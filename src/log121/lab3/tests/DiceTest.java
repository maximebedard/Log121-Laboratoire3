package log121.lab3.tests;

import static org.junit.Assert.*;
import log121.lab3.api.Dice;

import org.junit.Before;
import org.junit.Test;

public class DiceTest {

	private Dice de1;
	private Dice de2;

	@Before
	public void createDicesTest(){
		de1 = new Dice(6);
		de2 = new Dice(6);
	}

	@Test
	public void superiorTest(){
		de1.setValue(4);
		de2.setValue(5);
		assertTrue(de1.compareTo(de2)==1);
	}

	@Test
	public void inferiorTest(){
		de1.setValue(4);
		de2.setValue(5);
		assertTrue(de2.compareTo(de1)==-1);
	}

	@Test
	public void sameTest(){
		de1.setValue(4);
		assertTrue(de1.compareTo(de1)==0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void nullTest(){
		de1.setValue(4);
		de1.compareTo(null);
	}
}