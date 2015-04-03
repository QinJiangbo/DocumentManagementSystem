package service;

import java.util.Map;

import pojo.Log;
import pojo.Power_deliver_project;
@SuppressWarnings("rawtypes")
public interface IPowerDeliverProjectService {
	public boolean add(Power_deliver_project power_deliver_project);
	public boolean update(Power_deliver_project power_deliver_project);
	public boolean verify(Power_deliver_project power_deliver_project);
	public boolean maintenance(Power_deliver_project power_deliver_project);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Power_deliver_project power_deliver_project);
	public Map[] query(String pid,String name);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String pid,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultNameRows();
    public Map[] getDefaultTypeRows();
    public Map[] getDefaultNationRows();
    public Map[] getDefaultLineVoltageLevelRows();
    public Map[] getDefaultDesignWindSpeedRows();
    public Map[] getDefaultIcingThicknessRows();
    public Map[] getDefaultLandformRows();
    public Map[] getDefaultWirePatternRows();
    public Map[] getDefaultWireDivideNumberRows();
    public Map[] getDefaultWireCrossSectionRows();
    public Map[] getDefaultLoopNumbersRows();
    public Map[] getAllPid();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}
