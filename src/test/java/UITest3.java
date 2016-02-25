/**
 * Created by Anton on 21.02.2016.
 */
import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.*;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import com.codeborne.selenide.Condition.*;

public class UITest3 {
    @Test
    public void UserCanEditListofEmployeesSkills(){
        /*
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/getallusers");
        driver.findElement(By.id("SkillByID1002")).click();
        int a = driver.findElements(By.name("tech-id")).size();
        driver.findElement(By.id("deltech222")).click();
        int b = driver.findElements(By.name("tech-id")).size();
        assertEquals(1, (a - b));

        driver.findElement(By.id("addable222")).submit();


        int c = driver.findElements(By.name("tech-id")).size();
        assertEquals(1,(c-b));
        */
        open("http://localhost:8080/getallusers");
        $(By.id("SkillByID1002")).click();
        int a = $$(By.name("tech-id")).size();

        $(By.id("deltech222")).click();
        int b = $$(By.name("tech-id")).size();
        assertEquals(1, a-b);

        $(By.name("tech2add")).selectOption("Java");
        $(By.name("addtech")).click();
        int c = $$(By.name("tech-id")).size();
        assertEquals(1,(c-b));

        int d =$$(By.tagName("tr")).size();
        assertEquals(5, d);

        $(By.name("deltech")).shouldHave(Condition.type("submit"));







    }
}
