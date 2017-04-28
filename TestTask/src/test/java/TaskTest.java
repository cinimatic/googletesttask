import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;


public class TaskTest {

    @Test
    public void googleSeleniumSearch ()
    {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.RETURN);
        String firstSearch = driver.findElement(By.xpath("(//*[@class='srg']//*[@class='r'])[1]/a")).getAttribute("href");

        assertTrue(firstSearch.contains("http://www.seleniumhq.org"));

        driver.findElement(By.xpath("//*[@class='q qs' and contains(text(),'Images')]")).click();
        driver.findElement(By.xpath("//*[@id='rg_s']/div/a")).click();

        assertTrue(driver.findElement(By.xpath("//*[@id='irc_cc']//a/img[@class='irc_mi']")).getAttribute("src").contains("www.seleniumhq.org"));

        driver.findElement(By.xpath("//*[@class='q qs' and contains(text(),'All')]")).click();

        assertTrue(firstSearch.equals(driver.findElement(By.xpath("(//*[@class='srg']//*[@class='r'])[1]/a")).getAttribute("href")));
        driver.quit();
    }
}
