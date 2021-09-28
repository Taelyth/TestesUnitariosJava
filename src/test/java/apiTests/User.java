package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class User {

    //link do swagger: https://petstore.swagger.io/

    String uri = "https://petstore.swagger.io/v2/";

    int UserId = 1489416;
    String username = "test1489416";
    String password = "test123";

    // Funções de Apoio
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void incluirUser() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/user.json");

        // Padrão Gherkin
        // Give — Dado
        given()
                .contentType("application/json")        // Tipo do conteúdo (também pode ser text/xml)
                .log().all()                            // mostrar todos os logs
                .body(jsonBody)
                // .When — Quando
        .when()
                .post(uri + "user")              // Comando (post, put, get, delete) + Endpoint
                // .Then — Então
        .then()
                .log().all()
                .statusCode(200)
                .body("message", is(Integer.toString(UserId)))
        ;
    }

    @Test(priority = 1)
    public void consultarUser()
    {
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "user/" + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(UserId))
                .body("username", is(username))
                .body("firstName", is("Testando"))
                .body("lastName", is("Teste"))
                .body("email", endsWith("@test.com.br"))
                .body("userStatus", is(1))
        ;
    }

    @Test(priority = 1)
    public void login()
    {
        String mensagem =

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "user/login?username=" + username + "&password=" + password)
        .then()
                .log().all()
                .statusCode(200)
                .body("message", startsWith("logged in user session:"))
        .extract()
                .path("message")
        ;
        String token = mensagem.substring(mensagem.lastIndexOf(':') + 1);
        System.out.println(token);
    }

    @Test(priority = 2)
    public void alterarUser() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/putuser.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody) //json transmitido para fazer o put/alteração
        .when()
                .put(uri + "user/" + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("message", is(Integer.toString(UserId)))
        ;
    }

    @Test(priority = 3, dependsOnMethods = "incluirUser")
    public void deletarUser()
    {
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "user/" + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("message", is(username))
        ;
    }

}
