package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BiomassRubbishProjectServiceImpl;
import service.CoalMaterialServiceImpl;
import service.CompanyTechnologyAchievementServiceImpl;
import service.ContractTechnologyProtocolServiceImpl;
import service.DeviceVenderMaterialServiceImpl;
import service.EngineerSummaryServiceImpl;
import service.FuelCoalProjectServiceImpl;
import service.FuelMachineProjectServiceImpl;
import service.HomeBroadStandardServiceImpl;
import service.IBiomassRubbishProjectService;
import service.ICoalMaterialService;
import service.ICompanyTechnologyAchievementService;
import service.IContractTechnologyProtocolService;
import service.IDeviceVenderMaterialService;
import service.IEngineerSummaryService;
import service.IFuelCoalProjectService;
import service.IFuelMachineProjectService;
import service.IHomeBroadStandardService;
import service.IOtherService;
import service.IPhotovoltaicGenerationProjectService;
import service.IPowerDeliverProjectService;
import service.IPowerTransferEngineeringProjectService;
import service.IPreEngineeringDataService;
import service.IProjectExpertService;
import service.ITechnologyEssayService;
import service.ITechnologyService;
import service.OtherServiceImpl;
import service.PhotovoltaicGenerationProjectServiceImpl;
import service.PowerDeliverProjectServiceImpl;
import service.PowerTransferEngineeringProjectServiceImpl;
import service.PreEngineeringDataServiceImpl;
import service.ProjectExpertServiceImpl;
import service.TechnologyEssayServiceImpl;
import service.TechnologyServiceImpl;

/**
 * Servlet implementation class CheckServlet
 */
public class CheckServlet extends HttpServlet {
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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
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
			String act = request.getParameter("act");
			String pid = new String(request.getParameter("pid").getBytes("ISO-8859-1"),"UTF-8");
			if(session.getAttribute("Userlevel")==null){
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				PrintWriter out = response.getWriter();  
		        try{  
		            response.setHeader("Cache-Control", "no-store");  
		            response.setHeader("Pragma", "no-store");  
		            response.setDateHeader("Expires", 0);
					if(act.equals("fuel_machine_project")){
						if(this.fuelMachineProjectService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("fuel_coal_project")){
						if(this.fuelCoalProjectService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("photovoltaic_generation_project")){
						if(this.photovoltaicGenerationProjectService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("biomass_rubbish_project")){
						if(this.biomassRubbishProjectService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("power_transfer_engineering_project")){
						if(this.powerTransferEngineeringProjectService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("power_deliver_project")){
						if(this.powerDeliverProjectService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("pre_engineering_data")){
						if(this.preEngineeringDataService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("home_broad_standard")){
						if(this.homeBroadStandardService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("company_technology_achievement")){
						if(this.companyTechnologyAchievementService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("engineer_summary")){
						if(this.engineerSummaryService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("contract_technology_protocol")){
						if(this.contractTechnologyProtocolService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("device_vender_material")){
						if(this.deviceVenderMaterialService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("technology_essay")){
						if(this.technologyEssayService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("coal_material")){
						if(this.coalMaterialService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("technology")){
						if(this.technologyService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("other")){
						if(this.otherService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else if(act.equals("project_expert")){
						if(this.projectExpertService.isSubmit(pid)){
							out.print("YES");
						}
						else{
							out.print("NO");
						}
					}
					else{
						
					}
		            
		        }finally{
		        	out.close();
		        }
			}
		}
		
	}

}
