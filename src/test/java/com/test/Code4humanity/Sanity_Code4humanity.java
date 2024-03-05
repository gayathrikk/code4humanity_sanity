package com.test.Code4humanity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sanity_Code4humanity {
	
	  private RemoteWebDriver driver;
		
			@BeforeTest
			
			public void setup() throws MalformedURLException 
			{
				
				  DesiredCapabilities dc = DesiredCapabilities.chrome();
			        URL url = new URL("http://172.20.23.7:5555/wd/hub");
			        driver = new RemoteWebDriver(url, dc);
			
			       
			}
			//@Parameters("URL")
			@Test(priority=1)
			//public void login(@Optional("defaultURL") String URL) throws InterruptedException
			public void Launch()throws InterruptedException
			{
				//driver.get(URL);
				driver.get("http://code4humanity.humanbrain.in/annotation/analytics/home");
				driver.manage().window().maximize();
			}
			@Test(priority=2)
			public void Home()
			{
				String HomeURL="http://code4humanity.humanbrain.in/annotation/analytics/home";
				String currentURL = driver.getCurrentUrl();
		        System.out.println("Home URL: " + currentURL);
		        Assert.assertEquals(currentURL, HomeURL, "URLs do not match!");
			}
			
			@Test(priority=3)
			public void Login() throws InterruptedException
			{
				WebDriverWait wait = new WebDriverWait(driver, 10);
				 try {
		    		    WebElement Team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@Title='Team']")));
		    		    Team.click();
		    		    System.out.println("Team clicked successfully.");
		    		    Thread.sleep(2000);
		    		} catch (Exception e) {
		    		    System.out.println("Team not clicked: " + e.getMessage());
		    		}
				 String parentWindow = driver.getWindowHandle();
				 WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
			        if (loginButton != null) {
			            loginButton.click();
			            System.out.println("Login button clicked successfully.");
			        } else {
			            System.out.println("Login button is not clicked.");
			        }
				  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				  Set<String> allWindows = driver.getWindowHandles();
			        for (String window : allWindows) {
			            if (!window.equals(parentWindow)) {
			                driver.switchTo().window(window);
			                break;
			            }
			        }
			        
			        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
			        if (emailInput != null && emailInput.isDisplayed()) {
			            emailInput.sendKeys("teamsoftware457@gmail.com");
			            System.out.println("Email was entered successfully.");
			        } else {
			           System.out.println("Email was not entered.");
			        }
			       
			
			        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
			        if (nextButton1 != null) {
			            nextButton1.click();
			            System.out.println("Next button 1 is clicked.");
			        } else {
			            System.out.println("Next button 1 is not clicked.");
			        }
			       
			        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
			        passwordInput.sendKeys("Health#123");
			        if (passwordInput.getAttribute("value").equals("Health#123")) {
			            System.out.println("Password was entered successfully.");
			        } else {
			            System.out.println("Password was not entered.");
			        }
			       
			        
			        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
			        if (nextButton2 != null) {
			            nextButton2.click();
			            System.out.println("Next button 2 is clicked.");
			        } else {
			            System.out.println("Next button 2 is not clicked.");
			        }
			        
			
			        driver.switchTo().window(parentWindow);
			        System.out.println("Login successfully");
			        
			        System.out.println("************************Login validation done***********************");
			        Thread.sleep(5000);
				 
			        
			}
			
			@Test(priority=4)
			public void Team() throws InterruptedException
			{

				   WebDriverWait wait = new WebDriverWait(driver, 10);
				    try {
				        WebElement Team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Team']")));
				        Team.click();
				        System.out.println("Team clicked successfully.");
				        Thread.sleep(5000);
				        
				        // Get the current URL after clicking on the "Team" link
				        String currentURL = driver.getCurrentUrl();
				        System.out.println("Current URL after clicking on Team: " + currentURL);
				        
				        // Define the expected Team URL
				        String expectedTeamURL = "http://code4humanity.humanbrain.in/annotation/analytics/team";
				        
				        // Assert that the current URL matches the expected Team URL
				        Assert.assertEquals(currentURL, expectedTeamURL, "Team URL is not correct");
				    } catch (Exception e) {
				        System.out.println("Team not clicked: " + e.getMessage());
				    }
			}
			
			@Test(priority=5)
			public void Dataset() throws InterruptedException
			{

				 WebDriverWait wait = new WebDriverWait(driver, 10);
				    try {
				        WebElement Datasets = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Datasets']")));
				        Datasets.click();
				        System.out.println("Datasets clicked successfully.");
				        Thread.sleep(5000);
				        
				        // Get the current URL after clicking on the "Competitions" link
				        String currentURL = driver.getCurrentUrl();
				        System.out.println("Current URL after clicking on Datasets: " + currentURL);
				        
                        String expecteddatasetsURL = "http://code4humanity.humanbrain.in/annotation/analytics/datasets";
				        
				        // Assert that the current URL matches the expected Team URL
				        Assert.assertEquals(currentURL, expecteddatasetsURL, "Dataset URL is not correct");
				    } catch (Exception e) {
				        System.out.println("Datasets not clicked: " + e.getMessage());
				    }
			}
			
			@Test(priority=6)
			public void Models() throws InterruptedException
			{

				 WebDriverWait wait = new WebDriverWait(driver, 10);
				    try {
				        WebElement Models = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Models']")));
				        Models.click();
				        System.out.println("Models clicked successfully.");
				        Thread.sleep(5000);
				        
				        // Get the current URL after clicking on the "Competitions" link
				        String currentURL = driver.getCurrentUrl();
                        String expectedmodelsURL = "http://code4humanity.humanbrain.in/annotation/analytics/models";
				        
				        // Assert that the current URL matches the expected Team URL
				        Assert.assertEquals(currentURL, expectedmodelsURL, "Models URL is not correct");
				        System.out.println("Current URL after clicking on Models: " + currentURL);
				    } catch (Exception e) {
				        System.out.println("Models not clicked: " + e.getMessage());
				    }
			}
			
			@Test(priority=7)
			public void Code() throws InterruptedException
			{

				 WebDriverWait wait = new WebDriverWait(driver, 10);
				    try {
				        WebElement Code = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Code']")));
				        Code.click();
				        System.out.println("Code clicked successfully.");
				        Thread.sleep(5000);
				        
				        // Get the current URL after clicking on the "Competitions" link
				        String currentURL = driver.getCurrentUrl();
                        String expectedcodeURL = "http://code4humanity.humanbrain.in/annotation/analytics/code";
				        
				        // Assert that the current URL matches the expected Team URL
				        Assert.assertEquals(currentURL, expectedcodeURL, "Code URL is not correct");
				        
				        System.out.println("Current URL after clicking on Code: " + currentURL);
				    } catch (Exception e) {
				        System.out.println("Code not clicked: " + e.getMessage());
				    }
			}
			
			@Test(priority=8)
			public void Jobs() throws InterruptedException
			{

				 WebDriverWait wait = new WebDriverWait(driver, 10);
				    try {
				        WebElement Jobs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Jobs']")));
				        Jobs.click();
				        System.out.println("Jobs clicked successfully.");
				        Thread.sleep(5000);
				        
				        // Get the current URL after clicking on the "Competitions" link
				        String currentURL = driver.getCurrentUrl();
                        String expectedjobURL = "http://code4humanity.humanbrain.in/annotation/analytics/jobs";
				        
				        // Assert that the current URL matches the expected Team URL
				        Assert.assertEquals(currentURL, expectedjobURL, "Code URL is not correct");
				        System.out.println("Current URL after clicking on Jobs: " + currentURL);
				    } catch (Exception e) {
				        System.out.println("Jobs not clicked: " + e.getMessage());
				    }
			}
			
			@Test(priority=9)
			public void competition() throws InterruptedException
			{

				 WebDriverWait wait = new WebDriverWait(driver, 10);
				    try {
				        WebElement Competition = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Competitions']")));
				        Competition.click();
				        System.out.println("Competition clicked successfully.");
				        Thread.sleep(5000);
				        
				        // Get the current URL after clicking on the "Competitions" link
				        String currentURL = driver.getCurrentUrl();
                        String expectedcompetitionsURL = "http://code4humanity.humanbrain.in/annotation/analytics/competitions";
				        
				        // Assert that the current URL matches the expected Team URL
				        Assert.assertEquals(currentURL, expectedcompetitionsURL, "Code URL is not correct");
				        
				        System.out.println("Current URL after clicking on Competitions: " + currentURL);
				    } catch (Exception e) {
				        System.out.println("Competition not clicked: " + e.getMessage());
				    }
			}
			
			@AfterTest
			public void close()
			{
				driver.quit();
			}

}
