package service;

import java.util.Map;

import pojo.Fuel_coal_project;
import pojo.Log;
@SuppressWarnings("rawtypes")
public interface IFuelCoalProjectService {
	public boolean add(Fuel_coal_project fuel_coal_project);
	public boolean update(Fuel_coal_project fuel_coal_project);
	public boolean verify(Fuel_coal_project fuel_coal_project);
	public boolean maintenance(Fuel_coal_project fuel_coal_project);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Fuel_coal_project fuel_coal_project);
	public Map[] query(String pid,String name);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String pid,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultTypeRows();
    public Map[] getDefaultNationRows();
    public Map[] getDefaultUnitCapacityRows();
    public Map[] getDefaultConstructionModeRows();
    public Map[] getDefaultBoilerTypeRows();
    public Map[] getDefaultFuelTypeRows();
    public Map[] getDefaultCoalTypeRows();
    public Map[] getDefaultUnitLevelRows();
    public Map[] getDefaultUnitPatternRows();
    public Map[] getDefaultCondensateBumpConfigurationRows();
    public Map[] getDefaultCoalMillPatternRows();
    public Map[] getDefaultDustingMethodRows();
    public Map[] getDefaultSulfurRemoalMethodRows();
    public Map[] getDefaultDenitrationMethodRows();
    public Map[] getDefaultExternalCoalMethodRows();
    public Map[] getDefaultCoalYardPatternRows();
    public Map[] getDefaultAshRemovalSystemRows();
    public Map[] getDefaultPCStoveMediumSpeedCoalChildSystemRows();
    public Map[] getDefaultPCStoveSlagRemovalSystemRows();
    public Map[] getDefaultCFBStoveSlagRemovalSystemRows();
    public Map[] getDefaultCFBStoveBedMaterialRows();
    public Map[] getDefaultCFBStoveLimestoneBreakSystemRows();
    public Map[] getDefaultAshExternalExportRows();
    public Map[] getDefaultCirculatingCoolingMethodRows();
    public Map[] getDefaultWaterSourceRows();
    public Map[] getDefaultCoolingTowerPatternRows();
    public Map[] getDefaultRawWaterPreprocessRows();
    public Map[] getDefaultSeaWaterDesalinationProcessRows();
    public Map[] getDefaultBoilerFeedwaterProcessRows();
    public Map[] getDefaultCondensatePolishingRows();
    public Map[] getDefaultCoolingWaterProcessRows();
    public Map[] getDefaultHydrogenStationRows();
    public Map[] getDefaultStackInnerTankPatternRows();
    public Map[] getDefaultMainFactoryFoundationPatternRows();
    public Map[] getDefaultMainFactoryStructurePatternRows();
    public Map[] getDefaultAmmoniaForDenitrationRows();
    public Map[] getDefaultFireProtectionStandardRows();
    public Map[] getDefaultMainFactoryLayoutRows();
    public Map[] getDefaultDesignBasicSeismicAccelerationRows();
    public Map[] getDefaultPowerStationOutletVoltageClassRows();
    public Map[] getDefaultDynamoLoopGCBInstallationRows();
    public Map[] getDefaultHighVoltageDistributionDeviceMainElectricalConnectionRows();
    public Map[] getDefaultHighVoltageDistributionDevicePatternRows();
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
