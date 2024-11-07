package com.example;

import org.junit.jupiter.api.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationTest {

    @Test
    public void appium() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Redmi Note 9 Pro");
        options.setPlatformName("Android");
        //options.setAppPackage("com.google.android.youtube");
        //options.setAppActivity("com.google.android.apps.youtube.app.WatchWhileActivity");
        options.setCapability("automationName", "UiAutomator2");
        options.setCapability("autoGrantPermissions", true);
        options.setCapability("allowTestPackages", true);

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // Realizar pruebas con el driver
        System.out.println(driver.getDeviceTime());

        // Cerrar la sesión de Appium
        driver.quit();
    }
}
