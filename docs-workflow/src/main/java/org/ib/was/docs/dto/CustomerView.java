package org.ib.was.docs.dto;

public interface CustomerView {

	Long getId();

	String getName();
	
	//@Value("#{target.firstName + ' ' + target.lastName}")
    //String getFullName();
}
