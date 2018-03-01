import com.pi4j.io.gpio.*;

public class Distance {
    GpioController gpio = GpioFactory.getInstance();

    private static GpioPinDigitalOutput sensorTriggerPin_front;
    private static GpioPinDigitalInput sensorEchoPin_front;

    private static GpioPinDigitalOutput sensorTriggerPin_back;
    private static GpioPinDigitalInput sensorEchoPin_back;

    public Distance() {
        sensorTriggerPin_front = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
        sensorEchoPin_front = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);

        sensorTriggerPin_back = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
        sensorEchoPin_back = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
    }

    public double distanceFront() throws InterruptedException {
        sensorTriggerPin_front.high();
        Thread.sleep((long) 0.01);
        sensorTriggerPin_front.low();
        while (sensorEchoPin_front.isLow()) {}
        long startTime = System.nanoTime();
        while (sensorEchoPin_front.isHigh()) {}
        long endTime = System.nanoTime();

        return ((((endTime - startTime) / 1e3) / 2) / 29.1);
    }

    public double distanceBack() throws InterruptedException {
        sensorTriggerPin_back.high();
        Thread.sleep((long) 0.01);
        sensorTriggerPin_back.low();
        while (sensorEchoPin_back.isLow()) {}
        long startTime = System.nanoTime();
        while (sensorEchoPin_back.isHigh()) {}
        long endTime = System.nanoTime();
        return ((((endTime - startTime) / 1e3) / 2) / 29.1);
    }
}
