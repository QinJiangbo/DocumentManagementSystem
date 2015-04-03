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

import pojo.Config;
import pojo.Fuel_coal_project;
import pojo.Log;
import pojo.MyFile;
import service.FieldMaintenanceServiceImpl;
import service.FileService;
import service.FuelCoalProjectServiceImpl;
import service.IFieldMaintenanceService;
import service.IFuelCoalProjectService;
import service.ILogService;
import service.IUserService;
import service.LogServiceImpl;
import service.UserServiceImpl;

/**
 * Servlet implementation class FuelCoalProjectServlet
 */
@SuppressWarnings("rawtypes")
public class FuelCoalProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Fuel_coal_project fuel_coal_project = new Fuel_coal_project();
	private IFuelCoalProjectService fuelCoalProjectService = new FuelCoalProjectServiceImpl();
	private IFieldMaintenanceService fieldMaintenanceService = new FieldMaintenanceServiceImpl();
	private IUserService userService = new UserServiceImpl();
	private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
	FileService fileService=new FileService();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public FuelCoalProjectServlet() {
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
			String name = request.getParameter("name");
			String type = request.getParameter("type");
			String nation = request.getParameter("nation");
			String area = request.getParameter("area");
			String unit_capacity = request.getParameter("unit_capacity");
			String installation_number = request.getParameter("installation_number");
			String construction_mode = request.getParameter("construction_mode");
			String boiler_pattern = request.getParameter("boiler_pattern");
			String fuel_type = request.getParameter("fuel_type");
			String coal_type = request.getParameter("coal_type");
			String unit_level = request.getParameter("unit_level");
			String unit_pattern = request.getParameter("unit_pattern");
			String condensate_bump_configuration = request.getParameter("condensate_bump_configuration");
			String coal_mill_pattern = request.getParameter("coal_mill_pattern");
			String dusting_method = request.getParameter("dusting_method");
			String sulfur_removal_method = request.getParameter("sulfur_removal_method");
			String external_coal_method = request.getParameter("external_coal_method");
			String denitration_method = request.getParameter("denitration_method");
			String coal_yard_pattern = request.getParameter("coal_yard_pattern");
			String ash_removal_system = request.getParameter("ash_removal_system");
			String PC_stove_medium_speed_coal_child_system = request.getParameter("PC_stove_medium_speed_coal_child_system");
			String PC_stove_slag_removal_system = request.getParameter("PC_stove_slag_removal_system");
			String CFB_stove_slag_removal_system = request.getParameter("CFB_stove_slag_removal_system");
			String CFB_stove_bed_material = request.getParameter("CFB_stove_bed_material");
			String CFB_stove_limestone_break_system = request.getParameter("CFB_stove_limestone_break_system");
			String ash_external_export = request.getParameter("ash_external_export");
			String circulating_cooling_method = request.getParameter("circulating_cooling_method");
			String water_source = request.getParameter("water_source");
			String cooling_tower_pattern = request.getParameter("cooling_tower_pattern");
			String raw_water_preprocess = request.getParameter("raw_water_preprocess");
			String sea_water_desalination_process = request.getParameter("sea_water_desalination_process");
			String boiler_feedwater_process = request.getParameter("boiler_feedwater_process");
			String condensate_polishing = request.getParameter("condensate_polishing");
			String cooling_water_process = request.getParameter("cooling_water_process");
			String hydrogen_station = request.getParameter("hydrogen_station");
			String stack_inner_tank_pattern = request.getParameter("stack_inner_tank_pattern");
			String main_factory_foundation_pattern = request.getParameter("main_factory_foundation_pattern");
			String main_factory_structure_pattern = request.getParameter("main_factory_structure_pattern");
			String ammonia_for_denitration = request.getParameter("ammonia_for_denitration");
			String fire_protection_standard = request.getParameter("fire_protection_standard");
			String main_factory_layout = request.getParameter("main_factory_layout");
			String design_basic_seismic_acceleration = request.getParameter("design_basic_seismic_acceleration");
			String power_station_outlet_voltage_class = request.getParameter("power_station_outlet_voltage_class");
			String dynamo_loop_GCB_installation = request.getParameter("dynamo_loop_GCB_installation");
			String high_voltage_distribution_device_main_electrical_connection = request.getParameter("high_voltage_distribution_device_main_electrical_connection");
			String high_voltage_distribution_device_pattern = request.getParameter("high_voltage_distribution_device_pattern");
			String factory_area = request.getParameter("factory_area");
			String average_temperature = request.getParameter("average_temperature");
			String extreme_high_temperature = request.getParameter("extreme_high_temperature");
			String extreme_low_temperature = request.getParameter("extreme_low_temperature");
			String average_relative_humid = request.getParameter("average_relative_humid");
			String dust_emission_concentration = request.getParameter("dust_emission_concentration");
			String SO2_emission_concentration = request.getParameter("SO2_emission_concentration");
			String YOx_emission_concentration = request.getParameter("YOx_emission_concentration");
			String water_circulation_system_overview = request.getParameter("water_circulation_system_overview");
			String boiler_efficiency = request.getParameter("boiler_efficiency");
			String turbine_heat_consumption = request.getParameter("turbine_heat_consumption");
			String auxiliary_power_ratio = request.getParameter("auxiliary_power_ratio");
			String factory_net_efficiency = request.getParameter("factory_net_efficiency");
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
			Map[] typeRows = this.fuelCoalProjectService.getDefaultTypeRows();
			Map[] nationRows = this.fuelCoalProjectService.getDefaultNationRows();
			Map[] unitCapacityRows = this.fuelCoalProjectService.getDefaultUnitCapacityRows();
			Map[] constructionModeRows = this.fuelCoalProjectService.getDefaultConstructionModeRows();
			Map[] boilerTypeRows = this.fuelCoalProjectService.getDefaultBoilerTypeRows();
			Map[] fuelTypeRows = this.fuelCoalProjectService.getDefaultFuelTypeRows();
			Map[] coalTypeRows = this.fuelCoalProjectService.getDefaultCoalTypeRows();
			Map[] unitLevelRows = this.fuelCoalProjectService.getDefaultUnitLevelRows();
			Map[] unitPatternRows = this.fuelCoalProjectService.getDefaultUnitPatternRows();
			Map[] condensateBumpConfigurationRows = this.fuelCoalProjectService.getDefaultCondensateBumpConfigurationRows();
			Map[] coalMillPatternRows = this.fuelCoalProjectService.getDefaultCoalMillPatternRows();
			Map[] dustingMethodRows = this.fuelCoalProjectService.getDefaultDustingMethodRows();
			Map[] sulfurRemovalMethodRows = this.fuelCoalProjectService.getDefaultSulfurRemoalMethodRows();
			Map[] denitrationMethodRows = this.fuelCoalProjectService.getDefaultDenitrationMethodRows();
			Map[] externalCoalMethodRows = this.fuelCoalProjectService.getDefaultExternalCoalMethodRows();
			Map[] coalYardPatternRows = this.fuelCoalProjectService.getDefaultCoalYardPatternRows();
			Map[] ashRemovalSystemRows = this.fuelCoalProjectService.getDefaultAshRemovalSystemRows();
			Map[] pCStoveMediumSpeedCoalChildSystemRows = this.fuelCoalProjectService.getDefaultPCStoveMediumSpeedCoalChildSystemRows();
			Map[] pCStoveSlagRemovalSystemRows = this.fuelCoalProjectService.getDefaultPCStoveSlagRemovalSystemRows();
			Map[] cFBStoveSlagRemovalSystemRows = this.fuelCoalProjectService.getDefaultCFBStoveSlagRemovalSystemRows();
			Map[] cFBStoveBedMaterialRows=this.fuelCoalProjectService.getDefaultCFBStoveBedMaterialRows();
			Map[] cFBStoveLimestoneBreakSystemRows=this.fuelCoalProjectService.getDefaultCFBStoveLimestoneBreakSystemRows();
			Map[] ashExternalExportRows = this.fuelCoalProjectService.getDefaultAshExternalExportRows();
			Map[] circulatingCoolingMethodRows = this.fuelCoalProjectService.getDefaultCirculatingCoolingMethodRows();
			Map[] waterSourceRows = this.fuelCoalProjectService.getDefaultWaterSourceRows();
			Map[] coolingTowerPatternRows = this.fuelCoalProjectService.getDefaultCoolingTowerPatternRows();
			Map[] rawWaterPreprocessRows = this.fuelCoalProjectService.getDefaultRawWaterPreprocessRows();
			Map[] seaWaterDesalinationProcessRows = this.fuelCoalProjectService.getDefaultSeaWaterDesalinationProcessRows();
			Map[] boilerFeedwaterProcessRows = this.fuelCoalProjectService.getDefaultBoilerFeedwaterProcessRows();
			Map[] condensatePolishingRows = this.fuelCoalProjectService.getDefaultCondensatePolishingRows();
			Map[] coolingWaterProcessRows = this.fuelCoalProjectService.getDefaultCoolingWaterProcessRows();
			Map[] hydrogenStationRows = this.fuelCoalProjectService.getDefaultHydrogenStationRows();
			Map[] stackInnerTankPatternRows = this.fuelCoalProjectService.getDefaultStackInnerTankPatternRows();
			Map[] mainFactoryFoundationPatternRows = this.fuelCoalProjectService.getDefaultMainFactoryFoundationPatternRows();
			Map[] mainFactoryStructurePatternRows = this.fuelCoalProjectService.getDefaultMainFactoryStructurePatternRows();
			Map[] ammoniaForDenitrationRows = this.fuelCoalProjectService.getDefaultAmmoniaForDenitrationRows();
			Map[] fireProtectionStandardRows = this.fuelCoalProjectService.getDefaultFireProtectionStandardRows();
			Map[] mainFactoryLayoutRows = this.fuelCoalProjectService.getDefaultMainFactoryLayoutRows();
			Map[] designBasicSeismicAccelerationRows = this.fuelCoalProjectService.getDefaultDesignBasicSeismicAccelerationRows();
			Map[] powerStationOutletVoltageClassRows = this.fuelCoalProjectService.getDefaultPowerStationOutletVoltageClassRows();
			Map[] dynamoLoopGCBInstallationRows = this.fuelCoalProjectService.getDefaultDynamoLoopGCBInstallationRows();
			Map[] highVoltageDistributionDeviceMainElectricalConnectionRows = this.fuelCoalProjectService.getDefaultHighVoltageDistributionDeviceMainElectricalConnectionRows();
			Map[] highVoltageDistributionDevicePatternRows = this.fuelCoalProjectService.getDefaultHighVoltageDistributionDevicePatternRows();
			Map[] verifierRows = this.userService.getDefaultVerifierRows();
			Map[] preparationOneRows = this.fuelCoalProjectService.getDefaultPreparationOneRows();
			Map[] preparationTwoRows = this.fuelCoalProjectService.getDefaultPreparationTwoRows();
			Map[] preparationThreeRows = this.fuelCoalProjectService.getDefaultPreparationThreeRows();
			Map[] preparationFourRows = this.fuelCoalProjectService.getDefaultPreparationFourRows();
			Map[] preparationFiveRows = this.fuelCoalProjectService.getDefaultPreparationFiveRows();
			Map[] preparationSixRows= this.fuelCoalProjectService.getDefaultPreparationSixRows();
			Map[] preparationSevenRows = this.fuelCoalProjectService.getDefaultPreparationSevenRows();
			Map[] preparationEightRows = this.fuelCoalProjectService.getDefaultPreparationEightRows();
			Map[] preparationNineRows= this.fuelCoalProjectService.getDefaultPreparationNineRows();
			Map[] preparationTenRows = this.fuelCoalProjectService.getDefaultPreparationTenRows();
			request.setAttribute("typeRows",typeRows);
			request.setAttribute("nationRows",nationRows);
			request.setAttribute("unitCapacityRows",unitCapacityRows);
			request.setAttribute("constructionModeRows",constructionModeRows);
			request.setAttribute("boilerTypeRows",boilerTypeRows);
			request.setAttribute("fuelTypeRows",fuelTypeRows);
			request.setAttribute("coalTypeRows",coalTypeRows);
			request.setAttribute("unitLevelRows",unitLevelRows);
			request.setAttribute("unitPatternRows",unitPatternRows);
			request.setAttribute("condensateBumpConfigurationRows",condensateBumpConfigurationRows);
			request.setAttribute("coalMillPatternRows",coalMillPatternRows);
			request.setAttribute("dustingMethodRows",dustingMethodRows);
			request.setAttribute("sulfurRemovalMethodRows",sulfurRemovalMethodRows);
			request.setAttribute("denitrationMethodRows",denitrationMethodRows);
			request.setAttribute("externalCoalMethodRows",externalCoalMethodRows);
			request.setAttribute("coalYardPatternRows",coalYardPatternRows);
			request.setAttribute("ashRemovalSystemRows",ashRemovalSystemRows);
			request.setAttribute("pCStoveMediumSpeedCoalChildSystemRows",pCStoveMediumSpeedCoalChildSystemRows);
			request.setAttribute("pCStoveSlagRemovalSystemRows",pCStoveSlagRemovalSystemRows);
			request.setAttribute("cFBStoveSlagRemovalSystemRows",cFBStoveSlagRemovalSystemRows);
			request.setAttribute("cFBStoveBedMaterialRows", cFBStoveBedMaterialRows);
			request.setAttribute("cFBStoveLimestoneBreakSystemRows", cFBStoveLimestoneBreakSystemRows);
			request.setAttribute("ashExternalExportRows",ashExternalExportRows);
			request.setAttribute("circulatingCoolingMethodRows",circulatingCoolingMethodRows);
			request.setAttribute("waterSourceRows",waterSourceRows);
			request.setAttribute("coolingTowerPatternRows",coolingTowerPatternRows);
			request.setAttribute("rawWaterPreprocessRows",rawWaterPreprocessRows);
			request.setAttribute("seaWaterDesalinationProcessRows",seaWaterDesalinationProcessRows);
			request.setAttribute("boilerFeedwaterProcessRows",boilerFeedwaterProcessRows);
			request.setAttribute("condensatePolishingRows",condensatePolishingRows);
			request.setAttribute("coolingWaterProcessRows",coolingWaterProcessRows);
			request.setAttribute("hydrogenStationRows",hydrogenStationRows);
			request.setAttribute("stackInnerTankPatternRows",stackInnerTankPatternRows);
			request.setAttribute("mainFactoryFoundationPatternRows",mainFactoryFoundationPatternRows);
			request.setAttribute("mainFactoryStructurePatternRows",mainFactoryStructurePatternRows);
			request.setAttribute("ammoniaForDenitrationRows",ammoniaForDenitrationRows);
			request.setAttribute("fireProtectionStandardRows",fireProtectionStandardRows);
			request.setAttribute("mainFactoryLayoutRows",mainFactoryLayoutRows);
			request.setAttribute("designBasicSeismicAccelerationRows",designBasicSeismicAccelerationRows);
			request.setAttribute("powerStationOutletVoltageClassRows",powerStationOutletVoltageClassRows);
			request.setAttribute("dynamoLoopGCBInstallationRows",dynamoLoopGCBInstallationRows);
			request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRows",highVoltageDistributionDeviceMainElectricalConnectionRows);
			request.setAttribute("highVoltageDistributionDevicePatternRows",highVoltageDistributionDevicePatternRows);
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
			request.setAttribute("pageName", "fuel_coal_project");//pageName for page dispatcher
			//add log
			this.log.setUname(UserName);
			this.log.setTable("燃煤项目");
			this.log.setTime(this.date.format(new Date()));
			//设置初始审核人
			request.setAttribute("verifierRow", this.userService.getDefaultVerifier(UserName));
			//预留字段是否启用
			int isPreparationOneUsed = this.fieldMaintenanceService.isUse("燃煤项目","预留一");
			int isPreparationTwoUsed = this.fieldMaintenanceService.isUse("燃煤项目","预留二");
			int isPreparationThreeUsed = this.fieldMaintenanceService.isUse("燃煤项目","预留三");
			int isPreparationFourUsed = this.fieldMaintenanceService.isUse("燃煤项目","预留四");
			int isPreparationFiveUsed = this.fieldMaintenanceService.isUse("燃煤项目","预留五");
			int isPreparationSixUsed = this.fieldMaintenanceService.isUse("燃煤项目","预留六");
			int isPreparationSevenUsed = this.fieldMaintenanceService.isUse("燃煤项目","预留七");
			int isPreparationEightUsed = this.fieldMaintenanceService.isUse("燃煤项目","预留八");
			int isPreparationNineUsed = this.fieldMaintenanceService.isUse("燃煤项目","预留九");
			int isPreparationTenUsed = this.fieldMaintenanceService.isUse("燃煤项目","预留十");
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
			String preparationOneNewName = this.fieldMaintenanceService.getNewName("燃煤项目","预留一");
			String preparationTwoNewName = this.fieldMaintenanceService.getNewName("燃煤项目","预留二");
			String preparationThreeNewName = this.fieldMaintenanceService.getNewName("燃煤项目","预留三");
			String preparationFourNewName = this.fieldMaintenanceService.getNewName("燃煤项目","预留四");
			String preparationFiveNewName = this.fieldMaintenanceService.getNewName("燃煤项目","预留五");
			String preparationSixNewName = this.fieldMaintenanceService.getNewName("燃煤项目","预留六");
			String preparationSevenNewName = this.fieldMaintenanceService.getNewName("燃煤项目","预留七");
			String preparationEightNewName = this.fieldMaintenanceService.getNewName("燃煤项目","预留八");
			String preparationNineNewName = this.fieldMaintenanceService.getNewName("燃煤项目","预留九");
			String preparationTenNewName = this.fieldMaintenanceService.getNewName("燃煤项目","预留十");
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
				if(this.fuelCoalProjectService.hasSave(UserName)){
					Map[] primaryRows = this.fuelCoalProjectService.primaryQuery(UserName);
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("unitCapacityRow",m.get("机组容量"));
						request.setAttribute("installationNumberRow",m.get("装机数量"));
						request.setAttribute("constructionModeRow",m.get("建设方式"));
						request.setAttribute("boilerPatternRow",m.get("锅炉型式"));
						request.setAttribute("fuelTypeRow",m.get("燃料类型"));
						request.setAttribute("coalTypeRow",m.get("煤质类别"));
						request.setAttribute("unitLevelRow",m.get("机组等级"));
						request.setAttribute("unitPatternRow",m.get("机组型式"));
						request.setAttribute("condensateBumpConfigurationRow",m.get("凝结水泵配置"));
						request.setAttribute("coalMillPatternRow",m.get("磨煤机型式"));
						request.setAttribute("dustingMethodRow",m.get("除尘方式"));
						request.setAttribute("sulfurRemovalMethodRow",m.get("脱硫方式"));
						request.setAttribute("externalCoalMethodRow",m.get("脱硝方式"));
						request.setAttribute("denitrationMethodRow",m.get("厂外来煤方式"));
						request.setAttribute("coalYardPatternRow",m.get("煤场型式"));
						request.setAttribute("ashRemovalSystemRow",m.get("除灰系统"));
						request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",m.get("PC炉中速磨石子煤系统"));
						request.setAttribute("PCStoveSlagRemovalSystemRow",m.get("PC炉除渣系统"));
						request.setAttribute("CFBStoveSlagRemovalSystemRow",m.get("CFB炉除渣系统"));
						request.setAttribute("CFBStoveBedMaterialRow",m.get("CFB炉床料系统"));
						request.setAttribute("CFBStoveLimestoneBreakSystemRow",m.get("CFB炉石灰石细碎系统"));
						request.setAttribute("ashExternalExportRow",m.get("灰渣厂外输送"));
						request.setAttribute("circulatingCoolingMethodRow",m.get("循环冷却方式"));
						request.setAttribute("waterSourceRow",m.get("水源"));
						request.setAttribute("coolingTowerPatternRow",m.get("冷却塔型式"));
						request.setAttribute("rawWaterPreprocessRow",m.get("原水预处理"));
						request.setAttribute("seaWaterDesalinationProcessRow",m.get("海水淡化处理"));
						request.setAttribute("boilerFeedwaterProcessRow",m.get("锅炉补给水处理"));
						request.setAttribute("condensatePolishingRow",m.get("凝结水精处理"));
						request.setAttribute("coolingWaterProcessRow",m.get("冷却水处理"));
						request.setAttribute("hydrogenStationRow",m.get("氢气站"));
						request.setAttribute("stackInnerTankPatternRow",m.get("烟囱内筒型式"));
						request.setAttribute("mainFactoryFoundationPatternRow",m.get("主厂区基础型式"));
						request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
						request.setAttribute("ammoniaForDenitrationRow",m.get("脱硝用氨"));
						request.setAttribute("fireProtectionStandardRow",m.get("消防标准"));
						request.setAttribute("mainFactoryLayoutRow",m.get("主厂房布置"));
						request.setAttribute("designBasicSeismicAccelerationRow",m.get("设计基本地震加速度"));
						request.setAttribute("powerStationOutletVoltageClassRow",m.get("发电厂出线电压等级"));
						request.setAttribute("dynamoLoopGCBInstallationRow",m.get("发电机回路GCB配置"));
						request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",m.get("高压配电装置电气主接线"));
						request.setAttribute("highVoltageDistributionDevicePatternRow",m.get("高压配电装置型式"));
						request.setAttribute("factoryAreaRow",m.get("厂区面积"));
						request.setAttribute("averageTemperatureRow",m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow",m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow",m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow",m.get("平均相对湿度"));
						request.setAttribute("dustEmissionConcentrationRow",m.get("粉尘排放浓度"));
						request.setAttribute("SO2EmissionConcentrationRow",m.get("SO2排放浓度"));
						request.setAttribute("YOxEmissionConcentrationRow",m.get("YOx排放浓度"));
						request.setAttribute("waterCirculationSystemOverviewRow",m.get("循环水系统概述"));
						request.setAttribute("boilerEfficiencyRow",m.get("锅炉效率"));
						request.setAttribute("turbineHeatConsumptionRow",m.get("汽机热耗"));
						request.setAttribute("auxiliaryPowerRatioRow",m.get("厂用电率"));
						request.setAttribute("factoryNetEfficiencyRow",m.get("全厂净效率"));
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
					request.getRequestDispatcher("fuel_coal_project_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("fuel_coal_project_insert.jsp").forward(request, response);
				}
				
			}
			else if(op.equals("add")){
				request.setAttribute("op","insert");
				this.fuel_coal_project.setPid(pid);
				this.fuel_coal_project.setName(name);
				this.fuel_coal_project.setType(type);
				this.fuel_coal_project.setNation(nation);
				this.fuel_coal_project.setArea(area);
				this.fuel_coal_project.setUnit_capacity(unit_capacity);
				this.fuel_coal_project.setInstallation_number(installation_number);
				this.fuel_coal_project.setConstruction_mode(construction_mode);
				this.fuel_coal_project.setBoiler_pattern(boiler_pattern);
				this.fuel_coal_project.setFuel_type(fuel_type);
				this.fuel_coal_project.setCoal_type(coal_type);
				this.fuel_coal_project.setUnit_level(unit_level);
				this.fuel_coal_project.setUnit_pattern(unit_pattern);
				this.fuel_coal_project.setCondensate_bump_configuration(condensate_bump_configuration);
				this.fuel_coal_project.setCoal_mill_pattern(coal_mill_pattern);
				this.fuel_coal_project.setDusting_method(dusting_method);
				this.fuel_coal_project.setSulfur_removal_method(sulfur_removal_method);
				this.fuel_coal_project.setDenitration_method(denitration_method);
				this.fuel_coal_project.setExternal_coal_method(external_coal_method);
				this.fuel_coal_project.setCoal_yard_pattern(coal_yard_pattern);
				this.fuel_coal_project.setAsh_removal_system(ash_removal_system);
				this.fuel_coal_project.setPC_stove_medium_speed_coal_child_system(PC_stove_medium_speed_coal_child_system);
				this.fuel_coal_project.setPC_stove_slag_removal_system(PC_stove_slag_removal_system);
				this.fuel_coal_project.setCFB_stove_slag_removal_system(CFB_stove_slag_removal_system);
				this.fuel_coal_project.setCFB_stove_bed_material(CFB_stove_bed_material);
				this.fuel_coal_project.setCFB_stove_limestone_break_system(CFB_stove_limestone_break_system);
				this.fuel_coal_project.setAsh_external_export(ash_external_export);
				this.fuel_coal_project.setCirculating_cooling_method(circulating_cooling_method);
				this.fuel_coal_project.setWater_source(water_source);
				this.fuel_coal_project.setCooling_tower_pattern(cooling_tower_pattern);
				this.fuel_coal_project.setRaw_water_preprocess(raw_water_preprocess);
				this.fuel_coal_project.setSea_water_desalination_process(sea_water_desalination_process);
				this.fuel_coal_project.setBoiler_feedwater_process(boiler_feedwater_process);
				this.fuel_coal_project.setCondensate_polishing(condensate_polishing);
				this.fuel_coal_project.setCooling_water_process(cooling_water_process);
				this.fuel_coal_project.setHydrogen_station(hydrogen_station);
				this.fuel_coal_project.setStack_inner_tank_pattern(stack_inner_tank_pattern);
				this.fuel_coal_project.setMain_factory_foundation_pattern(main_factory_foundation_pattern);
				this.fuel_coal_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
				this.fuel_coal_project.setAmmonia_for_denitration(ammonia_for_denitration);
				this.fuel_coal_project.setFire_protection_standard(fire_protection_standard);
				this.fuel_coal_project.setMain_factory_layout(main_factory_layout);
				this.fuel_coal_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
				this.fuel_coal_project.setPower_station_outlet_voltage_class(power_station_outlet_voltage_class);
				this.fuel_coal_project.setDynamo_loop_GCB_installation(dynamo_loop_GCB_installation);
				this.fuel_coal_project.setHigh_voltage_distribution_device_main_electrical_connection(high_voltage_distribution_device_main_electrical_connection);
				this.fuel_coal_project.setHigh_voltage_distribution_device_pattern(high_voltage_distribution_device_pattern);
				this.fuel_coal_project.setFactory_area(factory_area);
				this.fuel_coal_project.setAverage_temperature(average_temperature);
				this.fuel_coal_project.setExtreme_high_temperature(extreme_high_temperature);
				this.fuel_coal_project.setExtreme_low_temperature(extreme_low_temperature);
				this.fuel_coal_project.setAverage_relative_humid(average_relative_humid);
				this.fuel_coal_project.setDust_emission_concentration(dust_emission_concentration);
				this.fuel_coal_project.setSO2_emission_concentration(SO2_emission_concentration);
				this.fuel_coal_project.setYOx_emission_concentration(YOx_emission_concentration);
				this.fuel_coal_project.setWater_circulation_system_overview(water_circulation_system_overview);
				this.fuel_coal_project.setBoiler_efficiency(boiler_efficiency);
				this.fuel_coal_project.setTurbine_heat_consumption(turbine_heat_consumption);
				this.fuel_coal_project.setAuxiliary_power_ratio(auxiliary_power_ratio);
				this.fuel_coal_project.setFactory_net_efficiency(factory_net_efficiency);
				this.fuel_coal_project.setPreparation_one(preparation_one);
				this.fuel_coal_project.setPreparation_two(preparation_two);
				this.fuel_coal_project.setPreparation_three(preparation_three);
				this.fuel_coal_project.setPreparation_four(preparation_four);
				this.fuel_coal_project.setPreparation_five(preparation_five);
				this.fuel_coal_project.setPreparation_six(preparation_six);
				this.fuel_coal_project.setPreparation_seven(preparation_seven);
				this.fuel_coal_project.setPreparation_eight(preparation_eight);
				this.fuel_coal_project.setPreparation_nine(preparation_nine);
				this.fuel_coal_project.setPreparation_ten(preparation_ten);
				this.fuel_coal_project.setEntry_time(this.date.format(new Date()));
				this.fuel_coal_project.setType_in_userNme(UserName);
				this.fuel_coal_project.setVerifier(verifier);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				request.setAttribute("pidRow",pid);
				request.setAttribute("nameRow",name);
				request.setAttribute("typeRow",type);
				request.setAttribute("nationRow",nation);
				request.setAttribute("areaRow",area);
				request.setAttribute("unitCapacityRow",unit_capacity);
				request.setAttribute("installationNumberRow",installation_number);
				request.setAttribute("constructionModeRow",construction_mode);
				request.setAttribute("boilerPatternRow",boiler_pattern);
				request.setAttribute("fuelTypeRow",fuel_type);
				request.setAttribute("coalTypeRow",coal_type);
				request.setAttribute("unitLevelRow",unit_level);
				request.setAttribute("unitPatternRow",unit_pattern);
				request.setAttribute("condensateBumpConfigurationRow",condensate_bump_configuration);
				request.setAttribute("coalMillPatternRow",coal_mill_pattern);
				request.setAttribute("dustingMethodRow",dusting_method);
				request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
				request.setAttribute("externalCoalMethodRow",external_coal_method);
				request.setAttribute("denitrationMethodRow",denitration_method);
				request.setAttribute("coalYardPatternRow",coal_yard_pattern);
				request.setAttribute("ashRemovalSystemRow",ash_removal_system);
				request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",PC_stove_medium_speed_coal_child_system);
				request.setAttribute("PCStoveSlagRemovalSystemRow",PC_stove_slag_removal_system);
				request.setAttribute("CFBStoveSlagRemovalSystemRow",CFB_stove_slag_removal_system);
				request.setAttribute("CFBStoveBedMaterialRow",CFB_stove_bed_material);
				request.setAttribute("CFBStoveLimestoneBreakSystemRow",CFB_stove_limestone_break_system);
				request.setAttribute("ashExternalExportRow",ash_external_export);
				request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
				request.setAttribute("waterSourceRow",water_source);
				request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
				request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
				request.setAttribute("seaWaterDesalinationProcessRow",sea_water_desalination_process);
				request.setAttribute("boilerFeedwaterProcessRow",boiler_feedwater_process);
				request.setAttribute("condensatePolishingRow",condensate_polishing);
				request.setAttribute("coolingWaterProcessRow",cooling_water_process);
				request.setAttribute("hydrogenStationRow",hydrogen_station);
				request.setAttribute("stackInnerTankPatternRow",stack_inner_tank_pattern);
				request.setAttribute("mainFactoryFoundationPatternRow",main_factory_foundation_pattern);
				request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
				request.setAttribute("ammoniaForDenitrationRow",ammonia_for_denitration);
				request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
				request.setAttribute("mainFactoryLayoutRow",main_factory_layout);
				request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
				request.setAttribute("powerStationOutletVoltageClassRow",power_station_outlet_voltage_class);
				request.setAttribute("dynamoLoopGCBInstallationRow",dynamo_loop_GCB_installation);
				request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",high_voltage_distribution_device_main_electrical_connection);
				request.setAttribute("highVoltageDistributionDevicePatternRow",high_voltage_distribution_device_pattern);
				request.setAttribute("factoryAreaRow",factory_area);
				request.setAttribute("averageTemperatureRow",average_temperature);
				request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
				request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
				request.setAttribute("averageRelativeHumidRow",average_relative_humid);
				request.setAttribute("dustEmissionConcentrationRow",dust_emission_concentration);
				request.setAttribute("SO2EmissionConcentrationRow",SO2_emission_concentration);
				request.setAttribute("YOxEmissionConcentrationRow",YOx_emission_concentration);
				request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
				request.setAttribute("boilerEfficiencyRow",boiler_efficiency);
				request.setAttribute("turbineHeatConsumptionRow",turbine_heat_consumption);
				request.setAttribute("auxiliaryPowerRatioRow",auxiliary_power_ratio);
				request.setAttribute("factoryNetEfficiencyRow",factory_net_efficiency);
				request.setAttribute("preparationOneRow",preparation_one);
				request.setAttribute("preparationTwoRow",preparation_two);
				request.setAttribute("preparationThreeRow",preparation_three);
				request.setAttribute("preparationFourRow",preparation_four);
				request.setAttribute("preparationFiveRow",preparation_five);
				request.setAttribute("preparationSixRow",preparation_six);
				request.setAttribute("preparationSevenRow",preparation_seven);
				request.setAttribute("preparationEightRow",preparation_eight);
				request.setAttribute("preparationNineRow",preparation_nine);
				request.setAttribute("preparationTenRow",preparation_ten);
				request.setAttribute("verifierRow",verifier);
				if(this.fuelCoalProjectService.isSubmit(pid)){
					if(this.fuelCoalProjectService.isSave(pid)){
						request.setAttribute("msg", "<script>alert('已存在相同编号保存记录,无法继续保存第二条具有相同编号的记录,请核实并修改项目编号！')</script>");
					}
					else{
						if(this.fuelCoalProjectService.hasSave(UserName)){
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，并且您已有一条保存记录了,无法继续保存第二条的记录,请核实并修改项目编号！')</script>");
						}
						else {
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，请核实项目编号后提交！')</script>");
						}
					}
				}
				else{
					this.fuel_coal_project.setVerify_state(1);
					if(this.fuelCoalProjectService.add(fuel_coal_project)){
						//添加入系统日志
						this.log.setOperation("录入");
						this.logService.add(log);
						Map[] primaryRows = this.fuelCoalProjectService.query(this.fuelCoalProjectService.getId(pid, 1));
						for(Map m : primaryRows){
							request.setAttribute("idRow", m.get("编号"));
							request.setAttribute("pidRow", m.get("项目编号"));
							request.setAttribute("nameRow", m.get("项目名称"));
							request.setAttribute("typeRow", m.get("项目类别"));
							request.setAttribute("nationRow", m.get("项目所在国"));
							request.setAttribute("areaRow", m.get("项目所在地区"));
							request.setAttribute("unitCapacityRow",m.get("机组容量"));
							request.setAttribute("installationNumberRow",m.get("装机数量"));
							request.setAttribute("constructionModeRow",m.get("建设方式"));
							request.setAttribute("boilerPatternRow",m.get("锅炉型式"));
							request.setAttribute("fuelTypeRow",m.get("燃料类型"));
							request.setAttribute("coalTypeRow",m.get("煤质类别"));
							request.setAttribute("unitLevelRow",m.get("机组等级"));
							request.setAttribute("unitPatternRow",m.get("机组型式"));
							request.setAttribute("condensateBumpConfigurationRow",m.get("凝结水泵配置"));
							request.setAttribute("coalMillPatternRow",m.get("磨煤机型式"));
							request.setAttribute("dustingMethodRow",m.get("除尘方式"));
							request.setAttribute("sulfurRemovalMethodRow",m.get("脱硫方式"));
							request.setAttribute("externalCoalMethodRow",m.get("脱硝方式"));
							request.setAttribute("denitrationMethodRow",m.get("厂外来煤方式"));
							request.setAttribute("coalYardPatternRow",m.get("煤场型式"));
							request.setAttribute("ashRemovalSystemRow",m.get("除灰系统"));
							request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",m.get("PC炉中速磨石子煤系统"));
							request.setAttribute("PCStoveSlagRemovalSystemRow",m.get("PC炉除渣系统"));
							request.setAttribute("CFBStoveSlagRemovalSystemRow",m.get("CFB炉除渣系统"));
							request.setAttribute("CFBStoveBedMaterialRow",m.get("CFB炉床料系统"));
							request.setAttribute("CFBStoveLimestoneBreakSystemRow",m.get("CFB炉石灰石细碎系统"));
							request.setAttribute("ashExternalExportRow",m.get("灰渣厂外输送"));
							request.setAttribute("circulatingCoolingMethodRow",m.get("循环冷却方式"));
							request.setAttribute("waterSourceRow",m.get("水源"));
							request.setAttribute("coolingTowerPatternRow",m.get("冷却塔型式"));
							request.setAttribute("rawWaterPreprocessRow",m.get("原水预处理"));
							request.setAttribute("seaWaterDesalinationProcessRow",m.get("海水淡化处理"));
							request.setAttribute("boilerFeedwaterProcessRow",m.get("锅炉补给水处理"));
							request.setAttribute("condensatePolishingRow",m.get("凝结水精处理"));
							request.setAttribute("coolingWaterProcessRow",m.get("冷却水处理"));
							request.setAttribute("hydrogenStationRow",m.get("氢气站"));
							request.setAttribute("stackInnerTankPatternRow",m.get("烟囱内筒型式"));
							request.setAttribute("mainFactoryFoundationPatternRow",m.get("主厂区基础型式"));
							request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
							request.setAttribute("ammoniaForDenitrationRow",m.get("脱硝用氨"));
							request.setAttribute("fireProtectionStandardRow",m.get("消防标准"));
							request.setAttribute("mainFactoryLayoutRow",m.get("主厂房布置"));
							request.setAttribute("designBasicSeismicAccelerationRow",m.get("设计基本地震加速度"));
							request.setAttribute("powerStationOutletVoltageClassRow",m.get("发电厂出线电压等级"));
							request.setAttribute("dynamoLoopGCBInstallationRow",m.get("发电机回路GCB配置"));
							request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",m.get("高压配电装置电气主接线"));
							request.setAttribute("highVoltageDistributionDevicePatternRow",m.get("高压配电装置型式"));
							request.setAttribute("factoryAreaRow",m.get("厂区面积"));
							request.setAttribute("averageTemperatureRow",m.get("年平均气温"));
							request.setAttribute("extremeHighTemperatureRow",m.get("极端最高气温"));
							request.setAttribute("extremeLowTemperatureRow",m.get("极端最低气温"));
							request.setAttribute("averageRelativeHumidRow",m.get("平均相对湿度"));
							request.setAttribute("dustEmissionConcentrationRow",m.get("粉尘排放浓度"));
							request.setAttribute("SO2EmissionConcentrationRow",m.get("SO2排放浓度"));
							request.setAttribute("YOxEmissionConcentrationRow",m.get("YOx排放浓度"));
							request.setAttribute("waterCirculationSystemOverviewRow",m.get("循环水系统概述"));
							request.setAttribute("boilerEfficiencyRow",m.get("锅炉效率"));
							request.setAttribute("turbineHeatConsumptionRow",m.get("汽机热耗"));
							request.setAttribute("auxiliaryPowerRatioRow",m.get("厂用电率"));
							request.setAttribute("factoryNetEfficiencyRow",m.get("全厂净效率"));
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
				request.getRequestDispatcher("fuel_coal_project_insert.jsp").forward(request, response);
			}
			else if(op.equals("query")){
				request.setAttribute("op", "query");
				this.fuel_coal_project.setPid(pid);
				this.fuel_coal_project.setName(name);
				this.fuel_coal_project.setType(type);
				this.fuel_coal_project.setNation(nation);
				this.fuel_coal_project.setUnit_capacity(unit_capacity);
				this.fuel_coal_project.setConstruction_mode(construction_mode);
				this.fuel_coal_project.setBoiler_pattern(boiler_pattern);
				this.fuel_coal_project.setFuel_type(fuel_type);
				this.fuel_coal_project.setCoal_type(coal_type);
				this.fuel_coal_project.setUnit_level(unit_level);
				this.fuel_coal_project.setUnit_pattern(unit_pattern);
				this.fuel_coal_project.setCondensate_bump_configuration(condensate_bump_configuration);
				this.fuel_coal_project.setCoal_mill_pattern(coal_mill_pattern);
				this.fuel_coal_project.setDusting_method(dusting_method);
				this.fuel_coal_project.setSulfur_removal_method(sulfur_removal_method);
				this.fuel_coal_project.setDenitration_method(denitration_method);
				this.fuel_coal_project.setExternal_coal_method(external_coal_method);
				this.fuel_coal_project.setCoal_yard_pattern(coal_yard_pattern);
				this.fuel_coal_project.setAsh_removal_system(ash_removal_system);
				this.fuel_coal_project.setPC_stove_medium_speed_coal_child_system(PC_stove_medium_speed_coal_child_system);
				this.fuel_coal_project.setPC_stove_slag_removal_system(PC_stove_slag_removal_system);
				this.fuel_coal_project.setCFB_stove_slag_removal_system(CFB_stove_slag_removal_system);
				this.fuel_coal_project.setCFB_stove_bed_material(CFB_stove_bed_material);
				this.fuel_coal_project.setCFB_stove_limestone_break_system(CFB_stove_limestone_break_system);
				this.fuel_coal_project.setAsh_external_export(ash_external_export);
				this.fuel_coal_project.setCirculating_cooling_method(circulating_cooling_method);
				this.fuel_coal_project.setWater_source(water_source);
				this.fuel_coal_project.setCooling_tower_pattern(cooling_tower_pattern);
				this.fuel_coal_project.setRaw_water_preprocess(raw_water_preprocess);
				this.fuel_coal_project.setSea_water_desalination_process(sea_water_desalination_process);
				this.fuel_coal_project.setBoiler_feedwater_process(boiler_feedwater_process);
				this.fuel_coal_project.setCondensate_polishing(condensate_polishing);
				this.fuel_coal_project.setCooling_water_process(cooling_water_process);
				this.fuel_coal_project.setHydrogen_station(hydrogen_station);
				this.fuel_coal_project.setStack_inner_tank_pattern(stack_inner_tank_pattern);
				this.fuel_coal_project.setMain_factory_foundation_pattern(main_factory_foundation_pattern);
				this.fuel_coal_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
				this.fuel_coal_project.setAmmonia_for_denitration(ammonia_for_denitration);
				this.fuel_coal_project.setFire_protection_standard(fire_protection_standard);
				this.fuel_coal_project.setMain_factory_layout(main_factory_layout);
				this.fuel_coal_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
				this.fuel_coal_project.setPower_station_outlet_voltage_class(power_station_outlet_voltage_class);
				this.fuel_coal_project.setDynamo_loop_GCB_installation(dynamo_loop_GCB_installation);
				this.fuel_coal_project.setHigh_voltage_distribution_device_main_electrical_connection(high_voltage_distribution_device_main_electrical_connection);
				this.fuel_coal_project.setHigh_voltage_distribution_device_pattern(high_voltage_distribution_device_pattern);
				this.fuel_coal_project.setPreparation_one(preparation_one);
				this.fuel_coal_project.setPreparation_two(preparation_two);
				this.fuel_coal_project.setPreparation_three(preparation_three);
				this.fuel_coal_project.setPreparation_four(preparation_four);
				this.fuel_coal_project.setPreparation_five(preparation_five);
				this.fuel_coal_project.setPreparation_six(preparation_six);
				this.fuel_coal_project.setPreparation_seven(preparation_seven);
				this.fuel_coal_project.setPreparation_eight(preparation_eight);
				this.fuel_coal_project.setPreparation_nine(preparation_nine);
				this.fuel_coal_project.setPreparation_ten(preparation_ten);
				Map[] rows = this.fuelCoalProjectService.query(fuel_coal_project);
				//添加入系统日志
				this.log.setOperation("查询");
				this.logService.add(log);
				request.setAttribute("rows", rows);
				if(ch!=null){
					String id = request.getParameter("id");
					Map[] primaryRows = this.fuelCoalProjectService.query(Integer.parseInt(id.toString()));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("unitCapacityRow",m.get("机组容量"));
						request.setAttribute("installationNumberRow",m.get("装机数量"));
						request.setAttribute("constructionModeRow",m.get("建设方式"));
						request.setAttribute("boilerPatternRow",m.get("锅炉型式"));
						request.setAttribute("fuelTypeRow",m.get("燃料类型"));
						request.setAttribute("coalTypeRow",m.get("煤质类别"));
						request.setAttribute("unitLevelRow",m.get("机组等级"));
						request.setAttribute("unitPatternRow",m.get("机组型式"));
						request.setAttribute("condensateBumpConfigurationRow",m.get("凝结水泵配置"));
						request.setAttribute("coalMillPatternRow",m.get("磨煤机型式"));
						request.setAttribute("dustingMethodRow",m.get("除尘方式"));
						request.setAttribute("sulfurRemovalMethodRow",m.get("脱硫方式"));
						request.setAttribute("externalCoalMethodRow",m.get("脱硝方式"));
						request.setAttribute("denitrationMethodRow",m.get("厂外来煤方式"));
						request.setAttribute("coalYardPatternRow",m.get("煤场型式"));
						request.setAttribute("ashRemovalSystemRow",m.get("除灰系统"));
						request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",m.get("PC炉中速磨石子煤系统"));
						request.setAttribute("PCStoveSlagRemovalSystemRow",m.get("PC炉除渣系统"));
						request.setAttribute("CFBStoveSlagRemovalSystemRow",m.get("CFB炉除渣系统"));
						request.setAttribute("CFBStoveBedMaterialRow",m.get("CFB炉床料系统"));
						request.setAttribute("CFBStoveLimestoneBreakSystemRow",m.get("CFB炉石灰石细碎系统"));
						request.setAttribute("ashExternalExportRow",m.get("灰渣厂外输送"));
						request.setAttribute("circulatingCoolingMethodRow",m.get("循环冷却方式"));
						request.setAttribute("waterSourceRow",m.get("水源"));
						request.setAttribute("coolingTowerPatternRow",m.get("冷却塔型式"));
						request.setAttribute("rawWaterPreprocessRow",m.get("原水预处理"));
						request.setAttribute("seaWaterDesalinationProcessRow",m.get("海水淡化处理"));
						request.setAttribute("boilerFeedwaterProcessRow",m.get("锅炉补给水处理"));
						request.setAttribute("condensatePolishingRow",m.get("凝结水精处理"));
						request.setAttribute("coolingWaterProcessRow",m.get("冷却水处理"));
						request.setAttribute("hydrogenStationRow",m.get("氢气站"));
						request.setAttribute("stackInnerTankPatternRow",m.get("烟囱内筒型式"));
						request.setAttribute("mainFactoryFoundationPatternRow",m.get("主厂区基础型式"));
						request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
						request.setAttribute("ammoniaForDenitrationRow",m.get("脱硝用氨"));
						request.setAttribute("fireProtectionStandardRow",m.get("消防标准"));
						request.setAttribute("mainFactoryLayoutRow",m.get("主厂房布置"));
						request.setAttribute("designBasicSeismicAccelerationRow",m.get("设计基本地震加速度"));
						request.setAttribute("powerStationOutletVoltageClassRow",m.get("发电厂出线电压等级"));
						request.setAttribute("dynamoLoopGCBInstallationRow",m.get("发电机回路GCB配置"));
						request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",m.get("高压配电装置电气主接线"));
						request.setAttribute("highVoltageDistributionDevicePatternRow",m.get("高压配电装置型式"));
						request.setAttribute("factoryAreaRow",m.get("厂区面积"));
						request.setAttribute("averageTemperatureRow",m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow",m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow",m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow",m.get("平均相对湿度"));
						request.setAttribute("dustEmissionConcentrationRow",m.get("粉尘排放浓度"));
						request.setAttribute("SO2EmissionConcentrationRow",m.get("SO2排放浓度"));
						request.setAttribute("YOxEmissionConcentrationRow",m.get("YOx排放浓度"));
						request.setAttribute("waterCirculationSystemOverviewRow",m.get("循环水系统概述"));
						request.setAttribute("boilerEfficiencyRow",m.get("锅炉效率"));
						request.setAttribute("turbineHeatConsumptionRow",m.get("汽机热耗"));
						request.setAttribute("auxiliaryPowerRatioRow",m.get("厂用电率"));
						request.setAttribute("factoryNetEfficiencyRow",m.get("全厂净效率"));
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
					request.getRequestDispatcher("fuel_coal_project_insert.jsp").forward(request, response);
				}
				else{

					request.getRequestDispatcher("fuel_coal_project_query.jsp").forward(request, response);
				}
			}
			else if(op.equals("update")){
				request.setAttribute("op", "update");
				String id = request.getParameter("id");
				if(this.fuelCoalProjectService.isSubmit(pid)){
					if(this.fuelCoalProjectService.isSave(pid)){
						this.fuel_coal_project.setId(Integer.parseInt(id));
						this.fuel_coal_project.setPid(pid);
						this.fuel_coal_project.setName(name);
						this.fuel_coal_project.setType(type);
						this.fuel_coal_project.setNation(nation);
						this.fuel_coal_project.setArea(area);
						this.fuel_coal_project.setUnit_capacity(unit_capacity);
						this.fuel_coal_project.setInstallation_number(installation_number);
						this.fuel_coal_project.setConstruction_mode(construction_mode);
						this.fuel_coal_project.setBoiler_pattern(boiler_pattern);
						this.fuel_coal_project.setFuel_type(fuel_type);
						this.fuel_coal_project.setCoal_type(coal_type);
						this.fuel_coal_project.setUnit_level(unit_level);
						this.fuel_coal_project.setUnit_pattern(unit_pattern);
						this.fuel_coal_project.setCondensate_bump_configuration(condensate_bump_configuration);
						this.fuel_coal_project.setCoal_mill_pattern(coal_mill_pattern);
						this.fuel_coal_project.setDusting_method(dusting_method);
						this.fuel_coal_project.setSulfur_removal_method(sulfur_removal_method);
						this.fuel_coal_project.setDenitration_method(denitration_method);
						this.fuel_coal_project.setExternal_coal_method(external_coal_method);
						this.fuel_coal_project.setCoal_yard_pattern(coal_yard_pattern);
						this.fuel_coal_project.setAsh_removal_system(ash_removal_system);
						this.fuel_coal_project.setPC_stove_medium_speed_coal_child_system(PC_stove_medium_speed_coal_child_system);
						this.fuel_coal_project.setPC_stove_slag_removal_system(PC_stove_slag_removal_system);
						this.fuel_coal_project.setCFB_stove_slag_removal_system(CFB_stove_slag_removal_system);
						this.fuel_coal_project.setCFB_stove_bed_material(CFB_stove_bed_material);
						this.fuel_coal_project.setCFB_stove_limestone_break_system(CFB_stove_limestone_break_system);
						this.fuel_coal_project.setAsh_external_export(ash_external_export);
						this.fuel_coal_project.setCirculating_cooling_method(circulating_cooling_method);
						this.fuel_coal_project.setWater_source(water_source);
						this.fuel_coal_project.setCooling_tower_pattern(cooling_tower_pattern);
						this.fuel_coal_project.setRaw_water_preprocess(raw_water_preprocess);
						this.fuel_coal_project.setSea_water_desalination_process(sea_water_desalination_process);
						this.fuel_coal_project.setBoiler_feedwater_process(boiler_feedwater_process);
						this.fuel_coal_project.setCondensate_polishing(condensate_polishing);
						this.fuel_coal_project.setCooling_water_process(cooling_water_process);
						this.fuel_coal_project.setHydrogen_station(hydrogen_station);
						this.fuel_coal_project.setStack_inner_tank_pattern(stack_inner_tank_pattern);
						this.fuel_coal_project.setMain_factory_foundation_pattern(main_factory_foundation_pattern);
						this.fuel_coal_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
						this.fuel_coal_project.setAmmonia_for_denitration(ammonia_for_denitration);
						this.fuel_coal_project.setFire_protection_standard(fire_protection_standard);
						this.fuel_coal_project.setMain_factory_layout(main_factory_layout);
						this.fuel_coal_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
						this.fuel_coal_project.setPower_station_outlet_voltage_class(power_station_outlet_voltage_class);
						this.fuel_coal_project.setDynamo_loop_GCB_installation(dynamo_loop_GCB_installation);
						this.fuel_coal_project.setHigh_voltage_distribution_device_main_electrical_connection(high_voltage_distribution_device_main_electrical_connection);
						this.fuel_coal_project.setHigh_voltage_distribution_device_pattern(high_voltage_distribution_device_pattern);
						this.fuel_coal_project.setFactory_area(factory_area);
						this.fuel_coal_project.setAverage_temperature(average_temperature);
						this.fuel_coal_project.setExtreme_high_temperature(extreme_high_temperature);
						this.fuel_coal_project.setExtreme_low_temperature(extreme_low_temperature);
						this.fuel_coal_project.setAverage_relative_humid(average_relative_humid);
						this.fuel_coal_project.setDust_emission_concentration(dust_emission_concentration);
						this.fuel_coal_project.setSO2_emission_concentration(SO2_emission_concentration);
						this.fuel_coal_project.setYOx_emission_concentration(YOx_emission_concentration);
						this.fuel_coal_project.setWater_circulation_system_overview(water_circulation_system_overview);
						this.fuel_coal_project.setBoiler_efficiency(boiler_efficiency);
						this.fuel_coal_project.setTurbine_heat_consumption(turbine_heat_consumption);
						this.fuel_coal_project.setAuxiliary_power_ratio(auxiliary_power_ratio);
						this.fuel_coal_project.setFactory_net_efficiency(factory_net_efficiency);
						this.fuel_coal_project.setPreparation_one(preparation_one);
						this.fuel_coal_project.setPreparation_two(preparation_two);
						this.fuel_coal_project.setPreparation_three(preparation_three);
						this.fuel_coal_project.setPreparation_four(preparation_four);
						this.fuel_coal_project.setPreparation_five(preparation_five);
						this.fuel_coal_project.setPreparation_six(preparation_six);
						this.fuel_coal_project.setPreparation_seven(preparation_seven);
						this.fuel_coal_project.setPreparation_eight(preparation_eight);
						this.fuel_coal_project.setPreparation_nine(preparation_nine);
						this.fuel_coal_project.setPreparation_ten(preparation_ten);
						this.fuel_coal_project.setEntry_time(this.date.format(new Date()));
						this.fuel_coal_project.setType_in_userNme(UserName);
						this.fuel_coal_project.setVerifier(verifier);
						this.fuel_coal_project.setVerify_state(1);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.fuelCoalProjectService.update(fuel_coal_project)){
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
					request.setAttribute("pidRow",pid);
					request.setAttribute("nameRow",name);
					request.setAttribute("typeRow",type);
					request.setAttribute("nationRow",nation);
					request.setAttribute("areaRow",area);
					request.setAttribute("unitCapacityRow",unit_capacity);
					request.setAttribute("installationNumberRow",installation_number);
					request.setAttribute("constructionModeRow",construction_mode);
					request.setAttribute("boilerPatternRow",boiler_pattern);
					request.setAttribute("fuelTypeRow",fuel_type);
					request.setAttribute("coalTypeRow",coal_type);
					request.setAttribute("unitLevelRow",unit_level);
					request.setAttribute("unitPatternRow",unit_pattern);
					request.setAttribute("condensateBumpConfigurationRow",condensate_bump_configuration);
					request.setAttribute("coalMillPatternRow",coal_mill_pattern);
					request.setAttribute("dustingMethodRow",dusting_method);
					request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
					request.setAttribute("externalCoalMethodRow",external_coal_method);
					request.setAttribute("denitrationMethodRow",denitration_method);
					request.setAttribute("coalYardPatternRow",coal_yard_pattern);
					request.setAttribute("ashRemovalSystemRow",ash_removal_system);
					request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",PC_stove_medium_speed_coal_child_system);
					request.setAttribute("PCStoveSlagRemovalSystemRow",PC_stove_slag_removal_system);
					request.setAttribute("CFBStoveSlagRemovalSystemRow",CFB_stove_slag_removal_system);
					request.setAttribute("CFBStoveBedMaterialRow",CFB_stove_bed_material);
					request.setAttribute("CFBStoveLimestoneBreakSystemRow",CFB_stove_limestone_break_system);
					request.setAttribute("ashExternalExportRow",ash_external_export);
					request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
					request.setAttribute("waterSourceRow",water_source);
					request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
					request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
					request.setAttribute("seaWaterDesalinationProcessRow",sea_water_desalination_process);
					request.setAttribute("boilerFeedwaterProcessRow",boiler_feedwater_process);
					request.setAttribute("condensatePolishingRow",condensate_polishing);
					request.setAttribute("coolingWaterProcessRow",cooling_water_process);
					request.setAttribute("hydrogenStationRow",hydrogen_station);
					request.setAttribute("stackInnerTankPatternRow",stack_inner_tank_pattern);
					request.setAttribute("mainFactoryFoundationPatternRow",main_factory_foundation_pattern);
					request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
					request.setAttribute("ammoniaForDenitrationRow",ammonia_for_denitration);
					request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
					request.setAttribute("mainFactoryLayoutRow",main_factory_layout);
					request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
					request.setAttribute("powerStationOutletVoltageClassRow",power_station_outlet_voltage_class);
					request.setAttribute("dynamoLoopGCBInstallationRow",dynamo_loop_GCB_installation);
					request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",high_voltage_distribution_device_main_electrical_connection);
					request.setAttribute("highVoltageDistributionDevicePatternRow",high_voltage_distribution_device_pattern);
					request.setAttribute("factoryAreaRow",factory_area);
					request.setAttribute("averageTemperatureRow",average_temperature);
					request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
					request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
					request.setAttribute("averageRelativeHumidRow",average_relative_humid);
					request.setAttribute("dustEmissionConcentrationRow",dust_emission_concentration);
					request.setAttribute("SO2EmissionConcentrationRow",SO2_emission_concentration);
					request.setAttribute("YOxEmissionConcentrationRow",YOx_emission_concentration);
					request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
					request.setAttribute("boilerEfficiencyRow",boiler_efficiency);
					request.setAttribute("turbineHeatConsumptionRow",turbine_heat_consumption);
					request.setAttribute("auxiliaryPowerRatioRow",auxiliary_power_ratio);
					request.setAttribute("factoryNetEfficiencyRow",factory_net_efficiency);
					request.setAttribute("preparationOneRow",preparation_one);
					request.setAttribute("preparationTwoRow",preparation_two);
					request.setAttribute("preparationThreeRow",preparation_three);
					request.setAttribute("preparationFourRow",preparation_four);
					request.setAttribute("preparationFiveRow",preparation_five);
					request.setAttribute("preparationSixRow",preparation_six);
					request.setAttribute("preparationSevenRow",preparation_seven);
					request.setAttribute("preparationEightRow",preparation_eight);
					request.setAttribute("preparationNineRow",preparation_nine);
					request.setAttribute("preparationTenRow",preparation_ten);
					request.setAttribute("verifierRow",verifier);
				}
				else{
					this.fuel_coal_project.setId(Integer.parseInt(id));
					this.fuel_coal_project.setPid(pid);
					this.fuel_coal_project.setName(name);
					this.fuel_coal_project.setType(type);
					this.fuel_coal_project.setNation(nation);
					this.fuel_coal_project.setArea(area);
					this.fuel_coal_project.setUnit_capacity(unit_capacity);
					this.fuel_coal_project.setInstallation_number(installation_number);
					this.fuel_coal_project.setConstruction_mode(construction_mode);
					this.fuel_coal_project.setBoiler_pattern(boiler_pattern);
					this.fuel_coal_project.setFuel_type(fuel_type);
					this.fuel_coal_project.setCoal_type(coal_type);
					this.fuel_coal_project.setUnit_level(unit_level);
					this.fuel_coal_project.setUnit_pattern(unit_pattern);
					this.fuel_coal_project.setCondensate_bump_configuration(condensate_bump_configuration);
					this.fuel_coal_project.setCoal_mill_pattern(coal_mill_pattern);
					this.fuel_coal_project.setDusting_method(dusting_method);
					this.fuel_coal_project.setSulfur_removal_method(sulfur_removal_method);
					this.fuel_coal_project.setDenitration_method(denitration_method);
					this.fuel_coal_project.setExternal_coal_method(external_coal_method);
					this.fuel_coal_project.setCoal_yard_pattern(coal_yard_pattern);
					this.fuel_coal_project.setAsh_removal_system(ash_removal_system);
					this.fuel_coal_project.setPC_stove_medium_speed_coal_child_system(PC_stove_medium_speed_coal_child_system);
					this.fuel_coal_project.setPC_stove_slag_removal_system(PC_stove_slag_removal_system);
					this.fuel_coal_project.setCFB_stove_slag_removal_system(CFB_stove_slag_removal_system);
					this.fuel_coal_project.setCFB_stove_bed_material(CFB_stove_bed_material);
					this.fuel_coal_project.setCFB_stove_limestone_break_system(CFB_stove_limestone_break_system);
					this.fuel_coal_project.setAsh_external_export(ash_external_export);
					this.fuel_coal_project.setCirculating_cooling_method(circulating_cooling_method);
					this.fuel_coal_project.setWater_source(water_source);
					this.fuel_coal_project.setCooling_tower_pattern(cooling_tower_pattern);
					this.fuel_coal_project.setRaw_water_preprocess(raw_water_preprocess);
					this.fuel_coal_project.setSea_water_desalination_process(sea_water_desalination_process);
					this.fuel_coal_project.setBoiler_feedwater_process(boiler_feedwater_process);
					this.fuel_coal_project.setCondensate_polishing(condensate_polishing);
					this.fuel_coal_project.setCooling_water_process(cooling_water_process);
					this.fuel_coal_project.setHydrogen_station(hydrogen_station);
					this.fuel_coal_project.setStack_inner_tank_pattern(stack_inner_tank_pattern);
					this.fuel_coal_project.setMain_factory_foundation_pattern(main_factory_foundation_pattern);
					this.fuel_coal_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
					this.fuel_coal_project.setAmmonia_for_denitration(ammonia_for_denitration);
					this.fuel_coal_project.setFire_protection_standard(fire_protection_standard);
					this.fuel_coal_project.setMain_factory_layout(main_factory_layout);
					this.fuel_coal_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
					this.fuel_coal_project.setPower_station_outlet_voltage_class(power_station_outlet_voltage_class);
					this.fuel_coal_project.setDynamo_loop_GCB_installation(dynamo_loop_GCB_installation);
					this.fuel_coal_project.setHigh_voltage_distribution_device_main_electrical_connection(high_voltage_distribution_device_main_electrical_connection);
					this.fuel_coal_project.setHigh_voltage_distribution_device_pattern(high_voltage_distribution_device_pattern);
					this.fuel_coal_project.setFactory_area(factory_area);
					this.fuel_coal_project.setAverage_temperature(average_temperature);
					this.fuel_coal_project.setExtreme_high_temperature(extreme_high_temperature);
					this.fuel_coal_project.setExtreme_low_temperature(extreme_low_temperature);
					this.fuel_coal_project.setAverage_relative_humid(average_relative_humid);
					this.fuel_coal_project.setDust_emission_concentration(dust_emission_concentration);
					this.fuel_coal_project.setSO2_emission_concentration(SO2_emission_concentration);
					this.fuel_coal_project.setYOx_emission_concentration(YOx_emission_concentration);
					this.fuel_coal_project.setWater_circulation_system_overview(water_circulation_system_overview);
					this.fuel_coal_project.setBoiler_efficiency(boiler_efficiency);
					this.fuel_coal_project.setTurbine_heat_consumption(turbine_heat_consumption);
					this.fuel_coal_project.setAuxiliary_power_ratio(auxiliary_power_ratio);
					this.fuel_coal_project.setFactory_net_efficiency(factory_net_efficiency);
					this.fuel_coal_project.setPreparation_one(preparation_one);
					this.fuel_coal_project.setPreparation_two(preparation_two);
					this.fuel_coal_project.setPreparation_three(preparation_three);
					this.fuel_coal_project.setPreparation_four(preparation_four);
					this.fuel_coal_project.setPreparation_five(preparation_five);
					this.fuel_coal_project.setPreparation_six(preparation_six);
					this.fuel_coal_project.setPreparation_seven(preparation_seven);
					this.fuel_coal_project.setPreparation_eight(preparation_eight);
					this.fuel_coal_project.setPreparation_nine(preparation_nine);
					this.fuel_coal_project.setPreparation_ten(preparation_ten);
					this.fuel_coal_project.setEntry_time(this.date.format(new Date()));
					this.fuel_coal_project.setType_in_userNme(UserName);
					this.fuel_coal_project.setVerifier(verifier);
					this.fuel_coal_project.setVerify_state(1);
					//重设默认审核人
					this.userService.setDefaultVerifier(UserName, verifier);
					
					//for 未审核更新处理
					if(ch==null||ch==""){
						if(this.fuelCoalProjectService.update(fuel_coal_project)){
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
						request.setAttribute("unitCapacityRow",unit_capacity);
						request.setAttribute("installationNumberRow",installation_number);
						request.setAttribute("constructionModeRow",construction_mode);
						request.setAttribute("boilerPatternRow",boiler_pattern);
						request.setAttribute("fuelTypeRow",fuel_type);
						request.setAttribute("coalTypeRow",coal_type);
						request.setAttribute("unitLevelRow",unit_level);
						request.setAttribute("unitPatternRow",unit_pattern);
						request.setAttribute("condensateBumpConfigurationRow",condensate_bump_configuration);
						request.setAttribute("coalMillPatternRow",coal_mill_pattern);
						request.setAttribute("dustingMethodRow",dusting_method);
						request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
						request.setAttribute("externalCoalMethodRow",external_coal_method);
						request.setAttribute("denitrationMethodRow",denitration_method);
						request.setAttribute("coalYardPatternRow",coal_yard_pattern);
						request.setAttribute("ashRemovalSystemRow",ash_removal_system);
						request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",PC_stove_medium_speed_coal_child_system);
						request.setAttribute("PCStoveSlagRemovalSystemRow",PC_stove_slag_removal_system);
						request.setAttribute("CFBStoveSlagRemovalSystemRow",CFB_stove_slag_removal_system);
						request.setAttribute("CFBStoveBedMaterialRow",CFB_stove_bed_material);
						request.setAttribute("CFBStoveLimestoneBreakSystemRow",CFB_stove_limestone_break_system);
						request.setAttribute("ashExternalExportRow",ash_external_export);
						request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
						request.setAttribute("waterSourceRow",water_source);
						request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
						request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
						request.setAttribute("seaWaterDesalinationProcessRow",sea_water_desalination_process);
						request.setAttribute("boilerFeedwaterProcessRow",boiler_feedwater_process);
						request.setAttribute("condensatePolishingRow",condensate_polishing);
						request.setAttribute("coolingWaterProcessRow",cooling_water_process);
						request.setAttribute("hydrogenStationRow",hydrogen_station);
						request.setAttribute("stackInnerTankPatternRow",stack_inner_tank_pattern);
						request.setAttribute("mainFactoryFoundationPatternRow",main_factory_foundation_pattern);
						request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
						request.setAttribute("ammoniaForDenitrationRow",ammonia_for_denitration);
						request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
						request.setAttribute("mainFactoryLayoutRow",main_factory_layout);
						request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
						request.setAttribute("powerStationOutletVoltageClassRow",power_station_outlet_voltage_class);
						request.setAttribute("dynamoLoopGCBInstallationRow",dynamo_loop_GCB_installation);
						request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",high_voltage_distribution_device_main_electrical_connection);
						request.setAttribute("highVoltageDistributionDevicePatternRow",high_voltage_distribution_device_pattern);
						request.setAttribute("factoryAreaRow",factory_area);
						request.setAttribute("averageTemperatureRow",average_temperature);
						request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
						request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
						request.setAttribute("averageRelativeHumidRow",average_relative_humid);
						request.setAttribute("dustEmissionConcentrationRow",dust_emission_concentration);
						request.setAttribute("SO2EmissionConcentrationRow",SO2_emission_concentration);
						request.setAttribute("YOxEmissionConcentrationRow",YOx_emission_concentration);
						request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
						request.setAttribute("boilerEfficiencyRow",boiler_efficiency);
						request.setAttribute("turbineHeatConsumptionRow",turbine_heat_consumption);
						request.setAttribute("auxiliaryPowerRatioRow",auxiliary_power_ratio);
						request.setAttribute("factoryNetEfficiencyRow",factory_net_efficiency);
						request.setAttribute("preparationOneRow",preparation_one);
						request.setAttribute("preparationTwoRow",preparation_two);
						request.setAttribute("preparationThreeRow",preparation_three);
						request.setAttribute("preparationFourRow",preparation_four);
						request.setAttribute("preparationFiveRow",preparation_five);
						request.setAttribute("preparationSixRow",preparation_six);
						request.setAttribute("preparationSevenRow",preparation_seven);
						request.setAttribute("preparationEightRow",preparation_eight);
						request.setAttribute("preparationNineRow",preparation_nine);
						request.setAttribute("preparationTenRow",preparation_ten);
						request.setAttribute("verifierRow",verifier);
					}
					else{
						if(ch.equals("unpass")){
							Map[] primaryRows = this.fuelCoalProjectService.query(Integer.parseInt(id));
							for(Map m : primaryRows){
								request.setAttribute("idRow", m.get("编号"));
								request.setAttribute("pidRow", m.get("项目编号"));
								request.setAttribute("nameRow", m.get("项目名称"));
								request.setAttribute("typeRow", m.get("项目类别"));
								request.setAttribute("nationRow", m.get("项目所在国"));
								request.setAttribute("areaRow", m.get("项目所在地区"));
								request.setAttribute("unitCapacityRow",m.get("机组容量"));
								request.setAttribute("installationNumberRow",m.get("装机数量"));
								request.setAttribute("constructionModeRow",m.get("建设方式"));
								request.setAttribute("boilerPatternRow",m.get("锅炉型式"));
								request.setAttribute("fuelTypeRow",m.get("燃料类型"));
								request.setAttribute("coalTypeRow",m.get("煤质类别"));
								request.setAttribute("unitLevelRow",m.get("机组等级"));
								request.setAttribute("unitPatternRow",m.get("机组型式"));
								request.setAttribute("condensateBumpConfigurationRow",m.get("凝结水泵配置"));
								request.setAttribute("coalMillPatternRow",m.get("磨煤机型式"));
								request.setAttribute("dustingMethodRow",m.get("除尘方式"));
								request.setAttribute("sulfurRemovalMethodRow",m.get("脱硫方式"));
								request.setAttribute("externalCoalMethodRow",m.get("脱硝方式"));
								request.setAttribute("denitrationMethodRow",m.get("厂外来煤方式"));
								request.setAttribute("coalYardPatternRow",m.get("煤场型式"));
								request.setAttribute("ashRemovalSystemRow",m.get("除灰系统"));
								request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",m.get("PC炉中速磨石子煤系统"));
								request.setAttribute("PCStoveSlagRemovalSystemRow",m.get("PC炉除渣系统"));
								request.setAttribute("CFBStoveSlagRemovalSystemRow",m.get("CFB炉除渣系统"));
								request.setAttribute("CFBStoveBedMaterialRow",m.get("CFB炉床料系统"));
								request.setAttribute("CFBStoveLimestoneBreakSystemRow",m.get("CFB炉石灰石细碎系统"));
								request.setAttribute("ashExternalExportRow",m.get("灰渣厂外输送"));
								request.setAttribute("circulatingCoolingMethodRow",m.get("循环冷却方式"));
								request.setAttribute("waterSourceRow",m.get("水源"));
								request.setAttribute("coolingTowerPatternRow",m.get("冷却塔型式"));
								request.setAttribute("rawWaterPreprocessRow",m.get("原水预处理"));
								request.setAttribute("seaWaterDesalinationProcessRow",m.get("海水淡化处理"));
								request.setAttribute("boilerFeedwaterProcessRow",m.get("锅炉补给水处理"));
								request.setAttribute("condensatePolishingRow",m.get("凝结水精处理"));
								request.setAttribute("coolingWaterProcessRow",m.get("冷却水处理"));
								request.setAttribute("hydrogenStationRow",m.get("氢气站"));
								request.setAttribute("stackInnerTankPatternRow",m.get("烟囱内筒型式"));
								request.setAttribute("mainFactoryFoundationPatternRow",m.get("主厂区基础型式"));
								request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
								request.setAttribute("ammoniaForDenitrationRow",m.get("脱硝用氨"));
								request.setAttribute("fireProtectionStandardRow",m.get("消防标准"));
								request.setAttribute("mainFactoryLayoutRow",m.get("主厂房布置"));
								request.setAttribute("designBasicSeismicAccelerationRow",m.get("设计基本地震加速度"));
								request.setAttribute("powerStationOutletVoltageClassRow",m.get("发电厂出线电压等级"));
								request.setAttribute("dynamoLoopGCBInstallationRow",m.get("发电机回路GCB配置"));
								request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",m.get("高压配电装置电气主接线"));
								request.setAttribute("highVoltageDistributionDevicePatternRow",m.get("高压配电装置型式"));
								request.setAttribute("factoryAreaRow",m.get("厂区面积"));
								request.setAttribute("averageTemperatureRow",m.get("年平均气温"));
								request.setAttribute("extremeHighTemperatureRow",m.get("极端最高气温"));
								request.setAttribute("extremeLowTemperatureRow",m.get("极端最低气温"));
								request.setAttribute("averageRelativeHumidRow",m.get("平均相对湿度"));
								request.setAttribute("dustEmissionConcentrationRow",m.get("粉尘排放浓度"));
								request.setAttribute("SO2EmissionConcentrationRow",m.get("SO2排放浓度"));
								request.setAttribute("YOxEmissionConcentrationRow",m.get("YOx排放浓度"));
								request.setAttribute("waterCirculationSystemOverviewRow",m.get("循环水系统概述"));
								request.setAttribute("boilerEfficiencyRow",m.get("锅炉效率"));
								request.setAttribute("turbineHeatConsumptionRow",m.get("汽机热耗"));
								request.setAttribute("auxiliaryPowerRatioRow",m.get("厂用电率"));
								request.setAttribute("factoryNetEfficiencyRow",m.get("全厂净效率"));
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
							//for verify page to show 审核意见
							request.setAttribute("ch", "unpass");
						}
						else{
							if(this.fuelCoalProjectService.update(fuel_coal_project)){
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
							request.setAttribute("unitCapacityRow",unit_capacity);
							request.setAttribute("installationNumberRow",installation_number);
							request.setAttribute("constructionModeRow",construction_mode);
							request.setAttribute("boilerPatternRow",boiler_pattern);
							request.setAttribute("fuelTypeRow",fuel_type);
							request.setAttribute("coalTypeRow",coal_type);
							request.setAttribute("unitLevelRow",unit_level);
							request.setAttribute("unitPatternRow",unit_pattern);
							request.setAttribute("condensateBumpConfigurationRow",condensate_bump_configuration);
							request.setAttribute("coalMillPatternRow",coal_mill_pattern);
							request.setAttribute("dustingMethodRow",dusting_method);
							request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
							request.setAttribute("externalCoalMethodRow",external_coal_method);
							request.setAttribute("denitrationMethodRow",denitration_method);
							request.setAttribute("coalYardPatternRow",coal_yard_pattern);
							request.setAttribute("ashRemovalSystemRow",ash_removal_system);
							request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",PC_stove_medium_speed_coal_child_system);
							request.setAttribute("PCStoveSlagRemovalSystemRow",PC_stove_slag_removal_system);
							request.setAttribute("CFBStoveSlagRemovalSystemRow",CFB_stove_slag_removal_system);
							request.setAttribute("CFBStoveBedMaterialRow",CFB_stove_bed_material);
							request.setAttribute("CFBStoveLimestoneBreakSystemRow",CFB_stove_limestone_break_system);
							request.setAttribute("ashExternalExportRow",ash_external_export);
							request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
							request.setAttribute("waterSourceRow",water_source);
							request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
							request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
							request.setAttribute("seaWaterDesalinationProcessRow",sea_water_desalination_process);
							request.setAttribute("boilerFeedwaterProcessRow",boiler_feedwater_process);
							request.setAttribute("condensatePolishingRow",condensate_polishing);
							request.setAttribute("coolingWaterProcessRow",cooling_water_process);
							request.setAttribute("hydrogenStationRow",hydrogen_station);
							request.setAttribute("stackInnerTankPatternRow",stack_inner_tank_pattern);
							request.setAttribute("mainFactoryFoundationPatternRow",main_factory_foundation_pattern);
							request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
							request.setAttribute("ammoniaForDenitrationRow",ammonia_for_denitration);
							request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
							request.setAttribute("mainFactoryLayoutRow",main_factory_layout);
							request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
							request.setAttribute("powerStationOutletVoltageClassRow",power_station_outlet_voltage_class);
							request.setAttribute("dynamoLoopGCBInstallationRow",dynamo_loop_GCB_installation);
							request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",high_voltage_distribution_device_main_electrical_connection);
							request.setAttribute("highVoltageDistributionDevicePatternRow",high_voltage_distribution_device_pattern);
							request.setAttribute("factoryAreaRow",factory_area);
							request.setAttribute("averageTemperatureRow",average_temperature);
							request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
							request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
							request.setAttribute("averageRelativeHumidRow",average_relative_humid);
							request.setAttribute("dustEmissionConcentrationRow",dust_emission_concentration);
							request.setAttribute("SO2EmissionConcentrationRow",SO2_emission_concentration);
							request.setAttribute("YOxEmissionConcentrationRow",YOx_emission_concentration);
							request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
							request.setAttribute("boilerEfficiencyRow",boiler_efficiency);
							request.setAttribute("turbineHeatConsumptionRow",turbine_heat_consumption);
							request.setAttribute("auxiliaryPowerRatioRow",auxiliary_power_ratio);
							request.setAttribute("factoryNetEfficiencyRow",factory_net_efficiency);
							request.setAttribute("preparationOneRow",preparation_one);
							request.setAttribute("preparationTwoRow",preparation_two);
							request.setAttribute("preparationThreeRow",preparation_three);
							request.setAttribute("preparationFourRow",preparation_four);
							request.setAttribute("preparationFiveRow",preparation_five);
							request.setAttribute("preparationSixRow",preparation_six);
							request.setAttribute("preparationSevenRow",preparation_seven);
							request.setAttribute("preparationEightRow",preparation_eight);
							request.setAttribute("preparationNineRow",preparation_nine);
							request.setAttribute("preparationTenRow",preparation_ten);
							request.setAttribute("verifierRow",verifier);
						}
					}
				}
				request.getRequestDispatcher("fuel_coal_project_insert.jsp").forward(request, response);
				
			}
			else if(op.equals("verify")){
				request.setAttribute("op", "verify");
				if(ch!=null){
					Map[] primaryRows = this.fuelCoalProjectService.query(Integer.parseInt(ch));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("unitCapacityRow",m.get("机组容量"));
						request.setAttribute("installationNumberRow",m.get("装机数量"));
						request.setAttribute("constructionModeRow",m.get("建设方式"));
						request.setAttribute("boilerPatternRow",m.get("锅炉型式"));
						request.setAttribute("fuelTypeRow",m.get("燃料类型"));
						request.setAttribute("coalTypeRow",m.get("煤质类别"));
						request.setAttribute("unitLevelRow",m.get("机组等级"));
						request.setAttribute("unitPatternRow",m.get("机组型式"));
						request.setAttribute("condensateBumpConfigurationRow",m.get("凝结水泵配置"));
						request.setAttribute("coalMillPatternRow",m.get("磨煤机型式"));
						request.setAttribute("dustingMethodRow",m.get("除尘方式"));
						request.setAttribute("sulfurRemovalMethodRow",m.get("脱硫方式"));
						request.setAttribute("externalCoalMethodRow",m.get("脱硝方式"));
						request.setAttribute("denitrationMethodRow",m.get("厂外来煤方式"));
						request.setAttribute("coalYardPatternRow",m.get("煤场型式"));
						request.setAttribute("ashRemovalSystemRow",m.get("除灰系统"));
						request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",m.get("PC炉中速磨石子煤系统"));
						request.setAttribute("PCStoveSlagRemovalSystemRow",m.get("PC炉除渣系统"));
						request.setAttribute("CFBStoveSlagRemovalSystemRow",m.get("CFB炉除渣系统"));
						request.setAttribute("CFBStoveBedMaterialRow",m.get("CFB炉床料系统"));
						request.setAttribute("CFBStoveLimestoneBreakSystemRow",m.get("CFB炉石灰石细碎系统"));
						request.setAttribute("ashExternalExportRow",m.get("灰渣厂外输送"));
						request.setAttribute("circulatingCoolingMethodRow",m.get("循环冷却方式"));
						request.setAttribute("waterSourceRow",m.get("水源"));
						request.setAttribute("coolingTowerPatternRow",m.get("冷却塔型式"));
						request.setAttribute("rawWaterPreprocessRow",m.get("原水预处理"));
						request.setAttribute("seaWaterDesalinationProcessRow",m.get("海水淡化处理"));
						request.setAttribute("boilerFeedwaterProcessRow",m.get("锅炉补给水处理"));
						request.setAttribute("condensatePolishingRow",m.get("凝结水精处理"));
						request.setAttribute("coolingWaterProcessRow",m.get("冷却水处理"));
						request.setAttribute("hydrogenStationRow",m.get("氢气站"));
						request.setAttribute("stackInnerTankPatternRow",m.get("烟囱内筒型式"));
						request.setAttribute("mainFactoryFoundationPatternRow",m.get("主厂区基础型式"));
						request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
						request.setAttribute("ammoniaForDenitrationRow",m.get("脱硝用氨"));
						request.setAttribute("fireProtectionStandardRow",m.get("消防标准"));
						request.setAttribute("mainFactoryLayoutRow",m.get("主厂房布置"));
						request.setAttribute("designBasicSeismicAccelerationRow",m.get("设计基本地震加速度"));
						request.setAttribute("powerStationOutletVoltageClassRow",m.get("发电厂出线电压等级"));
						request.setAttribute("dynamoLoopGCBInstallationRow",m.get("发电机回路GCB配置"));
						request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",m.get("高压配电装置电气主接线"));
						request.setAttribute("highVoltageDistributionDevicePatternRow",m.get("高压配电装置型式"));
						request.setAttribute("factoryAreaRow",m.get("厂区面积"));
						request.setAttribute("averageTemperatureRow",m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow",m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow",m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow",m.get("平均相对湿度"));
						request.setAttribute("dustEmissionConcentrationRow",m.get("粉尘排放浓度"));
						request.setAttribute("SO2EmissionConcentrationRow",m.get("SO2排放浓度"));
						request.setAttribute("YOxEmissionConcentrationRow",m.get("YOx排放浓度"));
						request.setAttribute("waterCirculationSystemOverviewRow",m.get("循环水系统概述"));
						request.setAttribute("boilerEfficiencyRow",m.get("锅炉效率"));
						request.setAttribute("turbineHeatConsumptionRow",m.get("汽机热耗"));
						request.setAttribute("auxiliaryPowerRatioRow",m.get("厂用电率"));
						request.setAttribute("factoryNetEfficiencyRow",m.get("全厂净效率"));
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
					request.getRequestDispatcher("fuel_coal_project_insert.jsp").forward(request, response);
				}
				else{
					String id = request.getParameter("id");
					this.fuel_coal_project.setId(Integer.parseInt(id));
					this.fuel_coal_project.setPid(pid);
					this.fuel_coal_project.setName(name);
					this.fuel_coal_project.setType(type);
					this.fuel_coal_project.setNation(nation);
					this.fuel_coal_project.setArea(area);
					this.fuel_coal_project.setUnit_capacity(unit_capacity);
					this.fuel_coal_project.setInstallation_number(installation_number);
					this.fuel_coal_project.setConstruction_mode(construction_mode);
					this.fuel_coal_project.setBoiler_pattern(boiler_pattern);
					this.fuel_coal_project.setFuel_type(fuel_type);
					this.fuel_coal_project.setCoal_type(coal_type);
					this.fuel_coal_project.setUnit_level(unit_level);
					this.fuel_coal_project.setUnit_pattern(unit_pattern);
					this.fuel_coal_project.setCondensate_bump_configuration(condensate_bump_configuration);
					this.fuel_coal_project.setCoal_mill_pattern(coal_mill_pattern);
					this.fuel_coal_project.setDusting_method(dusting_method);
					this.fuel_coal_project.setSulfur_removal_method(sulfur_removal_method);
					this.fuel_coal_project.setDenitration_method(denitration_method);
					this.fuel_coal_project.setExternal_coal_method(external_coal_method);
					this.fuel_coal_project.setCoal_yard_pattern(coal_yard_pattern);
					this.fuel_coal_project.setAsh_removal_system(ash_removal_system);
					this.fuel_coal_project.setPC_stove_medium_speed_coal_child_system(PC_stove_medium_speed_coal_child_system);
					this.fuel_coal_project.setPC_stove_slag_removal_system(PC_stove_slag_removal_system);
					this.fuel_coal_project.setCFB_stove_slag_removal_system(CFB_stove_slag_removal_system);
					this.fuel_coal_project.setCFB_stove_bed_material(CFB_stove_bed_material);
					this.fuel_coal_project.setCFB_stove_limestone_break_system(CFB_stove_limestone_break_system);
					this.fuel_coal_project.setAsh_external_export(ash_external_export);
					this.fuel_coal_project.setCirculating_cooling_method(circulating_cooling_method);
					this.fuel_coal_project.setWater_source(water_source);
					this.fuel_coal_project.setCooling_tower_pattern(cooling_tower_pattern);
					this.fuel_coal_project.setRaw_water_preprocess(raw_water_preprocess);
					this.fuel_coal_project.setSea_water_desalination_process(sea_water_desalination_process);
					this.fuel_coal_project.setBoiler_feedwater_process(boiler_feedwater_process);
					this.fuel_coal_project.setCondensate_polishing(condensate_polishing);
					this.fuel_coal_project.setCooling_water_process(cooling_water_process);
					this.fuel_coal_project.setHydrogen_station(hydrogen_station);
					this.fuel_coal_project.setStack_inner_tank_pattern(stack_inner_tank_pattern);
					this.fuel_coal_project.setMain_factory_foundation_pattern(main_factory_foundation_pattern);
					this.fuel_coal_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
					this.fuel_coal_project.setAmmonia_for_denitration(ammonia_for_denitration);
					this.fuel_coal_project.setFire_protection_standard(fire_protection_standard);
					this.fuel_coal_project.setMain_factory_layout(main_factory_layout);
					this.fuel_coal_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
					this.fuel_coal_project.setPower_station_outlet_voltage_class(power_station_outlet_voltage_class);
					this.fuel_coal_project.setDynamo_loop_GCB_installation(dynamo_loop_GCB_installation);
					this.fuel_coal_project.setHigh_voltage_distribution_device_main_electrical_connection(high_voltage_distribution_device_main_electrical_connection);
					this.fuel_coal_project.setHigh_voltage_distribution_device_pattern(high_voltage_distribution_device_pattern);
					this.fuel_coal_project.setFactory_area(factory_area);
					this.fuel_coal_project.setAverage_temperature(average_temperature);
					this.fuel_coal_project.setExtreme_high_temperature(extreme_high_temperature);
					this.fuel_coal_project.setExtreme_low_temperature(extreme_low_temperature);
					this.fuel_coal_project.setAverage_relative_humid(average_relative_humid);
					this.fuel_coal_project.setDust_emission_concentration(dust_emission_concentration);
					this.fuel_coal_project.setSO2_emission_concentration(SO2_emission_concentration);
					this.fuel_coal_project.setYOx_emission_concentration(YOx_emission_concentration);
					this.fuel_coal_project.setWater_circulation_system_overview(water_circulation_system_overview);
					this.fuel_coal_project.setBoiler_efficiency(boiler_efficiency);
					this.fuel_coal_project.setTurbine_heat_consumption(turbine_heat_consumption);
					this.fuel_coal_project.setAuxiliary_power_ratio(auxiliary_power_ratio);
					this.fuel_coal_project.setFactory_net_efficiency(factory_net_efficiency);
					this.fuel_coal_project.setPreparation_one(preparation_one);
					this.fuel_coal_project.setPreparation_two(preparation_two);
					this.fuel_coal_project.setPreparation_three(preparation_three);
					this.fuel_coal_project.setPreparation_four(preparation_four);
					this.fuel_coal_project.setPreparation_five(preparation_five);
					this.fuel_coal_project.setPreparation_six(preparation_six);
					this.fuel_coal_project.setPreparation_seven(preparation_seven);
					this.fuel_coal_project.setPreparation_eight(preparation_eight);
					this.fuel_coal_project.setPreparation_nine(preparation_nine);
					this.fuel_coal_project.setPreparation_ten(preparation_ten);
					this.fuel_coal_project.setVerify_time(this.date.format(new Date()));
					this.fuel_coal_project.setVerify_comment(verify_comment);
					if(se!=null){
						if(se.equals("1")){
							this.fuel_coal_project.setVerify_state(2);
						}
						else if(se.equals("-1")){
							this.fuel_coal_project.setVerify_state(-1);
						}
					}
					this.fuel_coal_project.setVerify_comment(verify_comment);
					//填充
					request.setAttribute("idRow", Integer.parseInt(id));
					request.setAttribute("pidRow",pid);
					request.setAttribute("nameRow",name);
					request.setAttribute("typeRow",type);
					request.setAttribute("nationRow",nation);
					request.setAttribute("areaRow",area);
					request.setAttribute("unitCapacityRow",unit_capacity);
					request.setAttribute("installationNumberRow",installation_number);
					request.setAttribute("constructionModeRow",construction_mode);
					request.setAttribute("boilerPatternRow",boiler_pattern);
					request.setAttribute("fuelTypeRow",fuel_type);
					request.setAttribute("coalTypeRow",coal_type);
					request.setAttribute("unitLevelRow",unit_level);
					request.setAttribute("unitPatternRow",unit_pattern);
					request.setAttribute("condensateBumpConfigurationRow",condensate_bump_configuration);
					request.setAttribute("coalMillPatternRow",coal_mill_pattern);
					request.setAttribute("dustingMethodRow",dusting_method);
					request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
					request.setAttribute("externalCoalMethodRow",external_coal_method);
					request.setAttribute("denitrationMethodRow",denitration_method);
					request.setAttribute("coalYardPatternRow",coal_yard_pattern);
					request.setAttribute("ashRemovalSystemRow",ash_removal_system);
					request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",PC_stove_medium_speed_coal_child_system);
					request.setAttribute("PCStoveSlagRemovalSystemRow",PC_stove_slag_removal_system);
					request.setAttribute("CFBStoveSlagRemovalSystemRow",CFB_stove_slag_removal_system);
					request.setAttribute("CFBStoveBedMaterialRow",CFB_stove_bed_material);
					request.setAttribute("CFBStoveLimestoneBreakSystemRow",CFB_stove_limestone_break_system);
					request.setAttribute("ashExternalExportRow",ash_external_export);
					request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
					request.setAttribute("waterSourceRow",water_source);
					request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
					request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
					request.setAttribute("seaWaterDesalinationProcessRow",sea_water_desalination_process);
					request.setAttribute("boilerFeedwaterProcessRow",boiler_feedwater_process);
					request.setAttribute("condensatePolishingRow",condensate_polishing);
					request.setAttribute("coolingWaterProcessRow",cooling_water_process);
					request.setAttribute("hydrogenStationRow",hydrogen_station);
					request.setAttribute("stackInnerTankPatternRow",stack_inner_tank_pattern);
					request.setAttribute("mainFactoryFoundationPatternRow",main_factory_foundation_pattern);
					request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
					request.setAttribute("ammoniaForDenitrationRow",ammonia_for_denitration);
					request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
					request.setAttribute("mainFactoryLayoutRow",main_factory_layout);
					request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
					request.setAttribute("powerStationOutletVoltageClassRow",power_station_outlet_voltage_class);
					request.setAttribute("dynamoLoopGCBInstallationRow",dynamo_loop_GCB_installation);
					request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",high_voltage_distribution_device_main_electrical_connection);
					request.setAttribute("highVoltageDistributionDevicePatternRow",high_voltage_distribution_device_pattern);
					request.setAttribute("factoryAreaRow",factory_area);
					request.setAttribute("averageTemperatureRow",average_temperature);
					request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
					request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
					request.setAttribute("averageRelativeHumidRow",average_relative_humid);
					request.setAttribute("dustEmissionConcentrationRow",dust_emission_concentration);
					request.setAttribute("SO2EmissionConcentrationRow",SO2_emission_concentration);
					request.setAttribute("YOxEmissionConcentrationRow",YOx_emission_concentration);
					request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
					request.setAttribute("boilerEfficiencyRow",boiler_efficiency);
					request.setAttribute("turbineHeatConsumptionRow",turbine_heat_consumption);
					request.setAttribute("auxiliaryPowerRatioRow",auxiliary_power_ratio);
					request.setAttribute("factoryNetEfficiencyRow",factory_net_efficiency);
					request.setAttribute("preparationOneRow",preparation_one);
					request.setAttribute("preparationTwoRow",preparation_two);
					request.setAttribute("preparationThreeRow",preparation_three);
					request.setAttribute("preparationFourRow",preparation_four);
					request.setAttribute("preparationFiveRow",preparation_five);
					request.setAttribute("preparationSixRow",preparation_six);
					request.setAttribute("preparationSevenRow",preparation_seven);
					request.setAttribute("preparationEightRow",preparation_eight);
					request.setAttribute("preparationNineRow",preparation_nine);
					request.setAttribute("preparationTenRow",preparation_ten);
					request.setAttribute("verifyCommentRow", verify_comment);
					if(this.fuelCoalProjectService.verify(fuel_coal_project)){
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
					request.getRequestDispatcher("fuel_coal_project_insert.jsp").forward(request, response);
				}
			}
			else if(op.equals("save")){
				request.setAttribute("op","save");
				String id = request.getParameter("id");
				this.fuel_coal_project.setPid(pid);
				this.fuel_coal_project.setName(name);
				this.fuel_coal_project.setType(type);
				this.fuel_coal_project.setNation(nation);
				this.fuel_coal_project.setArea(area);
				this.fuel_coal_project.setUnit_capacity(unit_capacity);
				this.fuel_coal_project.setInstallation_number(installation_number);
				this.fuel_coal_project.setConstruction_mode(construction_mode);
				this.fuel_coal_project.setBoiler_pattern(boiler_pattern);
				this.fuel_coal_project.setFuel_type(fuel_type);
				this.fuel_coal_project.setCoal_type(coal_type);
				this.fuel_coal_project.setUnit_level(unit_level);
				this.fuel_coal_project.setUnit_pattern(unit_pattern);
				this.fuel_coal_project.setCondensate_bump_configuration(condensate_bump_configuration);
				this.fuel_coal_project.setCoal_mill_pattern(coal_mill_pattern);
				this.fuel_coal_project.setDusting_method(dusting_method);
				this.fuel_coal_project.setSulfur_removal_method(sulfur_removal_method);
				this.fuel_coal_project.setDenitration_method(denitration_method);
				this.fuel_coal_project.setExternal_coal_method(external_coal_method);
				this.fuel_coal_project.setCoal_yard_pattern(coal_yard_pattern);
				this.fuel_coal_project.setAsh_removal_system(ash_removal_system);
				this.fuel_coal_project.setPC_stove_medium_speed_coal_child_system(PC_stove_medium_speed_coal_child_system);
				this.fuel_coal_project.setPC_stove_slag_removal_system(PC_stove_slag_removal_system);
				this.fuel_coal_project.setCFB_stove_slag_removal_system(CFB_stove_slag_removal_system);
				this.fuel_coal_project.setCFB_stove_bed_material(CFB_stove_bed_material);
				this.fuel_coal_project.setCFB_stove_limestone_break_system(CFB_stove_limestone_break_system);
				this.fuel_coal_project.setAsh_external_export(ash_external_export);
				this.fuel_coal_project.setCirculating_cooling_method(circulating_cooling_method);
				this.fuel_coal_project.setWater_source(water_source);
				this.fuel_coal_project.setCooling_tower_pattern(cooling_tower_pattern);
				this.fuel_coal_project.setRaw_water_preprocess(raw_water_preprocess);
				this.fuel_coal_project.setSea_water_desalination_process(sea_water_desalination_process);
				this.fuel_coal_project.setBoiler_feedwater_process(boiler_feedwater_process);
				this.fuel_coal_project.setCondensate_polishing(condensate_polishing);
				this.fuel_coal_project.setCooling_water_process(cooling_water_process);
				this.fuel_coal_project.setHydrogen_station(hydrogen_station);
				this.fuel_coal_project.setStack_inner_tank_pattern(stack_inner_tank_pattern);
				this.fuel_coal_project.setMain_factory_foundation_pattern(main_factory_foundation_pattern);
				this.fuel_coal_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
				this.fuel_coal_project.setAmmonia_for_denitration(ammonia_for_denitration);
				this.fuel_coal_project.setFire_protection_standard(fire_protection_standard);
				this.fuel_coal_project.setMain_factory_layout(main_factory_layout);
				this.fuel_coal_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
				this.fuel_coal_project.setPower_station_outlet_voltage_class(power_station_outlet_voltage_class);
				this.fuel_coal_project.setDynamo_loop_GCB_installation(dynamo_loop_GCB_installation);
				this.fuel_coal_project.setHigh_voltage_distribution_device_main_electrical_connection(high_voltage_distribution_device_main_electrical_connection);
				this.fuel_coal_project.setHigh_voltage_distribution_device_pattern(high_voltage_distribution_device_pattern);
				this.fuel_coal_project.setFactory_area(factory_area);
				this.fuel_coal_project.setAverage_temperature(average_temperature);
				this.fuel_coal_project.setExtreme_high_temperature(extreme_high_temperature);
				this.fuel_coal_project.setExtreme_low_temperature(extreme_low_temperature);
				this.fuel_coal_project.setAverage_relative_humid(average_relative_humid);
				this.fuel_coal_project.setDust_emission_concentration(dust_emission_concentration);
				this.fuel_coal_project.setSO2_emission_concentration(SO2_emission_concentration);
				this.fuel_coal_project.setYOx_emission_concentration(YOx_emission_concentration);
				this.fuel_coal_project.setWater_circulation_system_overview(water_circulation_system_overview);
				this.fuel_coal_project.setBoiler_efficiency(boiler_efficiency);
				this.fuel_coal_project.setTurbine_heat_consumption(turbine_heat_consumption);
				this.fuel_coal_project.setAuxiliary_power_ratio(auxiliary_power_ratio);
				this.fuel_coal_project.setFactory_net_efficiency(factory_net_efficiency);
				this.fuel_coal_project.setPreparation_one(preparation_one);
				this.fuel_coal_project.setPreparation_two(preparation_two);
				this.fuel_coal_project.setPreparation_three(preparation_three);
				this.fuel_coal_project.setPreparation_four(preparation_four);
				this.fuel_coal_project.setPreparation_five(preparation_five);
				this.fuel_coal_project.setPreparation_six(preparation_six);
				this.fuel_coal_project.setPreparation_seven(preparation_seven);
				this.fuel_coal_project.setPreparation_eight(preparation_eight);
				this.fuel_coal_project.setPreparation_nine(preparation_nine);
				this.fuel_coal_project.setPreparation_ten(preparation_ten);
				this.fuel_coal_project.setVerify_state(0);
				this.fuel_coal_project.setEntry_time(this.date.format(new Date()));
				this.fuel_coal_project.setVerifier(verifier);
				this.fuel_coal_project.setType_in_userNme(UserName);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				
				if(id==null||id==""){
					if(this.fuelCoalProjectService.isSubmit(pid)){
						request.setAttribute("msg", "<script>alert('已存在相应相同编号记录，请修改项目编号后提交！')</script>");
					}
					else{
						this.fuelCoalProjectService.add(fuel_coal_project);
						request.setAttribute("idRow", this.fuelCoalProjectService.getId(pid, 0));
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
					request.setAttribute("unitCapacityRow",unit_capacity);
					request.setAttribute("installationNumberRow",installation_number);
					request.setAttribute("constructionModeRow",construction_mode);
					request.setAttribute("boilerPatternRow",boiler_pattern);
					request.setAttribute("fuelTypeRow",fuel_type);
					request.setAttribute("coalTypeRow",coal_type);
					request.setAttribute("unitLevelRow",unit_level);
					request.setAttribute("unitPatternRow",unit_pattern);
					request.setAttribute("condensateBumpConfigurationRow",condensate_bump_configuration);
					request.setAttribute("coalMillPatternRow",coal_mill_pattern);
					request.setAttribute("dustingMethodRow",dusting_method);
					request.setAttribute("sulfurRemovalMethodRow",sulfur_removal_method);
					request.setAttribute("externalCoalMethodRow",external_coal_method);
					request.setAttribute("denitrationMethodRow",denitration_method);
					request.setAttribute("coalYardPatternRow",coal_yard_pattern);
					request.setAttribute("ashRemovalSystemRow",ash_removal_system);
					request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",PC_stove_medium_speed_coal_child_system);
					request.setAttribute("PCStoveSlagRemovalSystemRow",PC_stove_slag_removal_system);
					request.setAttribute("CFBStoveSlagRemovalSystemRow",CFB_stove_slag_removal_system);
					request.setAttribute("CFBStoveBedMaterialRow",CFB_stove_bed_material);
					request.setAttribute("CFBStoveLimestoneBreakSystemRow",CFB_stove_limestone_break_system);
					request.setAttribute("ashExternalExportRow",ash_external_export);
					request.setAttribute("circulatingCoolingMethodRow",circulating_cooling_method);
					request.setAttribute("waterSourceRow",water_source);
					request.setAttribute("coolingTowerPatternRow",cooling_tower_pattern);
					request.setAttribute("rawWaterPreprocessRow",raw_water_preprocess);
					request.setAttribute("seaWaterDesalinationProcessRow",sea_water_desalination_process);
					request.setAttribute("boilerFeedwaterProcessRow",boiler_feedwater_process);
					request.setAttribute("condensatePolishingRow",condensate_polishing);
					request.setAttribute("coolingWaterProcessRow",cooling_water_process);
					request.setAttribute("hydrogenStationRow",hydrogen_station);
					request.setAttribute("stackInnerTankPatternRow",stack_inner_tank_pattern);
					request.setAttribute("mainFactoryFoundationPatternRow",main_factory_foundation_pattern);
					request.setAttribute("mainFactoryStructurePatternRow",main_factory_structure_pattern);
					request.setAttribute("ammoniaForDenitrationRow",ammonia_for_denitration);
					request.setAttribute("fireProtectionStandardRow",fire_protection_standard);
					request.setAttribute("mainFactoryLayoutRow",main_factory_layout);
					request.setAttribute("designBasicSeismicAccelerationRow",design_basic_seismic_acceleration);
					request.setAttribute("powerStationOutletVoltageClassRow",power_station_outlet_voltage_class);
					request.setAttribute("dynamoLoopGCBInstallationRow",dynamo_loop_GCB_installation);
					request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",high_voltage_distribution_device_main_electrical_connection);
					request.setAttribute("highVoltageDistributionDevicePatternRow",high_voltage_distribution_device_pattern);
					request.setAttribute("factoryAreaRow",factory_area);
					request.setAttribute("averageTemperatureRow",average_temperature);
					request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature);
					request.setAttribute("extremeLowTemperatureRow",extreme_low_temperature);
					request.setAttribute("averageRelativeHumidRow",average_relative_humid);
					request.setAttribute("dustEmissionConcentrationRow",dust_emission_concentration);
					request.setAttribute("SO2EmissionConcentrationRow",SO2_emission_concentration);
					request.setAttribute("YOxEmissionConcentrationRow",YOx_emission_concentration);
					request.setAttribute("waterCirculationSystemOverviewRow",water_circulation_system_overview);
					request.setAttribute("boilerEfficiencyRow",boiler_efficiency);
					request.setAttribute("turbineHeatConsumptionRow",turbine_heat_consumption);
					request.setAttribute("auxiliaryPowerRatioRow",auxiliary_power_ratio);
					request.setAttribute("factoryNetEfficiencyRow",factory_net_efficiency);
					request.setAttribute("preparationOneRow",preparation_one);
					request.setAttribute("preparationTwoRow",preparation_two);
					request.setAttribute("preparationThreeRow",preparation_three);
					request.setAttribute("preparationFourRow",preparation_four);
					request.setAttribute("preparationFiveRow",preparation_five);
					request.setAttribute("preparationSixRow",preparation_six);
					request.setAttribute("preparationSevenRow",preparation_seven);
					request.setAttribute("preparationEightRow",preparation_eight);
					request.setAttribute("preparationNineRow",preparation_nine);
					request.setAttribute("preparationTenRow",preparation_ten);
					request.setAttribute("verifierRow",verifier);
				}
				else {
					this.fuel_coal_project.setId(Integer.parseInt(id));
					//填充
					Map[] primaryRows = this.fuelCoalProjectService.query(Integer.parseInt(id));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("unitCapacityRow",m.get("机组容量"));
						request.setAttribute("installationNumberRow",m.get("装机数量"));
						request.setAttribute("constructionModeRow",m.get("建设方式"));
						request.setAttribute("boilerPatternRow",m.get("锅炉型式"));
						request.setAttribute("fuelTypeRow",m.get("燃料类型"));
						request.setAttribute("coalTypeRow",m.get("煤质类别"));
						request.setAttribute("unitLevelRow",m.get("机组等级"));
						request.setAttribute("unitPatternRow",m.get("机组型式"));
						request.setAttribute("condensateBumpConfigurationRow",m.get("凝结水泵配置"));
						request.setAttribute("coalMillPatternRow",m.get("磨煤机型式"));
						request.setAttribute("dustingMethodRow",m.get("除尘方式"));
						request.setAttribute("sulfurRemovalMethodRow",m.get("脱硫方式"));
						request.setAttribute("externalCoalMethodRow",m.get("脱硝方式"));
						request.setAttribute("denitrationMethodRow",m.get("厂外来煤方式"));
						request.setAttribute("coalYardPatternRow",m.get("煤场型式"));
						request.setAttribute("ashRemovalSystemRow",m.get("除灰系统"));
						request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",m.get("PC炉中速磨石子煤系统"));
						request.setAttribute("PCStoveSlagRemovalSystemRow",m.get("PC炉除渣系统"));
						request.setAttribute("CFBStoveSlagRemovalSystemRow",m.get("CFB炉除渣系统"));
						request.setAttribute("CFBStoveBedMaterialRow",m.get("CFB炉床料系统"));
						request.setAttribute("CFBStoveLimestoneBreakSystemRow",m.get("CFB炉石灰石细碎系统"));
						request.setAttribute("ashExternalExportRow",m.get("灰渣厂外输送"));
						request.setAttribute("circulatingCoolingMethodRow",m.get("循环冷却方式"));
						request.setAttribute("waterSourceRow",m.get("水源"));
						request.setAttribute("coolingTowerPatternRow",m.get("冷却塔型式"));
						request.setAttribute("rawWaterPreprocessRow",m.get("原水预处理"));
						request.setAttribute("seaWaterDesalinationProcessRow",m.get("海水淡化处理"));
						request.setAttribute("boilerFeedwaterProcessRow",m.get("锅炉补给水处理"));
						request.setAttribute("condensatePolishingRow",m.get("凝结水精处理"));
						request.setAttribute("coolingWaterProcessRow",m.get("冷却水处理"));
						request.setAttribute("hydrogenStationRow",m.get("氢气站"));
						request.setAttribute("stackInnerTankPatternRow",m.get("烟囱内筒型式"));
						request.setAttribute("mainFactoryFoundationPatternRow",m.get("主厂区基础型式"));
						request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
						request.setAttribute("ammoniaForDenitrationRow",m.get("脱硝用氨"));
						request.setAttribute("fireProtectionStandardRow",m.get("消防标准"));
						request.setAttribute("mainFactoryLayoutRow",m.get("主厂房布置"));
						request.setAttribute("designBasicSeismicAccelerationRow",m.get("设计基本地震加速度"));
						request.setAttribute("powerStationOutletVoltageClassRow",m.get("发电厂出线电压等级"));
						request.setAttribute("dynamoLoopGCBInstallationRow",m.get("发电机回路GCB配置"));
						request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",m.get("高压配电装置电气主接线"));
						request.setAttribute("highVoltageDistributionDevicePatternRow",m.get("高压配电装置型式"));
						request.setAttribute("factoryAreaRow",m.get("厂区面积"));
						request.setAttribute("averageTemperatureRow",m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow",m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow",m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow",m.get("平均相对湿度"));
						request.setAttribute("dustEmissionConcentrationRow",m.get("粉尘排放浓度"));
						request.setAttribute("SO2EmissionConcentrationRow",m.get("SO2排放浓度"));
						request.setAttribute("YOxEmissionConcentrationRow",m.get("YOx排放浓度"));
						request.setAttribute("waterCirculationSystemOverviewRow",m.get("循环水系统概述"));
						request.setAttribute("boilerEfficiencyRow",m.get("锅炉效率"));
						request.setAttribute("turbineHeatConsumptionRow",m.get("汽机热耗"));
						request.setAttribute("auxiliaryPowerRatioRow",m.get("厂用电率"));
						request.setAttribute("factoryNetEfficiencyRow",m.get("全厂净效率"));
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
					if(this.fuelCoalProjectService.update(fuel_coal_project)){
						//添加入系统日志
						this.log.setOperation("保存");
						this.logService.add(log);
						request.setAttribute("msg", "<script>alert('更新成功！')</script>");
					}
					else {
						request.setAttribute("msg", "<script>alert('更新失败！')</script>");
					}
				}
				request.getRequestDispatcher("fuel_coal_project_insert.jsp").forward(request, response);
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
						this.fuel_coal_project.setId(Integer.parseInt(id));
						this.fuel_coal_project.setPid(pid);
						this.fuel_coal_project.setName(name);
						this.fuel_coal_project.setType(type);
						this.fuel_coal_project.setNation(nation);
						this.fuel_coal_project.setArea(area);
						this.fuel_coal_project.setUnit_capacity(unit_capacity);
						this.fuel_coal_project.setInstallation_number(installation_number);
						this.fuel_coal_project.setConstruction_mode(construction_mode);
						this.fuel_coal_project.setBoiler_pattern(boiler_pattern);
						this.fuel_coal_project.setFuel_type(fuel_type);
						this.fuel_coal_project.setCoal_type(coal_type);
						this.fuel_coal_project.setUnit_level(unit_level);
						this.fuel_coal_project.setUnit_pattern(unit_pattern);
						this.fuel_coal_project.setCondensate_bump_configuration(condensate_bump_configuration);
						this.fuel_coal_project.setCoal_mill_pattern(coal_mill_pattern);
						this.fuel_coal_project.setDusting_method(dusting_method);
						this.fuel_coal_project.setSulfur_removal_method(sulfur_removal_method);
						this.fuel_coal_project.setDenitration_method(denitration_method);
						this.fuel_coal_project.setExternal_coal_method(external_coal_method);
						this.fuel_coal_project.setCoal_yard_pattern(coal_yard_pattern);
						this.fuel_coal_project.setAsh_removal_system(ash_removal_system);
						this.fuel_coal_project.setPC_stove_medium_speed_coal_child_system(PC_stove_medium_speed_coal_child_system);
						this.fuel_coal_project.setPC_stove_slag_removal_system(PC_stove_slag_removal_system);
						this.fuel_coal_project.setCFB_stove_slag_removal_system(CFB_stove_slag_removal_system);
						this.fuel_coal_project.setCFB_stove_bed_material(CFB_stove_bed_material);
						this.fuel_coal_project.setCFB_stove_limestone_break_system(CFB_stove_limestone_break_system);
						this.fuel_coal_project.setAsh_external_export(ash_external_export);
						this.fuel_coal_project.setCirculating_cooling_method(circulating_cooling_method);
						this.fuel_coal_project.setWater_source(water_source);
						this.fuel_coal_project.setCooling_tower_pattern(cooling_tower_pattern);
						this.fuel_coal_project.setRaw_water_preprocess(raw_water_preprocess);
						this.fuel_coal_project.setSea_water_desalination_process(sea_water_desalination_process);
						this.fuel_coal_project.setBoiler_feedwater_process(boiler_feedwater_process);
						this.fuel_coal_project.setCondensate_polishing(condensate_polishing);
						this.fuel_coal_project.setCooling_water_process(cooling_water_process);
						this.fuel_coal_project.setHydrogen_station(hydrogen_station);
						this.fuel_coal_project.setStack_inner_tank_pattern(stack_inner_tank_pattern);
						this.fuel_coal_project.setMain_factory_foundation_pattern(main_factory_foundation_pattern);
						this.fuel_coal_project.setMain_factory_structure_pattern(main_factory_structure_pattern);
						this.fuel_coal_project.setAmmonia_for_denitration(ammonia_for_denitration);
						this.fuel_coal_project.setFire_protection_standard(fire_protection_standard);
						this.fuel_coal_project.setMain_factory_layout(main_factory_layout);
						this.fuel_coal_project.setDesign_basic_seismic_acceleration(design_basic_seismic_acceleration);
						this.fuel_coal_project.setPower_station_outlet_voltage_class(power_station_outlet_voltage_class);
						this.fuel_coal_project.setDynamo_loop_GCB_installation(dynamo_loop_GCB_installation);
						this.fuel_coal_project.setHigh_voltage_distribution_device_main_electrical_connection(high_voltage_distribution_device_main_electrical_connection);
						this.fuel_coal_project.setHigh_voltage_distribution_device_pattern(high_voltage_distribution_device_pattern);
						this.fuel_coal_project.setFactory_area(factory_area);
						this.fuel_coal_project.setAverage_temperature(average_temperature);
						this.fuel_coal_project.setExtreme_high_temperature(extreme_high_temperature);
						this.fuel_coal_project.setExtreme_low_temperature(extreme_low_temperature);
						this.fuel_coal_project.setAverage_relative_humid(average_relative_humid);
						this.fuel_coal_project.setDust_emission_concentration(dust_emission_concentration);
						this.fuel_coal_project.setSO2_emission_concentration(SO2_emission_concentration);
						this.fuel_coal_project.setYOx_emission_concentration(YOx_emission_concentration);
						this.fuel_coal_project.setWater_circulation_system_overview(water_circulation_system_overview);
						this.fuel_coal_project.setBoiler_efficiency(boiler_efficiency);
						this.fuel_coal_project.setTurbine_heat_consumption(turbine_heat_consumption);
						this.fuel_coal_project.setAuxiliary_power_ratio(auxiliary_power_ratio);
						this.fuel_coal_project.setFactory_net_efficiency(factory_net_efficiency);
						this.fuel_coal_project.setPreparation_one(preparation_one);
						this.fuel_coal_project.setPreparation_two(preparation_two);
						this.fuel_coal_project.setPreparation_three(preparation_three);
						this.fuel_coal_project.setPreparation_four(preparation_four);
						this.fuel_coal_project.setPreparation_five(preparation_five);
						this.fuel_coal_project.setPreparation_six(preparation_six);
						this.fuel_coal_project.setPreparation_seven(preparation_seven);
						this.fuel_coal_project.setPreparation_eight(preparation_eight);
						this.fuel_coal_project.setPreparation_nine(preparation_nine);
						this.fuel_coal_project.setPreparation_ten(preparation_ten);
						this.fuel_coal_project.setVerifier(verifier);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.fuelCoalProjectService.maintenance(fuel_coal_project)){
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
				Map[] primaryRows = this.fuelCoalProjectService.query(id);
				for(Map m : primaryRows){
					request.setAttribute("idRow", m.get("编号"));
					request.setAttribute("pidRow", m.get("项目编号"));
					request.setAttribute("nameRow", m.get("项目名称"));
					request.setAttribute("typeRow", m.get("项目类别"));
					request.setAttribute("nationRow", m.get("项目所在国"));
					request.setAttribute("areaRow", m.get("项目所在地区"));
					request.setAttribute("unitCapacityRow",m.get("机组容量"));
					request.setAttribute("installationNumberRow",m.get("装机数量"));
					request.setAttribute("constructionModeRow",m.get("建设方式"));
					request.setAttribute("boilerPatternRow",m.get("锅炉型式"));
					request.setAttribute("fuelTypeRow",m.get("燃料类型"));
					request.setAttribute("coalTypeRow",m.get("煤质类别"));
					request.setAttribute("unitLevelRow",m.get("机组等级"));
					request.setAttribute("unitPatternRow",m.get("机组型式"));
					request.setAttribute("condensateBumpConfigurationRow",m.get("凝结水泵配置"));
					request.setAttribute("coalMillPatternRow",m.get("磨煤机型式"));
					request.setAttribute("dustingMethodRow",m.get("除尘方式"));
					request.setAttribute("sulfurRemovalMethodRow",m.get("脱硫方式"));
					request.setAttribute("externalCoalMethodRow",m.get("脱硝方式"));
					request.setAttribute("denitrationMethodRow",m.get("厂外来煤方式"));
					request.setAttribute("coalYardPatternRow",m.get("煤场型式"));
					request.setAttribute("ashRemovalSystemRow",m.get("除灰系统"));
					request.setAttribute("PCStoveMediumSpeedCoalChildSystemRow",m.get("PC炉中速磨石子煤系统"));
					request.setAttribute("PCStoveSlagRemovalSystemRow",m.get("PC炉除渣系统"));
					request.setAttribute("CFBStoveSlagRemovalSystemRow",m.get("CFB炉除渣系统"));
					request.setAttribute("CFBStoveBedMaterialRow",m.get("CFB炉床料系统"));
					request.setAttribute("CFBStoveLimestoneBreakSystemRow",m.get("CFB炉石灰石细碎系统"));
					request.setAttribute("ashExternalExportRow",m.get("灰渣厂外输送"));
					request.setAttribute("circulatingCoolingMethodRow",m.get("循环冷却方式"));
					request.setAttribute("waterSourceRow",m.get("水源"));
					request.setAttribute("coolingTowerPatternRow",m.get("冷却塔型式"));
					request.setAttribute("rawWaterPreprocessRow",m.get("原水预处理"));
					request.setAttribute("seaWaterDesalinationProcessRow",m.get("海水淡化处理"));
					request.setAttribute("boilerFeedwaterProcessRow",m.get("锅炉补给水处理"));
					request.setAttribute("condensatePolishingRow",m.get("凝结水精处理"));
					request.setAttribute("coolingWaterProcessRow",m.get("冷却水处理"));
					request.setAttribute("hydrogenStationRow",m.get("氢气站"));
					request.setAttribute("stackInnerTankPatternRow",m.get("烟囱内筒型式"));
					request.setAttribute("mainFactoryFoundationPatternRow",m.get("主厂区基础型式"));
					request.setAttribute("mainFactoryStructurePatternRow", m.get("主厂房结构型式"));
					request.setAttribute("ammoniaForDenitrationRow",m.get("脱硝用氨"));
					request.setAttribute("fireProtectionStandardRow",m.get("消防标准"));
					request.setAttribute("mainFactoryLayoutRow",m.get("主厂房布置"));
					request.setAttribute("designBasicSeismicAccelerationRow",m.get("设计基本地震加速度"));
					request.setAttribute("powerStationOutletVoltageClassRow",m.get("发电厂出线电压等级"));
					request.setAttribute("dynamoLoopGCBInstallationRow",m.get("发电机回路GCB配置"));
					request.setAttribute("highVoltageDistributionDeviceMainElectricalConnectionRow",m.get("高压配电装置电气主接线"));
					request.setAttribute("highVoltageDistributionDevicePatternRow",m.get("高压配电装置型式"));
					request.setAttribute("factoryAreaRow",m.get("厂区面积"));
					request.setAttribute("averageTemperatureRow",m.get("年平均气温"));
					request.setAttribute("extremeHighTemperatureRow",m.get("极端最高气温"));
					request.setAttribute("extremeLowTemperatureRow",m.get("极端最低气温"));
					request.setAttribute("averageRelativeHumidRow",m.get("平均相对湿度"));
					request.setAttribute("dustEmissionConcentrationRow",m.get("粉尘排放浓度"));
					request.setAttribute("SO2EmissionConcentrationRow",m.get("SO2排放浓度"));
					request.setAttribute("YOxEmissionConcentrationRow",m.get("YOx排放浓度"));
					request.setAttribute("waterCirculationSystemOverviewRow",m.get("循环水系统概述"));
					request.setAttribute("boilerEfficiencyRow",m.get("锅炉效率"));
					request.setAttribute("turbineHeatConsumptionRow",m.get("汽机热耗"));
					request.setAttribute("auxiliaryPowerRatioRow",m.get("厂用电率"));
					request.setAttribute("factoryNetEfficiencyRow",m.get("全厂净效率"));
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
				request.getRequestDispatcher("fuel_coal_project_insert.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "<script>alert('非法访问，无相应参数！')</script>");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
	}

}
