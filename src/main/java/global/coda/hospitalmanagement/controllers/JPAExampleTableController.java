package global.coda.hospitalmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hospitalmanagement.delegates.JPAExampleTableDelegate;

@RestController
@RequestMapping("/jpaexample")
public class JPAExampleTableController {

	@Autowired
	private JPAExampleTableDelegate delegate;

	@GetMapping("/")
	public String createEntry() {
		delegate.createEntry();
		return "yes";
	}

}
