/**
 * Created by Anton on 20.02.2016.
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.*;

public class UITest2 {
    @Test
    public void UserCanAddDeleteSkills() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/getalltech");
        int a= driver.findElements(By.name("us1")).size();
        driver.findElement(By.name("redirect2addtech")).click();
        driver.findElement(By.name("techID")).sendKeys("555");
        driver.findElement(By.name("techName")).sendKeys("high-5-ing");
        driver.findElement(By.name("addTech")).click();
        int b= driver.findElements(By.name("us1")).size();
        assertEquals(1,(b-a));
       
        driver.findElement(By.name("DelTech555")).click();
        int c= driver.findElements(By.name("us1")).size();
        assertEquals(0,(c-a));


    }
}
