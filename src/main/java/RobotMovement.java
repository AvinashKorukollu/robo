/**
 * Created by Avi on 2/28/2018.
 */
public class RobotMovement {
    private Motor motor1;
    private Motor motor2;
    private Motor motor3;
    private Motor motor4;

    public RobotMovement() {
        motor1 = new Motor(23, 24);
        motor2 = new Motor(17, 22);
        motor3 = new Motor(26, 6);
        motor4 = new Motor(5, 16);
    }

    public void forward() {
        motor1.forward();
        motor2.forward();
        motor3.forward();
        motor4.forward();
    }

    public void backward() {
        motor1.reverse();
        motor2.reverse();
        motor3.reverse();
        motor4.reverse();
    }

    public void left() {
        motor1.forward();
        motor3.reverse();
    }

    public void right() {
        motor2.forward();
        motor4.reverse();
    }

    public void stop() {
        motor1.stop();
        motor2.stop();
        motor3.stop();
        motor4.stop();
    }
}
