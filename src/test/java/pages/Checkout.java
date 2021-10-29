package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

    WebDriver driver;
    @FindBy(css = "span.item-title") WebElement nomeCurso;
    @FindBy(css = "span.new-price") WebElement precoCurso;

    public Checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String lerNomeCurso()
    {
        return nomeCurso.getText();
    }

    public String lerPrecoCurso()
    {
        return precoCurso.getText();
    }

}
