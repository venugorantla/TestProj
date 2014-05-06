/**
 * 
 */
package com.ofcc.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    public void testInvoiceImpltrue()
    {
    	List<Invoice> invoices = new ArrayList<Invoice>();
    	List<Fee> fees = new ArrayList<Fee>();
    	Invoice invoice = new Invoice();
    	invoice.setInvoiceAmt(new BigDecimal("600000"));
    	invoices.add(invoice);
    	InvoiceI invoiceI = new InvoivceImpl();
    	fees = invoiceI.caliculateFee(invoices);
    	assertTrue( fees.get(0).getFeeAmt().longValue()==65000) ;
    	
    }
    
    public void testInvoiceImplListtrue()
    {
    	List<Invoice> invoices = new ArrayList<Invoice>();
    	List<Fee> fees = new ArrayList<Fee>();
    	
    	Invoice invoice = new Invoice();
    	invoice.setInvoiceAmt(new BigDecimal("400000"));
    	invoices.add(invoice);
    	Invoice invoice1 = new Invoice();
    	invoice1.setInvoiceAmt(new BigDecimal("200000"));
    	invoices.add(invoice1);
    	InvoiceI invoiceI = new InvoivceImpl();
    	fees = invoiceI.caliculateFee(invoices);
    	for(Fee fee:fees)
    	{
    		System.out.println("Fees for invoices"+fee.getFeeAmt().longValue());
    	}
    	assertTrue( (fees.get(0).getFeeAmt().add(fees.get(1).getFeeAmt())).longValue()==65000) ;
    	
    }
}
