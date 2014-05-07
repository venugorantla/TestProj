package com.ofcc.app;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvoivceImpl implements InvoiceI {

		public Fee caliculateFee(Invoice invoice) {
		
		Fee fee = new Fee();
		// TODO Auto-generated method stub
		if(invoice!=null && invoice.getInvoiceAmt().signum()==1)
		{
			BigDecimal invoiceAmt=invoice.getInvoiceAmt();
			BigDecimal bgAmt = BigDecimal.ZERO;
			BigDecimal restAmt = BigDecimal.ZERO;
			int j=0;
			for(int i=OfccConstants.ranges.intValue() ; i>0; i--)
			{
				if(invoiceAmt.longValue()>(i-1)*OfccConstants.incriment.longValue())
				{
					bgAmt = (invoiceAmt.subtract(new BigDecimal((i-1)*OfccConstants.incriment.longValue()))).multiply((OfccConstants.percentage.divide(new BigDecimal(i),2, RoundingMode.HALF_EVEN)));
					j=i-1;
					break;
				
				}
			}
			
			for(int i=j ; i>0;i--)
			{
				restAmt = restAmt.add((OfccConstants.incriment.multiply(((OfccConstants.percentage.divide(new BigDecimal(i),2, RoundingMode.HALF_EVEN))))));
			}
			
			fee.setFeeAmt(bgAmt.add(restAmt));
			System.out.println("bg fee"+bgAmt.longValue());
			System.out.println("rest fee"+restAmt.longValue());
			System.out.println("Total fee"+fee.getFeeAmt().longValue());
			/*if( invoiceAmt.longValue() <= CONSTANT_100THOUSAND.longValue() )
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
				
			}*/
		}
		
		return fee;
	}

}
