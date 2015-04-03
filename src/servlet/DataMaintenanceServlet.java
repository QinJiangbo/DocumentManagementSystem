package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Log;
import service.BiomassRubbishProjectServiceImpl;
import service.CoalMaterialServiceImpl;
import service.CompanyTechnologyAchievementServiceImpl;
import service.ContractTechnologyProtocolServiceImpl;
import service.DeviceVenderMaterialServiceImpl;
import service.EngineerSummaryServiceImpl;
import service.FieldMaintenanceServiceImpl;
import service.FuelCoalProjectServiceImpl;
import service.FuelMachineProjectServiceImpl;
import service.HomeBroadStandardServiceImpl;
import service.IBiomassRubbishProjectService;
import service.ICoalMaterialService;
import service.ICompanyTechnologyAchievementService;
import service.IContractTechnologyProtocolService;
import service.IDeviceVenderMaterialService;
import service.IEngineerSummaryService;
import service.IFieldMaintenanceService;
import service.IFuelCoalProjectService;
import service.IFuelMachineProjectService;
import service.IHomeBroadStandardService;
import service.ILogService;
import service.IOtherService;
import service.IPhotovoltaicGenerationProjectService;
import service.IPowerDeliverProjectService;
import service.IPowerTransferEngineeringProjectService;
import service.IPreEngineeringDataService;
import service.IProjectExpertService;
import service.ITechnologyEssayService;
import service.ITechnologyService;
import service.IUndoService;
import service.IUserService;
import service.LogServiceImpl;
import service.OtherServiceImpl;
import service.PhotovoltaicGenerationProjectServiceImpl;
import service.PowerDeliverProjectServiceImpl;
import service.PowerTransferEngineeringProjectServiceImpl;
import service.PreEngineeringDataServiceImpl;
import service.ProjectExpertServiceImpl;
import service.TechnologyEssayServiceImpl;
import service.TechnologyServiceImpl;
import service.UndoServiceImpl;
import service.UserServiceImpl;

/**
 * Servlet implementation class DataMaintenanceService
 */
