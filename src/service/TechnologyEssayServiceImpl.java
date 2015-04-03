package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Log;
import pojo.Technology_essay;
import pojo.Technology_essay_table;
@SuppressWarnings("rawtypes")
public class TechnologyEssayServiceImpl implements ITechnologyEssayService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Technology_essay technology_essay) {
		String sql="insert into [dbo].[技术文献]([名称],[专业],[摘要],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={technology_essay.getName(),technology_essay.getProfession(),technology_essay.getSummary(),technology_essay.getPreparation_one(),technology_essay.getPreparation_two(),technology_essay.getPreparation_three(),technology_essay.getPreparation_four(),technology_essay.getPreparation_five(),technology_essay.getType_in_userNme(),technology_essay.getVerifier(),technology_essay.getVerify_state(),technology_essay.getVerify_comment(),technology_essay.getEntry_time(),technology_essay.getVerify_time(),technology_essay.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Technology_essay technology_essay) {
		String sql="update [dbo].[技术文献] set [名称]=?,[专业]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={technology_essay.getName(),technology_essay.getProfession(),technology_essay.getSummary(),technology_essay.getPreparation_one(),technology_essay.getPreparation_two(),technology_essay.getPreparation_three(),technology_essay.getPreparation_four(),technology_essay.getPreparation_five(),technology_essay.getVerifier(),technology_essay.getVerify_state(),technology_essay.getEntry_time(),technology_essay.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int id) {
		String sql="delete [dbo].[技术文献] where [编号] = ?";
		Object[] params={id};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[技术文献] where [编号] = ?";
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
		String sql = "select count(*) n from [dbo].[技术文献] where [名称] = ? and [审核状态] > -1";
		Object[] params = {id};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String id) {
		String sql = "select count(*) n from [dbo].[技术文献] where [名称] = ? and [审核状态] = 0";
		Object[] params = {id};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[技术文献] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[技术文献] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Technology_essay technology_essay) {
		Technology_essay_table technology_essay_table=new Technology_essay_table(technology_essay);
		if(technology_essay_table.getName()!=""){
			String sql="select * from [dbo].[技术文献] where "+technology_essay_table.getName()+technology_essay_table.getProfession()+technology_essay_table.getSummary()+technology_essay_table.getPreparation_one()+technology_essay_table.getPreparation_two()+technology_essay_table.getPreparation_three()+technology_essay_table.getPreparation_four()+technology_essay_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[技术文献] where [审核状态] = 2";
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
		String sql = "select * from [dbo].[技术文献] where [专业] like \"%"+profession+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname, int state) {
		String sql = "select * from [dbo].[技术文献] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Technology_essay technology_essay) {
		String sql="update [dbo].[技术文献] set [名称]=?,[专业]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={technology_essay.getName(),technology_essay.getProfession(),technology_essay.getSummary(),technology_essay.getPreparation_one(),technology_essay.getPreparation_two(),technology_essay.getPreparation_three(),technology_essay.getPreparation_four(),technology_essay.getPreparation_five(),technology_essay.getVerify_state(),technology_essay.getVerify_comment(),technology_essay.getVerify_time(),technology_essay.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Technology_essay technology_essay) {
		String sql="update [dbo].[技术文献] set [名称]=?,[专业]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={technology_essay.getName(),technology_essay.getProfession(),technology_essay.getSummary(),technology_essay.getPreparation_one(),technology_essay.getPreparation_two(),technology_essay.getPreparation_three(),technology_essay.getPreparation_four(),technology_essay.getPreparation_five(),technology_essay.getVerifier(),technology_essay.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String entry_time, int state) {
		String sql = "select [编号] from [dbo].[技术文献] where [名称] = ? and [审核状态] = ?";
		Object[] params = {entry_time,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultProfessionRows() {
		String sql="select distinct [专业] from [dbo].[技术文献]";
		return this.dao.select(sql);
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[技术文献]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[技术文献]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[技术文献]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[技术文献]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[技术文献]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllName() {
		String sql="select distinct [名称] from [dbo].[技术文献]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[技术文献] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String name) {
		String sql = "select * from [dbo].[技术文献] where [名称] like '%"+name+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}

}
