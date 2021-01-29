package info.kinhho.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TestControllers {
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Contact> get() {
		
		
		return Arrays.asList(new Contact("1", "active"), 
				new Contact("2", "active"), 
				new Contact("3", "inactive"), 
				new Contact("4", "active"), 
				new Contact("5", "inactive"), 
				new Contact("6", "active"), 
				new Contact("7", "inactive"),
				new Contact("8", "active"), 
				new Contact("9", "inactive"), 
				new Contact("10", "active"), 
				new Contact("11", "active"), 
				new Contact("12", "active"), 
				new Contact("13", "inactive"), 
				new Contact("14", "active"),
				new Contact("15", "active"), 
				new Contact("16", "inactive"), 
				new Contact("17", "active"), 
				new Contact("18", "active"), 
				new Contact("19", "inactive"), 
				new Contact("20", "active"), 
				new Contact("21", "inactive")
				);
	}
}

class Contact {

	private String id;
	private String active;
	
	public Contact(String id, String active) {
		super();
		this.id = id;
		this.active = active;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
}