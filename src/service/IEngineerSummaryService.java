package service;

import java.util.Map;

import pojo.Engineer_summary;
import pojo.Log;
@SuppressWarnings("rawtypes")
public interface IEngineerSummaryService {
	public boolean add(Engineer_summary engineer_summary);
	public boolean update(Engineer_summary engineer_summary);
	public boolean verify(Engineer_summary engineer_summary);
	public boolean maintenance(Engineer_summary engineer_summary);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Engineer_summary engineer_summary);
	public Map[] query(String pid,String name);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String pid,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultTypeRows();
    public Map[] getDefaultNationRows();
    public Map[] getDefaultPatternRows();
    public Map[] getDefaultBoilerPatternRows();
    public Map[] getAllPid();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}
