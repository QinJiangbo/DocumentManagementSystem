package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Log;
import pojo.Power_transfer_engineering_project;
import pojo.Power_transfer_engineering_project_table;
@SuppressWarnings("rawtypes")
public class PowerTransferEngineeringProjectServiceImpl implements IPowerTransferEngineeringProjectService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Power_transfer_engineering_project power_transfer_engineering_project) {
		String sql="insert into [dbo].[变电工程项目]([项目编号],[项目名称],[项目类别],[项目所在国],[项目所在地区],[变电站类型],[单台主变容量],[主变台数],[主变一次侧电压],[主变二次侧电压],[主变第三绕组电压],[主变一次侧电压配电装置电气主接线],[主变二次侧电压配电装置电气主接线],[主变第三绕组侧电压配电装置电气主接线],[主变一次侧电压配电装置型式],[主变二次侧电压配电装置型式],[主变第三绕组侧电压配电装置型式],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={power_transfer_engineering_project.getPid(),power_transfer_engineering_project.getName(),power_transfer_engineering_project.getType(),power_transfer_engineering_project.getNation(),power_transfer_engineering_project.getArea(),power_transfer_engineering_project.getPower_transfer_type(),power_transfer_engineering_project.getSingle_main_transformation_capacity(),power_transfer_engineering_project.getMain_transformation_number(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage(),power_transfer_engineering_project.getMain_transformation_second_side_voltage(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_second_side_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage_power_distribution_pattern(),power_transfer_engineering_project.getMain_transformation_second_side_voltage_power_distribution_pattern(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage_power_distribution_pattern(),power_transfer_engineering_project.getPreparation_one(),power_transfer_engineering_project.getPreparation_two(),power_transfer_engineering_project.getPreparation_three(),power_transfer_engineering_project.getPreparation_four(),power_transfer_engineering_project.getPreparation_five(),power_transfer_engineering_project.getType_in_userNme(),power_transfer_engineering_project.getVerifier(),power_transfer_engineering_project.getVerify_state(),power_transfer_engineering_project.getVerify_comment(),power_transfer_engineering_project.getEntry_time(),power_transfer_engineering_project.getVerify_time(),power_transfer_engineering_project.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Power_transfer_engineering_project power_transfer_engineering_project) {
		String sql="update [dbo].[变电工程项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[变电站类型]=?,[单台主变容量]=?,[主变台数]=?,[主变一次侧电压]=?,[主变二次侧电压]=?,[主变第三绕组电压]=?,[主变一次侧电压配电装置电气主接线]=?,[主变二次侧电压配电装置电气主接线]=?,[主变第三绕组侧电压配电装置电气主接线]=?,[主变一次侧电压配电装置型式]=?,[主变二次侧电压配电装置型式]=?,[主变第三绕组侧电压配电装置型式]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={power_transfer_engineering_project.getPid(),power_transfer_engineering_project.getName(),power_transfer_engineering_project.getType(),power_transfer_engineering_project.getNation(),power_transfer_engineering_project.getArea(),power_transfer_engineering_project.getPower_transfer_type(),power_transfer_engineering_project.getSingle_main_transformation_capacity(),power_transfer_engineering_project.getMain_transformation_number(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage(),power_transfer_engineering_project.getMain_transformation_second_side_voltage(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_second_side_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage_power_distribution_pattern(),power_transfer_engineering_project.getMain_transformation_second_side_voltage_power_distribution_pattern(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage_power_distribution_pattern(),power_transfer_engineering_project.getPreparation_one(),power_transfer_engineering_project.getPreparation_two(),power_transfer_engineering_project.getPreparation_three(),power_transfer_engineering_project.getPreparation_four(),power_transfer_engineering_project.getPreparation_five(),power_transfer_engineering_project.getVerifier(),power_transfer_engineering_project.getVerify_state(),power_transfer_engineering_project.getEntry_time(),power_transfer_engineering_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[变电工程项目] where [项目编号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[变电工程项目] where [项目编号] = ?";
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
		String sql = "select count(*) n from [dbo].[变电工程项目] where [项目编号] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[变电工程项目] where [项目编号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[变电工程项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[变电工程项目] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Power_transfer_engineering_project power_transfer_engineering_project) {
		Power_transfer_engineering_project_table power_transfer_engineering_project_table=new Power_transfer_engineering_project_table(power_transfer_engineering_project);
		if(power_transfer_engineering_project_table.getPid()!=""){
			String sql="select * from [dbo].[变电工程项目] where "+power_transfer_engineering_project_table.getPid()+power_transfer_engineering_project_table.getName()+power_transfer_engineering_project_table.getType()+power_transfer_engineering_project_table.getNation()+power_transfer_engineering_project_table.getArea()+power_transfer_engineering_project_table.getPower_transfer_type()+power_transfer_engineering_project_table.getSingle_main_transformation_capacity()+power_transfer_engineering_project_table.getMain_transformation_number()+power_transfer_engineering_project_table.getMain_transformation_primary_side_voltage()+power_transfer_engineering_project_table.getMain_transformation_second_side_voltage()+power_transfer_engineering_project_table.getMain_transformation_third_winding_voltage()+power_transfer_engineering_project_table.getMain_transformation_primary_side_voltage_power_distribution_main_wire()+power_transfer_engineering_project_table.getMain_transformation_second_side_voltage_power_distribution_main_wire()+power_transfer_engineering_project_table.getMain_transformation_third_winding_voltage_power_distribution_main_wire()+power_transfer_engineering_project_table.getMain_transformation_primary_side_voltage_power_distribution_pattern()+power_transfer_engineering_project_table.getMain_transformation_second_side_voltage_power_distribution_pattern()+power_transfer_engineering_project_table.getMain_transformation_third_winding_voltage_power_distribution_pattern()+power_transfer_engineering_project_table.getPreparation_one()+power_transfer_engineering_project_table.getPreparation_two()+power_transfer_engineering_project_table.getPreparation_three()+power_transfer_engineering_project_table.getPreparation_four()+power_transfer_engineering_project_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[变电工程项目] where [审核状态] = 2";
			return this.dao.select(sql);
		}
	}

	@Override
	public Map[] briefQuery(String uname,int state) {
		String sql = "select * from [dbo].[变电工程项目] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Power_transfer_engineering_project power_transfer_engineering_project) {
		String sql="update [dbo].[变电工程项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[变电站类型]=?,[单台主变容量]=?,[主变台数]=?,[主变一次侧电压]=?,[主变二次侧电压]=?,[主变第三绕组电压]=?,[主变一次侧电压配电装置电气主接线]=?,[主变二次侧电压配电装置电气主接线]=?,[主变第三绕组侧电压配电装置电气主接线]=?,[主变一次侧电压配电装置型式]=?,[主变二次侧电压配电装置型式]=?,[主变第三绕组侧电压配电装置型式]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={power_transfer_engineering_project.getPid(),power_transfer_engineering_project.getName(),power_transfer_engineering_project.getType(),power_transfer_engineering_project.getNation(),power_transfer_engineering_project.getArea(),power_transfer_engineering_project.getPower_transfer_type(),power_transfer_engineering_project.getSingle_main_transformation_capacity(),power_transfer_engineering_project.getMain_transformation_number(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage(),power_transfer_engineering_project.getMain_transformation_second_side_voltage(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_second_side_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage_power_distribution_pattern(),power_transfer_engineering_project.getMain_transformation_second_side_voltage_power_distribution_pattern(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage_power_distribution_pattern(),power_transfer_engineering_project.getPreparation_one(),power_transfer_engineering_project.getPreparation_two(),power_transfer_engineering_project.getPreparation_three(),power_transfer_engineering_project.getPreparation_four(),power_transfer_engineering_project.getPreparation_five(),power_transfer_engineering_project.getVerify_state(),power_transfer_engineering_project.getVerify_comment(),power_transfer_engineering_project.getVerify_time(),power_transfer_engineering_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Power_transfer_engineering_project power_transfer_engineering_project) {
		String sql="update [dbo].[变电工程项目] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目所在地区]=?,[变电站类型]=?,[单台主变容量]=?,[主变台数]=?,[主变一次侧电压]=?,[主变二次侧电压]=?,[主变第三绕组电压]=?,[主变一次侧电压配电装置电气主接线]=?,[主变二次侧电压配电装置电气主接线]=?,[主变第三绕组侧电压配电装置电气主接线]=?,[主变一次侧电压配电装置型式]=?,[主变二次侧电压配电装置型式]=?,[主变第三绕组侧电压配电装置型式]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={power_transfer_engineering_project.getPid(),power_transfer_engineering_project.getName(),power_transfer_engineering_project.getType(),power_transfer_engineering_project.getNation(),power_transfer_engineering_project.getArea(),power_transfer_engineering_project.getPower_transfer_type(),power_transfer_engineering_project.getSingle_main_transformation_capacity(),power_transfer_engineering_project.getMain_transformation_number(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage(),power_transfer_engineering_project.getMain_transformation_second_side_voltage(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_second_side_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage_power_distribution_main_wire(),power_transfer_engineering_project.getMain_transformation_primary_side_voltage_power_distribution_pattern(),power_transfer_engineering_project.getMain_transformation_second_side_voltage_power_distribution_pattern(),power_transfer_engineering_project.getMain_transformation_third_winding_voltage_power_distribution_pattern(),power_transfer_engineering_project.getPreparation_one(),power_transfer_engineering_project.getPreparation_two(),power_transfer_engineering_project.getPreparation_three(),power_transfer_engineering_project.getPreparation_four(),power_transfer_engineering_project.getPreparation_five(),power_transfer_engineering_project.getVerifier(),power_transfer_engineering_project.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[变电工程项目] where [项目编号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultTypeRows() {
		String sql="select distinct [项目类别] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultNationRows() {
		String sql="select distinct [项目所在国] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPowerTransferTypeRows() {
		String sql="select distinct [变电站类型] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultSingleMainTransformationCapacityRows() {
		String sql="select distinct [单台主变容量] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainTransformationNumberRows() {
		String sql="select distinct [主变台数] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainTransformationPrimarySideVoltageRows() {
		String sql="select distinct [主变一次侧电压] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainTransformationSecondSideVoltageRows() {
		String sql="select distinct [主变二次侧电压] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainTransformationThirdWindingVoltageRows() {
		String sql="select distinct [主变第三绕组电压] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainTransformationPrimarySideVoltagePowerDistributionMainWireRows() {
		String sql="select distinct [主变一次侧电压配电装置电气主接线] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainTransformationSecondSideVoltagePowerDistributionMainWireRows() {
		String sql="select distinct [主变二次侧电压配电装置电气主接线] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainTransformationThirdWindingVoltagePowerDistributionMainWireRows() {
		String sql="select distinct [主变第三绕组侧电压配电装置电气主接线] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainTransformationPrimarySideVoltagePowerDistributionPatternRows() {
		String sql="select distinct [主变一次侧电压配电装置型式] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainTransformationSecondSideVoltagePowerDistributionPatternRows() {
		String sql="select distinct [主变二次侧电压配电装置型式] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultMainTransformationThirdWindingVoltagePowerDistributionPatternRows() {
		String sql="select distinct [主变第三绕组侧电压配电装置型式] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[变电工程项目]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[变电工程项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[变电工程项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[变电工程项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(String pid, String name) {
		if(name!=null&name!=""){
			name = " and [项目名称] like \"%"+name+"%\"";
		}
		else {
			name = "";
		}
		String sql = "select * from [dbo].[变电工程项目] where [项目编号] like \"%"+pid+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public Map[] getAllPid() {
		String sql="select distinct [项目编号] from [dbo].[变电工程项目]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[变电工程项目] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[变电工程项目] where [项目编号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}

}
