package steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GenericSteps {



	
	@After
	public void after() {
		System.out.println("***Aft***");	
	//	con.quit();
	}
	
	
	@Given("^I open (.*)$")
	public void openBrowser(String browserName) {
	}
	
	@And("^I go to (.*)$")
	public void navigate(String url) {
	}

	@And("^I type (.*) in (.*) field$")
	public void type(String data,String locatorKey) {
	}
	@And("^I clear (.*)$")
	public void clear(String locatorKey) {

	}
	
	@And("^I click on (.*)$")
	public void click(String locatorKey) {

	}
	
	@And("^I click (.*) and wait for (.*)$")
	public void clickAndWait(String src,String target) {

	}
	@And("I select (.*) from (.*)")
	public void select(String data,String locatorKey) {
	}

	@And("^I wait for page to load$")
	public void waitForPageToLoad() {
	}
	
	@When("^I accept alert$")
	public void iAcceptAlert() {
	}
	
}