@SuppressWarnings("rawtypes")
public class DataMaintenanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFuelMachineProjectService fuelMachineProjectService = new FuelMachineProjectServiceImpl();
    private IFuelCoalProjectService fuelCoalProjectService = new FuelCoalProjectServiceImpl();
    private IPhotovoltaicGenerationProjectService photovoltaicGenerationProjectService = new PhotovoltaicGenerationProjectServiceImpl();
    private IBiomassRubbishProjectService biomassRubbishProjectService = new BiomassRubbishProjectServiceImpl();
    private IPowerTransferEngineeringProjectService powerTransferEngineeringProjectService = new PowerTransferEngineeringProjectServiceImpl();
    private IPowerDeliverProjectService powerDeliverProjectService = new PowerDeliverProjectServiceImpl();
    private IPreEngineeringDataService preEngineeringDataService = new PreEngineeringDataServiceImpl();
    private IHomeBroadStandardService homeBroadStandardService = new HomeBroadStandardServiceImpl();
    private ICompanyTechnologyAchievementService companyTechnologyAchievementService = new CompanyTechnologyAchievementServiceImpl();
    private IEngineerSummaryService engineerSummaryService = new EngineerSummaryServiceImpl();
    private IContractTechnologyProtocolService contractTechnologyProtocolService = new ContractTechnologyProtocolServiceImpl();
    private IDeviceVenderMaterialService deviceVenderMaterialService = new DeviceVenderMaterialServiceImpl();
    private ITechnologyEssayService technologyEssayService = new TechnologyEssayServiceImpl();
    private ICoalMaterialService coalMaterialService = new CoalMaterialServiceImpl();
    private ITechnologyService technologyService = new TechnologyServiceImpl();
    private IOtherService otherService = new OtherServiceImpl();
    private IProjectExpertService projectExpertService = new ProjectExpertServiceImpl();
    private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private IFieldMaintenanceService fieldMaintenanceService = new FieldMaintenanceServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataMaintenanceServlet() {
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
			//添加系统日志
			this.log.setUname(UserName);
			this.log.setTime(this.date.format(new Date()));
			String op = request.getParameter("op");
			if(session.getAttribute("Userlevel")==null){
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				if(op.equals("recordMaintenance")){
					this.log.setTable("入库记录维护");
					this.log.setOperation("管理");
					this.logService.add(log);
					String tableName = "";
					String pid = request.getParameter("pid");
					if(request.getParameter("tableName")!=null){
						tableName = new String(request.getParameter("tableName").getBytes("ISO-8859-1"),"UTF-8");
					}
					Map[] Rows = null;
					if(tableName.equals("燃机项目")){
						if(pid!=null){
							request.setAttribute("rows", this.fuelMachineProjectService.query(pid));
						}
						Rows = this.fuelMachineProjectService.getAllPid();
						request.setAttribute("action", "FuelMachineProjectServlet");
					}
					else if(tableName.equals("燃煤项目")){
						if(pid!=null){
							request.setAttribute("rows", this.fuelCoalProjectService.query(pid));
						}
						Rows = this.fuelCoalProjectService.getAllPid();
						request.setAttribute("action", "FuelCoalProjectServlet");
					}
					else if(tableName.equals("光伏发电项目")){
						if(pid!=null){
							request.setAttribute("rows", this.photovoltaicGenerationProjectService.query(pid));
						}
						Rows = this.photovoltaicGenerationProjectService.getAllPid();
						request.setAttribute("action", "PhotovoltaicGenerationProjectServlet");
					}
					else if(tableName.equals("生物质、垃圾发电项目")){
						if(pid!=null){
							request.setAttribute("rows", this.biomassRubbishProjectService.query(pid));
						}
						Rows = this.biomassRubbishProjectService.getAllPid();
						request.setAttribute("action", "BiomassRubbishProjectServlet");
					}
					else if(tableName.equals("变电工程项目")){
						if(pid!=null){
							request.setAttribute("rows", this.powerTransferEngineeringProjectService.query(pid));
						}
						Rows = this.powerTransferEngineeringProjectService.getAllPid();
						request.setAttribute("action", "PowerTransferEngineeringProjectServlet");
					}
					else if(tableName.equals("送电工程项目")){
						if(pid!=null){
							request.setAttribute("rows", this.powerDeliverProjectService.query(pid));
						}
						Rows = this.powerDeliverProjectService.getAllPid();
						request.setAttribute("action", "PowerDeliverProjectServlet");
					}
					else if(tableName.equals("工程前期数据")){
						if(pid!=null){
							request.setAttribute("rows", this.preEngineeringDataService.query(pid));
						}
						Rows = this.preEngineeringDataService.getAllPid();
						request.setAttribute("action", "PreEngineeringDataServlet");
					}
					else if(tableName.equals("国内外规程规范及相关标准")){
						if(pid!=null){
							request.setAttribute("rows", this.homeBroadStandardService.query(pid));
						}
						Rows = this.homeBroadStandardService.getAllPid();
						request.setAttribute("action", "HomeBroadStandardServlet");
					}
					else if(tableName.equals("公司科技成果")){
						if(pid!=null){
							request.setAttribute("rows", this.homeBroadStandardService.query(pid));
						}
						Rows = this.companyTechnologyAchievementService.getAllName();
						request.setAttribute("action", "CompanyTechnologyAchievementServlet");
					}
					else if(tableName.equals("工程总结")){
						if(pid!=null){
							request.setAttribute("rows", this.homeBroadStandardService.query(pid));
						}
						Rows = this.engineerSummaryService.getAllPid();
						request.setAttribute("action", "EngineerSummaryServlet");
					}
					else if(tableName.equals("合同及技术协议")){
						if(pid!=null){
							request.setAttribute("rows", this.contractTechnologyProtocolService.query(pid));
						}
						Rows = this.contractTechnologyProtocolService.getAllPid();
						request.setAttribute("action", "ContractTechnologyProtocolServlet");
					}
					else if(tableName.equals("设备及厂家资料")){
						if(pid!=null){
							request.setAttribute("rows", this.deviceVenderMaterialService.query(pid));
						}
						Rows = this.deviceVenderMaterialService.getAllDeviceName();
						request.setAttribute("action", "DeviceVenderMaterialServlet");
					}
					else if(tableName.equals("技术文献")){
						if(pid!=null){
							request.setAttribute("rows", this.deviceVenderMaterialService.query(pid));
						}
						Rows = this.technologyEssayService.getAllName();
						request.setAttribute("action", "TechnologyEssayServlet");
					}
					else if(tableName.equals("煤质资料")){
						if(pid!=null){
							request.setAttribute("rows", this.coalMaterialService.query(pid));
						}
						Rows = this.coalMaterialService.getAllPid();
						request.setAttribute("action", "CoalMaterialServlet");
					}
					else if(tableName.equals("技经")){
						if(pid!=null){
							request.setAttribute("rows", this.coalMaterialService.query(pid));
						}
						Rows = this.technologyService.getAllPid();
						request.setAttribute("action", "TechnologyServlet");
					}
					else if(tableName.equals("其他")){
						if(pid!=null){
							request.setAttribute("rows", this.otherService.query(pid));
						}
						Rows = this.otherService.getAllLecture();
						request.setAttribute("action", "OtherServlet");
					}
					else if(tableName.equals("工程专家")){
						if(pid!=null){
							request.setAttribute("rows", this.projectExpertService.query(pid));
						}
						Rows = this.projectExpertService.getAllName();
						request.setAttribute("action", "ProjectExpertServlet");
					}
					else {}
					request.setAttribute("Rows", Rows);
					request.setAttribute("tableName", tableName);
					request.setAttribute("pid", pid);
					request.getRequestDispatcher("store_record_maintenance.jsp").forward(request, response);
				}
				else if(op.equals("fieldMaintenance")){
					this.log.setTable("预留字段维护");
					this.log.setOperation("管理");
					this.logService.add(log);
					PrintWriter out = response.getWriter();  
			        try{  
			            response.setHeader("Cache-Control", "no-store");  
			            response.setHeader("Pragma", "no-store");  
			            response.setDateHeader("Expires", 0);
			            String preservedField1 = "<option value=''></option><option value='预留一'>预留一</option><option value='预留二'>预留二</option><option value='预留三'>预留三</option><option value='预留四'>预留四</option><option value='预留五'>预留五</option><option value='预留六'>预留六</option><option value='预留七'>预留七</option><option value='预留八'>预留八</option><option value='预留九'>预留九</option><option value='预留十'>预留十</option>";
			            String preservedField2 = "<option value=''></option><option value='预留一'>预留一</option><option value='预留二'>预留二</option><option value='预留三'>预留三</option><option value='预留四'>预留四</option><option value='预留五'>预留五</option>";
			            String ch = request.getParameter("ch");
			            String tableName = "";
			            String oldName = "";
			            if(request.getParameter("tableName")!=null){
			            	tableName = new String(request.getParameter("tableName").getBytes("ISO-8859-1"),"UTF-8");
			            }
			            if(request.getParameter("oldName")!=null){
				            oldName = new String(request.getParameter("oldName").getBytes("ISO-8859-1"),"UTF-8");
			            }
			            if(ch.equals("getField")){//获取预留字段
			            	if(tableName.equals("燃机项目")||tableName.equals("燃煤项目")||tableName.equals("生物质、垃圾发电项目")||tableName.equals("煤质资料")){
				            	out.print(preservedField1);
				            }
				            else{
				            	out.print(preservedField2);
				            }
			            }
			            else if(ch.equals("getNewName")){
			            	if(this.fieldMaintenanceService.isUse(tableName, oldName)==1){
			            		out.print(this.fieldMaintenanceService.getNewName(tableName, oldName));
			            	}
			            	else{
			            		out.print("NO");
			            	}
			            }
			            else if(ch.equals("changeField")){
			            	String NewName = new String(request.getParameter("NewName").getBytes("ISO-8859-1"),"UTF-8");
			            	this.fieldMaintenanceService.changeNewName(tableName,oldName, NewName);
			            	out.print(NewName);
			            }
			            else if(ch.equals("useField")){
			            	String NewName = new String(request.getParameter("NewName").getBytes("ISO-8859-1"),"UTF-8");
			            	this.fieldMaintenanceService.Use(tableName, NewName, 1);
			            	out.print(NewName);
			            }
			            else if(ch.equals("unUseField")){
			            	String NewName = new String(request.getParameter("NewName").getBytes("ISO-8859-1"),"UTF-8");
			            	this.fieldMaintenanceService.Use(tableName, NewName, 0);
			            	out.print(NewName);
			            }
			        }finally{  
			            out.close();
			        }
				}
			}
		}
	}
}






