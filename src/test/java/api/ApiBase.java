package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {
    final static String BASE_URI = "https://studio-api.softr.io/v1/api/users";
    final static String API_KEY = "khIbAyJIU5CIuh1oDuBRx1s49";
    final static String DOMAIN = "jere237.softr.app";
    static RequestSpecification specification = new RequestSpecBuilder()
            .setUrlEncodingEnabled(false)
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", API_KEY)
            .addHeader("Softr-Domain",DOMAIN )
            .build();

    public void deleteRequest(String email) {
        Response response = RestAssured.given()
                .spec(specification)
                .body("{}")
                .when()
                .log().all()
                .delete(BASE_URI + "/" + email)
                .then().log().all()
                .extract().response();
//        response.then().assertThat().statusCode(200);
//        return response;
        int i = 0;
    }
}
