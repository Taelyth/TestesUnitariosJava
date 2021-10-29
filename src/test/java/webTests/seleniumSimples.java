package webTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import static org.testng.Assert.assertEquals;

import utils.Evidencias;

public class seleniumSimples {

    // declarar o objeto do Selenium WebDriver
    WebDriver driver;
    Evidencias evidencias; // declara classe Evidencias como objeto
    static String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
    static String data = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());


    // executa 1 vez apenas antes de executar toda a classe
    @BeforeClass
    public void antesDaClasse() throws IOException {
        evidencias = new Evidencias(); // instancia a classe Evidencias dentro do código
        evidencias.iniciarCsv(data);
    }

    // executa antes de cada método @Test dentro da classe
    @BeforeMethod
    public void iniciar()
    {
        // A - Início
        // Apontar onde está o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\94\\chromedriver.exe");
        //Instanciar o objeto do Selenium como controlador do Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000)); // espera implícita entre cada teste
    }

    @AfterMethod
    public void finalizar()
    {
        // C - Encerramento
        driver.quit(); // Encerra o Processo do Selenium
    }


    @Test
    public void consultarCursoMantis() throws IOException {

        String casoDeTeste = "consultarCursoMantis";
        // B - Realizar o teste
        driver.get("https://iterasys.com.br/");                                     // abre o site alvo informado
        driver.findElement(By.id("searchtext")).click();                            // clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                            // limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("mantis");     // digita "mantis" no campo
        driver.findElement(By.id("btn_form_search")).click();                       // clica na Lupa

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(30));
        espera.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.titulo"), "Mantis"));

        assertEquals(driver.findElement(By.cssSelector("span.titulo")).getText(), "Mantis");
        assertEquals(driver.findElement(By.cssSelector("h3:nth-child(1)")).getText(), "Cursos › \"mantis\"");
        String mensagem = "PesquisaMantis";
        evidencias.print(driver, dataHora, casoDeTeste,mensagem); // instancia o método da classe Evidencias que tira screenshot
        evidencias.registrarCsv(casoDeTeste, mensagem);

        driver.findElement(By.cssSelector("span.comprar")).click(); // clica no botão Matricule-se
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Mantis");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 49,99");
        mensagem = "PrecoMantis";
        evidencias.print(driver, dataHora, casoDeTeste, mensagem);
        evidencias.registrarCsv(casoDeTeste, mensagem);
    }


}
