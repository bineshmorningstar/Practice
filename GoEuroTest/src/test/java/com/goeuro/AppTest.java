package com.goeuro;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
	public void testEntryPointInit() throws Exception{
		EntryPoint entryPoint = new EntryPoint();
		try {
			entryPoint.getCityData(null);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertFalse("Exception at entry point", false);
		}
		
	}
}
