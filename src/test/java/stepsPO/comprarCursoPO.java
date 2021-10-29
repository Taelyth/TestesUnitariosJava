package stepsPO;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Busca;
import pages.Checkout;
import pages.Home;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class comprarCursoPO {

    WebDriver driver;
    Home home;
    Busca busca;
    Checkout checkout;

    @Before
    public void inicializar()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\95\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(1400, 0));
        driver.manage().window().maximize(); // maximizar janela
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Dado("que acesso a home da Iterasys")
    public void queAcessoAHomeDaIterasys() {
        home = new Home(driver);
        home.acessarPaginaInicial();
    }

    @Quando("procuro por {string}")
    public void procuroPor(String curso) {
        home.pesquisarPorCurso(curso);
    }

    @E("clico no botao da Lupa")
    public void clicoNoBotaoDaLupa() {
        busca = home.clicarNaLupa();
    }

    @Entao("vejo os resultados para o termo {string}")
    public void vejoOsResultadosParaOTermo(String curso) {

        assertEquals(busca.lerNomeCurso(), curso);
        assertEquals(busca.lerRodape(), curso);
    }

    @Quando("clico no botao Matricule-se")
    public void clicoNoBotaoMatriculeSe() {
        checkout = busca.clicarBtnMatriculese();
    }

    @Entao("confirmo o nome como {string} e o preco de {string}")
    public void confirmoONomeComoEOPrecoDe(String curso, String preco) {
        assertEquals(checkout.lerNomeCurso(), curso);
        assertEquals(checkout.lerPrecoCurso(), preco);
    }
}
