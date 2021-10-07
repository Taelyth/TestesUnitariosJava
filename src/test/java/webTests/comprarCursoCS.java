package webTests;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class comprarCursoCS {
    @Dado("que acesso o site da Iterasys")
    public void queAcessoOSiteDaIterasys() {
    }

    @Quando("pesquiso por {string}")
    public void pesquisoPor(String arg0) {
    }

    @E("clico na Lupa")
    public void clicoNaLupa() {
    }

    @Entao("vejo a lista de resultados para o termo {string}")
    public void vejoAListaDeResultadosParaOTermo(String arg0) {
    }

    @Quando("clico em Matricule-se")
    public void clicoEmMatriculeSe() {
    }

    @Entao("confirmo o nome do curso como {string} e o preco de {string}")
    public void confirmoONomeDoCursoComoEOPrecoDe(String arg0, String arg1) {
    }
}
