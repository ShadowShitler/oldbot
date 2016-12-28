package org.usfirst.frc.team369.robot;

import edu.wpi.first.wpilibj.Victor;

public class DriveTrain{
	Victor frontLeft;
	Victor backLeft;
	Victor frontRight;
	Victor backRight;
	
	public void driveTrain(){
		frontLeft = new Victor(2);
		backLeft = new Victor(3);
		frontRight = new Victor(4);
		backRight = new Victor(5);
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