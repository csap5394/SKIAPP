package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import model.Constraint;
import model.Lift;
import model.ManagementClass;
import model.NumberConstraint;
import model.Payment;
import model.Person;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class purchasePlaceTest {
	static ManagementClass mc;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mc =  ManagementClass.getInstance();
		mc.importLiftData();
		mc.registerUser("tomtom", "felix", new Date(1985-05-05), "user1", "1234");
		Person p = mc.findPerson("user1");
		p.setPaymentMethode(new Payment("Bankeinzug", 200));
	}

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Description
	 * */
	@Test
	public void testPurchase() {
		Person p = mc.findPerson("user1");
		List<Lift> lifts = new ArrayList<Lift>();
		Lift lift1 = mc.findLift(6778);
		lifts.add(lift1);
		Lift lift2 = mc.findLift(4847);
		lifts.add(lift2);
		double initialCredit = p.getPaymentMethode().getCredit();
		mc.buyNumberConstraint(p, 3, lifts);
		//start testing
		Map<Lift, List<Constraint>> map = p.getMap();
		//check whether exactly one constraint per lift has been created
		assertEquals(map.get(lift1).size(), 1);
		assertEquals(map.get(lift2).size(), 1);
		//check whether each newly created number constraint has number entries 3
		assertTrue(map.get(lift1).get(0) instanceof NumberConstraint);
		NumberConstraint c = (NumberConstraint)map.get(lift1).get(0);
		assertEquals(c.getNumEntries(), 3);
		
		assertTrue(map.get(lift2).get(0) instanceof NumberConstraint);
		c = (NumberConstraint)map.get(lift1).get(0);
		assertEquals(c.getNumEntries(), 3);
		//check whether proper amount has been paid
		double currentCredit = p.getPaymentMethode().getCredit();
		assertTrue(currentCredit == initialCredit - (2 * 3 * NumberConstraint.PRICE));
	}

}
