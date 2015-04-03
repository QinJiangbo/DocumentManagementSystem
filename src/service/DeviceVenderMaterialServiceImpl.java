package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Device_vender_material;
import pojo.Device_vender_material_table;
import pojo.Log;
@SuppressWarnings("rawtypes")
public class DeviceVenderMaterialServiceImpl implements IDeviceVenderMaterialService{
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Device_vender_material device_vender_material) {
		String sql="insert into [dbo].[设备及厂家资料]([设备名称],[厂家名称],[专业],[摘要],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={device_vender_material.getDevice_name(),device_vender_material.getFactory_name(),device_vender_material.getProfession(),device_vender_material.getSummary(),device_vender_material.getPreparation_one(),device_vender_material.getPreparation_two(),device_vender_material.getPreparation_three(),device_vender_material.getPreparation_four(),device_vender_material.getPreparation_five(),device_vender_material.getType_in_userNme(),device_vender_material.getVerifier(),device_vender_material.getVerify_state(),device_vender_material.getVerify_comment(),device_vender_material.getEntry_time(),device_vender_material.getVerify_time(),device_vender_material.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Device_vender_material device_vender_material) {
		String sql="update [dbo].[设备及厂家资料] set [设备名称]=?,[厂家名称]=?,[专业]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={device_vender_material.getDevice_name(),device_vender_material.getFactory_name(),device_vender_material.getProfession(),device_vender_material.getSummary(),device_vender_material.getPreparation_one(),device_vender_material.getPreparation_two(),device_vender_material.getPreparation_three(),device_vender_material.getPreparation_four(),device_vender_material.getPreparation_five(),device_vender_material.getVerifier(),device_vender_material.getVerify_state(),device_vender_material.getEntry_time(),device_vender_material.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int id) {
		String sql="delete [dbo].[设备及厂家资料] where [编号] = ?";
		Object[] params={id};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[设备及厂家资料] where [编号] = ?";
		Object[] params2={id};
		Map row = dao.select(sql2, params2)[0];
		int n = Integer.parseInt(row.get("n").toString());
		if(n==0){
			return true;
		}
		return false;
	}

	@Override
	public boolean isSubmit(String id) {
		String sql = "select count(*) n from [dbo].[设备及厂家资料] where [设备名称] = ? and [审核状态] > -1";
		Object[] params = {id};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String id) {
		String sql = "select count(*) n from [dbo].[设备及厂家资料] where [设备名称] = ? and [审核状态] = 0";
		Object[] params = {id};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[设备及厂家资料] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[设备及厂家资料] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Device_vender_material device_vender_material) {
		Device_vender_material_table device_vender_material_table=new Device_vender_material_table(device_vender_material);
		if(device_vender_material_table.getDevice_name()!=""){
			String sql="select * from [dbo].[设备及厂家资料] where "+device_vender_material_table.getDevice_name()+device_vender_material_table.getFactory_name()+device_vender_material_table.getProfession()+device_vender_material_table.getSummary()+device_vender_material_table.getPreparation_one()+device_vender_material_table.getPreparation_two()+device_vender_material_table.getPreparation_three()+device_vender_material_table.getPreparation_four()+device_vender_material_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[设备及厂家资料] where [审核状态] = 2";
			return this.dao.select(sql);
		}
	}

	@Override
	public Map[] query(String device_name, String factory_name) {
		if(device_name!=null&device_name!=""){
			device_name = " and [设备名称] like \"%"+device_name+"%\"";
		}
		else {
			device_name = "";
		}
		String sql = "select * from [dbo].[设备及厂家资料] where [厂家名称] like \"%"+factory_name+"%\""+device_name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname, int state) {
		String sql = "select * from [dbo].[设备及厂家资料] where [审核人] = ? and [审核状态] = ?";
		Object[] params = {uname,state};
		return dao.select(sql, params);
	}

	@Override
	public void addLog(Log log) {
		String sql = "insert into [dbo].[消息]([用户名],[操作],[表名],[时间]) values(?,?,?,?)";
		Object[] params = {log.getUname(),log.getOperation(),log.getTable(),log.getTime()};
		this.dao.update(sql, params);
	}

	@Override
	public boolean verify(Device_vender_material device_vender_material) {
		String sql="update [dbo].[设备及厂家资料] set [设备名称]=?,[厂家名称]=?,[专业]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={device_vender_material.getDevice_name(),device_vender_material.getFactory_name(),device_vender_material.getProfession(),device_vender_material.getSummary(),device_vender_material.getPreparation_one(),device_vender_material.getPreparation_two(),device_vender_material.getPreparation_three(),device_vender_material.getPreparation_four(),device_vender_material.getPreparation_five(),device_vender_material.getVerify_state(),device_vender_material.getVerify_comment(),device_vender_material.getVerify_time(),device_vender_material.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Device_vender_material device_vender_material) {
		String sql="update [dbo].[设备及厂家资料] set [设备名称]=?,[厂家名称]=?,[专业]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={device_vender_material.getDevice_name(),device_vender_material.getFactory_name(),device_vender_material.getProfession(),device_vender_material.getSummary(),device_vender_material.getPreparation_one(),device_vender_material.getPreparation_two(),device_vender_material.getPreparation_three(),device_vender_material.getPreparation_four(),device_vender_material.getPreparation_five(),device_vender_material.getVerifier(),device_vender_material.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String device_name, int state) {
		String sql = "select [编号] from [dbo].[设备及厂家资料] where [设备名称] = ? and [审核状态] = ?";
		Object[] params = {device_name,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultProfessionRows() {
		String sql="select distinct [专业] from [dbo].[设备及厂家资料]";
		return this.dao.select(sql);
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[设备及厂家资料]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[设备及厂家资料]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[设备及厂家资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[设备及厂家资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[设备及厂家资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllDeviceName() {
		String sql="select distinct [设备名称] from [dbo].[设备及厂家资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[设备及厂家资料] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String name) {
		String sql = "select * from [dbo].[设备及厂家资料] where [设备名称] like '%"+name+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}

}
