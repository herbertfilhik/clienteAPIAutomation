package APITesting.com.org.api;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class GetRequests {
	
	@Test(enabled = true)
	public void Test_01() {
		RestAssured.useRelaxedHTTPSValidation();
		Response resp = when().get(
				"https://jsonplaceholder.typicode.com/todos/1");
		System.out.println(resp.getStatusCode());
		AssertJUnit.assertEquals(resp.getStatusCode(), 200);
	}

	@Test(enabled = true)
	public void Test_02() {
		RestAssured.useRelaxedHTTPSValidation();
		Response resp = when().get("https://jsonplaceholder.typicode.com/todos/1");
		System.out.println(resp.getStatusCode());
		AssertJUnit.assertEquals(resp.getStatusCode(), 200);
	}

	@Test(enabled = true)
	public void Test_03() {
		RestAssured.useRelaxedHTTPSValidation();
		Response resp = given()
				.param("1")
				.when()
				.get("https://jsonplaceholder.typicode.com/todos/");
		System.out.println(resp.getStatusCode());
		AssertJUnit.assertEquals(resp.getStatusCode(), 200);
	}

	@Test(enabled = true)
	public void Test_04() {
		RestAssured.useRelaxedHTTPSValidation();
		given().relaxedHTTPSValidation().
		param("1").
		when().
		get("https://jsonplaceholder.typicode.com/todos/").
		then().
		assertThat().statusCode(200);
	}
	
	@Test(enabled = true)
	public void Test_05() {
		RestAssured.useRelaxedHTTPSValidation();
		Response resp = given().relaxedHTTPSValidation()
			.param("1")
			.when()
			.get("https://jsonplaceholder.typicode.com/todos/");
		System.out.println(resp.asString());
	}
	
	@Test(enabled = true)
	public void Test_06() {
		RestAssured.useRelaxedHTTPSValidation();
		String resp = given()
			.relaxedHTTPSValidation()
			.parameter("1")
			.when()
			.get("https://jsonplaceholder.typicode.com/todos/")
			.then()
			.contentType(ContentType.JSON)
			.extract()
			.path("userId","id","title", "completed");
		
		System.out.println("report: "+ resp);		
	}
	
	@Test(enabled = true)
	public void Test_07() {
		RestAssured.useRelaxedHTTPSValidation();
		Response resp = given().
				parameter("1").
				when().
				get("https://jsonplaceholder.typicode.com/todos/");
		
		String actual = resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("userId","id","title","completed");

	    String expected = null;		
			if(actual.equalsIgnoreCase(expected)){
				System.out.println("Testcase pass");
			}
			else
				System.out.println("Testcase fail");
	}
}