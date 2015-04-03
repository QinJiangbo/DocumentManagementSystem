package service;

import java.util.Map;
@SuppressWarnings("rawtypes")
public interface IFieldMaintenanceService {
	public boolean changeNewName(String tableName,String oldName,String NewName);
	public boolean Use(String tableName,String NewName,int state);
	public int isUse(String tableName,String oldName);
	public boolean add(String tableName,String NewName,String defaultValue);
	public boolean delete(String tableName,String NewName,String defaultValue);
	public Map[] query(String tableName,String NewName);
	public String getNewName(String tableName,String oldName);
}
