/**
 * 
 */
package tdd.test.com.com.hssa.code.test;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author USER
 *
 */
public class JavaCodeVulnerabilities {
/*	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ScriptException {
		  String input = req.getParameter("input");

		  ScriptEngineManager manager = new ScriptEngineManager();
		  ScriptEngine engine = manager.getEngineByName("JavaScript");
		  engine.eval(input); // Noncompliant
		}*/
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ScriptException {
		  String input = req.getParameter("input");

		  // Match the input against a whitelist
		String whiteList="^[a-z0-9_]{3,16}$";
		 // This regular expression allows only lowercase letters, numbers and the underscore character. The username is also restricted to a length of 3 and 16 characters.
		  if (!whiteList.contains(input))
		    throw new IOException();

		  ScriptEngineManager manager = new ScriptEngineManager();
		  ScriptEngine engine = manager.getEngineByName("JavaScript");
		  engine.eval(input);
		}
}
