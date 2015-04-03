package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Log;
import pojo.Technology;
import pojo.Technology_table;
@SuppressWarnings("rawtypes")
public class TechnologyServiceImpl implements ITechnologyService{

	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Technology technology) {
		String sql="insert into [dbo].[技经]([项目名称或编号],[类型],[容量],[设计阶段],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={technology.getPid(),technology.getType(),technology.getCapacity(),technology.getDesign_phase(),technology.getPreparation_one(),technology.getPreparation_two(),technology.getPreparation_three(),technology.getPreparation_four(),technology.getPreparation_five(),technology.getType_in_userNme(),technology.getVerifier(),technology.getVerify_state(),technology.getVerify_comment(),technology.getEntry_time(),technology.getVerify_time(),technology.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Technology technology) {
		String sql="update [dbo].[技经] set [项目名称或编号]=?,[类型]=?,[容量]=?,[设计阶段]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={technology.getPid(),technology.getType(),technology.getCapacity(),technology.getDesign_phase(),technology.getPreparation_one(),technology.getPreparation_two(),technology.getPreparation_three(),technology.getPreparation_four(),technology.getPreparation_five(),technology.getVerifier(),technology.getVerify_state(),technology.getEntry_time(),technology.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[技经] where [项目名称或编号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[技经] where [项目名称或编号] = ?";
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
		String sql = "select count(*) n from [dbo].[技经] where [项目名称或编号] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[技经] where [项目名称或编号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[技经] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[技经] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Technology technology) {
		Technology_table technology_table=new Technology_table(technology);
		if(technology_table.getPid()!=""){
			String sql="select * from [dbo].[技经] where "+technology_table.getPid()+technology_table.getType()+technology_table.getCapacity()+technology_table.getDesign_phase()+technology_table.getPreparation_one()+technology_table.getPreparation_two()+technology_table.getPreparation_three()+technology_table.getPreparation_four()+technology_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[技经] where [审核状态] = 2";
			return this.dao.select(sql);
		}
	}

	@Override
	public Map[] query(String pid, String type) {
		if(type!=null&type!=""){
			type = " and [类型] like \"%"+type+"%\"";
		}
		else {
			type = "";
		}
		String sql = "select * from [dbo].[技经] where [项目名称或编号] like \"%"+pid+"%\""+type;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname, int state) {
		String sql = "select * from [dbo].[技经] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Technology technology) {
		String sql="update [dbo].[技经] set [项目名称或编号]=?,[类型]=?,[容量]=?,[设计阶段]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={technology.getPid(),technology.getType(),technology.getCapacity(),technology.getDesign_phase(),technology.getPreparation_one(),technology.getPreparation_two(),technology.getPreparation_three(),technology.getPreparation_four(),technology.getPreparation_five(),technology.getVerify_state(),technology.getVerify_comment(),technology.getVerify_time(),technology.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Technology technology) {
		String sql="update [dbo].[技经] set [项目名称或编号]=?,[类型]=?,[容量]=?,[设计阶段]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={technology.getPid(),technology.getType(),technology.getCapacity(),technology.getDesign_phase(),technology.getPreparation_one(),technology.getPreparation_two(),technology.getPreparation_three(),technology.getPreparation_four(),technology.getPreparation_five(),technology.getVerifier(),technology.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[技经] where [项目名称或编号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultCapacityRows() {
		String sql="select distinct [容量] from [dbo].[技经]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultDesignPhaseRows() {
		String sql="select distinct [设计阶段] from [dbo].[技经]";
		return this.dao.select(sql);
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[技经]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[技经]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[技经]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[技经]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[技经]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllPid() {
		String sql="select distinct [项目名称或编号] from [dbo].[技经]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[技经] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[技经] where [项目名称或编号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}

}
