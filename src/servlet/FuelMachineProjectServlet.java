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
import pojo.Fuel_machine_project;
import pojo.Log;
import pojo.MyFile;
import service.FieldMaintenanceServiceImpl;
import service.FileService;
import service.FuelMachineProjectServiceImpl;
import service.IFieldMaintenanceService;
import service.IFuelMachineProjectService;
import service.ILogService;
import service.IUserService;
import service.LogServiceImpl;
import service.UserServiceImpl;

/**
 * Servlet implementation class FuelMachineProjectServlet
 */
@SuppressWarnings("rawtypes")
public class FuelMachineProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Fuel_machine_project fuel_machine_project = new Fuel_machine_project();
    private IFuelMachineProjectService fuelMachineProjectService = new FuelMachineProjectServiceImpl();
    private IFieldMaintenanceService fieldMaintenanceService = new FieldMaintenanceServiceImpl();
    private IUserService userService = new UserServiceImpl();
    private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
	FileService fileService=new FileService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuelMachineProjectServlet() {
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
			String average_temperature = request.getParameter("average_temperature");
			String extreme_high_temperature = request.getParameter("extreme_high_temperature");
			String extreme_low_temperature = request.getParameter("extreme_low_temperature");
			String average_relative_humid = request.getParameter("average_relative_humid");
			String barometric_pressure = request.getParameter("barometric_pressure");
			String water_source = request.getParameter("water_source");
			String fuel_power_station_pattern = request.getParameter("fuel_power_station_pattern");
			String fuel_station_fuel_type = request.getParameter("fuel_station_fuel_type");
			String fuel_machine_level = request.getParameter("fuel_machine_level");
			String fuel_machine_version = request.getParameter("fuel_machine_version");
			String waste_heat_boiler_circulate_type = request.getParameter("waste_heat_boiler_circulate_type");
			String waste_heat_boiler_structure_type = request.getParameter("waste_heat_boiler_structure_type");
			String waste_heat_boiler_afterburning_type = request.getParameter("waste_heat_boiler_afterburning_type");
			String combined_circulation_aerated_water_system_pattern = request.getParameter("combined_circulation_aerated_water_system_pattern");
			String combined_circulation_mainframe_layout_pattern = request.getParameter("combined_circulation_mainframe_layout_pattern");
			String factory_area = request.getParameter("factory_area");
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
			Map[] typeRows = this.fuelMachineProjectService.getDefaultTypeRows();
			Map[] nationRows = this.fuelMachineProjectService.getDefaultNationRows();
			Map[] waterSourceRows = this.fuelMachineProjectService.getDefaultWaterSourceRows();
			Map[] fuelPowerStationPatternRows = this.fuelMachineProjectService.getDefaultFuelPowerStationPatternRows();
			Map[] fuelStationFuelTypeRows = this.fuelMachineProjectService.getDefaultFuelStationFuelTypeRows();
			Map[] fuelMachineLevelRows = this.fuelMachineProjectService.getDefaultFuelMachineLevelRows();
			Map[] wasteHeatBoilerCirculateTypeRows = this.fuelMachineProjectService.getDefaultWasteHeatBoilerCirculateTypeRows();
			Map[] wasteHeatBoilerStructureTypeRows = this.fuelMachineProjectService.getDefaultWasteHeatBoilerStructureTypeRows();
			Map[] wasteHeatBoilerAfterburningTypeRows = this.fuelMachineProjectService.getDefaultWasteHeatBoilerAfterburningTypeRows();
			Map[] combinedCirculationAeratedWaterSystemPatternRows = this.fuelMachineProjectService.getDefaultCombinedCirculationAeratedWaterSystemPatternRows();
			Map[] combinedCirculationMainframeLayoutPatternRows = this.fuelMachineProjectService.getDefaultCombinedCirculationMainframeLayoutPatternRows();
			Map[] verifierRows = this.userService.getDefaultVerifierRows();
			Map[] preparationOneRows = this.fuelMachineProjectService.getDefaultPreparationOneRows();
			Map[] preparationTwoRows = this.fuelMachineProjectService.getDefaultPreparationTwoRows();
			Map[] preparationThreeRows = this.fuelMachineProjectService.getDefaultPreparationThreeRows();
			Map[] preparationFourRows = this.fuelMachineProjectService.getDefaultPreparationFourRows();
			Map[] preparationFiveRows = this.fuelMachineProjectService.getDefaultPreparationFiveRows();
			Map[] preparationSixRows= this.fuelMachineProjectService.getDefaultPreparationSixRows();
			Map[] preparationSevenRows = this.fuelMachineProjectService.getDefaultPreparationSevenRows();
			Map[] preparationEightRows = this.fuelMachineProjectService.getDefaultPreparationEightRows();
			Map[] preparationNineRows= this.fuelMachineProjectService.getDefaultPreparationNineRows();
			Map[] preparationTenRows = this.fuelMachineProjectService.getDefaultPreparationTenRows();
			request.setAttribute("typeRows",typeRows);
			request.setAttribute("nationRows",nationRows);
			request.setAttribute("waterSourceRows",waterSourceRows);
			request.setAttribute("fuelPowerStationPatternRows",fuelPowerStationPatternRows);
			request.setAttribute("fuelStationFuelTypeRows",fuelStationFuelTypeRows);
			request.setAttribute("fuelMachineLevelRows",fuelMachineLevelRows);
			request.setAttribute("wasteHeatBoilerCirculateTypeRows",wasteHeatBoilerCirculateTypeRows);
			request.setAttribute("wasteHeatBoilerStructureTypeRows",wasteHeatBoilerStructureTypeRows);
			request.setAttribute("wasteHeatBoilerAfterburningTypeRows",wasteHeatBoilerAfterburningTypeRows);
			request.setAttribute("combinedCirculationAeratedWaterSystemPatternRows",combinedCirculationAeratedWaterSystemPatternRows);
			request.setAttribute("combinedCirculationMainframeLayoutPatternRows",combinedCirculationMainframeLayoutPatternRows);
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
			request.setAttribute("pageName", "fuel_machine_project");//pageName for page dispatcher
			this.log.setUname(UserName);
			this.log.setTable("燃机项目");
			this.log.setTime(this.date.format(new Date()));
			//设置初始审核人
			request.setAttribute("verifierRow", this.userService.getDefaultVerifier(UserName));
			//预留字段是否启用
			int isPreparationOneUsed = this.fieldMaintenanceService.isUse("燃机项目","预留一");
			int isPreparationTwoUsed = this.fieldMaintenanceService.isUse("燃机项目","预留二");
			int isPreparationThreeUsed = this.fieldMaintenanceService.isUse("燃机项目","预留三");
			int isPreparationFourUsed = this.fieldMaintenanceService.isUse("燃机项目","预留四");
			int isPreparationFiveUsed = this.fieldMaintenanceService.isUse("燃机项目","预留五");
			int isPreparationSixUsed = this.fieldMaintenanceService.isUse("燃机项目","预留六");
			int isPreparationSevenUsed = this.fieldMaintenanceService.isUse("燃机项目","预留七");
			int isPreparationEightUsed = this.fieldMaintenanceService.isUse("燃机项目","预留八");
			int isPreparationNineUsed = this.fieldMaintenanceService.isUse("燃机项目","预留九");
			int isPreparationTenUsed = this.fieldMaintenanceService.isUse("燃机项目","预留十");
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
			String preparationOneNewName = this.fieldMaintenanceService.getNewName("燃机项目","预留一");
			String preparationTwoNewName = this.fieldMaintenanceService.getNewName("燃机项目","预留二");
			String preparationThreeNewName = this.fieldMaintenanceService.getNewName("燃机项目","预留三");
			String preparationFourNewName = this.fieldMaintenanceService.getNewName("燃机项目","预留四");
			String preparationFiveNewName = this.fieldMaintenanceService.getNewName("燃机项目","预留五");
			String preparationSixNewName = this.fieldMaintenanceService.getNewName("燃机项目","预留六");
			String preparationSevenNewName = this.fieldMaintenanceService.getNewName("燃机项目","预留七");
			String preparationEightNewName = this.fieldMaintenanceService.getNewName("燃机项目","预留八");
			String preparationNineNewName = this.fieldMaintenanceService.getNewName("燃机项目","预留九");
			String preparationTenNewName = this.fieldMaintenanceService.getNewName("燃机项目","预留十");
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
				if(this.fuelMachineProjectService.hasSave(UserName)){
					Map[] primaryRows = this.fuelMachineProjectService.primaryQuery(UserName);
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
						request.setAttribute("barometricPressureRow", m.get("大气压"));
						request.setAttribute("waterSourceRow", m.get("水源"));
						request.setAttribute("fuelPowerStationPatternRow", m.get("燃机电站型式"));
						request.setAttribute("fuelStationFuelTypeRow", m.get("燃机电站燃料类型"));
						request.setAttribute("fuelMachineLevelRow", m.get("燃机级别"));
						request.setAttribute("fuelMachineVersionRow", m.get("燃机型号"));
						request.setAttribute("wasteHeatBoilerCirculateTypeRow", m.get("余热锅炉循环类别"));
						request.setAttribute("wasteHeatBoilerStructureTypeRow", m.get("余热锅炉结构类别"));
						request.setAttribute("wasteHeatBoilerAfterburningTypeRow", m.get("余热锅炉补燃类别"));
						request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", m.get("联合循环汽水循环系统型式"));
						request.setAttribute("combinedCirculationMainframeLayoutPatternRow", m.get("联合循环主机布置型式"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
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
					request.getRequestDispatcher("fuel_machine_project_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("fuel_machine_project_insert.jsp").forward(request, response);
				}
				
			}
			else if(op.equals("add")){
				request.setAttribute("op","insert");
				this.fuel_machine_project.setPid(pid);
				this.fuel_machine_project.setName(name);
				this.fuel_machine_project.setType(type);
				this.fuel_machine_project.setNation(nation);
				this.fuel_machine_project.setArea(area);
				this.fuel_machine_project.setAverage_temperature(average_temperature);
				this.fuel_machine_project.setExtreme_high_temperature(extreme_high_temperature);
				this.fuel_machine_project.setExtreme_low_temperature(extreme_low_temperature);
				this.fuel_machine_project.setAverage_relative_humid(average_relative_humid);
				this.fuel_machine_project.setBarometric_pressure(barometric_pressure);
				this.fuel_machine_project.setWater_source(water_source);
				this.fuel_machine_project.setFuel_power_station_pattern(fuel_power_station_pattern);
				this.fuel_machine_project.setFuel_station_fuel_type(fuel_station_fuel_type);
				this.fuel_machine_project.setFuel_machine_level(fuel_machine_level);
				this.fuel_machine_project.setFuel_machine_version(fuel_machine_version);
				this.fuel_machine_project.setWaste_heat_boiler_circulate_type(waste_heat_boiler_circulate_type);
				this.fuel_machine_project.setWaste_heat_boiler_structure_type(waste_heat_boiler_structure_type);
				this.fuel_machine_project.setWaste_heat_boiler_afterburning_type(waste_heat_boiler_afterburning_type);
				this.fuel_machine_project.setCombined_circulation_aerated_water_system_pattern(combined_circulation_aerated_water_system_pattern);
				this.fuel_machine_project.setCombined_circulation_mainframe_layout_pattern(combined_circulation_mainframe_layout_pattern);
				this.fuel_machine_project.setFactory_area(factory_area);
				this.fuel_machine_project.setWater_circulation_system_overview(water_circulation_system_overview);
				this.fuel_machine_project.setPreparation_one(preparation_one);
				this.fuel_machine_project.setPreparation_two(preparation_two);
				this.fuel_machine_project.setPreparation_three(preparation_three);
				this.fuel_machine_project.setPreparation_four(preparation_four);
				this.fuel_machine_project.setPreparation_five(preparation_five);
				this.fuel_machine_project.setPreparation_six(preparation_six);
				this.fuel_machine_project.setPreparation_seven(preparation_seven);
				this.fuel_machine_project.setPreparation_eight(preparation_eight);
				this.fuel_machine_project.setPreparation_nine(preparation_nine);
				this.fuel_machine_project.setPreparation_ten(preparation_ten);
				this.fuel_machine_project.setEntry_time(this.date.format(new Date()));
				this.fuel_machine_project.setType_in_userNme(UserName);
				this.fuel_machine_project.setVerifier(verifier);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				request.setAttribute("pidRow", pid);
				request.setAttribute("nameRow", name);
				request.setAttribute("typeRow", type);
				request.setAttribute("nationRow", nation);
				request.setAttribute("areaRow", area);
				request.setAttribute("averageTemperatureRow",average_temperature);
				request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature );
				request.setAttribute("extremeLowTemperatureRow", extreme_low_temperature);
				request.setAttribute("averageRelativeHumidRow", average_relative_humid);
				request.setAttribute("barometricPressureRow", barometric_pressure);
				request.setAttribute("waterSourceRow", water_source);
				request.setAttribute("fuelPowerStationPatternRow", fuel_power_station_pattern);
				request.setAttribute("fuelStationFuelTypeRow", fuel_station_fuel_type);
				request.setAttribute("fuelMachineLevelRow", fuel_machine_level);
				request.setAttribute("fuelMachineVersionRow", fuel_machine_version);
				request.setAttribute("wasteHeatBoilerCirculateTypeRow", waste_heat_boiler_circulate_type);
				request.setAttribute("wasteHeatBoilerStructureTypeRow", waste_heat_boiler_structure_type);
				request.setAttribute("wasteHeatBoilerAfterburningTypeRow", waste_heat_boiler_afterburning_type);
				request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", combined_circulation_aerated_water_system_pattern);
				request.setAttribute("combinedCirculationMainframeLayoutPatternRow", combined_circulation_mainframe_layout_pattern);
				request.setAttribute("factoryAreaRow", factory_area);
				request.setAttribute("waterCirculationSystemOverviewRow", water_circulation_system_overview);
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
				if(this.fuelMachineProjectService.isSubmit(pid)){
					if(this.fuelMachineProjectService.isSave(pid)){
						request.setAttribute("msg", "<script>alert('已存在相同编号保存记录,无法继续保存第二条具有相同编号的记录,请核实并修改项目编号！')</script>");
					}
					else{
						if(this.fuelMachineProjectService.hasSave(UserName)){
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，并且您已有一条保存记录了,无法继续保存第二条的记录,请核实并修改项目编号！')</script>");
						}
						else {
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，请核实项目编号后提交！')</script>");
						}
					}
				}
				else{
					this.fuel_machine_project.setVerify_state(1);
					if(this.fuelMachineProjectService.add(fuel_machine_project)){
						//添加入系统日志
						this.log.setOperation("录入");
						this.logService.add(log);
						
						Map[] primaryRows = this.fuelMachineProjectService.query(this.fuelMachineProjectService.getId(pid, 1));
						for(Map m : primaryRows){
							request.setAttribute("idRow", m.get("编号"));
							request.setAttribute("pidRow", m.get("项目编号"));
							request.setAttribute("nameRow", m.get("项目名称"));
							request.setAttribute("typeRow", m.get("项目类别"));
							request.setAttribute("nationRow", m.get("项目所在国"));
							request.setAttribute("areaRow", m.get("项目所在地区"));
							request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
							request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
							request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
							request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
							request.setAttribute("barometricPressureRow", m.get("大气压"));
							request.setAttribute("waterSourceRow", m.get("水源"));
							request.setAttribute("fuelPowerStationPatternRow", m.get("燃机电站型式"));
							request.setAttribute("fuelStationFuelTypeRow", m.get("燃机电站燃料类型"));
							request.setAttribute("fuelMachineLevelRow", m.get("燃机级别"));
							request.setAttribute("fuelMachineVersionRow", m.get("燃机型号"));
							request.setAttribute("wasteHeatBoilerCirculateTypeRow", m.get("余热锅炉循环类别"));
							request.setAttribute("wasteHeatBoilerStructureTypeRow", m.get("余热锅炉结构类别"));
							request.setAttribute("wasteHeatBoilerAfterburningTypeRow", m.get("余热锅炉补燃类别"));
							request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", m.get("联合循环汽水循环系统型式"));
							request.setAttribute("combinedCirculationMainframeLayoutPatternRow", m.get("联合循环主机布置型式"));
							request.setAttribute("factoryAreaRow", m.get("厂区面积"));
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
						request.setAttribute("msg", "<script>alert('提交成功！')</script>");
						
					}
					else{
						request.setAttribute("msg", "<script>alert('提交失败！')</script>");
					}
				}
				request.setAttribute("op","update");
				request.getRequestDispatcher("fuel_machine_project_insert.jsp").forward(request, response);
			}
			else if(op.equals("query")){
				request.setAttribute("op", "query");
				this.fuel_machine_project.setPid(pid);
				this.fuel_machine_project.setName(name);
				this.fuel_machine_project.setType(type);
				this.fuel_machine_project.setNation(nation);
				this.fuel_machine_project.setArea(area);
				this.fuel_machine_project.setAverage_temperature(average_temperature);
				this.fuel_machine_project.setExtreme_high_temperature(extreme_high_temperature);
				this.fuel_machine_project.setExtreme_low_temperature(extreme_low_temperature);
				this.fuel_machine_project.setAverage_relative_humid(average_relative_humid);
				this.fuel_machine_project.setBarometric_pressure(barometric_pressure);
				this.fuel_machine_project.setWater_source(water_source);
				this.fuel_machine_project.setFuel_power_station_pattern(fuel_power_station_pattern);
				this.fuel_machine_project.setFuel_station_fuel_type(fuel_station_fuel_type);
				this.fuel_machine_project.setFuel_machine_level(fuel_machine_level);
				this.fuel_machine_project.setFuel_machine_version(fuel_machine_version);
				this.fuel_machine_project.setWaste_heat_boiler_circulate_type(waste_heat_boiler_circulate_type);
				this.fuel_machine_project.setWaste_heat_boiler_structure_type(waste_heat_boiler_structure_type);
				this.fuel_machine_project.setWaste_heat_boiler_afterburning_type(waste_heat_boiler_afterburning_type);
				this.fuel_machine_project.setCombined_circulation_aerated_water_system_pattern(combined_circulation_aerated_water_system_pattern);
				this.fuel_machine_project.setCombined_circulation_mainframe_layout_pattern(combined_circulation_mainframe_layout_pattern);
				this.fuel_machine_project.setFactory_area(factory_area);
				this.fuel_machine_project.setWater_circulation_system_overview(water_circulation_system_overview);
				this.fuel_machine_project.setPreparation_one(preparation_one);
				this.fuel_machine_project.setPreparation_two(preparation_two);
				this.fuel_machine_project.setPreparation_three(preparation_three);
				this.fuel_machine_project.setPreparation_four(preparation_four);
				this.fuel_machine_project.setPreparation_five(preparation_five);
				this.fuel_machine_project.setPreparation_six(preparation_six);
				this.fuel_machine_project.setPreparation_seven(preparation_seven);
				this.fuel_machine_project.setPreparation_eight(preparation_eight);
				this.fuel_machine_project.setPreparation_nine(preparation_nine);
				this.fuel_machine_project.setPreparation_ten(preparation_ten);
				Map[] rows = this.fuelMachineProjectService.query(fuel_machine_project);
				//添加入系统日志
				this.log.setOperation("查询");
				this.logService.add(log);
				request.setAttribute("rows", rows);
				if(ch!=null){
					String id = request.getParameter("id");
					Map[] primaryRows = this.fuelMachineProjectService.query(Integer.parseInt(id.toString()));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
						request.setAttribute("barometricPressureRow", m.get("大气压"));
						request.setAttribute("waterSourceRow", m.get("水源"));
						request.setAttribute("fuelPowerStationPatternRow", m.get("燃机电站型式"));
						request.setAttribute("fuelStationFuelTypeRow", m.get("燃机电站燃料类型"));
						request.setAttribute("fuelMachineLevelRow", m.get("燃机级别"));
						request.setAttribute("fuelMachineVersionRow", m.get("燃机型号"));
						request.setAttribute("wasteHeatBoilerCirculateTypeRow", m.get("余热锅炉循环类别"));
						request.setAttribute("wasteHeatBoilerStructureTypeRow", m.get("余热锅炉结构类别"));
						request.setAttribute("wasteHeatBoilerAfterburningTypeRow", m.get("余热锅炉补燃类别"));
						request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", m.get("联合循环汽水循环系统型式"));
						request.setAttribute("combinedCirculationMainframeLayoutPatternRow", m.get("联合循环主机布置型式"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
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
					request.getRequestDispatcher("fuel_machine_project_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("fuel_machine_project_query.jsp").forward(request, response);
				}
				
			}
			else if(op.equals("update")){
				request.setAttribute("op", "update");
				String id = request.getParameter("id");
				if(this.fuelMachineProjectService.isSubmit(pid)){
					if(this.fuelMachineProjectService.isSave(pid)){
						this.fuel_machine_project.setId(Integer.parseInt(id));
						this.fuel_machine_project.setPid(pid);
						this.fuel_machine_project.setName(name);
						this.fuel_machine_project.setType(type);
						this.fuel_machine_project.setNation(nation);
						this.fuel_machine_project.setArea(area);
						this.fuel_machine_project.setAverage_temperature(average_temperature);
						this.fuel_machine_project.setExtreme_high_temperature(extreme_high_temperature);
						this.fuel_machine_project.setExtreme_low_temperature(extreme_low_temperature);
						this.fuel_machine_project.setAverage_relative_humid(average_relative_humid);
						this.fuel_machine_project.setBarometric_pressure(barometric_pressure);
						this.fuel_machine_project.setWater_source(water_source);
						this.fuel_machine_project.setFuel_power_station_pattern(fuel_power_station_pattern);
						this.fuel_machine_project.setFuel_station_fuel_type(fuel_station_fuel_type);
						this.fuel_machine_project.setFuel_machine_level(fuel_machine_level);
						this.fuel_machine_project.setFuel_machine_version(fuel_machine_version);
						this.fuel_machine_project.setWaste_heat_boiler_circulate_type(waste_heat_boiler_circulate_type);
						this.fuel_machine_project.setWaste_heat_boiler_structure_type(waste_heat_boiler_structure_type);
						this.fuel_machine_project.setWaste_heat_boiler_afterburning_type(waste_heat_boiler_afterburning_type);
						this.fuel_machine_project.setCombined_circulation_aerated_water_system_pattern(combined_circulation_aerated_water_system_pattern);
						this.fuel_machine_project.setCombined_circulation_mainframe_layout_pattern(combined_circulation_mainframe_layout_pattern);
						this.fuel_machine_project.setFactory_area(factory_area);
						this.fuel_machine_project.setWater_circulation_system_overview(water_circulation_system_overview);
						this.fuel_machine_project.setPreparation_one(preparation_one);
						this.fuel_machine_project.setPreparation_two(preparation_two);
						this.fuel_machine_project.setPreparation_three(preparation_three);
						this.fuel_machine_project.setPreparation_four(preparation_four);
						this.fuel_machine_project.setPreparation_five(preparation_five);
						this.fuel_machine_project.setPreparation_six(preparation_six);
						this.fuel_machine_project.setPreparation_seven(preparation_seven);
						this.fuel_machine_project.setPreparation_eight(preparation_eight);
						this.fuel_machine_project.setPreparation_nine(preparation_nine);
						this.fuel_machine_project.setPreparation_ten(preparation_ten);
						this.fuel_machine_project.setEntry_time(this.date.format(new Date()));
						this.fuel_machine_project.setType_in_userNme(UserName);
						this.fuel_machine_project.setVerifier(verifier);
						this.fuel_machine_project.setVerify_state(1);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.fuelMachineProjectService.update(fuel_machine_project)){
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
					request.setAttribute("nameRow", name);
					request.setAttribute("typeRow", type);
					request.setAttribute("nationRow", nation);
					request.setAttribute("areaRow", area);
					request.setAttribute("averageTemperatureRow",average_temperature);
					request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature );
					request.setAttribute("extremeLowTemperatureRow", extreme_low_temperature);
					request.setAttribute("averageRelativeHumidRow", average_relative_humid);
					request.setAttribute("barometricPressureRow", barometric_pressure);
					request.setAttribute("waterSourceRow", water_source);
					request.setAttribute("fuelPowerStationPatternRow", fuel_power_station_pattern);
					request.setAttribute("fuelStationFuelTypeRow", fuel_station_fuel_type);
					request.setAttribute("fuelMachineLevelRow", fuel_machine_level);
					request.setAttribute("fuelMachineVersionRow", fuel_machine_version);
					request.setAttribute("wasteHeatBoilerCirculateTypeRow", waste_heat_boiler_circulate_type);
					request.setAttribute("wasteHeatBoilerStructureTypeRow", waste_heat_boiler_structure_type);
					request.setAttribute("wasteHeatBoilerAfterburningTypeRow", waste_heat_boiler_afterburning_type);
					request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", combined_circulation_aerated_water_system_pattern);
					request.setAttribute("combinedCirculationMainframeLayoutPatternRow", combined_circulation_mainframe_layout_pattern);
					request.setAttribute("factoryAreaRow", factory_area);
					request.setAttribute("waterCirculationSystemOverviewRow", water_circulation_system_overview);
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
					this.fuel_machine_project.setId(Integer.parseInt(id));
					this.fuel_machine_project.setPid(pid);
					this.fuel_machine_project.setName(name);
					this.fuel_machine_project.setType(type);
					this.fuel_machine_project.setNation(nation);
					this.fuel_machine_project.setArea(area);
					this.fuel_machine_project.setAverage_temperature(average_temperature);
					this.fuel_machine_project.setExtreme_high_temperature(extreme_high_temperature);
					this.fuel_machine_project.setExtreme_low_temperature(extreme_low_temperature);
					this.fuel_machine_project.setAverage_relative_humid(average_relative_humid);
					this.fuel_machine_project.setBarometric_pressure(barometric_pressure);
					this.fuel_machine_project.setWater_source(water_source);
					this.fuel_machine_project.setFuel_power_station_pattern(fuel_power_station_pattern);
					this.fuel_machine_project.setFuel_station_fuel_type(fuel_station_fuel_type);
					this.fuel_machine_project.setFuel_machine_level(fuel_machine_level);
					this.fuel_machine_project.setFuel_machine_version(fuel_machine_version);
					this.fuel_machine_project.setWaste_heat_boiler_circulate_type(waste_heat_boiler_circulate_type);
					this.fuel_machine_project.setWaste_heat_boiler_structure_type(waste_heat_boiler_structure_type);
					this.fuel_machine_project.setWaste_heat_boiler_afterburning_type(waste_heat_boiler_afterburning_type);
					this.fuel_machine_project.setCombined_circulation_aerated_water_system_pattern(combined_circulation_aerated_water_system_pattern);
					this.fuel_machine_project.setCombined_circulation_mainframe_layout_pattern(combined_circulation_mainframe_layout_pattern);
					this.fuel_machine_project.setFactory_area(factory_area);
					this.fuel_machine_project.setWater_circulation_system_overview(water_circulation_system_overview);
					this.fuel_machine_project.setPreparation_one(preparation_one);
					this.fuel_machine_project.setPreparation_two(preparation_two);
					this.fuel_machine_project.setPreparation_three(preparation_three);
					this.fuel_machine_project.setPreparation_four(preparation_four);
					this.fuel_machine_project.setPreparation_five(preparation_five);
					this.fuel_machine_project.setPreparation_six(preparation_six);
					this.fuel_machine_project.setPreparation_seven(preparation_seven);
					this.fuel_machine_project.setPreparation_eight(preparation_eight);
					this.fuel_machine_project.setPreparation_nine(preparation_nine);
					this.fuel_machine_project.setPreparation_ten(preparation_ten);
					this.fuel_machine_project.setEntry_time(this.date.format(new Date()));
					this.fuel_machine_project.setType_in_userNme(UserName);
					this.fuel_machine_project.setVerifier(verifier);
					this.fuel_machine_project.setVerify_state(1);
					//重设默认审核人
					this.userService.setDefaultVerifier(UserName, verifier);
					
					//for 未审核更新处理
					if(ch==null||ch==""){
						if(this.fuelMachineProjectService.update(fuel_machine_project)){
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
						request.setAttribute("nameRow", name);
						request.setAttribute("typeRow", type);
						request.setAttribute("nationRow", nation);
						request.setAttribute("areaRow", area);
						request.setAttribute("averageTemperatureRow",average_temperature);
						request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature );
						request.setAttribute("extremeLowTemperatureRow", extreme_low_temperature);
						request.setAttribute("averageRelativeHumidRow", average_relative_humid);
						request.setAttribute("barometricPressureRow", barometric_pressure);
						request.setAttribute("waterSourceRow", water_source);
						request.setAttribute("fuelPowerStationPatternRow", fuel_power_station_pattern);
						request.setAttribute("fuelStationFuelTypeRow", fuel_station_fuel_type);
						request.setAttribute("fuelMachineLevelRow", fuel_machine_level);
						request.setAttribute("fuelMachineVersionRow", fuel_machine_version);
						request.setAttribute("wasteHeatBoilerCirculateTypeRow", waste_heat_boiler_circulate_type);
						request.setAttribute("wasteHeatBoilerStructureTypeRow", waste_heat_boiler_structure_type);
						request.setAttribute("wasteHeatBoilerAfterburningTypeRow", waste_heat_boiler_afterburning_type);
						request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", combined_circulation_aerated_water_system_pattern);
						request.setAttribute("combinedCirculationMainframeLayoutPatternRow", combined_circulation_mainframe_layout_pattern);
						request.setAttribute("factoryAreaRow", factory_area);
						request.setAttribute("waterCirculationSystemOverviewRow", water_circulation_system_overview);
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
							Map[] primaryRows = this.fuelMachineProjectService.query(Integer.parseInt(id));
							for(Map m : primaryRows){
								request.setAttribute("idRow", m.get("编号"));
								request.setAttribute("pidRow", m.get("项目编号"));
								request.setAttribute("nameRow", m.get("项目名称"));
								request.setAttribute("typeRow", m.get("项目类别"));
								request.setAttribute("nationRow", m.get("项目所在国"));
								request.setAttribute("areaRow", m.get("项目所在地区"));
								request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
								request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
								request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
								request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
								request.setAttribute("barometricPressureRow", m.get("大气压"));
								request.setAttribute("waterSourceRow", m.get("水源"));
								request.setAttribute("fuelPowerStationPatternRow", m.get("燃机电站型式"));
								request.setAttribute("fuelStationFuelTypeRow", m.get("燃机电站燃料类型"));
								request.setAttribute("fuelMachineLevelRow", m.get("燃机级别"));
								request.setAttribute("fuelMachineVersionRow", m.get("燃机型号"));
								request.setAttribute("wasteHeatBoilerCirculateTypeRow", m.get("余热锅炉循环类别"));
								request.setAttribute("wasteHeatBoilerStructureTypeRow", m.get("余热锅炉结构类别"));
								request.setAttribute("wasteHeatBoilerAfterburningTypeRow", m.get("余热锅炉补燃类别"));
								request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", m.get("联合循环汽水循环系统型式"));
								request.setAttribute("combinedCirculationMainframeLayoutPatternRow", m.get("联合循环主机布置型式"));
								request.setAttribute("factoryAreaRow", m.get("厂区面积"));
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
							if(this.fuelMachineProjectService.update(fuel_machine_project)){
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
							request.setAttribute("nameRow", name);
							request.setAttribute("typeRow", type);
							request.setAttribute("nationRow", nation);
							request.setAttribute("areaRow", area);
							request.setAttribute("averageTemperatureRow",average_temperature);
							request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature );
							request.setAttribute("extremeLowTemperatureRow", extreme_low_temperature);
							request.setAttribute("averageRelativeHumidRow", average_relative_humid);
							request.setAttribute("barometricPressureRow", barometric_pressure);
							request.setAttribute("waterSourceRow", water_source);
							request.setAttribute("fuelPowerStationPatternRow", fuel_power_station_pattern);
							request.setAttribute("fuelStationFuelTypeRow", fuel_station_fuel_type);
							request.setAttribute("fuelMachineLevelRow", fuel_machine_level);
							request.setAttribute("fuelMachineVersionRow", fuel_machine_version);
							request.setAttribute("wasteHeatBoilerCirculateTypeRow", waste_heat_boiler_circulate_type);
							request.setAttribute("wasteHeatBoilerStructureTypeRow", waste_heat_boiler_structure_type);
							request.setAttribute("wasteHeatBoilerAfterburningTypeRow", waste_heat_boiler_afterburning_type);
							request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", combined_circulation_aerated_water_system_pattern);
							request.setAttribute("combinedCirculationMainframeLayoutPatternRow", combined_circulation_mainframe_layout_pattern);
							request.setAttribute("factoryAreaRow", factory_area);
							request.setAttribute("waterCirculationSystemOverviewRow", water_circulation_system_overview);
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
				request.getRequestDispatcher("fuel_machine_project_insert.jsp").forward(request, response);
				
			}
			else if(op.equals("verify")){
				request.setAttribute("op", "verify");
				if(ch!=null){
					Map[] primaryRows = this.fuelMachineProjectService.query(Integer.parseInt(ch));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
						request.setAttribute("barometricPressureRow", m.get("大气压"));
						request.setAttribute("waterSourceRow", m.get("水源"));
						request.setAttribute("fuelPowerStationPatternRow", m.get("燃机电站型式"));
						request.setAttribute("fuelStationFuelTypeRow", m.get("燃机电站燃料类型"));
						request.setAttribute("fuelMachineLevelRow", m.get("燃机级别"));
						request.setAttribute("fuelMachineVersionRow", m.get("燃机型号"));
						request.setAttribute("wasteHeatBoilerCirculateTypeRow", m.get("余热锅炉循环类别"));
						request.setAttribute("wasteHeatBoilerStructureTypeRow", m.get("余热锅炉结构类别"));
						request.setAttribute("wasteHeatBoilerAfterburningTypeRow", m.get("余热锅炉补燃类别"));
						request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", m.get("联合循环汽水循环系统型式"));
						request.setAttribute("combinedCirculationMainframeLayoutPatternRow", m.get("联合循环主机布置型式"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
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
					request.getRequestDispatcher("fuel_machine_project_insert.jsp").forward(request, response);
				}
				else{//审核
					String id = request.getParameter("id");
					this.fuel_machine_project.setId(Integer.parseInt(id));
					this.fuel_machine_project.setPid(pid);
					this.fuel_machine_project.setName(name);
					this.fuel_machine_project.setType(type);
					this.fuel_machine_project.setNation(nation);
					this.fuel_machine_project.setArea(area);
					this.fuel_machine_project.setAverage_temperature(average_temperature);
					this.fuel_machine_project.setExtreme_high_temperature(extreme_high_temperature);
					this.fuel_machine_project.setExtreme_low_temperature(extreme_low_temperature);
					this.fuel_machine_project.setAverage_relative_humid(average_relative_humid);
					this.fuel_machine_project.setBarometric_pressure(barometric_pressure);
					this.fuel_machine_project.setWater_source(water_source);
					this.fuel_machine_project.setFuel_power_station_pattern(fuel_power_station_pattern);
					this.fuel_machine_project.setFuel_station_fuel_type(fuel_station_fuel_type);
					this.fuel_machine_project.setFuel_machine_level(fuel_machine_level);
					this.fuel_machine_project.setFuel_machine_version(fuel_machine_version);
					this.fuel_machine_project.setWaste_heat_boiler_circulate_type(waste_heat_boiler_circulate_type);
					this.fuel_machine_project.setWaste_heat_boiler_structure_type(waste_heat_boiler_structure_type);
					this.fuel_machine_project.setWaste_heat_boiler_afterburning_type(waste_heat_boiler_afterburning_type);
					this.fuel_machine_project.setCombined_circulation_aerated_water_system_pattern(combined_circulation_aerated_water_system_pattern);
					this.fuel_machine_project.setCombined_circulation_mainframe_layout_pattern(combined_circulation_mainframe_layout_pattern);
					this.fuel_machine_project.setFactory_area(factory_area);
					this.fuel_machine_project.setWater_circulation_system_overview(water_circulation_system_overview);
					this.fuel_machine_project.setPreparation_one(preparation_one);
					this.fuel_machine_project.setPreparation_two(preparation_two);
					this.fuel_machine_project.setPreparation_three(preparation_three);
					this.fuel_machine_project.setPreparation_four(preparation_four);
					this.fuel_machine_project.setPreparation_five(preparation_five);
					this.fuel_machine_project.setPreparation_six(preparation_six);
					this.fuel_machine_project.setPreparation_seven(preparation_seven);
					this.fuel_machine_project.setPreparation_eight(preparation_eight);
					this.fuel_machine_project.setPreparation_nine(preparation_nine);
					this.fuel_machine_project.setPreparation_ten(preparation_ten);
					this.fuel_machine_project.setVerify_time(this.date.format(new Date()));
					this.fuel_machine_project.setVerify_comment(verify_comment);
					if(se!=null){
						if(se.equals("1")){
							this.fuel_machine_project.setVerify_state(2);
						}
						else if(se.equals("-1")){
							this.fuel_machine_project.setVerify_state(-1);
						}
					}
					//填充
					request.setAttribute("idRow", Integer.parseInt(id));
					request.setAttribute("pidRow", pid);
					request.setAttribute("nameRow", name);
					request.setAttribute("typeRow", type);
					request.setAttribute("nationRow", nation);
					request.setAttribute("areaRow", area);
					request.setAttribute("averageTemperatureRow",average_temperature);
					request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature );
					request.setAttribute("extremeLowTemperatureRow", extreme_low_temperature);
					request.setAttribute("averageRelativeHumidRow", average_relative_humid);
					request.setAttribute("barometricPressureRow", barometric_pressure);
					request.setAttribute("waterSourceRow", water_source);
					request.setAttribute("fuelPowerStationPatternRow", fuel_power_station_pattern);
					request.setAttribute("fuelStationFuelTypeRow", fuel_station_fuel_type);
					request.setAttribute("fuelMachineLevelRow", fuel_machine_level);
					request.setAttribute("fuelMachineVersionRow", fuel_machine_version);
					request.setAttribute("wasteHeatBoilerCirculateTypeRow", waste_heat_boiler_circulate_type);
					request.setAttribute("wasteHeatBoilerStructureTypeRow", waste_heat_boiler_structure_type);
					request.setAttribute("wasteHeatBoilerAfterburningTypeRow", waste_heat_boiler_afterburning_type);
					request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", combined_circulation_aerated_water_system_pattern);
					request.setAttribute("combinedCirculationMainframeLayoutPatternRow", combined_circulation_mainframe_layout_pattern);
					request.setAttribute("factoryAreaRow", factory_area);
					request.setAttribute("waterCirculationSystemOverviewRow", water_circulation_system_overview);
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
					if(this.fuelMachineProjectService.verify(fuel_machine_project)){
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
					request.getRequestDispatcher("fuel_machine_project_insert.jsp").forward(request, response);
				}
			}
			else if(op.equals("save")){
				request.setAttribute("op","save");
				String id = request.getParameter("id");
				this.fuel_machine_project.setPid(pid);
				this.fuel_machine_project.setName(name);
				this.fuel_machine_project.setType(type);
				this.fuel_machine_project.setNation(nation);
				this.fuel_machine_project.setArea(area);
				this.fuel_machine_project.setAverage_temperature(average_temperature);
				this.fuel_machine_project.setExtreme_high_temperature(extreme_high_temperature);
				this.fuel_machine_project.setExtreme_low_temperature(extreme_low_temperature);
				this.fuel_machine_project.setAverage_relative_humid(average_relative_humid);
				this.fuel_machine_project.setBarometric_pressure(barometric_pressure);
				this.fuel_machine_project.setWater_source(water_source);
				this.fuel_machine_project.setFuel_power_station_pattern(fuel_power_station_pattern);
				this.fuel_machine_project.setFuel_station_fuel_type(fuel_station_fuel_type);
				this.fuel_machine_project.setFuel_machine_level(fuel_machine_level);
				this.fuel_machine_project.setFuel_machine_version(fuel_machine_version);
				this.fuel_machine_project.setWaste_heat_boiler_circulate_type(waste_heat_boiler_circulate_type);
				this.fuel_machine_project.setWaste_heat_boiler_structure_type(waste_heat_boiler_structure_type);
				this.fuel_machine_project.setWaste_heat_boiler_afterburning_type(waste_heat_boiler_afterburning_type);
				this.fuel_machine_project.setCombined_circulation_aerated_water_system_pattern(combined_circulation_aerated_water_system_pattern);
				this.fuel_machine_project.setCombined_circulation_mainframe_layout_pattern(combined_circulation_mainframe_layout_pattern);
				this.fuel_machine_project.setFactory_area(factory_area);
				this.fuel_machine_project.setWater_circulation_system_overview(water_circulation_system_overview);
				this.fuel_machine_project.setPreparation_one(preparation_one);
				this.fuel_machine_project.setPreparation_two(preparation_two);
				this.fuel_machine_project.setPreparation_three(preparation_three);
				this.fuel_machine_project.setPreparation_four(preparation_four);
				this.fuel_machine_project.setPreparation_five(preparation_five);
				this.fuel_machine_project.setPreparation_six(preparation_six);
				this.fuel_machine_project.setPreparation_seven(preparation_seven);
				this.fuel_machine_project.setPreparation_eight(preparation_eight);
				this.fuel_machine_project.setPreparation_nine(preparation_nine);
				this.fuel_machine_project.setPreparation_ten(preparation_ten);
				this.fuel_machine_project.setVerify_state(0);
				this.fuel_machine_project.setEntry_time(this.date.format(new Date()));
				this.fuel_machine_project.setVerifier(verifier);
				this.fuel_machine_project.setType_in_userNme(UserName);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				
				if(id==null||id==""){
					if(this.fuelMachineProjectService.isSubmit(pid)){
						request.setAttribute("msg", "<script>alert('已存在相应相同编号记录，请修改项目编号后提交！')</script>");
					}
					else{
						this.fuelMachineProjectService.add(fuel_machine_project);
						request.setAttribute("idRow", this.fuelMachineProjectService.getId(pid, 0));
						request.setAttribute("msg", "<script>alert('保存成功！')</script>");
						//添加入系统日志
						this.log.setOperation("保存");
						this.logService.add(log);
					}
					request.setAttribute("pidRow", pid);
					request.setAttribute("nameRow", name);
					request.setAttribute("typeRow", type);
					request.setAttribute("nationRow", nation);
					request.setAttribute("areaRow", area);
					request.setAttribute("averageTemperatureRow",average_temperature);
					request.setAttribute("extremeHighTemperatureRow",extreme_high_temperature );
					request.setAttribute("extremeLowTemperatureRow", extreme_low_temperature);
					request.setAttribute("averageRelativeHumidRow", average_relative_humid);
					request.setAttribute("barometricPressureRow", barometric_pressure);
					request.setAttribute("waterSourceRow", water_source);
					request.setAttribute("fuelPowerStationPatternRow", fuel_power_station_pattern);
					request.setAttribute("fuelStationFuelTypeRow", fuel_station_fuel_type);
					request.setAttribute("fuelMachineLevelRow", fuel_machine_level);
					request.setAttribute("fuelMachineVersionRow", fuel_machine_version);
					request.setAttribute("wasteHeatBoilerCirculateTypeRow", waste_heat_boiler_circulate_type);
					request.setAttribute("wasteHeatBoilerStructureTypeRow", waste_heat_boiler_structure_type);
					request.setAttribute("wasteHeatBoilerAfterburningTypeRow", waste_heat_boiler_afterburning_type);
					request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", combined_circulation_aerated_water_system_pattern);
					request.setAttribute("combinedCirculationMainframeLayoutPatternRow", combined_circulation_mainframe_layout_pattern);
					request.setAttribute("factoryAreaRow", factory_area);
					request.setAttribute("waterCirculationSystemOverviewRow", water_circulation_system_overview);
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
					this.fuel_machine_project.setId(Integer.parseInt(id));
					//填充
					Map[] primaryRows = this.fuelMachineProjectService.query(Integer.parseInt(id));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
						request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
						request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
						request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
						request.setAttribute("barometricPressureRow", m.get("大气压"));
						request.setAttribute("waterSourceRow", m.get("水源"));
						request.setAttribute("fuelPowerStationPatternRow", m.get("燃机电站型式"));
						request.setAttribute("fuelStationFuelTypeRow", m.get("燃机电站燃料类型"));
						request.setAttribute("fuelMachineLevelRow", m.get("燃机级别"));
						request.setAttribute("fuelMachineVersionRow", m.get("燃机型号"));
						request.setAttribute("wasteHeatBoilerCirculateTypeRow", m.get("余热锅炉循环类别"));
						request.setAttribute("wasteHeatBoilerStructureTypeRow", m.get("余热锅炉结构类别"));
						request.setAttribute("wasteHeatBoilerAfterburningTypeRow", m.get("余热锅炉补燃类别"));
						request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", m.get("联合循环汽水循环系统型式"));
						request.setAttribute("combinedCirculationMainframeLayoutPatternRow", m.get("联合循环主机布置型式"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
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
					if(this.fuelMachineProjectService.update(fuel_machine_project)){
						//添加入系统日志
						this.log.setOperation("保存");
						this.logService.add(log);
						request.setAttribute("msg", "<script>alert('更新成功！')</script>");
					}
					else {
						request.setAttribute("msg", "<script>alert('更新失败！')</script>");
					}
				}
				request.getRequestDispatcher("fuel_machine_project_insert.jsp").forward(request, response);
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
						this.fuel_machine_project.setId(Integer.parseInt(id));
						this.fuel_machine_project.setPid(pid);
						this.fuel_machine_project.setName(name);
						this.fuel_machine_project.setType(type);
						this.fuel_machine_project.setNation(nation);
						this.fuel_machine_project.setArea(area);
						this.fuel_machine_project.setAverage_temperature(average_temperature);
						this.fuel_machine_project.setExtreme_high_temperature(extreme_high_temperature);
						this.fuel_machine_project.setExtreme_low_temperature(extreme_low_temperature);
						this.fuel_machine_project.setAverage_relative_humid(average_relative_humid);
						this.fuel_machine_project.setBarometric_pressure(barometric_pressure);
						this.fuel_machine_project.setWater_source(water_source);
						this.fuel_machine_project.setFuel_power_station_pattern(fuel_power_station_pattern);
						this.fuel_machine_project.setFuel_station_fuel_type(fuel_station_fuel_type);
						this.fuel_machine_project.setFuel_machine_level(fuel_machine_level);
						this.fuel_machine_project.setFuel_machine_version(fuel_machine_version);
						this.fuel_machine_project.setWaste_heat_boiler_circulate_type(waste_heat_boiler_circulate_type);
						this.fuel_machine_project.setWaste_heat_boiler_structure_type(waste_heat_boiler_structure_type);
						this.fuel_machine_project.setWaste_heat_boiler_afterburning_type(waste_heat_boiler_afterburning_type);
						this.fuel_machine_project.setCombined_circulation_aerated_water_system_pattern(combined_circulation_aerated_water_system_pattern);
						this.fuel_machine_project.setCombined_circulation_mainframe_layout_pattern(combined_circulation_mainframe_layout_pattern);
						this.fuel_machine_project.setFactory_area(factory_area);
						this.fuel_machine_project.setWater_circulation_system_overview(water_circulation_system_overview);
						this.fuel_machine_project.setPreparation_one(preparation_one);
						this.fuel_machine_project.setPreparation_two(preparation_two);
						this.fuel_machine_project.setPreparation_three(preparation_three);
						this.fuel_machine_project.setPreparation_four(preparation_four);
						this.fuel_machine_project.setPreparation_five(preparation_five);
						this.fuel_machine_project.setPreparation_six(preparation_six);
						this.fuel_machine_project.setPreparation_seven(preparation_seven);
						this.fuel_machine_project.setPreparation_eight(preparation_eight);
						this.fuel_machine_project.setPreparation_nine(preparation_nine);
						this.fuel_machine_project.setPreparation_ten(preparation_ten);
						this.fuel_machine_project.setVerifier(verifier);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.fuelMachineProjectService.maintenance(fuel_machine_project)){
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
				Map[] primaryRows = this.fuelMachineProjectService.query(Integer.parseInt(id));
				for(Map m : primaryRows){
					request.setAttribute("idRow", m.get("编号"));
					request.setAttribute("pidRow", m.get("项目编号"));
					request.setAttribute("nameRow", m.get("项目名称"));
					request.setAttribute("typeRow", m.get("项目类别"));
					request.setAttribute("nationRow", m.get("项目所在国"));
					request.setAttribute("areaRow", m.get("项目所在地区"));
					request.setAttribute("averageTemperatureRow", m.get("年平均气温"));
					request.setAttribute("extremeHighTemperatureRow", m.get("极端最高气温"));
					request.setAttribute("extremeLowTemperatureRow", m.get("极端最低气温"));
					request.setAttribute("averageRelativeHumidRow", m.get("平均相对湿度"));
					request.setAttribute("barometricPressureRow", m.get("大气压"));
					request.setAttribute("waterSourceRow", m.get("水源"));
					request.setAttribute("fuelPowerStationPatternRow", m.get("燃机电站型式"));
					request.setAttribute("fuelStationFuelTypeRow", m.get("燃机电站燃料类型"));
					request.setAttribute("fuelMachineLevelRow", m.get("燃机级别"));
					request.setAttribute("fuelMachineVersionRow", m.get("燃机型号"));
					request.setAttribute("wasteHeatBoilerCirculateTypeRow", m.get("余热锅炉循环类别"));
					request.setAttribute("wasteHeatBoilerStructureTypeRow", m.get("余热锅炉结构类别"));
					request.setAttribute("wasteHeatBoilerAfterburningTypeRow", m.get("余热锅炉补燃类别"));
					request.setAttribute("combinedCirculationAeratedWaterSystemPatternRow", m.get("联合循环汽水循环系统型式"));
					request.setAttribute("combinedCirculationMainframeLayoutPatternRow", m.get("联合循环主机布置型式"));
					request.setAttribute("factoryAreaRow", m.get("厂区面积"));
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
				request.getRequestDispatcher("fuel_machine_project_insert.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "<script>alert('非法访问，无相应参数！')</script>");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
	}

}
