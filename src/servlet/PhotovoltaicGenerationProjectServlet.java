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
import pojo.Log;
import pojo.MyFile;
import pojo.Photovoltaic_generation_project;
import service.FieldMaintenanceServiceImpl;
import service.FileService;
import service.IFieldMaintenanceService;
import service.ILogService;
import service.IPhotovoltaicGenerationProjectService;
import service.IUserService;
import service.LogServiceImpl;
import service.PhotovoltaicGenerationProjectServiceImpl;
import service.UserServiceImpl;

/**
 * Servlet implementation class PhotovoltaicGenerationProjectServlet
 */
@SuppressWarnings("rawtypes")
public class PhotovoltaicGenerationProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Photovoltaic_generation_project photovoltaic_generation_project = new Photovoltaic_generation_project();
    private IPhotovoltaicGenerationProjectService photovoltaicGenerationProjectService = new PhotovoltaicGenerationProjectServiceImpl();
    private IUserService userService = new UserServiceImpl();
    private IFieldMaintenanceService fieldMaintenanceService = new FieldMaintenanceServiceImpl();
    private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
	FileService fileService=new FileService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotovoltaicGenerationProjectServlet() {
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
			String total_capacity = request.getParameter("total_capacity");
			String sunshine_duration = request.getParameter("sunshine_duration");
			String total_solar_radiation = request.getParameter("total_solar_radiation");
			String power_supply_type = request.getParameter("power_supply_type");
			String building_type = request.getParameter("building_type");
			String running_mode = request.getParameter("running_mode");
			String battery_type = request.getParameter("battery_type");
			String factory_area = request.getParameter("factory_area");
			String preparation_one = request.getParameter("preparation_one");
			String preparation_two = request.getParameter("preparation_two");
			String preparation_three = request.getParameter("preparation_three");
			String preparation_four = request.getParameter("preparation_four");
			String preparation_five = request.getParameter("preparation_five");
			String verifier = request.getParameter("verifier");
			String verify_comment = request.getParameter("verify_comment");
			//默认select选项
			Map[] typeRows = this.photovoltaicGenerationProjectService.getDefaultTypeRows();
			Map[] nationRows = this.photovoltaicGenerationProjectService.getDefaultNationRows();
			Map[] totalCapacityRows = this.photovoltaicGenerationProjectService.getDefaultTotalCapacityRows();
			Map[] powerSupplyTypeRows = this.photovoltaicGenerationProjectService.getDefaultPowerSupplyTypeRows();
			Map[] buildingTypeRows = this.photovoltaicGenerationProjectService.getDefaultBuildingTypeRows();
			Map[] runningModeRows = this.photovoltaicGenerationProjectService.getDefaultRunningModeRows();
			Map[] batteryTypeRows = this.photovoltaicGenerationProjectService.getDefaultBatteryTypeRows();
			Map[] verifierRows = this.userService.getDefaultVerifierRows();
			Map[] preparationOneRows = this.photovoltaicGenerationProjectService.getDefaultPreparationOneRows();
			Map[] preparationTwoRows = this.photovoltaicGenerationProjectService.getDefaultPreparationTwoRows();
			Map[] preparationThreeRows = this.photovoltaicGenerationProjectService.getDefaultPreparationThreeRows();
			Map[] preparationFourRows = this.photovoltaicGenerationProjectService.getDefaultPreparationFourRows();
			Map[] preparationFiveRows = this.photovoltaicGenerationProjectService.getDefaultPreparationFiveRows();
			request.setAttribute("typeRows",typeRows);
			request.setAttribute("nationRows",nationRows);
			request.setAttribute("totalCapacityRows",totalCapacityRows);
			request.setAttribute("powerSupplyTypeRows",powerSupplyTypeRows);
			request.setAttribute("buildingTypeRows",buildingTypeRows);
			request.setAttribute("runningModeRows",runningModeRows);
			request.setAttribute("batteryTypeRows",batteryTypeRows);
			request.setAttribute("verifierRows",verifierRows);
			request.setAttribute("preparationOneRows",preparationOneRows);
			request.setAttribute("preparationTwoRows",preparationTwoRows);
			request.setAttribute("preparationThreeRows",preparationThreeRows);
			request.setAttribute("preparationFourRows",preparationFourRows);
			request.setAttribute("preparationFiveRows",preparationFiveRows);
			request.setAttribute("pageName", "photovoltaic_generation_project");//pageName for page dispatcher
			//add log
			this.log.setUname(UserName);
			this.log.setTable("光伏发电项目");
			this.log.setTime(this.date.format(new Date()));
			//设置初始审核人
			request.setAttribute("verifierRow", this.userService.getDefaultVerifier(UserName));
			//预留字段是否启用
			int isPreparationOneUsed = this.fieldMaintenanceService.isUse("光伏发电项目","预留一");
			int isPreparationTwoUsed = this.fieldMaintenanceService.isUse("光伏发电项目","预留二");
			int isPreparationThreeUsed = this.fieldMaintenanceService.isUse("光伏发电项目","预留三");
			int isPreparationFourUsed = this.fieldMaintenanceService.isUse("光伏发电项目","预留四");
			int isPreparationFiveUsed = this.fieldMaintenanceService.isUse("光伏发电项目","预留五");
			request.setAttribute("isPreparationOneUsed", isPreparationOneUsed);
			request.setAttribute("isPreparationTwoUsed", isPreparationTwoUsed);
			request.setAttribute("isPreparationThreeUsed", isPreparationThreeUsed);
			request.setAttribute("isPreparationFourUsed", isPreparationFourUsed);
			request.setAttribute("isPreparationFiveUsed", isPreparationFiveUsed);
			//获取预留字段新名称
			String preparationOneNewName = this.fieldMaintenanceService.getNewName("光伏发电项目","预留一");
			String preparationTwoNewName = this.fieldMaintenanceService.getNewName("光伏发电项目","预留二");
			String preparationThreeNewName = this.fieldMaintenanceService.getNewName("光伏发电项目","预留三");
			String preparationFourNewName = this.fieldMaintenanceService.getNewName("光伏发电项目","预留四");
			String preparationFiveNewName = this.fieldMaintenanceService.getNewName("光伏发电项目","预留五");
			request.setAttribute("preparationOneNewName", preparationOneNewName);
			request.setAttribute("preparationTwoNewName", preparationTwoNewName);
			request.setAttribute("preparationThreeNewName", preparationThreeNewName);
			request.setAttribute("preparationFourNewName", preparationFourNewName);
			request.setAttribute("preparationFiveNewName", preparationFiveNewName);
			if(op.equals("insert")){
				request.setAttribute("op","insert");
				if(this.photovoltaicGenerationProjectService.hasSave(UserName)){
					Map[] primaryRows = this.photovoltaicGenerationProjectService.primaryQuery(UserName);
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("totalCapacityRow", m.get("总容量"));
						request.setAttribute("sunshineDurationRow", m.get("日照时间"));
						request.setAttribute("totalSolarRadiationRow", m.get("太阳总辐射"));
						request.setAttribute("powerSupplyTypeRow", m.get("供电类型"));
						request.setAttribute("buildingTypeRow", m.get("建筑类型"));
						request.setAttribute("runningModeRow", m.get("运行方式"));
						request.setAttribute("batteryTypeRow", m.get("电池类型"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
						request.setAttribute("verifierRow", m.get("审核人"));
						
					}
					request.setAttribute("op", "update");
					request.getRequestDispatcher("photovoltaic_generation_project_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("photovoltaic_generation_project_insert.jsp").forward(request, response);
				}
				
			}
			else if(op.equals("add")){
				request.setAttribute("op","insert");
				this.photovoltaic_generation_project.setPid(pid);
				this.photovoltaic_generation_project.setName(name);
				this.photovoltaic_generation_project.setType(type);
				this.photovoltaic_generation_project.setNation(nation);
				this.photovoltaic_generation_project.setArea(area);
				this.photovoltaic_generation_project.setTotal_capacity(total_capacity);
				this.photovoltaic_generation_project.setSunshine_duration(sunshine_duration);
				this.photovoltaic_generation_project.setTotal_solar_radiation(total_solar_radiation);
				this.photovoltaic_generation_project.setPower_supply_type(power_supply_type);
				this.photovoltaic_generation_project.setBuilding_type(building_type);
				this.photovoltaic_generation_project.setRunning_mode(running_mode);
				this.photovoltaic_generation_project.setBattery_type(battery_type);
				this.photovoltaic_generation_project.setFactory_area(factory_area);
				this.photovoltaic_generation_project.setPreparation_one(preparation_one);
				this.photovoltaic_generation_project.setPreparation_two(preparation_two);
				this.photovoltaic_generation_project.setPreparation_three(preparation_three);
				this.photovoltaic_generation_project.setPreparation_four(preparation_four);
				this.photovoltaic_generation_project.setPreparation_five(preparation_five);
				this.photovoltaic_generation_project.setEntry_time(this.date.format(new Date()));
				this.photovoltaic_generation_project.setType_in_userNme(UserName);
				this.photovoltaic_generation_project.setVerifier(verifier);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				request.setAttribute("pidRow",pid);
				request.setAttribute("nameRow",name);
				request.setAttribute("typeRow",type);
				request.setAttribute("nationRow",nation);
				request.setAttribute("areaRow",area);
				request.setAttribute("totalCapacityRow",total_capacity);
				request.setAttribute("sunshineDurationRow",sunshine_duration);
				request.setAttribute("totalSolarRadiationRow",total_solar_radiation);
				request.setAttribute("powerSupplyTypeRow",power_supply_type);
				request.setAttribute("buildingTypeRow",building_type);
				request.setAttribute("runningModeRow",running_mode);
				request.setAttribute("batteryTypeRow",battery_type);
				request.setAttribute("factoryAreaRow",factory_area);
				request.setAttribute("preparationOneRows",preparationOneRows);
				request.setAttribute("preparationTwoRows",preparationTwoRows);
				request.setAttribute("preparationThreeRows",preparationThreeRows);
				request.setAttribute("preparationFourRows",preparationFourRows);
				request.setAttribute("preparationFiveRows",preparationFiveRows);
				request.setAttribute("verifierRow", verifier);
				if(this.photovoltaicGenerationProjectService.isSubmit(pid)){
					if(this.photovoltaicGenerationProjectService.isSave(pid)){
						request.setAttribute("msg", "<script>alert('已存在相同编号保存记录,无法继续保存第二条具有相同编号的记录,请核实并修改项目编号！')</script>");
					}
					else{
						if(this.photovoltaicGenerationProjectService.hasSave(UserName)){
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，并且您已有一条保存记录了,无法继续保存第二条的记录,请核实并修改项目编号！')</script>");
						}
						else {
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，请核实项目编号后提交！')</script>");
						}
					}
				}
				else{
					this.photovoltaic_generation_project.setVerify_state(1);
					if(this.photovoltaicGenerationProjectService.add(photovoltaic_generation_project)){
						Map[] primaryRows = this.photovoltaicGenerationProjectService.query(this.photovoltaicGenerationProjectService.getId(pid, 1));
						for(Map m : primaryRows){
							request.setAttribute("idRow", m.get("编号"));
							request.setAttribute("pidRow", m.get("项目编号"));
							request.setAttribute("nameRow", m.get("项目名称"));
							request.setAttribute("typeRow", m.get("项目类别"));
							request.setAttribute("nationRow", m.get("项目所在国"));
							request.setAttribute("areaRow", m.get("项目所在地区"));
							request.setAttribute("totalCapacityRow", m.get("总容量"));
							request.setAttribute("sunshineDurationRow", m.get("日照时间"));
							request.setAttribute("totalSolarRadiationRow", m.get("太阳总辐射"));
							request.setAttribute("powerSupplyTypeRow", m.get("供电类型"));
							request.setAttribute("buildingTypeRow", m.get("建筑类型"));
							request.setAttribute("runningModeRow", m.get("运行方式"));
							request.setAttribute("batteryTypeRow", m.get("电池类型"));
							request.setAttribute("factoryAreaRow", m.get("厂区面积"));
							request.setAttribute("preparationOneRow", m.get("预留一"));
							request.setAttribute("preparationTwoRow", m.get("预留二"));
							request.setAttribute("preparationThreeRow", m.get("预留三"));
							request.setAttribute("preparationFourRow", m.get("预留四"));
							request.setAttribute("preparationFiveRow", m.get("预留五"));
							request.setAttribute("verifierRow", m.get("审核人"));
							
						}
						request.setAttribute("msg", "<script>alert('提交成功！')</script>");
						
					}
					else{
						request.setAttribute("msg", "<script>alert('提交失败！')</script>");
					}
				}
				request.setAttribute("op","update");
				request.getRequestDispatcher("photovoltaic_generation_project_insert.jsp").forward(request, response);
			}
			else if(op.equals("query")){
				request.setAttribute("op", "query");
				this.photovoltaic_generation_project.setPid(pid);
				this.photovoltaic_generation_project.setName(name);
				this.photovoltaic_generation_project.setType(type);
				this.photovoltaic_generation_project.setNation(nation);
				this.photovoltaic_generation_project.setArea(area);
				this.photovoltaic_generation_project.setTotal_capacity(total_capacity);
				this.photovoltaic_generation_project.setSunshine_duration(sunshine_duration);
				this.photovoltaic_generation_project.setTotal_solar_radiation(total_solar_radiation);
				this.photovoltaic_generation_project.setPower_supply_type(power_supply_type);
				this.photovoltaic_generation_project.setBuilding_type(building_type);
				this.photovoltaic_generation_project.setRunning_mode(running_mode);
				this.photovoltaic_generation_project.setBattery_type(battery_type);
				this.photovoltaic_generation_project.setFactory_area(factory_area);
				this.photovoltaic_generation_project.setPreparation_one(preparation_one);
				this.photovoltaic_generation_project.setPreparation_two(preparation_two);
				this.photovoltaic_generation_project.setPreparation_three(preparation_three);
				this.photovoltaic_generation_project.setPreparation_four(preparation_four);
				this.photovoltaic_generation_project.setPreparation_five(preparation_five);
				Map[] rows = this.photovoltaicGenerationProjectService.query(photovoltaic_generation_project);
				//添加入系统日志
				this.log.setOperation("查询");
				this.logService.add(log);
				request.setAttribute("rows", rows);
				if(ch!=null){
					String id = request.getParameter("id");
					Map[] primaryRows = this.photovoltaicGenerationProjectService.query(Integer.parseInt(id.toString()));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("totalCapacityRow", m.get("总容量"));
						request.setAttribute("sunshineDurationRow", m.get("日照时间"));
						request.setAttribute("totalSolarRadiationRow", m.get("太阳总辐射"));
						request.setAttribute("powerSupplyTypeRow", m.get("供电类型"));
						request.setAttribute("buildingTypeRow", m.get("建筑类型"));
						request.setAttribute("runningModeRow", m.get("运行方式"));
						request.setAttribute("batteryTypeRow", m.get("电池类型"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
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
					}
					else{}
					request.getRequestDispatcher("photovoltaic_generation_project_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("photovoltaic_generation_project_query.jsp").forward(request, response);
				}
			}
			else if(op.equals("update")){
				request.setAttribute("op", "update");
				String id = request.getParameter("id");
				if(this.photovoltaicGenerationProjectService.isSubmit(pid)){
					if(this.photovoltaicGenerationProjectService.isSave(pid)){
						this.photovoltaic_generation_project.setId(Integer.parseInt(id));
						//System.out.println(id+" 22 "+this.photovoltaic_generation_project.getId());
						this.photovoltaic_generation_project.setPid(pid);
						this.photovoltaic_generation_project.setName(name);
						this.photovoltaic_generation_project.setType(type);
						this.photovoltaic_generation_project.setNation(nation);
						this.photovoltaic_generation_project.setArea(area);
						this.photovoltaic_generation_project.setTotal_capacity(total_capacity);
						this.photovoltaic_generation_project.setSunshine_duration(sunshine_duration);
						this.photovoltaic_generation_project.setTotal_solar_radiation(total_solar_radiation);
						this.photovoltaic_generation_project.setPower_supply_type(power_supply_type);
						this.photovoltaic_generation_project.setBuilding_type(building_type);
						this.photovoltaic_generation_project.setRunning_mode(running_mode);
						this.photovoltaic_generation_project.setBattery_type(battery_type);
						this.photovoltaic_generation_project.setFactory_area(factory_area);
						this.photovoltaic_generation_project.setPreparation_one(preparation_one);
						this.photovoltaic_generation_project.setPreparation_two(preparation_two);
						this.photovoltaic_generation_project.setPreparation_three(preparation_three);
						this.photovoltaic_generation_project.setPreparation_four(preparation_four);
						this.photovoltaic_generation_project.setPreparation_five(preparation_five);
						this.photovoltaic_generation_project.setEntry_time(this.date.format(new Date()));
						this.photovoltaic_generation_project.setType_in_userNme(UserName);
						this.photovoltaic_generation_project.setVerifier(verifier);
						this.photovoltaic_generation_project.setVerify_state(1);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.photovoltaicGenerationProjectService.update(photovoltaic_generation_project)){
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
					request.setAttribute("totalCapacityRow",total_capacity);
					request.setAttribute("sunshineDurationRow",sunshine_duration);
					request.setAttribute("totalSolarRadiationRow",total_solar_radiation);
					request.setAttribute("powerSupplyTypeRow",power_supply_type);
					request.setAttribute("buildingTypeRow",building_type);
					request.setAttribute("runningModeRow",running_mode);
					request.setAttribute("batteryTypeRow",battery_type);
					request.setAttribute("factoryAreaRow",factory_area);
					request.setAttribute("preparationOneRow",preparation_one);
					request.setAttribute("preparationTwoRow",preparation_two);
					request.setAttribute("preparationThreeRow",preparation_three);
					request.setAttribute("preparationFourRow",preparation_four);
					request.setAttribute("preparationFiveRow",preparation_five);
					request.setAttribute("verifierRow", verifier);
					
				}
				else{
					this.photovoltaic_generation_project.setId(Integer.parseInt(id));
					this.photovoltaic_generation_project.setPid(pid);
					this.photovoltaic_generation_project.setName(name);
					this.photovoltaic_generation_project.setType(type);
					this.photovoltaic_generation_project.setNation(nation);
					this.photovoltaic_generation_project.setArea(area);
					this.photovoltaic_generation_project.setTotal_capacity(total_capacity);
					this.photovoltaic_generation_project.setSunshine_duration(sunshine_duration);
					this.photovoltaic_generation_project.setTotal_solar_radiation(total_solar_radiation);
					this.photovoltaic_generation_project.setPower_supply_type(power_supply_type);
					this.photovoltaic_generation_project.setBuilding_type(building_type);
					this.photovoltaic_generation_project.setRunning_mode(running_mode);
					this.photovoltaic_generation_project.setBattery_type(battery_type);
					this.photovoltaic_generation_project.setFactory_area(factory_area);
					this.photovoltaic_generation_project.setPreparation_one(preparation_one);
					this.photovoltaic_generation_project.setPreparation_two(preparation_two);
					this.photovoltaic_generation_project.setPreparation_three(preparation_three);
					this.photovoltaic_generation_project.setPreparation_four(preparation_four);
					this.photovoltaic_generation_project.setPreparation_five(preparation_five);
					this.photovoltaic_generation_project.setEntry_time(this.date.format(new Date()));
					this.photovoltaic_generation_project.setType_in_userNme(UserName);
					this.photovoltaic_generation_project.setVerifier(verifier);
					this.photovoltaic_generation_project.setVerify_state(1);
					//重设默认审核人
					this.userService.setDefaultVerifier(UserName, verifier);
					
					//for 未审核更新处理
					if(ch==null||ch==""){
						if(this.photovoltaicGenerationProjectService.update(photovoltaic_generation_project)){
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
						request.setAttribute("totalCapacityRow",total_capacity);
						request.setAttribute("sunshineDurationRow",sunshine_duration);
						request.setAttribute("totalSolarRadiationRow",total_solar_radiation);
						request.setAttribute("powerSupplyTypeRow",power_supply_type);
						request.setAttribute("buildingTypeRow",building_type);
						request.setAttribute("runningModeRow",running_mode);
						request.setAttribute("batteryTypeRow",battery_type);
						request.setAttribute("factoryAreaRow",factory_area);
						request.setAttribute("preparationOneRow",preparation_one);
						request.setAttribute("preparationTwoRow",preparation_two);
						request.setAttribute("preparationThreeRow",preparation_three);
						request.setAttribute("preparationFourRow",preparation_four);
						request.setAttribute("preparationFiveRow",preparation_five);
						request.setAttribute("verifierRow", verifier);
					}
					else{
						if(ch.equals("unpass")){
							Map[] primaryRows = this.photovoltaicGenerationProjectService.query(Integer.parseInt(id));
							for(Map m : primaryRows){
								request.setAttribute("idRow", m.get("编号"));
								request.setAttribute("pidRow", m.get("项目编号"));
								request.setAttribute("nameRow", m.get("项目名称"));
								request.setAttribute("typeRow", m.get("项目类别"));
								request.setAttribute("nationRow", m.get("项目所在国"));
								request.setAttribute("areaRow", m.get("项目所在地区"));
								request.setAttribute("totalCapacityRow", m.get("总容量"));
								request.setAttribute("sunshineDurationRow", m.get("日照时间"));
								request.setAttribute("totalSolarRadiationRow", m.get("太阳总辐射"));
								request.setAttribute("powerSupplyTypeRow", m.get("供电类型"));
								request.setAttribute("buildingTypeRow", m.get("建筑类型"));
								request.setAttribute("runningModeRow", m.get("运行方式"));
								request.setAttribute("batteryTypeRow", m.get("电池类型"));
								request.setAttribute("factoryAreaRow", m.get("厂区面积"));
								request.setAttribute("preparationOneRow", m.get("预留一"));
								request.setAttribute("preparationTwoRow", m.get("预留二"));
								request.setAttribute("preparationThreeRow", m.get("预留三"));
								request.setAttribute("preparationFourRow", m.get("预留四"));
								request.setAttribute("preparationFiveRow", m.get("预留五"));
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
							if(this.photovoltaicGenerationProjectService.update(photovoltaic_generation_project)){
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
							request.setAttribute("totalCapacityRow",total_capacity);
							request.setAttribute("sunshineDurationRow",sunshine_duration);
							request.setAttribute("totalSolarRadiationRow",total_solar_radiation);
							request.setAttribute("powerSupplyTypeRow",power_supply_type);
							request.setAttribute("buildingTypeRow",building_type);
							request.setAttribute("runningModeRow",running_mode);
							request.setAttribute("batteryTypeRow",battery_type);
							request.setAttribute("factoryAreaRow",factory_area);
							request.setAttribute("preparationOneRow",preparation_one);
							request.setAttribute("preparationTwoRow",preparation_two);
							request.setAttribute("preparationThreeRow",preparation_three);
							request.setAttribute("preparationFourRow",preparation_four);
							request.setAttribute("preparationFiveRow",preparation_five);
							request.setAttribute("verifierRow", verifier);
						}
					}
				}
				request.getRequestDispatcher("photovoltaic_generation_project_insert.jsp").forward(request, response);
				
			}
			else if(op.equals("verify")){
				request.setAttribute("op", "verify");
				if(ch!=null){
					Map[] primaryRows = this.photovoltaicGenerationProjectService.query(Integer.parseInt(ch));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("totalCapacityRow", m.get("总容量"));
						request.setAttribute("sunshineDurationRow", m.get("日照时间"));
						request.setAttribute("totalSolarRadiationRow", m.get("太阳总辐射"));
						request.setAttribute("powerSupplyTypeRow", m.get("供电类型"));
						request.setAttribute("buildingTypeRow", m.get("建筑类型"));
						request.setAttribute("runningModeRow", m.get("运行方式"));
						request.setAttribute("batteryTypeRow", m.get("电池类型"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
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
					}
					else{}
					request.getRequestDispatcher("photovoltaic_generation_project_insert.jsp").forward(request, response);
				}
				else{
					String id = request.getParameter("id");
					this.photovoltaic_generation_project.setId(Integer.parseInt(id));
					this.photovoltaic_generation_project.setPid(pid);
					this.photovoltaic_generation_project.setName(name);
					this.photovoltaic_generation_project.setType(type);
					this.photovoltaic_generation_project.setNation(nation);
					this.photovoltaic_generation_project.setArea(area);
					this.photovoltaic_generation_project.setTotal_capacity(total_capacity);
					this.photovoltaic_generation_project.setSunshine_duration(sunshine_duration);
					this.photovoltaic_generation_project.setTotal_solar_radiation(total_solar_radiation);
					this.photovoltaic_generation_project.setPower_supply_type(power_supply_type);
					this.photovoltaic_generation_project.setBuilding_type(building_type);
					this.photovoltaic_generation_project.setRunning_mode(running_mode);
					this.photovoltaic_generation_project.setBattery_type(battery_type);
					this.photovoltaic_generation_project.setFactory_area(factory_area);
					this.photovoltaic_generation_project.setPreparation_one(preparation_one);
					this.photovoltaic_generation_project.setPreparation_two(preparation_two);
					this.photovoltaic_generation_project.setPreparation_three(preparation_three);
					this.photovoltaic_generation_project.setPreparation_four(preparation_four);
					this.photovoltaic_generation_project.setPreparation_five(preparation_five);
					this.photovoltaic_generation_project.setVerify_time(this.date.format(new Date()));
					this.photovoltaic_generation_project.setVerify_comment(verify_comment);
					if(se!=null){
						if(se.equals("1")){
							this.photovoltaic_generation_project.setVerify_state(2);
						}
						else if(se.equals("-1")){
							this.photovoltaic_generation_project.setVerify_state(-1);
						}
					}
					this.photovoltaic_generation_project.setVerify_comment(verify_comment);
					//填充
					request.setAttribute("idRow", Integer.parseInt(id));
					request.setAttribute("pidRow",pid);
					request.setAttribute("nameRow",name);
					request.setAttribute("typeRow",type);
					request.setAttribute("nationRow",nation);
					request.setAttribute("areaRow",area);
					request.setAttribute("totalCapacityRow",total_capacity);
					request.setAttribute("sunshineDurationRow",sunshine_duration);
					request.setAttribute("totalSolarRadiationRow",total_solar_radiation);
					request.setAttribute("powerSupplyTypeRow",power_supply_type);
					request.setAttribute("buildingTypeRow",building_type);
					request.setAttribute("runningModeRow",running_mode);
					request.setAttribute("batteryTypeRow",battery_type);
					request.setAttribute("preparationOneRow",preparation_one);
					request.setAttribute("preparationTwoRow",preparation_two);
					request.setAttribute("preparationThreeRow",preparation_three);
					request.setAttribute("preparationFourRow",preparation_four);
					request.setAttribute("preparationFiveRow",preparation_five);
					request.setAttribute("verifyCommentRow", verify_comment);
					if(this.photovoltaicGenerationProjectService.verify(photovoltaic_generation_project)){
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
					request.getRequestDispatcher("photovoltaic_generation_project_insert.jsp").forward(request, response);
				}
			}
			else if(op.equals("save")){
				request.setAttribute("op","save");
				String id = request.getParameter("id");
				this.photovoltaic_generation_project.setPid(pid);
				this.photovoltaic_generation_project.setName(name);
				this.photovoltaic_generation_project.setType(type);
				this.photovoltaic_generation_project.setNation(nation);
				this.photovoltaic_generation_project.setArea(area);
				this.photovoltaic_generation_project.setTotal_capacity(total_capacity);
				this.photovoltaic_generation_project.setSunshine_duration(sunshine_duration);
				this.photovoltaic_generation_project.setTotal_solar_radiation(total_solar_radiation);
				this.photovoltaic_generation_project.setPower_supply_type(power_supply_type);
				this.photovoltaic_generation_project.setBuilding_type(building_type);
				this.photovoltaic_generation_project.setRunning_mode(running_mode);
				this.photovoltaic_generation_project.setBattery_type(battery_type);
				this.photovoltaic_generation_project.setFactory_area(factory_area);
				this.photovoltaic_generation_project.setPreparation_one(preparation_one);
				this.photovoltaic_generation_project.setPreparation_two(preparation_two);
				this.photovoltaic_generation_project.setPreparation_three(preparation_three);
				this.photovoltaic_generation_project.setPreparation_four(preparation_four);
				this.photovoltaic_generation_project.setPreparation_five(preparation_five);
				this.photovoltaic_generation_project.setVerify_state(0);
				this.photovoltaic_generation_project.setEntry_time(this.date.format(new Date()));
				this.photovoltaic_generation_project.setVerifier(verifier);
				this.photovoltaic_generation_project.setType_in_userNme(UserName);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				
				if(id==null||id==""){
					if(this.photovoltaicGenerationProjectService.isSubmit(pid)){
						request.setAttribute("msg", "<script>alert('已存在相应相同编号记录，请修改项目编号后提交！')</script>");
					}
					else{
						this.photovoltaicGenerationProjectService.add(photovoltaic_generation_project);
						request.setAttribute("idRow", this.photovoltaicGenerationProjectService.getId(pid, 0));
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
					request.setAttribute("totalCapacityRow",total_capacity);
					request.setAttribute("sunshineDurationRow",sunshine_duration);
					request.setAttribute("totalSolarRadiationRow",total_solar_radiation);
					request.setAttribute("powerSupplyTypeRow",power_supply_type);
					request.setAttribute("buildingTypeRow",building_type);
					request.setAttribute("runningModeRow",running_mode);
					request.setAttribute("batteryTypeRow",battery_type);
					request.setAttribute("factoryAreaRow",factory_area);
					request.setAttribute("preparationOneRow",preparation_one);
					request.setAttribute("preparationTwoRow",preparation_two);
					request.setAttribute("preparationThreeRow",preparation_three);
					request.setAttribute("preparationFourRow",preparation_four);
					request.setAttribute("preparationFiveRow",preparation_five);
					request.setAttribute("verifierRow", verifier);
				}
				else {
					this.photovoltaic_generation_project.setId(Integer.parseInt(id));
					//填充
					Map[] primaryRows = this.photovoltaicGenerationProjectService.query(Integer.parseInt(id));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("typeRow", m.get("项目类别"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("areaRow", m.get("项目所在地区"));
						request.setAttribute("totalCapacityRow", m.get("总容量"));
						request.setAttribute("sunshineDurationRow", m.get("日照时间"));
						request.setAttribute("totalSolarRadiationRow", m.get("太阳总辐射"));
						request.setAttribute("powerSupplyTypeRow", m.get("供电类型"));
						request.setAttribute("buildingTypeRow", m.get("建筑类型"));
						request.setAttribute("runningModeRow", m.get("运行方式"));
						request.setAttribute("batteryTypeRow", m.get("电池类型"));
						request.setAttribute("factoryAreaRow", m.get("厂区面积"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
						request.setAttribute("verifierRow", m.get("审核人"));
						
					}
					if(this.photovoltaicGenerationProjectService.update(photovoltaic_generation_project)){
						//添加入系统日志
						this.log.setOperation("保存");
						this.logService.add(log);
						request.setAttribute("msg", "<script>alert('更新成功！')</script>");
					}
					else {
						request.setAttribute("msg", "<script>alert('更新失败！')</script>");
					}
				}
				request.getRequestDispatcher("photovoltaic_generation_project_insert.jsp").forward(request, response);
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
						this.photovoltaic_generation_project.setId(Integer.parseInt(id));
						this.photovoltaic_generation_project.setPid(pid);
						this.photovoltaic_generation_project.setName(name);
						this.photovoltaic_generation_project.setType(type);
						this.photovoltaic_generation_project.setNation(nation);
						this.photovoltaic_generation_project.setArea(area);
						this.photovoltaic_generation_project.setTotal_capacity(total_capacity);
						this.photovoltaic_generation_project.setSunshine_duration(sunshine_duration);
						this.photovoltaic_generation_project.setTotal_solar_radiation(total_solar_radiation);
						this.photovoltaic_generation_project.setPower_supply_type(power_supply_type);
						this.photovoltaic_generation_project.setBuilding_type(building_type);
						this.photovoltaic_generation_project.setRunning_mode(running_mode);
						this.photovoltaic_generation_project.setBattery_type(battery_type);
						this.photovoltaic_generation_project.setFactory_area(factory_area);
						this.photovoltaic_generation_project.setPreparation_one(preparation_one);
						this.photovoltaic_generation_project.setPreparation_two(preparation_two);
						this.photovoltaic_generation_project.setPreparation_three(preparation_three);
						this.photovoltaic_generation_project.setPreparation_four(preparation_four);
						this.photovoltaic_generation_project.setPreparation_five(preparation_five);
						this.photovoltaic_generation_project.setVerifier(verifier);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.photovoltaicGenerationProjectService.maintenance(photovoltaic_generation_project)){
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
				Map[] primaryRows = this.photovoltaicGenerationProjectService.query(Integer.parseInt(id));
				for(Map m : primaryRows){
					request.setAttribute("idRow", m.get("编号"));
					request.setAttribute("pidRow", m.get("项目编号"));
					request.setAttribute("nameRow", m.get("项目名称"));
					request.setAttribute("typeRow", m.get("项目类别"));
					request.setAttribute("nationRow", m.get("项目所在国"));
					request.setAttribute("areaRow", m.get("项目所在地区"));
					request.setAttribute("totalCapacityRow", m.get("总容量"));
					request.setAttribute("sunshineDurationRow", m.get("日照时间"));
					request.setAttribute("totalSolarRadiationRow", m.get("太阳总辐射"));
					request.setAttribute("powerSupplyTypeRow", m.get("供电类型"));
					request.setAttribute("buildingTypeRow", m.get("建筑类型"));
					request.setAttribute("runningModeRow", m.get("运行方式"));
					request.setAttribute("batteryTypeRow", m.get("电池类型"));
					request.setAttribute("factoryAreaRow", m.get("厂区面积"));
					request.setAttribute("preparationOneRow", m.get("预留一"));
					request.setAttribute("preparationTwoRow", m.get("预留二"));
					request.setAttribute("preparationThreeRow", m.get("预留三"));
					request.setAttribute("preparationFourRow", m.get("预留四"));
					request.setAttribute("preparationFiveRow", m.get("预留五"));
					request.setAttribute("verifierRow", m.get("审核人"));
					
				}
				request.getRequestDispatcher("photovoltaic_generation_project_insert.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "<script>alert('非法访问，无相应参数！')</script>");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
	}

}
