package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Fuel_coal_project;
import pojo.Fuel_coal_project_table;
import pojo.Log;
@SuppressWarnings("rawtypes")
public class FuelCoalProjectServiceImpl implements IFuelCoalProjectService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Fuel_coal_project fuel_coal_project) {
		String sql="insert into [dbo].[燃煤项目]([项目编号],[项目名称],[项目类别],[项目所在国],[项目所在地区],[机组容量],[装机数量],[建设方式],[锅炉型式],[燃料类型],[煤质类别],[机组等级],[机组型式],[凝结水泵配置],[磨煤机型式],[除尘方式],[脱硫方式] ,[脱硝方式],[厂外来煤方式],[煤场型式],[除灰系统],[PC炉中速磨石子煤系统],[PC炉除渣系统],[CFB炉除渣系统],[CFB炉床料系统],[CFB炉石灰石细碎系统],[灰渣厂外输送],[循环冷却方式],[水源],[冷却塔型式],[原水预处理],[海水淡化处理],[锅炉补给水处理],[凝结水精处理],[冷却水处理],[氢气站],[烟囱内筒型式],[主厂区基础型式],[主厂房结构型式],[脱硝用氨],[消防标准],[主厂房布置],[设计基本地震加速度],[发电厂出线电压等级],[发电机回路GCB配置],[高压配电装置电气主接线],[高压配电装置型式],[厂区面积],[年平均气温],[极端最高气温],[极端最低气温],[平均相对湿度],[粉尘排放浓度],[SO2排放浓度],[YOx排放浓度],[循环水系统概述],[锅炉效率],[汽机热耗],[厂用电率],[全厂净效率],[预留一],[预留二],[预留三],[预留四],[预留五],[预留六],[预留七],[预留八],[预留九],[预留十],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={fuel_coal_project.getPid(),fuel_coal_project.getName(),fuel_coal_project.getType(),fuel_coal_project.getNation(),fuel_coal_project.getArea(),fuel_coal_project.getUnit_capacity(),fuel_coal_project.getInstallation_number(),fuel_coal_project.getConstruction_mode(),fuel_coal_project.getBoiler_pattern(),fuel_coal_project.getFuel_type(),fuel_coal_project.getCoal_type(),fuel_coal_project.getUnit_level(),fuel_coal_project.getUnit_pattern(),fuel_coal_project.getCondensate_bump_configuration(),fuel_coal_project.getCoal_mill_pattern(),fuel_coal_project.getDusting_method(),fuel_coal_project.getSulfur_removal_method(),fuel_coal_project.getDenitration_method(),fuel_coal_project.getExternal_coal_method(),fuel_coal_project.getCoal_yard_pattern(),fuel_coal_project.getAsh_removal_system(),fuel_coal_project.getPC_stove_medium_speed_coal_child_system(),fuel_coal_project.getPC_stove_slag_removal_system(),fuel_coal_project.getCFB_stove_slag_removal_system(),fuel_coal_project.getCFB_stove_bed_material(),fuel_coal_project.getCFB_stove_limestone_break_system(),fuel_coal_project.getAsh_external_export(),fuel_coal_project.getCirculating_cooling_method(),fuel_coal_project.getWater_source(),fuel_coal_project.getCooling_tower_pattern(),fuel_coal_project.getRaw_water_preprocess(),fuel_coal_project.getSea_water_desalination_process(),fuel_coal_project.getBoiler_feedwater_process(),fuel_coal_project.getCondensate_polishing(),fuel_coal_project.getCooling_water_process(),fuel_coal_project.getHydrogen_station(),fuel_coal_project.getStack_inner_tank_pattern(),fuel_coal_project.getMain_factory_foundation_pattern(),fuel_coal_project.getMain_factory_structure_pattern(),fuel_coal_project.getAmmonia_for_denitration(),fuel_coal_project.getFire_protection_standard(),fuel_coal_project.getMain_factory_layout(),fuel_coal_project.getDesign_basic_seismic_acceleration(),fuel_coal_project.getPower_station_outlet_voltage_class(),fuel_coal_project.getDynamo_loop_GCB_installation(),fuel_coal_project.getHigh_voltage_distribution_device_main_electrical_connection(),fuel_coal_project.getHigh_voltage_distribution_device_pattern(),fuel_coal_project.getFactory_area(),fuel_coal_project.getAverage_temperature(),fuel_coal_project.getExtreme_high_temperature(),fuel_coal_project.getExtreme_low_temperature(),fuel_coal_project.getAverage_relative_humid(),fuel_coal_project.getDust_emission_concentration(),fuel_coal_project.getSO2_emission_concentration(),fuel_coal_project.getYOx_emission_concentration(),fuel_coal_project.getWater_circulation_system_overview(),fuel_coal_project.getBoiler_efficiency(),fuel_coal_project.getTurbine_heat_consumption(),fuel_coal_project.getAuxiliary_power_ratio(),fuel_coal_project.getFactory_net_efficiency(),fuel_coal_project.getPreparation_one(),fuel_coal_project.getPreparation_two(),fuel_coal_project.getPreparation_three(),fuel_coal_project.getPreparation_four(),fuel_coal_project.getPreparation_five(),fuel_coal_project.getPreparation_six(),fuel_coal_project.getPreparation_seven(),fuel_coal_project.getPreparation_eight(),fuel_coal_project.getPreparation_nine(),fuel_coal_project.getPreparation_ten(),fuel_coal_project.getType_in_userNme(),fuel_coal_project.getVerifier(),fuel_coal_project.getVerify_state(),fuel_coal_project.getVerify_comment(),fuel_coal_project.getEntry_time(),fuel_coal_project.getVerify_time(),fuel_coal_project.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Fuel_coal_project fuel_coal_project) {
		String sql="update [dbo].[燃煤项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[机组容量]=?,[装机数量]=?,[建设方式]=?,[锅炉型式]=?,[燃料类型]=?,[煤质类别]=?,[机组等级]=?,[机组型式]=?,[凝结水泵配置]=?,[磨煤机型式]=?,[除尘方式]=?,[脱硫方式]=? ,[脱硝方式]=?,[厂外来煤方式]=?,[煤场型式]=?,[除灰系统]=?,[PC炉中速磨石子煤系统]=?,[PC炉除渣系统]=?,[CFB炉除渣系统]=?,[CFB炉床料系统]=?,[CFB炉石灰石细碎系统]=?,[灰渣厂外输送]=?,[循环冷却方式]=?,[水源]=?,[冷却塔型式]=?,[原水预处理]=?,[海水淡化处理]=?,[锅炉补给水处理]=?,[凝结水精处理]=?,[冷却水处理]=?,[氢气站]=?,[烟囱内筒型式]=?,[主厂区基础型式]=?,[主厂房结构型式]=?,[脱硝用氨]=?,[消防标准]=?,[主厂房布置]=?,[设计基本地震加速度]=?,[发电厂出线电压等级]=?,[发电机回路GCB配置]=?,[高压配电装置电气主接线]=?,[高压配电装置型式]=?,[厂区面积]=?,[年平均气温]=?,[极端最高气温]=?,[极端最低气温]=?,[平均相对湿度]=?,[粉尘排放浓度]=?,[SO2排放浓度]=?,[YOx排放浓度]=?,[循环水系统概述]=?,[锅炉效率]=?,[汽机热耗]=?,[厂用电率]=?,[全厂净效率]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[预留六]=?,[预留七]=?,[预留八]=?,[预留九]=?,[预留十]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={fuel_coal_project.getPid(),fuel_coal_project.getName(),fuel_coal_project.getType(),fuel_coal_project.getNation(),fuel_coal_project.getArea(),fuel_coal_project.getUnit_capacity(),fuel_coal_project.getInstallation_number(),fuel_coal_project.getConstruction_mode(),fuel_coal_project.getBoiler_pattern(),fuel_coal_project.getFuel_type(),fuel_coal_project.getCoal_type(),fuel_coal_project.getUnit_level(),fuel_coal_project.getUnit_pattern(),fuel_coal_project.getCondensate_bump_configuration(),fuel_coal_project.getCoal_mill_pattern(),fuel_coal_project.getDusting_method(),fuel_coal_project.getSulfur_removal_method(),fuel_coal_project.getDenitration_method(),fuel_coal_project.getExternal_coal_method(),fuel_coal_project.getCoal_yard_pattern(),fuel_coal_project.getAsh_removal_system(),fuel_coal_project.getPC_stove_medium_speed_coal_child_system(),fuel_coal_project.getPC_stove_slag_removal_system(),fuel_coal_project.getCFB_stove_slag_removal_system(),fuel_coal_project.getCFB_stove_bed_material(),fuel_coal_project.getCFB_stove_limestone_break_system(),fuel_coal_project.getAsh_external_export(),fuel_coal_project.getCirculating_cooling_method(),fuel_coal_project.getWater_source(),fuel_coal_project.getCooling_tower_pattern(),fuel_coal_project.getRaw_water_preprocess(),fuel_coal_project.getSea_water_desalination_process(),fuel_coal_project.getBoiler_feedwater_process(),fuel_coal_project.getCondensate_polishing(),fuel_coal_project.getCooling_water_process(),fuel_coal_project.getHydrogen_station(),fuel_coal_project.getStack_inner_tank_pattern(),fuel_coal_project.getMain_factory_foundation_pattern(),fuel_coal_project.getMain_factory_structure_pattern(),fuel_coal_project.getAmmonia_for_denitration(),fuel_coal_project.getFire_protection_standard(),fuel_coal_project.getMain_factory_layout(),fuel_coal_project.getDesign_basic_seismic_acceleration(),fuel_coal_project.getPower_station_outlet_voltage_class(),fuel_coal_project.getDynamo_loop_GCB_installation(),fuel_coal_project.getHigh_voltage_distribution_device_main_electrical_connection(),fuel_coal_project.getHigh_voltage_distribution_device_pattern(),fuel_coal_project.getFactory_area(),fuel_coal_project.getAverage_temperature(),fuel_coal_project.getExtreme_high_temperature(),fuel_coal_project.getExtreme_low_temperature(),fuel_coal_project.getAverage_relative_humid(),fuel_coal_project.getDust_emission_concentration(),fuel_coal_project.getSO2_emission_concentration(),fuel_coal_project.getYOx_emission_concentration(),fuel_coal_project.getWater_circulation_system_overview(),fuel_coal_project.getBoiler_efficiency(),fuel_coal_project.getTurbine_heat_consumption(),fuel_coal_project.getAuxiliary_power_ratio(),fuel_coal_project.getFactory_net_efficiency(),fuel_coal_project.getPreparation_one(),fuel_coal_project.getPreparation_two(),fuel_coal_project.getPreparation_three(),fuel_coal_project.getPreparation_four(),fuel_coal_project.getPreparation_five(),fuel_coal_project.getPreparation_six(),fuel_coal_project.getPreparation_seven(),fuel_coal_project.getPreparation_eight(),fuel_coal_project.getPreparation_nine(),fuel_coal_project.getPreparation_ten(),fuel_coal_project.getVerifier(),fuel_coal_project.getVerify_state(),fuel_coal_project.getEntry_time(),fuel_coal_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[燃煤项目] where [项目编号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[燃煤项目] where [项目编号] = ?";
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
		String sql = "select count(*) n from [dbo].[燃煤项目] where [项目编号] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[燃煤项目] where [项目编号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[燃煤项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[燃煤项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Fuel_coal_project fuel_coal_project) {
		Fuel_coal_project_table fuel_coal_project_table=new Fuel_coal_project_table(fuel_coal_project);
		if(fuel_coal_project_table.getPid()!=""){
			String sql="select * from [dbo].[燃煤项目] where "+fuel_coal_project_table.getPid()+fuel_coal_project_table.getName()+fuel_coal_project_table.getType()+fuel_coal_project_table.getNation()+fuel_coal_project_table.getArea()+fuel_coal_project_table.getUnit_capacity()+fuel_coal_project_table.getInstallation_number()+fuel_coal_project_table.getConstruction_mode()+fuel_coal_project_table.getBoiler_pattern()+fuel_coal_project_table.getFuel_type()+fuel_coal_project_table.getCoal_type()+fuel_coal_project_table.getUnit_level()+fuel_coal_project_table.getUnit_pattern()+fuel_coal_project_table.getCondensate_bump_configuration()+fuel_coal_project_table.getCoal_mill_pattern()+fuel_coal_project_table.getDusting_method()+fuel_coal_project_table.getSulfur_removal_method()+fuel_coal_project_table.getDenitration_method()+fuel_coal_project_table.getExternal_coal_method()+fuel_coal_project_table.getCoal_yard_pattern()+fuel_coal_project_table.getAsh_removal_system()+fuel_coal_project_table.getPC_stove_medium_speed_coal_child_system()+fuel_coal_project_table.getPC_stove_slag_removal_system()+fuel_coal_project_table.getCFB_stove_slag_removal_system()+fuel_coal_project_table.getCFB_stove_bed_material()+fuel_coal_project_table.getCFB_stove_limestone_break_system()+fuel_coal_project_table.getAsh_external_export()+fuel_coal_project_table.getCirculating_cooling_method()+fuel_coal_project_table.getWater_source()+fuel_coal_project_table.getCooling_tower_pattern()+fuel_coal_project_table.getRaw_water_preprocess()+fuel_coal_project_table.getSea_water_desalination_process()+fuel_coal_project_table.getBoiler_feedwater_process()+fuel_coal_project_table.getCondensate_polishing()+fuel_coal_project_table.getCooling_water_process()+fuel_coal_project_table.getHydrogen_station()+fuel_coal_project_table.getStack_inner_tank_pattern()+fuel_coal_project_table.getMain_factory_foundation_pattern()+fuel_coal_project_table.getMain_factory_structure_pattern()+fuel_coal_project_table.getAmmonia_for_denitration()+fuel_coal_project_table.getFire_protection_standard()+fuel_coal_project_table.getMain_factory_layout()+fuel_coal_project_table.getDesign_basic_seismic_acceleration()+fuel_coal_project_table.getPower_station_outlet_voltage_class()+fuel_coal_project_table.getDynamo_loop_GCB_installation()+fuel_coal_project_table.getHigh_voltage_distribution_device_main_electrical_connection()+fuel_coal_project_table.getHigh_voltage_distribution_device_pattern()+fuel_coal_project_table.getFactory_area()+fuel_coal_project_table.getAverage_temperature()+fuel_coal_project_table.getExtreme_high_temperature()+fuel_coal_project_table.getExtreme_low_temperature()+fuel_coal_project_table.getAverage_relative_humid()+fuel_coal_project_table.getDust_emission_concentration()+fuel_coal_project_table.getSO2_emission_concentration()+fuel_coal_project_table.getYOx_emission_concentration()+fuel_coal_project_table.getWater_circulation_system_overview()+fuel_coal_project_table.getBoiler_efficiency()+fuel_coal_project_table.getTurbine_heat_consumption()+fuel_coal_project_table.getAuxiliary_power_ratio()+fuel_coal_project_table.getFactory_net_efficiency()+fuel_coal_project_table.getPreparation_one()+fuel_coal_project_table.getPreparation_two()+fuel_coal_project_table.getPreparation_three()+fuel_coal_project_table.getPreparation_four()+fuel_coal_project_table.getPreparation_five()+fuel_coal_project_table.getPreparation_six()+fuel_coal_project_table.getPreparation_seven()+fuel_coal_project_table.getPreparation_nine()+fuel_coal_project_table.getPreparation_ten()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[燃煤项目] where [审核状态] = 2";
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
		String sql = "select * from [dbo].[燃煤项目] where [项目编号] like \"%"+pid+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname,int state) {
		String sql = "select * from [dbo].[燃煤项目] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Fuel_coal_project fuel_coal_project) {
		String sql="update [dbo].[燃煤项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[机组容量]=?,[装机数量]=?,[建设方式]=?,[锅炉型式]=?,[燃料类型]=?,[煤质类别]=?,[机组等级]=?,[机组型式]=?,[凝结水泵配置]=?,[磨煤机型式]=?,[除尘方式]=?,[脱硫方式]=? ,[脱硝方式]=?,[厂外来煤方式]=?,[煤场型式]=?,[除灰系统]=?,[PC炉中速磨石子煤系统]=?,[PC炉除渣系统]=?,[CFB炉除渣系统]=?,[CFB炉床料系统]=?,[CFB炉石灰石细碎系统]=?,[灰渣厂外输送]=?,[循环冷却方式]=?,[水源]=?,[冷却塔型式]=?,[原水预处理]=?,[海水淡化处理]=?,[锅炉补给水处理]=?,[凝结水精处理]=?,[冷却水处理]=?,[氢气站]=?,[烟囱内筒型式]=?,[主厂区基础型式]=?,[主厂房结构型式]=?,[脱硝用氨]=?,[消防标准]=?,[主厂房布置]=?,[设计基本地震加速度]=?,[发电厂出线电压等级]=?,[发电机回路GCB配置]=?,[高压配电装置电气主接线]=?,[高压配电装置型式]=?,[厂区面积]=?,[年平均气温]=?,[极端最高气温]=?,[极端最低气温]=?,[平均相对湿度]=?,[粉尘排放浓度]=?,[SO2排放浓度]=?,[YOx排放浓度]=?,[循环水系统概述]=?,[锅炉效率]=?,[汽机热耗]=?,[厂用电率]=?,[全厂净效率]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[预留六]=?,[预留七]=?,[预留八]=?,[预留九]=?,[预留十]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={fuel_coal_project.getPid(),fuel_coal_project.getName(),fuel_coal_project.getType(),fuel_coal_project.getNation(),fuel_coal_project.getArea(),fuel_coal_project.getUnit_capacity(),fuel_coal_project.getInstallation_number(),fuel_coal_project.getConstruction_mode(),fuel_coal_project.getBoiler_pattern(),fuel_coal_project.getFuel_type(),fuel_coal_project.getCoal_type(),fuel_coal_project.getUnit_level(),fuel_coal_project.getUnit_pattern(),fuel_coal_project.getCondensate_bump_configuration(),fuel_coal_project.getCoal_mill_pattern(),fuel_coal_project.getDusting_method(),fuel_coal_project.getSulfur_removal_method(),fuel_coal_project.getDenitration_method(),fuel_coal_project.getExternal_coal_method(),fuel_coal_project.getCoal_yard_pattern(),fuel_coal_project.getAsh_removal_system(),fuel_coal_project.getPC_stove_medium_speed_coal_child_system(),fuel_coal_project.getPC_stove_slag_removal_system(),fuel_coal_project.getCFB_stove_slag_removal_system(),fuel_coal_project.getCFB_stove_bed_material(),fuel_coal_project.getCFB_stove_limestone_break_system(),fuel_coal_project.getAsh_external_export(),fuel_coal_project.getCirculating_cooling_method(),fuel_coal_project.getWater_source(),fuel_coal_project.getCooling_tower_pattern(),fuel_coal_project.getRaw_water_preprocess(),fuel_coal_project.getSea_water_desalination_process(),fuel_coal_project.getBoiler_feedwater_process(),fuel_coal_project.getCondensate_polishing(),fuel_coal_project.getCooling_water_process(),fuel_coal_project.getHydrogen_station(),fuel_coal_project.getStack_inner_tank_pattern(),fuel_coal_project.getMain_factory_foundation_pattern(),fuel_coal_project.getMain_factory_structure_pattern(),fuel_coal_project.getAmmonia_for_denitration(),fuel_coal_project.getFire_protection_standard(),fuel_coal_project.getMain_factory_layout(),fuel_coal_project.getDesign_basic_seismic_acceleration(),fuel_coal_project.getPower_station_outlet_voltage_class(),fuel_coal_project.getDynamo_loop_GCB_installation(),fuel_coal_project.getHigh_voltage_distribution_device_main_electrical_connection(),fuel_coal_project.getHigh_voltage_distribution_device_pattern(),fuel_coal_project.getFactory_area(),fuel_coal_project.getAverage_temperature(),fuel_coal_project.getExtreme_high_temperature(),fuel_coal_project.getExtreme_low_temperature(),fuel_coal_project.getAverage_relative_humid(),fuel_coal_project.getDust_emission_concentration(),fuel_coal_project.getSO2_emission_concentration(),fuel_coal_project.getYOx_emission_concentration(),fuel_coal_project.getWater_circulation_system_overview(),fuel_coal_project.getBoiler_efficiency(),fuel_coal_project.getTurbine_heat_consumption(),fuel_coal_project.getAuxiliary_power_ratio(),fuel_coal_project.getFactory_net_efficiency(),fuel_coal_project.getPreparation_one(),fuel_coal_project.getPreparation_two(),fuel_coal_project.getPreparation_three(),fuel_coal_project.getPreparation_four(),fuel_coal_project.getPreparation_five(),fuel_coal_project.getPreparation_six(),fuel_coal_project.getPreparation_seven(),fuel_coal_project.getPreparation_eight(),fuel_coal_project.getPreparation_nine(),fuel_coal_project.getPreparation_ten(),fuel_coal_project.getVerify_state(),fuel_coal_project.getVerify_comment(),fuel_coal_project.getVerify_time(),fuel_coal_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Fuel_coal_project fuel_coal_project) {
		String sql="update [dbo].[燃煤项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[机组容量]=?,[装机数量]=?,[建设方式]=?,[锅炉型式]=?,[燃料类型]=?,[煤质类别]=?,[机组等级]=?,[机组型式]=?,[凝结水泵配置]=?,[磨煤机型式]=?,[除尘方式]=?,[脱硫方式]=? ,[脱硝方式]=?,[厂外来煤方式]=?,[煤场型式]=?,[除灰系统]=?,[PC炉中速磨石子煤系统]=?,[PC炉除渣系统]=?,[CFB炉除渣系统]=?,[CFB炉床料系统]=?,[CFB炉石灰石细碎系统]=?,[灰渣厂外输送]=?,[循环冷却方式]=?,[水源]=?,[冷却塔型式]=?,[原水预处理]=?,[海水淡化处理]=?,[锅炉补给水处理]=?,[凝结水精处理]=?,[冷却水处理]=?,[氢气站]=?,[烟囱内筒型式]=?,[主厂区基础型式]=?,[主厂房结构型式]=?,[脱硝用氨]=?,[消防标准]=?,[主厂房布置]=?,[设计基本地震加速度]=?,[发电厂出线电压等级]=?,[发电机回路GCB配置]=?,[高压配电装置电气主接线]=?,[高压配电装置型式]=?,[厂区面积]=?,[年平均气温]=?,[极端最高气温]=?,[极端最低气温]=?,[平均相对湿度]=?,[粉尘排放浓度]=?,[SO2排放浓度]=?,[YOx排放浓度]=?,[循环水系统概述]=?,[锅炉效率]=?,[汽机热耗]=?,[厂用电率]=?,[全厂净效率]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[预留六]=?,[预留七]=?,[预留八]=?,[预留九]=?,[预留十]=?,[审核人]=? where [编号]=?";
		Object[] params={fuel_coal_project.getPid(),fuel_coal_project.getName(),fuel_coal_project.getType(),fuel_coal_project.getNation(),fuel_coal_project.getArea(),fuel_coal_project.getUnit_capacity(),fuel_coal_project.getInstallation_number(),fuel_coal_project.getConstruction_mode(),fuel_coal_project.getBoiler_pattern(),fuel_coal_project.getFuel_type(),fuel_coal_project.getCoal_type(),fuel_coal_project.getUnit_level(),fuel_coal_project.getUnit_pattern(),fuel_coal_project.getCondensate_bump_configuration(),fuel_coal_project.getCoal_mill_pattern(),fuel_coal_project.getDusting_method(),fuel_coal_project.getSulfur_removal_method(),fuel_coal_project.getDenitration_method(),fuel_coal_project.getExternal_coal_method(),fuel_coal_project.getCoal_yard_pattern(),fuel_coal_project.getAsh_removal_system(),fuel_coal_project.getPC_stove_medium_speed_coal_child_system(),fuel_coal_project.getPC_stove_slag_removal_system(),fuel_coal_project.getCFB_stove_slag_removal_system(),fuel_coal_project.getCFB_stove_bed_material(),fuel_coal_project.getCFB_stove_limestone_break_system(),fuel_coal_project.getAsh_external_export(),fuel_coal_project.getCirculating_cooling_method(),fuel_coal_project.getWater_source(),fuel_coal_project.getCooling_tower_pattern(),fuel_coal_project.getRaw_water_preprocess(),fuel_coal_project.getSea_water_desalination_process(),fuel_coal_project.getBoiler_feedwater_process(),fuel_coal_project.getCondensate_polishing(),fuel_coal_project.getCooling_water_process(),fuel_coal_project.getHydrogen_station(),fuel_coal_project.getStack_inner_tank_pattern(),fuel_coal_project.getMain_factory_foundation_pattern(),fuel_coal_project.getMain_factory_structure_pattern(),fuel_coal_project.getAmmonia_for_denitration(),fuel_coal_project.getFire_protection_standard(),fuel_coal_project.getMain_factory_layout(),fuel_coal_project.getDesign_basic_seismic_acceleration(),fuel_coal_project.getPower_station_outlet_voltage_class(),fuel_coal_project.getDynamo_loop_GCB_installation(),fuel_coal_project.getHigh_voltage_distribution_device_main_electrical_connection(),fuel_coal_project.getHigh_voltage_distribution_device_pattern(),fuel_coal_project.getFactory_area(),fuel_coal_project.getAverage_temperature(),fuel_coal_project.getExtreme_high_temperature(),fuel_coal_project.getExtreme_low_temperature(),fuel_coal_project.getAverage_relative_humid(),fuel_coal_project.getDust_emission_concentration(),fuel_coal_project.getSO2_emission_concentration(),fuel_coal_project.getYOx_emission_concentration(),fuel_coal_project.getWater_circulation_system_overview(),fuel_coal_project.getBoiler_efficiency(),fuel_coal_project.getTurbine_heat_consumption(),fuel_coal_project.getAuxiliary_power_ratio(),fuel_coal_project.getFactory_net_efficiency(),fuel_coal_project.getPreparation_one(),fuel_coal_project.getPreparation_two(),fuel_coal_project.getPreparation_three(),fuel_coal_project.getPreparation_four(),fuel_coal_project.getPreparation_five(),fuel_coal_project.getPreparation_six(),fuel_coal_project.getPreparation_seven(),fuel_coal_project.getPreparation_eight(),fuel_coal_project.getPreparation_nine(),fuel_coal_project.getPreparation_ten(),fuel_coal_project.getVerifier(),fuel_coal_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[燃煤项目] where [项目编号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultTypeRows() {
		String sql="select distinct [项目类别] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultNationRows() {
		String sql="select distinct [项目所在国] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultUnitCapacityRows() {
		String sql="select distinct [机组容量] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultConstructionModeRows() {
		String sql="select distinct [建设方式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultBoilerTypeRows() {
		String sql="select distinct [锅炉型式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultFuelTypeRows() {
		String sql="select distinct [燃料类型] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCoalTypeRows() {
		String sql="select distinct [煤质类别] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultUnitLevelRows() {
		String sql="select distinct [机组等级] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultUnitPatternRows() {
		String sql="select distinct [机组型式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCondensateBumpConfigurationRows() {
		String sql="select distinct [凝结水泵配置] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCoalMillPatternRows() {
		String sql="select distinct [磨煤机型式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultDustingMethodRows() {
		String sql="select distinct [除尘方式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultSulfurRemoalMethodRows() {
		String sql="select distinct [脱硫方式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultDenitrationMethodRows() {
		String sql="select distinct [脱硝方式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultExternalCoalMethodRows() {
		String sql="select distinct [厂外来煤方式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCoalYardPatternRows() {
		String sql="select distinct [煤场型式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultAshRemovalSystemRows() {
		String sql="select distinct [除灰系统] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPCStoveMediumSpeedCoalChildSystemRows() {
		String sql="select distinct [PC炉中速磨石子煤系统] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPCStoveSlagRemovalSystemRows() {
		String sql="select distinct [PC炉除渣系统] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCFBStoveSlagRemovalSystemRows() {
		String sql="select distinct [CFB炉除渣系统] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCFBStoveBedMaterialRows() {
		String sql="select distinct [CFB炉床料系统] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCFBStoveLimestoneBreakSystemRows() {
		String sql="select distinct [CFB炉石灰石细碎系统] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultAshExternalExportRows() {
		String sql="select distinct [灰渣厂外输送] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCirculatingCoolingMethodRows() {
		String sql="select distinct [循环冷却方式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultWaterSourceRows() {
		String sql="select distinct [水源] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCoolingTowerPatternRows() {
		String sql="select distinct [冷却塔型式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultRawWaterPreprocessRows() {
		String sql="select distinct [原水预处理] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultSeaWaterDesalinationProcessRows() {
		String sql="select distinct [海水淡化处理] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultBoilerFeedwaterProcessRows() {
		String sql="select distinct [锅炉补给水处理] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCondensatePolishingRows() {
		String sql="select distinct [凝结水精处理] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCoolingWaterProcessRows() {
		String sql="select distinct [冷却水处理] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultHydrogenStationRows() {
		String sql="select distinct [氢气站] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultStackInnerTankPatternRows() {
		String sql="select distinct [烟囱内筒型式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainFactoryFoundationPatternRows() {
		String sql="select distinct [主厂区基础型式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainFactoryStructurePatternRows() {
		String sql="select distinct [主厂房结构型式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultAmmoniaForDenitrationRows() {
		String sql="select distinct [脱硝用氨] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultFireProtectionStandardRows() {
		String sql="select distinct [消防标准] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainFactoryLayoutRows() {
		String sql="select distinct [主厂房布置] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultDesignBasicSeismicAccelerationRows() {
		String sql="select distinct [设计基本地震加速度] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPowerStationOutletVoltageClassRows() {
		String sql="select distinct [发电厂出线电压等级] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultDynamoLoopGCBInstallationRows() {
		String sql="select distinct [发电机回路GCB配置] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultHighVoltageDistributionDeviceMainElectricalConnectionRows() {
		String sql="select distinct [高压配电装置电气主接线] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultHighVoltageDistributionDevicePatternRows() {
		String sql="select distinct [高压配电装置型式] from [dbo].[燃煤项目]";
		return this.dao.select(sql);
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[燃煤项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[燃煤项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[燃煤项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[燃煤项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[燃煤项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationSixRows() {
		String sql="select distinct [预留六] from [dbo].[燃煤项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationSevenRows() {
		String sql="select distinct [预留七] from [dbo].[燃煤项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationEightRows() {
		String sql="select distinct [预留八] from [dbo].[燃煤项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationNineRows() {
		String sql="select distinct [预留九] from [dbo].[燃煤项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTenRows() {
		String sql="select distinct [预留十] from [dbo].[燃煤项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllPid() {
		String sql="select distinct [项目编号] from [dbo].[燃煤项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql="select * from [dbo].[燃煤项目] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[燃煤项目] where [项目编号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}
	
}
