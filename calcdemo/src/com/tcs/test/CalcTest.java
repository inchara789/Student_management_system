package com.tcs.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tcs.calc.Calculator;

public class CalcTest {

	@Test
	public void addtest() {
		Calculator c=new Calculator();
		int actual=c.add(5,5);
		assertEquals(10, actual);
		
	}
	
	@Test
	public void multiplyTest()
	{
		Calculator c=new Calculator();
		int actual=c.multi(4, 5);
		assertEquals(20, actual);
	}
	@Test
	public void divideTest()
	{
		Calculator c=new Calculator();
		int actual=c.divide(5, 1);
		assertEquals(5, actual);
	}
	
	@Test(expected=ArithmeticException.class)
	public void dividebyzeroTest()
	{
		Calculator c=new Calculator();
		int actual=c.divide(4, 0);
		//assertEquals(20, actual);
	}

}