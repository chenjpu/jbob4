package com.bob.sql.vm;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;

/**
 * Velocity
 * @author Winter Lau
 * @date 2009-3-16 ??04:40:19
 */
public class VarDirective extends Directive {
	
	
	@Override
	public String getName() {
		return "var";
	}

	@Override
	public int getType() {
		return LINE;
	} //??????????
	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException,
			ParseErrorException, MethodInvocationException {
		SimpleNode sn_value = (SimpleNode) node.jjtGetChild(0);
		Object value = sn_value.value(context);
		@SuppressWarnings("unchecked")
		List<Object> values = (List<Object>) context.get("sql.values");
		values.add(value);
		writer.write("?");
		return true;
	}
}