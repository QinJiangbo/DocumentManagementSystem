package servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Coal_material;
import pojo.Config;
import pojo.Log;
import pojo.MyFile;
import service.CoalMaterialServiceImpl;
import service.FieldMaintenanceServiceImpl;
import service.FileService;
import service.ICoalMaterialService;
import service.IFieldMaintenanceService;
import service.ILogService;
import service.IUserService;
import service.LogServiceImpl;
import service.UserServiceImpl;

/**
 * Servlet implementation class CoalMaterialServlet
 */
@SuppressWarnings("rawtypes")
public class CoalMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Coal_material coal_material = new Coal_material();
    private ICoalMaterialService coalMaterialService = new CoalMaterialServiceImpl();
    private IFieldMaintenanceService fieldMaintenanceService = new FieldMaintenanceServiceImpl();
    private IUserService userService = new UserServiceImpl();
    private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
    FileService fileService=new FileService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoalMaterialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("run", "1");//程序运行标识
		String UserName = (String) session.getAttribute("UserName");
		if(UserName==null){
			request.setAttribute("msg", "<script>alert('对不起，请先登录！')</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else{
			String op = request.getParameter("op");
			String ch = request.getParameter("ch");
			String se = request.getParameter("se");
			
			String pid = request.getParameter("pid");
			String project_name = request.getParameter("project_name");
			String sulfur = request.getParameter("sulfur");
			String ash = request.getParameter("ash");
			String moisture = request.getParameter("moisture");
			String net_calorific_power = request.getParameter("net_calorific_power");
			String coal_producing_area = request.getParameter("coal_producing_area");
			String ARB_Car = request.getParameter("ARB_Car");
			String ARB_Har = request.getParameter("ARB_Har");
			String ARB_Oar = request.getParameter("ARB_Oar");
			String ARB_Nar = request.getParameter("ARB_Nar");
			String ARB_S = request.getParameter("ARB_S");
			String ARB_Mar = request.getParameter("ARB_Mar");
			String ARB_Aar = request.getParameter("ARB_Aar");
			String mad = request.getParameter("mad");
			String vdaf = request.getParameter("vdaf");
			String ARB_LHV = request.getParameter("ARB_LHV");
			String HGI = request.getParameter("HGI");
			String ke = request.getParameter("ke");
			String IT = request.getParameter("IT");
			String DT = request.getParameter("DT");
			String ST = request.getParameter("ST");
			String FT = request.getParameter("FT");
			String SiO2 = request.getParameter("SiO2");
			String Al2O3 = request.getParameter("Al2O3");
			String Fe2O3 = request.getParameter("Fe2O3");
			String CaO = request.getParameter("CaO");
			String SO3 = request.getParameter("SO3");
			String grindability_judge = request.getParameter("grindability_judge");
			String abradability_judge = request.getParameter("abradability_judge");
			String fire_stability_judge = request.getParameter("fire_stability_judge");
			String ash_quality_judge = request.getParameter("ash_quality_judge");
			String pollution_quality_judge = request.getParameter("pollution_quality_judge");
			String slag_bonding_trend_judge = request.getParameter("slag_bonding_trend_judge");
			String coal_dust_explode_judge = request.getParameter("coal_dust_explode_judge");
			String summary = request.getParameter("summary");
			String preparation_one = request.getParameter("preparation_one");
			String preparation_two = request.getParameter("preparation_two");
			String preparation_three = request.getParameter("preparation_three");
			String preparation_four = request.getParameter("preparation_four");
			String preparation_five = request.getParameter("preparation_five");
			String preparation_six = request.getParameter("preparation_six");
			String preparation_seven = request.getParameter("preparation_seven");
			String preparation_eight = request.getParameter("preparation_eight");
			String preparation_nine = request.getParameter("preparation_nine");
			String preparation_ten = request.getParameter("preparation_ten");
			String verifier = request.getParameter("verifier");
			String verify_comment = request.getParameter("verify_comment");
			//默认select选项
			Map[] sulfurRows = this.coalMaterialService.getDefaultSulfurRows();
			Map[] verifierRows = this.userService.getDefaultVerifierRows();
			Map[] preparationOneRows = this.coalMaterialService.getDefaultPreparationOneRows();
			Map[] preparationTwoRows = this.coalMaterialService.getDefaultPreparationTwoRows();
			Map[] preparationThreeRows = this.coalMaterialService.getDefaultPreparationThreeRows();
			Map[] preparationFourRows = this.coalMaterialService.getDefaultPreparationFourRows();
			Map[] preparationFiveRows = this.coalMaterialService.getDefaultPreparationFiveRows();
			Map[] preparationSixRows= this.coalMaterialService.getDefaultPreparationSixRows();
			Map[] preparationSevenRows = this.coalMaterialService.getDefaultPreparationSevenRows();
			Map[] preparationEightRows = this.coalMaterialService.getDefaultPreparationEightRows();
			Map[] preparationNineRows= this.coalMaterialService.getDefaultPreparationNineRows();
			Map[] preparationTenRows = this.coalMaterialService.getDefaultPreparationTenRows();
			request.setAttribute("sulfurRows",sulfurRows);
			request.setAttribute("verifierRows",verifierRows);
			request.setAttribute("preparationOneRows",preparationOneRows);
			request.setAttribute("preparationTwoRows",preparationTwoRows);
			request.setAttribute("preparationThreeRows",preparationThreeRows);
			request.setAttribute("preparationFourRows",preparationFourRows);
			request.setAttribute("preparationFiveRows",preparationFiveRows);
			request.setAttribute("preparationSixRows",preparationSixRows);
			request.setAttribute("preparationSevenRows",preparationSevenRows);
			request.setAttribute("preparationEightRows",preparationEightRows);
			request.setAttribute("preparationNineRows",preparationNineRows);
			request.setAttribute("preparationTenRows",preparationTenRows);
			request.setAttribute("pageName", "coal_material");//pageName for page dispatcher
			//add log
			this.log.setUname(UserName);
			this.log.setTable("煤质资料");
			this.log.setTime(this.date.format(new Date()));
			//设置初始审核人
			request.setAttribute("verifierRow", this.userService.getDefaultVerifier(UserName));
			//预留字段是否启用
			int isPreparationOneUsed = this.fieldMaintenanceService.isUse("煤质资料","预留一");
			int isPreparationTwoUsed = this.fieldMaintenanceService.isUse("煤质资料","预留二");
			int isPreparationThreeUsed = this.fieldMaintenanceService.isUse("煤质资料","预留三");
			int isPreparationFourUsed = this.fieldMaintenanceService.isUse("煤质资料","预留四");
			int isPreparationFiveUsed = this.fieldMaintenanceService.isUse("煤质资料","预留五");
			int isPreparationSixUsed = this.fieldMaintenanceService.isUse("煤质资料","预留六");
			int isPreparationSevenUsed = this.fieldMaintenanceService.isUse("煤质资料","预留七");
			int isPreparationEightUsed = this.fieldMaintenanceService.isUse("煤质资料","预留八");
			int isPreparationNineUsed = this.fieldMaintenanceService.isUse("煤质资料","预留九");
			int isPreparationTenUsed = this.fieldMaintenanceService.isUse("煤质资料","预留十");
			request.setAttribute("isPreparationOneUsed", isPreparationOneUsed);
			request.setAttribute("isPreparationTwoUsed", isPreparationTwoUsed);
			request.setAttribute("isPreparationThreeUsed", isPreparationThreeUsed);
			request.setAttribute("isPreparationFourUsed", isPreparationFourUsed);
			request.setAttribute("isPreparationFiveUsed", isPreparationFiveUsed);
			request.setAttribute("isPreparationSixUsed", isPreparationSixUsed);
			request.setAttribute("isPreparationSevenUsed", isPreparationSevenUsed);
			request.setAttribute("isPreparationEightUsed", isPreparationEightUsed);
			request.setAttribute("isPreparationNineUsed", isPreparationNineUsed);
			request.setAttribute("isPreparationTenUsed", isPreparationTenUsed);
			//获取预留字段新名称
			String preparationOneNewName = this.fieldMaintenanceService.getNewName("煤质资料","预留一");
			String preparationTwoNewName = this.fieldMaintenanceService.getNewName("煤质资料","预留二");
			String preparationThreeNewName = this.fieldMaintenanceService.getNewName("煤质资料","预留三");
			String preparationFourNewName = this.fieldMaintenanceService.getNewName("煤质资料","预留四");
			String preparationFiveNewName = this.fieldMaintenanceService.getNewName("煤质资料","预留五");
			String preparationSixNewName = this.fieldMaintenanceService.getNewName("煤质资料","预留六");
			String preparationSevenNewName = this.fieldMaintenanceService.getNewName("煤质资料","预留七");
			String preparationEightNewName = this.fieldMaintenanceService.getNewName("煤质资料","预留八");
			String preparationNineNewName = this.fieldMaintenanceService.getNewName("煤质资料","预留九");
			String preparationTenNewName = this.fieldMaintenanceService.getNewName("煤质资料","预留十");
			request.setAttribute("preparationOneNewName", preparationOneNewName);
			request.setAttribute("preparationTwoNewName", preparationTwoNewName);
			request.setAttribute("preparationThreeNewName", preparationThreeNewName);
			request.setAttribute("preparationFourNewName", preparationFourNewName);
			request.setAttribute("preparationFiveNewName", preparationFiveNewName);
			request.setAttribute("preparationSixNewName", preparationSixNewName);
			request.setAttribute("preparationSevenNewName", preparationSevenNewName);
			request.setAttribute("preparationEightNewName", preparationEightNewName);
			request.setAttribute("preparationNineNewName", preparationNineNewName);
			request.setAttribute("preparationTenNewName", preparationTenNewName);
			if(op.equals("insert")){	
				request.setAttribute("op","insert");
				if(this.coalMaterialService.hasSave(UserName)){
					Map[] primaryRows = this.coalMaterialService.primaryQuery(UserName);
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("标准编号"));
						request.setAttribute("projectNameRow", m.get("工程名称"));
						request.setAttribute("sulfurRow", m.get("硫"));
						request.setAttribute("ashRow", m.get("灰分"));
						request.setAttribute("moistureRow", m.get("水分"));
						request.setAttribute("netCalorificPowerRow", m.get("低位发热量"));
						request.setAttribute("coalProducingAreaRow", m.get("燃煤产地"));
						request.setAttribute("ARBCarRow", m.get("收到基碳"));
						request.setAttribute("ARBHarRow", m.get("收到基氢"));
						request.setAttribute("ARBOarRow", m.get("收到基氧"));
						request.setAttribute("ARBNarRow", m.get("收到基氮"));
						request.setAttribute("ARBSRow", m.get("收到基全硫"));
						request.setAttribute("ARBMarRow", m.get("收到基水分"));
						request.setAttribute("ARBAarRow", m.get("收到基灰分"));
						request.setAttribute("madRow", m.get("空气干燥基水分"));
						request.setAttribute("vdafRow", m.get("干燥无灰基挥发分"));
						request.setAttribute("ARBLHVRow", m.get("收到基低位发热量"));
						request.setAttribute("HGIRow", m.get("可磨系数"));
						request.setAttribute("keRow", m.get("冲刷磨损指数"));
						request.setAttribute("ITRow", m.get("煤粉气流着火温度"));
						request.setAttribute("DTRow", m.get("变形温度"));
						request.setAttribute("STRow", m.get("软化温度"));
						request.setAttribute("FTRow", m.get("流动温度"));
						request.setAttribute("SiO2Row", m.get("二氧化硅"));
						request.setAttribute("Al2O3Row", m.get("三氧化二铝"));
						request.setAttribute("Fe2O3Row", m.get("三氧化二铁"));
						request.setAttribute("CaORow", m.get("氧化钙"));
						request.setAttribute("SO3Row", m.get("三氧化硫"));
						request.setAttribute("grindabilityJudgeRow", m.get("可磨性判定"));
						request.setAttribute("abradabilityJudgeRow", m.get("磨损性判定"));
						request.setAttribute("fireStabilityJudgeRow", m.get("着火稳定性判定"));
						request.setAttribute("ashQualityJudgeRow", m.get("燃烬特性判定"));
						request.setAttribute("pollutionQualityJudgeRow", m.get("灰沾污性能判定"));
						request.setAttribute("slagBondingTrendJudgeRow", m.get("结渣倾向判定"));
						request.setAttribute("coalDustExplodeJudgeRow", m.get("煤粉爆炸性判定"));
						request.setAttribute("summaryRow", m.get("摘要"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
						request.setAttribute("preparationSixRow", m.get("预留六"));
						request.setAttribute("preparationSevenRow", m.get("预留七"));
						request.setAttribute("preparationEightRow", m.get("预留八"));
						request.setAttribute("preparationNineRow", m.get("预留九"));
						request.setAttribute("preparationTenRow", m.get("预留十"));
						request.setAttribute("verifierRow", m.get("审核人"));
						
					}
					request.setAttribute("op", "update");
					request.getRequestDispatcher("coal_material_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("coal_material_insert.jsp").forward(request, response);
				}
				
			}
			else if(op.equals("add")){
				request.setAttribute("op","insert");
				this.coal_material.setPid(pid);
				this.coal_material.setProject_name(project_name);
				this.coal_material.setSulfur(sulfur);
				this.coal_material.setAsh(ash);
				this.coal_material.setMoisture(moisture);
				this.coal_material.setNet_calorific_power(net_calorific_power);
				this.coal_material.setCoal_producing_area(coal_producing_area);
				this.coal_material.setARB_Car(ARB_Car);
				this.coal_material.setARB_Har(ARB_Har);
				this.coal_material.setARB_Oar(ARB_Oar);
				this.coal_material.setARB_Nar(ARB_Nar);
				this.coal_material.setARB_S(ARB_S);
				this.coal_material.setARB_Mar(ARB_Mar);
				this.coal_material.setARB_Aar(ARB_Aar);
				this.coal_material.setMad(mad);
				this.coal_material.setVdaf(vdaf);
				this.coal_material.setARB_LHV(ARB_LHV);
				this.coal_material.setHGI(HGI);
				this.coal_material.setKe(ke);
				this.coal_material.setIT(IT);
				this.coal_material.setDT(DT);
				this.coal_material.setST(ST);
				this.coal_material.setFT(FT);
				this.coal_material.setSiO2(SiO2);
				this.coal_material.setAl2O3(Al2O3);
				this.coal_material.setFe2O3(Fe2O3);
				this.coal_material.setCaO(CaO);
				this.coal_material.setSO3(SO3);
				this.coal_material.setGrindability_judge(grindability_judge);
				this.coal_material.setAbradability_judge(abradability_judge);
				this.coal_material.setFire_stability_judge(fire_stability_judge);
				this.coal_material.setAsh_quality_judge(ash_quality_judge);
				this.coal_material.setPollution_quality_judge(pollution_quality_judge);
				this.coal_material.setSlag_bonding_trend_judge(slag_bonding_trend_judge);
				this.coal_material.setCoal_dust_explode_judge(coal_dust_explode_judge);
				this.coal_material.setSummary(summary);
				this.coal_material.setPreparation_one(preparation_one);
				this.coal_material.setPreparation_two(preparation_two);
				this.coal_material.setPreparation_three(preparation_three);
				this.coal_material.setPreparation_four(preparation_four);
				this.coal_material.setPreparation_five(preparation_five);
				this.coal_material.setPreparation_six(preparation_six);
				this.coal_material.setPreparation_seven(preparation_seven);
				this.coal_material.setPreparation_eight(preparation_eight);
				this.coal_material.setPreparation_nine(preparation_nine);
				this.coal_material.setPreparation_ten(preparation_ten);
				this.coal_material.setEntry_time(this.date.format(new Date()));
				this.coal_material.setType_in_userNme(UserName);
				this.coal_material.setVerifier(verifier);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				request.setAttribute("pidRow", pid);
				request.setAttribute("projectNameRow", project_name);
				request.setAttribute("sulfurRow", sulfur);
				request.setAttribute("ashRow", ash);
				request.setAttribute("moistureRow", moisture);
				request.setAttribute("netCalorificPowerRow",net_calorific_power);
				request.setAttribute("coalProducingAreaRow",coal_producing_area );
				request.setAttribute("ARBCarRow", ARB_Car);
				request.setAttribute("ARBHarRow", ARB_Har);
				request.setAttribute("ARBOarRow", ARB_Oar);
				request.setAttribute("ARBNarRow", ARB_Nar);
				request.setAttribute("ARBSRow", ARB_S);
				request.setAttribute("ARBMarRow", ARB_Mar);
				request.setAttribute("ARBAarRow", ARB_Aar);
				request.setAttribute("madRow", mad);
				request.setAttribute("vdafRow", vdaf);
				request.setAttribute("ARBLHVRow", ARB_LHV);
				request.setAttribute("HGIRow", HGI);
				request.setAttribute("keRow", ke);
				request.setAttribute("ITRow", IT);
				request.setAttribute("DTRow", DT);
				request.setAttribute("STRow", ST);
				request.setAttribute("FTRow", FT);
				request.setAttribute("SiO2Row", SiO2);
				request.setAttribute("Al2O3Row", Al2O3);
				request.setAttribute("Fe2O3Row", Fe2O3);
				request.setAttribute("CaORow", CaO);
				request.setAttribute("SO3Row", SO3);
				request.setAttribute("grindabilityJudgeRow", grindability_judge);
				request.setAttribute("abradabilityJudgeRow", abradability_judge);
				request.setAttribute("fireStabilityJudgeRow", abradability_judge);
				request.setAttribute("ashQualityJudgeRow", ash_quality_judge);
				request.setAttribute("pollutionQualityJudgeRow", pollution_quality_judge);
				request.setAttribute("slagBondingTrendJudgeRow", slag_bonding_trend_judge);
				request.setAttribute("coalDustExplodeJudgeRow", coal_dust_explode_judge);
				request.setAttribute("summaryRow", summary);
				request.setAttribute("preparationOneRow", preparation_one);
				request.setAttribute("preparationTwoRow", preparation_two);
				request.setAttribute("preparationThreeRow", preparation_three);
				request.setAttribute("preparationFourRow", preparation_four);
				request.setAttribute("preparationFiveRow", preparation_five);
				request.setAttribute("preparationSixRow", preparation_six);
				request.setAttribute("preparationSevenRow", preparation_seven);
				request.setAttribute("preparationEightRow", preparation_eight);
				request.setAttribute("preparationNineRow", preparation_nine);
				request.setAttribute("preparationTenRow", preparation_ten);
				request.setAttribute("verifierRow", verifier);
				if(this.coalMaterialService.isSubmit(pid)){
					if(this.coalMaterialService.isSave(pid)){
						request.setAttribute("msg", "<script>alert('已存在相同编号保存记录,无法继续保存第二条具有相同编号的记录,请核实并修改标准编号！')</script>");
					}
					else{
						if(this.coalMaterialService.hasSave(UserName)){
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，并且您已有一条保存记录了,无法继续保存第二条的记录,请核实并修改标准编号！')</script>");
						}
						else {
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，请核实标准编号后提交！')</script>");
						}
					}
				}
				else{
					this.coal_material.setVerify_state(1);
					if(this.coalMaterialService.add(coal_material)){
						//添加入系统日志
						this.log.setOperation("录入");
						this.logService.add(log);
						
						Map[] primaryRows = this.coalMaterialService.query(this.coalMaterialService.getId(pid, 1));
						for(Map m : primaryRows){
							request.setAttribute("idRow", m.get("编号"));
							request.setAttribute("pidRow", m.get("标准编号"));
							request.setAttribute("projectNameRow", m.get("工程名称"));
							request.setAttribute("sulfurRow", m.get("硫"));
							request.setAttribute("ashRow", m.get("灰分"));
							request.setAttribute("moistureRow", m.get("水分"));
							request.setAttribute("netCalorificPowerRow", m.get("低位发热量"));
							request.setAttribute("coalProducingAreaRow", m.get("燃煤产地"));
							request.setAttribute("ARBCarRow", m.get("收到基碳"));
							request.setAttribute("ARBHarRow", m.get("收到基氢"));
							request.setAttribute("ARBOarRow", m.get("收到基氧"));
							request.setAttribute("ARBNarRow", m.get("收到基氮"));
							request.setAttribute("ARBSRow", m.get("收到基全硫"));
							request.setAttribute("ARBMarRow", m.get("收到基水分"));
							request.setAttribute("ARBAarRow", m.get("收到基灰分"));
							request.setAttribute("madRow", m.get("空气干燥基水分"));
							request.setAttribute("vdafRow", m.get("干燥无灰基挥发分"));
							request.setAttribute("ARBLHVRow", m.get("收到基低位发热量"));
							request.setAttribute("HGIRow", m.get("可磨系数"));
							request.setAttribute("keRow", m.get("冲刷磨损指数"));
							request.setAttribute("ITRow", m.get("煤粉气流着火温度"));
							request.setAttribute("DTRow", m.get("变形温度"));
							request.setAttribute("STRow", m.get("软化温度"));
							request.setAttribute("FTRow", m.get("流动温度"));
							request.setAttribute("SiO2Row", m.get("二氧化硅"));
							request.setAttribute("Al2O3Row", m.get("三氧化二铝"));
							request.setAttribute("Fe2O3Row", m.get("三氧化二铁"));
							request.setAttribute("CaORow", m.get("氧化钙"));
							request.setAttribute("SO3Row", m.get("三氧化硫"));
							request.setAttribute("grindabilityJudgeRow", m.get("可磨性判定"));
							request.setAttribute("abradabilityJudgeRow", m.get("磨损性判定"));
							request.setAttribute("fireStabilityJudgeRow", m.get("着火稳定性判定"));
							request.setAttribute("ashQualityJudgeRow", m.get("燃烬特性判定"));
							request.setAttribute("pollutionQualityJudgeRow", m.get("灰沾污性能判定"));
							request.setAttribute("slagBondingTrendJudgeRow", m.get("结渣倾向判定"));
							request.setAttribute("coalDustExplodeJudgeRow", m.get("煤粉爆炸性判定"));
							request.setAttribute("summaryRow", m.get("摘要"));
							request.setAttribute("preparationOneRow", m.get("预留一"));
							request.setAttribute("preparationTwoRow", m.get("预留二"));
							request.setAttribute("preparationThreeRow", m.get("预留三"));
							request.setAttribute("preparationFourRow", m.get("预留四"));
							request.setAttribute("preparationFiveRow", m.get("预留五"));
							request.setAttribute("preparationSixRow", m.get("预留六"));
							request.setAttribute("preparationSevenRow", m.get("预留七"));
							request.setAttribute("preparationEightRow", m.get("预留八"));
							request.setAttribute("preparationNineRow", m.get("预留九"));
							request.setAttribute("preparationTenRow", m.get("预留十"));
							request.setAttribute("verifierRow", m.get("审核人"));
							
						}
						request.setAttribute("msg", "<script>alert('提交成功！')</script>");
						
					}
					else{
						request.setAttribute("msg", "<script>alert('提交失败！')</script>");
					}
				}
				request.setAttribute("op","update");
				request.getRequestDispatcher("coal_material_insert.jsp").forward(request, response);
			}
			else if(op.equals("query")){
				request.setAttribute("op", "query");
				this.coal_material.setPid(pid);
				this.coal_material.setProject_name(project_name);
				this.coal_material.setSulfur(sulfur);
				this.coal_material.setAsh(ash);
				this.coal_material.setMoisture(moisture);
				this.coal_material.setNet_calorific_power(net_calorific_power);
				this.coal_material.setCoal_producing_area(coal_producing_area);
				this.coal_material.setARB_Car(ARB_Car);
				this.coal_material.setARB_Har(ARB_Har);
				this.coal_material.setARB_Oar(ARB_Oar);
				this.coal_material.setARB_Nar(ARB_Nar);
				this.coal_material.setARB_S(ARB_S);
				this.coal_material.setARB_Mar(ARB_Mar);
				this.coal_material.setARB_Aar(ARB_Aar);
				this.coal_material.setMad(mad);
				this.coal_material.setVdaf(vdaf);
				this.coal_material.setARB_LHV(ARB_LHV);
				this.coal_material.setHGI(HGI);
				this.coal_material.setKe(ke);
				this.coal_material.setIT(IT);
				this.coal_material.setDT(DT);
				this.coal_material.setST(ST);
				this.coal_material.setFT(FT);
				this.coal_material.setSiO2(SiO2);
				this.coal_material.setAl2O3(Al2O3);
				this.coal_material.setFe2O3(Fe2O3);
				this.coal_material.setCaO(CaO);
				this.coal_material.setSO3(SO3);
				this.coal_material.setGrindability_judge(grindability_judge);
				this.coal_material.setAbradability_judge(abradability_judge);
				this.coal_material.setFire_stability_judge(fire_stability_judge);
				this.coal_material.setAsh_quality_judge(ash_quality_judge);
				this.coal_material.setPollution_quality_judge(pollution_quality_judge);
				this.coal_material.setSlag_bonding_trend_judge(slag_bonding_trend_judge);
				this.coal_material.setCoal_dust_explode_judge(coal_dust_explode_judge);
				this.coal_material.setSummary(summary);
				this.coal_material.setPreparation_one(preparation_one);
				this.coal_material.setPreparation_two(preparation_two);
				this.coal_material.setPreparation_three(preparation_three);
				this.coal_material.setPreparation_four(preparation_four);
				this.coal_material.setPreparation_five(preparation_five);
				this.coal_material.setPreparation_six(preparation_six);
				this.coal_material.setPreparation_seven(preparation_seven);
				this.coal_material.setPreparation_eight(preparation_eight);
				this.coal_material.setPreparation_nine(preparation_nine);
				this.coal_material.setPreparation_ten(preparation_ten);
				
				Map[] rows = this.coalMaterialService.query(coal_material);
				//添加入系统日志
				this.log.setOperation("查询");
				this.logService.add(log);
				
				request.setAttribute("rows", rows);
				if(ch!=null){
					String id = request.getParameter("id");
					Map[] primaryRows = this.coalMaterialService.query(Integer.parseInt(id.toString()));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("标准编号"));
						request.setAttribute("projectNameRow", m.get("工程名称"));
						request.setAttribute("sulfurRow", m.get("硫"));
						request.setAttribute("ashRow", m.get("灰分"));
						request.setAttribute("moistureRow", m.get("水分"));
						request.setAttribute("netCalorificPowerRow", m.get("低位发热量"));
						request.setAttribute("coalProducingAreaRow", m.get("燃煤产地"));
						request.setAttribute("ARBCarRow", m.get("收到基碳"));
						request.setAttribute("ARBHarRow", m.get("收到基氢"));
						request.setAttribute("ARBOarRow", m.get("收到基氧"));
						request.setAttribute("ARBNarRow", m.get("收到基氮"));
						request.setAttribute("ARBSRow", m.get("收到基全硫"));
						request.setAttribute("ARBMarRow", m.get("收到基水分"));
						request.setAttribute("ARBAarRow", m.get("收到基灰分"));
						request.setAttribute("madRow", m.get("空气干燥基水分"));
						request.setAttribute("vdafRow", m.get("干燥无灰基挥发分"));
						request.setAttribute("ARBLHVRow", m.get("收到基低位发热量"));
						request.setAttribute("HGIRow", m.get("可磨系数"));
						request.setAttribute("keRow", m.get("冲刷磨损指数"));
						request.setAttribute("ITRow", m.get("煤粉气流着火温度"));
						request.setAttribute("DTRow", m.get("变形温度"));
						request.setAttribute("STRow", m.get("软化温度"));
						request.setAttribute("FTRow", m.get("流动温度"));
						request.setAttribute("SiO2Row", m.get("二氧化硅"));
						request.setAttribute("Al2O3Row", m.get("三氧化二铝"));
						request.setAttribute("Fe2O3Row", m.get("三氧化二铁"));
						request.setAttribute("CaORow", m.get("氧化钙"));
						request.setAttribute("SO3Row", m.get("三氧化硫"));
						request.setAttribute("grindabilityJudgeRow", m.get("可磨性判定"));
						request.setAttribute("abradabilityJudgeRow", m.get("磨损性判定"));
						request.setAttribute("fireStabilityJudgeRow", m.get("着火稳定性判定"));
						request.setAttribute("ashQualityJudgeRow", m.get("燃烬特性判定"));
						request.setAttribute("pollutionQualityJudgeRow", m.get("灰沾污性能判定"));
						request.setAttribute("slagBondingTrendJudgeRow", m.get("结渣倾向判定"));
						request.setAttribute("coalDustExplodeJudgeRow", m.get("煤粉爆炸性判定"));
						request.setAttribute("summaryRow", m.get("摘要"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
						request.setAttribute("preparationSixRow", m.get("预留六"));
						request.setAttribute("preparationSevenRow", m.get("预留七"));
						request.setAttribute("preparationEightRow", m.get("预留八"));
						request.setAttribute("preparationNineRow", m.get("预留九"));
						request.setAttribute("preparationTenRow", m.get("预留十"));
						request.setAttribute("verifierRow", m.get("审核人"));
						
					}
					if(ch.equals("view")){
						request.setAttribute("op","view");
					}
					else if(ch.equals("maintenance")){
						request.setAttribute("op","maintenance");
					}
					String method = request.getParameter("method");
					//file operate
					if(method!=null){
						if(method.equals("init"))
						{
							String defaultRootPath=Config.initPath;//默认的要配的路径
							String projectType=new String(request.getParameter("projectType").getBytes("ISO-8859-1"),Config.charset1);
							String projectId=new String(request.getParameter("projectId").getBytes("ISO-8859-1"),Config.charset1);
							String initPath=defaultRootPath+"/"+projectType+"/"+projectId+"/";
							//System.out.println(initPath);
							List<File> fileList=new ArrayList<File>();
							List<MyFile> myFileList=new ArrayList<MyFile>();
							fileService.getCurrentDirectoryFiles(fileList, initPath);
							for(int i=0;i<fileList.size();i++)
							{
								MyFile myFile=new MyFile();
								myFile.setFileName(fileList.get(i).getName().toString());
								myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
								Calendar cal=Calendar.getInstance();
								long time=fileList.get(i).lastModified();
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cal.setTimeInMillis(time);
								myFile.setLastModified(formatter.format(cal.getTime()));
								if(fileList.get(i).isDirectory())
								{
									myFile.setFileType("Folder");
									long size=fileService.getFolderSize(fileList.get(i))/1048576;
									myFile.setFileSize(size);
								}else
								{
									myFile.setFileType("File");
									long size=fileService.getFileSize(fileList.get(i))/1024;
									myFile.setFileSize(size);
								}
								myFileList.add(myFile);
							}
							request.setAttribute("currentPath", initPath);
							session.setAttribute("initPath", initPath);
							request.setAttribute("myFileList", myFileList);
						}
						else if(method.equals("checkSubFiles"))
						{
							String path=new String(request.getParameter("path").getBytes("ISO-8859-1"),Config.charset2);
							List<File> fileList=new ArrayList<File>();
							List<MyFile> myFileList=new ArrayList<MyFile>();
							fileService.getCurrentDirectoryFiles(fileList, path);
							for(int i=0;i<fileList.size();i++)
							{
								MyFile myFile=new MyFile();
								myFile.setFileName(fileList.get(i).getName().toString());
								myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
								Calendar cal=Calendar.getInstance();
								long time=fileList.get(i).lastModified();
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cal.setTimeInMillis(time);
								myFile.setLastModified(formatter.format(cal.getTime()));
								if(fileList.get(i).isDirectory())
								{
									myFile.setFileType("Folder");
									long size=fileService.getFolderSize(fileList.get(i))/1048576;
									myFile.setFileSize(size);
								}else
								{
									myFile.setFileType("File");
									long size=fileService.getFileSize(fileList.get(i))/1024;
									myFile.setFileSize(size);
								}
								myFileList.add(myFile);
							}
							request.setAttribute("currentPath", path);
							request.setAttribute("myFileList", myFileList);
						}else if(method.equals("checkParentFolder"))
						{
							String currentPath=request.getParameter("currentPath");
							String pathTransfer=new String(currentPath.getBytes("ISO-8859-1"),Config.charset3);
							List<File> fileList=new ArrayList<File>();
							List<MyFile> myFileList=new ArrayList<MyFile>();
							fileService.getCurrentDirectoryFiles(fileList, fileService.getParentPath(pathTransfer));
							for(int i=0;i<fileList.size();i++)
							{
								MyFile myFile=new MyFile();
								myFile.setFileName(fileList.get(i).getName().toString());
								myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
								Calendar cal=Calendar.getInstance();
								long time=fileList.get(i).lastModified();
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cal.setTimeInMillis(time);
								myFile.setLastModified(formatter.format(cal.getTime()));
								if(fileList.get(i).isDirectory())
								{
									myFile.setFileType("Folder");
									long size=fileService.getFolderSize(fileList.get(i))/1048576;
									myFile.setFileSize(size);
								}else
								{
									myFile.setFileType("File");
									long size=fileService.getFileSize(fileList.get(i))/1024;
									myFile.setFileSize(size);
								}
								myFileList.add(myFile);
							}
							request.setAttribute("currentPath", fileService.getParentPath(pathTransfer));
							request.setAttribute("myFileList", myFileList);
						}
					}else{
						
					}
					request.getRequestDispatcher("coal_material_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("coal_material_query.jsp").forward(request, response);
				}
			}
			else if(op.equals("update")){
				request.setAttribute("op", "update");
				String id = request.getParameter("id");
				if(this.coalMaterialService.isSubmit(pid)){
					if(this.coalMaterialService.isSave(pid)){
						this.coal_material.setId(Integer.parseInt(id));
						this.coal_material.setPid(pid);
						this.coal_material.setProject_name(project_name);
						this.coal_material.setSulfur(sulfur);
						this.coal_material.setAsh(ash);
						this.coal_material.setMoisture(moisture);
						this.coal_material.setNet_calorific_power(net_calorific_power);
						this.coal_material.setCoal_producing_area(coal_producing_area);
						this.coal_material.setARB_Car(ARB_Car);
						this.coal_material.setARB_Har(ARB_Har);
						this.coal_material.setARB_Oar(ARB_Oar);
						this.coal_material.setARB_Nar(ARB_Nar);
						this.coal_material.setARB_S(ARB_S);
						this.coal_material.setARB_Mar(ARB_Mar);
						this.coal_material.setARB_Aar(ARB_Aar);
						this.coal_material.setMad(mad);
						this.coal_material.setVdaf(vdaf);
						this.coal_material.setARB_LHV(ARB_LHV);
						this.coal_material.setHGI(HGI);
						this.coal_material.setKe(ke);
						this.coal_material.setIT(IT);
						this.coal_material.setDT(DT);
						this.coal_material.setST(ST);
						this.coal_material.setFT(FT);
						this.coal_material.setSiO2(SiO2);
						this.coal_material.setAl2O3(Al2O3);
						this.coal_material.setFe2O3(Fe2O3);
						this.coal_material.setCaO(CaO);
						this.coal_material.setSO3(SO3);
						this.coal_material.setGrindability_judge(grindability_judge);
						this.coal_material.setAbradability_judge(abradability_judge);
						this.coal_material.setFire_stability_judge(fire_stability_judge);
						this.coal_material.setAsh_quality_judge(ash_quality_judge);
						this.coal_material.setPollution_quality_judge(pollution_quality_judge);
						this.coal_material.setSlag_bonding_trend_judge(slag_bonding_trend_judge);
						this.coal_material.setCoal_dust_explode_judge(coal_dust_explode_judge);
						this.coal_material.setSummary(summary);
						this.coal_material.setPreparation_one(preparation_one);
						this.coal_material.setPreparation_two(preparation_two);
						this.coal_material.setPreparation_three(preparation_three);
						this.coal_material.setPreparation_four(preparation_four);
						this.coal_material.setPreparation_five(preparation_five);
						this.coal_material.setPreparation_six(preparation_six);
						this.coal_material.setPreparation_seven(preparation_seven);
						this.coal_material.setPreparation_eight(preparation_eight);
						this.coal_material.setPreparation_nine(preparation_nine);
						this.coal_material.setPreparation_ten(preparation_ten);
						this.coal_material.setEntry_time(this.date.format(new Date()));
						this.coal_material.setType_in_userNme(UserName);
						this.coal_material.setVerifier(verifier);
						this.coal_material.setVerify_state(1);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.coalMaterialService.update(coal_material)){
							//添加入系统日志
							this.log.setOperation("更新");
							this.logService.add(log);
							
							request.setAttribute("msg", "<script>alert('更新成功！')</script>");
							
						}
						else {
							request.setAttribute("msg", "<script>alert('更新失败！')</script>");
						}
					}
					else{
						request.setAttribute("msg", "<script>alert('已存在相同编号项目，请修改编号后提交！')</script>");
					}
					//填充
					request.setAttribute("idRow", Integer.parseInt(id));
					request.setAttribute("pidRow", pid);
					request.setAttribute("projectNameRow", project_name);
					request.setAttribute("sulfurRow", sulfur);
					request.setAttribute("ashRow", ash);
					request.setAttribute("moistureRow", moisture);
					request.setAttribute("netCalorificPowerRow",net_calorific_power);
					request.setAttribute("coalProducingAreaRow",coal_producing_area );
					request.setAttribute("ARBCarRow", ARB_Car);
					request.setAttribute("ARBHarRow", ARB_Har);
					request.setAttribute("ARBOarRow", ARB_Oar);
					request.setAttribute("ARBNarRow", ARB_Nar);
					request.setAttribute("ARBSRow", ARB_S);
					request.setAttribute("ARBMarRow", ARB_Mar);
					request.setAttribute("ARBAarRow", ARB_Aar);
					request.setAttribute("madRow", mad);
					request.setAttribute("vdafRow", vdaf);
					request.setAttribute("ARBLHVRow", ARB_LHV);
					request.setAttribute("HGIRow", HGI);
					request.setAttribute("keRow", ke);
					request.setAttribute("ITRow", IT);
					request.setAttribute("DTRow", DT);
					request.setAttribute("STRow", ST);
					request.setAttribute("FTRow", FT);
					request.setAttribute("SiO2Row", SiO2);
					request.setAttribute("Al2O3Row", Al2O3);
					request.setAttribute("Fe2O3Row", Fe2O3);
					request.setAttribute("CaORow", CaO);
					request.setAttribute("SO3Row", SO3);
					request.setAttribute("grindabilityJudgeRow", grindability_judge);
					request.setAttribute("abradabilityJudgeRow", abradability_judge);
					request.setAttribute("fireStabilityJudgeRow", abradability_judge);
					request.setAttribute("ashQualityJudgeRow", ash_quality_judge);
					request.setAttribute("pollutionQualityJudgeRow", pollution_quality_judge);
					request.setAttribute("slagBondingTrendJudgeRow", slag_bonding_trend_judge);
					request.setAttribute("coalDustExplodeJudgeRow", coal_dust_explode_judge);
					request.setAttribute("summaryRow", summary);
					request.setAttribute("preparationOneRow", preparation_one);
					request.setAttribute("preparationTwoRow", preparation_two);
					request.setAttribute("preparationThreeRow", preparation_three);
					request.setAttribute("preparationFourRow", preparation_four);
					request.setAttribute("preparationFiveRow", preparation_five);
					request.setAttribute("preparationSixRow", preparation_six);
					request.setAttribute("preparationSevenRow", preparation_seven);
					request.setAttribute("preparationEightRow", preparation_eight);
					request.setAttribute("preparationNineRow", preparation_nine);
					request.setAttribute("preparationTenRow", preparation_ten);
					request.setAttribute("verifierRow", verifier);
				}
				else{
					this.coal_material.setId(Integer.parseInt(id));
					this.coal_material.setPid(pid);
					this.coal_material.setProject_name(project_name);
					this.coal_material.setSulfur(sulfur);
					this.coal_material.setAsh(ash);
					this.coal_material.setMoisture(moisture);
					this.coal_material.setNet_calorific_power(net_calorific_power);
					this.coal_material.setCoal_producing_area(coal_producing_area);
					this.coal_material.setARB_Car(ARB_Car);
					this.coal_material.setARB_Har(ARB_Har);
					this.coal_material.setARB_Oar(ARB_Oar);
					this.coal_material.setARB_Nar(ARB_Nar);
					this.coal_material.setARB_S(ARB_S);
					this.coal_material.setARB_Mar(ARB_Mar);
					this.coal_material.setARB_Aar(ARB_Aar);
					this.coal_material.setMad(mad);
					this.coal_material.setVdaf(vdaf);
					this.coal_material.setARB_LHV(ARB_LHV);
					this.coal_material.setHGI(HGI);
					this.coal_material.setKe(ke);
					this.coal_material.setIT(IT);
					this.coal_material.setDT(DT);
					this.coal_material.setST(ST);
					this.coal_material.setFT(FT);
					this.coal_material.setSiO2(SiO2);
					this.coal_material.setAl2O3(Al2O3);
					this.coal_material.setFe2O3(Fe2O3);
					this.coal_material.setCaO(CaO);
					this.coal_material.setSO3(SO3);
					this.coal_material.setGrindability_judge(grindability_judge);
					this.coal_material.setAbradability_judge(abradability_judge);
					this.coal_material.setFire_stability_judge(fire_stability_judge);
					this.coal_material.setAsh_quality_judge(ash_quality_judge);
					this.coal_material.setPollution_quality_judge(pollution_quality_judge);
					this.coal_material.setSlag_bonding_trend_judge(slag_bonding_trend_judge);
					this.coal_material.setCoal_dust_explode_judge(coal_dust_explode_judge);
					this.coal_material.setSummary(summary);
					this.coal_material.setPreparation_one(preparation_one);
					this.coal_material.setPreparation_two(preparation_two);
					this.coal_material.setPreparation_three(preparation_three);
					this.coal_material.setPreparation_four(preparation_four);
					this.coal_material.setPreparation_five(preparation_five);
					this.coal_material.setPreparation_six(preparation_six);
					this.coal_material.setPreparation_seven(preparation_seven);
					this.coal_material.setPreparation_eight(preparation_eight);
					this.coal_material.setPreparation_nine(preparation_nine);
					this.coal_material.setPreparation_ten(preparation_ten);
					this.coal_material.setEntry_time(this.date.format(new Date()));
					this.coal_material.setType_in_userNme(UserName);
					this.coal_material.setVerifier(verifier);
					this.coal_material.setVerify_state(1);
					//重设默认审核人
					this.userService.setDefaultVerifier(UserName, verifier);
					
					//for 未审核更新处理
					if(ch==null||ch==""){
						if(this.coalMaterialService.update(coal_material)){
							//添加入系统日志
							this.log.setOperation("更新");
							this.logService.add(log);
							
							request.setAttribute("msg", "<script>alert('更新成功！')</script>");
							
						}
						else {
							request.setAttribute("msg", "<script>alert('更新失败！')</script>");
						}
						//填充
						request.setAttribute("idRow", Integer.parseInt(id));
						request.setAttribute("pidRow", pid);
						request.setAttribute("projectNameRow", project_name);
						request.setAttribute("sulfurRow", sulfur);
						request.setAttribute("ashRow", ash);
						request.setAttribute("moistureRow", moisture);
						request.setAttribute("netCalorificPowerRow",net_calorific_power);
						request.setAttribute("coalProducingAreaRow",coal_producing_area );
						request.setAttribute("ARBCarRow", ARB_Car);
						request.setAttribute("ARBHarRow", ARB_Har);
						request.setAttribute("ARBOarRow", ARB_Oar);
						request.setAttribute("ARBNarRow", ARB_Nar);
						request.setAttribute("ARBSRow", ARB_S);
						request.setAttribute("ARBMarRow", ARB_Mar);
						request.setAttribute("ARBAarRow", ARB_Aar);
						request.setAttribute("madRow", mad);
						request.setAttribute("vdafRow", vdaf);
						request.setAttribute("ARBLHVRow", ARB_LHV);
						request.setAttribute("HGIRow", HGI);
						request.setAttribute("keRow", ke);
						request.setAttribute("ITRow", IT);
						request.setAttribute("DTRow", DT);
						request.setAttribute("STRow", ST);
						request.setAttribute("FTRow", FT);
						request.setAttribute("SiO2Row", SiO2);
						request.setAttribute("Al2O3Row", Al2O3);
						request.setAttribute("Fe2O3Row", Fe2O3);
						request.setAttribute("CaORow", CaO);
						request.setAttribute("SO3Row", SO3);
						request.setAttribute("grindabilityJudgeRow", grindability_judge);
						request.setAttribute("abradabilityJudgeRow", abradability_judge);
						request.setAttribute("fireStabilityJudgeRow", abradability_judge);
						request.setAttribute("ashQualityJudgeRow", ash_quality_judge);
						request.setAttribute("pollutionQualityJudgeRow", pollution_quality_judge);
						request.setAttribute("slagBondingTrendJudgeRow", slag_bonding_trend_judge);
						request.setAttribute("coalDustExplodeJudgeRow", coal_dust_explode_judge);
						request.setAttribute("summaryRow", summary);
						request.setAttribute("preparationOneRow", preparation_one);
						request.setAttribute("preparationTwoRow", preparation_two);
						request.setAttribute("preparationThreeRow", preparation_three);
						request.setAttribute("preparationFourRow", preparation_four);
						request.setAttribute("preparationFiveRow", preparation_five);
						request.setAttribute("preparationSixRow", preparation_six);
						request.setAttribute("preparationSevenRow", preparation_seven);
						request.setAttribute("preparationEightRow", preparation_eight);
						request.setAttribute("preparationNineRow", preparation_nine);
						request.setAttribute("preparationTenRow", preparation_ten);
						request.setAttribute("verifierRow", verifier);
					}
					else{
						if(ch.equals("unpass")){
							Map[] primaryRows = this.coalMaterialService.query(Integer.parseInt(id));
							for(Map m : primaryRows){
								request.setAttribute("idRow", m.get("编号"));
								request.setAttribute("pidRow", m.get("标准编号"));
								request.setAttribute("projectNameRow", m.get("工程名称"));
								request.setAttribute("sulfurRow", m.get("硫"));
								request.setAttribute("ashRow", m.get("灰分"));
								request.setAttribute("moistureRow", m.get("水分"));
								request.setAttribute("netCalorificPowerRow", m.get("低位发热量"));
								request.setAttribute("coalProducingAreaRow", m.get("燃煤产地"));
								request.setAttribute("ARBCarRow", m.get("收到基碳"));
								request.setAttribute("ARBHarRow", m.get("收到基氢"));
								request.setAttribute("ARBOarRow", m.get("收到基氧"));
								request.setAttribute("ARBNarRow", m.get("收到基氮"));
								request.setAttribute("ARBSRow", m.get("收到基全硫"));
								request.setAttribute("ARBMarRow", m.get("收到基水分"));
								request.setAttribute("ARBAarRow", m.get("收到基灰分"));
								request.setAttribute("madRow", m.get("空气干燥基水分"));
								request.setAttribute("vdafRow", m.get("干燥无灰基挥发分"));
								request.setAttribute("ARBLHVRow", m.get("收到基低位发热量"));
								request.setAttribute("HGIRow", m.get("可磨系数"));
								request.setAttribute("keRow", m.get("冲刷磨损指数"));
								request.setAttribute("ITRow", m.get("煤粉气流着火温度"));
								request.setAttribute("DTRow", m.get("变形温度"));
								request.setAttribute("STRow", m.get("软化温度"));
								request.setAttribute("FTRow", m.get("流动温度"));
								request.setAttribute("SiO2Row", m.get("二氧化硅"));
								request.setAttribute("Al2O3Row", m.get("三氧化二铝"));
								request.setAttribute("Fe2O3Row", m.get("三氧化二铁"));
								request.setAttribute("CaORow", m.get("氧化钙"));
								request.setAttribute("SO3Row", m.get("三氧化硫"));
								request.setAttribute("grindabilityJudgeRow", m.get("可磨性判定"));
								request.setAttribute("abradabilityJudgeRow", m.get("磨损性判定"));
								request.setAttribute("fireStabilityJudgeRow", m.get("着火稳定性判定"));
								request.setAttribute("ashQualityJudgeRow", m.get("燃烬特性判定"));
								request.setAttribute("pollutionQualityJudgeRow", m.get("灰沾污性能判定"));
								request.setAttribute("slagBondingTrendJudgeRow", m.get("结渣倾向判定"));
								request.setAttribute("coalDustExplodeJudgeRow", m.get("煤粉爆炸性判定"));
								request.setAttribute("summaryRow", m.get("摘要"));
								request.setAttribute("preparationOneRow", m.get("预留一"));
								request.setAttribute("preparationTwoRow", m.get("预留二"));
								request.setAttribute("preparationThreeRow", m.get("预留三"));
								request.setAttribute("preparationFourRow", m.get("预留四"));
								request.setAttribute("preparationFiveRow", m.get("预留五"));
								request.setAttribute("preparationSixRow", m.get("预留六"));
								request.setAttribute("preparationSevenRow", m.get("预留七"));
								request.setAttribute("preparationEightRow", m.get("预留八"));
								request.setAttribute("preparationNineRow", m.get("预留九"));
								request.setAttribute("preparationTenRow", m.get("预留十"));
								request.setAttribute("verifyCommentRow", m.get("审核意见"));
								request.setAttribute("verifierRow", m.get("审核人"));
								
							}
							String method = request.getParameter("method");
							//file operate
							if(method!=null){
								if(method.equals("init"))
								{
									String defaultRootPath=Config.initPath;//默认的要配的路径
									String projectType=new String(request.getParameter("projectType").getBytes("ISO-8859-1"),Config.charset4);
									String projectId=new String(request.getParameter("projectId").getBytes("ISO-8859-1"),Config.charset4);
									String initPath=defaultRootPath+"/"+projectType+"/"+projectId+"/";
									//System.out.println(initPath);
									List<File> fileList=new ArrayList<File>();
									List<MyFile> myFileList=new ArrayList<MyFile>();
									fileService.getCurrentDirectoryFiles(fileList, initPath);
									for(int i=0;i<fileList.size();i++)
									{
										MyFile myFile=new MyFile();
										myFile.setFileName(fileList.get(i).getName().toString());
										myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
										Calendar cal=Calendar.getInstance();
										long time=fileList.get(i).lastModified();
										SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										cal.setTimeInMillis(time);
										myFile.setLastModified(formatter.format(cal.getTime()));
										if(fileList.get(i).isDirectory())
										{
											myFile.setFileType("Folder");
											long size=fileService.getFolderSize(fileList.get(i))/1048576;
											myFile.setFileSize(size);
										}else
										{
											myFile.setFileType("File");
											long size=fileService.getFileSize(fileList.get(i))/1024;
											myFile.setFileSize(size);
										}
										myFileList.add(myFile);
									}
									request.setAttribute("currentPath", initPath);
									session.setAttribute("initPath", initPath);
									request.setAttribute("myFileList", myFileList);
								}
								else if(method.equals("checkSubFiles"))
								{
									String path=new String(request.getParameter("path").getBytes("ISO-8859-1"),Config.charset5);
									List<File> fileList=new ArrayList<File>();
									List<MyFile> myFileList=new ArrayList<MyFile>();
									fileService.getCurrentDirectoryFiles(fileList, path);
									for(int i=0;i<fileList.size();i++)
									{
										MyFile myFile=new MyFile();
										myFile.setFileName(fileList.get(i).getName().toString());
										myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
										Calendar cal=Calendar.getInstance();
										long time=fileList.get(i).lastModified();
										SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										cal.setTimeInMillis(time);
										myFile.setLastModified(formatter.format(cal.getTime()));
										if(fileList.get(i).isDirectory())
										{
											myFile.setFileType("Folder");
											long size=fileService.getFolderSize(fileList.get(i))/1048576;
											myFile.setFileSize(size);
										}else
										{
											myFile.setFileType("File");
											long size=fileService.getFileSize(fileList.get(i))/1024;
											myFile.setFileSize(size);
										}
										myFileList.add(myFile);
									}
									request.setAttribute("currentPath", path);
									request.setAttribute("myFileList", myFileList);
								}else if(method.equals("checkParentFolder"))
								{
									String currentPath=request.getParameter("currentPath");
									String pathTransfer=new String(currentPath.getBytes("ISO-8859-1"),Config.charset6);
									List<File> fileList=new ArrayList<File>();
									List<MyFile> myFileList=new ArrayList<MyFile>();
									fileService.getCurrentDirectoryFiles(fileList, fileService.getParentPath(pathTransfer));
									for(int i=0;i<fileList.size();i++)
									{
										MyFile myFile=new MyFile();
										myFile.setFileName(fileList.get(i).getName().toString());
										myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
										Calendar cal=Calendar.getInstance();
										long time=fileList.get(i).lastModified();
										SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										cal.setTimeInMillis(time);
										myFile.setLastModified(formatter.format(cal.getTime()));
										if(fileList.get(i).isDirectory())
										{
											myFile.setFileType("Folder");
											long size=fileService.getFolderSize(fileList.get(i))/1048576;
											myFile.setFileSize(size);
										}else
										{
											myFile.setFileType("File");
											long size=fileService.getFileSize(fileList.get(i))/1024;
											myFile.setFileSize(size);
										}
										myFileList.add(myFile);
									}
									request.setAttribute("currentPath", fileService.getParentPath(pathTransfer));
									request.setAttribute("myFileList", myFileList);
								}
							}else{
								
							}
							request.setAttribute("ch", "unpass");
						}
						else{
							if(this.coalMaterialService.update(coal_material)){
								//添加入系统日志
								this.log.setOperation("更新");
								this.logService.add(log);
								
								request.setAttribute("msg", "<script>alert('更新成功！')</script>");
								
							}
							else {
								request.setAttribute("msg", "<script>alert('更新失败！')</script>");
							}
							//填充
							request.setAttribute("idRow", Integer.parseInt(id));
							request.setAttribute("pidRow", pid);
							request.setAttribute("projectNameRow", project_name);
							request.setAttribute("sulfurRow", sulfur);
							request.setAttribute("ashRow", ash);
							request.setAttribute("moistureRow", moisture);
							request.setAttribute("netCalorificPowerRow",net_calorific_power);
							request.setAttribute("coalProducingAreaRow",coal_producing_area );
							request.setAttribute("ARBCarRow", ARB_Car);
							request.setAttribute("ARBHarRow", ARB_Har);
							request.setAttribute("ARBOarRow", ARB_Oar);
							request.setAttribute("ARBNarRow", ARB_Nar);
							request.setAttribute("ARBSRow", ARB_S);
							request.setAttribute("ARBMarRow", ARB_Mar);
							request.setAttribute("ARBAarRow", ARB_Aar);
							request.setAttribute("madRow", mad);
							request.setAttribute("vdafRow", vdaf);
							request.setAttribute("ARBLHVRow", ARB_LHV);
							request.setAttribute("HGIRow", HGI);
							request.setAttribute("keRow", ke);
							request.setAttribute("ITRow", IT);
							request.setAttribute("DTRow", DT);
							request.setAttribute("STRow", ST);
							request.setAttribute("FTRow", FT);
							request.setAttribute("SiO2Row", SiO2);
							request.setAttribute("Al2O3Row", Al2O3);
							request.setAttribute("Fe2O3Row", Fe2O3);
							request.setAttribute("CaORow", CaO);
							request.setAttribute("SO3Row", SO3);
							request.setAttribute("grindabilityJudgeRow", grindability_judge);
							request.setAttribute("abradabilityJudgeRow", abradability_judge);
							request.setAttribute("fireStabilityJudgeRow", abradability_judge);
							request.setAttribute("ashQualityJudgeRow", ash_quality_judge);
							request.setAttribute("pollutionQualityJudgeRow", pollution_quality_judge);
							request.setAttribute("slagBondingTrendJudgeRow", slag_bonding_trend_judge);
							request.setAttribute("coalDustExplodeJudgeRow", coal_dust_explode_judge);
							request.setAttribute("summaryRow", summary);
							request.setAttribute("preparationOneRow", preparation_one);
							request.setAttribute("preparationTwoRow", preparation_two);
							request.setAttribute("preparationThreeRow", preparation_three);
							request.setAttribute("preparationFourRow", preparation_four);
							request.setAttribute("preparationFiveRow", preparation_five);
							request.setAttribute("preparationSixRow", preparation_six);
							request.setAttribute("preparationSevenRow", preparation_seven);
							request.setAttribute("preparationEightRow", preparation_eight);
							request.setAttribute("preparationNineRow", preparation_nine);
							request.setAttribute("preparationTenRow", preparation_ten);
							request.setAttribute("verifierRow", verifier);
						}
					}
				}
				request.setAttribute("op", "update");
				request.getRequestDispatcher("coal_material_insert.jsp").forward(request, response);
				
			}
			else if(op.equals("verify")){
				request.setAttribute("op", "verify");
				if(ch!=null){
					Map[] primaryRows = this.coalMaterialService.query(Integer.parseInt(ch));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("标准编号"));
						request.setAttribute("projectNameRow", m.get("工程名称"));
						request.setAttribute("sulfurRow", m.get("硫"));
						request.setAttribute("ashRow", m.get("灰分"));
						request.setAttribute("moistureRow", m.get("水分"));
						request.setAttribute("netCalorificPowerRow", m.get("低位发热量"));
						request.setAttribute("coalProducingAreaRow", m.get("燃煤产地"));
						request.setAttribute("ARBCarRow", m.get("收到基碳"));
						request.setAttribute("ARBHarRow", m.get("收到基氢"));
						request.setAttribute("ARBOarRow", m.get("收到基氧"));
						request.setAttribute("ARBNarRow", m.get("收到基氮"));
						request.setAttribute("ARBSRow", m.get("收到基全硫"));
						request.setAttribute("ARBMarRow", m.get("收到基水分"));
						request.setAttribute("ARBAarRow", m.get("收到基灰分"));
						request.setAttribute("madRow", m.get("空气干燥基水分"));
						request.setAttribute("vdafRow", m.get("干燥无灰基挥发分"));
						request.setAttribute("ARBLHVRow", m.get("收到基低位发热量"));
						request.setAttribute("HGIRow", m.get("可磨系数"));
						request.setAttribute("keRow", m.get("冲刷磨损指数"));
						request.setAttribute("ITRow", m.get("煤粉气流着火温度"));
						request.setAttribute("DTRow", m.get("变形温度"));
						request.setAttribute("STRow", m.get("软化温度"));
						request.setAttribute("FTRow", m.get("流动温度"));
						request.setAttribute("SiO2Row", m.get("二氧化硅"));
						request.setAttribute("Al2O3Row", m.get("三氧化二铝"));
						request.setAttribute("Fe2O3Row", m.get("三氧化二铁"));
						request.setAttribute("CaORow", m.get("氧化钙"));
						request.setAttribute("SO3Row", m.get("三氧化硫"));
						request.setAttribute("grindabilityJudgeRow", m.get("可磨性判定"));
						request.setAttribute("abradabilityJudgeRow", m.get("磨损性判定"));
						request.setAttribute("fireStabilityJudgeRow", m.get("着火稳定性判定"));
						request.setAttribute("ashQualityJudgeRow", m.get("燃烬特性判定"));
						request.setAttribute("pollutionQualityJudgeRow", m.get("灰沾污性能判定"));
						request.setAttribute("slagBondingTrendJudgeRow", m.get("结渣倾向判定"));
						request.setAttribute("coalDustExplodeJudgeRow", m.get("煤粉爆炸性判定"));
						request.setAttribute("summaryRow", m.get("摘要"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
						request.setAttribute("preparationSixRow", m.get("预留六"));
						request.setAttribute("preparationSevenRow", m.get("预留七"));
						request.setAttribute("preparationEightRow", m.get("预留八"));
						request.setAttribute("preparationNineRow", m.get("预留九"));
						request.setAttribute("preparationTenRow", m.get("预留十"));
						request.setAttribute("verifyCommentRow", m.get("审核意见"));
					}
					String method = request.getParameter("method");
					//file operate
					if(method!=null){
						if(method.equals("init"))
						{
							String defaultRootPath=Config.initPath;//默认的要配的路径
							String projectType=new String(request.getParameter("projectType").getBytes("ISO-8859-1"),Config.charset7);
							String projectId=new String(request.getParameter("projectId").getBytes("ISO-8859-1"),Config.charset7);
							String initPath=defaultRootPath+"/"+projectType+"/"+projectId+"/";
							//System.out.println(initPath);
							List<File> fileList=new ArrayList<File>();
							List<MyFile> myFileList=new ArrayList<MyFile>();
							fileService.getCurrentDirectoryFiles(fileList, initPath);
							for(int i=0;i<fileList.size();i++)
							{
								MyFile myFile=new MyFile();
								myFile.setFileName(fileList.get(i).getName().toString());
								myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
								Calendar cal=Calendar.getInstance();
								long time=fileList.get(i).lastModified();
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cal.setTimeInMillis(time);
								myFile.setLastModified(formatter.format(cal.getTime()));
								if(fileList.get(i).isDirectory())
								{
									myFile.setFileType("Folder");
									long size=fileService.getFolderSize(fileList.get(i))/1048576;
									myFile.setFileSize(size);
								}else
								{
									myFile.setFileType("File");
									long size=fileService.getFileSize(fileList.get(i))/1024;
									myFile.setFileSize(size);
								}
								myFileList.add(myFile);
							}
							request.setAttribute("currentPath", initPath);
							session.setAttribute("initPath", initPath);
							request.setAttribute("myFileList", myFileList);
						}
						else if(method.equals("checkSubFiles"))
						{
							String path=new String(request.getParameter("path").getBytes("ISO-8859-1"),Config.charset8);
							List<File> fileList=new ArrayList<File>();
							List<MyFile> myFileList=new ArrayList<MyFile>();
							fileService.getCurrentDirectoryFiles(fileList, path);
							for(int i=0;i<fileList.size();i++)
							{
								MyFile myFile=new MyFile();
								myFile.setFileName(fileList.get(i).getName().toString());
								myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
								Calendar cal=Calendar.getInstance();
								long time=fileList.get(i).lastModified();
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cal.setTimeInMillis(time);
								myFile.setLastModified(formatter.format(cal.getTime()));
								if(fileList.get(i).isDirectory())
								{
									myFile.setFileType("Folder");
									long size=fileService.getFolderSize(fileList.get(i))/1048576;
									myFile.setFileSize(size);
								}else
								{
									myFile.setFileType("File");
									long size=fileService.getFileSize(fileList.get(i))/1024;
									myFile.setFileSize(size);
								}
								myFileList.add(myFile);
							}
							request.setAttribute("currentPath", path);
							request.setAttribute("myFileList", myFileList);
						}else if(method.equals("checkParentFolder"))
						{
							String currentPath=request.getParameter("currentPath");
							String pathTransfer=new String(currentPath.getBytes("ISO-8859-1"),Config.charset9);
							List<File> fileList=new ArrayList<File>();
							List<MyFile> myFileList=new ArrayList<MyFile>();
							fileService.getCurrentDirectoryFiles(fileList, fileService.getParentPath(pathTransfer));
							for(int i=0;i<fileList.size();i++)
							{
								MyFile myFile=new MyFile();
								myFile.setFileName(fileList.get(i).getName().toString());
								myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
								Calendar cal=Calendar.getInstance();
								long time=fileList.get(i).lastModified();
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cal.setTimeInMillis(time);
								myFile.setLastModified(formatter.format(cal.getTime()));
								if(fileList.get(i).isDirectory())
								{
									myFile.setFileType("Folder");
									long size=fileService.getFolderSize(fileList.get(i))/1048576;
									myFile.setFileSize(size);
								}else
								{
									myFile.setFileType("File");
									long size=fileService.getFileSize(fileList.get(i))/1024;
									myFile.setFileSize(size);
								}
								myFileList.add(myFile);
							}
							request.setAttribute("currentPath", fileService.getParentPath(pathTransfer));
							request.setAttribute("myFileList", myFileList);
						}
					}else{
						
					}
					request.getRequestDispatcher("coal_material_insert.jsp").forward(request, response);
				}
				else{
					String id = request.getParameter("id");
					this.coal_material.setId(Integer.parseInt(id));
					this.coal_material.setPid(pid);
					this.coal_material.setProject_name(project_name);
					this.coal_material.setSulfur(sulfur);
					this.coal_material.setAsh(ash);
					this.coal_material.setMoisture(moisture);
					this.coal_material.setNet_calorific_power(net_calorific_power);
					this.coal_material.setCoal_producing_area(coal_producing_area);
					this.coal_material.setARB_Car(ARB_Car);
					this.coal_material.setARB_Har(ARB_Har);
					this.coal_material.setARB_Oar(ARB_Oar);
					this.coal_material.setARB_Nar(ARB_Nar);
					this.coal_material.setARB_S(ARB_S);
					this.coal_material.setARB_Mar(ARB_Mar);
					this.coal_material.setARB_Aar(ARB_Aar);
					this.coal_material.setMad(mad);
					this.coal_material.setVdaf(vdaf);
					this.coal_material.setARB_LHV(ARB_LHV);
					this.coal_material.setHGI(HGI);
					this.coal_material.setKe(ke);
					this.coal_material.setIT(IT);
					this.coal_material.setDT(DT);
					this.coal_material.setST(ST);
					this.coal_material.setFT(FT);
					this.coal_material.setSiO2(SiO2);
					this.coal_material.setAl2O3(Al2O3);
					this.coal_material.setFe2O3(Fe2O3);
					this.coal_material.setCaO(CaO);
					this.coal_material.setSO3(SO3);
					this.coal_material.setGrindability_judge(grindability_judge);
					this.coal_material.setAbradability_judge(abradability_judge);
					this.coal_material.setFire_stability_judge(fire_stability_judge);
					this.coal_material.setAsh_quality_judge(ash_quality_judge);
					this.coal_material.setPollution_quality_judge(pollution_quality_judge);
					this.coal_material.setSlag_bonding_trend_judge(slag_bonding_trend_judge);
					this.coal_material.setCoal_dust_explode_judge(coal_dust_explode_judge);
					this.coal_material.setSummary(summary);
					this.coal_material.setPreparation_one(preparation_one);
					this.coal_material.setPreparation_two(preparation_two);
					this.coal_material.setPreparation_three(preparation_three);
					this.coal_material.setPreparation_four(preparation_four);
					this.coal_material.setPreparation_five(preparation_five);
					this.coal_material.setPreparation_six(preparation_six);
					this.coal_material.setPreparation_seven(preparation_seven);
					this.coal_material.setPreparation_eight(preparation_eight);
					this.coal_material.setPreparation_nine(preparation_nine);
					this.coal_material.setPreparation_ten(preparation_ten);
					this.coal_material.setVerify_time(this.date.format(new Date()));
					this.coal_material.setVerify_comment(verify_comment);
					if(se!=null){
						if(se.equals("1")){
							this.coal_material.setVerify_state(2);
						}
						else if(se.equals("-1")){
							this.coal_material.setVerify_state(-1);
						}
					}
					this.coal_material.setVerify_comment(verify_comment);
					//填充
					request.setAttribute("idRow", Integer.parseInt(id));
					request.setAttribute("pidRow", pid);
					request.setAttribute("projectNameRow", project_name);
					request.setAttribute("sulfurRow", sulfur);
					request.setAttribute("ashRow", ash);
					request.setAttribute("moistureRow", moisture);
					request.setAttribute("netCalorificPowerRow",net_calorific_power);
					request.setAttribute("coalProducingAreaRow",coal_producing_area );
					request.setAttribute("ARBCarRow", ARB_Car);
					request.setAttribute("ARBHarRow", ARB_Har);
					request.setAttribute("ARBOarRow", ARB_Oar);
					request.setAttribute("ARBNarRow", ARB_Nar);
					request.setAttribute("ARBSRow", ARB_S);
					request.setAttribute("ARBMarRow", ARB_Mar);
					request.setAttribute("ARBAarRow", ARB_Aar);
					request.setAttribute("madRow", mad);
					request.setAttribute("vdafRow", vdaf);
					request.setAttribute("ARBLHVRow", ARB_LHV);
					request.setAttribute("HGIRow", HGI);
					request.setAttribute("keRow", ke);
					request.setAttribute("ITRow", IT);
					request.setAttribute("DTRow", DT);
					request.setAttribute("STRow", ST);
					request.setAttribute("FTRow", FT);
					request.setAttribute("SiO2Row", SiO2);
					request.setAttribute("Al2O3Row", Al2O3);
					request.setAttribute("Fe2O3Row", Fe2O3);
					request.setAttribute("CaORow", CaO);
					request.setAttribute("SO3Row", SO3);
					request.setAttribute("grindabilityJudgeRow", grindability_judge);
					request.setAttribute("abradabilityJudgeRow", abradability_judge);
					request.setAttribute("fireStabilityJudgeRow", abradability_judge);
					request.setAttribute("ashQualityJudgeRow", ash_quality_judge);
					request.setAttribute("pollutionQualityJudgeRow", pollution_quality_judge);
					request.setAttribute("slagBondingTrendJudgeRow", slag_bonding_trend_judge);
					request.setAttribute("coalDustExplodeJudgeRow", coal_dust_explode_judge);
					request.setAttribute("summaryRow", summary);
					request.setAttribute("preparationOneRow", preparation_one);
					request.setAttribute("preparationTwoRow", preparation_two);
					request.setAttribute("preparationThreeRow", preparation_three);
					request.setAttribute("preparationFourRow", preparation_four);
					request.setAttribute("preparationFiveRow", preparation_five);
					request.setAttribute("preparationSixRow", preparation_six);
					request.setAttribute("preparationSevenRow", preparation_seven);
					request.setAttribute("preparationEightRow", preparation_eight);
					request.setAttribute("preparationNineRow", preparation_nine);
					request.setAttribute("preparationTenRow", preparation_ten);
					request.setAttribute("verifyCommentRow", verify_comment);
					if(this.coalMaterialService.verify(coal_material)){
						//添加入系统日志
						this.log.setOperation("审核");
						this.logService.add(log);
						
						request.setAttribute("msg", "<script>alert('审核成功！')</script>");
					}
					else {
						request.setAttribute("msg", "<script>alert('审核失败！')</script>");
					}
					String method = request.getParameter("method");
					//file operate
					if(method!=null){
						if(method.equals("init"))
						{
							String defaultRootPath=Config.initPath;//默认的要配的路径
							String projectType=new String(request.getParameter("projectType").getBytes("ISO-8859-1"),Config.charset10);
							String projectId=new String(request.getParameter("projectId").getBytes("ISO-8859-1"),Config.charset10);
							String initPath=defaultRootPath+"/"+projectType+"/"+projectId+"/";
							//System.out.println(initPath);
							List<File> fileList=new ArrayList<File>();
							List<MyFile> myFileList=new ArrayList<MyFile>();
							fileService.getCurrentDirectoryFiles(fileList, initPath);
							for(int i=0;i<fileList.size();i++)
							{
								MyFile myFile=new MyFile();
								myFile.setFileName(fileList.get(i).getName().toString());
								myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
								Calendar cal=Calendar.getInstance();
								long time=fileList.get(i).lastModified();
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cal.setTimeInMillis(time);
								myFile.setLastModified(formatter.format(cal.getTime()));
								if(fileList.get(i).isDirectory())
								{
									myFile.setFileType("Folder");
									long size=fileService.getFolderSize(fileList.get(i))/1048576;
									myFile.setFileSize(size);
								}else
								{
									myFile.setFileType("File");
									long size=fileService.getFileSize(fileList.get(i))/1024;
									myFile.setFileSize(size);
								}
								myFileList.add(myFile);
							}
							request.setAttribute("currentPath", initPath);
							session.setAttribute("initPath", initPath);
							request.setAttribute("myFileList", myFileList);
						}
						else if(method.equals("checkSubFiles"))
						{
							String path=new String(request.getParameter("path").getBytes("ISO-8859-1"),Config.charset11);
							List<File> fileList=new ArrayList<File>();
							List<MyFile> myFileList=new ArrayList<MyFile>();
							fileService.getCurrentDirectoryFiles(fileList, path);
							for(int i=0;i<fileList.size();i++)
							{
								MyFile myFile=new MyFile();
								myFile.setFileName(fileList.get(i).getName().toString());
								myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
								Calendar cal=Calendar.getInstance();
								long time=fileList.get(i).lastModified();
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cal.setTimeInMillis(time);
								myFile.setLastModified(formatter.format(cal.getTime()));
								if(fileList.get(i).isDirectory())
								{
									myFile.setFileType("Folder");
									long size=fileService.getFolderSize(fileList.get(i))/1048576;
									myFile.setFileSize(size);
								}else
								{
									myFile.setFileType("File");
									long size=fileService.getFileSize(fileList.get(i))/1024;
									myFile.setFileSize(size);
								}
								myFileList.add(myFile);
							}
							request.setAttribute("currentPath", path);
							request.setAttribute("myFileList", myFileList);
						}else if(method.equals("checkParentFolder"))
						{
							String currentPath=request.getParameter("currentPath");
							String pathTransfer=new String(currentPath.getBytes("ISO-8859-1"),Config.charset12);
							List<File> fileList=new ArrayList<File>();
							List<MyFile> myFileList=new ArrayList<MyFile>();
							fileService.getCurrentDirectoryFiles(fileList, fileService.getParentPath(pathTransfer));
							for(int i=0;i<fileList.size();i++)
							{
								MyFile myFile=new MyFile();
								myFile.setFileName(fileList.get(i).getName().toString());
								myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
								Calendar cal=Calendar.getInstance();
								long time=fileList.get(i).lastModified();
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cal.setTimeInMillis(time);
								myFile.setLastModified(formatter.format(cal.getTime()));
								if(fileList.get(i).isDirectory())
								{
									myFile.setFileType("Folder");
									long size=fileService.getFolderSize(fileList.get(i))/1048576;
									myFile.setFileSize(size);
								}else
								{
									myFile.setFileType("File");
									long size=fileService.getFileSize(fileList.get(i))/1024;
									myFile.setFileSize(size);
								}
								myFileList.add(myFile);
							}
							request.setAttribute("currentPath", fileService.getParentPath(pathTransfer));
							request.setAttribute("myFileList", myFileList);
						}
					}else{
						
					}
					request.getRequestDispatcher("coal_material_insert.jsp").forward(request, response);
				}
			}
			else if(op.equals("save")){
				request.setAttribute("op","save");
				String id = request.getParameter("id");
				this.coal_material.setPid(pid);
				this.coal_material.setProject_name(project_name);
				this.coal_material.setSulfur(sulfur);
				this.coal_material.setAsh(ash);
				this.coal_material.setMoisture(moisture);
				this.coal_material.setNet_calorific_power(net_calorific_power);
				this.coal_material.setCoal_producing_area(coal_producing_area);
				this.coal_material.setARB_Car(ARB_Car);
				this.coal_material.setARB_Har(ARB_Har);
				this.coal_material.setARB_Oar(ARB_Oar);
				this.coal_material.setARB_Nar(ARB_Nar);
				this.coal_material.setARB_S(ARB_S);
				this.coal_material.setARB_Mar(ARB_Mar);
				this.coal_material.setARB_Aar(ARB_Aar);
				this.coal_material.setMad(mad);
				this.coal_material.setVdaf(vdaf);
				this.coal_material.setARB_LHV(ARB_LHV);
				this.coal_material.setHGI(HGI);
				this.coal_material.setKe(ke);
				this.coal_material.setIT(IT);
				this.coal_material.setDT(DT);
				this.coal_material.setST(ST);
				this.coal_material.setFT(FT);
				this.coal_material.setSiO2(SiO2);
				this.coal_material.setAl2O3(Al2O3);
				this.coal_material.setFe2O3(Fe2O3);
				this.coal_material.setCaO(CaO);
				this.coal_material.setSO3(SO3);
				this.coal_material.setGrindability_judge(grindability_judge);
				this.coal_material.setAbradability_judge(abradability_judge);
				this.coal_material.setFire_stability_judge(fire_stability_judge);
				this.coal_material.setAsh_quality_judge(ash_quality_judge);
				this.coal_material.setPollution_quality_judge(pollution_quality_judge);
				this.coal_material.setSlag_bonding_trend_judge(slag_bonding_trend_judge);
				this.coal_material.setCoal_dust_explode_judge(coal_dust_explode_judge);
				this.coal_material.setSummary(summary);
				this.coal_material.setPreparation_one(preparation_one);
				this.coal_material.setPreparation_two(preparation_two);
				this.coal_material.setPreparation_three(preparation_three);
				this.coal_material.setPreparation_four(preparation_four);
				this.coal_material.setPreparation_five(preparation_five);
				this.coal_material.setPreparation_six(preparation_six);
				this.coal_material.setPreparation_seven(preparation_seven);
				this.coal_material.setPreparation_eight(preparation_eight);
				this.coal_material.setPreparation_nine(preparation_nine);
				this.coal_material.setPreparation_ten(preparation_ten);
				this.coal_material.setVerify_state(0);
				this.coal_material.setEntry_time(this.date.format(new Date()));
				this.coal_material.setVerifier(verifier);
				this.coal_material.setType_in_userNme(UserName);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				
				if(id==null||id==""){
					if(this.coalMaterialService.isSubmit(pid)){
						request.setAttribute("msg", "<script>alert('已存在相应相同编号记录，请修改标准编号后提交！')</script>");
					}
					else{
						this.coalMaterialService.add(coal_material);
						request.setAttribute("idRow", this.coalMaterialService.getId(pid, 0));
						request.setAttribute("msg", "<script>alert('保存成功！')</script>");
						//添加入系统日志
						this.log.setOperation("保存");
						this.logService.add(log);
					}
					request.setAttribute("pidRow", pid);
					request.setAttribute("projectNameRow", project_name);
					request.setAttribute("sulfurRow", sulfur);
					request.setAttribute("ashRow", ash);
					request.setAttribute("moistureRow", moisture);
					request.setAttribute("netCalorificPowerRow",net_calorific_power);
					request.setAttribute("coalProducingAreaRow",coal_producing_area );
					request.setAttribute("ARBCarRow", ARB_Car);
					request.setAttribute("ARBHarRow", ARB_Har);
					request.setAttribute("ARBOarRow", ARB_Oar);
					request.setAttribute("ARBNarRow", ARB_Nar);
					request.setAttribute("ARBSRow", ARB_S);
					request.setAttribute("ARBMarRow", ARB_Mar);
					request.setAttribute("ARBAarRow", ARB_Aar);
					request.setAttribute("madRow", mad);
					request.setAttribute("vdafRow", vdaf);
					request.setAttribute("ARBLHVRow", ARB_LHV);
					request.setAttribute("HGIRow", HGI);
					request.setAttribute("keRow", ke);
					request.setAttribute("ITRow", IT);
					request.setAttribute("DTRow", DT);
					request.setAttribute("STRow", ST);
					request.setAttribute("FTRow", FT);
					request.setAttribute("SiO2Row", SiO2);
					request.setAttribute("Al2O3Row", Al2O3);
					request.setAttribute("Fe2O3Row", Fe2O3);
					request.setAttribute("CaORow", CaO);
					request.setAttribute("SO3Row", SO3);
					request.setAttribute("grindabilityJudgeRow", grindability_judge);
					request.setAttribute("abradabilityJudgeRow", abradability_judge);
					request.setAttribute("fireStabilityJudgeRow", abradability_judge);
					request.setAttribute("ashQualityJudgeRow", ash_quality_judge);
					request.setAttribute("pollutionQualityJudgeRow", pollution_quality_judge);
					request.setAttribute("slagBondingTrendJudgeRow", slag_bonding_trend_judge);
					request.setAttribute("coalDustExplodeJudgeRow", coal_dust_explode_judge);
					request.setAttribute("summaryRow", summary);
					request.setAttribute("preparationOneRow", preparation_one);
					request.setAttribute("preparationTwoRow", preparation_two);
					request.setAttribute("preparationThreeRow", preparation_three);
					request.setAttribute("preparationFourRow", preparation_four);
					request.setAttribute("preparationFiveRow", preparation_five);
					request.setAttribute("preparationSixRow", preparation_six);
					request.setAttribute("preparationSevenRow", preparation_seven);
					request.setAttribute("preparationEightRow", preparation_eight);
					request.setAttribute("preparationNineRow", preparation_nine);
					request.setAttribute("preparationTenRow", preparation_ten);
					request.setAttribute("verifierRow", verifier);
				}
				else {
					this.coal_material.setId(Integer.parseInt(id));
					//填充
					Map[] primaryRows = this.coalMaterialService.query(Integer.parseInt(id));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("标准编号"));
						request.setAttribute("projectNameRow", m.get("工程名称"));
						request.setAttribute("sulfurRow", m.get("硫"));
						request.setAttribute("ashRow", m.get("灰分"));
						request.setAttribute("moistureRow", m.get("水分"));
						request.setAttribute("netCalorificPowerRow", m.get("低位发热量"));
						request.setAttribute("coalProducingAreaRow", m.get("燃煤产地"));
						request.setAttribute("ARBCarRow", m.get("收到基碳"));
						request.setAttribute("ARBHarRow", m.get("收到基氢"));
						request.setAttribute("ARBOarRow", m.get("收到基氧"));
						request.setAttribute("ARBNarRow", m.get("收到基氮"));
						request.setAttribute("ARBSRow", m.get("收到基全硫"));
						request.setAttribute("ARBMarRow", m.get("收到基水分"));
						request.setAttribute("ARBAarRow", m.get("收到基灰分"));
						request.setAttribute("madRow", m.get("空气干燥基水分"));
						request.setAttribute("vdafRow", m.get("干燥无灰基挥发分"));
						request.setAttribute("ARBLHVRow", m.get("收到基低位发热量"));
						request.setAttribute("HGIRow", m.get("可磨系数"));
						request.setAttribute("keRow", m.get("冲刷磨损指数"));
						request.setAttribute("ITRow", m.get("煤粉气流着火温度"));
						request.setAttribute("DTRow", m.get("变形温度"));
						request.setAttribute("STRow", m.get("软化温度"));
						request.setAttribute("FTRow", m.get("流动温度"));
						request.setAttribute("SiO2Row", m.get("二氧化硅"));
						request.setAttribute("Al2O3Row", m.get("三氧化二铝"));
						request.setAttribute("Fe2O3Row", m.get("三氧化二铁"));
						request.setAttribute("CaORow", m.get("氧化钙"));
						request.setAttribute("SO3Row", m.get("三氧化硫"));
						request.setAttribute("grindabilityJudgeRow", m.get("可磨性判定"));
						request.setAttribute("abradabilityJudgeRow", m.get("磨损性判定"));
						request.setAttribute("fireStabilityJudgeRow", m.get("着火稳定性判定"));
						request.setAttribute("ashQualityJudgeRow", m.get("燃烬特性判定"));
						request.setAttribute("pollutionQualityJudgeRow", m.get("灰沾污性能判定"));
						request.setAttribute("slagBondingTrendJudgeRow", m.get("结渣倾向判定"));
						request.setAttribute("coalDustExplodeJudgeRow", m.get("煤粉爆炸性判定"));
						request.setAttribute("summaryRow", m.get("摘要"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
						request.setAttribute("preparationSixRow", m.get("预留六"));
						request.setAttribute("preparationSevenRow", m.get("预留七"));
						request.setAttribute("preparationEightRow", m.get("预留八"));
						request.setAttribute("preparationNineRow", m.get("预留九"));
						request.setAttribute("preparationTenRow", m.get("预留十"));
						request.setAttribute("verifierRow", m.get("审核人"));
						
					}
					if(this.coalMaterialService.update(coal_material)){
						//添加入系统日志
						this.log.setOperation("更新");
						this.logService.add(log);
						
						request.setAttribute("msg", "<script>alert('保存成功！')</script>");
					}
					else {
						request.setAttribute("msg", "<script>alert('保存失败！')</script>");
					}
				}
				request.setAttribute("op", "save");
				request.getRequestDispatcher("coal_material_insert.jsp").forward(request, response);
			}
			else if(op.equals("maintenance")){
				request.setAttribute("op", "update");
				String id = request.getParameter("id");
				if(ch!=null){
					if(ch.equals("open")){
						String method = request.getParameter("method");
						//file operate
						if(method!=null){
							if(method.equals("init"))
							{
								String defaultRootPath=Config.initPath;//默认的要配的路径
								String projectType=new String(request.getParameter("projectType").getBytes("ISO-8859-1"),Config.charset1);
								String projectId=new String(request.getParameter("projectId").getBytes("ISO-8859-1"),Config.charset1);
								String initPath=defaultRootPath+"/"+projectType+"/"+projectId+"/";
								//System.out.println(initPath);
								List<File> fileList=new ArrayList<File>();
								List<MyFile> myFileList=new ArrayList<MyFile>();
								fileService.getCurrentDirectoryFiles(fileList, initPath);
								for(int i=0;i<fileList.size();i++)
								{
									MyFile myFile=new MyFile();
									myFile.setFileName(fileList.get(i).getName().toString());
									myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
									Calendar cal=Calendar.getInstance();
									long time=fileList.get(i).lastModified();
									SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									cal.setTimeInMillis(time);
									myFile.setLastModified(formatter.format(cal.getTime()));
									if(fileList.get(i).isDirectory())
									{
										myFile.setFileType("Folder");
										long size=fileService.getFolderSize(fileList.get(i))/1048576;
										myFile.setFileSize(size);
									}else
									{
										myFile.setFileType("File");
										long size=fileService.getFileSize(fileList.get(i))/1024;
										myFile.setFileSize(size);
									}
									myFileList.add(myFile);
								}
								request.setAttribute("currentPath", initPath);
								session.setAttribute("initPath", initPath);
								request.setAttribute("myFileList", myFileList);
							}
							else if(method.equals("checkSubFiles"))
							{
								String path=new String(request.getParameter("path").getBytes("ISO-8859-1"),Config.charset2);
								List<File> fileList=new ArrayList<File>();
								List<MyFile> myFileList=new ArrayList<MyFile>();
								fileService.getCurrentDirectoryFiles(fileList, path);
								for(int i=0;i<fileList.size();i++)
								{
									MyFile myFile=new MyFile();
									myFile.setFileName(fileList.get(i).getName().toString());
									myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
									Calendar cal=Calendar.getInstance();
									long time=fileList.get(i).lastModified();
									SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									cal.setTimeInMillis(time);
									myFile.setLastModified(formatter.format(cal.getTime()));
									if(fileList.get(i).isDirectory())
									{
										myFile.setFileType("Folder");
										long size=fileService.getFolderSize(fileList.get(i))/1048576;
										myFile.setFileSize(size);
									}else
									{
										myFile.setFileType("File");
										long size=fileService.getFileSize(fileList.get(i))/1024;
										myFile.setFileSize(size);
									}
									myFileList.add(myFile);
								}
								request.setAttribute("currentPath", path);
								request.setAttribute("myFileList", myFileList);
							}else if(method.equals("checkParentFolder"))
							{
								String currentPath=request.getParameter("currentPath");
								String pathTransfer=new String(currentPath.getBytes("ISO-8859-1"),Config.charset3);
								List<File> fileList=new ArrayList<File>();
								List<MyFile> myFileList=new ArrayList<MyFile>();
								fileService.getCurrentDirectoryFiles(fileList, fileService.getParentPath(pathTransfer));
								for(int i=0;i<fileList.size();i++)
								{
									MyFile myFile=new MyFile();
									myFile.setFileName(fileList.get(i).getName().toString());
									myFile.setFilePath(fileService.getAvailablePath(fileList.get(i)));
									Calendar cal=Calendar.getInstance();
									long time=fileList.get(i).lastModified();
									SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									cal.setTimeInMillis(time);
									myFile.setLastModified(formatter.format(cal.getTime()));
									if(fileList.get(i).isDirectory())
									{
										myFile.setFileType("Folder");
										long size=fileService.getFolderSize(fileList.get(i))/1048576;
										myFile.setFileSize(size);
									}else
									{
										myFile.setFileType("File");
										long size=fileService.getFileSize(fileList.get(i))/1024;
										myFile.setFileSize(size);
									}
									myFileList.add(myFile);
								}
								request.setAttribute("currentPath", fileService.getParentPath(pathTransfer));
								request.setAttribute("myFileList", myFileList);
							}
						}else{
							
						}
					}
					else{
						this.coal_material.setId(Integer.parseInt(id));
						this.coal_material.setPid(pid);
						this.coal_material.setProject_name(project_name);
						this.coal_material.setSulfur(sulfur);
						this.coal_material.setAsh(ash);
						this.coal_material.setMoisture(moisture);
						this.coal_material.setNet_calorific_power(net_calorific_power);
						this.coal_material.setCoal_producing_area(coal_producing_area);
						this.coal_material.setARB_Car(ARB_Car);
						this.coal_material.setARB_Har(ARB_Har);
						this.coal_material.setARB_Oar(ARB_Oar);
						this.coal_material.setARB_Nar(ARB_Nar);
						this.coal_material.setARB_S(ARB_S);
						this.coal_material.setARB_Mar(ARB_Mar);
						this.coal_material.setARB_Aar(ARB_Aar);
						this.coal_material.setMad(mad);
						this.coal_material.setVdaf(vdaf);
						this.coal_material.setARB_LHV(ARB_LHV);
						this.coal_material.setHGI(HGI);
						this.coal_material.setKe(ke);
						this.coal_material.setIT(IT);
						this.coal_material.setDT(DT);
						this.coal_material.setST(ST);
						this.coal_material.setFT(FT);
						this.coal_material.setSiO2(SiO2);
						this.coal_material.setAl2O3(Al2O3);
						this.coal_material.setFe2O3(Fe2O3);
						this.coal_material.setCaO(CaO);
						this.coal_material.setSO3(SO3);
						this.coal_material.setGrindability_judge(grindability_judge);
						this.coal_material.setAbradability_judge(abradability_judge);
						this.coal_material.setFire_stability_judge(fire_stability_judge);
						this.coal_material.setAsh_quality_judge(ash_quality_judge);
						this.coal_material.setPollution_quality_judge(pollution_quality_judge);
						this.coal_material.setSlag_bonding_trend_judge(slag_bonding_trend_judge);
						this.coal_material.setCoal_dust_explode_judge(coal_dust_explode_judge);
						this.coal_material.setSummary(summary);
						this.coal_material.setPreparation_one(preparation_one);
						this.coal_material.setPreparation_two(preparation_two);
						this.coal_material.setPreparation_three(preparation_three);
						this.coal_material.setPreparation_four(preparation_four);
						this.coal_material.setPreparation_five(preparation_five);
						this.coal_material.setPreparation_six(preparation_six);
						this.coal_material.setPreparation_seven(preparation_seven);
						this.coal_material.setPreparation_eight(preparation_eight);
						this.coal_material.setPreparation_nine(preparation_nine);
						this.coal_material.setPreparation_ten(preparation_ten);
						this.coal_material.setVerifier(verifier);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.coalMaterialService.maintenance(coal_material)){
							//添加入系统日志
							this.log.setOperation("维护");
							this.logService.add(log);
							
							request.setAttribute("msg", "<script>alert('更新成功！')</script>");
						}
						else {
							request.setAttribute("msg", "<script>alert('更新失败！')</script>");
						}
					}
				}
				
				//填充
				Map[] primaryRows = this.coalMaterialService.query(Integer.parseInt(id));
				for(Map m : primaryRows){
					request.setAttribute("idRow", m.get("编号"));
					request.setAttribute("pidRow", m.get("标准编号"));
					request.setAttribute("projectNameRow", m.get("工程名称"));
					request.setAttribute("sulfurRow", m.get("硫"));
					request.setAttribute("ashRow", m.get("灰分"));
					request.setAttribute("moistureRow", m.get("水分"));
					request.setAttribute("netCalorificPowerRow", m.get("低位发热量"));
					request.setAttribute("coalProducingAreaRow", m.get("燃煤产地"));
					request.setAttribute("ARBCarRow", m.get("收到基碳"));
					request.setAttribute("ARBHarRow", m.get("收到基氢"));
					request.setAttribute("ARBOarRow", m.get("收到基氧"));
					request.setAttribute("ARBNarRow", m.get("收到基氮"));
					request.setAttribute("ARBSRow", m.get("收到基全硫"));
					request.setAttribute("ARBMarRow", m.get("收到基水分"));
					request.setAttribute("ARBAarRow", m.get("收到基灰分"));
					request.setAttribute("madRow", m.get("空气干燥基水分"));
					request.setAttribute("vdafRow", m.get("干燥无灰基挥发分"));
					request.setAttribute("ARBLHVRow", m.get("收到基低位发热量"));
					request.setAttribute("HGIRow", m.get("可磨系数"));
					request.setAttribute("keRow", m.get("冲刷磨损指数"));
					request.setAttribute("ITRow", m.get("煤粉气流着火温度"));
					request.setAttribute("DTRow", m.get("变形温度"));
					request.setAttribute("STRow", m.get("软化温度"));
					request.setAttribute("FTRow", m.get("流动温度"));
					request.setAttribute("SiO2Row", m.get("二氧化硅"));
					request.setAttribute("Al2O3Row", m.get("三氧化二铝"));
					request.setAttribute("Fe2O3Row", m.get("三氧化二铁"));
					request.setAttribute("CaORow", m.get("氧化钙"));
					request.setAttribute("SO3Row", m.get("三氧化硫"));
					request.setAttribute("grindabilityJudgeRow", m.get("可磨性判定"));
					request.setAttribute("abradabilityJudgeRow", m.get("磨损性判定"));
					request.setAttribute("fireStabilityJudgeRow", m.get("着火稳定性判定"));
					request.setAttribute("ashQualityJudgeRow", m.get("燃烬特性判定"));
					request.setAttribute("pollutionQualityJudgeRow", m.get("灰沾污性能判定"));
					request.setAttribute("slagBondingTrendJudgeRow", m.get("结渣倾向判定"));
					request.setAttribute("coalDustExplodeJudgeRow", m.get("煤粉爆炸性判定"));
					request.setAttribute("summaryRow", m.get("摘要"));
					request.setAttribute("preparationOneRow", m.get("预留一"));
					request.setAttribute("preparationTwoRow", m.get("预留二"));
					request.setAttribute("preparationThreeRow", m.get("预留三"));
					request.setAttribute("preparationFourRow", m.get("预留四"));
					request.setAttribute("preparationFiveRow", m.get("预留五"));
					request.setAttribute("preparationSixRow", m.get("预留六"));
					request.setAttribute("preparationSevenRow", m.get("预留七"));
					request.setAttribute("preparationEightRow", m.get("预留八"));
					request.setAttribute("preparationNineRow", m.get("预留九"));
					request.setAttribute("preparationTenRow", m.get("预留十"));
					request.setAttribute("verifierRow", m.get("审核人"));
				}
				request.getRequestDispatcher("coal_material_insert.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "<script>alert('非法访问，无相应参数！')</script>");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

}
