package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Engineer_summary;
import pojo.Engineer_summary_table;
import pojo.Log;
@SuppressWarnings("rawtypes")
public class EngineerSummaryServiceImpl implements IEngineerSummaryService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Engineer_summary engineer_summary) {
		String sql="insert into [dbo].[工程总结]([项目编号],[项目名称],[项目类别],[项目所在国],[项目类型],[锅炉型式],[摘要],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={engineer_summary.getPid(),engineer_summary.getName(),engineer_summary.getType(),engineer_summary.getNation(),engineer_summary.getPattern(),engineer_summary.getBoiler_pattern(),engineer_summary.getSummary(),engineer_summary.getPreparation_one(),engineer_summary.getPreparation_two(),engineer_summary.getPreparation_three(),engineer_summary.getPreparation_four(),engineer_summary.getPreparation_five(),engineer_summary.getType_in_userNme(),engineer_summary.getVerifier(),engineer_summary.getVerify_state(),engineer_summary.getVerify_comment(),engineer_summary.getEntry_time(),engineer_summary.getVerify_time(),engineer_summary.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Engineer_summary engineer_summary) {
		String sql="update [dbo].[工程总结] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目类型]=?,[锅炉型式]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={engineer_summary.getPid(),engineer_summary.getName(),engineer_summary.getType(),engineer_summary.getNation(),engineer_summary.getPattern(),engineer_summary.getBoiler_pattern(),engineer_summary.getSummary(),engineer_summary.getPreparation_one(),engineer_summary.getPreparation_two(),engineer_summary.getPreparation_three(),engineer_summary.getPreparation_four(),engineer_summary.getPreparation_five(),engineer_summary.getVerifier(),engineer_summary.getVerify_state(),engineer_summary.getEntry_time(),engineer_summary.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[工程总结] where [项目编号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[工程总结] where [项目编号] = ?";
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
		String sql = "select count(*) n from [dbo].[工程总结] where [项目编号] = ?  and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[工程总结] where [项目编号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[工程总结] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[工程总结] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Engineer_summary engineer_summary) {
		Engineer_summary_table engineer_summary_table=new Engineer_summary_table(engineer_summary);
		if(engineer_summary_table.getPid()!=""){
			String sql="select * from [dbo].[工程总结] where "+engineer_summary_table.getPid()+engineer_summary_table.getName()+engineer_summary_table.getType()+engineer_summary_table.getNation()+engineer_summary_table.getPattern()+engineer_summary_table.getBoiler_pattern()+engineer_summary_table.getSummary()+engineer_summary_table.getPreparation_one()+engineer_summary_table.getPreparation_two()+engineer_summary_table.getPreparation_three()+engineer_summary_table.getPreparation_four()+engineer_summary_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[工程总结] where [审核状态] = 2";
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
		String sql = "select * from [dbo].[工程总结] where [项目编号] like \"%"+pid+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname, int state) {
		String sql = "select * from [dbo].[工程总结] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Engineer_summary engineer_summary) {
		String sql="update [dbo].[工程总结] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目类型]=?,[锅炉型式]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={engineer_summary.getPid(),engineer_summary.getName(),engineer_summary.getType(),engineer_summary.getNation(),engineer_summary.getPattern(),engineer_summary.getBoiler_pattern(),engineer_summary.getSummary(),engineer_summary.getPreparation_one(),engineer_summary.getPreparation_two(),engineer_summary.getPreparation_three(),engineer_summary.getPreparation_four(),engineer_summary.getPreparation_five(),engineer_summary.getVerify_state(),engineer_summary.getVerify_comment(),engineer_summary.getVerify_time(),engineer_summary.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Engineer_summary engineer_summary) {
		String sql="update [dbo].[工程总结] set [项目编号]=?,[项目名称]=?,[项目类别]=?,[项目所在国]=?,[项目类型]=?,[锅炉型式]=?,[摘要]=?,[预留一],[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={engineer_summary.getPid(),engineer_summary.getName(),engineer_summary.getType(),engineer_summary.getNation(),engineer_summary.getPattern(),engineer_summary.getBoiler_pattern(),engineer_summary.getSummary(),engineer_summary.getPreparation_one(),engineer_summary.getPreparation_two(),engineer_summary.getPreparation_three(),engineer_summary.getPreparation_four(),engineer_summary.getPreparation_five(),engineer_summary.getVerifier(),engineer_summary.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[工程总结] where [项目编号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultTypeRows() {
		String sql="select distinct [项目类别] from [dbo].[工程总结]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultNationRows() {
		String sql="select distinct [项目所在国] from [dbo].[工程总结]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPatternRows() {
		String sql="select distinct [项目类型] from [dbo].[工程总结]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultBoilerPatternRows() {
		String sql="select distinct [锅炉型式] from [dbo].[工程总结]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[工程总结]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[工程总结]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[工程总结]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[工程总结]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[工程总结]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllPid() {
		String sql="select distinct [项目编号] from [dbo].[工程总结]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[工程总结] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[工程总结] where [项目编号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}

}
