package com.framework.stepdefinitions.api;
import com.framework.api.clients.UserClient; 
import com.framework.utils.EnvConfig; 
import io.cucumber.java.en.*; 
import io.qameta.allure.Allure; 
import io.restassured.module.jsv.JsonSchemaValidator; 
import io.restassured.response.Response; 
import org.testng.Assert; 
import java.io.File;
public class UserApiSteps {
    private Response response; private final UserClient client = new UserClient();
    @Given("api env loaded") 
    public void loadEnv(){
    	EnvConfig.load(); 
    	}
    @When("I send a GET request to {string}") 
    public void sendGet(String endpoint){ 
    	String base = EnvConfig.get("apiBaseUrl"); 
    	response = io.restassured.RestAssured.given().baseUri(base).when().get(endpoint).then().extract().response(); 
    	Allure.addAttachment("Response", response.asPrettyString()); 
    	}
    @Then("the response status code should be {int}") 
    public void status(int code){ 
    	Assert.assertEquals(response.getStatusCode(), code); 
    	}
    @Then("the response should match {string}") public void match(String schemaPath){ File schema = new File("src/test/resources/" + schemaPath); response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schema)); }
}
