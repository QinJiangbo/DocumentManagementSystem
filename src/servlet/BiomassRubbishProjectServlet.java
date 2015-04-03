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

import pojo.Biomass_rubbish_project;
import pojo.Config;
import pojo.Log;
import pojo.MyFile;
import service.BiomassRubbishProjectServiceImpl;
import service.FieldMaintenanceServiceImpl;
import service.FileService;
import service.IBiomassRubbishProjectService;
import service.IFieldMaintenanceService;
import service.ILogService;
import service.IUndoService;
import service.IUserService;
import service.LogServiceImpl;
import service.UndoServiceImpl;
import service.UserServiceImpl;


/**
 * Servlet implementation class BiomassRubbishProjectServlet
 */
@SuppressWarnings("rawtypes")
public class BiomassRubbishProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Biomass_rubbish_project biomass_rubbish_project = new Biomass_rubbish_project();
    private IBiomassRubbishProjectService biomassRubbishProjectService = new BiomassRubbishProjectServiceImpl();
    private IFieldMaintenanceService fieldMaintenanceService = new FieldMaintenanceServiceImpl();
    private IUserService userService = new UserServiceImpl();
    private IUndoService undoService = new UndoServiceImpl();
    private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
    FileService fileService=new FileService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BiomassRubbishProjectServlet() {
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
		request.setAttribute("run", "1");
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
			String name = request.getParameter("name");
			String type = request.getParameter("type");
			String nation = request.getParameter("nation");
			String area = request.getParameter("area");
			String installation_number = request.getParameter("installation_number");
			String construction_mode = request.getParameter("construction_mode");
			String boiler_type = request.getParameter("boiler_type");
			String fuel_type = request.getParameter("fuel_type");
			String dusting_method = request.getParameter("dusting_method");
			String sulfur_removal_method = request.getParameter("sulfur_removal_method");
			String average_temperature = request.getParameter("average_temperature");
			String extreme_high_temperature = request.getParameter("extreme_high_temperature");
			String extreme_low_temperature = request.getParameter("extreme_low_temperature");
			String average_relative_humid = request.getParameter("average_relative_humid");
			String circulating_cooling_method = request.getParameter("circulating_cooling_method");
			String water_source = request.getParameter("water_source");
			String cooling_tower_pattern = request.getParameter("cooling_tower_pattern");
			String fire_protection_standard = request.getParameter("fire_protection_standard");
			String raw_water_preprocess = request.getParameter("raw_water_preprocess");
			String factory_area = request.getParameter("factory_area");
			String design_basic_seismic_acceleration = request.getParameter("design_basic_seismic_acceleration");
			String foundation_type = request.getParameter("foundation_type");
			String main_factory_structure_pattern = request.getParameter("main_factory_structure_pattern");
			String water_circulation_system_overview = request.getParameter("water_circulation_system_overview");
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
			Map[] typeRows = this.biomassRubbishProjectService.getDefaultTypeRows();
			Map[] nationRows = this.biomassRubbishProjectService.getDefaultNationRows();
			Map[] constructionModeRows = this.biomassRubbishProjectService.getDefaultConstructionModeRows();
			Map[] boilerTypeRows = this.biomassRubbishProjectService.getDefaultBoilerTypeRows();
			Map[] fuelTypeRows = this.biomassRubbishProjectService.getDefaultFuelTypeRows();
			Map[] dustingMethodRows = this.biomassRubbishProjectService.getDefaultDustingMethodRows();
			Map[] sulfurRemovalMethodRows = this.biomassRubbishProjectService.getDefaultSulfurRemovalMethodRows();
			Map[] circulatingCoolingMethodRows = this.biomassRubbishProjectService.getDefaultCirculatingCoolingMethodRows();
			Map[] waterSourceRows = this.biomassRubbishProjectService.getDefaultWaterSourceRows();
			Map[] coolingTowerPatternRows = this.biomassRubbishProjectService.getDefaultCoolingTowerPatternRows();
			Map[] fireProtectionStantardRows = this.biomassRubbishProjectService.getDefaultFireProtectionStantardRows();
			Map[] rawWaterPreprocessRows = this.biomassRubbishProjectService.getDefaultRawWaterPreprocessRows();
			Map[] designBasicSeismicAccelerationRows = this.biomassRubbishProjectService.getDefaultDesignBasicSeismicAccelerationRows();
			Map[] foundationTypeRows = this.biomassRubbishProjectService.getDefaultFoundationTypeRows();
			Map[] mainFactoryStructurePatternRows = this.biomassRubbishProjectService.getDefaultMainFactoryStructurePatternRows();
			Map[] verifierRows = this.userService.getDefaultVerifierRows();
			Map[] preparationOneRows = this.biomassRubbishProjectService.getDefaultPreparationOneRows();
			Map[] preparationTwoRows = this.biomassRubbishProjectService.getDefaultPreparationTwoRows();
			Map[] preparationThreeRows = this.biomassRubbishProjectService.getDefaultPreparationThreeRows();
			Map[] preparationFourRows = this.biomassRubbishProjectService.getDefaultPreparationFourRows();
			Map[] preparationFiveRows = this.biomassRubbishProjectService.getDefaultPreparationFiveRows();
			Map[] preparationSixRows= this.biomassRubbishProjectService.getDefaultPreparationSixRows();
			Map[] preparationSevenRows = this.biomassRubbishProjectService.getDefaultPreparationSevenRows();
			Map[] preparationEightRows = this.biomassRubbishProjectService.getDefaultPreparationEightRows();
			Map[] preparationNineRows= this.biomassRubbishProjectService.getDefaultPreparationNineRows();
			Map[] preparationTenRows = this.biomassRubbishProjectService.getDefaultPreparationTenRows();
			request.setAttribute("typeRows",typeRows);
			request.setAttribute("nationRows",nationRows);
			request.setAttribute("constructionModeRows",constructionModeRows);
			request.setAttribute("boilerTypeRows",boilerTypeRows);
			request.setAttribute("fuelTypeRows",fuelTypeRows);
			request.setAttribute("dustingMethodRows",dustingMethodRows);
			request.setAttribute("sulfurRemovalMethodRows",sulfurRemovalMethodRows);
			request.setAttribute("circulatingCoolingMethodRows",circulatingCoolingMethodRows);
			request.setAttribute("waterSourceRows",waterSourceRows);
			request.setAttribute("coolingTowerPatternRows",coolingTowerPatternRows);
			request.setAttribute("fireProtectionStantardRows",fireProtectionStantardRows);
			request.setAttribute("rawWaterPreprocessRows",rawWaterPreprocessRows);
			request.setAttribute("designBasicSeismicAccelerationRows",designBasicSeismicAccelerationRows);
			request.setAttribute("foundationTypeRows",foundationTypeRows);
			request.setAttribute("mainFactoryStructurePatternRows",mainFactoryStructurePatternRows);
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
			request.setAttribute("project_expert",this.undoService.getProjectExpertNum(UserName));
			request.setAttribute("pageName", "biomass_rubbish_project");//pageName for page dispatcher
			this.log.setUname(UserName);
			this.log.setTable("生物质、垃圾发电项目");
			this.log.setTime(this.date.format(new Date()));
			//设置初始审核人
			request.setAttribute("verifierRow", this.userService.getDefaultVerifier(UserName));
			//预留字段是否启用
			int isPreparationOneUsed = this.fieldMaintenanceService.isUse("生物质、垃圾发电项目","预留一");
			int isPreparationTwoUsed = this.fieldMaintenanceService.isUse("生物质、垃圾发电项目","预留二");
			int isPreparationThreeUsed = this.fieldMaintenanceService.isUse("生物质、垃圾发电项目","预留三");
			int isPreparationFourUsed = this.fieldMaintenanceService.isUse("生物质、垃圾发电项目","预留四");
			int isPreparationFiveUsed = this.fieldMaintenanceService.isUse("生物质、垃圾发电项目","预留五");
			int isPreparationSixUsed = this.fieldMaintenanceService.isUse("生物质、垃圾发电项目","预留六");
			int isPreparationSevenUsed = this.fieldMaintenanceService.isUse("生物质、垃圾发电项目","预留七");
			int isPreparationEightUsed = this.fieldMaintenanceService.isUse("生物质、垃圾发电项目","预留八");
			int isPreparationNineUsed = this.fieldMaintenanceService.isUse("生物质、垃圾发电项目","预留九");
			int isPreparationTenUsed = this.fieldMaintenanceService.isUse("生物质、垃圾发电项目","预留十");
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
			String preparationOneNewName = this.fieldMaintenanceService.getNewName("生物质、垃圾发电项目","预留一");
			String preparationTwoNewName = this.fieldMaintenanceService.getNewName("生物质、垃圾发电项目","预留二");
			String preparationThreeNewName = this.fieldMaintenanceService.getNewName("生物质、垃圾发电项目","预留三");
			String preparationFourNewName = this.fieldMaintenanceService.getNewName("生物质、垃圾发电项目","预留四");
			String preparationFiveNewName = this.fieldMaintenanceService.getNewName("生物质、垃圾发电项目","预留五");
			String preparationSixNewName = this.fieldMaintenanceService.getNewName("生物质、垃圾发电项目","预留六");
			String preparationSevenNewName = this.fieldMaintenanceService.getNewName("生物质、垃圾发电项目","预留七");
			String preparationEightNewName = this.fieldMaintenanceService.getNewName("生物质、垃圾发电项目","预留八");
			String preparationNineNewName = this.fieldMaintenanceService.getNewName("生物质、垃圾发电项目","预留九");
			String preparationTenNewName = this.fieldMaintenanceService.getNewName("生物质、垃圾发电项目","预留十");
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
				if(this.biomassRubbishProjectService.hasSave(UserName)){
					Map[] primaryRows = this.biomassRubbishProjectService.primaryQuery(UserName);
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("installationNumberRow", m.get("装机数量"));
						request.setAttribute("constructionModeRow", m.get("建设方式"));
						request.setAttribute("boilerTypeRow", m.get("锅炉类型"));
						request.setAttribute("fuelTypeRow", m.get("燃料类型"));
						request.setAttribute("dustingMethodRow", m.get("除尘方式"));
						request.setAttribute("sulfurRemovalMethodRow", m.get("脱硫方式"));
						request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
						request.setAttribute("circulatingCoolingMethodRow", m.get("循环冷却方式"));
						request.setAttribute("waterSourceRow", m.get("水源"));
						request.setAttribute("coolingTowerPatternRow", m.get("冷却塔型式"));
						request.setAttribute("fireProtectionStandardRow", m.get("消防标准"));
						request.setAttribute("rawWaterPreprocessRow", m.get("原水预处理"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
						request.setAttribute("designBasicSeismicAccelerationRow", m.get("设计基本地震加速度"));
						request.setAttribute("foundationTypeRow", m.get("基础型式"));
						request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
						request.setAttribute("waterCirculationSystemOverviewRow", m.get("循环水系统概述"));
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
					request.getRequestDispatcher("biomass_rubbish_project_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("biomass_rubbish_project_insert.jsp").forward(request, response);
				}
				
			}
			else if(op.equals("add")){
				request.setAttribute("op","insert");
				this.biomass_rubbish_project.setPid(pid);
				this.biomass_rubbish_project.setName(name);
				this.biomass_rubbish_project.setType(type);
				this.biomass_rubbish_project.setNation(nation);
				this.biomass_rubbish_project.setArea(area);
				this.biomass_rubbish_project.setInstallation_number(installation_number);
				this.biomass_rubbish_project.setConstruction_mode(construction_mode);
				this.biomass_rubbish_project.setBoiler_type(boiler_type);
				this.biomass_rubbish_project.setFuel_type(fuel_type);
				this.biomass_rubbish_project.setDusting_method(dusting_method);
				this.biomass_rubbish_project.setSulfur_removal_method(sulfur_removal_method);
				this.biomass_rubbish_project.setAverage_temperature(average_temperature);
				this.biomass_rubbish_project.setExtreme_high_temperature(extreme_high_temperature);
				this.biomass_rubbish_project.setExtreme_low_temperature(extreme_low_temperature);
				this.biomass_rubbish_project.setAverage_relative_humid(average_relative_humid);
				this.biomass_rubbish_project.setCirculating_cooling_method(circulating_cooling_method);
				this.biomass_rubbish_project.setWater_source(water_source);
				this.biomass_rubbish_project.setCooling_tower_pattern(cooling_tower_pattern);
				this.biomass_rubbish_project.setFire_protection_standard(fire_protection_standard);
				this.biomass_rubbish_project.setRaw_water_preprocess(raw_water_preprocess);
				this.biomass_rubbish_project.setFactory_area(factory_area);
				this.biomass_rubbish_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
				this.biomass_rubbish_project.setFoundation_type(foundation_type);
				this.biomass_rubbish_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
				this.biomass_rubbish_project.setWater_circulation_system_overview(water_circulation_system_overview);
				this.biomass_rubbish_project.setPreparation_one(preparation_one);
				this.biomass_rubbish_project.setPreparation_two(preparation_two);
				this.biomass_rubbish_project.setPreparation_three(preparation_three);
				this.biomass_rubbish_project.setPreparation_four(preparation_four);
				this.biomass_rubbish_project.setPreparation_five(preparation_five);
				this.biomass_rubbish_project.setPreparation_six(preparation_six);
				this.biomass_rubbish_project.setPreparation_seven(preparation_seven);
				this.biomass_rubbish_project.setPreparation_eight(preparation_eight);
				this.biomass_rubbish_project.setPreparation_nine(preparation_nine);
				this.biomass_rubbish_project.setPreparation_ten(preparation_ten);
				this.biomass_rubbish_project.setEntry_time(this.date.format(new Date()));
				this.biomass_rubbish_project.setType_in_userNme(UserName);
				this.biomass_rubbish_project.setVerifier(verifier);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				request.setAttribute("pidRow",pid);
				request.setAttribute("nameRow",name);
				request.setAttribute("typeRow",type);
				request.setAttribute("nationRow",nation);
				request.setAttribute("areaRow",area);
				request.setAttribute("installationNumberRow",installation_number);
				request.setAttribute("constructionModeRow",construction_mode);
				request.setAttribute("boilerTypeRow",boiler_type);
				request.setAttribute("fuelTypeRow",fuel_type);
				request.setAttribute("dustingMethodRow",dusting_method);
				request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
				request.setAttribute("averageTemperatureRow",average_temperature);
				request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
				request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
				request.setAttribute("averageRelativeHumidRow",average_relative_humid);
				request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
				request.setAttribute("waterSourceRow",water_source);
				request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
				request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
				request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
				request.setAttribute("factoryAreaRow",factory_area);
				request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
				request.setAttribute("foundationTypeRow",foundation_type);
				request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
				request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
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

				if(this.biomassRubbishProjectService.isSubmit(pid)){
					if(this.biomassRubbishProjectService.isSave(pid)){
						request.setAttribute("msg", "<script>alert('已存在相同编号保存记录,无法继续保存第二条具有相同编号的记录,请核实并修改项目编号！')</script>");
					}
					else{
						if(this.biomassRubbishProjectService.hasSave(UserName)){
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，并且您已有一条保存记录了,无法继续保存第二条的记录,请核实并修改项目编号！')</script>");
						}
						else {
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，请核实项目编号后提交！')</script>");
						}
					}
				}
				else{
					this.biomass_rubbish_project.setVerify_state(1);
					if(this.biomassRubbishProjectService.add(biomass_rubbish_project)){
						//添加入系统日志
						this.log.setOperation("录入");
						this.logService.add(log);
						Map[] primaryRows = this.biomassRubbishProjectService.query(this.biomassRubbishProjectService.getId(pid, 1));
						for(Map m : primaryRows){
							request.setAttribute("idRow", m.get("编号"));
							request.setAttribute("pidRow", m.get("项目编号"));
							request.setAttribute("nameRow", m.get("项目名称"));
							request.setAttribute("typeRow", m.get("项目类别"));
							request.setAttribute("nationRow", m.get("项目所在国"));
							request.setAttribute("areaRow", m.get("项目所在地区"));
							request.setAttribute("installationNumberRow", m.get("装机数量"));
							request.setAttribute("constructionModeRow", m.get("建设方式"));
							request.setAttribute("boilerTypeRow", m.get("锅炉类型"));
							request.setAttribute("fuelTypeRow", m.get("燃料类型"));
							request.setAttribute("dustingMethodRow", m.get("除尘方式"));
							request.setAttribute("sulfurRemovalMethodRow", m.get("脱硫方式"));
							request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
							request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
							request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
							request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
							request.setAttribute("circulatingCoolingMethodRow", m.get("循环冷却方式"));
							request.setAttribute("waterSourceRow", m.get("水源"));
							request.setAttribute("coolingTowerPatternRow", m.get("冷却塔型式"));
							request.setAttribute("fireProtectionStandardRow", m.get("消防标准"));
							request.setAttribute("rawWaterPreprocessRow", m.get("原水预处理"));
							request.setAttribute("factoryAreaRow", m.get("厂区面积"));
							request.setAttribute("designBasicSeismicAccelerationRow", m.get("设计基本地震加速度"));
							request.setAttribute("foundationTypeRow", m.get("基础型式"));
							request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
							request.setAttribute("waterCirculationSystemOverviewRow", m.get("循环水系统概述"));
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
						request.setAttribute("op","update");
						request.setAttribute("msg", "<script>alert('提交成功！')</script>");
						
					}
					else{
						request.setAttribute("msg", "<script>alert('提交失败！')</script>");
					}
				}
				request.setAttribute("op","update");
				request.getRequestDispatcher("biomass_rubbish_project_insert.jsp").forward(request, response);
			}
			else if(op.equals("query")){
				request.setAttribute("op", "query");
				this.biomass_rubbish_project.setPid(pid);
				this.biomass_rubbish_project.setName(name);
				this.biomass_rubbish_project.setType(type);
				this.biomass_rubbish_project.setNation(nation);
				this.biomass_rubbish_project.setArea(area);
				this.biomass_rubbish_project.setInstallation_number(installation_number);
				this.biomass_rubbish_project.setConstruction_mode(construction_mode);
				this.biomass_rubbish_project.setBoiler_type(boiler_type);
				this.biomass_rubbish_project.setFuel_type(fuel_type);
				this.biomass_rubbish_project.setDusting_method(dusting_method);
				this.biomass_rubbish_project.setSulfur_removal_method(sulfur_removal_method);
				this.biomass_rubbish_project.setAverage_temperature(average_temperature);
				this.biomass_rubbish_project.setExtreme_high_temperature(extreme_high_temperature);
				this.biomass_rubbish_project.setExtreme_low_temperature(extreme_low_temperature);
				this.biomass_rubbish_project.setAverage_relative_humid(average_relative_humid);
				this.biomass_rubbish_project.setCirculating_cooling_method(circulating_cooling_method);
				this.biomass_rubbish_project.setWater_source(water_source);
				this.biomass_rubbish_project.setCooling_tower_pattern(cooling_tower_pattern);
				this.biomass_rubbish_project.setFire_protection_standard(fire_protection_standard);
				this.biomass_rubbish_project.setRaw_water_preprocess(raw_water_preprocess);
				this.biomass_rubbish_project.setFactory_area(factory_area);
				this.biomass_rubbish_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
				this.biomass_rubbish_project.setFoundation_type(foundation_type);
				this.biomass_rubbish_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
				this.biomass_rubbish_project.setWater_circulation_system_overview(water_circulation_system_overview);
				this.biomass_rubbish_project.setPreparation_one(preparation_one);
				this.biomass_rubbish_project.setPreparation_two(preparation_two);
				this.biomass_rubbish_project.setPreparation_three(preparation_three);
				this.biomass_rubbish_project.setPreparation_four(preparation_four);
				this.biomass_rubbish_project.setPreparation_five(preparation_five);
				this.biomass_rubbish_project.setPreparation_six(preparation_six);
				this.biomass_rubbish_project.setPreparation_seven(preparation_seven);
				this.biomass_rubbish_project.setPreparation_eight(preparation_eight);
				this.biomass_rubbish_project.setPreparation_nine(preparation_nine);
				this.biomass_rubbish_project.setPreparation_ten(preparation_ten);
				
				Map[] rows = this.biomassRubbishProjectService.query(biomass_rubbish_project);
				//添加入系统日志
				this.log.setOperation("查询");
				this.logService.add(log);
				
				request.setAttribute("rows", rows);
				if(ch!=null){
					String id = request.getParameter("id");
					Map[] primaryRows = this.biomassRubbishProjectService.query(Integer.parseInt(id.toString()));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("installationNumberRow", m.get("装机数量"));
						request.setAttribute("constructionModeRow", m.get("建设方式"));
						request.setAttribute("boilerTypeRow", m.get("锅炉类型"));
						request.setAttribute("fuelTypeRow", m.get("燃料类型"));
						request.setAttribute("dustingMethodRow", m.get("除尘方式"));
						request.setAttribute("sulfurRemovalMethodRow", m.get("脱硫方式"));
						request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
						request.setAttribute("circulatingCoolingMethodRow", m.get("循环冷却方式"));
						request.setAttribute("waterSourceRow", m.get("水源"));
						request.setAttribute("coolingTowerPatternRow", m.get("冷却塔型式"));
						request.setAttribute("fireProtectionStandardRow", m.get("消防标准"));
						request.setAttribute("rawWaterPreprocessRow", m.get("原水预处理"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
						request.setAttribute("designBasicSeismicAccelerationRow", m.get("设计基本地震加速度"));
						request.setAttribute("foundationTypeRow", m.get("基础型式"));
						request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
						request.setAttribute("waterCirculationSystemOverviewRow", m.get("循环水系统概述"));
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
					request.getRequestDispatcher("biomass_rubbish_project_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("biomass_rubbish_project_query.jsp").forward(request, response);
				}
			}
			else if(op.equals("update")){
				request.setAttribute("op", "update");
				String id = request.getParameter("id");
				if(this.biomassRubbishProjectService.isSubmit(pid)){
					if(this.biomassRubbishProjectService.isSave(pid)){
						this.biomass_rubbish_project.setId(Integer.parseInt(id));
						this.biomass_rubbish_project.setPid(pid);
						this.biomass_rubbish_project.setName(name);
						this.biomass_rubbish_project.setType(type);
						this.biomass_rubbish_project.setNation(nation);
						this.biomass_rubbish_project.setArea(area);
						this.biomass_rubbish_project.setInstallation_number(installation_number);
						this.biomass_rubbish_project.setConstruction_mode(construction_mode);
						this.biomass_rubbish_project.setBoiler_type(boiler_type);
						this.biomass_rubbish_project.setFuel_type(fuel_type);
						this.biomass_rubbish_project.setDusting_method(dusting_method);
						this.biomass_rubbish_project.setSulfur_removal_method(sulfur_removal_method);
						this.biomass_rubbish_project.setAverage_temperature(average_temperature);
						this.biomass_rubbish_project.setExtreme_high_temperature(extreme_high_temperature);
						this.biomass_rubbish_project.setExtreme_low_temperature(extreme_low_temperature);
						this.biomass_rubbish_project.setAverage_relative_humid(average_relative_humid);
						this.biomass_rubbish_project.setCirculating_cooling_method(circulating_cooling_method);
						this.biomass_rubbish_project.setWater_source(water_source);
						this.biomass_rubbish_project.setCooling_tower_pattern(cooling_tower_pattern);
						this.biomass_rubbish_project.setFire_protection_standard(fire_protection_standard);
						this.biomass_rubbish_project.setRaw_water_preprocess(raw_water_preprocess);
						this.biomass_rubbish_project.setFactory_area(factory_area);
						this.biomass_rubbish_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
						this.biomass_rubbish_project.setFoundation_type(foundation_type);
						this.biomass_rubbish_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
						this.biomass_rubbish_project.setWater_circulation_system_overview(water_circulation_system_overview);
						this.biomass_rubbish_project.setPreparation_one(preparation_one);
						this.biomass_rubbish_project.setPreparation_two(preparation_two);
						this.biomass_rubbish_project.setPreparation_three(preparation_three);
						this.biomass_rubbish_project.setPreparation_four(preparation_four);
						this.biomass_rubbish_project.setPreparation_five(preparation_five);
						this.biomass_rubbish_project.setPreparation_six(preparation_six);
						this.biomass_rubbish_project.setPreparation_seven(preparation_seven);
						this.biomass_rubbish_project.setPreparation_eight(preparation_eight);
						this.biomass_rubbish_project.setPreparation_nine(preparation_nine);
						this.biomass_rubbish_project.setPreparation_ten(preparation_ten);
						this.biomass_rubbish_project.setEntry_time(this.date.format(new Date()));
						this.biomass_rubbish_project.setType_in_userNme(UserName);
						this.biomass_rubbish_project.setVerifier(verifier);
						this.biomass_rubbish_project.setVerify_state(1);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.biomassRubbishProjectService.update(biomass_rubbish_project)){
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
					request.setAttribute("pidRow",pid);
					request.setAttribute("nameRow",name);
					request.setAttribute("typeRow",type);
					request.setAttribute("nationRow",nation);
					request.setAttribute("areaRow",area);
					request.setAttribute("installationNumberRow",installation_number);
					request.setAttribute("constructionModeRow",construction_mode);
					request.setAttribute("boilerTypeRow",boiler_type);
					request.setAttribute("fuelTypeRow",fuel_type);
					request.setAttribute("dustingMethodRow",dusting_method);
					request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
					request.setAttribute("averageTemperatureRow",average_temperature);
					request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
					request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
					request.setAttribute("averageRelativeHumidRow",average_relative_humid);
					request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
					request.setAttribute("waterSourceRow",water_source);
					request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
					request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
					request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
					request.setAttribute("factoryAreaRow",factory_area);
					request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
					request.setAttribute("foundationTypeRow",foundation_type);
					request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
					request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
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
					request.setAttribute("verifier", verifier);
				}
				else{
					this.biomass_rubbish_project.setId(Integer.parseInt(id));
					this.biomass_rubbish_project.setPid(pid);
					this.biomass_rubbish_project.setName(name);
					this.biomass_rubbish_project.setType(type);
					this.biomass_rubbish_project.setNation(nation);
					this.biomass_rubbish_project.setArea(area);
					this.biomass_rubbish_project.setInstallation_number(installation_number);
					this.biomass_rubbish_project.setConstruction_mode(construction_mode);
					this.biomass_rubbish_project.setBoiler_type(boiler_type);
					this.biomass_rubbish_project.setFuel_type(fuel_type);
					this.biomass_rubbish_project.setDusting_method(dusting_method);
					this.biomass_rubbish_project.setSulfur_removal_method(sulfur_removal_method);
					this.biomass_rubbish_project.setAverage_temperature(average_temperature);
					this.biomass_rubbish_project.setExtreme_high_temperature(extreme_high_temperature);
					this.biomass_rubbish_project.setExtreme_low_temperature(extreme_low_temperature);
					this.biomass_rubbish_project.setAverage_relative_humid(average_relative_humid);
					this.biomass_rubbish_project.setCirculating_cooling_method(circulating_cooling_method);
					this.biomass_rubbish_project.setWater_source(water_source);
					this.biomass_rubbish_project.setCooling_tower_pattern(cooling_tower_pattern);
					this.biomass_rubbish_project.setFire_protection_standard(fire_protection_standard);
					this.biomass_rubbish_project.setRaw_water_preprocess(raw_water_preprocess);
					this.biomass_rubbish_project.setFactory_area(factory_area);
					this.biomass_rubbish_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
					this.biomass_rubbish_project.setFoundation_type(foundation_type);
					this.biomass_rubbish_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
					this.biomass_rubbish_project.setWater_circulation_system_overview(water_circulation_system_overview);
					this.biomass_rubbish_project.setPreparation_one(preparation_one);
					this.biomass_rubbish_project.setPreparation_two(preparation_two);
					this.biomass_rubbish_project.setPreparation_three(preparation_three);
					this.biomass_rubbish_project.setPreparation_four(preparation_four);
					this.biomass_rubbish_project.setPreparation_five(preparation_five);
					this.biomass_rubbish_project.setPreparation_six(preparation_six);
					this.biomass_rubbish_project.setPreparation_seven(preparation_seven);
					this.biomass_rubbish_project.setPreparation_eight(preparation_eight);
					this.biomass_rubbish_project.setPreparation_nine(preparation_nine);
					this.biomass_rubbish_project.setPreparation_ten(preparation_ten);
					this.biomass_rubbish_project.setEntry_time(this.date.format(new Date()));
					this.biomass_rubbish_project.setType_in_userNme(UserName);
					this.biomass_rubbish_project.setVerifier(verifier);
					this.biomass_rubbish_project.setVerify_state(1);
					//重设默认审核人
					this.userService.setDefaultVerifier(UserName, verifier);
					if(ch==null||ch==""){
						if(this.biomassRubbishProjectService.update(biomass_rubbish_project)){
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
						request.setAttribute("pidRow",pid);
						request.setAttribute("nameRow",name);
						request.setAttribute("typeRow",type);
						request.setAttribute("nationRow",nation);
						request.setAttribute("areaRow",area);
						request.setAttribute("installationNumberRow",installation_number);
						request.setAttribute("constructionModeRow",construction_mode);
						request.setAttribute("boilerTypeRow",boiler_type);
						request.setAttribute("fuelTypeRow",fuel_type);
						request.setAttribute("dustingMethodRow",dusting_method);
						request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
						request.setAttribute("averageTemperatureRow",average_temperature);
						request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
						request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
						request.setAttribute("averageRelativeHumidRow",average_relative_humid);
						request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
						request.setAttribute("waterSourceRow",water_source);
						request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
						request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
						request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
						request.setAttribute("factoryAreaRow",factory_area);
						request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
						request.setAttribute("foundationTypeRow",foundation_type);
						request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
						request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
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
							Map[] primaryRows = this.biomassRubbishProjectService.query(Integer.parseInt(id));
							for(Map m : primaryRows){
								request.setAttribute("idRow", m.get("编号"));
								request.setAttribute("pidRow", m.get("项目编号"));
								request.setAttribute("nameRow", m.get("项目名称"));
								request.setAttribute("typeRow", m.get("项目类别"));
								request.setAttribute("nationRow", m.get("项目所在国"));
								request.setAttribute("areaRow", m.get("项目所在地区"));
								request.setAttribute("installationNumberRow", m.get("装机数量"));
								request.setAttribute("constructionModeRow", m.get("建设方式"));
								request.setAttribute("boilerTypeRow", m.get("锅炉类型"));
								request.setAttribute("fuelTypeRow", m.get("燃料类型"));
								request.setAttribute("dustingMethodRow", m.get("除尘方式"));
								request.setAttribute("sulfurRemovalMethodRow", m.get("脱硫方式"));
								request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
								request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
								request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
								request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
								request.setAttribute("circulatingCoolingMethodRow", m.get("循环冷却方式"));
								request.setAttribute("waterSourceRow", m.get("水源"));
								request.setAttribute("coolingTowerPatternRow", m.get("冷却塔型式"));
								request.setAttribute("fireProtectionStandardRow", m.get("消防标准"));
								request.setAttribute("rawWaterPreprocessRow", m.get("原水预处理"));
								request.setAttribute("factoryAreaRow", m.get("厂区面积"));
								request.setAttribute("designBasicSeismicAccelerationRow", m.get("设计基本地震加速度"));
								request.setAttribute("foundationTypeRow", m.get("基础型式"));
								request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
								request.setAttribute("waterCirculationSystemOverviewRow", m.get("循环水系统概述"));
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
							request.setAttribute("ch", "unpass");
						}
						else{
							if(this.biomassRubbishProjectService.update(biomass_rubbish_project)){
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
							request.setAttribute("pidRow",pid);
							request.setAttribute("nameRow",name);
							request.setAttribute("typeRow",type);
							request.setAttribute("nationRow",nation);
							request.setAttribute("areaRow",area);
							request.setAttribute("installationNumberRow",installation_number);
							request.setAttribute("constructionModeRow",construction_mode);
							request.setAttribute("boilerTypeRow",boiler_type);
							request.setAttribute("fuelTypeRow",fuel_type);
							request.setAttribute("dustingMethodRow",dusting_method);
							request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
							request.setAttribute("averageTemperatureRow",average_temperature);
							request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
							request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
							request.setAttribute("averageRelativeHumidRow",average_relative_humid);
							request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
							request.setAttribute("waterSourceRow",water_source);
							request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
							request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
							request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
							request.setAttribute("factoryAreaRow",factory_area);
							request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
							request.setAttribute("foundationTypeRow",foundation_type);
							request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
							request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
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
				request.getRequestDispatcher("biomass_rubbish_project_insert.jsp").forward(request, response);
				
			}
			else if(op.equals("verify")){
				request.setAttribute("op", "verify");
				if(ch!=null){
					Map[] primaryRows = this.biomassRubbishProjectService.query(Integer.parseInt(ch));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("installationNumberRow", m.get("装机数量"));
						request.setAttribute("constructionModeRow", m.get("建设方式"));
						request.setAttribute("boilerTypeRow", m.get("锅炉类型"));
						request.setAttribute("fuelTypeRow", m.get("燃料类型"));
						request.setAttribute("dustingMethodRow", m.get("除尘方式"));
						request.setAttribute("sulfurRemovalMethodRow", m.get("脱硫方式"));
						request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
						request.setAttribute("circulatingCoolingMethodRow", m.get("循环冷却方式"));
						request.setAttribute("waterSourceRow", m.get("水源"));
						request.setAttribute("coolingTowerPatternRow", m.get("冷却塔型式"));
						request.setAttribute("fireProtectionStandardRow", m.get("消防标准"));
						request.setAttribute("rawWaterPreprocessRow", m.get("原水预处理"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
						request.setAttribute("designBasicSeismicAccelerationRow", m.get("设计基本地震加速度"));
						request.setAttribute("foundationTypeRow", m.get("基础型式"));
						request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
						request.setAttribute("waterCirculationSystemOverviewRow", m.get("循环水系统概述"));
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
					request.getRequestDispatcher("biomass_rubbish_project_insert.jsp").forward(request, response);
				}
				else{
					String id = request.getParameter("id");
					this.biomass_rubbish_project.setId(Integer.parseInt(id));
					this.biomass_rubbish_project.setPid(pid);
					this.biomass_rubbish_project.setName(name);
					this.biomass_rubbish_project.setType(type);
					this.biomass_rubbish_project.setNation(nation);
					this.biomass_rubbish_project.setArea(area);
					this.biomass_rubbish_project.setInstallation_number(installation_number);
					this.biomass_rubbish_project.setConstruction_mode(construction_mode);
					this.biomass_rubbish_project.setBoiler_type(boiler_type);
					this.biomass_rubbish_project.setFuel_type(fuel_type);
					this.biomass_rubbish_project.setDusting_method(dusting_method);
					this.biomass_rubbish_project.setSulfur_removal_method(sulfur_removal_method);
					this.biomass_rubbish_project.setAverage_temperature(average_temperature);
					this.biomass_rubbish_project.setExtreme_high_temperature(extreme_high_temperature);
					this.biomass_rubbish_project.setExtreme_low_temperature(extreme_low_temperature);
					this.biomass_rubbish_project.setAverage_relative_humid(average_relative_humid);
					this.biomass_rubbish_project.setCirculating_cooling_method(circulating_cooling_method);
					this.biomass_rubbish_project.setWater_source(water_source);
					this.biomass_rubbish_project.setCooling_tower_pattern(cooling_tower_pattern);
					this.biomass_rubbish_project.setFire_protection_standard(fire_protection_standard);
					this.biomass_rubbish_project.setRaw_water_preprocess(raw_water_preprocess);
					this.biomass_rubbish_project.setFactory_area(factory_area);
					this.biomass_rubbish_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
					this.biomass_rubbish_project.setFoundation_type(foundation_type);
					this.biomass_rubbish_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
					this.biomass_rubbish_project.setWater_circulation_system_overview(water_circulation_system_overview);
					this.biomass_rubbish_project.setPreparation_one(preparation_one);
					this.biomass_rubbish_project.setPreparation_two(preparation_two);
					this.biomass_rubbish_project.setPreparation_three(preparation_three);
					this.biomass_rubbish_project.setPreparation_four(preparation_four);
					this.biomass_rubbish_project.setPreparation_five(preparation_five);
					this.biomass_rubbish_project.setPreparation_six(preparation_six);
					this.biomass_rubbish_project.setPreparation_seven(preparation_seven);
					this.biomass_rubbish_project.setPreparation_eight(preparation_eight);
					this.biomass_rubbish_project.setPreparation_nine(preparation_nine);
					this.biomass_rubbish_project.setPreparation_ten(preparation_ten);
					this.biomass_rubbish_project.setVerify_time(this.date.format(new Date()));
					this.biomass_rubbish_project.setVerify_comment(verify_comment);
					if(se!=null){
						if(se.equals("1")){
							this.biomass_rubbish_project.setVerify_state(2);
						}
						else if(se.equals("-1")){
							this.biomass_rubbish_project.setVerify_state(-1);
						}
					}
					this.biomass_rubbish_project.setVerify_comment(verify_comment);
					//填充
					request.setAttribute("idRow", Integer.parseInt(id));
					request.setAttribute("pidRow",pid);
					request.setAttribute("nameRow",name);
					request.setAttribute("typeRow",type);
					request.setAttribute("nationRow",nation);
					request.setAttribute("areaRow",area);
					request.setAttribute("installationNumberRow",installation_number);
					request.setAttribute("constructionModeRow",construction_mode);
					request.setAttribute("boilerTypeRow",boiler_type);
					request.setAttribute("fuelTypeRow",fuel_type);
					request.setAttribute("dustingMethodRow",dusting_method);
					request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
					request.setAttribute("averageTemperatureRow",average_temperature);
					request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
					request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
					request.setAttribute("averageRelativeHumidRow",average_relative_humid);
					request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
					request.setAttribute("waterSourceRow",water_source);
					request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
					request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
					request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
					request.setAttribute("factoryAreaRow",factory_area);
					request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
					request.setAttribute("foundationTypeRow",foundation_type);
					request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
					request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
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
					if(this.biomassRubbishProjectService.verify(biomass_rubbish_project)){
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
					request.getRequestDispatcher("biomass_rubbish_project_insert.jsp").forward(request, response);
				}
			}
			else if(op.equals("save")){
				request.setAttribute("op","save");
				String id = request.getParameter("id");
				this.biomass_rubbish_project.setPid(pid);
				this.biomass_rubbish_project.setName(name);
				this.biomass_rubbish_project.setType(type);
				this.biomass_rubbish_project.setNation(nation);
				this.biomass_rubbish_project.setArea(area);
				this.biomass_rubbish_project.setInstallation_number(installation_number);
				this.biomass_rubbish_project.setConstruction_mode(construction_mode);
				this.biomass_rubbish_project.setBoiler_type(boiler_type);
				this.biomass_rubbish_project.setFuel_type(fuel_type);
				this.biomass_rubbish_project.setDusting_method(dusting_method);
				this.biomass_rubbish_project.setSulfur_removal_method(sulfur_removal_method);
				this.biomass_rubbish_project.setAverage_temperature(average_temperature);
				this.biomass_rubbish_project.setExtreme_high_temperature(extreme_high_temperature);
				this.biomass_rubbish_project.setExtreme_low_temperature(extreme_low_temperature);
				this.biomass_rubbish_project.setAverage_relative_humid(average_relative_humid);
				this.biomass_rubbish_project.setCirculating_cooling_method(circulating_cooling_method);
				this.biomass_rubbish_project.setWater_source(water_source);
				this.biomass_rubbish_project.setCooling_tower_pattern(cooling_tower_pattern);
				this.biomass_rubbish_project.setFire_protection_standard(fire_protection_standard);
				this.biomass_rubbish_project.setRaw_water_preprocess(raw_water_preprocess);
				this.biomass_rubbish_project.setFactory_area(factory_area);
				this.biomass_rubbish_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
				this.biomass_rubbish_project.setFoundation_type(foundation_type);
				this.biomass_rubbish_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
				this.biomass_rubbish_project.setWater_circulation_system_overview(water_circulation_system_overview);
				this.biomass_rubbish_project.setPreparation_one(preparation_one);
				this.biomass_rubbish_project.setPreparation_two(preparation_two);
				this.biomass_rubbish_project.setPreparation_three(preparation_three);
				this.biomass_rubbish_project.setPreparation_four(preparation_four);
				this.biomass_rubbish_project.setPreparation_five(preparation_five);
				this.biomass_rubbish_project.setPreparation_six(preparation_six);
				this.biomass_rubbish_project.setPreparation_seven(preparation_seven);
				this.biomass_rubbish_project.setPreparation_eight(preparation_eight);
				this.biomass_rubbish_project.setPreparation_nine(preparation_nine);
				this.biomass_rubbish_project.setPreparation_ten(preparation_ten);
				this.biomass_rubbish_project.setVerify_state(0);
				this.biomass_rubbish_project.setEntry_time(this.date.format(new Date()));
				this.biomass_rubbish_project.setVerifier(verifier);
				this.biomass_rubbish_project.setType_in_userNme(UserName);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				if(id==null||id==""){
					if(this.biomassRubbishProjectService.isSubmit(pid)){
						request.setAttribute("msg", "<script>alert('已存在相应相同编号记录，请修改项目编号后提交！')</script>");
					}
					else{
						this.biomassRubbishProjectService.add(biomass_rubbish_project);
						request.setAttribute("idRow", this.biomassRubbishProjectService.getId(pid, 0));
						request.setAttribute("msg", "<script>alert('保存成功！')</script>");
						//添加入系统日志
						this.log.setOperation("保存");
						this.logService.add(log);
					}
					request.setAttribute("pidRow",pid);
					request.setAttribute("nameRow",name);
					request.setAttribute("typeRow",type);
					request.setAttribute("nationRow",nation);
					request.setAttribute("areaRow",area);
					request.setAttribute("installationNumberRow",installation_number);
					request.setAttribute("constructionModeRow",construction_mode);
					request.setAttribute("boilerTypeRow",boiler_type);
					request.setAttribute("fuelTypeRow",fuel_type);
					request.setAttribute("dustingMethodRow",dusting_method);
					request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
					request.setAttribute("averageTemperatureRow",average_temperature);
					request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
					request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
					request.setAttribute("averageRelativeHumidRow",average_relative_humid);
					request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
					request.setAttribute("waterSourceRow",water_source);
					request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
					request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
					request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
					request.setAttribute("factoryAreaRow",factory_area);
					request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
					request.setAttribute("foundationTypeRow",foundation_type);
					request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
					request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
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
					request.setAttribute("verifier", verifier);
				}
				else {
					this.biomass_rubbish_project.setId(Integer.parseInt(id));
					//填充
					Map[] primaryRows = this.biomassRubbishProjectService.query(Integer.parseInt(id));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("installationNumberRow", m.get("装机数量"));
						request.setAttribute("constructionModeRow", m.get("建设方式"));
						request.setAttribute("boilerTypeRow", m.get("锅炉类型"));
						request.setAttribute("fuelTypeRow", m.get("燃料类型"));
						request.setAttribute("dustingMethodRow", m.get("除尘方式"));
						request.setAttribute("sulfurRemovalMethodRow", m.get("脱硫方式"));
						request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
						request.setAttribute("circulatingCoolingMethodRow", m.get("循环冷却方式"));
						request.setAttribute("waterSourceRow", m.get("水源"));
						request.setAttribute("coolingTowerPatternRow", m.get("冷却塔型式"));
						request.setAttribute("fireProtectionStandardRow", m.get("消防标准"));
						request.setAttribute("rawWaterPreprocessRow", m.get("原水预处理"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
						request.setAttribute("designBasicSeismicAccelerationRow", m.get("设计基本地震加速度"));
						request.setAttribute("foundationTypeRow", m.get("基础型式"));
						request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
						request.setAttribute("waterCirculationSystemOverviewRow", m.get("循环水系统概述"));
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
					if(this.biomassRubbishProjectService.update(biomass_rubbish_project)){
						//添加入系统日志
						this.log.setOperation("更新");
						this.logService.add(log);
						
						request.setAttribute("msg", "<script>alert('更新成功！')</script>");
					}
					else {
						request.setAttribute("msg", "<script>alert('更新失败！')</script>");
					}
				}
				request.getRequestDispatcher("biomass_rubbish_project_insert.jsp").forward(request, response);
			}
			else if(op.equals("maintenance")){
				request.setAttribute("op", "maintenance");
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
						this.biomass_rubbish_project.setId(Integer.parseInt(id));
						this.biomass_rubbish_project.setPid(pid);
						this.biomass_rubbish_project.setName(name);
						this.biomass_rubbish_project.setType(type);
						this.biomass_rubbish_project.setNation(nation);
						this.biomass_rubbish_project.setArea(area);
						this.biomass_rubbish_project.setInstallation_number(installation_number);
						this.biomass_rubbish_project.setConstruction_mode(construction_mode);
						this.biomass_rubbish_project.setBoiler_type(boiler_type);
						this.biomass_rubbish_project.setFuel_type(fuel_type);
						this.biomass_rubbish_project.setDusting_method(dusting_method);
						this.biomass_rubbish_project.setSulfur_removal_method(sulfur_removal_method);
						this.biomass_rubbish_project.setAverage_temperature(average_temperature);
						this.biomass_rubbish_project.setExtreme_high_temperature(extreme_high_temperature);
						this.biomass_rubbish_project.setExtreme_low_temperature(extreme_low_temperature);
						this.biomass_rubbish_project.setAverage_relative_humid(average_relative_humid);
						this.biomass_rubbish_project.setCirculating_cooling_method(circulating_cooling_method);
						this.biomass_rubbish_project.setWater_source(water_source);
						this.biomass_rubbish_project.setCooling_tower_pattern(cooling_tower_pattern);
						this.biomass_rubbish_project.setFire_protection_standard(fire_protection_standard);
						this.biomass_rubbish_project.setRaw_water_preprocess(raw_water_preprocess);
						this.biomass_rubbish_project.setFactory_area(factory_area);
						this.biomass_rubbish_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
						this.biomass_rubbish_project.setFoundation_type(foundation_type);
						this.biomass_rubbish_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
						this.biomass_rubbish_project.setWater_circulation_system_overview(water_circulation_system_overview);
						this.biomass_rubbish_project.setPreparation_one(preparation_one);
						this.biomass_rubbish_project.setPreparation_two(preparation_two);
						this.biomass_rubbish_project.setPreparation_three(preparation_three);
						this.biomass_rubbish_project.setPreparation_four(preparation_four);
						this.biomass_rubbish_project.setPreparation_five(preparation_five);
						this.biomass_rubbish_project.setPreparation_six(preparation_six);
						this.biomass_rubbish_project.setPreparation_seven(preparation_seven);
						this.biomass_rubbish_project.setPreparation_eight(preparation_eight);
						this.biomass_rubbish_project.setPreparation_nine(preparation_nine);
						this.biomass_rubbish_project.setPreparation_ten(preparation_ten);
						this.biomass_rubbish_project.setVerifier(verifier);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.biomassRubbishProjectService.maintenance(biomass_rubbish_project)){
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
				Map[] primaryRows = this.biomassRubbishProjectService.query(Integer.parseInt(id.toString()));
				for(Map m : primaryRows){
					request.setAttribute("idRow", m.get("编号"));
					request.setAttribute("pidRow", m.get("项目编号"));
					request.setAttribute("nameRow", m.get("项目名称"));
					request.setAttribute("typeRow", m.get("项目类别"));
					request.setAttribute("nationRow", m.get("项目所在国"));
					request.setAttribute("areaRow", m.get("项目所在地区"));
					request.setAttribute("installationNumberRow", m.get("装机数量"));
					request.setAttribute("constructionModeRow", m.get("建设方式"));
					request.setAttribute("boilerTypeRow", m.get("锅炉类型"));
					request.setAttribute("fuelTypeRow", m.get("燃料类型"));
					request.setAttribute("dustingMethodRow", m.get("除尘方式"));
					request.setAttribute("sulfurRemovalMethodRow", m.get("脱硫方式"));
					request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
					request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
					request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
					request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
					request.setAttribute("circulatingCoolingMethodRow", m.get("循环冷却方式"));
					request.setAttribute("waterSourceRow", m.get("水源"));
					request.setAttribute("coolingTowerPatternRow", m.get("冷却塔型式"));
					request.setAttribute("fireProtectionStandardRow", m.get("消防标准"));
					request.setAttribute("rawWaterPreprocessRow", m.get("原水预处理"));
					request.setAttribute("factoryAreaRow", m.get("厂区面积"));
					request.setAttribute("designBasicSeismicAccelerationRow", m.get("设计基本地震加速度"));
					request.setAttribute("foundationTypeRow", m.get("基础型式"));
					request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
					request.setAttribute("waterCirculationSystemOverviewRow", m.get("循环水系统概述"));
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
				
				request.getRequestDispatcher("biomass_rubbish_project_insert.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "<script>alert('非法访问，无相应参数！')</script>");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

}
