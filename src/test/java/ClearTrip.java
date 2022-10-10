import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ClearTrip {
    public WebDriver driver;

    @BeforeMethod
    public void ClearTrip() {

        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.cleartrip.com/");
    }

    @Test
    public void Test() {
        //driver.findElement(By.cssSelector("svg[class='c-pointer c-neutral-900']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Where from?']")).click();
        driver.findElement((By.xpath("//p[contains (text(),'New Delhi, IN - Indira Gandhi Airport (DEL)')]"))).click();

        driver.findElement(By.className("icon-2")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//p[contains(text(),'Mumbai, IN - Chatrapati Shivaji Airport (BOM)')]")).click();

        /*List<WebElement> dropdown = driver.findElements(By.xpath("//select[contains(@class,'default-select bc')]"));
        Select AdultDropdown = new Select(dropdown.get(0));
        AdultDropdown.selectByValue("3");

        Select ChildDropdown = new Select(dropdown.get(1));
        ChildDropdown.selectByValue("2");

        Select InfantDropdown = new Select(dropdown.get(2));
        InfantDropdown.selectByValue("1");*/

        driver.findElement(By.xpath("//button[contains(text(),'Search flights')]")).click();
    }
    @AfterMethod
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}
