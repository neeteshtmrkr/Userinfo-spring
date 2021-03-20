package com.userinfo.main.services;



public interface UserServices <T> {
	
	Object save (T t);
	Object edit (long id,T t);
	Object delete(long id);
	Object list();
	Object getById(int id);
	Object find_by_name(String name);
	
	
}
