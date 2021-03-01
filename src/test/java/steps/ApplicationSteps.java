package steps;

import cucumber.api.java.en.And;
import java.util.List;

public class ApplicationSteps{

	@And("^I Login inside application$")
	public void login(List<String> data) {
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		
	}
	
}
