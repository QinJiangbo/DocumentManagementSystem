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
import pojo.Contract_technology_protocol;
import pojo.Log;
import pojo.MyFile;
import service.ContractTechnologyProtocolServiceImpl;
import service.FieldMaintenanceServiceImpl;
import service.FileService;
import service.IContractTechnologyProtocolService;
import service.IFieldMaintenanceService;
import service.ILogService;
import service.IUserService;
import service.LogServiceImpl;
import service.UserServiceImpl;

/**
 * Servlet implementation class ContractTechnologyProtocolServlet
 */
@SuppressWarnings("rawtypes")
public class ContractTechnologyProtocolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Contract_technology_protocol contract_technology_protocol = new Contract_technology_protocol();
    private IContractTechnologyProtocolService contractTechnologyProtocolService = new ContractTechnologyProtocolServiceImpl();
    private IFieldMaintenanceService fieldMaintenanceService = new FieldMaintenanceServiceImpl();
    private IUserService userService = new UserServiceImpl();
    private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
	FileService fileService=new FileService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContractTechnologyProtocolServlet() {
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
			String capacity = request.getParameter("capacity");
			String profession_name = request.getParameter("profession_name");
			String device_name = request.getParameter("device_name");
			String nation = request.getParameter("nation");
			String preparation_one = request.getParameter("preparation_one");
			String preparation_two = request.getParameter("preparation_two");
			String preparation_three = request.getParameter("preparation_three");
			String preparation_four = request.getParameter("preparation_four");
			String preparation_five = request.getParameter("preparation_five");
			String verifier = request.getParameter("verifier");
			String verify_comment = request.getParameter("verify_comment");
			//默认select选项
			Map[] capacityRows = this.contractTechnologyProtocolService.getDefaultCapacityRows();
			Map[] professionNameRows = this.contractTechnologyProtocolService.getDefaultProfessionNameRows();
			Map[] nationRows = this.contractTechnologyProtocolService.getDefaultNationRows();
			Map[] verifierRows = this.userService.getDefaultVerifierRows();
			Map[] preparationOneRows = this.contractTechnologyProtocolService.getDefaultPreparationOneRows();
			Map[] preparationTwoRows = this.contractTechnologyProtocolService.getDefaultPreparationTwoRows();
			Map[] preparationThreeRows = this.contractTechnologyProtocolService.getDefaultPreparationThreeRows();
			Map[] preparationFourRows = this.contractTechnologyProtocolService.getDefaultPreparationFourRows();
			Map[] preparationFiveRows = this.contractTechnologyProtocolService.getDefaultPreparationFiveRows();
			request.setAttribute("capacityRows",capacityRows);
			request.setAttribute("professionNameRows",professionNameRows);
			request.setAttribute("nationRows",nationRows);
			request.setAttribute("verifierRows",verifierRows);
			request.setAttribute("preparationOneRows",preparationOneRows);
			request.setAttribute("preparationTwoRows",preparationTwoRows);
			request.setAttribute("preparationThreeRows",preparationThreeRows);
			request.setAttribute("preparationFourRows",preparationFourRows);
			request.setAttribute("preparationFiveRows",preparationFiveRows);
			request.setAttribute("pageName", "contract_technology_protocol");//pageName for page dispatcher
			//add log
			this.log.setUname(UserName);
			this.log.setTable("合同及技术协议");
			this.log.setTime(this.date.format(new Date()));
			//设置初始审核人
			request.setAttribute("verifierRow", this.userService.getDefaultVerifier(UserName));
			//预留字段是否启用
			int isPreparationOneUsed = this.fieldMaintenanceService.isUse("合同及技术协议","预留一");
			int isPreparationTwoUsed = this.fieldMaintenanceService.isUse("合同及技术协议","预留二");
			int isPreparationThreeUsed = this.fieldMaintenanceService.isUse("合同及技术协议","预留三");
			int isPreparationFourUsed = this.fieldMaintenanceService.isUse("合同及技术协议","预留四");
			int isPreparationFiveUsed = this.fieldMaintenanceService.isUse("合同及技术协议","预留五");
			request.setAttribute("isPreparationOneUsed", isPreparationOneUsed);
			request.setAttribute("isPreparationTwoUsed", isPreparationTwoUsed);
			request.setAttribute("isPreparationThreeUsed", isPreparationThreeUsed);
			request.setAttribute("isPreparationFourUsed", isPreparationFourUsed);
			request.setAttribute("isPreparationFiveUsed", isPreparationFiveUsed);
			//获取预留字段新名称
			String preparationOneNewName = this.fieldMaintenanceService.getNewName("合同及技术协议","预留一");
			String preparationTwoNewName = this.fieldMaintenanceService.getNewName("合同及技术协议","预留二");
			String preparationThreeNewName = this.fieldMaintenanceService.getNewName("合同及技术协议","预留三");
			String preparationFourNewName = this.fieldMaintenanceService.getNewName("合同及技术协议","预留四");
			String preparationFiveNewName = this.fieldMaintenanceService.getNewName("合同及技术协议","预留五");
			request.setAttribute("preparationOneNewName", preparationOneNewName);
			request.setAttribute("preparationTwoNewName", preparationTwoNewName);
			request.setAttribute("preparationThreeNewName", preparationThreeNewName);
			request.setAttribute("preparationFourNewName", preparationFourNewName);
			request.setAttribute("preparationFiveNewName", preparationFiveNewName);
			if(op.equals("insert")){
				request.setAttribute("op","insert");
				if(this.contractTechnologyProtocolService.hasSave(UserName)){
					Map[] primaryRows = this.contractTechnologyProtocolService.primaryQuery(UserName);
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("capacityRow", m.get("机组容量"));
						request.setAttribute("professionNameRow", m.get("专业名称"));
						request.setAttribute("deviceNameRow", m.get("设备名称"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
						request.setAttribute("verifierRow", m.get("审核人"));
						
					}
					request.setAttribute("op", "update");
					request.getRequestDispatcher("contract_technology_protocol_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("contract_technology_protocol_insert.jsp").forward(request, response);
				}
				
			}
			else if(op.equals("add")){
				request.setAttribute("op","insert");
				this.contract_technology_protocol.setPid(pid);
				this.contract_technology_protocol.setName(name);
				this.contract_technology_protocol.setCapacity(capacity);
				this.contract_technology_protocol.setProfession_name(profession_name);
				this.contract_technology_protocol.setDevice_name(device_name);
				this.contract_technology_protocol.setNation(nation);
				this.contract_technology_protocol.setPreparation_one(preparation_one);
				this.contract_technology_protocol.setPreparation_two(preparation_two);
				this.contract_technology_protocol.setPreparation_three(preparation_three);
				this.contract_technology_protocol.setPreparation_four(preparation_four);
				this.contract_technology_protocol.setPreparation_five(preparation_five);
				this.contract_technology_protocol.setEntry_time(this.date.format(new Date()));
				this.contract_technology_protocol.setType_in_userNme(UserName);
				this.contract_technology_protocol.setVerifier(verifier);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				request.setAttribute("pidRow", pid);
				request.setAttribute("nameRow", name);
				request.setAttribute("capacityRow", capacity);
				request.setAttribute("professionNameRow", profession_name);
				request.setAttribute("deviceNameRow", device_name);
				request.setAttribute("nationRow", nation);
				request.setAttribute("preparationOneRow", preparation_one);
				request.setAttribute("preparationTwoRow", preparation_two);
				request.setAttribute("preparationThreeRow", preparation_three);
				request.setAttribute("preparationFourRow", preparation_four);
				request.setAttribute("preparationFiveRow", preparation_five);
				request.setAttribute("verifierRow", verifier);
				if(this.contractTechnologyProtocolService.isSubmit(pid)){
					if(this.contractTechnologyProtocolService.isSave(pid)){
						request.setAttribute("msg", "<script>alert('已存在相同编号保存记录,无法继续保存第二条具有相同编号的记录,请核实并修改名称！')</script>");
					}
					else{
						if(this.contractTechnologyProtocolService.hasSave(UserName)){
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，并且您已有一条保存记录了,无法继续保存第二条的记录,请核实并修改名称！')</script>");
						}
						else {
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，请核实名称后提交！')</script>");
						}
					}
				}
				else{
					this.contract_technology_protocol.setVerify_state(1);
					if(this.contractTechnologyProtocolService.add(contract_technology_protocol)){
						//添加入系统日志
						this.log.setOperation("录入");
						this.logService.add(log);
						Map[] primaryRows = this.contractTechnologyProtocolService.query(this.contractTechnologyProtocolService.getId(pid, 1));
						for(Map m : primaryRows){
							request.setAttribute("idRow", m.get("编号"));
							request.setAttribute("pidRow", m.get("项目编号"));
							request.setAttribute("nameRow", m.get("项目名称"));
							request.setAttribute("capacityRow", m.get("机组容量"));
							request.setAttribute("professionNameRow", m.get("专业名称"));
							request.setAttribute("deviceNameRow", m.get("设备名称"));
							request.setAttribute("nationRow", m.get("项目所在国"));
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
				request.getRequestDispatcher("contract_technology_protocol_insert.jsp").forward(request, response);
			}
			else if(op.equals("query")){
				request.setAttribute("op","query");
				this.contract_technology_protocol.setPid(pid);
				this.contract_technology_protocol.setName(name);
				this.contract_technology_protocol.setCapacity(capacity);
				this.contract_technology_protocol.setProfession_name(profession_name);
				this.contract_technology_protocol.setDevice_name(device_name);
				this.contract_technology_protocol.setNation(nation);
				this.contract_technology_protocol.setPreparation_one(preparation_one);
				this.contract_technology_protocol.setPreparation_two(preparation_two);
				this.contract_technology_protocol.setPreparation_three(preparation_three);
				this.contract_technology_protocol.setPreparation_four(preparation_four);
				this.contract_technology_protocol.setPreparation_five(preparation_five);
				Map[] rows = this.contractTechnologyProtocolService.query(contract_technology_protocol);
				//添加入系统日志
				this.log.setOperation("查询");
				this.logService.add(log);
				request.setAttribute("rows", rows);
				if(ch!=null){
					String id = request.getParameter("id");
					Map[] primaryRows = this.contractTechnologyProtocolService.query(Integer.parseInt(id.toString()));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("capacityRow", m.get("机组容量"));
						request.setAttribute("professionNameRow", m.get("专业名称"));
						request.setAttribute("deviceNameRow", m.get("设备名称"));
						request.setAttribute("nationRow", m.get("项目所在国"));
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
							String projectType=new String(request.getParameter("projectType").getBytes("ISO-8859-1"),"GBK");
							String projectId=new String(request.getParameter("projectId").getBytes("ISO-8859-1"),"GBK");
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
							String path=new String(request.getParameter("path").getBytes("ISO-8859-1"),"UTF-8");
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
							String pathTransfer=new String(currentPath.getBytes("ISO-8859-1"),"UTF-8");
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
					request.getRequestDispatcher("contract_technology_protocol_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("contract_technology_protocol_query.jsp").forward(request, response);
				}
			}
			else if(op.equals("update")){
				request.setAttribute("op","update");
				String id = request.getParameter("id");
				if(this.contractTechnologyProtocolService.isSubmit(pid)){
					if(this.contractTechnologyProtocolService.isSave(pid)){
						this.contract_technology_protocol.setId(Integer.parseInt(id));
						this.contract_technology_protocol.setPid(pid);
						this.contract_technology_protocol.setName(name);
						this.contract_technology_protocol.setCapacity(capacity);
						this.contract_technology_protocol.setProfession_name(profession_name);
						this.contract_technology_protocol.setDevice_name(device_name);
						this.contract_technology_protocol.setNation(nation);
						this.contract_technology_protocol.setPreparation_one(preparation_one);
						this.contract_technology_protocol.setPreparation_two(preparation_two);
						this.contract_technology_protocol.setPreparation_three(preparation_three);
						this.contract_technology_protocol.setPreparation_four(preparation_four);
						this.contract_technology_protocol.setPreparation_five(preparation_five);
						this.contract_technology_protocol.setEntry_time(this.date.format(new Date()));
						this.contract_technology_protocol.setType_in_userNme(UserName);
						this.contract_technology_protocol.setVerifier(verifier);
						this.contract_technology_protocol.setVerify_state(1);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.contractTechnologyProtocolService.update(contract_technology_protocol)){
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
					request.setAttribute("capacityRow", capacity);
					request.setAttribute("professionNameRow", profession_name);
					request.setAttribute("deviceNameRow", device_name);
					request.setAttribute("nationRow", nation);
					request.setAttribute("preparationOneRow", preparation_one);
					request.setAttribute("preparationTwoRow", preparation_two);
					request.setAttribute("preparationThreeRow", preparation_three);
					request.setAttribute("preparationFourRow", preparation_four);
					request.setAttribute("preparationFiveRow", preparation_five);
					request.setAttribute("verifierRow", verifier);
				}
				else{
					this.contract_technology_protocol.setId(Integer.parseInt(id));
					this.contract_technology_protocol.setPid(pid);
					this.contract_technology_protocol.setName(name);
					this.contract_technology_protocol.setCapacity(capacity);
					this.contract_technology_protocol.setProfession_name(profession_name);
					this.contract_technology_protocol.setDevice_name(device_name);
					this.contract_technology_protocol.setNation(nation);
					this.contract_technology_protocol.setPreparation_one(preparation_one);
					this.contract_technology_protocol.setPreparation_two(preparation_two);
					this.contract_technology_protocol.setPreparation_three(preparation_three);
					this.contract_technology_protocol.setPreparation_four(preparation_four);
					this.contract_technology_protocol.setPreparation_five(preparation_five);
					this.contract_technology_protocol.setEntry_time(this.date.format(new Date()));
					this.contract_technology_protocol.setType_in_userNme(UserName);
					this.contract_technology_protocol.setVerifier(verifier);
					this.contract_technology_protocol.setVerify_state(1);
					//重设默认审核人
					this.userService.setDefaultVerifier(UserName, verifier);
					
					//for 未审核更新处理
					if(ch==null||ch==""){
						if(this.contractTechnologyProtocolService.update(contract_technology_protocol)){
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
						request.setAttribute("capacityRow", capacity);
						request.setAttribute("professionNameRow", profession_name);
						request.setAttribute("deviceNameRow", device_name);
						request.setAttribute("nationRow", nation);
						request.setAttribute("preparationOneRow", preparation_one);
						request.setAttribute("preparationTwoRow", preparation_two);
						request.setAttribute("preparationThreeRow", preparation_three);
						request.setAttribute("preparationFourRow", preparation_four);
						request.setAttribute("preparationFiveRow", preparation_five);
						request.setAttribute("verifierRow", verifier);
					}
					else{
						if(ch.equals("unpass")){
							Map[] primaryRows = this.contractTechnologyProtocolService.query(Integer.parseInt(id));
							for(Map m : primaryRows){
								request.setAttribute("idRow", m.get("编号"));
								request.setAttribute("pidRow", m.get("项目编号"));
								request.setAttribute("nameRow", m.get("项目名称"));
								request.setAttribute("capacityRow", m.get("机组容量"));
								request.setAttribute("professionNameRow", m.get("专业名称"));
								request.setAttribute("deviceNameRow", m.get("设备名称"));
								request.setAttribute("nationRow", m.get("项目所在国"));
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
							if(this.contractTechnologyProtocolService.update(contract_technology_protocol)){
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
							request.setAttribute("capacityRow", capacity);
							request.setAttribute("professionNameRow", profession_name);
							request.setAttribute("deviceNameRow", device_name);
							request.setAttribute("nationRow", nation);
							request.setAttribute("preparationOneRow", preparation_one);
							request.setAttribute("preparationTwoRow", preparation_two);
							request.setAttribute("preparationThreeRow", preparation_three);
							request.setAttribute("preparationFourRow", preparation_four);
							request.setAttribute("preparationFiveRow", preparation_five);
							request.setAttribute("verifierRow", verifier);
						}
					}
				}
				request.getRequestDispatcher("contract_technology_protocol_insert.jsp").forward(request, response);
				
			}
			else if(op.equals("verify")){
				request.setAttribute("op", "verify");
				if(ch!=null){
					Map[] primaryRows = this.contractTechnologyProtocolService.query(Integer.parseInt(ch));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("capacityRow", m.get("机组容量"));
						request.setAttribute("professionNameRow", m.get("专业名称"));
						request.setAttribute("deviceNameRow", m.get("设备名称"));
						request.setAttribute("nationRow", m.get("项目所在国"));
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
							String projectType=new String(request.getParameter("projectType").getBytes("ISO-8859-1"),"UTF-8");
							String projectId=new String(request.getParameter("projectId").getBytes("ISO-8859-1"),"UTF-8");
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
							String path=new String(request.getParameter("path").getBytes("ISO-8859-1"),"UTF-8");
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
							String pathTransfer=new String(currentPath.getBytes("ISO-8859-1"),"UTF-8");
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
					else{
						
					}
					request.getRequestDispatcher("contract_technology_protocol_insert.jsp").forward(request, response);
				}
				else{
					String id = request.getParameter("id");
					this.contract_technology_protocol.setId(Integer.parseInt(id));
					this.contract_technology_protocol.setPid(pid);
					this.contract_technology_protocol.setName(name);
					this.contract_technology_protocol.setCapacity(capacity);
					this.contract_technology_protocol.setProfession_name(profession_name);
					this.contract_technology_protocol.setDevice_name(device_name);
					this.contract_technology_protocol.setNation(nation);
					this.contract_technology_protocol.setPreparation_one(preparation_one);
					this.contract_technology_protocol.setPreparation_two(preparation_two);
					this.contract_technology_protocol.setPreparation_three(preparation_three);
					this.contract_technology_protocol.setPreparation_four(preparation_four);
					this.contract_technology_protocol.setPreparation_five(preparation_five);
					this.contract_technology_protocol.setVerify_time(this.date.format(new Date()));
					this.contract_technology_protocol.setVerify_comment(verify_comment);
					if(se!=null){
						if(se.equals("1")){
							this.contract_technology_protocol.setVerify_state(2);
						}
						else if(se.equals("-1")){
							this.contract_technology_protocol.setVerify_state(-1);
						}
					}
					this.contract_technology_protocol.setVerify_comment(verify_comment);
					//填充
					request.setAttribute("idRow", Integer.parseInt(id));
					request.setAttribute("pidRow", pid);
					request.setAttribute("nameRow", name);
					request.setAttribute("capacityRow", capacity);
					request.setAttribute("professionNameRow", profession_name);
					request.setAttribute("deviceNameRow", device_name);
					request.setAttribute("nationRow", nation);
					request.setAttribute("preparationOneRow", preparation_one);
					request.setAttribute("preparationTwoRow", preparation_two);
					request.setAttribute("preparationThreeRow", preparation_three);
					request.setAttribute("preparationFourRow", preparation_four);
					request.setAttribute("preparationFiveRow", preparation_five);
					request.setAttribute("verifyCommentRow", verify_comment);
					if(this.contractTechnologyProtocolService.verify(contract_technology_protocol)){
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
							String projectType=new String(request.getParameter("projectType").getBytes("ISO-8859-1"),"UTF-8");
							String projectId=new String(request.getParameter("projectId").getBytes("ISO-8859-1"),"UTF-8");
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
							String path=new String(request.getParameter("path").getBytes("ISO-8859-1"),"UTF-8");
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
							String pathTransfer=new String(currentPath.getBytes("ISO-8859-1"),"UTF-8");
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
					request.getRequestDispatcher("contract_technology_protocol_insert.jsp").forward(request, response);
				}
			}
			else if(op.equals("save")){
				request.setAttribute("op","save");
				String id = request.getParameter("id");
				this.contract_technology_protocol.setPid(pid);
				this.contract_technology_protocol.setName(name);
				this.contract_technology_protocol.setCapacity(capacity);
				this.contract_technology_protocol.setProfession_name(profession_name);
				this.contract_technology_protocol.setDevice_name(device_name);
				this.contract_technology_protocol.setNation(nation);
				this.contract_technology_protocol.setPreparation_one(preparation_one);
				this.contract_technology_protocol.setPreparation_two(preparation_two);
				this.contract_technology_protocol.setPreparation_three(preparation_three);
				this.contract_technology_protocol.setPreparation_four(preparation_four);
				this.contract_technology_protocol.setPreparation_five(preparation_five);
				this.contract_technology_protocol.setVerify_state(0);
				this.contract_technology_protocol.setEntry_time(this.date.format(new Date()));
				this.contract_technology_protocol.setVerifier(verifier);
				this.contract_technology_protocol.setType_in_userNme(UserName);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				
				if(id==null||id==""){
					if(this.contractTechnologyProtocolService.isSubmit(pid)){
						request.setAttribute("msg", "<script>alert('已存在相应相同编号记录，请修改项目编号后提交！')</script>");
					}
					else{
						this.contractTechnologyProtocolService.add(contract_technology_protocol);
						request.setAttribute("idRow", this.contractTechnologyProtocolService.getId(pid, 0));
						request.setAttribute("msg", "<script>alert('保存成功！')</script>");
						//添加入系统日志
						this.log.setOperation("保存");
						this.logService.add(log);
					}
					request.setAttribute("pidRow", pid);
					request.setAttribute("nameRow", name);
					request.setAttribute("capacityRow", capacity);
					request.setAttribute("professionNameRow", profession_name);
					request.setAttribute("deviceNameRow", device_name);
					request.setAttribute("nationRow", nation);
					request.setAttribute("preparationOneRow", preparation_one);
					request.setAttribute("preparationTwoRow", preparation_two);
					request.setAttribute("preparationThreeRow", preparation_three);
					request.setAttribute("preparationFourRow", preparation_four);
					request.setAttribute("preparationFiveRow", preparation_five);
					request.setAttribute("verifierRow", verifier);
				}
				else {
					this.contract_technology_protocol.setId(Integer.parseInt(id));
					//填充
					Map[] primaryRows = this.contractTechnologyProtocolService.query(Integer.parseInt(id));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("pidRow", m.get("项目编号"));
						request.setAttribute("nameRow", m.get("项目名称"));
						request.setAttribute("capacityRow", m.get("机组容量"));
						request.setAttribute("professionNameRow", m.get("专业名称"));
						request.setAttribute("deviceNameRow", m.get("设备名称"));
						request.setAttribute("nationRow", m.get("项目所在国"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
						request.setAttribute("verifierRow", m.get("审核人"));
						
					}
					if(this.contractTechnologyProtocolService.update(contract_technology_protocol)){
						//添加入系统日志
						this.log.setOperation("更新");
						this.logService.add(log);
						request.setAttribute("msg", "<script>alert('更新成功！')</script>");
					}
					else {
						request.setAttribute("msg", "<script>alert('更新失败！')</script>");
					}
				}
				request.getRequestDispatcher("contract_technology_protocol_insert.jsp").forward(request, response);
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
						this.contract_technology_protocol.setId(Integer.parseInt(id));
						this.contract_technology_protocol.setPid(pid);
						this.contract_technology_protocol.setName(name);
						this.contract_technology_protocol.setCapacity(capacity);
						this.contract_technology_protocol.setProfession_name(profession_name);
						this.contract_technology_protocol.setDevice_name(device_name);
						this.contract_technology_protocol.setNation(nation);
						this.contract_technology_protocol.setPreparation_one(preparation_one);
						this.contract_technology_protocol.setPreparation_two(preparation_two);
						this.contract_technology_protocol.setPreparation_three(preparation_three);
						this.contract_technology_protocol.setPreparation_four(preparation_four);
						this.contract_technology_protocol.setPreparation_five(preparation_five);
						this.contract_technology_protocol.setVerifier(verifier);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.contractTechnologyProtocolService.maintenance(contract_technology_protocol)){
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
				Map[] primaryRows = this.contractTechnologyProtocolService.query(Integer.parseInt(id));
				for(Map m : primaryRows){
					request.setAttribute("idRow", m.get("编号"));
					request.setAttribute("pidRow", m.get("项目编号"));
					request.setAttribute("nameRow", m.get("项目名称"));
					request.setAttribute("capacityRow", m.get("机组容量"));
					request.setAttribute("professionNameRow", m.get("专业名称"));
					request.setAttribute("deviceNameRow", m.get("设备名称"));
					request.setAttribute("nationRow", m.get("项目所在国"));
					request.setAttribute("preparationOneRow", m.get("预留一"));
					request.setAttribute("preparationTwoRow", m.get("预留二"));
					request.setAttribute("preparationThreeRow", m.get("预留三"));
					request.setAttribute("preparationFourRow", m.get("预留四"));
					request.setAttribute("preparationFiveRow", m.get("预留五"));
					request.setAttribute("verifierRow", m.get("审核人"));
					
				}
				request.getRequestDispatcher("contract_technology_protocol_insert.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "<script>alert('非法访问，无相应参数！')</script>");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

}
