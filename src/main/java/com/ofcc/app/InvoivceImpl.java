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
			BigDecimal bgAmt1 = BigDecimal.ZERO;
			BigDecimal bgAmt2 = BigDecimal.ZERO;
			BigDecimal restAmt = BigDecimal.ZERO;
			int j=0;
			for(int i=OfccConstants.ranges.intValue() ; i>0; i--)
			{
				if(invoiceAmt.longValue()>(i-1)*OfccConstants.incriment.longValue())
				{
					bgAmt1=(invoiceAmt.subtract(new BigDecimal((i-1)*OfccConstants.incriment.longValue())));
					bgAmt2 =((OfccConstants.percentage.divide(new BigDecimal(i).multiply(new BigDecimal(100)),2,RoundingMode.HALF_EVEN)));
					bgAmt = bgAmt1.multiply(bgAmt2);
					j=i-1;
					break;
				
				}
			}
			
			for(int i=j ; i>0;i--)
			{
				restAmt = restAmt.add((OfccConstants.incriment.multiply(((OfccConstants.percentage.divide(new BigDecimal(i).multiply(new BigDecimal(100)),2, RoundingMode.HALF_EVEN))))));
			}
			
			fee.setFeeAmt(bgAmt.add(restAmt));

		}
		
		return fee;
	}

}
