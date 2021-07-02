package pruebautest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Utest {

    private static WebDriver driver;

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);
        driver.get("https://www.utest.com/");
    }

    @Test
    public void test() {
        //Tiempo de espera

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */

        //Espera implicita
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Clic en el boton Join Today
        driver.findElement(By.xpath("//a[@class='unauthenticated-nav-bar__sign-up']")).click();

        //Tiempo de espera
       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */

        //Campo donde se ingresa el nombre
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Diego Armando");
        //WebElement nombre = driver.findElement(By.xpath("//input[@id='firstName']"));
        //nombre.sendKeys("Diego Armnando");
        //Campo donde se ingresa el apellido
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Martinez Beleño");
        //campo para el correo electronico
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("di_ma_be@hotmail.com");
        //Campo fecha mes de nacimiento
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='birthMonth']"));
        Select selectObject1 = new Select(selectElement);

        //Selecciona una <option> basandose en el texto que muestra
        selectObject1.selectByVisibleText("February");

        //Campo fecha dia de nacimiento
        WebElement selectElementDay= driver.findElement(By.xpath("//select[@name='birthDay']"));
        Select selectObject2 = new Select(selectElementDay);
        selectObject2.selectByVisibleText("23");

        //Campo fecha año de nacimiento
        WebElement selectElementanio = driver.findElement(By.xpath("//select[@id='birthYear']"));
        Select selectObject3 = new Select(selectElementanio);
        selectObject3.selectByVisibleText("1989");

        //Scroll
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,550)");

        WebElement campoIdioma = driver.findElement(By.xpath("//input[@type='search']"));
        campoIdioma.click();

        WebElement SeleccionIdioma = driver.findElement(By.xpath("//div[contains(text(),'Spanish')]"));
        SeleccionIdioma.click();

        WebElement boton1 = driver.findElement(By.xpath("//a[@aria-label='Next step - define your location']"));
        boton1.click();



        //Espera Explicita
       /* WebDriverWait ewait = new WebDriverWait(driver, 20);
        ewait.until(ExpectedConditions.elementToBeSelected(By.id("city")));*/

        //Campo de la ciudad
        WebElement ciudad = driver.findElement(By.id("city"));
        ciudad.click();
        //driver.findElement(By.id("city")).click();

        //Espera
        try {
            //Espera explicita
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //ciudad.clear();

       //ciudad.sendKeys("Santa Marta Magdalena, Colombia");

        //Campo codigo postal
        /* WebElement codPostal = driver.findElement(By.id("zip"));
        codPostal.sendKeys("470005"); */
        WebElement pais = driver.findElement(By.xpath("//input[@placeholder='Select a country']"));

        //Espera
        try {
            //Espera explicita
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


            WebElement boton2 = driver.findElement(By.xpath("//a[@aria-label='Next step - select your devices']"));
            boton2.click();



        //Marca del mobil
        WebElement MarcaCel = driver.findElement(By.xpath("//span[contains(text(),'Select Brand')]"));
        MarcaCel.click();
        WebElement InputMarcaCel = driver.findElement(By.xpath("//input[@placeholder='Select Brand']"));
        InputMarcaCel.sendKeys("Motorola");
        InputMarcaCel.sendKeys(Keys.ENTER);

        //Espera
        try {
            //Espera explicita
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Version del mobil
        WebElement VersionCel = driver.findElement(By.xpath("//span[@aria-label='Select a Model']"));
        VersionCel.click();
        WebElement InputVersionCel = driver.findElement(By.xpath("//input[@placeholder='Select a Model']"));
        InputVersionCel.sendKeys("Moto G9 Plus");
        InputVersionCel.sendKeys(Keys.ENTER);

        //Espera
        try {
            //Espera explicita
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Sistema operativo
        WebElement SoCel = driver.findElement(By.xpath("//span[@class='ui-select-placeholder text-muted']"));
        SoCel.click();
        WebElement InputSocel = driver.findElement(By.xpath("//div[contains(text(),'Android 10')]"));
        InputSocel.click();

        //Boton para pasar al siguiente paso
        WebElement boton3 = driver.findElement(By.xpath("//a[@aria-label='Next - final step']"));
        boton3.click();

        //Campo para la contraseña
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("IanJosue_19");

        //Campo para confirmar contraseña
        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys("IanJosue_19");

        //Terminos y condiciones
        WebElement Terminos = driver.findElement(By.id("termOfUse"));
        Terminos.click();

        //Politicas
        WebElement Politicas = driver.findElement(By.id("privacySetting"));
        Politicas.click();

        //boton para finalizar el formulario
        WebElement boton4 = driver.findElement(By.id("laddaBtn"));
        boton4.click();




    }

    @After
    public void after() {
        WebElement mensaje = driver.findElement(By.xpath("//h1"));
        mensaje.getText();

        assertEquals(mensaje,"Welcome to the world's largest community of freelance software testers!");

        //driver.quit();


    }

}
