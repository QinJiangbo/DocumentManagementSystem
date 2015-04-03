package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Contract_technology_protocol;
import pojo.Contract_technology_protocol_table;
import pojo.Log;
@SuppressWarnings("rawtypes")
public class ContractTechnologyProtocolServiceImpl implements IContractTechnologyProtocolService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Contract_technology_protocol contract_technology_protocol) {
		String sql="insert into [dbo].[合同及技术协议]([项目编号],[项目名称],[机组容量],[专业名称],[设备名称],[项目所在国],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={contract_technology_protocol.getPid(),contract_technology_protocol.getName(),contract_technology_protocol.getCapacity(),contract_technology_protocol.getProfession_name(),contract_technology_protocol.getDevice_name(),contract_technology_protocol.getNation(),contract_technology_protocol.getPreparation_one(),contract_technology_protocol.getPreparation_two(),contract_technology_protocol.getPreparation_three(),contract_technology_protocol.getPreparation_four(),contract_technology_protocol.getPreparation_five(),contract_technology_protocol.getType_in_userNme(),contract_technology_protocol.getVerifier(),contract_technology_protocol.getVerify_state(),contract_technology_protocol.getVerify_comment(),contract_technology_protocol.getEntry_time(),contract_technology_protocol.getVerify_time(),contract_technology_protocol.getProject_file_address()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Contract_technology_protocol contract_technology_protocol) {
		String sql="update [dbo].[合同及技术协议] set [项目编号]=?,[项目名称]=?,[机组容量]=?,[专业名称]=?,[设备名称]=?,[项目所在国]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={contract_technology_protocol.getPid(),contract_technology_protocol.getName(),contract_technology_protocol.getCapacity(),contract_technology_protocol.getProfession_name(),contract_technology_protocol.getDevice_name(),contract_technology_protocol.getNation(),contract_technology_protocol.getPreparation_one(),contract_technology_protocol.getPreparation_two(),contract_technology_protocol.getPreparation_three(),contract_technology_protocol.getPreparation_four(),contract_technology_protocol.getPreparation_five(),contract_technology_protocol.getVerifier(),contract_technology_protocol.getVerify_state(),contract_technology_protocol.getEntry_time(),contract_technology_protocol.getId()};
	    this.dao.update(sql, params);
	    return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[合同及技术协议] where [项目编号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[合同及技术协议] where [项目编号] = ?";
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
		String sql = "select count(*) n from [dbo].[合同及技术协议] where [项目编号] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[合同及技术协议] where [项目编号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[合同及技术协议] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[合同及技术协议] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Contract_technology_protocol contract_technology_protocol) {
		Contract_technology_protocol_table contract_technology_protocol_table=new Contract_technology_protocol_table(contract_technology_protocol);
		if(contract_technology_protocol_table.getPid()!=""){
			String sql="select * from [dbo].[合同及技术协议] where "+contract_technology_protocol_table.getPid()+contract_technology_protocol_table.getName()+contract_technology_protocol_table.getCapacity()+contract_technology_protocol_table.getProfession_name()+contract_technology_protocol_table.getDevice_name()+contract_technology_protocol_table.getNation()+contract_technology_protocol_table.getPreparation_one()+contract_technology_protocol_table.getPreparation_two()+contract_technology_protocol_table.getPreparation_three()+contract_technology_protocol_table.getPreparation_four()+contract_technology_protocol_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[合同及技术协议] where [审核状态] = 2 ";
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
		String sql = "select * from [dbo].[合同及技术协议] where [项目编号] like \"%"+pid+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname, int state) {
		String sql = "select * from [dbo].[合同及技术协议] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Contract_technology_protocol contract_technology_protocol) {
		String sql="update [dbo].[合同及技术协议] set [项目编号]=?,[项目名称]=?,[机组容量]=?,[专业名称]=?,[设备名称]=?,[项目所在国]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={contract_technology_protocol.getPid(),contract_technology_protocol.getName(),contract_technology_protocol.getCapacity(),contract_technology_protocol.getProfession_name(),contract_technology_protocol.getDevice_name(),contract_technology_protocol.getNation(),contract_technology_protocol.getPreparation_one(),contract_technology_protocol.getPreparation_two(),contract_technology_protocol.getPreparation_three(),contract_technology_protocol.getPreparation_four(),contract_technology_protocol.getPreparation_five(),contract_technology_protocol.getVerify_state(),contract_technology_protocol.getVerify_comment(),contract_technology_protocol.getVerify_time(),contract_technology_protocol.getId()};
	    this.dao.update(sql, params);
	    return true;
	}

	@Override
	public boolean maintenance(Contract_technology_protocol contract_technology_protocol) {
		String sql="update [dbo].[合同及技术协议] set [项目编号]=?,[项目名称]=?,[机组容量]=?,[专业名称]=?,[设备名称]=?,[项目所在国]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={contract_technology_protocol.getPid(),contract_technology_protocol.getName(),contract_technology_protocol.getCapacity(),contract_technology_protocol.getProfession_name(),contract_technology_protocol.getDevice_name(),contract_technology_protocol.getNation(),contract_technology_protocol.getPreparation_one(),contract_technology_protocol.getPreparation_two(),contract_technology_protocol.getPreparation_three(),contract_technology_protocol.getPreparation_four(),contract_technology_protocol.getPreparation_five(),contract_technology_protocol.getVerifier(),contract_technology_protocol.getId()};
	    this.dao.update(sql, params);
	    return true;
	}

	@Override
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[合同及技术协议] where [项目编号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultCapacityRows() {
		String sql="select distinct [机组容量] from [dbo].[合同及技术协议]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultProfessionNameRows() {
		String sql="select distinct [专业名称] from [dbo].[合同及技术协议]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultNationRows() {
		String sql="select distinct [项目所在国] from [dbo].[合同及技术协议]";
		return this.dao.select(sql);
	}
	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[合同及技术协议]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[合同及技术协议]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[合同及技术协议]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[合同及技术协议]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[合同及技术协议]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllPid() {
		String sql="select distinct [项目编号] from [dbo].[合同及技术协议]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[合同及技术协议] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[合同及技术协议] where [项目编号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}

}
