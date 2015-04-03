package service;

import java.util.Map;

import pojo.Log;
import pojo.Other;
@SuppressWarnings("rawtypes")
public interface IOtherService {
	public boolean add(Other other);
	public boolean update(Other other);
	public boolean verify(Other other);
	public boolean maintenance(Other other);
	public boolean delete(int id);
	public boolean isSubmit(String id);
	public boolean isSave(String id);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Other other);
	public Map[] query(String name);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String id,int state);
	
	//以下是该类独有的方法
    public Map[] getAllLecture();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}
