package service;

import java.util.Map;

import pojo.Log;
import pojo.Photovoltaic_generation_project;
@SuppressWarnings("rawtypes")
public interface IPhotovoltaicGenerationProjectService {
	public boolean add(Photovoltaic_generation_project photovoltaic_generation_project);
	public boolean update(Photovoltaic_generation_project photovoltaic_generation_project);
	public boolean verify(Photovoltaic_generation_project photovoltaic_generation_project);
	public boolean maintenance(Photovoltaic_generation_project photovoltaic_generation_project);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Photovoltaic_generation_project photovoltaic_generation_project);
	public Map[] query(String pid,String name);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String pid,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultTypeRows();
    public Map[] getDefaultNationRows();
    public Map[] getDefaultTotalCapacityRows();
    public Map[] getDefaultPowerSupplyTypeRows();
    public Map[] getDefaultBuildingTypeRows();
    public Map[] getDefaultRunningModeRows();
    public Map[] getDefaultBatteryTypeRows();
    public Map[] getAllPid();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}
