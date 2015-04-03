package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Biomass_rubbish_project;
import pojo.Biomass_rubbish_project_table;
import pojo.Log;
@SuppressWarnings("rawtypes")
public class BiomassRubbishProjectServiceImpl implements IBiomassRubbishProjectService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Biomass_rubbish_project biomass_rubbish_project) {
		String sql="insert into [dbo].[生物质、垃圾发电项目]([项目编号],[项目名称],[项目类别],[项目所在国],[项目所在地区],[装机数量],[建设方式],[锅炉类型],[燃料类型],[除尘方式],[脱硫方式],[年平均气温],[极端最高气温],[极端最低气温],[平均相对湿度],[循环冷却方式],[水源],[冷却塔型式],[消防标准],[原水预处理],[厂区面积],[设计基本地震加速度],[基础型式],[主厂房结构型式],[循环水系统概述],[预留一],[预留二],[预留三],[预留四],[预留五],[预留六],[预留七],[预留八],[预留九],[预留十] ,[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={biomass_rubbish_project.getPid(),biomass_rubbish_project.getName(),biomass_rubbish_project.getType(),biomass_rubbish_project.getNation(),biomass_rubbish_project.getArea(),biomass_rubbish_project.getInstallation_number(),biomass_rubbish_project.getConstruction_mode(),biomass_rubbish_project.getBoiler_type(),biomass_rubbish_project.getFuel_type(),biomass_rubbish_project.getDusting_method(),biomass_rubbish_project.getSulfur_removal_method(),biomass_rubbish_project.getAverage_temperature(),biomass_rubbish_project.getExtreme_high_temperature(),biomass_rubbish_project.getExtreme_low_temperature(),biomass_rubbish_project.getAverage_relative_humid(),biomass_rubbish_project.getCirculating_cooling_method(),biomass_rubbish_project.getWater_source(),biomass_rubbish_project.getCooling_tower_pattern(),biomass_rubbish_project.getFire_protection_standard(),biomass_rubbish_project.getRaw_water_preprocess(),biomass_rubbish_project.getFactory_area(),biomass_rubbish_project.getDesign_basic_seismic_acceleration(),biomass_rubbish_project.getFoundation_type(),biomass_rubbish_project.getMain_factory_structure_pattern(),biomass_rubbish_project.getWater_circulation_system_overview(),biomass_rubbish_project.getPreparation_one(),biomass_rubbish_project.getPreparation_two(),biomass_rubbish_project.getPreparation_three(),biomass_rubbish_project.getPreparation_four(),biomass_rubbish_project.getPreparation_five(),biomass_rubbish_project.getPreparation_six(),biomass_rubbish_project.getPreparation_seven(),biomass_rubbish_project.getPreparation_eight(),biomass_rubbish_project.getPreparation_nine(),biomass_rubbish_project.getPreparation_ten(),biomass_rubbish_project.getType_in_userNme(),biomass_rubbish_project.getVerifier(),biomass_rubbish_project.getVerify_state(),biomass_rubbish_project.getVerify_comment(),biomass_rubbish_project.getEntry_time(),biomass_rubbish_project.getVerify_time(),biomass_rubbish_project.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Biomass_rubbish_project biomass_rubbish_project) {
		String sql="update [dbo].[生物质、垃圾发电项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[装机数量]=?,[建设方式]=?,[锅炉类型]=?,[燃料类型]=?,[除尘方式]=?,[脱硫方式]=?,[年平均气温]=?,[极端最高气温]=?,[极端最低气温]=?,[平均相对湿度]=?,[循环冷却方式]=?,[水源]=?,[冷却塔型式]=?,[消防标准]=?,[原水预处理]=?,[厂区面积]=?,[设计基本地震加速度]=?,[基础型式]=?,[主厂房结构型式]=?,[循环水系统概述]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[预留六]=?,[预留七]=?,[预留八]=?,[预留九]=?,[预留十]=? ,[审核人]=?,[审核状态]=? ,[录入时间]=? where [编号]=?";
		Object[] params={biomass_rubbish_project.getPid(),biomass_rubbish_project.getName(),biomass_rubbish_project.getType(),biomass_rubbish_project.getNation(),biomass_rubbish_project.getArea(),biomass_rubbish_project.getInstallation_number(),biomass_rubbish_project.getConstruction_mode(),biomass_rubbish_project.getBoiler_type(),biomass_rubbish_project.getFuel_type(),biomass_rubbish_project.getDusting_method(),biomass_rubbish_project.getSulfur_removal_method(),biomass_rubbish_project.getAverage_temperature(),biomass_rubbish_project.getExtreme_high_temperature(),biomass_rubbish_project.getExtreme_low_temperature(),biomass_rubbish_project.getAverage_relative_humid(),biomass_rubbish_project.getCirculating_cooling_method(),biomass_rubbish_project.getWater_source(),biomass_rubbish_project.getCooling_tower_pattern(),biomass_rubbish_project.getFire_protection_standard(),biomass_rubbish_project.getRaw_water_preprocess(),biomass_rubbish_project.getFactory_area(),biomass_rubbish_project.getDesign_basic_seismic_acceleration(),biomass_rubbish_project.getFoundation_type(),biomass_rubbish_project.getMain_factory_structure_pattern(),biomass_rubbish_project.getWater_circulation_system_overview(),biomass_rubbish_project.getPreparation_one(),biomass_rubbish_project.getPreparation_two(),biomass_rubbish_project.getPreparation_three(),biomass_rubbish_project.getPreparation_four(),biomass_rubbish_project.getPreparation_five(),biomass_rubbish_project.getPreparation_six(),biomass_rubbish_project.getPreparation_seven(),biomass_rubbish_project.getPreparation_eight(),biomass_rubbish_project.getPreparation_nine(),biomass_rubbish_project.getPreparation_ten(),biomass_rubbish_project.getVerifier(),biomass_rubbish_project.getVerify_state(),biomass_rubbish_project.getEntry_time(),biomass_rubbish_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[生物质、垃圾发电项目] where [项目编号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[生物质、垃圾发电项目] where [项目编号] = ?";
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
		String sql = "select count(*) n from [dbo].[生物质、垃圾发电项目] where [项目编号] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[生物质、垃圾发电项目] where [项目编号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[生物质、垃圾发电项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[生物质、垃圾发电项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Biomass_rubbish_project biomass_rubbish_project) {
		Biomass_rubbish_project_table biomass_rubbish_project_table =new Biomass_rubbish_project_table(biomass_rubbish_project); 
		if(biomass_rubbish_project_table.getPid()!=""){
			String sql="select * from [dbo].[生物质、垃圾发电项目] where "+biomass_rubbish_project_table.getPid()+biomass_rubbish_project_table.getName()+biomass_rubbish_project_table.getType()+biomass_rubbish_project_table.getNation()+biomass_rubbish_project_table.getInstallation_number()+biomass_rubbish_project_table.getConstruction_mode()+biomass_rubbish_project_table.getBoiler_type()+biomass_rubbish_project_table.getFuel_type()+biomass_rubbish_project_table.getDusting_method()+biomass_rubbish_project_table.getSulfur_removal_method()+biomass_rubbish_project_table.getAverage_temperature()+biomass_rubbish_project_table.getExtreme_high_temperature()+biomass_rubbish_project_table.getExtreme_low_temperature()+biomass_rubbish_project_table.getAverage_relative_humid()+biomass_rubbish_project_table.getCirculating_cooling_method()+biomass_rubbish_project_table.getWater_source()+biomass_rubbish_project_table.getCooling_tower_pattern()+biomass_rubbish_project_table.getFire_protection_standard()+biomass_rubbish_project_table.getRaw_water_preprocess()+biomass_rubbish_project_table.getFactory_area()+biomass_rubbish_project_table.getDesign_basic_seismic_acceleration()+biomass_rubbish_project_table.getFoundation_type()+biomass_rubbish_project_table.getMain_factory_structure_pattern()+biomass_rubbish_project_table.getWater_circulation_system_overview()+biomass_rubbish_project_table.getPreparation_one()+biomass_rubbish_project_table.getPreparation_two()+biomass_rubbish_project_table.getPreparation_three()+biomass_rubbish_project_table.getPreparation_four()+biomass_rubbish_project_table.getPreparation_five()+biomass_rubbish_project_table.getPreparation_six()+biomass_rubbish_project_table.getPreparation_seven()+biomass_rubbish_project_table.getPreparation_eight()+biomass_rubbish_project_table.getPreparation_nine()+biomass_rubbish_project_table.getPreparation_ten()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql = "select * from [dbo].[生物质、垃圾发电项目] where [审核状态] = 2";
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
		String sql = "select * from [dbo].[生物质、垃圾发电项目] where [项目编号] like \"%"+pid+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname,int state) {
		String sql = "select * from [dbo].[生物质、垃圾发电项目] where [审核人] = ? and [审核状态] = ?";
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
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[生物质、垃圾发电项目] where [项目编号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultTypeRows() {
		String sql="select distinct [项目类别] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultNationRows() {
		String sql="select distinct [项目所在国] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultConstructionModeRows() {
		String sql="select distinct [建设方式] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultBoilerTypeRows() {
		String sql="select distinct [锅炉类型] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultFuelTypeRows() {
		String sql="select distinct [燃料类型] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultDustingMethodRows() {
		String sql="select distinct [除尘方式] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultSulfurRemovalMethodRows() {
		String sql="select distinct [脱硫方式] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCirculatingCoolingMethodRows() {
		String sql="select distinct [循环冷却方式] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultWaterSourceRows() {
		String sql="select distinct [水源] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCoolingTowerPatternRows() {
		String sql="select distinct [冷却塔型式] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultFireProtectionStantardRows() {
		String sql="select distinct [消防标准] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultRawWaterPreprocessRows() {
		String sql="select distinct [原水预处理] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultDesignBasicSeismicAccelerationRows() {
		String sql="select distinct [设计基本地震加速度] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultFoundationTypeRows() {
		String sql="select distinct [基础型式] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainFactoryStructurePatternRows() {
		String sql="select distinct [主厂房结构型式] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[生物质、垃圾发电项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[生物质、垃圾发电项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[生物质、垃圾发电项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationSixRows() {
		String sql="select distinct [预留六] from [dbo].[生物质、垃圾发电项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationSevenRows() {
		String sql="select distinct [预留七] from [dbo].[生物质、垃圾发电项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationEightRows() {
		String sql="select distinct [预留八] from [dbo].[生物质、垃圾发电项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationNineRows() {
		String sql="select distinct [预留九] from [dbo].[生物质、垃圾发电项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTenRows() {
		String sql="select distinct [预留十] from [dbo].[生物质、垃圾发电项目]";
		return dao.select(sql);
	}

	@Override
	public boolean verify(Biomass_rubbish_project biomass_rubbish_project) {
		String sql="update [dbo].[生物质、垃圾发电项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[装机数量]=?,[建设方式]=?,[锅炉类型]=?,[燃料类型]=?,[除尘方式]=?,[脱硫方式]=?,[年平均气温]=?,[极端最高气温]=?,[极端最低气温]=?,[平均相对湿度]=?,[循环冷却方式]=?,[水源]=?,[冷却塔型式]=?,[消防标准]=?,[原水预处理]=?,[厂区面积]=?,[设计基本地震加速度]=?,[基础型式]=?,[主厂房结构型式]=?,[循环水系统概述]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[预留六]=?,[预留七]=?,[预留八]=?,[预留九]=?,[预留十]=? ,[审核状态]=? ,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={biomass_rubbish_project.getPid(),biomass_rubbish_project.getName(),biomass_rubbish_project.getType(),biomass_rubbish_project.getNation(),biomass_rubbish_project.getArea(),biomass_rubbish_project.getInstallation_number(),biomass_rubbish_project.getConstruction_mode(),biomass_rubbish_project.getBoiler_type(),biomass_rubbish_project.getFuel_type(),biomass_rubbish_project.getDusting_method(),biomass_rubbish_project.getSulfur_removal_method(),biomass_rubbish_project.getAverage_temperature(),biomass_rubbish_project.getExtreme_high_temperature(),biomass_rubbish_project.getExtreme_low_temperature(),biomass_rubbish_project.getAverage_relative_humid(),biomass_rubbish_project.getCirculating_cooling_method(),biomass_rubbish_project.getWater_source(),biomass_rubbish_project.getCooling_tower_pattern(),biomass_rubbish_project.getFire_protection_standard(),biomass_rubbish_project.getRaw_water_preprocess(),biomass_rubbish_project.getFactory_area(),biomass_rubbish_project.getDesign_basic_seismic_acceleration(),biomass_rubbish_project.getFoundation_type(),biomass_rubbish_project.getMain_factory_structure_pattern(),biomass_rubbish_project.getWater_circulation_system_overview(),biomass_rubbish_project.getPreparation_one(),biomass_rubbish_project.getPreparation_two(),biomass_rubbish_project.getPreparation_three(),biomass_rubbish_project.getPreparation_four(),biomass_rubbish_project.getPreparation_five(),biomass_rubbish_project.getPreparation_six(),biomass_rubbish_project.getPreparation_seven(),biomass_rubbish_project.getPreparation_eight(),biomass_rubbish_project.getPreparation_nine(),biomass_rubbish_project.getPreparation_ten(),biomass_rubbish_project.getVerify_state(),biomass_rubbish_project.getVerify_comment(),biomass_rubbish_project.getVerify_time(),biomass_rubbish_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Biomass_rubbish_project biomass_rubbish_project) {
		String sql="update [dbo].[生物质、垃圾发电项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[装机数量]=?,[建设方式]=?,[锅炉类型]=?,[燃料类型]=?,[除尘方式]=?,[脱硫方式]=?,[年平均气温]=?,[极端最高气温]=?,[极端最低气温]=?,[平均相对湿度]=?,[循环冷却方式]=?,[水源]=?,[冷却塔型式]=?,[消防标准]=?,[原水预处理]=?,[厂区面积]=?,[设计基本地震加速度]=?,[基础型式]=?,[主厂房结构型式]=?,[循环水系统概述]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[预留六]=?,[预留七]=?,[预留八]=?,[预留九]=?,[预留十]=? ,[审核人]=? where [编号]=?";
		Object[] params={biomass_rubbish_project.getPid(),biomass_rubbish_project.getName(),biomass_rubbish_project.getType(),biomass_rubbish_project.getNation(),biomass_rubbish_project.getArea(),biomass_rubbish_project.getInstallation_number(),biomass_rubbish_project.getConstruction_mode(),biomass_rubbish_project.getBoiler_type(),biomass_rubbish_project.getFuel_type(),biomass_rubbish_project.getDusting_method(),biomass_rubbish_project.getSulfur_removal_method(),biomass_rubbish_project.getAverage_temperature(),biomass_rubbish_project.getExtreme_high_temperature(),biomass_rubbish_project.getExtreme_low_temperature(),biomass_rubbish_project.getAverage_relative_humid(),biomass_rubbish_project.getCirculating_cooling_method(),biomass_rubbish_project.getWater_source(),biomass_rubbish_project.getCooling_tower_pattern(),biomass_rubbish_project.getFire_protection_standard(),biomass_rubbish_project.getRaw_water_preprocess(),biomass_rubbish_project.getFactory_area(),biomass_rubbish_project.getDesign_basic_seismic_acceleration(),biomass_rubbish_project.getFoundation_type(),biomass_rubbish_project.getMain_factory_structure_pattern(),biomass_rubbish_project.getWater_circulation_system_overview(),biomass_rubbish_project.getPreparation_one(),biomass_rubbish_project.getPreparation_two(),biomass_rubbish_project.getPreparation_three(),biomass_rubbish_project.getPreparation_four(),biomass_rubbish_project.getPreparation_five(),biomass_rubbish_project.getPreparation_six(),biomass_rubbish_project.getPreparation_seven(),biomass_rubbish_project.getPreparation_eight(),biomass_rubbish_project.getPreparation_nine(),biomass_rubbish_project.getPreparation_ten(),biomass_rubbish_project.getVerifier(),biomass_rubbish_project.getId()};
		this.dao.update(sql, params);
		return true;
	}
	@Override
	public Map[] getAllPid() {
		String sql="select distinct [项目编号] from [dbo].[生物质、垃圾发电项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[生物质、垃圾发电项目] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[生物质、垃圾发电项目] where [项目编号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}

}
