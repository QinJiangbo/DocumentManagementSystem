package service;

import java.util.Map;

import pojo.Home_broad_standard;
import pojo.Log;
@SuppressWarnings("rawtypes")
public interface IHomeBroadStandardService {
	public boolean add(Home_broad_standard home_broad_standard);
	public boolean update(Home_broad_standard home_broad_standard);
	public boolean verify(Home_broad_standard home_broad_standard);
	public boolean maintenance(Home_broad_standard home_broad_standard);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Home_broad_standard home_broad_standard);
	public Map[] query(String pid,String name);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String pid,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultNationRows();
    public Map[] getDefaultProfessionRows();
    public Map[] getAllPid();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}
