import com.pi4j.io.i2c.I2CFactory;

public class Servo {

    PCA9685 servoBoard = new PCA9685();
    int servoMin = 150;
    int servoMax = 600;
    int servoMid = (servoMax - servoMin)/2;
    int servo1Position = servoMid;
    int servo2Position = servoMid;

    final int SERVO_1 = 0;
    final int SERVO_2 = 1;

    public Servo() throws I2CFactory.UnsupportedBusNumberException {
        servoBoard = new PCA9685();
        servoBoard.setPWMFreq(60);
    }

    public void servo1_clockwise(double rotation) {
        if( servo1Position + rotation < 600) {
            servo1Position += rotation;
            servoBoard.setPWM(SERVO_1,   0, servo1Position);
        }
        else {
            servoBoard.setPWM(SERVO_1,   0, servoMax);
        }
    }

    public void servo1_antiClockwise(double rotation) {
        if( servo1Position - rotation < 150) {
            servo1Position -= rotation;
            servoBoard.setPWM(SERVO_1,   0, servo1Position);
        }
        else {
            servoBoard.setPWM(SERVO_1,   0, servoMin);
        }
    }

    public void servo2_clockwise(double rotation) {
        if( servo2Position + rotation < 600) {
            servo2Position += rotation;
            servoBoard.setPWM(SERVO_2,   0, servo2Position);
        }
        else{
            servoBoard.setPWM(SERVO_2,   0, servoMax);
        }
    }

    public void servo2_antiClockwise(double rotation) {
        if( servo2Position - rotation > 150) {
            servo2Position -= rotation;
            servoBoard.setPWM(SERVO_2,   0, servo2Position);
        }
        else {
            servoBoard.setPWM(SERVO_2,   0, servoMin);
        }
    }
}
