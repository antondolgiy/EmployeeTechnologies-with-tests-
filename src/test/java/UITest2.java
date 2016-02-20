/**
 * Created by Anton on 20.02.2016.
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static com.codeborne.selenide.Selenide.sleep;
public class UITest2 {
    @Test
    public void UserCanAddDeleteSkills() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/getalltech");
        driver.findElement(By.name("redirect2addtech")).click();
        driver.findElement(By.name("techID")).sendKeys("555");
        driver.findElement(By.name("techName")).sendKeys("high-5-ing");
        driver.findElement(By.name("addTech")).click();
        sleep(2000);
        driver.findElement(By.name("DelTech555")).click();


    }
}
