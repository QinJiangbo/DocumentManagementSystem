package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
import pojo.Coal_material;
import pojo.Coal_material_table;
import pojo.Log;
@SuppressWarnings("rawtypes")
public class CoalMaterialServiceImpl implements ICoalMaterialService{
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(Coal_material coal_material) {
		String sql="insert into [dbo].[煤质资料]([标准编号],[工程名称],[硫],[灰分],[水分],[低位发热量],[燃煤产地],[收到基碳],[收到基氢],[收到基氧],[收到基氮],[收到基全硫],[收到基水分],[收到基灰分],[空气干燥基水分],[干燥无灰基挥发分],[收到基低位发热量],[可磨系数],[冲刷磨损指数],[煤粉气流着火温度],[变形温度],[软化温度],[流动温度],[二氧化硅],[三氧化二铝],[三氧化二铁],[氧化钙],[三氧化硫],[可磨性判定],[磨损性判定],[着火稳定性判定],[燃烬特性判定],[灰沾污性能判定],[结渣倾向判定],[煤粉爆炸性判定],[摘要],[预留一],[预留二],[预留三],[预留四],[预留五],[预留六],[预留七],[预留八],[预留九],[预留十],[录入用户名],[审核人],[审核状态],[审核意见],[录入时间],[审核时间],[项目文件路径]) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={coal_material.getPid(),coal_material.getProject_name(),coal_material.getSulfur(),coal_material.getAsh(),coal_material.getMoisture(),coal_material.getNet_calorific_power(),coal_material.getCoal_producing_area(),coal_material.getARB_Car(),coal_material.getARB_Har(),coal_material.getARB_Oar(),coal_material.getARB_Nar(),coal_material.getARB_S(),coal_material.getARB_Mar(),coal_material.getARB_Aar(),coal_material.getMad(),coal_material.getVdaf(),coal_material.getARB_LHV(),coal_material.getHGI(),coal_material.getKe(),coal_material.getIT(),coal_material.getDT(),coal_material.getST(),coal_material.getFT(),coal_material.getSiO2(),coal_material.getAl2O3(),coal_material.getFe2O3(),coal_material.getCaO(),coal_material.getSO3(),coal_material.getGrindability_judge(),coal_material.getAbradability_judge(),coal_material.getFire_stability_judge(),coal_material.getAsh_quality_judge(),coal_material.getPollution_quality_judge(),coal_material.getSlag_bonding_trend_judge(),coal_material.getCoal_dust_explode_judge(),coal_material.getSummary(),coal_material.getPreparation_one(),coal_material.getPreparation_two(),coal_material.getPreparation_three(),coal_material.getPreparation_four(),coal_material.getPreparation_five(),coal_material.getPreparation_six(),coal_material.getPreparation_seven(),coal_material.getPreparation_eight(),coal_material.getPreparation_nine(),coal_material.getPreparation_ten(),coal_material.getType_in_userNme(),coal_material.getVerifier(),coal_material.getVerify_state(),coal_material.getVerify_comment(),coal_material.getEntry_time(),coal_material.getVerify_time(),coal_material.getProject_file_address()};
		this.dao.update(sql,params);
		return true;
	}

