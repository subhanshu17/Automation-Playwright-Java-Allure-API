package com.framework.api.clients;
import com.framework.api.models.User; 
import com.framework.utils.EnvConfig; 
import com.framework.utils.LoggerUtil; 
import io.qameta.allure.Allure; 
import io.restassured.http.ContentType; 
import io.restassured.response.Response; 
import org.slf4j.Logger; 
import static io.restassured.RestAssured.given;
public class UserClient {
    private static final Logger log = LoggerUtil.getLogger(UserClient.class);
    private final String BASE = EnvConfig.get("apiBaseUrl");
    private void attach(String name, String body){ Allure.addAttachment(name, body); }
    public Response getUser(int id){ String endpoint = "/users/" + id; log.info("GET {}", endpoint); Response r = given().baseUri(BASE).when().get(endpoint); attach("GET response", r.asPrettyString()); return r; }
    public Response createUser(User user){ String endpoint = "/users"; log.info("POST {}", endpoint); attach("POST body", user.getName()+","+user.getUsername()+","+user.getEmail()); Response r = given().baseUri(BASE).contentType(ContentType.JSON).body(user).when().post(endpoint); attach("POST response", r.asPrettyString()); return r; }
}
