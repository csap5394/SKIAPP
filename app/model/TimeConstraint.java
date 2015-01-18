package model;

import java.util.Calendar;
import java.util.Date;



public class TimeConstraint implements Constraint{
	private Calendar howLong;
	
	
	
	public TimeConstraint(Calendar howLong){
		this.howLong = howLong;
	}
	
	@Override
	public boolean checkEntryAllowed() {
		return checkEligible();
	}


	/**
	 * prueft ob tages/halbtageskarte gueltig ist
	 * cmp == 0: zeit ist gleich
	 * cmp < 0:  zeit ist ok
	 * cmp >: zeit ist abgelaufen 
	 */
	@Override
	public boolean checkEligible() {
		Calendar now = Calendar.getInstance();
		int cmp = now.compareTo(howLong);
		if(cmp == 0) {
			return false;
		} else if(cmp < 0) {
			return true;
		} else {
			return false;
		}
	}

	public Calendar getHowLong() {
		return howLong;
	}

	public void setHowLong(Calendar howLong) {
		this.howLong = howLong;
	}




}
