package webTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class comprarCursoCS {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void iniciar()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\95\\chromedriver.exe");
        driver = new ChromeDriver();

        //driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize(); // maximizar janela
        wait = new WebDriverWait(driver, 3);
        System.out.println("0 - Antes do Teste iniciar");
    }

    @After
    public void finalizar()
    {
        driver.quit();
        System.out.println("Z - Depois do Teste finalizar");
    }


    @Dado("que acesso o site da Iterasys")
    public void queAcessoOSiteDaIterasys() {

        driver.get("https://iterasys.com.br/");

        System.out.println("1 - Acessou o site");
    }

    @Quando("pesquiso por {string}")
    public void pesquisoPor(String curso) {

        driver.findElement(By.id("searchtext")).click();                            // clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                            // limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys(Keys.chord(curso));

        System.out.println("2 - Digitou o nome do curso como " + curso);
    }

    @E("clico na Lupa")
    public void clicoNaLupa() {

        driver.findElement(By.id("btn_form_search")).click();

        System.out.println("3 - Clicou na Lupa");
    }

    @Entao("vejo a lista de resultados para o termo {string}")
    public void vejoAListaDeResultadosParaOTermo(String curso) {

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.titulo"), curso));

        assertEquals(driver.findElement(By.cssSelector("span.titulo")).getText(), curso);
        assertEquals(driver.findElement(By.cssSelector("h3:nth-child(1)")).getText(), "Cursos › \""+ curso +"\"");

        System.out.println("4 - Exibiu a lista de resultados para o curso " + curso);
    }

    @Quando("clico em Matricule-se")
    public void clicoEmMatriculeSe() {

        driver.findElement(By.cssSelector("span.comprar")).click();

        System.out.println("5 - Clicou em matricule-se");
    }

    @Entao("confirmo o nome do curso como {string} e o preco de {string}")
    public void confirmoONomeDoCursoComoEOPrecoDe(String curso, String preco) {

        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), curso);
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), preco);

        System.out.println("6 - Validou nome como " + curso + " e preco do curso como " + preco);
    }

    @E("pressiono Enter")
    public void pressionoEnter() {
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);

        System.out.println("3a - Pressionou Enter");
    }

    @Quando("clico no botao Ok!")
    public void clicoNoBotaoOk() {
        driver.findElement(By.cssSelector("div.cc-compliance")).click();
    }

    @E("clico na imagem de um Curso")
    public void clicoNaImagemDeUmCurso() {
        WebElement saibaMais = driver.findElement(By.cssSelector("a[title = \"Formação em Teste de Software (On Demand)\"]"));

        // Ir com o mouse até o elemento (mouse hover):
        Actions actions = new Actions(driver);
        actions.moveToElement(saibaMais).build().perform();

        driver.findElement(By.cssSelector("a[title = \"Formação em Teste de Software (On Demand)\"] > span.mais")).click();

    }

    @Entao("vejo a pagina com detalhes do Curso")
    public void vejoAPaginaComDetalhesDoCurso() {
        assertEquals(driver.getTitle(), "Formação em Teste de Software (On Demand) - Iterasys");
    }
}
