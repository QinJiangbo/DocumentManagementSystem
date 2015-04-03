package service;

import java.util.Map;

import pojo.Log;
import pojo.Technology_essay;
@SuppressWarnings("rawtypes")
public interface ITechnologyEssayService {
	public boolean add(Technology_essay technology_essay);
	public boolean update(Technology_essay technology_essay);
	public boolean verify(Technology_essay technology_essay);
	public boolean maintenance(Technology_essay technology_essay);
	public boolean delete(int id);
	public boolean isSubmit(String id);
	public boolean isSave(String id);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Technology_essay technology_essay);
	public Map[] query(String name,String profession);
	public Map[] query(String name);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String entry_time,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultProfessionRows();
    public Map[] getAllName();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}
