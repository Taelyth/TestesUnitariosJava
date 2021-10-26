package stepsPO;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/featuresPO"},       // onde estão as features em Gherkin
        glue = {"stepsPO"},                                 // onde estão as definições de passos
        dryRun = false,                                     // true = remove exibição de log
        monochrome = false,                                  // true = para deixar o resultado em P/B
        plugin = {
                "pretty",                                    // formatação visual para JSON
                "html:target/reports/report.html",         // saída html do relatório Simples
                "json:target/reports/report.json"     // saída json com os dados
        }
)
public class Runner extends AbstractTestNGCucumberTests { // equivalente ao @RunWith do JUnit
    // Configuração de modelo de relatório ou de outra característica

}
