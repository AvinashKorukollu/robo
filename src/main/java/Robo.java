import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.i2c.I2CFactory;

import java.awt.*;

public class Robo {

    public static GpioController GPIO = GpioFactory.getInstance();

    public GpioController getGPIO() {
        return GPIO;
    }

    public void shutDownGPIO() {
        GPIO.shutdown();
    }

    public static void moveServo(double mouseX, double mouseY) {
        if(mouseX < MouseInfo.getPointerInfo().getLocation().getX()) {

        }

        if(mouseX > MouseInfo.getPointerInfo().getLocation().getX()){

        }

        if(mouseY < MouseInfo.getPointerInfo().getLocation().getY()) {

        }

        if(mouseY > MouseInfo.getPointerInfo().getLocation().getY()){

        }
    }

    public static void main(String[] arg ) {
        double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
        while(true){
            moveServo(mouseX, mouseY);
        }
    }

}
