package service;

import java.util.Map;

import pojo.Company_technology_achievement;
import pojo.Log;
@SuppressWarnings("rawtypes")
public interface ICompanyTechnologyAchievementService {
	public boolean add(Company_technology_achievement company_technology_achievement);
	public boolean update(Company_technology_achievement company_technology_achievement);
	public boolean verify(Company_technology_achievement company_technology_achievement);
	public boolean maintenance(Company_technology_achievement company_technology_achievement);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Company_technology_achievement company_technology_achievement);
	public Map[] query(String name,String profession);
	public Map[] query(String name);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String pid,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultProfessionRows();
    public Map[] getDefaultCompleteTimeRows();
    public Map[] getAllName();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}
