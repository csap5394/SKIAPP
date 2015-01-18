package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ManagementClass {
	private static List <Person> users; 
	private  List <Lift> lifts;
	private static ManagementClass instance = null;
	private long id; 
	
	private ManagementClass(){
		users = new ArrayList<Person>();
		lifts = new ArrayList<Lift>();
		this.id = 0;
		
	}
	
	public static ManagementClass getInstance(){
		if (instance == null){
		 instance = new ManagementClass();
		}
		return instance;
	}
	/**
	 * legt user an, falls username existiert, wird der kein objekt angelegt
	 * 
	 * @param surname
	 * @param firstname
	 * @param birthday
	 * @param username
	 * @param password
	 * @return
	 */
	
	public boolean registerUser(String surname, String firstname, Date birthday, String username, String password){
		id++;
		Person p = new Person(surname, firstname, id, birthday, null, username, password);
		for(Person per: users){
			if(username.equals(per.getUsername())){
				return false;
			}
		}
		users.add(p);
		return true;
	}
	
	public boolean login(String username, String password){
		for(Person per: users){
			if(username.equals(per.getUsername()) && password.equals(per.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public void importLiftData() {
		lifts = Excel.importLiftData();
		printLifts();
	}
	
	public void printLifts() {
		int counter = 0;
		for(Lift lift: lifts) {
			System.out.println(lift.getName());
			counter++;
		}
		System.out.println(counter);
	}
	
	/**
	 * TODO Perosn herholen
	 * @return
	 */
	public boolean buyNumberConstraint(Person p, int number, List<Lift> lifts){
		for(Lift lift: lifts) {
			if(p.getMap().get(lift) == null) {
				p.getMap().put(lift, new ArrayList<Constraint>());
			}
			/*Map<Lift, List<Constraint>> map = p.getMap();
			List<Constraint> constraints = map.get(lift);
			Constraint c = new NumberConstraint(number);
			constraints.add(c);*/
			p.getMap().get(lift).add(new NumberConstraint(number));
			p.pay(number * NumberConstraint.PRICE);
		}
		return true;
	}
	
	public Person findPerson(String username) {
		for(Person p: users) {
			if(p.getUsername().equals(username)) {
				return p;
			}
		}
		return null;
	}
	
	public Lift findLift(int id) {
		for(Lift lift: lifts) {
			if(lift.getID() == id) {
				return lift;
			}
		}
		return null;
	}
}
