package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Home_broad_standard;
import pojo.Home_broad_standard_table;
import pojo.Log;
@SuppressWarnings("rawtypes")
public class HomeBroadStandardServiceImpl implements IHomeBroadStandardService{
	private IDbHelper dao = new DbHelperImpl();

	@Override
	public boolean add(Home_broad_standard home_broad_standard) {
		String sql="insert into [dbo].[国内外规程规范及相关标准]([标准编号],[名称],[国别],[专业],[摘要],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={home_broad_standard.getPid(),home_broad_standard.getName(),home_broad_standard.getNation(),home_broad_standard.getProfession(),home_broad_standard.getSummary(),home_broad_standard.getPreparation_one(),home_broad_standard.getPreparation_two(),home_broad_standard.getPreparation_three(),home_broad_standard.getPreparation_four(),home_broad_standard.getPreparation_five(),home_broad_standard.getType_in_userNme(),home_broad_standard.getVerifier(),home_broad_standard.getVerify_state(),home_broad_standard.getVerify_comment(),home_broad_standard.getEntry_time(),home_broad_standard.getVerify_time(),home_broad_standard.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Home_broad_standard home_broad_standard) {
		String sql="update [dbo].[国内外规程规范及相关标准] set [标准编号]=?,[名称]=?,[国别]=?,[专业]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={home_broad_standard.getPid(),home_broad_standard.getName(),home_broad_standard.getNation(),home_broad_standard.getProfession(),home_broad_standard.getSummary(),home_broad_standard.getPreparation_one(),home_broad_standard.getPreparation_two(),home_broad_standard.getPreparation_three(),home_broad_standard.getPreparation_four(),home_broad_standard.getPreparation_five(),home_broad_standard.getVerifier(),home_broad_standard.getVerify_state(),home_broad_standard.getEntry_time(),home_broad_standard.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[国内外规程规范及相关标准] where [标准编号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[国内外规程规范及相关标准] where [标准编号] = ?";
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
		String sql = "select count(*) n from [dbo].[国内外规程规范及相关标准] where [标准编号] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[国内外规程规范及相关标准] where [标准编号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[国内外规程规范及相关标准] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[国内外规程规范及相关标准] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Home_broad_standard home_broad_standard) {
		Home_broad_standard_table home_broad_standard_table=new Home_broad_standard_table(home_broad_standard);
		if(home_broad_standard_table.getPid()!=""){
			String sql="select * from [dbo].[国内外规程规范及相关标准] where "+home_broad_standard_table.getPid()+home_broad_standard_table.getName()+home_broad_standard_table.getNation()+home_broad_standard_table.getProfession()+home_broad_standard_table.getSummary()+home_broad_standard_table.getPreparation_one()+home_broad_standard_table.getPreparation_two()+home_broad_standard_table.getPreparation_three()+home_broad_standard_table.getPreparation_four()+home_broad_standard_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[国内外规程规范及相关标准] where [审核状态] = 2";
			return this.dao.select(sql);
		}
	}

	@Override
	public Map[] query(String pid, String name) {
		if(name!=null&name!=""){
			name = " and [名称] like \"%"+name+"%\"";
		}
		else {
			name = "";
		}
		String sql = "select * from [dbo].[国内外规程规范及相关标准] where [标准编号] like \"%"+pid+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname, int state) {
		String sql = "select * from [dbo].[国内外规程规范及相关标准] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Home_broad_standard home_broad_standard) {
		String sql="update [dbo].[国内外规程规范及相关标准] set [标准编号]=?,[名称]=?,[国别]=?,[专业]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={home_broad_standard.getPid(),home_broad_standard.getName(),home_broad_standard.getNation(),home_broad_standard.getProfession(),home_broad_standard.getSummary(),home_broad_standard.getPreparation_one(),home_broad_standard.getPreparation_two(),home_broad_standard.getPreparation_three(),home_broad_standard.getPreparation_four(),home_broad_standard.getPreparation_five(),home_broad_standard.getVerify_state(),home_broad_standard.getVerify_comment(),home_broad_standard.getVerify_time(),home_broad_standard.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Home_broad_standard home_broad_standard) {
		String sql="update [dbo].[国内外规程规范及相关标准] set [标准编号]=?,[名称]=?,[国别]=?,[专业]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={home_broad_standard.getPid(),home_broad_standard.getName(),home_broad_standard.getNation(),home_broad_standard.getProfession(),home_broad_standard.getSummary(),home_broad_standard.getPreparation_one(),home_broad_standard.getPreparation_two(),home_broad_standard.getPreparation_three(),home_broad_standard.getPreparation_four(),home_broad_standard.getPreparation_five(),home_broad_standard.getVerifier(),home_broad_standard.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[国内外规程规范及相关标准] where [标准编号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultNationRows() {
		String sql = "select distinct [国别] from [dbo].[国内外规程规范及相关标准]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultProfessionRows() {
		String sql = "select distinct [专业] from [dbo].[国内外规程规范及相关标准]";
		return dao.select(sql);
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[国内外规程规范及相关标准]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[国内外规程规范及相关标准]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[国内外规程规范及相关标准]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[国内外规程规范及相关标准]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[国内外规程规范及相关标准]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllPid() {
		String sql="select distinct [标准编号] from [dbo].[国内外规程规范及相关标准]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[国内外规程规范及相关标准] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[国内外规程规范及相关标准] where [标准编号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}
	
}
