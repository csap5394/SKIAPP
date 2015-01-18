package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lift {
	//private Person person;
	private String Name;
	private int ID;
	private int PLZ;
	//art des Lift (schlepplift, etc...)
	private String typ;
	// anzahl der pläzte im lift
	private int numberPlaces;
	// anzahl der nicht privilegierten plätze, die zur verfügung stehen
	private int nonPriorityPlaces;
	// wie schnell sich der Lift dreht, wie oft sich die schranken drehen
	private double barOpeningInterval;
	// wieviele personen befinden sich in der priorityqueue
	private int personInQueue;
	//wieviel plätze stehen max in der prioQueue zur verfügung
	private int maxPriorityPlaces;
	//setzt die tatsächlich zu öffnende anzahl von priorityplätzen
	private int setPriorityPlaces;


	private List <Person> person;
	//List <Person> allowedPersonLift = new ArrayList<Person>();

	public Lift() {
		person = new ArrayList<Person>();
		this.personInQueue = 0;
	} 

	public Lift(int maxPriorityPlaces, int numberPlaces){
		this();
		this.maxPriorityPlaces = maxPriorityPlaces;
		this.numberPlaces = numberPlaces;
	}
	
	
	
	//wenn sich person registriert, hänge ihn an liste an
	public void registerPerson(Person p){
		person.add(p);
	}
	
	/**
	 *  kontrolliert ob person für zugang berechtigt ist. Falls nicht, 
	 *  wird Object in toBeDelted zwischengespeichert und anschließend
	 *  aus der liste person geloescht.
	 *  
	 *  TODO: Funktion wird peridisch aufgerufen 
	 *  
	 */
	public void checkPeople(){
		List <Person> toBeDeleted = new ArrayList<Person>();
		for(int i = 0; i < person.size(); i++){
			Person p = (Person)person.get(i);
			Map<Lift, List<Constraint>> map = p.getMap();
			boolean remove = true;
			for(Lift lift: map.keySet()) {
				if(lift.equals(this)) {
					List<Constraint> constraints = map.get(lift);
					for(Constraint constraint: constraints) {
						if(constraint.checkEligible()) {
							remove = false;
							break;
						}
					}
				}
			}
			
			if (remove) {
				toBeDeleted.add(p);
			}
		}
		for(Person p: toBeDeleted) {
			person.remove(p);
		}
	}
	
	public void incrementQueue(){
		personInQueue++;
		
	}
	
	public void decrementQueue(){
		personInQueue--;
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
		if(personInQueue < maxPriorityPlaces){
			setNonPriorityPlaces(getNumberPlaces() - personInQueue);
			openNonPriorPlaces(getNonPriorityPlaces());
			openPriorPlaces(getPersonInQueue());
			
			
		}
		else {
			setNonPriorityPlaces(getNumberPlaces() - maxPriorityPlaces);
			openNonPriorPlaces(getNonPriorityPlaces());
			openPriorPlaces(maxPriorityPlaces);
		}
		
			
	}
	
	/**
	 * Theoretische Mehtoden, die nicht ausgeführt werden kann
	 * @param personInQueue2 anzahl der zu oeffnenden tueren, der
	 * prioroty plaetze 
	 */
	private void openPriorPlaces(int personInQueue2) {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * Theoresche Methode, die nicht ausgeführt werden kann
	 * @param personInQueue2 azhal der zu oeffnend. tueren, der
	 * nicht piror. plaetze 
	 */
	private void openNonPriorPlaces(int personInQueue2) {
		// TODO Auto-generated method stub
		
	}

	public int getNumberPlaces() {
		return numberPlaces;
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

	public void setNumberPlaces(int numberPlaces) {
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

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
	public int getSetPriorityPlaces() {
		return setPriorityPlaces;
	}

	public void setSetPriorityPlaces(int setPriorityPlaces) {
		this.setPriorityPlaces = setPriorityPlaces;
	}
	
	
	

}
