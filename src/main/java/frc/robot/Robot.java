/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.File;
import java.text.SimpleDateFormat;

import static frc.robot.common.RobotMap.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    private SendableChooser<Double> fineControlSpeed = new SendableChooser<>();
    private SendableChooser<Double> deadBandOptions = new SendableChooser<>();
    private double fineControlSpeedDouble;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    private NetworkTable limelight_table = NetworkTableInstance.getDefault().getTable("limelight");
    private NetworkTableEntry ledStatusEntry = Shuffleboard.getTab("DRIVETRAIN").add("LED Status", "OFF").getEntry();
    private NetworkTableEntry ll3dEntry = Shuffleboard.getTab("DRIVETRAIN").add("Limelight 3D stuff", new Number[0]).getEntry();
    private NetworkTableEntry sensorEntry = Shuffleboard.getTab("DEBUG").add("Sensor value", false).getEntry();
    private NetworkTableEntry ballEntry = Shuffleboard.getTab("DEBUG").add("Ball Count",0).getEntry();

    private static boolean isReadingBall = false;
    public static int powerCellCount = 0;

    public static double d; // The distance to the target!
    private static double a2; // The angle from the limelight
    private static final double a1 = 42; // The angle the limelight is mounted at
    private static final double h1 = 11.25; // The height the limelight is mounted at
    private static final double h2 = 98.25; // The height of the target

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */

  private static boolean isReadingBall = false;
  public static int powerCellCount = 0;

  public static double d; // The distance to the target
  private static double a2; // The angle from the limelight
  private static final double a1 = 42; // The angle the limelight is mounted at
  private static final double h1 = 11.25; // The height the limelight is mounted at
  private static double h2 = 98.25; // The height of the target

  /**
   * Configure Victors, SendableChoosers, and initial debug statistics
   */

  @Override
  public void robotInit() {
<<<<<<< HEAD
    File file = new File(Robot.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    Shuffleboard.getTab("DEBUG").add("Left Aft Drivetrain Firm", m_leftAft.getFirmwareVersion());
    Shuffleboard.getTab("DEBUG").add("Left Front Drivetrain Firm", m_leftFront.getFirmwareVersion());
    Shuffleboard.getTab("DEBUG").add("Right Aft Drivetrain Firm", m_rightAft.getFirmwareVersion());
    Shuffleboard.getTab("DEBUG").add("Right Front Drivetrain Firm", m_rightFront.getFirmwareVersion());
    Shuffleboard.getTab("DEBUG").add("Last code deploy", sdf.format(file.lastModified()));


    //Format all motor controllers
    m_leftAft.configFactoryDefault();
    m_leftFront.configFactoryDefault();
    m_rightAft.configFactoryDefault();
    m_rightFront.configFactoryDefault();


    //Config followers
    m_leftAft.follow(m_leftFront);
    m_rightAft.follow(m_rightFront);

    //Config inversion
    m_leftFront.setInverted(false);
    m_rightFront.setInverted(false);

    //Instantiate DifferentialDrive and put it on Shuffleboard
    m_drive = new DifferentialDrive(m_leftFront,m_rightFront);
    Shuffleboard.getTab("DRIVETRAIN").add(m_drive);

    //Put Limelight LED Status to Shuffleboard
    ledStatusEntry.setString("OFF");

    //Fine Control Speed User
    fineControlSpeed.addOption("35% Speed", 0.35);
    fineControlSpeed.addOption("40% Speed", 0.40);
    fineControlSpeed.setDefaultOption("45% Speed", 0.45);
    fineControlSpeed.addOption("50% Speed", 0.50);
    fineControlSpeed.addOption("55% Speed", 0.55);
    fineControlSpeed.addOption("60% Speed", 0.60);
    Shuffleboard.getTab("SETUP").add("Fine Control Speed", fineControlSpeed);

    //Dead Band chooser
    deadBandOptions.setDefaultOption("5%", 0.05);
    deadBandOptions.addOption("10%", 0.10);
    deadBandOptions.addOption("15%", 0.15);
    Shuffleboard.getTab("SETUP").add("Dead Band", deadBandOptions);

    //Transmits video through cameras
    CameraServer.getInstance().startAutomaticCapture();
=======

      File file = new File(Robot.class.getProtectionDomain().getCodeSource().getLocation().getPath());
      Shuffleboard.getTab("DEBUG").add("Left Aft Drivetrain Firm", m_leftAft.getFirmwareVersion());
      Shuffleboard.getTab("DEBUG").add("Left Front Drivetrain Firm", m_leftFront.getFirmwareVersion());
      Shuffleboard.getTab("DEBUG").add("Right Aft Drivetrain Firm", m_rightAft.getFirmwareVersion());
      Shuffleboard.getTab("DEBUG").add("Right Front Drivetrain Firm", m_rightFront.getFirmwareVersion());
      Shuffleboard.getTab("DEBUG").add("Last code deploy", sdf.format(file.lastModified()));

      //Format all motor controllera
      m_leftAft.configFactoryDefault();
      m_leftFront.configFactoryDefault();
      m_rightAft.configFactoryDefault();
      m_rightFront.configFactoryDefault();

      //Config followers
      m_leftAft.follow(m_leftFront);
      m_rightAft.follow(m_rightFront);

      //Config inversion
      m_leftFront.setInverted(false);
      m_rightFront.setInverted(false);

      //Instantiate DifferentialDrive and put it on Shuffleboard
      m_drive = new DifferentialDrive(m_leftFront, m_rightFront);
      Shuffleboard.getTab("DRIVETRAIN").add(m_drive);

      //Put Limelight LED Status to Shuffleboard
      ledStatusEntry.setString("OFF");

      //Fine Control Speed User
      fineControlSpeed.addOption("35% Speed", 0.35);
      fineControlSpeed.addOption("40% Speed", 0.40);
      fineControlSpeed.setDefaultOption("45% Speed", 0.45);
      fineControlSpeed.addOption("50% Speed", 0.50);
      fineControlSpeed.addOption("55% Speed", 0.55);
      fineControlSpeed.addOption("60% Speed", 0.60);
      Shuffleboard.getTab("SETUP").add("Fine Control Speed", fineControlSpeed);

      //Dead Band chooser
      deadBandOptions.setDefaultOption("5%", 0.05);
      deadBandOptions.addOption("10%", 0.10);
      deadBandOptions.addOption("15%", 0.15);
      Shuffleboard.getTab("SETUP").add("Dead Band", deadBandOptions);

      //Transmits video through cameras
      CameraServer.getInstance().startAutomaticCapture();
>>>>>>> a886c3bd1806cfe42ab8bc2ade9df1dc39b49b9d
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
      ll3dEntry.setNumberArray(limelight_table.getEntry("camtran").getNumberArray(new Number[0]));
      sensorEntry.setBoolean(ballCounter.get());
      ballEntry.setNumber(powerCellCount);

      if(!ballCounter.get() && !isReadingBall) { //If ball sensor is reading ball being intaked
          powerCellCount++; //Increase power cell count by one
          isReadingBall = true; //Prevent reading multiple power cells at once
      }
      if(ballCounter.get() && isReadingBall) {
          isReadingBall = false;
      }

      if(m_joy.getRawButtonPressed(4)) {
          powerCellCount = 0;
      }

      a2 = limelight_table.getEntry("ty").getDouble(0); // Sets a2, the y position of the target
      d = Math.round((h2-h1) * 12 / Math.tan(Math.toRadians(a1+a2))); // Finds the distance
      SmartDashboard.putNumber("distance",d);
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
//    m_autoSelected = m_chooser.getSelected();
//    m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
//    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
//     switch (m_autoSelected) {
//      case kCustomAuto:
//        // Put custom auto code here
//        break;
//      case kDefaultAuto:
//      default:
//        // Put default auto code here
//        break;
    }

  /**
   * This function is called once when teleop is enabled.
   */
  @Override
  public void teleopInit() {
      fineControlSpeedDouble = -fineControlSpeed.getSelected(); //set fine control speed
      m_drive.setDeadband(deadBandOptions.getSelected()); //set deadband
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

      //Fine control
      if (m_joy.getPOV() == 0) { //Forward
          m_drive.arcadeDrive(-fineControlSpeedDouble, 0);
      } else if (m_joy.getPOV() == 90) { //Right
          m_drive.arcadeDrive(0, -fineControlSpeedDouble);
      } else if (m_joy.getPOV() == 180) { //Reverse
          m_drive.arcadeDrive(fineControlSpeedDouble, 0);
      } else if (m_joy.getPOV() == 270) { //Left
          m_drive.arcadeDrive(0, fineControlSpeedDouble);
      } else {
          //Arcade drive
          m_drive.arcadeDrive(-m_joy.getY(), m_joy.getX());
      }
      //Limelight LED Control
      if(m_joy.getRawButtonPressed(5)) {
          limelight_table.getEntry("ledMode").setNumber(1); //Off
          ledStatusEntry.setString("OFF");
      }

      if(m_joy.getRawButtonPressed(6)) {
          limelight_table.getEntry("ledMode").setNumber(2); //Blink
          ledStatusEntry.setString("BLINK");
      }

      if(m_joy.getRawButtonPressed(3)) {
          limelight_table.getEntry("ledMode").setNumber(3); //On
          ledStatusEntry.setString("ON");
      }

      //Limelight Driver Cam Mode
      if(m_joy.getRawButtonPressed(12)) {
          limelight_table.getEntry("camMode").setNumber(0); //Vision Processor
      }

      if(m_joy.getRawButtonPressed(11)) {
          limelight_table.getEntry("camMode").setNumber(1); //Driver Cam
      }
  }

    @Override
    public void disabledInit() {
        limelight_table.getEntry("ledMode").setNumber(0); //Reset limelight LEDs after match end
        ledStatusEntry.setString("OFF");
  }
}