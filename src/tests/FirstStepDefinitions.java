package tests;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testrun.ApplicationConstants;

public class FirstStepDefinitions {
	private WebDriver driver ;
	
	@Given ("a user is on initial webpage")
	public void openwebpage() throws Throwable{
		
		System.setProperty(ApplicationConstants.CHROME_DRIVER_KEY , ApplicationConstants.CHROME_DRIVER_VALUE);
		
		if(null != driver){
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://sit3portal.ahcthost.com");
		WebElement seeplanslink = driver.findElement(By.linkText("Compare Plans"));
		seeplanslink.click();
	//	Thread.sleep(2000);
		WebElement countylink = driver.findElement(By.id("county"));
		countylink.sendKeys("Hartford");  
		
		
		WebElement agelink1 = driver.findElement(By.id("preAge_0"));
		agelink1.sendKeys("24");
		
		
		WebElement target1 = driver.findElement(By.id("pregnancy_0NO"));
		target1.click();
		
		
		WebElement agelink2 = driver.findElement(By.id("preAge_1"));
		agelink2.sendKeys("23");
		
		
		Select relationship = new Select(driver.findElement(By.id("relationship_1")));
		relationship.selectByVisibleText("Dependent");
		
		
		WebElement target2 = driver.findElement(By.id("pregnancy_1NO"));
		target2.click();
		WebElement income = driver.findElement(By.name("income"));
		income.sendKeys("12000");
		
		
		Select incometype = new Select(driver.findElement(By.id("incomeType")));
		incometype.selectByVisibleText("Monthly");
		
		
		WebElement next1 = driver.findElement(By.id("next-button"));
		next1.click();
		
		WebElement image = driver.findElement(By.xpath("//img[@src='img/Skip_to_See_Plans.png']"));
		image.click();
		
		
	}
	
	@When("user clicks see 2019 plans")
	public void user_clicks_see_plans() throws Throwable{
		
		System.out.println(1);
	}

	@When("^user is taken to basic info$")
	public void user_is_taken_to_basic_info() {
		System.out.println(1);
	   
	}

	@Then("^skip all to see plans$")
	public void skip_all_to_see_plans(){
	    
		System.out.println(1);
	}
	

}
