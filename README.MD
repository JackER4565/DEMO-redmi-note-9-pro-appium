### appium test con mi xiaomi redmi note 9 pro personal

* Primero tuve que habilitar las opciones de desarrollador, 
* despues activar:
* Depuracion USB
* Instalar vía USB
* Depuracion USB (ajuste de seguridad)

Yo lo que hice fue automatizar la calculadora, asi que abri la calculadora y ejecute el comando

```bash
adb shell dumpsys window windows
```

y de aqui obtuve que el paquete y la actividad se llaman:

* com.miui.calculator
* com.miui.calculator.cal.CalculatorActivity

asi que agregue las capabilities al proyecto
```
caps.setCapability("appPackage", "com.miui.calculator"); // Paquete de la calculadora, por ejemplo
caps.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity"); // Activity de la calculadora
```

## obteniendo IDS de la aplicación

se puede usar appium inspector, yo en mi caso use adb sin instalar nada a parte:

```
adb shell uiautomator dump /sdcard/ui.xml
```
esto genera un archivo xml en el celular, ahora obtenemos ese archivo en la computadora:

```
adb pull /sdcard/ui.xml
```

este comando te descarga el ui.xml en el lugar donde ejecutaste el comando.
Ahora abrimos el archivo y buscamos "resource-id"

en mi caso me devolvio 
text="4" resource-id="com.miui.calculator:id/btn_4_s"
entonces ya se que necesito buscar por ese ID para tocar el numero 4 de la calculadora en mi proyecto java