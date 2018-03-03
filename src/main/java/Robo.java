import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.i2c.I2CFactory;

import java.awt.*;
import java.util.Scanner;

public class Robo {

    public static GpioController GPIO = GpioFactory.getInstance();
    static Distance distance;

    public GpioController getGPIO() {
        return GPIO;
    }

    public void shutDownGPIO() {
        GPIO.shutdown();
    }


    public static void main(String[] arg ) {

        distance = new Distance();

        (new Thread(new MoveServo())).start();

        (new Thread(new MoveMotors())).start();
    }
}

class MoveServo extends Thread {
    double mouseX;
    double mouseY;
    Servo servo;

    public MoveServo() {
        try {
            servo = new Servo();
        } catch (I2CFactory.UnsupportedBusNumberException e) {
            e.printStackTrace();
        }
        mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        mouseY = MouseInfo.getPointerInfo().getLocation().getY();
    }
    public void run() {
        double deltaX = mouseX - MouseInfo.getPointerInfo().getLocation().getX();
        double deltaY = mouseY - MouseInfo.getPointerInfo().getLocation().getY();
        if(deltaX < 0) {
            servo.servo1_antiClockwise(deltaX);
        }

        if(deltaX > 0){
            servo.servo1_clockwise(deltaX);
        }

        if(deltaY < 0) {
            servo.servo2_antiClockwise(deltaY);
        }

        if(deltaY > 0){
            servo.servo2_clockwise(deltaY);
        }
    }
}

class MoveMotors extends Thread {
    RobotMovement robotMovement;
    public MoveMotors(){
        robotMovement = new RobotMovement();
    }
    public void run() {
        //get char input and move motors
        Scanner reader = new Scanner(System.in);
        char input = reader.next().charAt(0);
        if(input == 'w'){
            robotMovement.forward();
        }
        else if(input == 's') {
            robotMovement.backward();
        }
        else if(input == 'a') {
            robotMovement.left();
        }
        else if(input == 'd') {
            robotMovement.right();
        }
        else {
            robotMovement.stop();
        }
    }
}
