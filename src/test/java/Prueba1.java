import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;







public class Prueba1 {


    WebDriver driver = new ChromeDriver();

    @Test
    void deberiaIniciarSesionCuandoEnvioCredencialesValidas()  {

        //System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/.src/main/resources/driver/chromedriver.exe");
        driver.get("https://www.saucedemo.com/");



        WebElement usuario = driver.findElement(By.xpath("//input[@id='user-name']"));
        usuario.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret-sauce");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        WebElement tituloProducts = driver.findElement(By.xpath("//span[contains(.,'Products')]"));


        Assertions.assertEquals(tituloProducts.getText(),"PRODUCTS");

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
