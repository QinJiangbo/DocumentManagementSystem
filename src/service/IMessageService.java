package service;

import java.util.Map;
@SuppressWarnings("rawtypes")
public interface IMessageService {
	public Map[] getUnReadMsg(String name);
	public Map[] query(String name);
	public void DoRead();
	public void delete(int id); 
	public void delete(String name);
	
}
