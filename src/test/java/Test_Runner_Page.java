import Pages.Login_Page;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileReader;
public class Test_Runner_Page extends Main_Setup_Page {
    Login_Page objlogin;

    //Chcek Login Functionality with  valid  User Email and valid password
    @Test
    public void dologin_valid_E_P() throws Exception {
        driver.get("http://automationpractice.com");
        objlogin = new Login_Page(driver);

        JSONParser jsonParser =new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/Different_Email_Pass.json"));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        String email = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");

        String user = objlogin.dologin_valid_E_P(email, password);
        Assert.assertEquals(user, "Purno SQA");

    }
    @Test
    //Chcek Login Functionality with valid User Email and Invalid password

    public void dologin_valid_E_invalid_P() throws Exception {
        driver.get("http://automationpractice.com");
        objlogin = new Login_Page(driver);

        JSONParser jsonParser =new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/Different_Email_Pass.json"));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject jsonObject = (JSONObject) jsonArray.get(1);
        String email = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");

        String user = objlogin.dologin_valid_E_invalid_P (email, password);
        Assert.assertEquals(user, "Authentication failed.");

    }
    @Test
    //Chcek Login Functionality with Invalid User Email and valid password

    public void dologin_invalid_E_valid_P() throws Exception {
        driver.get("http://automationpractice.com");
        objlogin = new Login_Page(driver);

        JSONParser jsonParser =new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/Different_Email_Pass.json"));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject jsonObject = (JSONObject) jsonArray.get(2);
        String email = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");

        String user = objlogin.dologin_invalid_E_valid_P (email, password);
        Assert.assertEquals(user, "Invalid email address.");

    }
    //Chcek Login Functionality with Invalid User Email and Invalid password
    @Test
    public void dologin_invalid_E_invalid_P() throws Exception {
        driver.get("http://automationpractice.com");
        objlogin = new Login_Page(driver);

        JSONParser jsonParser =new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/Different_Email_Pass.json"));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject jsonObject = (JSONObject) jsonArray.get(3);
        String email = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");

        String user = objlogin.dologin_invalid_E_invalid_P (email, password);
        Assert.assertEquals(user, "Invalid email address.");

    }
    //Chcek Login Functionality with valid User Email and Null password
    @Test
    public void dologin_valid_E_Nul_P() throws Exception {
        driver.get("http://automationpractice.com");
        objlogin = new Login_Page(driver);

        JSONParser jsonParser =new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/Different_Email_Pass.json"));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject jsonObject = (JSONObject) jsonArray.get(4);
        String email = (String) jsonObject.get("email");
        //String password = (String) jsonObject.get("password");

        String user = objlogin.dologin_valid_E_Nul_P (email);
        Assert.assertEquals(user, "Password is required.");

    }
}