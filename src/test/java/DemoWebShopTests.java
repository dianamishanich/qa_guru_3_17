import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoWebShopTests {

    private static ValidatableResponse request;
    private static String body = "addtocart_51.EnteredQuantity=1";
    private static String path = "http://demowebshop.tricentis.com/addproducttocart/details/51/2";
    private static String cookies = System.getProperty("cookies");

    @BeforeAll
    static void setup() {
        request = given()
                .body(body)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(cookies)
                .when()
                .post(path)
                .then()
                .statusCode(200);
    }

    @Test
    void addToWishlistAssertTest() {
        Response response = request.extract().response();
        System.out.println(response.asString());
        assertTrue(response.asString().contains("The product has been added to your"));
    }

    @Test
    void addToWishlistBodyAssertTest() {
        System.out.println(request);
        request.body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"));
    }

}