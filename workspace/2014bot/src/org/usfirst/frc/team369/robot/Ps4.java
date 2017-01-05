package org.usfirst.frc.team369.robot;

import java.util.HashMap;
import edu.wpi.first.wpilibj.Joystick;

public class Ps4 extends Joystick{
	private HashMap<Integer, Boolean> past = new HashMap<Integer, Boolean>();
	
	public Ps4(int port){
		super(port);
	}
	
	public void
	updateButtonsPast(int button){
		past.put(button,  this.getRawButton(button));
	}
	
	public boolean getButtonClicked(int button){
		if(this.getRawButton(button) && !past.get(button)){
			return true;
		}
		
		return false;
	}
	
	static class buttons{
		static int 
		square = 1,
		x = 2,
		circle = 3,
		triangle = 4,
		L1 = 5,
		R1 = 6,
		L2 = 7,
		R2 = 8,
		share = 9,
		options = 10,
		L3 = 11,
		R3 = 12,
		ps = 13,
		touchpad = 14,
		//analog
		leftX = 0,
		leftY = 1,
		rightX = 2,
		L2Analog = 3,
		R2Analog = 4,
		rightY = 5;
	}
//	public double getAxis(int axis){
//		this.getRawAxis(axis) && !past.get(axis){
//			return;
//		}
//	}
}
