package com.bob.iform.fvm.impl.runtime;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.number.NumberFormatter;

import com.bob.iform.engine.FormEngine;
import com.bob.iform.fvm.FvmContext;

public class ContextImpl implements FvmContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected final static ExpressionParser parser = new SpelExpressionParser();

	protected final static DateFormatter dateFormatter = new DateFormatter();
	protected final static NumberFormatter numberFormatter = new NumberFormatter();

	private final Object user;

	private final List<String> userRoles;

	private final Map<String, Object> variables = new HashMap<String, Object>();

	private FormEngine formEngine;

	public ContextImpl(Object user, List<String> userRoles) {
		super();
		this.user = user;
		this.userRoles = userRoles;
	}

	public Object getUser() {
		return user;
	}

	public Serializable getUserId() {
		return null;
	}

	public List<String> getUserRoles() {
		return userRoles;
	}

	public Map<String, Object> getVariables() {
		return variables;
	}

	@SuppressWarnings("unchecked")
	public <T> T getVariable(String key) {
		return (T) variables.get(key);
	}

	public Object evaluate(String expression) {
		Expression exp = parser.parseExpression(expression);

		return exp.getValue(user);
	}

	public Object evaluate(String expression, Class<?> expectedResultType) {
		Expression exp = parser.parseExpression(expression);

		return exp.getValue(user, expectedResultType);
	}

	public Object evaluate(String expression, Map<String, Object> context) {
		StandardEvaluationContext evaluationContext = new StandardEvaluationContext(user);
		evaluationContext.setVariables(context);
		Expression exp = parser.parseExpression(expression);
		return exp.getValue(evaluationContext);
	}

	public Object evaluate(String expression, Map<String, Object> context, Class<?> expectedResultType) {
		StandardEvaluationContext evaluationContext = new StandardEvaluationContext(user);
		evaluationContext.setVariables(context);
		Expression exp = parser.parseExpression(expression);
		return exp.getValue(evaluationContext, expectedResultType);
	}

	public String format(Object ob, String format) {
		if (null == ob) {
			return null;
		}
		if (ob instanceof Date) {
			dateFormatter.setPattern(format);
			return dateFormatter.print((Date) ob, Locale.getDefault());
		} else if (ob instanceof Number) {
			numberFormatter.setPattern(format);
			return numberFormatter.print((Number) ob, Locale.getDefault());
		} else {
			return ob.toString();
		}
	}

	public FormEngine getFormEngine() {
		return formEngine;
	}

	public void setFormEngine(FormEngine formEngine) {
		this.formEngine = formEngine;
	}
}
