package forms.PracticeForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class StudentRegistrationForm {
    WebDriver driver;
    @Test
    void validateRegistrationForm(){
        driver.findElement(By.id("firstName")).sendKeys("Rishika Reddy");
        driver.findElement(By.id("lastName")).sendKeys("Madi");
        driver.findElement(By.id("userEmail")).sendKeys("rishikareddymadi@gmail.com");
        driver.findElement(By.cssSelector(".custom-radio:nth-child(1) > .custom-control-label")).click();
        driver.findElement(By.id("userNumber")).sendKeys("9542222024");
        driver.findElement(By.id("dateOfBirthInput")).click();
        new Select(driver.findElement(By.className("react-datepicker__month-select"))).selectByVisibleText("April");
        new Select(driver.findElement(By.className("react-datepicker__year-select"))).selectByVisibleText("2019");
        driver.findElement(By.cssSelector(".react-datepicker__day--017")).click();
        driver.findElement(By.id("subjectsInput")).sendKeys("EVS");
        driver.findElement(By.cssSelector(".custom-checkbox:nth-child(3) > .custom-control-label")).click();
    }
    @BeforeTest
    void openurl(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }
    @AfterTest
    void closeBrowser()  {
        driver.close();
    }

}
