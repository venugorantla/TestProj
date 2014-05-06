/**
 * 
 */
package com.ofcc.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author venu  gorantla
 *
 */
public class InvoiceTest extends TestCase {

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InvoiceTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( InvoiceTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testInvoice()
    {
        assertTrue( true );
    	
    }
}
