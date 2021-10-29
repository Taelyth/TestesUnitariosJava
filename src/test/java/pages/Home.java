package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    // Classe de Mapeamento possui 3 seções
    // 1 — Mapeamento de Elementos (Atributos)
    // 2 — Construtor entre os Elementos e os passos
    // 3 — Funções e Métodos Mapeados

    // 1 — Mapeamento
    WebDriver driver;
    @FindBy(id = "searchtext") WebElement caixaDePesquisa;
    @FindBy(id = "btn_form_search") WebElement lupa;

    // 2 — Construtor
    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acessarPaginaInicial()
    {
        driver.get("https://iterasys.com.br/");
    }

    // 3 — Funções e Métodos
    public void pesquisarPorCurso(String curso)
    {
        caixaDePesquisa.click();
        caixaDePesquisa.clear();
        caixaDePesquisa.sendKeys(curso);
    }

    public Busca clicarNaLupa()
    {
        lupa.click();
        return new Busca(driver);
    }

}
