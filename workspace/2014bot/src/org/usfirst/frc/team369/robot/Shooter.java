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
	double motorsStarted;
	double newStamp;
	
	Timestamp motorsstarted;
	Timestamp newstamp;
	
	public void shooter(){
		shootTop = new Victor(1);
        shootBot = new Victor(2);
        LoadingRelay = new Relay(0);
        PP = new DoubleSolenoid (1,2);
        limit = new DigitalInput(0);
        
	}

	public void load(){
		if(isLoaded == false){
			PPdown();
		}
		
			
	}
	
	public void getReady(){
		shootTop.set(1);
		shootBot.set(.5);
		motorsOn = true;
		if (motorsOn == false){
			motorsStarted = motorsstarted.getTime();

		}	
	}

	public void shoot(int x){
		getReady();
		newStamp = newstamp.getTime();
		
		for (int i = 0; i < x;){
			PPdown();
			load();
		if (newStamp - motorsStarted < .5){
			PPup();
			isLoaded = false;
			i++;
		}
		}
	}

	public void PPup(){
		PP.set(DoubleSolenoid.Value.kForward);
		Timer.delay(.75);
		PP.set(DoubleSolenoid.Value.kOff);
	}
	
	public void PPdown(){
		if (!limit.get()){
			PP.set(DoubleSolenoid.Value.kReverse);
		}
		else if(limit.get()){
			PP.set(DoubleSolenoid.Value.kOff);
		}
	}

	public void stopShootMotors(){
		shootTop.set(0);
		shootBot.set(0);
	}
}




