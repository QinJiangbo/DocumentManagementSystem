package service;

import java.util.Map;

import pojo.Fuel_machine_project;
import pojo.Log;
@SuppressWarnings("rawtypes")
public interface IFuelMachineProjectService {
	public boolean add(Fuel_machine_project fuel_machine_project);
	public boolean update(Fuel_machine_project fuel_machine_project);
	public boolean verify(Fuel_machine_project fuel_machine_project);
	public boolean maintenance(Fuel_machine_project fuel_machine_project);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Fuel_machine_project fuel_machine_project);
	public Map[] query(String pid,String name);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
	public int getId(String pid,int state);
	
	//以下是该类独有的方法
	public Map[] getDefaultTypeRows();
	public Map[] getDefaultNationRows();
	public Map[] getDefaultWaterSourceRows();
	public Map[] getDefaultFuelPowerStationPatternRows();
	public Map[] getDefaultFuelStationFuelTypeRows();
	public Map[] getDefaultFuelMachineLevelRows();
	public Map[] getDefaultWasteHeatBoilerCirculateTypeRows();
	public Map[] getDefaultWasteHeatBoilerStructureTypeRows();
	public Map[] getDefaultWasteHeatBoilerAfterburningTypeRows();
	public Map[] getDefaultCombinedCirculationAeratedWaterSystemPatternRows();
	public Map[] getDefaultCombinedCirculationMainframeLayoutPatternRows();
	public Map[] getAllPid();
	
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
  	public Map[] getDefaultPreparationSixRows();
  	public Map[] getDefaultPreparationSevenRows();
  	public Map[] getDefaultPreparationEightRows();
  	public Map[] getDefaultPreparationNineRows();
  	public Map[] getDefaultPreparationTenRows();
}
