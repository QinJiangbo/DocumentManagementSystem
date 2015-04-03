package service;

import java.util.Map;

import pojo.Log;
import pojo.Pre_engineering_data;
@SuppressWarnings("rawtypes")
public interface IPreEngineeringDataService {
	public boolean add(Pre_engineering_data pre_engineering_data);
	public boolean update(Pre_engineering_data pre_engineering_data);
	public boolean verify(Pre_engineering_data pre_engineering_data);
	public boolean maintenance(Pre_engineering_data pre_engineering_data);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Pre_engineering_data pre_engineering_data);
	public Map[] query(String pid,String type);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String pid,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultTypeRows();
    public Map[] getAllPid();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}
