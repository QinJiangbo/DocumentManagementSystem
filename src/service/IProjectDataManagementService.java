package service;

import java.util.Map;

public interface IProjectDataManagementService {
	public Map[] query(String tableName);
	public Map[] query(String tableName,String pid);
}
