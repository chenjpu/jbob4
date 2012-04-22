package com.bob.sql.xml.dialect;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Dialect {

	private static final Logger log = LoggerFactory.getLogger(Dialect.class);

	public static final String DEFAULT_BATCH_SIZE = "15";
	public static final String NO_BATCH = "0";

	/**
	 * Characters used for quoting SQL identifiers
	 */
	public static final String QUOTE = "`\"[";
	public static final String CLOSED_QUOTE = "`\"]";

	private final Properties properties = new Properties();

	private static final Map<Pattern, String> dialects = new HashMap<Pattern, String>();

	static {
		dialects.put(Pattern.compile("h2.*", Pattern.DOTALL & Pattern.CASE_INSENSITIVE), null);
		dialects.put(Pattern.compile("mysql.*", Pattern.DOTALL & Pattern.CASE_INSENSITIVE), null);
		dialects.put(Pattern.compile("postgresql.*", Pattern.DOTALL & Pattern.CASE_INSENSITIVE), null);
		dialects.put(Pattern.compile("db2.*", Pattern.DOTALL & Pattern.CASE_INSENSITIVE), null);
		dialects.put(Pattern.compile("oracle.*", Pattern.DOTALL & Pattern.CASE_INSENSITIVE), null);
		// SqlServer2005 --> 9.0 , SqlServer2008 --> 10.0
		dialects.put(Pattern.compile("microsoft sql server.*(9|10)[.].+", Pattern.DOTALL & Pattern.CASE_INSENSITIVE), null);
		dialects.put(Pattern.compile("microsoft sql server.*(8)[.].+", Pattern.DOTALL & Pattern.CASE_INSENSITIVE), null);
		dialects.put(Pattern.compile("hsql.*", Pattern.DOTALL & Pattern.CASE_INSENSITIVE), null);
		dialects.put(Pattern.compile("sqlite", Pattern.DOTALL & Pattern.CASE_INSENSITIVE), null);

	}

	// constructors and factory methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	protected Dialect() {
		log.info("Using dialect: " + this);
	}

	/**
	 * Get an instance of the dialect specified by the current <tt>System</tt> properties.
	 *
	 * @return The specified Dialect
	 * @throws HibernateException If no dialect was specified, or if it could not be instantiated.
	 */
	public static Dialect getDialect(DataSource dataSource) {

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			DatabaseMetaData meta = conn.getMetaData();
			String productName = meta.getDatabaseProductName();
			String version = meta.getDatabaseProductVersion();
			String dbName = String.format("%s::NUTZ_JDBC::%s", productName, version).toLowerCase();

			return instantiateDialect(dbName);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		} finally {
			if (null != conn)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
	}

	private static Dialect instantiateDialect(String dbName) {
		if (dbName == null) {
			throw new RuntimeException("The dialect was not set. Set the property dialect.");
		}

		for (Entry<Pattern, String> entry : dialects.entrySet()) {
			try {
				if (entry.getKey().matcher(dbName).find())
					return (Dialect) Class.forName(entry.getValue()).newInstance();
			} catch (ClassNotFoundException cnfe) {
				throw new RuntimeException("Dialect class not found: " + entry.getValue());
			} catch (Exception e) {
				throw new RuntimeException("Could not instantiate given dialect class: " + entry.getValue(), e);
			}
		}
		return null;

	}

	/**
	 * Retrieve a set of default Hibernate properties for this database.
	 *
	 * @return a set of Hibernate properties
	 */
	public final Properties getDefaultProperties() {
		return properties;
	}

	public String toString() {
		return getClass().getName();
	}

	// database type mapping support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// limit/offset support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Does this dialect support some form of limiting query results
	 * via a SQL clause?
	 *
	 * @return True if this dialect supports some form of LIMIT.
	 */
	public boolean supportsLimit() {
		return false;
	}

	/**
	 * Does this dialect's LIMIT support (if any) additionally
	 * support specifying an offset?
	 *
	 * @return True if the dialect supports an offset within the limit support.
	 */
	public boolean supportsLimitOffset() {
		return supportsLimit();
	}

	/**
	 * Does this dialect support bind variables (i.e., prepared statement
	 * parameters) for its limit/offset?
	 *
	 * @return True if bind variables can be used; false otherwise.
	 */
	public boolean supportsVariableLimit() {
		return supportsLimit();
	}

	/**
	 * ANSI SQL defines the LIMIT clause to be in the form LIMIT offset, limit.
	 * Does this dialect require us to bind the parameters in reverse order?
	 *
	 * @return true if the correct order is limit, offset
	 */
	public boolean bindLimitParametersInReverseOrder() {
		return false;
	}

	/**
	 * Does the <tt>LIMIT</tt> clause come at the start of the
	 * <tt>SELECT</tt> statement, rather than at the end?
	 *
	 * @return true if limit parameters should come before other parameters
	 */
	public boolean bindLimitParametersFirst() {
		return false;
	}

	/**
	 * Does the <tt>LIMIT</tt> clause take a "maximum" row number instead
	 * of a total number of returned rows?
	 * <p/>
	 * This is easiest understood via an example.  Consider you have a table
	 * with 20 rows, but you only want to retrieve rows number 11 through 20.
	 * Generally, a limit with offset would say that the offset = 11 and the
	 * limit = 10 (we only want 10 rows at a time); this is specifying the
	 * total number of returned rows.  Some dialects require that we instead
	 * specify offset = 11 and limit = 20, where 20 is the "last" row we want
	 * relative to offset (i.e. total number of rows = 20 - 11 = 9)
	 * <p/>
	 * So essentially, is limit relative from offset?  Or is limit absolute?
	 *
	 * @return True if limit is relative from offset; false otherwise.
	 */
	public boolean useMaxForLimit() {
		return false;
	}

	/**
	 * Generally, if there is no limit applied to a Hibernate query we do not apply any limits
	 * to the SQL query.  This option forces that the limit be written to the SQL query.
	 *
	 * @return True to force limit into SQL query even if none specified in Hibernate query; false otherwise.
	 */
	public boolean forceLimitUsage() {
		return false;
	}

	/**
	 * Given a limit and an offset, apply the limit clause to the query.
	 *
	 * @param query The query to which to apply the limit.
	 * @param offset The offset of the limit
	 * @param limit The limit of the limit ;)
	 * @return The modified query statement with the limit applied.
	 */
	public String getLimitString(String query, int offset, int limit) {
		return getLimitString(query, (offset > 0 || forceLimitUsage()));
	}

	/**
	 * Apply s limit clause to the query.
	 * <p/>
	 * Typically dialects utilize {@link #supportsVariableLimit() variable}
	 * limit clauses when they support limits.  Thus, when building the
	 * select command we do not actually need to know the limit or the offest
	 * since we will just be using placeholders.
	 * <p/>
	 * Here we do still pass along whether or not an offset was specified
	 * so that dialects not supporting offsets can generate proper exceptions.
	 * In general, dialects will override one or the other of this method and
	 * {@link #getLimitString(String, int, int)}.
	 *
	 * @param query The query to which to apply the limit.
	 * @param hasOffset Is the query requesting an offset?
	 * @return the modified SQL
	 */
	protected String getLimitString(String query, boolean hasOffset) {
		throw new UnsupportedOperationException("Paged queries not supported by " + getClass().getName());
	}

	/**
	 * Hibernate APIs explicitly state that setFirstResult() should be a zero-based offset. Here we allow the
	 * Dialect a chance to convert that value based on what the underlying db or driver will expect.
	 * <p/>
	 * NOTE: what gets passed into {@link #getLimitString(String,int,int)} is the zero-based offset.  Dialects which
	 * do not {@link #supportsVariableLimit} should take care to perform any needed {@link #convertToFirstRowValue}
	 * calls prior to injecting the limit values into the SQL string.
	 *
	 * @param zeroBasedFirstResult The user-supplied, zero-based first row offset.
	 *
	 * @return The corresponding db/dialect specific offset.
	 *
	 * @see org.hibernate.Query#setFirstResult
	 * @see org.hibernate.Criteria#setFirstResult
	 */
	public int convertToFirstRowValue(int zeroBasedFirstResult) {
		return zeroBasedFirstResult;
	}

	// lock acquisition support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
