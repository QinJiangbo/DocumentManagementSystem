package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Log;
import pojo.Other;
import pojo.Other_table;
@SuppressWarnings("rawtypes")
public class OtherServiceImpl implements IOtherService{

	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Other other) {
		String sql="insert into [dbo].[其他]([专家讲座],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={other.getExpert_lecture(),other.getPreparation_one(),other.getPreparation_two(),other.getPreparation_three(),other.getPreparation_four(),other.getPreparation_five(),other.getType_in_userNme(),other.getVerifier(),other.getVerify_state(),other.getVerify_comment(),other.getEntry_time(),other.getVerify_time(),other.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Other other) {
		String sql="update [dbo].[其他] set [专家讲座]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={other.getExpert_lecture(),other.getPreparation_one(),other.getPreparation_two(),other.getPreparation_three(),other.getPreparation_four(),other.getPreparation_five(),other.getVerifier(),other.getVerify_state(),other.getEntry_time(),other.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int id) {
		String sql="delete [dbo].[其他] where [编号] = ?";
		Object[] params={id};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[其他] where [编号] = ?";
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
		String sql = "select count(*) n from [dbo].[其他] where [专家讲座] = ? and [审核状态] > -1";
		Object[] params = {id};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String id) {
		String sql = "select count(*) n from [dbo].[其他] where [专家讲座] = ? and [审核状态] = 0";
		Object[] params = {id};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[其他] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[其他] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Other other) {
		Other_table other_table=new Other_table(other);
		if(other_table.getExpert_lecture()!=""){
			String sql="select * from [dbo].[其他] where "+other_table.getExpert_lecture()+other_table.getPreparation_one()+other_table.getPreparation_two()+other_table.getPreparation_three()+other_table.getPreparation_four()+other_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql = "select * from [dbo].[其他] where [审核状态] = 2";
			return this.dao.select(sql);
		}
	}

	@Override
	public Map[] query(String lecture) {
		String sql = "select * from [dbo].[其他] where [专家讲座] like '%"+lecture+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname, int state) {
		String sql = "select * from [dbo].[其他] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Other other) {
		String sql="update [dbo].[其他] set [专家讲座]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={other.getExpert_lecture(),other.getPreparation_one(),other.getPreparation_two(),other.getPreparation_three(),other.getPreparation_four(),other.getPreparation_five(),other.getVerify_state(),other.getVerify_comment(),other.getVerify_time(),other.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Other other) {
		String sql="update [dbo].[其他] set [专家讲座]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={other.getExpert_lecture(),other.getPreparation_one(),other.getPreparation_two(),other.getPreparation_three(),other.getPreparation_four(),other.getPreparation_five(),other.getVerifier(),other.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String expert_lecture, int state) {
		String sql = "select [编号] from [dbo].[其他] where [专家讲座] = ? and [审核状态] = ?";
		Object[] params = {expert_lecture,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[其他]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[其他]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[其他]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[其他]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[其他]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllLecture() {
		String sql="select distinct [专家讲座] from [dbo].[其他]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[其他] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}
}
