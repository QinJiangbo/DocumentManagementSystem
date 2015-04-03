package service;

import java.util.Map;

import pojo.Log;
@SuppressWarnings("rawtypes")
public interface ILogService {
	public Map[] getAllLog();
	public Map[] getAllLog(String uname);
	public void add(Log log);
	public void delete(int id);
	public void delete(String fromTime,String EndTime);
	public void delete(String name,String fromTime,String EndTime);
	
}
