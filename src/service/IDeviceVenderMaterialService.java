package service;

import java.util.Map;

import pojo.Device_vender_material;
import pojo.Log;
@SuppressWarnings("rawtypes")
public interface IDeviceVenderMaterialService {
	public boolean add(Device_vender_material device_vender_material);
	public boolean update(Device_vender_material device_vender_material);
	public boolean verify(Device_vender_material device_vender_material);
	public boolean maintenance(Device_vender_material device_vender_material);
	public boolean delete(int id);
	public boolean isSubmit(String id);
	public boolean isSave(String id);
	public boolean hasSave(String uname);
	public Map[] primaryQuery(String uname);
	public Map[] query(Device_vender_material device_vender_material);
	public Map[] query(String device_name,String factory_name);
	public Map[] query(String pid);
	public Map[] query(int id);
	public Map[] briefQuery(String uname,int state);
	public void addLog(Log log);
    public int getId(String device_name,int state);
	
	//以下是该类独有的方法
    public Map[] getDefaultProfessionRows();
    public Map[] getAllDeviceName();
    
    //以下是所有预留字段的公用方法
  	public Map[] getDefaultPreparationOneRows();
  	public Map[] getDefaultPreparationTwoRows();
  	public Map[] getDefaultPreparationThreeRows();
  	public Map[] getDefaultPreparationFourRows();
  	public Map[] getDefaultPreparationFiveRows();
}	
