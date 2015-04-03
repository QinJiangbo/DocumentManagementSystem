package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Log;
import pojo.Project_expert;
import pojo.Project_expert_table;
@SuppressWarnings("rawtypes")
public class ProjectExpertServiceImpl implements IProjectExpertService{

	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Project_expert project_expert) {
		String sql="insert into [dbo].[工程专家]([姓名],[专业],[所在单位],[学历],[毕业学校],[参加工作时间],[身份证],[职务],[职称],[联系电话],[手机],[传真],[email],[通讯地址],[邮编],[技术专长],[工作简历],[主要业绩],[获奖情况],[著作及论文],[备注],[预留一],[预留二],[预留三],[预留四],[预留五],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={project_expert.getName(),project_expert.getProfession(),project_expert.getDepartment(),project_expert.getEducation_background(),project_expert.getGraduation_school(),project_expert.getWorking_time(),project_expert.getIdentified_card(),project_expert.getJob(),project_expert.getJob_title(),project_expert.getContact_number(),project_expert.getTelephone(),project_expert.getFax(),project_expert.getEmail(),project_expert.getMailing_address(),project_expert.getPostcode(),project_expert.getTechnical_expertise(),project_expert.getJob_resume(),project_expert.getMain_performance(),project_expert.getAwards(),project_expert.getPapers(),project_expert.getRemark(),project_expert.getPreparation_one(),project_expert.getPreparation_two(),project_expert.getPreparation_three(),project_expert.getPreparation_four(),project_expert.getPreparation_five(),project_expert.getType_in_userNme(),project_expert.getVerifier(),project_expert.getVerify_state(),project_expert.getVerify_comment(),project_expert.getEntry_time(),project_expert.getVerify_time()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean update(Project_expert project_expert) {
		String sql="update [dbo].[工程专家] set [姓名]=?,[专业]=?,[所在单位]=?,[学历]=?,[毕业学校]=?,[参加工作时间]=?,[身份证]=?,[职务]=?,[职称]=?,[联系电话]=?,[手机]=?,[传真]=?,[email]=?,[通讯地址]=?,[邮编]=?,[技术专长]=?,[工作简历]=?,[主要业绩]=?,[获奖情况]=?,[著作及论文]=?,[备注]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={project_expert.getName(),project_expert.getProfession(),project_expert.getDepartment(),project_expert.getEducation_background(),project_expert.getGraduation_school(),project_expert.getWorking_time(),project_expert.getIdentified_card(),project_expert.getJob(),project_expert.getJob_title(),project_expert.getContact_number(),project_expert.getTelephone(),project_expert.getFax(),project_expert.getEmail(),project_expert.getMailing_address(),project_expert.getPostcode(),project_expert.getTechnical_expertise(),project_expert.getJob_resume(),project_expert.getMain_performance(),project_expert.getAwards(),project_expert.getPapers(),project_expert.getRemark(),project_expert.getPreparation_one(),project_expert.getPreparation_two(),project_expert.getPreparation_three(),project_expert.getPreparation_four(),project_expert.getPreparation_five(),project_expert.getVerifier(),project_expert.getVerify_state(),project_expert.getEntry_time(),project_expert.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int id) {
		String sql="delete [dbo].[工程专家] where [编号] = ?";
		Object[] params={id};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[工程专家] where [编号] = ?";
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
		String sql = "select count(*) n from [dbo].[工程专家] where [身份证] = ? and [审核状态] > -1";
		Object[] params = {id};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String id) {
		String sql = "select count(*) n from [dbo].[工程专家] where [身份证] = ? and [审核状态] = 0";
		Object[] params = {id};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[工程专家] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[工程专家] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Project_expert project_expert) {
		Project_expert_table project_expert_table=new Project_expert_table(project_expert);
		if(project_expert_table.getName()!=""){
			String sql = "select * from [dbo].[工程专家] where "+project_expert_table.getName()+project_expert_table.getProfession()+project_expert_table.getDepartment()+project_expert_table.getEducation_background()+project_expert_table.getGraduation_school()+project_expert_table.getWorking_time()+project_expert_table.getIdentified_card()+project_expert_table.getJob()+project_expert_table.getJob_title()+project_expert_table.getContact_number()+project_expert_table.getTelephone()+project_expert_table.getFax()+project_expert_table.getEmail()+project_expert_table.getMailing_address()+project_expert_table.getPostcode()+project_expert_table.getTechnical_expertise()+project_expert_table.getJob_resume()+project_expert_table.getMain_performance()+project_expert_table.getAwards()+project_expert_table.getPapers()+project_expert_table.getRemark()+project_expert_table.getPreparation_one()+project_expert_table.getPreparation_two()+project_expert_table.getPreparation_three()+project_expert_table.getPreparation_four()+project_expert_table.getPreparation_five()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[工程专家] where [审核状态] = 2";
			return this.dao.select(sql);
		}
	}

	@Override
	public Map[] query(String name, String profession) {
		if(name!=null&name!=""){
			name = " and [姓名] like \"%"+name+"%\"";
		}
		else {
			name = "";
		}
		String sql = "select * from [dbo].[工程专家] where [专业] like \"%"+profession+"%\""+name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname, int state) {
		String sql = "select * from [dbo].[工程专家] where [审核人] = ? and [审核状态] = ?";
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
	public boolean verify(Project_expert project_expert) {
		String sql="update [dbo].[工程专家] set [姓名]=?,[专业]=?,[所在单位]=?,[学历]=?,[毕业学校]=?,[参加工作时间]=?,[身份证]=?,[职务]=?,[职称]=?,[联系电话]=?,[手机]=?,[传真]=?,[email]=?,[通讯地址]=?,[邮编]=?,[技术专长]=?,[工作简历]=?,[主要业绩]=?,[获奖情况]=?,[著作及论文]=?,[备注]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核状态]=?,[审核意见]=?,[审核时间]=? where [编号]=?";
		Object[] params={project_expert.getName(),project_expert.getProfession(),project_expert.getDepartment(),project_expert.getEducation_background(),project_expert.getGraduation_school(),project_expert.getWorking_time(),project_expert.getIdentified_card(),project_expert.getJob(),project_expert.getJob_title(),project_expert.getContact_number(),project_expert.getTelephone(),project_expert.getFax(),project_expert.getEmail(),project_expert.getMailing_address(),project_expert.getPostcode(),project_expert.getTechnical_expertise(),project_expert.getJob_resume(),project_expert.getMain_performance(),project_expert.getAwards(),project_expert.getPapers(),project_expert.getRemark(),project_expert.getPreparation_one(),project_expert.getPreparation_two(),project_expert.getPreparation_three(),project_expert.getPreparation_four(),project_expert.getPreparation_five(),project_expert.getVerify_state(),project_expert.getVerify_comment(),project_expert.getVerify_time(),project_expert.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Project_expert project_expert) {
		String sql="update [dbo].[工程专家] set [姓名]=?,[专业]=?,[所在单位]=?,[学历]=?,[毕业学校]=?,[参加工作时间]=?,[身份证]=?,[职务]=?,[职称]=?,[联系电话]=?,[手机]=?,[传真]=?,[email]=?,[通讯地址]=?,[邮编]=?,[技术专长]=?,[工作简历]=?,[主要业绩]=?,[获奖情况]=?,[著作及论文]=?,[备注]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[审核人]=? where [编号]=?";
		Object[] params={project_expert.getName(),project_expert.getProfession(),project_expert.getDepartment(),project_expert.getEducation_background(),project_expert.getGraduation_school(),project_expert.getWorking_time(),project_expert.getIdentified_card(),project_expert.getJob(),project_expert.getJob_title(),project_expert.getContact_number(),project_expert.getTelephone(),project_expert.getFax(),project_expert.getEmail(),project_expert.getMailing_address(),project_expert.getPostcode(),project_expert.getTechnical_expertise(),project_expert.getJob_resume(),project_expert.getMain_performance(),project_expert.getAwards(),project_expert.getPapers(),project_expert.getRemark(),project_expert.getPreparation_one(),project_expert.getPreparation_two(),project_expert.getPreparation_three(),project_expert.getPreparation_four(),project_expert.getPreparation_five(),project_expert.getVerifier(),project_expert.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int getId(String identified_card, int state) {
		String sql = "select [编号] from [dbo].[工程专家] where [身份证] = ? and [审核状态] = ?";
		Object[] params = {identified_card,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultProfessionRows() {
		String sql="select distinct [专业] from [dbo].[工程专家]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultEducationBackgroundRows() {
		String sql="select distinct [学历] from [dbo].[工程专家]";
		return this.dao.select(sql);
	}
	
	@Override
	public Map[] getDefaultJobTitleRows() {
		String sql="select distinct [职称] from [dbo].[工程专家]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[工程专家]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[工程专家]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[工程专家]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[工程专家]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[工程专家]";
		return dao.select(sql);
	}

	@Override
	public Map[] getAllName() {
		String sql="select distinct [姓名] from [dbo].[工程专家]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[工程专家] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String name) {
		String sql = "select * from [dbo].[工程专家] where [姓名] like '%"+name+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}
}
