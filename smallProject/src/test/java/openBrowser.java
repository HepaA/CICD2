import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class openBrowser {

    @Test
    public void OpenBrowser () throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        //or
        //driver.navigate().to("https://www.google.com/");
        //or
        //driver.navigate().refresh();
        //driver.navigate().back();
        //driver.navigate().forward();
        String LoginWindow = driver.getWindowHandle();
        String TitleLoginWindow = driver.getTitle();
        System.out.println(TitleLoginWindow);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        //or
        //driver.manage().window().fullscreen();
        //or
        //Dimension ResponsiveMode = new Dimension(414, 896);
        //driver.manage().window().setSize(ResponsiveMode);
        //String CurrentURL = driver.getCurrentUrl();
        //System.out.println(CurrentURL);
        //Thread.sleep(3000);
        //String Title = driver.getTitle();
        //System.out.println(Title);
        //Thread.sleep(3000);
        //String PageSource = driver.getPageSource();
        //System.out.println(PageSource);
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]")); //relative-xpath
        Thread.sleep(2000);
        username.click();
        Thread.sleep(2000);
        username.sendKeys("tomsmith");
        Thread.sleep(3000);
        WebElement Password = driver.findElement(By.xpath("//*[contains(@id,'password')]")); //xpath with contains
        Thread.sleep(3000);
        Password.click();
        Thread.sleep(3000);
        Password.sendKeys("SuperSecretPassword!");
        Thread.sleep(3000);
        WebElement GetText = driver.findElement(By.xpath("//*[text() = 'Elemental Selenium']")); //xpath with text
        Thread.sleep(3000);
        String PrintGetText = GetText.getText();
        Thread.sleep(3000);
        System.out.println(PrintGetText);
        Thread.sleep(3000);
        WebElement PageHeaderWithAllText = driver.findElement(By.xpath("//*[contains(text(),'Login Page')]")); //xpath with contains and text with all text
        //WebElement PageHeaderWithPartOfText = driver.findElement(By.xpath("//*[contains(text(),'Page')]")); //xpath with contains and text with partial text
        String PrintPageHeader = PageHeaderWithAllText.getText();
        System.out.println(PrintPageHeader);
        Thread.sleep(3000);
        //WebElement linkText = driver.findElement(By.linkText("href=\"http://elementalselenium.com/\""));
        WebElement linkText = driver.findElement(By.xpath("//html/body/div[3]/div/div/a")); //Absolute-xpath
        Thread.sleep(3000);
        linkText.click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String SecondWindow = driver.getWindowHandle();
        Set<String> AllWindows = driver.getWindowHandles();
        for (String Window: AllWindows){
            Thread.sleep(3000);
            if (Window.equalsIgnoreCase(LoginWindow)) {
                Thread.sleep(3000);
                driver.switchTo().window(SecondWindow);
                Thread.sleep(3000);
                String TitleSecondWindow = driver.getTitle();
                Thread.sleep(3000);
                    System.out.println(TitleSecondWindow);
            }
        }


        Thread.sleep(3000);
       // driver.close();





        //or
        //driver.quit();

    }
}
