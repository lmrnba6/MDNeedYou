package com.riadh.mdneedyou.genric;

import java.util.List;

public interface Executer<T> {

	public void add(T var1);

	public void update(T var1);

	public List<T> list();

	public T getById(Long var1);

	public T getByName(String var1);

	public void remove(Long var1);

	
}
