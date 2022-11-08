import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

public class JiraIssues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "http://localhost:8080";

		// user authentication

		SessionFilter sf = new SessionFilter();
		String IssueSummary = "Performance issues";

		given().log().all().header("Content-Type", "application/json").body(JiraRequest.UserAutRequest()).log().all()
				.filter(sf).when().post("rest/auth/1/session").then().log().all().assertThat().statusCode(200).extract()
				.response().asString();

		// Normal way of Create issues

		String CreateResponse = given().log().all().filter(sf).header("Content-Type", "application/json")
				.body(JiraRequest.CreateIssues()).when().post("/rest/api/2/issue").then().log().all().assertThat()
				.statusCode(201).extract().response().asString();

		System.out.println(CreateResponse);

		// create the issues through passing parameters

		given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "\"fields\": {\r\n" + "        \"project\": \r\n" + "        {\r\n"
						+ "            \"key\":\"AT\"\r\n" + "        },\r\n" + "\r\n" + "        \"summary\" : \""
						+ IssueSummary + "\",\r\n" + "        \"description\" : \"Incorrect error message has\",\r\n"
						+ "        \"issuetype\" : {\r\n" + "            \"name\": \"Bug\"\r\n" + "\r\n"
						+ "        }\r\n" + "\r\n" + "}\r\n" + "\r\n" + "}\r\n" + "\r\n" + "\r\n" + "\r\n" + "")
				.log().all().filter(sf).when().post("/rest/api/2/issue").then().log().all().assertThat().statusCode(201)
				.extract().response().asString();

		// create multiple issues

		/*
		 * String BulkResponse=
		 * given().log().all().filter(sf).header("Content-Type","application/json").body
		 * (JiraRequest.BulkIssues()) .when().post("/rest/api/2/issue/bulk")
		 * .then().log().all().assertThat().statusCode(201).extract().response().
		 * asString(); System.out.println(BulkResponse);
		 */

		// Get issues through path parameter

		String GetPath = given().log().all().filter(sf).pathParam("ID", "10005").when().get("/rest/api/2/issue/{ID}")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(GetPath);

		// get issues comments fields through path & Query

		String getResponse = given().log().all().filter(sf).pathParam("ID", "10005").queryParam("fields", "comment")
				.when().get("/rest/api/2/issue/{ID}").then().log().all().assertThat().statusCode(200).extract()
				.response().asString();
		System.out.println(getResponse);

		// adding comment in jira & filter out all the comment added into specific ID

		String getcomment = given().log().all().filter(sf).headers("Content-Type", "application/json")
				.pathParam("ID", "10005").body(JiraRequest.AddComment()).when().post("/rest/api/2/issue/{ID}/comment")
				.then().log().all().assertThat().statusCode(201).extract().response().asString();

		JsonPath js = new JsonPath(GetPath);
		String Commentid = js.get("id");
		String Commentdes = js.get("body");
		int commentscount = js.getInt("fields.comment.comments.size()");

		for (int i = 0; i < commentscount; i++) {
			String message = js.get("fields.comment.comments[" + i + "]").toString();
			System.out.println(message);
		}

		// adding a comment and filter out the description of the comment

		for (int i = 0; i < commentscount; i++) {
			String Commentbody = js.get("fields.comment.comments[" + i + "].body").toString();
			System.out.println(Commentbody);

		}

		// Update issue
		String UpdateSummary = "Name has been changed";

		String updateResponse = given().log().all().filter(sf).pathParam("ID", "10005")
				.header("Content-Type", "application/json").body(JiraRequest.UpdateIssue()).when()
				.put("/rest/api/2/issue/{ID}").then().log().all().assertThat().statusCode(204).extract().response()
				.asString();
		System.out.println(updateResponse);

		// Compare the name change with variable
		JsonPath jsUpdate = new JsonPath(updateResponse);
		String newSummary = js.getString("fields.description");
		System.out.println(newSummary);

		if (UpdateSummary.equalsIgnoreCase(newSummary)) {
			System.out.println("The issue summary has been updated successfully");
		} else {
			System.out.println("failed");
		}

	}

}
