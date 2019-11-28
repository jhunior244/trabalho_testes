
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAutomatizado {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:4200/consultaJogador");

        WebElement filtro = driver.findElement(By.name("filtro"));
        Thread.sleep(3000);
        filtro.click();
        WebElement adicionaJogador = driver.findElement(By.name("adicionaJogador"));
        Thread.sleep(3000);
        adicionaJogador.click();

        driver.findElement(By.name("nomeJogador"))
                .sendKeys("Julimar dos Santos");
        Thread.sleep(3000);
        driver.findElement(By.name("numeroJogador")).sendKeys("28");
        Thread.sleep(3000);
        driver.findElement(By.name("salarioJogador")).sendKeys("12000");
        Thread.sleep(3000);
        WebElement posicaoJogador = driver.findElement(By.name("posicaoJogador"));
        posicaoJogador.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//span[text()='Goleiro']")));

        driver.findElement(By.xpath("//span[text()='Goleiro']")).click();
        Thread.sleep(3000);

        WebElement botaoCadastrar = driver.findElement(By.name("submit"));
        botaoCadastrar.click();

        driver.get("http://localhost:4200/consultaJogador");

        Thread.sleep(3000);

        filtro = driver.findElement(By.name("filtro"));
        filtro.click();
        Thread.sleep(3000);

        WebElement nome = driver.findElement(By.name("nomeJogador"));
        nome.sendKeys("Julimar");
        Thread.sleep(3000);

        WebElement buscaJogador = driver.findElement(By.name("buscaJogador"));
        buscaJogador.click();


    }
}


