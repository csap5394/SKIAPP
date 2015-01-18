package model;

public class NumberConstraint implements Constraint{
	//in euro
	public static final double PRICE = 5;
	
	private int numEntries;

	
	public NumberConstraint(int numEntries){
		this.numEntries = numEntries;
	}
	@Override
	public boolean checkEntryAllowed() {
		if(getNumEntries() >= 1){
			setNumEntries(numEntries--);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkEligible() {
		if(getNumEntries() >= 1){
			return true;
		}
		return false;
	}
	
	public int getNumEntries() {
		return numEntries;
	}
	
	public void setNumEntries(int numEntries) {
		this.numEntries = numEntries;
	}
	
	

}
