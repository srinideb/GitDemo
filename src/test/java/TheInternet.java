import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TheInternet {

    public WebDriver driver;

    @BeforeMethod
    public void initialisation() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void Run() {
        driver.findElement(By.linkText("Multiple Windows")).click();
        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.cssSelector("body:nth-child(2) div.example > h3:nth-child(1)")).getText());
        driver.switchTo().window(parentId);
        driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText();
        driver.quit();

    }
}

