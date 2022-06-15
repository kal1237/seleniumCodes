package seleniumPractice;

import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeMultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C://Program Files//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.manage().window().maximize();
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		System.out.println(driver.getCurrentUrl());
		System.out.println("parent window is"+driver.getTitle());
		driver.findElement(By.linkText("Privacy")).click();
		
		/*Set<String> s1=driver.getWindowHandles();
		java.util.Iterator<String> itr= s1.iterator();
		while(itr.hasNext()) {
			String childWindow=itr.next();
			if(!parent.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
				System.out.println("childwindows is :"+driver.switchTo().window(childWindow).getTitle());
				
				
			}
		}*/
		
		driver.switchTo().window(parent);
		System.out.println("parent window now");
		
		driver.findElement(By.linkText("Terms")).click();
		Set<String> s2=driver.getWindowHandles();
		int number=driver.getWindowHandles().size();
		System.out.println("number of windows open"+number);
		java.util.Iterator<String> itr1=s2.iterator();
		while(itr1.hasNext()) {
			String childs=itr1.next();
			// System.out.println("The titles are: "+driver.switchTo().window(childs).getTitle());
			
			//if(!parent.equals(childs))
			
				//driver.switchTo().window(childs);
				
				//System.out.println("child  now is:"+driver.switchTo().window(childs).getTitle());
				if(driver.switchTo().window(childs).getTitle().equalsIgnoreCase("Privacy Policy – Privacy & Terms – Google"))
				{
					driver.switchTo().window(childs);
					System.out.println("privacy window is open");
					String a=driver.switchTo().window(childs).getTitle();
					System.out.println(a);
					WebElement pic=driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div[2]/div[3]/c-wiz/div[1]/div/div[2]/div/p[3]/a"));
					System.out.println(pic.getText());
					break;
				
				}
				
				
				/*else
				{
					driver.switchTo().window(childs);
					System.out.println("terms window is open");
					String b=driver.switchTo().window(childs).getTitle();
				}*/
			}
		}
		
		//driver.switchTo().window(parent);
		//System.out.println("parent window is opened");
		
		
		
		/*System.out.println(s1);
		System.out.println(s1.toString());
		String lastwindow="";
		for(String handle:s1)
		{
			System.out.println("switch to window"+handle);
			System.out.println("current url is:"+driver.getTitle());
			driver.switchTo().window(handle);
			System.out.println("current url is:"+driver.getTitle());
			//driver.getTitle().contains("Privacy Policy – Privacy & Terms – Google");
			lastwindow=handle;
			System.out.println(lastwindow);
		}*/
		
		
		//driver.quit();

	

}
