package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Pet {

    //link do swagger: https://petstore.swagger.io/

    String uri = "https://petstore.swagger.io/v2/";
    int petId = 16484517;

    // Funções de Apoio
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }


    @Test
    public void incluirPet() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/pet.json");

        // Padrão Gherkin
        // Give — Dado
        given()
                .contentType("application/json")        // Tipo do conteúdo (também pode ser text/xml)
                .log().all()                            // mostrar todos os logs
                .body(jsonBody)
        // .When — Quando
        .when()
                .post(uri + "pet")              // Comando (post, put, get, delete) + Endpoint
        // .Then — Então
        .then()
                .log().all()
                .statusCode(200)                        // Valida Código do Estado
                .body("id", is(petId))      // Validar o Body do JSON
                .body("name", is("Kuro"))
                .body("category.name", is("gato")) // Validar um body dentro de uma categoria no JSON
                .body("tags.name[0]", containsString("preto")) // containsString valida parte do texto do body
                .body("tags.name[1]", endsWith("manchado"))     // valida final do body, e startsWith o começo
        ;
    }

    @Test(priority = 1)
    public void consultarPet()
    {
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "pet/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(petId))
                .body("name", is("Kuro"))
                .body("category.name", is("gato"))
                .body("tags.name[0]", containsString("preto"))
                .body("tags.id[0]", is(1))
                .body("tags.name[1]", endsWith("manchado"))
                .body("tags.id[1]", is(2))
        ;
    }

    @Test(priority = 2)
    public void alterarPet() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/newpet.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody) //json transmitido para fazer o put/alteração
        .when()
                .put(uri + "pet")
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(petId))
                .body("name", is("Kuro"))
                .body("tags.name[2]", containsString("vermifugado"))
                .body("tags.id[2]", is(3))
                .body("status", is("sold"))
        ;
    }

    @Test(priority = 3, dependsOnMethods = "incluirPet")
    public void deletarPet()
    {
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "pet/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("message", is(Integer.toString(petId)))
        ;
    }

}
