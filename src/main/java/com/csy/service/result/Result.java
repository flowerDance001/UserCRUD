package com.csy.service.result;

import java.io.Serializable;

public interface Result extends Serializable {
	
	public boolean isSuccess();
	
	public boolean isExecuted();
	
	public String getMessage();
	
}
