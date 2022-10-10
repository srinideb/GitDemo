import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClearTrip_1 {
    public WebDriver driver;

    @BeforeMethod
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cleartrip.com/");
    }

    @Test
    public void Test() {
        //driver.findElement(By.cssSelector("svg[class=' c-pointer c-neutral-900']")).click();
        driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])")).click();
        driver.findElement((By.xpath("//p[contains(text(),'New Delhi, IN - Indira Gandhi Airport (DEL)')]"))).click();

        driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[2]")).click();
        driver.findElement(By.xpath("//p[contains(text(),'Mumbai, IN - Chatrapati Shivaji Airport (BOM)')]")).click();

        driver.findElement(By.xpath("(//button[contains(@class,'flex flex-middle')])[3]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement Element = driver.findElement(By.xpath("(//div[contains(text(),'1')])[15]"));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Element.click();

        List<WebElement> dropdown = driver.findElements(By.xpath("//select[contains(@class,'default-select bc')]"));
        Select AdultDropdown = new Select(dropdown.get(0));
        AdultDropdown.selectByValue("3");

        Select ChildDropdown = new Select(dropdown.get(1));
        ChildDropdown.selectByValue("2");

        Select InfantDropdown = new Select(dropdown.get(2));
        InfantDropdown.selectByValue("1");

        driver.findElement(By.xpath("//button[contains(text(),'Search flights')]")).click();

    }

    @AfterMethod
    public void cleanUp() {
        driver.close();
        driver.quit();
    }


}
