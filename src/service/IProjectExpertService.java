package service;

import java.util.Map;

import pojo.Log;
import pojo.Project_expert;
@SuppressWarnings("rawtypes")
public interface IProjectExpertService {
	public boolean add(Project_expert project_expert);
	public boolean update(Project_expert project_expert);
	public boolean verify(Project_expert project_expert);
	public boolean maintenance(Project_expert project_expert);
	public boolean delete(int id);
	public boolean isSubmit(String id);
	public boolean isSave(String id);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Project_expert project_expert);
	public Map[] query(String name,String profession);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String identified_card,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultProfessionRows();
    public Map[] getDefaultEducationBackgroundRows();
    public Map[] getAllName();
    public Map[] getDefaultJobTitleRows();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}
