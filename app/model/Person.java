package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person{
	private String surname;
	private String firstname;
	private long id;
	private Date birthday;
	private Payment paymentMethode;
	private String username;
	private String password;
	private Map<Lift, List<Constraint>> map;
	
	
	public Person(String surname, String firstname, long id, Date birthday, Payment paymentMethode, String username, String password){
		this.surname = surname;
		this.firstname = firstname;
		this.id = id;
		this.birthday = birthday;
		this.paymentMethode = paymentMethode;
		this.username = username;
		this.password = password;
		map = new HashMap<Lift, List<Constraint>>();
	}
	
	/**
	 * prueft ob lift vorahndne ist, wenn ja wird constraint hinzugefuegt,
	 * wenn nicht, wird eine Liste tmp erstellt. Der constraint wird hinzugefuegt
	 * und dann in die map in der Liste hinzugefuegt.
	 *
	 *
	 * @param lift
	 * @param constraint
	 */
	public void addConstraint(Lift lift, Constraint constraint){
		if (map.get(lift) != null){
			map.get(lift).add(constraint);
		}else {
			List<Constraint> tmp = new ArrayList<Constraint>();
			tmp.add(constraint);
			map.put(lift, tmp);
		}
		
	}
	
	public Map<Lift, List<Constraint>> getMap() {
		return map;
	}

	public void setMap(Map<Lift, List<Constraint>> map) {
		this.map = map;
	}



	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public void pay(double amount) {
		this.paymentMethode.transferMoney(amount);
	}
	

}
