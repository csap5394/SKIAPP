package model;

import java.util.Date;

public class Person{
	private String name;
	private long id;
	private Date birthday;
	private Payment paymentMethode;
	private NumberConstraint numConstrait;
	private TimeConstraint timeConstrait;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Payment getPaymentMethode() {
		return paymentMethode;
	}
	public void setPaymentMethode(Payment paymentMethode) {
		this.paymentMethode = paymentMethode;
	}
	public NumberConstraint getNumConstrait() {
		return numConstrait;
	}
	public void setNumConstrait(NumberConstraint numConstrait) {
		this.numConstrait = numConstrait;
	}
	public TimeConstraint getTimeConstrait() {
		return timeConstrait;
	}
	public void setTimeConstrait(TimeConstraint timeConstrait) {
		this.timeConstrait = timeConstrait;
	}
	

}
