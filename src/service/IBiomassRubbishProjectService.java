package service;

import java.util.Map;

import pojo.Biomass_rubbish_project;
import pojo.Log;
@SuppressWarnings("rawtypes")
public interface IBiomassRubbishProjectService {
	public boolean add(Biomass_rubbish_project biomass_rubbish_project);
	public boolean update(Biomass_rubbish_project biomass_rubbish_project);
	public boolean verify(Biomass_rubbish_project biomass_rubbish_project);
	public boolean maintenance(Biomass_rubbish_project biomass_rubbish_project);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Biomass_rubbish_project biomass_rubbish_project);
	public Map[] query(String pid,String name);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
	public int getId(String pid,int state);
	
	//以下是该类独有的方法
	public Map[] getDefaultTypeRows();
	public Map[] getDefaultNationRows();
	public Map[] getDefaultConstructionModeRows();
	public Map[] getDefaultBoilerTypeRows();
	public Map[] getDefaultFuelTypeRows();
	public Map[] getDefaultDustingMethodRows();
	public Map[] getDefaultSulfurRemovalMethodRows();
	public Map[] getDefaultCirculatingCoolingMethodRows();
	public Map[] getDefaultWaterSourceRows();
	public Map[] getDefaultCoolingTowerPatternRows();
	public Map[] getDefaultFireProtectionStantardRows();
	public Map[] getDefaultRawWaterPreprocessRows();
	public Map[] getDefaultDesignBasicSeismicAccelerationRows();
	public Map[] getDefaultFoundationTypeRows();
	public Map[] getDefaultMainFactoryStructurePatternRows();
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
