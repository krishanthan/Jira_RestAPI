
public class JiraRequest {
	
	public static String UserAutRequest()
	{
		return "{\r\n" + 
				"    \"username\": \"Krishanthan075\",\r\n" + 
				"    \"password\": \"Kingston@123\"\r\n" + 
				"}";
	}
	
	public static String CreateIssues()
	{
		return "{\r\n" + 
				"\"fields\": {\r\n" + 
				"        \"project\": \r\n" + 
				"        {\r\n" + 
				"            \"key\":\"AT\"\r\n" + 
				"        },\r\n" + 
				"\r\n" + 
				"        \"summary\" : \"Time Out Error\",\r\n" + 
				"        \"description\" : \"Incorrect error message has\",\r\n" + 
				"        \"issuetype\" : {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"";
	}
	
	public static String BulkIssues()
	{
		return "{\r\n" + 
				"    \"issueUpdates\": [\r\n" + 
				"        {\r\n" + 
				"            \"update\": {\r\n" + 
				"                \"worklog\": [\r\n" + 
				"                    {\r\n" + 
				"                        \"add\": {\r\n" + 
				"                            \"timeSpent\": \"60m\",\r\n" + 
				"                            \"started\": \"2011-07-05T11:05:00.000+0000\"\r\n" + 
				"                        }\r\n" + 
				"                    }\r\n" + 
				"                ]\r\n" + 
				"            },\r\n" + 
				"\r\n" + 
				"          \r\n" + 
				"\"fields\": {\r\n" + 
				"        \"project\": \r\n" + 
				"        {\r\n" + 
				"            \"key\":\"AT\"\r\n" + 
				"        },\r\n" + 
				"\r\n" + 
				"        \"summary\" : \"Incorrect error message appears while user enter user name\",\r\n" + 
				"        \"description\" : \"Incorrect error message has\",\r\n" + 
				"        \"issuetype\" : {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"\r\n" + 
				"        },\r\n" + 
				"\r\n" + 
				"  \r\n" + 
				"\"fields\": {\r\n" + 
				"        \"project\": \r\n" + 
				"        {\r\n" + 
				"            \"key\":\"AT\"\r\n" + 
				"        },\r\n" + 
				"\r\n" + 
				"        \"summary\" : \"Incorrect error message appears while user enter user name\",\r\n" + 
				"        \"description\" : \"Incorrect error message has\",\r\n" + 
				"        \"issuetype\" : {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"}]\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"          ";
				
				
	}
	
	public static String AddComment()
	{
		return "{\r\n" + 
				"    \"body\": \"The issue has been verified in QA\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
	}
	
	public static String UpdateIssue()
	{
		
		return "{\r\n" + 
				"\"fields\": {\r\n" + 
				"        \"project\": \r\n" + 
				"        {\r\n" + 
				"            \"key\":\"AT\"\r\n" + 
				"        },\r\n" + 
				"\r\n" + 
				"        \"summary\" : \"Name has been changed\",\r\n" + 
				"        \"description\" : \"Name has been changed\",\r\n" + 
				"        \"issuetype\" : {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"";
	}

}
