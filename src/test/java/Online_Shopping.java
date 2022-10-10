import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Online_Shopping {
    public WebDriver driver;

    @BeforeMethod
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void shopping() {
        driver.findElement(By.linkText("Women")).click();
        driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]")).click();

        WebElement Element = driver.findElement(By.className("product_img_link"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", Element);

        Actions Hover = new Actions(driver);
        Hover.moveToElement(Element).build().perform();

        driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
        WebElement Dropdown = driver.findElement(By.id("group_1"));
        Select dropdown = new Select(Dropdown);
        dropdown.selectByIndex(2);

        driver.findElement(By.xpath("//a[@class='color_pick']")).isSelected();
        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[contains(text(), 'Proceed to checkout')]")).click();
        driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
        driver.findElement(By.id("total_price")).getText();
    }

    @AfterMethod
    public void cleanUp() {
        driver.close();
        driver.quit();
    }

}
