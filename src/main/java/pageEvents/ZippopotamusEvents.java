package pageEvents;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import jdk.nashorn.internal.ir.IfNode;
import org.testng.Assert;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.Objects;

import static io.restassured.RestAssured.*;


public class ZippopotamusEvents {

    RequestSpecification apiRequest;
    Response apiResponse;
    ResponseBody apiResponseBody;
    String apiResponseBodyAsString;
    JsonPath jsonPathFromApiResponse;

    public void setApiURL(String url){
        RestAssured.baseURI = url;
    }

    public void sendApiRequest(){
        apiResponse = get(RestAssured.baseURI);
        //apiResponse = get(RestAssured.baseURI).then().extract().response();
        apiResponseBody = apiResponse.getBody();
        apiResponseBodyAsString = apiResponseBody.asString();
        System.out.println(apiResponseBodyAsString);
        jsonPathFromApiResponse = apiResponse.jsonPath();
    }

    public void checkForCorrectPlaceName(String expectedPlaceName){
        ArrayList returnedPlaceList = jsonPathFromApiResponse.get("places");
        String returnedPlace = "";

        for (Object o : returnedPlaceList) {
            String thisPlace = o.toString();

            if (thisPlace.contains(expectedPlaceName)) {
                returnedPlace = o.toString();
            }
        }
        System.out.println("Place found: " + returnedPlace);
        Assert.assertTrue(returnedPlace.contains(expectedPlaceName));
    }

    public void checkForCorrectPostcode(String expectedPostcode){
        ArrayList returnedPlaceList = jsonPathFromApiResponse.get("places");
        String returnedPostcode = "";

        for (Object o : returnedPlaceList) {
            String thisPlace = o.toString();

            if (thisPlace.contains(expectedPostcode)) {
                returnedPostcode = o.toString();
            }
        }
        System.out.println("Postcode found: " + returnedPostcode);
        Assert.assertTrue(returnedPostcode.contains(expectedPostcode));
    }

    public void checkForCorrectStatusCode(String expectedStatusCode){
        int expectedStatusCodeInt = Integer.parseInt(expectedStatusCode); //parseInt because the feature file holds the number as a string
        int returnedStatusCode = apiResponse.statusCode();
        System.out.println((returnedStatusCode));
        Assert.assertEquals(returnedStatusCode, expectedStatusCodeInt);
    }

}
