package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Log;
import pojo.Power_deliver_project;
import pojo.Power_deliver_project_table;
@SuppressWarnings("rawtypes")
public class PowerDeliverProjectServiceImpl implements IPowerDeliverProjectService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Power_deliver_project power_deliver_project) {
		String sql="insert into [dbo].[送电工程项目]([项目编号],[项目名称],[项目类别],[项目所在国],[项目所在地区],[线路电压等级],[设计风速],[覆冰厚度],[地形地貌],[导线型式],[导线分裂数],[导线截面],[回路数],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={power_deliver_project.getPid(),power_deliver_project.getName(),power_deliver_project.getType(),power_deliver_project.getNation(),power_deliver_project.getArea(),power_deliver_project.getLine_voltage_level(),power_deliver_project.getDesign_wind_speed(),power_deliver_project.getIcing_thickness(),power_deliver_project.getLandform(),power_deliver_project.getWire_pattern(),power_deliver_project.getWire_divide_number(),power_deliver_project.getWire_cross_section(),power_deliver_project.getLoop_numbers(),power_deliver_project.getPreparation_one(),power_deliver_project.getPreparation_two(),power_deliver_project.getPreparation_three(),power_deliver_project.getPreparation_four(),power_deliver_project.getPreparation_five(),power_deliver_project.getType_in_userNme(),power_deliver_project.getVerifier(),power_deliver_project.getVerify_state(),power_deliver_project.getVerify_comment(),power_deliver_project.getEntry_time(),power_deliver_project.getVerify_time(),power_deliver_project.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Power_deliver_project power_deliver_project) {
		String sql="update [dbo].[送电工程项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[线路电压等级]=?,[设计风速]=?,[覆冰厚度]=?,[地形地貌]=?,[导线型式]=?,[导线分裂数]=?,[导线截面]=?,[回路数]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={power_deliver_project.getPid(),power_deliver_project.getName(),power_deliver_project.getType(),power_deliver_project.getNation(),power_deliver_project.getArea(),power_deliver_project.getLine_voltage_level(),power_deliver_project.getDesign_wind_speed(),power_deliver_project.getIcing_thickness(),power_deliver_project.getLandform(),power_deliver_project.getWire_pattern(),power_deliver_project.getWire_divide_number(),power_deliver_project.getWire_cross_section(),power_deliver_project.getLoop_numbers(),power_deliver_project.getPreparation_one(),power_deliver_project.getPreparation_two(),power_deliver_project.getPreparation_three(),power_deliver_project.getPreparation_four(),power_deliver_project.getPreparation_five(),power_deliver_project.getVerifier(),power_deliver_project.getVerify_state(),power_deliver_project.getEntry_time(),power_deliver_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[送电工程项目] where [项目编号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[送电工程项目] where [项目编号] = ?";
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
		String sql = "select count(*) n from [dbo].[送电工程项目] where [项目编号] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[送电工程项目] where [项目编号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[送电工程项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[送电工程项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Power_deliver_project power_deliver_project) {
		Power_deliver_project_table power_deliver_project_table=new Power_deliver_project_table(power_deliver_project);
		if(power_deliver_project_table.getPid()!=""){
			String sql="select * from [dbo].[送电工程项目] where "+power_deliver_project_table.getPid()+power_deliver_project_table.getName()+power_deliver_project_table.getType()+power_deliver_project_table.getNation()+power_deliver_project_table.getArea()+power_deliver_project_table.getLine_voltage_level()+power_deliver_project_table.getDesign_wind_speed()+power_deliver_project_table.getIcing_thickness()+power_deliver_project_table.getLandform()+power_deliver_project_table.getWire_pattern()+power_deliver_project_table.getWire_divide_number()+power_deliver_project_table.getWire_cross_section()+power_deliver_project_table.getLoop_numbers()+power_deliver_project_table.getPreparation_one()+power_deliver_project_table.getPreparation_two()+power_deliver_project_table.getPreparation_three()+power_deliver_project_table.getPreparation_four()+power_deliver_project_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[送电工程项目] where [审核状态] = 2";
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
		String sql = "select * from [dbo].[送电工程项目] where [项目编号] like \"%"+pid+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname,int state) {
		String sql = "select * from [dbo].[送电工程项目] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Power_deliver_project power_deliver_project) {
		String sql="update [dbo].[送电工程项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[线路电压等级]=?,[设计风速]=?,[覆冰厚度]=?,[地形地貌]=?,[导线型式]=?,[导线分裂数]=?,[导线截面]=?,[回路数]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={power_deliver_project.getPid(),power_deliver_project.getName(),power_deliver_project.getType(),power_deliver_project.getNation(),power_deliver_project.getArea(),power_deliver_project.getLine_voltage_level(),power_deliver_project.getDesign_wind_speed(),power_deliver_project.getIcing_thickness(),power_deliver_project.getLandform(),power_deliver_project.getWire_pattern(),power_deliver_project.getWire_divide_number(),power_deliver_project.getWire_cross_section(),power_deliver_project.getLoop_numbers(),power_deliver_project.getPreparation_one(),power_deliver_project.getPreparation_two(),power_deliver_project.getPreparation_three(),power_deliver_project.getPreparation_four(),power_deliver_project.getPreparation_five(),power_deliver_project.getVerify_state(),power_deliver_project.getVerify_comment(),power_deliver_project.getVerify_time(),power_deliver_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Power_deliver_project power_deliver_project) {
		String sql="update [dbo].[送电工程项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[线路电压等级]=?,[设计风速]=?,[覆冰厚度]=?,[地形地貌]=?,[导线型式]=?,[导线分裂数]=?,[导线截面]=?,[回路数]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={power_deliver_project.getPid(),power_deliver_project.getName(),power_deliver_project.getType(),power_deliver_project.getNation(),power_deliver_project.getArea(),power_deliver_project.getLine_voltage_level(),power_deliver_project.getDesign_wind_speed(),power_deliver_project.getIcing_thickness(),power_deliver_project.getLandform(),power_deliver_project.getWire_pattern(),power_deliver_project.getWire_divide_number(),power_deliver_project.getWire_cross_section(),power_deliver_project.getLoop_numbers(),power_deliver_project.getPreparation_one(),power_deliver_project.getPreparation_two(),power_deliver_project.getPreparation_three(),power_deliver_project.getPreparation_four(),power_deliver_project.getPreparation_five(),power_deliver_project.getVerifier(),power_deliver_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[送电工程项目] where [项目编号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultNameRows() {
		String sql="select distinct [项目名称] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultTypeRows() {
		String sql="select distinct [项目类别] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultNationRows() {
		String sql="select distinct [项目所在国] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultLineVoltageLevelRows() {
		String sql="select distinct [线路电压等级] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultDesignWindSpeedRows() {
		String sql="select distinct [设计风速] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultIcingThicknessRows() {
		String sql="select distinct [覆冰厚度] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultLandformRows() {
		String sql="select distinct [地形地貌] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultWirePatternRows() {
		String sql="select distinct [导线型式] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultWireDivideNumberRows() {
		String sql="select distinct [导线分裂数] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultWireCrossSectionRows() {
		String sql="select distinct [导线截面] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultLoopNumbersRows() {
		String sql="select distinct [回路数] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[送电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[送电工程项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[送电工程项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[送电工程项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllPid() {
		String sql="select distinct [项目编号] from [dbo].[送电工程项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[送电工程项目] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}
	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[送电工程项目] where [项目编号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}
}
