package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
    WebDriver driver;
    @FindBy(className="login")
    WebElement linkLogin;
    @FindBy(id="email")
    WebElement TextEmail;
    @FindBy(id="passwd")
    WebElement TextPass;
    @FindBy(xpath="//span[contains(.,'Sign in')]")
    WebElement singIn;
    @FindBy(xpath = "//span[contains(.,'Purno SQA')]")
    WebElement TextName;
    @FindBy(xpath = "//li[contains(.,'Authentication failed.')]")
    WebElement ErrorPass;
    @FindBy(xpath = "//li[contains(.,'Invalid email address.')]")
    WebElement Erroremail;
    @FindBy(xpath = "//li[contains(.,'Password is required.')]")
    WebElement Nullpass;

    public Login_Page(WebDriver driver){
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }
//--- Do Login With Valid Email And PassWord-- //
    public String dologin_valid_E_P (String email, String password ) throws InterruptedException{
        linkLogin.click();
        TextEmail.sendKeys(email);
        TextPass.sendKeys(password);
        singIn.click();
        return TextName.getText();
    }
    public String dologin_valid_E_invalid_P (String email, String password ) throws InterruptedException{
        linkLogin.click();
        TextEmail.sendKeys(email);
        TextPass.sendKeys(password);
        singIn.click();
        return ErrorPass.getText();
    }
    public String dologin_invalid_E_valid_P (String email, String password ) throws InterruptedException{
        linkLogin.click();
        TextEmail.sendKeys(email);
        TextPass.sendKeys(password);
        singIn.click();
        return Erroremail.getText();
    }
    public String dologin_invalid_E_invalid_P (String email, String password ) throws InterruptedException{
        linkLogin.click();
        TextEmail.sendKeys(email);
        TextPass.sendKeys(password);
        singIn.click();
        return Erroremail.getText();
    }

    public String dologin_valid_E_Nul_P (String email) throws InterruptedException{
        linkLogin.click();
        TextEmail.sendKeys(email);
        singIn.click();
        return Nullpass.getText();
    }

}
