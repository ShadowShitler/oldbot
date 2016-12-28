package org.usfirst.frc.team369.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;
import java.sql.Timestamp;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;



public class Shooter{
	
	Victor shootTop;
	Victor shootBot;
	Relay LoadingRelay;
	DoubleSolenoid PP;
	DigitalInput limit;
	Timer RelayTime;
	boolean isLoaded = true;
	boolean motorsOn;
	Timestamp motorsstarted;
	Timestamp newStamp;
	
	public void shooter(){
		shootTop = new Victor(1);
        shootBot = new Victor(2);
        LoadingRelay = new Relay(0);
        PP = new DoubleSolenoid (1,2);
        limit = new DigitalInput(0);
        
	}

	public void load(){
		if(isLoaded == false){
			PP.set(DoubleSolenoid.Value.kReverse);
			Timer.delay(.75);
			PP.set(DoubleSolenoid.Value.kOff);
		}
		
			
	}
	
	public void getReady(){
		shootTop.set(1);
		shootBot.set(.5);
		motorsOn = true;
		if (motorsOn == false){
			motorsstarted.getTime();
			motorsstarted.equals(motorsstarted);
		}	
	}

	public void shoot(int x){
		getReady();
		newStamp.getTime();
		newStamp.equals(newStamp);
		for (int i = 0; i < x;){
			PP.set(DoubleSolenoid.Value.kReverse);
			load();
		if (newStamp.compareTo(motorsstarted) < .5){
			PP.set(DoubleSolenoid.Value.kForward);
			isLoaded = false;
			i++;
		}
		}
	}

}




