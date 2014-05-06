package com.ofcc.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class InvoivceImpl implements InvoiceI {

	private static final BigDecimal CONSTANT_100THOUSAND = new BigDecimal("100000");
	private static final BigDecimal CONSTANT_500THOUSAND = new BigDecimal("500000");
	

	public List<Fee> caliculateFee(List<Invoice> invoices) {
		
		List<Fee> fees = new ArrayList<Fee>();
		// TODO Auto-generated method stub
		if(!invoices.isEmpty())
		{
				Invoice invoice=null;
				BigDecimal invAmt = new BigDecimal(0);
				Fee fee = new Fee();
				
				if(invoices.size()==1)
				{
					invoice= invoices.get(0);
				}
				else
				{
					
					for(Invoice invoices2:invoices)
					{
						invAmt = invAmt.add(invoices2.getInvoiceAmt());
					}
					invoice = new Invoice();
					invoice.setInvoiceAmt(invAmt);
				}
				
				
				if(invoice!=null && invoice.getInvoiceAmt().signum()==1)
				{
					BigDecimal invoiceAmt=invoice.getInvoiceAmt();
					if( invoiceAmt.longValue() <= CONSTANT_100THOUSAND.longValue() )
					{
						
						fee.setFeeAmt(invoiceAmt.multiply(new BigDecimal("0.2")));
					}
					else if(invoiceAmt.longValue() > CONSTANT_100THOUSAND.longValue() && invoiceAmt.longValue() <= CONSTANT_500THOUSAND.longValue())
					{
						BigDecimal bgAmt = invoice.getInvoiceAmt().subtract(CONSTANT_100THOUSAND);
						fee.setFeeAmt(
								new BigDecimal("100000").multiply(new BigDecimal("0.2")).add((bgAmt.multiply(new BigDecimal("0.1"))))
								);
						
					}
					else
					{
						BigDecimal bgAmt = invoice.getInvoiceAmt().subtract(CONSTANT_500THOUSAND);
						fee.setFeeAmt(
								new BigDecimal("100000").multiply(new BigDecimal("0.2")).add((new BigDecimal("400000").multiply(new BigDecimal("0.1")))).add(bgAmt.multiply(new BigDecimal("0.05")))
								);
						
					}
				}
				if(invoices.size()==1)
				{
					fees.add(fee);
				}
				else if (invoice!=null && invoice.getInvoiceAmt().signum()==1)
				{
					for(Invoice invoices3:invoices)
					{
						BigDecimal bgFee = new BigDecimal(0);
						Fee fee2 = new Fee();
						bgFee = (invoices3.getInvoiceAmt().divide(invAmt,2,RoundingMode.HALF_EVEN)).multiply(fee.getFeeAmt());
						fee2.setFeeAmt(bgFee);
						fees.add(fee2);
					}
				}
			
		}
		return fees;
	}

}
