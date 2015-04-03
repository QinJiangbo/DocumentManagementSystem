package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Company_technology_achievement;
import pojo.Company_technology_achievement_table;
import pojo.Log;
@SuppressWarnings("rawtypes")
public class CompanyTechnologyAchievementServiceImpl implements ICompanyTechnologyAchievementService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Company_technology_achievement company_technology_achievement) {
		String sql="insert into [dbo].[公司科技成果]([名称],[专业],[完成时间],[摘要],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={company_technology_achievement.getName(),company_technology_achievement.getProfession(),company_technology_achievement.getComplete_time(),company_technology_achievement.getSummary(),company_technology_achievement.getPreparation_one(),company_technology_achievement.getPreparation_two(),company_technology_achievement.getPreparation_three(),company_technology_achievement.getPreparation_four(),company_technology_achievement.getPreparation_five(),company_technology_achievement.getType_in_userNme(),company_technology_achievement.getVerifier(),company_technology_achievement.getVerify_state(),company_technology_achievement.getVerify_comment(),company_technology_achievement.getEntry_time(),company_technology_achievement.getVerify_time(),company_technology_achievement.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Company_technology_achievement company_technology_achievement) {
		String sql="update [dbo].[公司科技成果] set [名称]=?,[专业]=?,[完成时间]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={company_technology_achievement.getName(),company_technology_achievement.getProfession(),company_technology_achievement.getComplete_time(),company_technology_achievement.getSummary(),company_technology_achievement.getPreparation_one(),company_technology_achievement.getPreparation_two(),company_technology_achievement.getPreparation_three(),company_technology_achievement.getPreparation_four(),company_technology_achievement.getPreparation_five(),company_technology_achievement.getVerifier(),company_technology_achievement.getVerify_state(),company_technology_achievement.getEntry_time(),company_technology_achievement.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[公司科技成果] where [名称] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[公司科技成果] where [名称] = ?";
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
		String sql = "select count(*) n from [dbo].[公司科技成果] where [名称] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[公司科技成果] where [名称] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[公司科技成果] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[公司科技成果] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Company_technology_achievement company_technology_achievement) {
		Company_technology_achievement_table company_technology_achievement_table =new Company_technology_achievement_table(company_technology_achievement);
		if(company_technology_achievement_table.getName()!=""){
			String sql="select * from [dbo].[公司科技成果] where "+company_technology_achievement_table.getName()+company_technology_achievement_table.getProfession()+company_technology_achievement_table.getComplete_time()+company_technology_achievement_table.getSummary()+company_technology_achievement_table.getPreparation_one()+company_technology_achievement_table.getPreparation_two()+company_technology_achievement_table.getPreparation_three()+company_technology_achievement_table.getPreparation_four()+company_technology_achievement_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[公司科技成果] where [审核状态] = 2 ";
			return this.dao.select(sql);
		}
	}

	@Override
	public Map[] query(String name, String profession) {
		if(name!=null&name!=""){
			name = " and [名称] like \"%"+name+"%\"";
		}
		else {
			name = "";
		}
		String sql = "select * from [dbo].[公司科技成果] where [专业] like \"%"+profession+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname, int state) {
		String sql = "select * from [dbo].[公司科技成果] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Company_technology_achievement company_technology_achievement) {
		String sql="update [dbo].[公司科技成果] set [名称]=?,[专业]=?,[完成时间]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[审核时间]=? where [编号]=?";
		Object[] params={company_technology_achievement.getName(),company_technology_achievement.getProfession(),company_technology_achievement.getComplete_time(),company_technology_achievement.getSummary(),company_technology_achievement.getPreparation_one(),company_technology_achievement.getPreparation_two(),company_technology_achievement.getPreparation_three(),company_technology_achievement.getPreparation_four(),company_technology_achievement.getPreparation_five(),company_technology_achievement.getVerifier(),company_technology_achievement.getVerify_state(),company_technology_achievement.getVerify_time(),company_technology_achievement.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Company_technology_achievement company_technology_achievement) {
		String sql="update [dbo].[公司科技成果] set [名称]=?,[专业]=?,[完成时间]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={company_technology_achievement.getName(),company_technology_achievement.getProfession(),company_technology_achievement.getComplete_time(),company_technology_achievement.getSummary(),company_technology_achievement.getPreparation_one(),company_technology_achievement.getPreparation_two(),company_technology_achievement.getPreparation_three(),company_technology_achievement.getPreparation_four(),company_technology_achievement.getPreparation_five(),company_technology_achievement.getVerifier(),company_technology_achievement.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[公司科技成果] where [名称] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultProfessionRows() {
		String sql="select distinct [专业] from [dbo].[公司科技成果]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultCompleteTimeRows() {
		String sql="select distinct [完成时间] from [dbo].[公司科技成果]";
		return this.dao.select(sql);
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[公司科技成果]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[公司科技成果]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[公司科技成果]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[公司科技成果]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[公司科技成果]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllName() {
		String sql="select distinct [名称] from [dbo].[公司科技成果]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql="select * from [dbo].[公司科技成果] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String name) {
		String sql = "select * from [dbo].[公司科技成果] where [名称] like '%"+name+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}

}
