import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AutomationPractice {
    public WebDriver driver;

    @BeforeMethod
    public void initialisation() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void Run() {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("srinideb22@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        WebElement Gender = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        Gender.click();
        driver.findElement(By.name("customer_firstname")).sendKeys("4566778");
        driver.findElement(By.name("customer_lastname")).sendKeys("543678");
        driver.findElement(By.id("passwd")).sendKeys("FGY");
        driver.findElement(By.id("address1")).sendKeys("3214590");
        driver.findElement(By.id("postcode")).sendKeys("asdrtyu");
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("ertyuifrhjuy");
        driver.findElement(By.id("submitAccount")).click();
        driver.findElement(By.xpath("//p[contains(text(),'There are 7 errors')]")).getText();

        driver.findElement(By.name("customer_firstname")).clear();
        driver.findElement(By.name("customer_lastname")).clear();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.cssSelector("#phone_mobile")).clear();
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("submitAccount")).click();
        driver.findElement(By.xpath("//p[contains(text(),'There are 8 errors')]")).getText();
    }

    @AfterMethod
    public void cleanUp() {
        driver.close();
        driver.quit();
    }

}




