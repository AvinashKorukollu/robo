/**
 * Created by Avi on 2/28/2018.
 */

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Motor {

    private GpioPinDigitalOutput pin1, pin2;
    public Motor(int pin1, int pin2) {
        this.pin1 = setRaspiPin(pin1);
        this.pin2 = setRaspiPin(pin2);
        this.pin1.setShutdownOptions(true, PinState.LOW);
        this.pin2.setShutdownOptions(true, PinState.LOW);
    }

    public void forward(){
        pin1.high();
        pin2.low();
    }

    public void reverse(){
        pin1.low();
        pin2.high();
    }

    public void stop(){
        pin1.low();
        pin2.low();
    }

    public GpioPinDigitalOutput setRaspiPin(int pin) {
        switch (pin) {
            case 0:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);
            case 1:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW);
            case 2:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);
            case 3:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW);
            case 4:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW);
            case 5:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.LOW);
            case 6:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, PinState.LOW);
            case 7:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW);
            case 8:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, PinState.LOW);
            case 9:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, PinState.LOW);
            case 10:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, PinState.LOW);
            case 11:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, PinState.LOW);
            case 12:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, PinState.LOW);
            case 13:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, PinState.LOW);
            case 14:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, PinState.LOW);
            case 15:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, PinState.LOW);
            case 16:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, PinState.LOW);
            case 17:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, PinState.LOW);
            case 18:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, PinState.LOW);
            case 19:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, PinState.LOW);
            case 20:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20, PinState.LOW);
            case 21:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, PinState.LOW);
            case 22:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, PinState.LOW);
            case 23:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, PinState.LOW);
            case 24:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, PinState.LOW);
            case 25:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, PinState.LOW);
            case 26:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, PinState.LOW);
            case 27:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, PinState.LOW);
            case 28:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, PinState.LOW);
            case 29:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, PinState.LOW);
            case 30:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_30, PinState.LOW);
            case 31:
                return gpio.provisionDigitalOutputPin(RaspiPin.GPIO_31, PinState.LOW);
            default:
                return null;
        }
    }

}
