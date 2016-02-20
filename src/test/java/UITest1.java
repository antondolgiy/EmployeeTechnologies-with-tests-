/**
 * Created by Anton on 20.02.2016.
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class UITest1 {

    @Test
    public void UserCanViewEmployeesWithSpecifiedSkill() {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/getalltech");
        driver.findElement(By.name("TechIDtoFind")).sendKeys("202");
        driver.findElement(By.name("SelectTechID")).click();

    }

}
