package global.coda.hospitalmanagement.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vijay
 *
 * Class that tests the working of gretty by simply replying with a hello
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

	/**
	 *
	 * @return String
	 */
	@RequestMapping(value = "say")
	public final String sayHello() {
		return "Hello";
	}
}
