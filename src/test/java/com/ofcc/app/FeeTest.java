package com.ofcc.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FeeTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FeeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FeeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testFee()
    {
        assertTrue( true );
    	
    }
}
