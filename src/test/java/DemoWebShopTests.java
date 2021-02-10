import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoWebShopTests {


    @Test
    void addToWishlistTest() {
        String body = "addtocart_51.EnteredQuantity=1";
        String cookie = "Nop.customer=8ceb6c9b-a5bf-4f8f-8900-b9e59bab7be6; __utmz=78382081.1611734283.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); nop.CompareProducts=; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=51&RecentlyViewedProductIds=29&RecentlyViewedProductIds=53&RecentlyViewedProductIds=14; ARRAffinity=7f10010dd6b12d83d6aefe199065b2e8fe0d0850a7df2983b482815225e42439; __utmc=78382081; __utma=78382081.1191995250.1611734283.1612630814.1612646290.7; __utmt=1; __atuvc=1%7C4%2C22%7C5%2C1%7C6; __atuvs=601f07b0b48db0da000; __utmb=78382081.7.10.1612646290";

        given()
                .body(body)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(cookie)
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/51/2")
                .then()
                .statusCode(200);
    }

    @Test
    void addToWishlistAssertTest() {
        String body = "addtocart_51.EnteredQuantity=1";
        String cookie = "Nop.customer=8ceb6c9b-a5bf-4f8f-8900-b9e59bab7be6; __utmz=78382081.1611734283.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); nop.CompareProducts=; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=51&RecentlyViewedProductIds=29&RecentlyViewedProductIds=53&RecentlyViewedProductIds=14; ARRAffinity=7f10010dd6b12d83d6aefe199065b2e8fe0d0850a7df2983b482815225e42439; __utmc=78382081; __utma=78382081.1191995250.1611734283.1612630814.1612646290.7; __utmt=1; __atuvc=1%7C4%2C22%7C5%2C1%7C6; __atuvs=601f07b0b48db0da000; __utmb=78382081.7.10.1612646290";

        Response response = given()
                .body(body)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(cookie)
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/51/2")
                .then()
                .statusCode(200)
                .extract().response();

        assertTrue(response.asString().contains("The product has been added to your"));

    }

    @Test
    void addToWishlistBodyAssertTest() {
        String body = "addtocart_51.EnteredQuantity=1";
        String cookie = "Nop.customer=8ceb6c9b-a5bf-4f8f-8900-b9e59bab7be6; __utmz=78382081.1611734283.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); nop.CompareProducts=; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=51&RecentlyViewedProductIds=29&RecentlyViewedProductIds=53&RecentlyViewedProductIds=14; ARRAffinity=7f10010dd6b12d83d6aefe199065b2e8fe0d0850a7df2983b482815225e42439; __utmc=78382081; __utma=78382081.1191995250.1611734283.1612630814.1612646290.7; __utmt=1; __atuvc=1%7C4%2C22%7C5%2C1%7C6; __atuvs=601f07b0b48db0da000; __utmb=78382081.7.10.1612646290";

        given()
                .body(body)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(cookie)
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/51/2")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"));

    }

}
