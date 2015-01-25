package com.tbs.general;

import java.io.Serializable;

public abstract interface DTO extends  Serializable{
	
	Long getID();
	void setID(Long ID);
	
}
