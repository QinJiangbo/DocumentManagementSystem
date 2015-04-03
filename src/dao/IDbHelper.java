package dao;

import java.util.Map;

@SuppressWarnings("rawtypes")
public interface IDbHelper {

	//run the select SQL with parameters
	public Map[] select(String sql,Object[] params);
	//run the select SQL without parameters
	public Map[] select(String sql);
	//run the update SQL without parameters
	public void update(String sql);
	//run the update SQL with parameters
	public void update(String sql,Object[] params);
}
