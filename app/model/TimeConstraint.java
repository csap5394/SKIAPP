package model;

import java.util.Date;



public class TimeConstraint implements Constraint{
	private Date howLong;
	
	public TimeConstraint(Date howLong){
		this.howLong = howLong;
	}
	
	@Override
	public boolean checkEntryAllowed() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean checkEligible() {
		// TODO Auto-generated method stub
		return false;
	}



	
	public Date getHowLong() {
		return howLong;
	}

	public void setHowLong(Date howLong) {
		this.howLong = howLong;
	}





}
