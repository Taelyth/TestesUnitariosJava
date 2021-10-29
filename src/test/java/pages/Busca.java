package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Busca {

    WebDriver driver;
    @FindBy(css = "span.titulo") WebElement nomeCurso;
    @FindBy(css = "h3") WebElement nomeRodape;
    @FindBy(css = "span.comprar") WebElement btnMatriculese;

    public Busca(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String lerNomeCurso()
    {
        return nomeCurso.getText();
    }

    public String lerRodape()
    {
        String NomeCursoRodape = nomeRodape.getText();
        NomeCursoRodape = NomeCursoRodape.replace("Cursos › \"", "");
        NomeCursoRodape = NomeCursoRodape.replace("\"", "");

        return NomeCursoRodape;
    }

    public Checkout clicarBtnMatriculese()
    {
        btnMatriculese.click();
        return new Checkout(driver);
    }



}
