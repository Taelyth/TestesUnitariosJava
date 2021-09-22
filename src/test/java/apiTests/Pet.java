package apiTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Pet {

    String uri = "https://petstore.swagger.io/v2/";

    @Test
    public void incluirPet()
    {
        // Padrão Gherkin
        // Give — Dado
        given()
                .contentType("application/json")
                .log().all()
        // .When — Quando
        .when()
                .post(uri + "pet")
        // .Then — Então
        .then()
                .log().all()

        ;



    }

}
