package com.test.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.remote.RemoteWebElement;


public class ScreenLogin  extends BaseScreen {

    @AndroidFindBy(id = "login_username")
    @iOSFindBy(accessibility = "login_username")
    private RemoteWebElement campoemail;

    @AndroidFindBy(id = "login_password")
    @iOSFindBy(accessibility = "login_password")
    private RemoteWebElement camposenha;

    @AndroidFindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[1]")
    @iOSFindBy(accessibility = "login_button")
    private RemoteWebElement botaologin;

    public void DadoescreverEmail() {
        campoemail.sendKeys("aimeemflins@gmail.com");
    }
    public void QuandoescreverSenha() {
        camposenha.sendKeys("1234567");
    }
    public void EntaoclicarParaLogar() {
        botaologin.click();

    }
    public void logar() {
        campoemail.sendKeys("aimeemflins@gmail.com");
        camposenha.sendKeys("1234567");
        botaologin.click();
    }
    public void logar2(String email, String senha){
        campoemail.sendKeys(email);
        camposenha.sendKeys(senha);
        botaologin.click();


    }
}
