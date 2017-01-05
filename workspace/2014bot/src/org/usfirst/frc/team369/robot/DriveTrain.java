package org.usfirst.frc.team369.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team369.robot.Robot;

public class DriveTrain extends Robot{
	Victor frontLeft;
	Victor backLeft;
	Victor frontRight;
	Victor backRight;
	static RobotDrive myDrive;
//	private RobotDrive driveController;
	Ps4 p4;
	
	
	public void driveTrain(){
		frontLeft = new Victor(1);
		backLeft = new Victor(0);
		frontRight = new Victor(3);
		backRight = new Victor(2);
		myDrive = new RobotDrive(0,1,2,3);
		//		driveController = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		p4 = new Ps4(0);
	}
	
	public void Drive(double leftSpeed, double rightSpeed){
		frontLeft.set(leftSpeed);
		backLeft.set(leftSpeed);
		frontRight.set(rightSpeed);	
		backRight.set(rightSpeed);
	}
	
	
	
	public void rightforward(){
		frontRight.set(1);
		backRight.set(1);
	}
	
	public void leftForward(){
		frontLeft.set(1);
		backLeft.set(1);
	}
	
	public void leftReverse(){
		frontLeft.set(-1);
		backLeft.set(-1);
	}
	

	public double normalize(double Right){
		double V = (Right * 0.5) + 0.5;
		return V;
	}
	
//	public void turnLeft(){
//		frontLeft.set(-1);
//		backLeft.set(-1);
//		frontRight.set(1);
//		backRight.set(1);
//	}
//	public void right(){
//		frontLeft.set(1);
//		backLeft.set(1);
//		frontRight.set(-1);
//		backRight.set(-1);
//	}

}
