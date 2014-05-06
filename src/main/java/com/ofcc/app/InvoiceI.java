package com.ofcc.app;

import java.util.List;

public interface InvoiceI {
	
	public List<Fee> caliculateFee(List<Invoice> invoices);

}
