package com.bob.sql.vm;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

/**
 * This class is a simple demonstration of how the Velocity Template Engine
 * can be used in a standalone application.
 *
 * @author <a href="mailto:jvanzyl@apache.org">Jason van Zyl</a>
 * @author <a href="mailto:geirm@optonline.net">Geir Magnusson Jr.</a>
 * @version $Id: Example.java 463298 2006-10-12 16:10:32Z henning $
 */

public class Test {

	String templateFile = "example.vm";

	public Test() {
		try {
			/*
			 * setup
			 */

			Velocity.init("D:\\eclipse\\workspace\\AaaS\\VMSQL\\src\\velocity.properties");

			/*
			 *  Make a context object and populate with the data.  This
			 *  is where the Velocity engine gets the data to resolve the
			 *  references (ex. $list) in the template
			 */
			
			List<Object> s = new ArrayList<Object>();

			VelocityContext context = new VelocityContext();
			context.put("condition", true);
			context.put("test1", 1);
			context.put("test2", "test2");
			context.put("test3", "test3");
			context.put("test4", "test4");
			context.put("sql.values", s);

			/*
			 *  get the Template object.  This is the parsed version of your
			 *  template input file.  Note that getTemplate() can throw
			 *   ResourceNotFoundException : if it doesn't find the template
			 *   ParseErrorException : if there is something wrong with the VTL
			 *   Exception : if something else goes wrong (this is generally
			 *        indicative of as serious problem...)
			 */

			Template template = null;

			try {
				template = Velocity.getTemplate(templateFile);
			} catch (ResourceNotFoundException rnfe) {
				System.out.println("Example : error : cannot find template " + templateFile);
			} catch (ParseErrorException pee) {
				System.out.println("Example : Syntax error in template " + templateFile + ":" + pee);
			}

			/*
			 *  Now have the template engine process your template using the
			 *  data placed into the context.  Think of it as a  'merge'
			 *  of the template and the data to produce the output stream.
			 */

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

			if (template != null)
				template.merge(context, writer);

			/*
			 *  flush and cleanup
			 */
			System.out.println(s);
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new Test();
	}
}
