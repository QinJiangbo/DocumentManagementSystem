package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Log;
import pojo.Photovoltaic_generation_project;
import pojo.Photovoltaic_generation_project_table;
@SuppressWarnings("rawtypes")
public class PhotovoltaicGenerationProjectServiceImpl implements IPhotovoltaicGenerationProjectService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Photovoltaic_generation_project photovoltaic_generation_project) {
		String sql="insert into [dbo].[光伏发电项目]([项目编号],[项目名称],[项目类别],[项目所在国],[项目所在地区],[总容量],[日照时间],[太阳总辐射],[供电类型],[建筑类型],[运行方式],[电池类型],[厂区面积],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={photovoltaic_generation_project.getPid(),photovoltaic_generation_project.getName(),photovoltaic_generation_project.getType(),photovoltaic_generation_project.getNation(),photovoltaic_generation_project.getArea(),photovoltaic_generation_project.getTotal_capacity(),photovoltaic_generation_project.getSunshine_duration(),photovoltaic_generation_project.getTotal_solar_radiation(),photovoltaic_generation_project.getPower_supply_type(),photovoltaic_generation_project.getBuilding_type(),photovoltaic_generation_project.getRunning_mode(),photovoltaic_generation_project.getBattery_type(),photovoltaic_generation_project.getFactory_area(),photovoltaic_generation_project.getPreparation_one(),photovoltaic_generation_project.getPreparation_two(),photovoltaic_generation_project.getPreparation_three(),photovoltaic_generation_project.getPreparation_four(),photovoltaic_generation_project.getPreparation_five(),photovoltaic_generation_project.getType_in_userNme(),photovoltaic_generation_project.getVerifier(),photovoltaic_generation_project.getVerify_state(),photovoltaic_generation_project.getVerify_comment(),photovoltaic_generation_project.getEntry_time(),photovoltaic_generation_project.getVerify_time(),photovoltaic_generation_project.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Photovoltaic_generation_project photovoltaic_generation_project) {
		String sql="update [dbo].[光伏发电项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[总容量]=?,[日照时间]=?,[太阳总辐射]=?,[供电类型]=?,[建筑类型]=?,[运行方式]=?,[电池类型]=?,[厂区面积]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		System.out.println(photovoltaic_generation_project.getId()+" 11 "+photovoltaic_generation_project.getPid());
		Object[] params={photovoltaic_generation_project.getPid(),photovoltaic_generation_project.getName(),photovoltaic_generation_project.getType(),photovoltaic_generation_project.getNation(),photovoltaic_generation_project.getArea(),photovoltaic_generation_project.getTotal_capacity(),photovoltaic_generation_project.getSunshine_duration(),photovoltaic_generation_project.getTotal_solar_radiation(),photovoltaic_generation_project.getPower_supply_type(),photovoltaic_generation_project.getBuilding_type(),photovoltaic_generation_project.getRunning_mode(),photovoltaic_generation_project.getBattery_type(),photovoltaic_generation_project.getFactory_area(),photovoltaic_generation_project.getPreparation_one(),photovoltaic_generation_project.getPreparation_two(),photovoltaic_generation_project.getPreparation_three(),photovoltaic_generation_project.getPreparation_four(),photovoltaic_generation_project.getPreparation_five(),photovoltaic_generation_project.getVerifier(),photovoltaic_generation_project.getVerify_state(),photovoltaic_generation_project.getEntry_time(),photovoltaic_generation_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[光伏发电项目] where [项目编号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[光伏发电项目] where [项目编号] = ?";
		Object[] params2={pid};
		Map row = dao.select(sql2, params2)[0];
		int n = Integer.parseInt(row.get("n").toString());
		if(n==0){
			return true;
		}
		return false;
	}

	@Override
	public boolean isSubmit(String pid) {
		String sql = "select count(*) n from [dbo].[光伏发电项目] where [项目编号] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[光伏发电项目] where [项目编号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[光伏发电项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[光伏发电项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Photovoltaic_generation_project photovoltaic_generation_project) {
		Photovoltaic_generation_project_table photovoltaic_generation_project_table=new Photovoltaic_generation_project_table(photovoltaic_generation_project);
		if(photovoltaic_generation_project_table.getPid()!=""){
			String sql="select * from [dbo].[光伏发电项目] where "+photovoltaic_generation_project_table.getPid()+photovoltaic_generation_project_table.getName()+photovoltaic_generation_project_table.getType()+photovoltaic_generation_project_table.getNation()+photovoltaic_generation_project_table.getArea()+photovoltaic_generation_project_table.getTotal_capacity()+photovoltaic_generation_project_table.getSunshine_duration()+photovoltaic_generation_project_table.getTotal_solar_radiation()+photovoltaic_generation_project_table.getPower_supply_type()+photovoltaic_generation_project_table.getBuilding_type()+photovoltaic_generation_project_table.getRunning_mode()+photovoltaic_generation_project_table.getBattery_type()+photovoltaic_generation_project_table.getFactory_area()+photovoltaic_generation_project_table.getPreparation_one()+photovoltaic_generation_project_table.getPreparation_two()+photovoltaic_generation_project_table.getPreparation_three()+photovoltaic_generation_project_table.getPreparation_four()+photovoltaic_generation_project_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[光伏发电项目] where [审核状态] = 2";
			return this.dao.select(sql);
		}
	}

	@Override
	public Map[] query(String pid, String name) {
		if(name!=null&name!=""){
			name = " and [项目名称] like \"%"+name+"%\"";
		}
		else {
			name = "";
		}
		String sql = "select * from [dbo].[光伏发电项目] where [项目编号] like \"%"+pid+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname,int state) {
		String sql = "select * from [dbo].[光伏发电项目] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Photovoltaic_generation_project photovoltaic_generation_project) {
		String sql="update [dbo].[光伏发电项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[总容量]=?,[日照时间]=?,[太阳总辐射]=?,[供电类型]=?,[建筑类型]=?,[运行方式]=?,[电池类型]=?,[厂区面积]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={photovoltaic_generation_project.getPid(),photovoltaic_generation_project.getName(),photovoltaic_generation_project.getType(),photovoltaic_generation_project.getNation(),photovoltaic_generation_project.getArea(),photovoltaic_generation_project.getTotal_capacity(),photovoltaic_generation_project.getSunshine_duration(),photovoltaic_generation_project.getTotal_solar_radiation(),photovoltaic_generation_project.getPower_supply_type(),photovoltaic_generation_project.getBuilding_type(),photovoltaic_generation_project.getRunning_mode(),photovoltaic_generation_project.getBattery_type(),photovoltaic_generation_project.getFactory_area(),photovoltaic_generation_project.getPreparation_one(),photovoltaic_generation_project.getPreparation_two(),photovoltaic_generation_project.getPreparation_three(),photovoltaic_generation_project.getPreparation_four(),photovoltaic_generation_project.getPreparation_five(),photovoltaic_generation_project.getVerify_state(),photovoltaic_generation_project.getVerify_comment(),photovoltaic_generation_project.getVerify_time(),photovoltaic_generation_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Photovoltaic_generation_project photovoltaic_generation_project) {
		String sql="update [dbo].[光伏发电项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[总容量]=?,[日照时间]=?,[太阳总辐射]=?,[供电类型]=?,[建筑类型]=?,[运行方式]=?,[电池类型]=?,[厂区面积]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={photovoltaic_generation_project.getPid(),photovoltaic_generation_project.getName(),photovoltaic_generation_project.getType(),photovoltaic_generation_project.getNation(),photovoltaic_generation_project.getArea(),photovoltaic_generation_project.getTotal_capacity(),photovoltaic_generation_project.getSunshine_duration(),photovoltaic_generation_project.getTotal_solar_radiation(),photovoltaic_generation_project.getPower_supply_type(),photovoltaic_generation_project.getBuilding_type(),photovoltaic_generation_project.getRunning_mode(),photovoltaic_generation_project.getBattery_type(),photovoltaic_generation_project.getFactory_area(),photovoltaic_generation_project.getPreparation_one(),photovoltaic_generation_project.getPreparation_two(),photovoltaic_generation_project.getPreparation_three(),photovoltaic_generation_project.getPreparation_four(),photovoltaic_generation_project.getPreparation_five(),photovoltaic_generation_project.getVerifier(),photovoltaic_generation_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[光伏发电项目] where [项目编号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultTypeRows() {
		String sql="select distinct [项目类别] from [dbo].[光伏发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultNationRows() {
		String sql="select distinct [项目所在国] from [dbo].[光伏发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultTotalCapacityRows() {
		String sql="select distinct [总容量] from [dbo].[光伏发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPowerSupplyTypeRows() {
		String sql="select distinct [供电类型] from [dbo].[光伏发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultBuildingTypeRows() {
		String sql="select distinct [建筑类型] from [dbo].[光伏发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultRunningModeRows() {
		String sql="select distinct [运行方式] from [dbo].[光伏发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultBatteryTypeRows() {
		String sql="select distinct [电池类型] from [dbo].[光伏发电项目]";
		return this.dao.select(sql);
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[光伏发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[光伏发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[光伏发电项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[光伏发电项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[光伏发电项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllPid() {
		String sql="select distinct [项目编号] from [dbo].[光伏发电项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql="select * from [dbo].[光伏发电项目] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[光伏发电项目] where [项目编号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}
}
