package com.ofcc.app;

import java.math.BigDecimal;

public class InvoivceImpl implements InvoiceI {

	private static final BigDecimal CONSTANT_100THOUSAND = new BigDecimal("100000");
	
	

	public Fee caliculateFee(Invoice invoice) {
		
		Fee fee = new Fee();
		// TODO Auto-generated method stub
		if(invoice!=null && invoice.getInvoiceAmt().signum()==1)
		{
			BigDecimal invoiceAmt=invoice.getInvoiceAmt();
			if( invoiceAmt.longValue() > CONSTANT_100THOUSAND.longValue() )
			{
				
				fee.setFeeAmt(invoiceAmt.multiply(new BigDecimal("0.2")));
			}
			else
			{
				BigDecimal bgAmt = invoice.getInvoiceAmt().subtract(CONSTANT_100THOUSAND);
				fee.setFeeAmt(
						new BigDecimal("100000").multiply(new BigDecimal("0.2")).add((bgAmt.multiply(new BigDecimal("0.1"))))
						);
				
			}
		}
		
		return fee;
	}

}