	@Override
	public boolean update(Coal_material coal_material) {
		String sql="update [dbo].[煤质资料] set [标准编号]=?,[工程名称]=?,[硫]=?,[灰分]=?,[水分]=?,[低位发热量]=?,[燃煤产地]=?,[收到基碳]=?,[收到基氢]=?,[收到基氧]=?,[收到基氮]=?,[收到基全硫]=?,[收到基水分]=?,[收到基灰分]=?,[空气干燥基水分]=?,[干燥无灰基挥发分]=?,[收到基低位发热量]=?,[可磨系数]=?,[冲刷磨损指数]=?,[煤粉气流着火温度]=?,[变形温度]=?,[软化温度]=?,[流动温度]=?,[二氧化硅]=?,[三氧化二铝]=?,[三氧化二铁]=?,[氧化钙]=?,[三氧化硫]=?,[可磨性判定]=?,[磨损性判定]=?,[着火稳定性判定]=?,[燃烬特性判定]=?,[灰沾污性能判定]=?,[结渣倾向判定]=?,[煤粉爆炸性判定]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[预留六]=?,[预留七]=?,[预留八]=?,[预留九]=?,[预留十]=?,[审核人]=?,[审核状态]=?,[录入时间]=? where [编号]=?";
		Object[] params={coal_material.getPid(),coal_material.getProject_name(),coal_material.getSulfur(),coal_material.getAsh(),coal_material.getMoisture(),coal_material.getNet_calorific_power(),coal_material.getCoal_producing_area(),coal_material.getARB_Car(),coal_material.getARB_Har(),coal_material.getARB_Oar(),coal_material.getARB_Nar(),coal_material.getARB_S(),coal_material.getARB_Mar(),coal_material.getARB_Aar(),coal_material.getMad(),coal_material.getVdaf(),coal_material.getARB_LHV(),coal_material.getHGI(),coal_material.getKe(),coal_material.getIT(),coal_material.getDT(),coal_material.getST(),coal_material.getFT(),coal_material.getSiO2(),coal_material.getAl2O3(),coal_material.getFe2O3(),coal_material.getCaO(),coal_material.getSO3(),coal_material.getGrindability_judge(),coal_material.getAbradability_judge(),coal_material.getFire_stability_judge(),coal_material.getAsh_quality_judge(),coal_material.getPollution_quality_judge(),coal_material.getSlag_bonding_trend_judge(),coal_material.getCoal_dust_explode_judge(),coal_material.getSummary(),coal_material.getPreparation_one(),coal_material.getPreparation_two(),coal_material.getPreparation_three(),coal_material.getPreparation_four(),coal_material.getPreparation_five(),coal_material.getPreparation_six(),coal_material.getPreparation_seven(),coal_material.getPreparation_eight(),coal_material.getPreparation_nine(),coal_material.getPreparation_ten(),coal_material.getVerifier(),coal_material.getVerify_state(),coal_material.getEntry_time(),coal_material.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(int pid) {
		String sql="delete [dbo].[煤质资料] where [标准编号] = ?";
		Object[] params={pid};
		this.dao.update(sql, params);
		String sql2="select count(*) n from [dbo].[煤质资料] where [标准编号] = ?";
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
		String sql = "select count(*) n from [dbo].[煤质资料] where [标准编号] = ? and [审核状态] > -1";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public boolean isSave(String pid) {
		String sql = "select count(*) n from [dbo].[煤质资料] where [标准编号] = ? and [审核状态] = 0";
		Object[] params = {pid};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n==1;
	}

	@Override
	public boolean hasSave(String uname) {
		String sql = "select count(*) n from [dbo].[煤质资料] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("n").toString());
		return n>=1;
	}

	@Override
	public Map[] primaryQuery(String uname) {
		String sql = "select * from [dbo].[煤质资料] where [录入用户名] = ? and [审核状态] = 0";
		Object[] params = {uname};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(Coal_material coal_material) {
		Coal_material_table coal_material_table=new Coal_material_table(coal_material);
		if(coal_material_table.getPid()!=""){
			String sql="select * from [dbo].[煤质资料] where "+coal_material_table.getPid()+coal_material_table.getProject_name()+coal_material_table.getSulfur()+coal_material_table.getAsh()+coal_material_table.getMoisture()+coal_material_table.getNet_calorific_power()+coal_material_table.getCoal_producing_area()+coal_material_table.getARB_Car()+coal_material_table.getARB_Har()+coal_material_table.getARB_Oar()+coal_material_table.getARB_Nar()+coal_material_table.getARB_S()+coal_material_table.getARB_Mar()+coal_material_table.getARB_Aar()+coal_material_table.getMad()+coal_material_table.getVdaf()+coal_material_table.getARB_LHV()+coal_material_table.getHGI()+coal_material_table.getKe()+coal_material_table.getIT()+coal_material_table.getDT()+coal_material_table.getST()+coal_material_table.getFT()+coal_material_table.getSiO2()+coal_material_table.getAl2O3()+coal_material_table.getFe2O3()+coal_material_table.getCaO()+coal_material_table.getSO3()+coal_material_table.getGrindability_judge()+coal_material_table.getAbradability_judge()+coal_material_table.getFire_stability_judge()+coal_material_table.getAsh_quality_judge()+coal_material_table.getPollution_quality_judge()+coal_material_table.getSlag_bonding_trend_judge()+coal_material_table.getCoal_dust_explode_judge()+coal_material_table.getSummary()+coal_material_table.getPreparation_one()+coal_material_table.getPreparation_two()+coal_material_table.getPreparation_three()+coal_material_table.getPreparation_four()+coal_material_table.getPreparation_five()+coal_material_table.getPreparation_six()+coal_material_table.getPreparation_seven()+coal_material_table.getPreparation_eight()+coal_material_table.getPreparation_nine()+coal_material_table.getPreparation_ten()+" and [审核状态] = 2";
			return this.dao.select(sql);
		}
		else{
			String sql="select * from [dbo].[煤质资料] where [审核状态]=2";
			return this.dao.select(sql);
		}
	}

	@Override
	public Map[] query(String pid, String project_name) {
		if(project_name!=null&project_name!=""){
			project_name = " and [工程名称] like \"%"+project_name+"%\"";
		}
		else {
			project_name = "";
		}
		String sql = "select * from [dbo].[煤质资料] where [标准编号] like \"%"+pid+"%\""+project_name;
		return dao.select(sql);
	}

	@Override
	public Map[] briefQuery(String uname, int state) {
		String sql = "select * from [dbo].[煤质资料] where [审核人] = ? and [审核状态] = ?";
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
	public int getId(String pid, int state) {
		String sql = "select [编号] from [dbo].[煤质资料] where [标准编号] = ? and [审核状态] = ?";
		Object[] params = {pid,state};
		Map row = dao.select(sql, params)[0];
		int n = Integer.parseInt(row.get("编号").toString());
		return n;
	}

	@Override
	public Map[] getDefaultSulfurRows() {
		String sql="select distinct [硫] from [dbo].[煤质资料]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationOneRows() {
		String sql="select distinct [预留一] from [dbo].[煤质资料]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTwoRows() {
		String sql="select distinct [预留二] from [dbo].[煤质资料]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationThreeRows() {
		String sql="select distinct [预留三] from [dbo].[煤质资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFourRows() {
		String sql="select distinct [预留四] from [dbo].[煤质资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationFiveRows() {
		String sql="select distinct [预留五] from [dbo].[煤质资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationSixRows() {
		String sql="select distinct [预留六] from [dbo].[煤质资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationSevenRows() {
		String sql="select distinct [预留七] from [dbo].[煤质资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationEightRows() {
		String sql="select distinct [预留八] from [dbo].[煤质资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationNineRows() {
		String sql="select distinct [预留九] from [dbo].[煤质资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] getDefaultPreparationTenRows() {
		String sql="select distinct [预留十] from [dbo].[煤质资料]";
		return dao.select(sql);
	}

	@Override
	public boolean verify(Coal_material coal_material) {
		String sql="update [dbo].[煤质资料] set [标准编号]=?,[工程名称]=?,[硫]=?,[灰分]=?,[水分]=?,[低位发热量]=?,[燃煤产地]=?,[收到基碳]=?,[收到基氢]=?,[收到基氧]=?,[收到基氮]=?,[收到基全硫]=?,[收到基水分]=?,[收到基灰分]=?,[空气干燥基水分]=?,[干燥无灰基挥发分]=?,[收到基低位发热量]=?,[可磨系数]=?,[冲刷磨损指数]=?,[煤粉气流着火温度]=?,[变形温度]=?,[软化温度]=?,[流动温度]=?,[二氧化硅]=?,[三氧化二铝]=?,[三氧化二铁]=?,[氧化钙]=?,[三氧化硫]=?,[可磨性判定]=?,[磨损性判定]=?,[着火稳定性判定]=?,[燃烬特性判定]=?,[灰沾污性能判定]=?,[结渣倾向判定]=?,[煤粉爆炸性判定]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[预留六]=?,[预留七]=?,[预留八]=?,[预留九]=?,[预留十]=?,[审核状态]=?,[审核时间]=?,[审核意见]=? where [编号]=?";
		Object[] params={coal_material.getPid(),coal_material.getProject_name(),coal_material.getSulfur(),coal_material.getAsh(),coal_material.getMoisture(),coal_material.getNet_calorific_power(),coal_material.getCoal_producing_area(),coal_material.getARB_Car(),coal_material.getARB_Har(),coal_material.getARB_Oar(),coal_material.getARB_Nar(),coal_material.getARB_S(),coal_material.getARB_Mar(),coal_material.getARB_Aar(),coal_material.getMad(),coal_material.getVdaf(),coal_material.getARB_LHV(),coal_material.getHGI(),coal_material.getKe(),coal_material.getIT(),coal_material.getDT(),coal_material.getST(),coal_material.getFT(),coal_material.getSiO2(),coal_material.getAl2O3(),coal_material.getFe2O3(),coal_material.getCaO(),coal_material.getSO3(),coal_material.getGrindability_judge(),coal_material.getAbradability_judge(),coal_material.getFire_stability_judge(),coal_material.getAsh_quality_judge(),coal_material.getPollution_quality_judge(),coal_material.getSlag_bonding_trend_judge(),coal_material.getCoal_dust_explode_judge(),coal_material.getSummary(),coal_material.getPreparation_one(),coal_material.getPreparation_two(),coal_material.getPreparation_three(),coal_material.getPreparation_four(),coal_material.getPreparation_five(),coal_material.getPreparation_six(),coal_material.getPreparation_seven(),coal_material.getPreparation_eight(),coal_material.getPreparation_nine(),coal_material.getPreparation_ten(),coal_material.getVerify_state(),coal_material.getVerify_time(),coal_material.getVerify_comment(),coal_material.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean maintenance(Coal_material coal_material) {
		String sql="update [dbo].[煤质资料] set [标准编号]=?,[工程名称]=?,[硫]=?,[灰分]=?,[水分]=?,[低位发热量]=?,[燃煤产地]=?,[收到基碳]=?,[收到基氢]=?,[收到基氧]=?,[收到基氮]=?,[收到基全硫]=?,[收到基水分]=?,[收到基灰分]=?,[空气干燥基水分]=?,[干燥无灰基挥发分]=?,[收到基低位发热量]=?,[可磨系数]=?,[冲刷磨损指数]=?,[煤粉气流着火温度]=?,[变形温度]=?,[软化温度]=?,[流动温度]=?,[二氧化硅]=?,[三氧化二铝]=?,[三氧化二铁]=?,[氧化钙]=?,[三氧化硫]=?,[可磨性判定]=?,[磨损性判定]=?,[着火稳定性判定]=?,[燃烬特性判定]=?,[灰沾污性能判定]=?,[结渣倾向判定]=?,[煤粉爆炸性判定]=?,[摘要]=?,[预留一]=?,[预留二]=?,[预留三]=?,[预留四]=?,[预留五]=?,[预留六]=?,[预留七]=?,[预留八]=?,[预留九]=?,[预留十]=?,[审核人]=? where [编号]=?";
		Object[] params={coal_material.getPid(),coal_material.getProject_name(),coal_material.getSulfur(),coal_material.getAsh(),coal_material.getMoisture(),coal_material.getNet_calorific_power(),coal_material.getCoal_producing_area(),coal_material.getARB_Car(),coal_material.getARB_Har(),coal_material.getARB_Oar(),coal_material.getARB_Nar(),coal_material.getARB_S(),coal_material.getARB_Mar(),coal_material.getARB_Aar(),coal_material.getMad(),coal_material.getVdaf(),coal_material.getARB_LHV(),coal_material.getHGI(),coal_material.getKe(),coal_material.getIT(),coal_material.getDT(),coal_material.getST(),coal_material.getFT(),coal_material.getSiO2(),coal_material.getAl2O3(),coal_material.getFe2O3(),coal_material.getCaO(),coal_material.getSO3(),coal_material.getGrindability_judge(),coal_material.getAbradability_judge(),coal_material.getFire_stability_judge(),coal_material.getAsh_quality_judge(),coal_material.getPollution_quality_judge(),coal_material.getSlag_bonding_trend_judge(),coal_material.getCoal_dust_explode_judge(),coal_material.getSummary(),coal_material.getPreparation_one(),coal_material.getPreparation_two(),coal_material.getPreparation_three(),coal_material.getPreparation_four(),coal_material.getPreparation_five(),coal_material.getPreparation_six(),coal_material.getPreparation_seven(),coal_material.getPreparation_eight(),coal_material.getPreparation_nine(),coal_material.getPreparation_ten(),coal_material.getVerifier(),coal_material.getId()};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public Map[] getAllPid() {
		String sql="select distinct [标准编号] from [dbo].[煤质资料]";
		return dao.select(sql);
	}

	@Override
	public Map[] query(int id) {
		String sql = "select * from [dbo].[煤质资料] where [编号] = ?";
		Object[] params = {id};
		return dao.select(sql,params);
	}

	@Override
	public Map[] query(String pid) {
		String sql = "select * from [dbo].[煤质资料] where [标准编号] like '%"+pid+"%' and [审核状态] in (-1,0,1,2)";
		return dao.select(sql);
	}


}
