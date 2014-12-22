package model;

import java.util.ArrayList;
import java.util.List;

public class Lift {
	//private Person person;
	private String Name;
	private int ID;
	private int PLZ;
	//art des Lift (schlepplift, etc...)
	private String typ;
	// anzahl der pläzte im lift
	private int numberPlaces;
	// anzal der nicht privilegierten plätze, die zur verfügung stehen
	private int nonPriorityPlaces;
	// wie schnell sich der Lift dreht, wie oft sich die schranken drehen
	private double barOpeningInterval;
	// wieviele personen befinden sich in der priorityqueue
	private int personInQueue;
	//wieviel plätze stehen max in der prioQueue zur verfügung
	private int maxPriorityPlaces;
	//setzt die tatsächlich zu öffnende anzahl von priorityplätzen
	private int setPriorityPlaces;


	private ArrayList person;
	//List <Person> allowedPersonLift = new ArrayList<Person>();
	
	public Lift(int maxPriorityPlaces, int numberPlaces){
		person = new ArrayList();
		this.personInQueue = 0;
		this.maxPriorityPlaces = maxPriorityPlaces;
		this.numberPlaces = numberPlaces;
	}
	
	//wenn sich person registriert, hänge ihn an liste an
	public void registerPerson(Person p){
		person.add(p);
	}
	
	public void incrementQueue(){
		for(int i = 0; i < person.size(); i++){
			Person p = (Person)person.get(i);
			if (p.getNumConstrait().checkEntryAllowed() == false) {
				int j = person.indexOf(p);
				if(j >= 0){
					person.remove(j);
				}
				else {
					personInQueue++;
				}
			}
		}
		
	}
	
	public void decrementQueue(){

	}
	/**
	 * Wenn weniger in der Queue sind als MAXPriorityPlätze verfügbar, werden <= 
	 * PriorytySchranken freigegegbbn und die Queue auf Null gesetzt. Dafür die Mehrdifferenz
	 * der PriorityPlätze auf die nicht PriorityPlätze umverteilt
	 * 
	 * Falls mehr in der PriorityQueue vorhanden ist, als MAXPriorityPlätze, so werden immer nur
	 * die MAXmimale Anzahl an PriorityPlätzen freigegeben und die Differenz an nichtPriorityPlätzen
	 * überschreitet nicht die Differenz
	 * @return
	 */
	public void maxOpenPlaces(){
		if(personInQueue <= maxPriorityPlaces){
			setNonPriorityPlaces(getNumberPlaces() - personInQueue);
			openNonPriorPlaces(getNonPriorityPlaces());
			openPriorPlaces(getPersonInQueue());
			setPersonInQueue(0);
			
		}
		if(personInQueue >= maxPriorityPlaces){
			setNonPriorityPlaces(getNumberPlaces() - maxPriorityPlaces);
			openNonPriorPlaces(getNonPriorityPlaces());
			openPriorPlaces(maxPriorityPlaces);
			setPersonInQueue(getPersonInQueue() - getSetPriorityPlaces());
		}
		
			
	}
	

	private void openPriorPlaces(int personInQueue2) {
		// TODO Auto-generated method stub
		
	}

	private void openNonPriorPlaces(int personInQueue2) {
		// TODO Auto-generated method stub
		
	}

	public int getNumberPlaces() {
		return numberPlaces;
	}

	public void setNumberPlaces(int numberPlaces) {
		this.numberPlaces = numberPlaces;
	}

	public int getNonPriorityPlaces() {
		return nonPriorityPlaces;
	}

	public void setNonPriorityPlaces(int nonPriorityPlaces) {
		this.nonPriorityPlaces = nonPriorityPlaces;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getPLZ() {
		return PLZ;
	}

	public void setPLZ(int pLZ) {
		PLZ = pLZ;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public int getNumberPlaes() {
		return numberPlaces;
	}

	public void setNumberPlaes(int numberPlaces) {
		this.numberPlaces = numberPlaces;
	}

	public double getBarOpeningInterval() {
		return barOpeningInterval;
	}

	public void setBarOpeningInterval(double barOpeningInterval) {
		this.barOpeningInterval = barOpeningInterval;
	}

	public int getPersonInQueue() {
		return personInQueue;
	}

	public void setPersonInQueue(int personInQueue) {
		this.personInQueue = personInQueue;
	}

	public int getMaxPriorityPlaces() {
		return maxPriorityPlaces;
	}

	public void setMaxPriorityPlaces(int maxPriorityPlaces) {
		this.maxPriorityPlaces = maxPriorityPlaces;
	}

	public ArrayList getPerson() {
		return person;
	}

	public void setPerson(ArrayList person) {
		this.person = person;
	}
	public int getSetPriorityPlaces() {
		return setPriorityPlaces;
	}

	public void setSetPriorityPlaces(int setPriorityPlaces) {
		this.setPriorityPlaces = setPriorityPlaces;
	}
	
	
	

}
