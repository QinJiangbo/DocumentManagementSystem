package service;

import java.util.Map;

import pojo.Coal_material;
import pojo.Log;
@SuppressWarnings("rawtypes")
public interface ICoalMaterialService {
	public boolean add(Coal_material coal_material);
	public boolean update(Coal_material coal_material);
	public boolean verify(Coal_material coal_material);
	public boolean maintenance(Coal_material coal_material);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Coal_material coal_material);
	public Map[] query(String pid,String project_name);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
	public int getId(String pid,int state);
	
	//以下是该类独有的方法
	public Map[] getDefaultSulfurRows();
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
