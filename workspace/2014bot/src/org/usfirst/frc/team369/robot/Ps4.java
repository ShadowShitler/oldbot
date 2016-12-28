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
}
