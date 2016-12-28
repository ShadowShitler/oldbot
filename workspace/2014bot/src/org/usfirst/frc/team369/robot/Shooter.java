package org.usfirst.frc.team369.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;

import java.sql.Time;
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
	

	
	public void shooter(){
		shootTop = new Victor(5);
        shootBot = new Victor(4);
        LoadingRelay = new Relay(0);
        PP = new DoubleSolenoid (1,2);
        limit = new DigitalInput(0);
        motorsOn = false;
        
	}

	public void load(){
		if(isLoaded == false){
			PPdown();
			LoadingRelay.set(Relay.Value.kForward);
			Timer.delay(.25);
			LoadingRelay.set(Relay.Value.kOff);
			isLoaded = true;
		}
		
			
	}
	
	public void getReady(){
		shootTop.set(1);
		shootBot.set(.5);
		if (motorsOn == false){
			motorsStarted = Timer.getFPGATimestamp();
			motorsOn = true;
		}	
	}

	public void shoot(int x){
		getReady();
		newStamp = Timer.getFPGATimestamp();
		
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
	}
	
	public void PPdown(){
		PP.set(DoubleSolenoid.Value.kReverse);
	}

	public void stopShootMotors(){
		shootTop.set(0);
		shootBot.set(0);
		motorsOn = false;
	}
	
//	public boolean isPPdown(){
//		return limit.get();
//	}
}
