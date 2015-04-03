package service;

import java.util.Map;

import pojo.Log;
import pojo.Power_transfer_engineering_project;
@SuppressWarnings("rawtypes")
public interface IPowerTransferEngineeringProjectService {
	public boolean add(Power_transfer_engineering_project power_transfer_engineering_project);
	public boolean update(Power_transfer_engineering_project power_transfer_engineering_project);
	public boolean verify(Power_transfer_engineering_project power_transfer_engineering_project);
	public boolean maintenance(Power_transfer_engineering_project power_transfer_engineering_project);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Power_transfer_engineering_project power_transfer_engineering_project);
	public Map[] query(String pid,String name);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String pid,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultTypeRows();
    public Map[] getDefaultNationRows();
    public Map[] getDefaultPowerTransferTypeRows();
    public Map[] getDefaultSingleMainTransformationCapacityRows();
    public Map[] getDefaultMainTransformationNumberRows();
    public Map[] getDefaultMainTransformationPrimarySideVoltageRows();
    public Map[] getDefaultMainTransformationSecondSideVoltageRows();
    public Map[] getDefaultMainTransformationThirdWindingVoltageRows();
    public Map[] getDefaultMainTransformationPrimarySideVoltagePowerDistributionMainWireRows();
    public Map[] getDefaultMainTransformationSecondSideVoltagePowerDistributionMainWireRows();
    public Map[] getDefaultMainTransformationThirdWindingVoltagePowerDistributionMainWireRows();
    public Map[] getDefaultMainTransformationPrimarySideVoltagePowerDistributionPatternRows();
    public Map[] getDefaultMainTransformationSecondSideVoltagePowerDistributionPatternRows();
    public Map[] getDefaultMainTransformationThirdWindingVoltagePowerDistributionPatternRows();
    public Map[] getAllPid();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}
