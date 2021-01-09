package frc.robot.common;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {
    /**
     * This is cool.
     */
    public static DifferentialDrive m_drive;
    public static WPI_VictorSPX m_leftAft = new WPI_VictorSPX(1);
    public static WPI_VictorSPX m_leftFront = new WPI_VictorSPX(2);
    public static WPI_VictorSPX m_rightAft = new WPI_VictorSPX(3);
    public static WPI_VictorSPX m_rightFront = new WPI_VictorSPX(4);

    public static Joystick m_joy = new Joystick(0);

    public static DigitalInput ballCounter = new DigitalInput(9);
}


//Hallo javaworld
