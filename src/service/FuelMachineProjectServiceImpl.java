package service;

import java.util.Map;

import pojo.Fuel_machine_project;
import pojo.Fuel_machine_project_table;
import pojo.Log;
import dao.DbHelperImpl;
import dao.IDbHelper;
@SuppressWarnings("rawtypes")
public class FuelMachineProjectServiceImpl implements IFuelMachineProjectService{
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Fuel_machine_project fuel_machine_project) {
		String sql="insert into [dbo].[燃机项目]([项目编号],[项目名称],[项目类别],[项目所在国],[项目所在地区],[年平均气温],[极端最高气温],[极端最低气温],[平均相对湿度],[大气压],[水源],[燃机电站型式],[燃机电站燃料类型],[燃机级别],[燃机型号],[余热锅炉循环类别],[余热锅炉结构类别],[余热锅炉补燃类别],[联合循环汽水循环系统型式],[联合循环主机布置型式],[厂区面积],[循环水系统概述],[预留一],[预留二],[预留三],[预留四],[预留五],[预留六],[预留七],[预留八],[预留九],[预留十],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={fuel_machine_project.getPid(),fuel_machine_project.getName(),fuel_machine_project.getType(),fuel_machine_project.getNation(),fuel_machine_project.getArea(),fuel_machine_project.getAverage_temperature(),fuel_machine_project.getExtreme_high_temperature(),fuel_machine_project.getExtreme_low_temperature(),fuel_machine_project.getAverage_relative_humid(),fuel_machine_project.getBarometric_pressure(),fuel_machine_project.getWater_source(),fuel_machine_project.getFuel_power_station_pattern(),fuel_machine_project.getFuel_station_fuel_type(),fuel_machine_project.getFuel_machine_level(),fuel_machine_project.getFuel_machine_version(),fuel_machine_project.getWaste_heat_boiler_circulate_type(),fuel_machine_project.getWaste_heat_boiler_structure_type(),fuel_machine_project.getWaste_heat_boiler_afterburning_type(),fuel_machine_project.getCombined_circulation_aerated_water_system_pattern(),fuel_machine_project.getCombined_circulation_mainframe_layout_pattern(),fuel_machine_project.getFactory_area(),fuel_machine_project.getWater_circulation_system_overview(),fuel_machine_project.getPreparation_one(),fuel_machine_project.getPreparation_two(),fuel_machine_project.getPreparation_three(),fuel_machine_project.getPreparation_four(),fuel_machine_project.getPreparation_five(),fuel_machine_project.getPreparation_six(),fuel_machine_project.getPreparation_seven(),fuel_machine_project.getPreparation_eight(),fuel_machine_project.getPreparation_nine(),fuel_machine_project.getPreparation_ten(),fuel_machine_project.getType_in_userNme(),fuel_machine_project.getVerifier(),fuel_machine_project.getVerify_state(),fuel_machine_project.getVerify_comment(),fuel_machine_project.getEntry_time(),fuel_machine_project.getVerify_time(),fuel_machine_project.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public Map[] query(Fuel_machine_project fuel_machine_project) {
		Fuel_machine_project_table fuel_machine_project_table = new Fuel_machine_project_table(fuel_machine_project);
		if(fuel_machine_project_table.getPid()!=""){
			String sql = "select * from [dbo].[燃机项目] where "+fuel_machine_project_table.getPid()+fuel_machine_project_table.getName()+fuel_machine_project_table.getType()+fuel_machine_project_table.getNation()+fuel_machine_project_table.getArea()+fuel_machine_project_table.getAverage_temperature()+fuel_machine_project_table.getExtreme_high_temperature()+fuel_machine_project_table.getExtreme_low_temperature()+fuel_machine_project_table.getAverage_relative_humid()+fuel_machine_project_table.getBarometric_pressure()+fuel_machine_project_table.getWater_source()+fuel_machine_project_table.getFuel_power_station_pattern()+fuel_machine_project_table.getFuel_station_fuel_type()+fuel_machine_project_table.getFuel_machine_level()+fuel_machine_project_table.getFuel_machine_version()+fuel_machine_project_table.getWaste_heat_boiler_circulate_type()+fuel_machine_project_table.getWaste_heat_boiler_structure_type()+fuel_machine_project_table.getWaste_heat_boiler_afterburning_type()+fuel_machine_project_table.getCombined_circulation_aerated_water_system_pattern()+fuel_machine_project_table.getCombined_circulation_mainframe_layout_pattern()+fuel_machine_project_table.getFactory_area()+fuel_machine_project_table.getWater_circulation_system_overview()+fuel_machine_project_table.getPreparation_one()+fuel_machine_project_table.getPreparation_two()+fuel_machine_project_table.getPreparation_three()+fuel_machine_project_table.getPreparation_four()+fuel_machine_project_table.getPreparation_five()+fuel_machine_project_table.getPreparation_six()+fuel_machine_project_table.getPreparation_seven()+fuel_machine_project_table.getPreparation_eight()+fuel_machine_project_table.getPreparation_nine()+fuel_machine_project_table.getPreparation_ten()+" and [审核状态] = 2";
			return dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[燃机项目] where [审核状态] = 2";
			return this.dao.select(sql);
		}
	}

	@Override
	public boolean update(Fuel_machine_project fuel_machine_project) {
		String sql="update [dbo].[燃机项目] set [项目编号] = ? , [项目名称] = ? , [项目类别] = ? , [项目所在国] = ? , [项目所在地区] = ? , [年平均气温] = ? , [极端最高气温] = ? , [极端最低气温] = ? , [平均相对湿度] = ? , [大气压] = ? , [水源] = ? , [燃机电站型式] = ? , [燃机电站燃料类型] = ? , [燃机级别] = ? , [燃机型号] = ? , [余热锅炉循环类别] = ? , [余热锅炉结构类别] = ? , [余热锅炉补燃类别] = ? , [联合循环汽水循环系统型式] = ? , [联合循环主机布置型式] = ? , [厂区面积] = ? , [循环水系统概述] = ? , [预留一] = ? , [预留二] = ? , [预留三] = ? , [预留四] = ? , [预留五] = ? , [预留六] = ? , [预留七] = ? , [预留八] = ? , [预留九] = ? , [预留十] = ? , [审核人] = ? , [审核状态] = ? , [录入时间] = ? where [编号] = ?";
		Object[] params={fuel_machine_project.getPid(),fuel_machine_project.getName(),fuel_machine_project.getType(),fuel_machine_project.getNation(),fuel_machine_project.getArea(),fuel_machine_project.getAverage_temperature(),fuel_machine_project.getExtreme_high_temperature(),fuel_machine_project.getExtreme_low_temperature(),fuel_machine_project.getAverage_relative_humid(),fuel_machine_project.getBarometric_pressure(),fuel_machine_project.getWater_source(),fuel_machine_project.getFuel_power_station_pattern(),fuel_machine_project.getFuel_station_fuel_type(),fuel_machine_project.getFuel_machine_level(),fuel_machine_project.getFuel_machine_version(),fuel_machine_project.getWaste_heat_boiler_circulate_type(),fuel_machine_project.getWaste_heat_boiler_structure_type(),fuel_machine_project.getWaste_heat_boiler_afterburning_type(),fuel_machine_project.getCombined_circulation_aerated_water_system_pattern(),fuel_machine_project.getCombined_circulation_mainframe_layout_pattern(),fuel_machine_project.getFactory_area(),fuel_machine_project.getWater_circulation_system_overview(),fuel_machine_project.getPreparation_one(),fuel_machine_project.getPreparation_two(),fuel_machine_project.getPreparation_three(),fuel_machine_project.getPreparation_four(),fuel_machine_project.getPreparation_five(),fuel_machine_project.getPreparation_six(),fuel_machine_project.getPreparation_seven(),fuel_machine_project.getPreparation_eight(),fuel_machine_project.getPreparation_nine(),fuel_machine_project.getPreparation_ten(),fuel_machine_project.getVerifier(),fuel_machine_project.getVerify_state(),fuel_machine_project.getEntry_time(),fuel_machine_project.getId()};
		this.dao.update(sql, params);
		return true;
	}
	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[燃机项目] where [项目编号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[燃机项目] where [项目编号] = ?";
		Object[] params2={pid};
		Map row = dao.select(sql2, params2)[0];
		int n = Integer.parseInt(row.get("n").toString());
		if(n==0){
			return true;
		}
		return false;
	}
	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[燃机项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public void addLog(Log log) {
		String sql = "insert into [dbo].[消息]([用户名],[操作],[表名],[时间]) values(?,?,?,?)";
		Object[] params = {log.getUname(),log.getOperation(),log.getTable(),log.getTime()};
		this.dao.update(sql, params);
	}

	@Override
	public Map[] query(String pid, String name) {
		if(name!=null&name!=""){
			name = " and [项目名称] like \"%"+name+"%\"";
		}
		else {
			name = "";
		}
		String sql = "select * from [dbo].[燃机项目] where [项目编号] like \"%"+pid+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public boolean isSubmit(String pid) {
		String sql = "select count(*) n from [dbo].[燃机项目] where [项目编号] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[燃机项目] where [项目编号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[燃机项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] briefQuery(String uname,int state) {
		String sql = "select * from [dbo].[燃机项目] where [审核人] = ? and [审核状态] = ?";
		Object[] params = {uname,state};
		return dao.select(sql, params);
	}

	@Override
	public Map[] getDefaultTypeRows() {
		String sql = "select distinct [项目类别] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultNationRows() {
		String sql = "select distinct [项目所在国] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultWaterSourceRows() {
		String sql = "select distinct [水源] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultFuelPowerStationPatternRows() {
		String sql = "select distinct [燃机电站型式] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultFuelStationFuelTypeRows() {
		String sql = "select distinct [燃机电站燃料类型] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultFuelMachineLevelRows() {
		String sql = "select distinct [燃机级别] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultWasteHeatBoilerCirculateTypeRows() {
		String sql = "select distinct [余热锅炉循环类别] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultWasteHeatBoilerStructureTypeRows() {
		String sql = "select distinct [余热锅炉结构类别] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultWasteHeatBoilerAfterburningTypeRows() {
		String sql = "select distinct [余热锅炉补燃类别] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultCombinedCirculationAeratedWaterSystemPatternRows() {
		String sql = "select distinct [联合循环汽水循环系统型式] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultCombinedCirculationMainframeLayoutPatternRows() {
		String sql = "select distinct [联合循环主机布置型式] from [dbo].[燃机项目]";
		return dao.select(sql);
	}
	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[燃机项目] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public int getId(String pid,int state) {
		String sql = "select [编号] from [dbo].[燃机项目] where [项目编号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getAllPid() {
		String sql = "select distinct [项目编号] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public boolean verify(Fuel_machine_project fuel_machine_project) {
		String sql="update [dbo].[燃机项目] set [项目编号] = ? , [项目名称] = ? , [项目类别] = ? , [项目所在国] = ? , [项目所在地区] = ? , [年平均气温] = ? , [极端最高气温] = ? , [极端最低气温] = ? , [平均相对湿度] = ? , [大气压] = ? , [水源] = ? , [燃机电站型式] = ? , [燃机电站燃料类型] = ? , [燃机级别] = ? , [燃机型号] = ? , [余热锅炉循环类别] = ? , [余热锅炉结构类别] = ? , [余热锅炉补燃类别] = ? , [联合循环汽水循环系统型式] = ? , [联合循环主机布置型式] = ? , [厂区面积] = ? , [循环水系统概述] = ? , [预留一] = ? , [预留二] = ? , [预留三] = ? , [预留四] = ? , [预留五] = ? , [预留六] = ? , [预留七] = ? , [预留八] = ? , [预留九] = ? , [预留十] = ? , [审核状态] = ? , [审核意见] = ? , [审核时间] = ? where [编号] = ?";
		Object[] params={fuel_machine_project.getPid(),fuel_machine_project.getName(),fuel_machine_project.getType(),fuel_machine_project.getNation(),fuel_machine_project.getArea(),fuel_machine_project.getAverage_temperature(),fuel_machine_project.getExtreme_high_temperature(),fuel_machine_project.getExtreme_low_temperature(),fuel_machine_project.getAverage_relative_humid(),fuel_machine_project.getBarometric_pressure(),fuel_machine_project.getWater_source(),fuel_machine_project.getFuel_power_station_pattern(),fuel_machine_project.getFuel_station_fuel_type(),fuel_machine_project.getFuel_machine_level(),fuel_machine_project.getFuel_machine_version(),fuel_machine_project.getWaste_heat_boiler_circulate_type(),fuel_machine_project.getWaste_heat_boiler_structure_type(),fuel_machine_project.getWaste_heat_boiler_afterburning_type(),fuel_machine_project.getCombined_circulation_aerated_water_system_pattern(),fuel_machine_project.getCombined_circulation_mainframe_layout_pattern(),fuel_machine_project.getFactory_area(),fuel_machine_project.getWater_circulation_system_overview(),fuel_machine_project.getPreparation_one(),fuel_machine_project.getPreparation_two(),fuel_machine_project.getPreparation_three(),fuel_machine_project.getPreparation_four(),fuel_machine_project.getPreparation_five(),fuel_machine_project.getPreparation_six(),fuel_machine_project.getPreparation_seven(),fuel_machine_project.getPreparation_eight(),fuel_machine_project.getPreparation_nine(),fuel_machine_project.getPreparation_ten(),fuel_machine_project.getVerify_state(),fuel_machine_project.getVerify_comment(),fuel_machine_project.getVerify_time(),fuel_machine_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Fuel_machine_project fuel_machine_project) {
		String sql="update [dbo].[燃机项目] set [项目编号] = ? , [项目名称] = ? , [项目类别] = ? , [项目所在国] = ? , [项目所在地区] = ? , [年平均气温] = ? , [极端最高气温] = ? , [极端最低气温] = ? , [平均相对湿度] = ? , [大气压] = ? , [水源] = ? , [燃机电站型式] = ? , [燃机电站燃料类型] = ? , [燃机级别] = ? , [燃机型号] = ? , [余热锅炉循环类别] = ? , [余热锅炉结构类别] = ? , [余热锅炉补燃类别] = ? , [联合循环汽水循环系统型式] = ? , [联合循环主机布置型式] = ? , [厂区面积] = ? , [循环水系统概述] = ? , [预留一] = ? , [预留二] = ? , [预留三] = ? , [预留四] = ? , [预留五] = ? , [预留六] = ? , [预留七] = ? , [预留八] = ? , [预留九] = ? , [预留十] = ? , [审核人] = ? where [编号] = ?";
		Object[] params={fuel_machine_project.getPid(),fuel_machine_project.getName(),fuel_machine_project.getType(),fuel_machine_project.getNation(),fuel_machine_project.getArea(),fuel_machine_project.getAverage_temperature(),fuel_machine_project.getExtreme_high_temperature(),fuel_machine_project.getExtreme_low_temperature(),fuel_machine_project.getAverage_relative_humid(),fuel_machine_project.getBarometric_pressure(),fuel_machine_project.getWater_source(),fuel_machine_project.getFuel_power_station_pattern(),fuel_machine_project.getFuel_station_fuel_type(),fuel_machine_project.getFuel_machine_level(),fuel_machine_project.getFuel_machine_version(),fuel_machine_project.getWaste_heat_boiler_circulate_type(),fuel_machine_project.getWaste_heat_boiler_structure_type(),fuel_machine_project.getWaste_heat_boiler_afterburning_type(),fuel_machine_project.getCombined_circulation_aerated_water_system_pattern(),fuel_machine_project.getCombined_circulation_mainframe_layout_pattern(),fuel_machine_project.getFactory_area(),fuel_machine_project.getWater_circulation_system_overview(),fuel_machine_project.getPreparation_one(),fuel_machine_project.getPreparation_two(),fuel_machine_project.getPreparation_three(),fuel_machine_project.getPreparation_four(),fuel_machine_project.getPreparation_five(),fuel_machine_project.getPreparation_six(),fuel_machine_project.getPreparation_seven(),fuel_machine_project.getPreparation_eight(),fuel_machine_project.getPreparation_nine(),fuel_machine_project.getPreparation_ten(),fuel_machine_project.getVerifier(),fuel_machine_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationSixRows() {
		String sql="select distinct [预留六] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationSevenRows() {
		String sql="select distinct [预留七] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationEightRows() {
		String sql="select distinct [预留八] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationNineRows() {
		String sql="select distinct [预留九] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTenRows() {
		String sql="select distinct [预留十] from [dbo].[燃机项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[燃机项目] where [项目编号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}
	
}