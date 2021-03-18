package com.userinfo.main.services;

public interface UserServices <T> {
	
	Object save (T t);
	Object edit (long id,T t);
	Object delete(long id);
	Object list();
	
	
}
