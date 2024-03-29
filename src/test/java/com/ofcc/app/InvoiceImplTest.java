/**
 * 
 */
package com.ofcc.app;

import java.math.BigDecimal;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author venu  gorantla
 *
 */
public class InvoiceImplTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InvoiceImplTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( InvoiceImplTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testInvoiceImpltrue1()
    {
    	Invoice invoice = new Invoice();
    	invoice.setInvoiceAmt(new BigDecimal("200000"));
    	InvoiceI invoiceI = new InvoivceImpl();
    	Fee fee = invoiceI.caliculateFee(invoice);
        assertTrue( fee.getFeeAmt().longValue()==30000) ;
    	 
    }
    
    public void testInvoiceImpltrue2()
    {
    	Invoice invoice = new Invoice();
    	invoice.setInvoiceAmt(new BigDecimal("50000"));
    	InvoiceI invoiceI = new InvoivceImpl();
    	Fee fee = invoiceI.caliculateFee(invoice);
    	assertTrue( fee.getFeeAmt().longValue()==10000);
    	
    }
}
