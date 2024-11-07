package com.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Application { 

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        try {
            // Configuración de capacidades para el dispositivo y navegador
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 9 Pro"); // Nombre del dispositivo
            caps.setCapability(MobileCapabilityType.UDID, "95b5f0b0"); // Reemplaza con el ID único del dispositivo
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12"); // Ejemplo: "11"
            // caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser"); // Abre el navegador Chrome
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
            caps.setCapability("appPackage", "com.miui.calculator"); // Paquete de la calculadora, por ejemplo
caps.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity"); // Activity de la calculadora
            caps.setCapability("ignoreHiddenApiPolicyError", true);
            caps.setCapability("skipDeviceInitialization", true);
            caps.setCapability("noReset", true);


            // Agregar el nombre de la automatización para Android
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

            // Iniciar el driver con Appium server
            AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), caps);

            // Navegar a una URL de prueba
            Thread.sleep(3000); // Espera 3 segundos para que la aplicación cargue

            WebElement clearButton = driver.findElement(By.id("com.miui.calculator:id/btn_7_s"));
            clearButton.click(); // Toca el botón de limpiar

            // Cerrar el driver
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
