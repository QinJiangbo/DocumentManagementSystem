package service;

import java.util.Map;

import pojo.Contract_technology_protocol;
import pojo.Log;
@SuppressWarnings("rawtypes")
public interface IContractTechnologyProtocolService {
	public boolean add(Contract_technology_protocol contract_technology_protocol);
	public boolean update(Contract_technology_protocol contract_technology_protocol);
	public boolean verify(Contract_technology_protocol contract_technology_protocol);
	public boolean maintenance(Contract_technology_protocol contract_technology_protocol);
	public boolean delete(int pid);
	public boolean isSubmit(String pid);
	public boolean isSave(String pid);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Contract_technology_protocol contract_technology_protocol);
	public Map[] query(String pid,String name);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String pid,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultCapacityRows();
    public Map[] getDefaultProfessionNameRows();
    public Map[] getDefaultNationRows();
    public Map[] getAllPid();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}
