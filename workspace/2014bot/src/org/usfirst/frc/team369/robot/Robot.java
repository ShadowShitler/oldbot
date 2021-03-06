
package org.usfirst.frc.team369.robot;

import org.usfirst.frc.team369.robot.Ps4.buttons;
import org.usfirst.frc.team369.robot.DriveTrain.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;





/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	
	
	
	
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    Ps4 p4;
    Shooter shoot;
    DigitalInput limit;
 //   RobotDrive DriveController;
    
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        p4 = new Ps4(0);
        shoot = new Shooter();
        limit = new DigitalInput(0);
//        DriveController = new RobotDrive(backLeft, frontLeft, backRight, frontRight);
       
    
    
    
    }
    
    
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	

    	
//    if (normalize(p4.getRawAxis(){
//  //     Drive(1,1);
//    }
   } 
    
    public void operatorControl(){
    	while (isOperatorControl() && isEnabled()) {
    	    		DriveTrain.myDrive.tankDrive(p4.getRawAxis(buttons.leftY), p4.getRawAxis(buttons.rightY));
    	    		Timer.delay(0.01);
    	    	}
    	if (p4.getRawButton(buttons.circle)){
    		shoot.shoot(3);
    	}
    	
    	
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }

	
}
	
