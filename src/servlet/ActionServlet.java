package servlet;

import java.io.IOException;
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
import service.DataMaintenanceServiceImpl;
import service.DeviceVenderMaterialServiceImpl;
import service.EngineerSummaryServiceImpl;
import service.FuelCoalProjectServiceImpl;
import service.FuelMachineProjectServiceImpl;
import service.HomeBroadStandardServiceImpl;
import service.IBiomassRubbishProjectService;
import service.ICoalMaterialService;
import service.ICompanyTechnologyAchievementService;
import service.IContractTechnologyProtocolService;
import service.IDataMaintenanceService;
import service.IDeviceVenderMaterialService;
import service.IEngineerSummaryService;
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
 * Servlet implementation class ActionServlet
 */
@SuppressWarnings("rawtypes")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
	private IUndoService undoService = new UndoServiceImpl();
	private IUserService UService=new UserServiceImpl();
	private ILogService logService = new LogServiceImpl();
	private Log log = new Log();
	private IDataMaintenanceService dataMaintenanceService = new DataMaintenanceServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
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
		String UserName = (String)session.getAttribute("UserName");
		if(UserName==null){
			request.setAttribute("msg", "<script>alert('对不起，请先登录！')</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else{
			String act = request.getParameter("act");
			String op = request.getParameter("op");
			if(session.getAttribute("Userlevel")==null){
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else{
				 if(act.equals("project_data")){
						if(op.equals("add")){
							if(Integer.parseInt(session.getAttribute("Userlevel").toString())>3){
								request.setAttribute("msg", "<script>alert('对不起，您不相应权限查看！')</script>");
								request.getRequestDispatcher("index.jsp").forward(request, response);
							}
							else{
								request.setAttribute("op", op);
								request.getRequestDispatcher("project_data_management.jsp").forward(request, response);
							}
						}
						else if(op.equals("query")){
							request.setAttribute("op", op);
							request.getRequestDispatcher("project_data_management.jsp").forward(request, response);
						}
					}
					else if(act.equals("technology_essay")){
						if(op.equals("add")){
							if(Integer.parseInt(session.getAttribute("Userlevel").toString())>3){
								request.setAttribute("msg", "<script>alert('对不起，您不相应权限查看！')</script>");
								request.getRequestDispatcher("index.jsp").forward(request, response);
							}
							else{
								request.setAttribute("op", op);
								request.getRequestDispatcher("technology_essay_management.jsp").forward(request, response);
							}
						}
						else if(op.equals("query")){
							request.setAttribute("op", op);
							request.getRequestDispatcher("technology_essay_management.jsp").forward(request, response);
						}
					}
					else if(act.equals("project_expert")){
						if(op.equals("add")){
							if(Integer.parseInt(session.getAttribute("Userlevel").toString())>3){
								request.setAttribute("msg", "<script>alert('对不起，您不相应权限查看！')</script>");
								request.getRequestDispatcher("index.jsp").forward(request, response);
							}
							else{
								request.setAttribute("op", op);
								request.getRequestDispatcher("project_expert_insert.jsp").forward(request, response);
							}
						}
						else if(op.equals("query")){
							request.setAttribute("op", op);
							request.getRequestDispatcher("project_expert_insert.jsp").forward(request, response);
						}
					}
					else if(act.equals("Undo")){
						if(Integer.parseInt(session.getAttribute("Userlevel").toString())>2&&!op.equals("non_passed")){
							request.setAttribute("msg", "<script>alert('对不起，您不相应权限查看！')</script>");
							request.getRequestDispatcher("index.jsp").forward(request, response);
						}
						else{
							if(op.equals("management")){
								//menu 代办事宜
								request.setAttribute("project_data",this.undoService.getProjectDataNum(UserName));
								request.setAttribute("non_passed",this.undoService.getUnPassedNum(UserName));
								request.setAttribute("other",this.undoService.getOtherNum(UserName));
								request.setAttribute("pre_engineering_data",this.undoService.getPreEngineeringDataNum(UserName));
								request.setAttribute("home_broad_standard",this.undoService.getHomeBroadStandardNum(UserName));
								request.setAttribute("company_technology_achievement",this.undoService.getCompanyTechnologyAchievementNum(UserName));
								request.setAttribute("engineering_summary",this.undoService.getEngineeringSummaryNum(UserName));
								request.setAttribute("contract_technology_protocol",this.undoService.getContractTechnologyProtocolNum(UserName));
								request.setAttribute("device_vender_meterial",this.undoService.getDeviceVenderMeterialNum(UserName));
								request.setAttribute("technology_essay",this.undoService.getTechnologyEssayNum(UserName));
								request.setAttribute("coal_material",this.undoService.getCoalMeterialNum(UserName));
								request.setAttribute("technology",this.undoService.getTechnologyNum(UserName));
								request.setAttribute("project_expert", this.undoService.getProjectExpertNum(UserName));
								request.getRequestDispatcher("undo_management.jsp").forward(request, response);
							}
							else if(op.equals("project_data")){
								//查询未审核的信息
								Map[] fuelMachineProjectRows = this.fuelMachineProjectService.briefQuery(UserName,1);
								Map[] fuelCoalProjectRows  = this.fuelCoalProjectService.briefQuery(UserName,1);
								Map[] photovoltaicGenerationProjectRows  = this.photovoltaicGenerationProjectService.briefQuery(UserName,1);
								Map[] biomassRubbishProjectRows  = this.biomassRubbishProjectService.briefQuery(UserName,1);
								Map[] powerTransferEngineeringProjectRows  = this.powerTransferEngineeringProjectService.briefQuery(UserName,1);
								Map[] powerDeliverProjectRows  = this.powerDeliverProjectService.briefQuery(UserName,1);
								request.setAttribute("fuelMachineProjectRows", fuelMachineProjectRows );
								request.setAttribute("fuelCoalProjectRows", fuelCoalProjectRows );
								request.setAttribute("photovoltaicGenerationProjectRows", photovoltaicGenerationProjectRows );
								request.setAttribute("biomassRubbishProjectRows", biomassRubbishProjectRows );
								request.setAttribute("powerTransferEngineeringProjectRows", powerTransferEngineeringProjectRows );
								request.setAttribute("powerDeliverProjectRows", powerDeliverProjectRows );
								request.getRequestDispatcher("project_data_verifier.jsp").forward(request, response);
							}
							else if(op.equals("non_passed")){
								Map[] fuelMachineProjectRows = this.fuelMachineProjectService.briefQuery(UserName,-1);
								Map[] fuelCoalProjectRows  = this.fuelCoalProjectService.briefQuery(UserName,-1);
								Map[] photovoltaicGenerationProjectRows  = this.photovoltaicGenerationProjectService.briefQuery(UserName,-1);
								Map[] biomassRubbishProjectRows  = this.biomassRubbishProjectService.briefQuery(UserName,-1);
								Map[] powerTransferEngineeringProjectRows  = this.powerTransferEngineeringProjectService.briefQuery(UserName,-1);
								Map[] powerDeliverProjectRows  = this.powerDeliverProjectService.briefQuery(UserName,-1);
								Map[] preEngineeringDataRows = this.preEngineeringDataService.briefQuery(UserName, -1);
								Map[] homeBroadStandardRows = this.homeBroadStandardService.briefQuery(UserName, -1);
								Map[] companyTechnologyAchievementRows = this.companyTechnologyAchievementService.briefQuery(UserName, -1);
								Map[] engineerSummaryRows = this.engineerSummaryService.briefQuery(UserName, -1);
								Map[] contractTechnologyProtocolRows = this.contractTechnologyProtocolService.briefQuery(UserName, -1);
								Map[] deviceVenderMaterialRows = this.deviceVenderMaterialService.briefQuery(UserName, -1);
								Map[] technologyEssayRows = this.technologyEssayService.briefQuery(UserName, -1);
								Map[] coalMaterialRows = this.coalMaterialService.briefQuery(UserName, -1);
								Map[] technologyRows = this.technologyService.briefQuery(UserName, -1);
								Map[] otherRows = this.otherService.briefQuery(UserName, -1);
								Map[] projectExpertRows = this.projectExpertService.briefQuery(UserName, -1);
								request.setAttribute("fuelMachineProjectRows", fuelMachineProjectRows );
								request.setAttribute("fuelCoalProjectRows", fuelCoalProjectRows );
								request.setAttribute("photovoltaicGenerationProjectRows", photovoltaicGenerationProjectRows );
								request.setAttribute("biomassRubbishProjectRows", biomassRubbishProjectRows );
								request.setAttribute("powerTransferEngineeringProjectRows", powerTransferEngineeringProjectRows );
								request.setAttribute("powerDeliverProjectRows", powerDeliverProjectRows );
								request.setAttribute("preEngineeringDataRows", preEngineeringDataRows );
								request.setAttribute("homeBroadStandardRows", homeBroadStandardRows );
								request.setAttribute("companyTechnologyAchievementRows", companyTechnologyAchievementRows );
								request.setAttribute("engineerSummaryRows", engineerSummaryRows );
								request.setAttribute("contractTechnologyProtocolRows", contractTechnologyProtocolRows );
								request.setAttribute("deviceVenderMaterialRows", deviceVenderMaterialRows );
								request.setAttribute("technologyEssayRows", technologyEssayRows );
								request.setAttribute("coalMaterialRows", coalMaterialRows );
								request.setAttribute("technologyRows", technologyRows );
								request.setAttribute("otherRows", otherRows );
								request.setAttribute("projectExpertRows", projectExpertRows );
								request.getRequestDispatcher("non_passed_verifier.jsp").forward(request, response);
								
							}
							else if(op.equals("pre_engineering_data")){
								Map[] preEngineeringDataRows = this.preEngineeringDataService.briefQuery(UserName, 1);
								request.setAttribute("preEngineeringDataRows", preEngineeringDataRows );
								request.getRequestDispatcher("pre_engineering_data_verifier.jsp").forward(request, response);
							}
							else if(op.equals("home_broad_standard")){
								Map[] homeBroadStandardRows = this.homeBroadStandardService.briefQuery(UserName, 1);
								request.setAttribute("homeBroadStandardRows", homeBroadStandardRows );
								request.getRequestDispatcher("home_broad_standard_verifier.jsp").forward(request, response);
							}
							else if(op.equals("company_technology_achievement")){
								Map[] companyTechnologyAchievementRows = this.companyTechnologyAchievementService.briefQuery(UserName, 1);
								request.setAttribute("companyTechnologyAchievementRows", companyTechnologyAchievementRows );
								request.getRequestDispatcher("company_technology_achievement_verifier.jsp").forward(request, response);
							}
							else if(op.equals("engineering_summary")){
								Map[] engineerSummaryRows = this.engineerSummaryService.briefQuery(UserName, 1);
								request.setAttribute("engineerSummaryRows", engineerSummaryRows );
								request.getRequestDispatcher("engineer_summary_verifier.jsp").forward(request, response);
							}
							else if(op.equals("contract_technology_protocol")){
								Map[] contractTechnologyProtocolRows = this.contractTechnologyProtocolService.briefQuery(UserName, 1);
								request.setAttribute("contractTechnologyProtocolRows", contractTechnologyProtocolRows );
								request.getRequestDispatcher("contract_technology_protocol_verifier.jsp").forward(request, response);
							}
							else if(op.equals("device_vender_meterial")){
								Map[] deviceVenderMaterialRows = this.deviceVenderMaterialService.briefQuery(UserName, 1);
								request.setAttribute("deviceVenderMaterialRows", deviceVenderMaterialRows );
								request.getRequestDispatcher("device_vender_material_verifier.jsp").forward(request, response);
							}
							else if(op.equals("technology_essay")){
								Map[] technologyEssayRows = this.technologyEssayService.briefQuery(UserName, 1);
								request.setAttribute("technologyEssayRows", technologyEssayRows );
								request.getRequestDispatcher("technology_essay_verifier.jsp").forward(request, response);
							}
							else if(op.equals("coal_material")){
								Map[] coalMaterialRows = this.coalMaterialService.briefQuery(UserName, 1);
								request.setAttribute("coalMaterialRows", coalMaterialRows );
								request.getRequestDispatcher("coal_material_verifier.jsp").forward(request, response);
							}
							else if(op.equals("technology")){
								Map[] technologyRows = this.technologyService.briefQuery(UserName, 1);
								request.setAttribute("technologyRows", technologyRows );
								request.getRequestDispatcher("technology_verifier.jsp").forward(request, response);
							}
							else if(op.equals("other")){
								Map[] otherRows = this.otherService.briefQuery(UserName, 1);
								request.setAttribute("otherRows", otherRows );
								request.getRequestDispatcher("other_verifier.jsp").forward(request, response);
							}
							else if(op.equals("project_expert")){
								Map[] projectExpertRows = this.projectExpertService.briefQuery(UserName, 1);
								request.setAttribute("projectExpertRows", projectExpertRows );
								request.getRequestDispatcher("project_expert_verifier.jsp").forward(request, response);
							}
							else if(op.equals("modify_recorded_file")){
								
							}
							else {//url出错
								request.getRequestDispatcher("index.jsp").forward(request, response);
							}
						}
					}
					else if(act.equals("system_mangement")){
						if(Integer.parseInt(session.getAttribute("Userlevel").toString())>1&&!op.equals("changePwd")){
							request.setAttribute("msg", "<script>alert('对不起，您不相应权限查看！')</script>");
							request.getRequestDispatcher("index.jsp").forward(request, response);
						}
						else{
							if(op.equals("newUser")){
								request.getRequestDispatcher("new_user.jsp").forward(request, response);
							}
							else if(op.equals("showUser")){
								request.setAttribute("rows",this.UService.getUserMsg(Integer.parseInt(session.getAttribute("Userlevel").toString())));
								request.getRequestDispatcher("show_user.jsp").forward(request, response);
							}
							else if(op.equals("log")){
								request.setAttribute("Uname", this.UService.getDefaultVerifierRows());
								request.setAttribute("rows", this.logService.getAllLog());
								request.getRequestDispatcher("system_journal.jsp").forward(request, response);
							}
							else if(op.equals("dataMaintenance")){
								String ch = request.getParameter("ch");
								if(ch!=null){
									if(ch.equals("fieldMaintenance")){
										request.getRequestDispatcher("preserved_field_maintenance.jsp").forward(request, response);
									}
									else if(ch.equals("recordMaintenance")){
										request.getRequestDispatcher("store_record_maintenance.jsp").forward(request, response);
									}
									else if(ch.equals("clearDatabase")){
										this.dataMaintenanceService.clearDatabase();
						            	//添加系统日志
										this.log.setUname(UserName);
										this.log.setTable("数据库");
										this.log.setTime(this.date.format(new Date()));
										this.log.setOperation("清理");
										this.logService.add(log);
										request.setAttribute("msg", "<script>alert('清理成功！')</script>");
										request.getRequestDispatcher("data_maintenance.jsp").forward(request, response);
									}
								}
								else{
									request.getRequestDispatcher("data_maintenance.jsp").forward(request, response);
								}
							}
							else if(op.equals("changePwd")){
								request.getRequestDispatcher("change_password.jsp").forward(request, response);
							}
							else{//url 请求出错
								request.getRequestDispatcher("index.jsp").forward(request, response);
							}
						}
					}
					else if(act.equals("index")){
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					else{//url 请求出错
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
			}
		}
	}
}







