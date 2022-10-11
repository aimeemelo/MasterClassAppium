package com.test;


import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    private static AppiumDriver<?> driver;
    public static String plataforma = "";

    public static AppiumDriver validarDriver () throws MalformedURLException {

        plataforma = System.getProperty("plataforma");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(plataforma.equals("androidlocal")) {
            capabilities.setCapability("app", "/Users/quint/Downloads/apidemos/app-debug.apk");
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("platformaName", "Android");
//        capabilities.setCapability("platformVersion", "11");
//        capabilities.setCapability("automationName", "UiAutomator2");
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        }else if(plataforma.equals("ioslocal")){
            capabilities.setCapability("app", "/Users/quint/Downloads/apidemos/LoginExample.app");
            capabilities.setCapability("deviceName", "iPhone 13");
            capabilities.setCapability("platformaName", "iOS");
            capabilities.setCapability("platformVersion", "15.0");
            capabilities.setCapability("automationName", "XCUITest");
            driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        } else if(plataforma.equals("androidfarm")) {

            System.out.println("vai rodar no farm - ANDROID");
            // Set your access credentials
            capabilities.setCapability("browserstack.user", "aimemelo_Uxgn5e");
            capabilities.setCapability("browserstack.key", "2Ed3JF1p43BxfD5nsUu4");

            // Set URL of the application under test
            capabilities.setCapability("app", "bs://975b06aac6472f231604ba4bd50eb2447bfc2276");

            // Specify device and os_version for testing
            capabilities.setCapability("device", "Google Pixel 3");
            capabilities.setCapability("os_version", "9.0");

            driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);

        } else if(plataforma.equals("iosfarm")) {
            // Set your access credentials
            capabilities.setCapability("browserstack.user", "aimemelo_Uxgn5e");
            capabilities.setCapability("browserstack.key", "2Ed3JF1p43BxfD5nsUu4");

            // Set URL of the application under test
            capabilities.setCapability("app", "bs://975b06aac6472f231604ba4bd50eb2447bfc2276");

            // Specify device and os_version for testing
            capabilities.setCapability("device", "Google Pixel 3");
            capabilities.setCapability("os_version", "9.0");

            driver = new IOSDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);

        }
        else {
            System.out.println("não foi passado os parametros");
        }
        return driver;
    }
    public static AppiumDriver<?> getDriver(){
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Before
    public static void iniciarProjeto() throws MalformedURLException {
        if (getDriver() !=null) {
            getDriver().launchApp();
        }else {
            validarDriver();

        }
    }
}
