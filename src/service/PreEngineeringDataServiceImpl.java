package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Log;
import pojo.Pre_engineering_data;
import pojo.Pre_engineering_data_table;
@SuppressWarnings("rawtypes")
public class PreEngineeringDataServiceImpl implements IPreEngineeringDataService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Pre_engineering_data pre_engineering_data) {
		String sql="insert into [dbo].[工程前期数据]([序号],[类别],[名称],[摘要],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={pre_engineering_data.getPid(),pre_engineering_data.getType(),pre_engineering_data.getName(),pre_engineering_data.getSummary(),pre_engineering_data.getPreparation_one(),pre_engineering_data.getPreparation_two(),pre_engineering_data.getPreparation_three(),pre_engineering_data.getPreparation_four(),pre_engineering_data.getPreparation_five(),pre_engineering_data.getType_in_userNme(),pre_engineering_data.getVerifier(),pre_engineering_data.getVerify_state(),pre_engineering_data.getVerify_comment(),pre_engineering_data.getEntry_time(),pre_engineering_data.getVerify_time()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Pre_engineering_data pre_engineering_data) {
		String sql="update [dbo].[工程前期数据] set [序号]=?,[类别]=?,[名称]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=? ";
		Object[] params={pre_engineering_data.getPid(),pre_engineering_data.getType(),pre_engineering_data.getName(),pre_engineering_data.getSummary(),pre_engineering_data.getPreparation_one(),pre_engineering_data.getPreparation_two(),pre_engineering_data.getPreparation_three(),pre_engineering_data.getPreparation_four(),pre_engineering_data.getPreparation_five(),pre_engineering_data.getVerifier(),pre_engineering_data.getVerify_state(),pre_engineering_data.getEntry_time(),pre_engineering_data.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[工程前期数据] where [序号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[工程前期数据] where [序号] = ?";
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
		String sql = "select count(*) n from [dbo].[工程前期数据] where [序号] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[工程前期数据] where [序号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[工程前期数据] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[工程前期数据] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Pre_engineering_data pre_engineering_data) {
		Pre_engineering_data_table pre_engineering_data_table=new Pre_engineering_data_table(pre_engineering_data);
		if(pre_engineering_data_table.getPid()!=""){
			String sql="select * from [dbo].[工程前期数据] where "+pre_engineering_data_table.getPid()+pre_engineering_data_table.getType()+pre_engineering_data_table.getSummary()+pre_engineering_data_table.getPreparation_one()+pre_engineering_data_table.getPreparation_two()+pre_engineering_data_table.getPreparation_three()+pre_engineering_data_table.getPreparation_four()+pre_engineering_data_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[工程前期数据] where [审核状态] = 2";
			return this.dao.select(sql);
		}
	}

	@Override
	public Map[] query(String pid, String type) {
		if(type!=null&type!=""){
			type = " and [类别] like \"%"+type+"%\"";
		}
		else {
			type = "";
		}
		String sql = "select * from [dbo].[工程前期数据] where [序号] like \"%"+pid+"%\""+type;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname, int state) {
		String sql = "select * from [dbo].[工程前期数据] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Pre_engineering_data pre_engineering_data) {
		String sql="update [dbo].[工程前期数据] set [序号]=?,[类别]=?,[名称]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=? ";
		Object[] params={pre_engineering_data.getPid(),pre_engineering_data.getType(),pre_engineering_data.getName(),pre_engineering_data.getSummary(),pre_engineering_data.getPreparation_one(),pre_engineering_data.getPreparation_two(),pre_engineering_data.getPreparation_three(),pre_engineering_data.getPreparation_four(),pre_engineering_data.getPreparation_five(),pre_engineering_data.getVerify_state(),pre_engineering_data.getVerify_comment(),pre_engineering_data.getVerify_time(),pre_engineering_data.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Pre_engineering_data pre_engineering_data) {
		String sql="update [dbo].[工程前期数据] set [序号]=?,[类别]=?,[名称]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=? ";
		Object[] params={pre_engineering_data.getPid(),pre_engineering_data.getType(),pre_engineering_data.getName(),pre_engineering_data.getSummary(),pre_engineering_data.getPreparation_one(),pre_engineering_data.getPreparation_two(),pre_engineering_data.getPreparation_three(),pre_engineering_data.getPreparation_four(),pre_engineering_data.getPreparation_five(),pre_engineering_data.getVerifier(),pre_engineering_data.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[工程前期数据] where [序号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultTypeRows() {
		String sql="select distinct [类别] from [dbo].[工程前期数据]";
		return this.dao.select(sql);
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[工程前期数据]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[工程前期数据]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[工程前期数据]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[工程前期数据]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[工程前期数据]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllPid() {
		String sql="select distinct [序号] from [dbo].[工程前期数据]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[工程前期数据] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[工程前期数据] where [序号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}

}
