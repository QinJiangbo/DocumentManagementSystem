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
import pojo.Project_expert;
import service.FieldMaintenanceServiceImpl;
import service.FileService;
import service.IFieldMaintenanceService;
import service.ILogService;
import service.IProjectExpertService;
import service.IUserService;
import service.LogServiceImpl;
import service.ProjectExpertServiceImpl; 
import service.UserServiceImpl;

/**
 * Servlet implementation class ProjectExpertServlet
 */
@SuppressWarnings("rawtypes")
public class ProjectExpertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Project_expert project_expert = new Project_expert();
	private IProjectExpertService projectExpertService = new ProjectExpertServiceImpl();
	private IFieldMaintenanceService fieldMaintenanceService = new FieldMaintenanceServiceImpl();
	private IUserService userService = new UserServiceImpl();
	private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
	FileService fileService=new FileService();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectExpertServlet() {
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
			
			String name = request.getParameter("name");
			String profession = request.getParameter("profession");
			String department = request.getParameter("department");
			String education_background = request.getParameter("education_background");
			String graduation_school = request.getParameter("graduation_school");
			String working_time = request.getParameter("working_time");
			String identified_card = request.getParameter("identified_card");
			String job = request.getParameter("job");
			String job_title = request.getParameter("job_title");
			String contact_number = request.getParameter("contact_number");
			String telephone = request.getParameter("telephone");
			String fax = request.getParameter("fax");
			String email = request.getParameter("email");
			String mailing_address = request.getParameter("mailing_address");
			String postcode = request.getParameter("postcode");
			String technical_expertise = request.getParameter("technical_expertise");
			String job_resume = request.getParameter("job_resume");
			String main_performance = request.getParameter("main_performance");
			String awards = request.getParameter("awards");
			String papers = request.getParameter("papers");
			String remark = request.getParameter("remark");
			String preparation_one = request.getParameter("preparation_one");
			String preparation_two = request.getParameter("preparation_two");
			String preparation_three = request.getParameter("preparation_three");
			String preparation_four = request.getParameter("preparation_four");
			String preparation_five = request.getParameter("preparation_five");
			String verifier = request.getParameter("verifier");
			String verify_comment = request.getParameter("verify_comment");
			//默认select选项
			Map[] professionRows = this.projectExpertService.getDefaultProfessionRows();
			Map[] educationBackgroundRows = this.projectExpertService.getDefaultEducationBackgroundRows();
			Map[] jobTitleRows = this.projectExpertService.getDefaultJobTitleRows();
			Map[] verifierRows = this.userService.getDefaultVerifierRows();
			Map[] preparationOneRows = this.projectExpertService.getDefaultPreparationOneRows();
			Map[] preparationTwoRows = this.projectExpertService.getDefaultPreparationTwoRows();
			Map[] preparationThreeRows = this.projectExpertService.getDefaultPreparationThreeRows();
			Map[] preparationFourRows = this.projectExpertService.getDefaultPreparationFourRows();
			Map[] preparationFiveRows = this.projectExpertService.getDefaultPreparationFiveRows();
			request.setAttribute("professionRows",professionRows);
			request.setAttribute("educationBackgroundRows",educationBackgroundRows);
			request.setAttribute("jobTitleRows",jobTitleRows);
			request.setAttribute("verifierRows",verifierRows);
			request.setAttribute("preparationOneRows",preparationOneRows);
			request.setAttribute("preparationTwoRows",preparationTwoRows);
			request.setAttribute("preparationThreeRows",preparationThreeRows);
			request.setAttribute("preparationFourRows",preparationFourRows);
			request.setAttribute("preparationFiveRows",preparationFiveRows);
			request.setAttribute("pageName", "project_expert");//pageName for page dispatcher
			//add log
			this.log.setUname(UserName);
			this.log.setTable("工程专家");
			this.log.setTime(this.date.format(new Date()));
			//设置初始审核人
			request.setAttribute("verifierRow", this.userService.getDefaultVerifier(UserName));
			//预留字段是否启用
			int isPreparationOneUsed = this.fieldMaintenanceService.isUse("工程专家","预留一");
			int isPreparationTwoUsed = this.fieldMaintenanceService.isUse("工程专家","预留二");
			int isPreparationThreeUsed = this.fieldMaintenanceService.isUse("工程专家","预留三");
			int isPreparationFourUsed = this.fieldMaintenanceService.isUse("工程专家","预留四");
			int isPreparationFiveUsed = this.fieldMaintenanceService.isUse("工程专家","预留五");
			request.setAttribute("isPreparationOneUsed", isPreparationOneUsed);
			request.setAttribute("isPreparationTwoUsed", isPreparationTwoUsed);
			request.setAttribute("isPreparationThreeUsed", isPreparationThreeUsed);
			request.setAttribute("isPreparationFourUsed", isPreparationFourUsed);
			request.setAttribute("isPreparationFiveUsed", isPreparationFiveUsed);
			//获取预留字段新名称
			String preparationOneNewName = this.fieldMaintenanceService.getNewName("工程专家","预留一");
			String preparationTwoNewName = this.fieldMaintenanceService.getNewName("工程专家","预留二");
			String preparationThreeNewName = this.fieldMaintenanceService.getNewName("工程专家","预留三");
			String preparationFourNewName = this.fieldMaintenanceService.getNewName("工程专家","预留四");
			String preparationFiveNewName = this.fieldMaintenanceService.getNewName("工程专家","预留五");
			request.setAttribute("preparationOneNewName", preparationOneNewName);
			request.setAttribute("preparationTwoNewName", preparationTwoNewName);
			request.setAttribute("preparationThreeNewName", preparationThreeNewName);
			request.setAttribute("preparationFourNewName", preparationFourNewName);
			request.setAttribute("preparationFiveNewName", preparationFiveNewName);
			if(op.equals("insert")){
				request.setAttribute("op","insert");
				if(this.projectExpertService.hasSave(UserName)){
					Map[] primaryRows = this.projectExpertService.primaryQuery(UserName);
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("nameRow", m.get("姓名"));
						request.setAttribute("professionRow", m.get("专业"));
						request.setAttribute("departmentRow", m.get("所在单位"));
						request.setAttribute("educationBackgroundRow", m.get("学历"));
						request.setAttribute("graduationSchoolRow", m.get("毕业学校"));
						request.setAttribute("workingTimeRow", m.get("参加工作时间"));
						request.setAttribute("identifiedCardRow", m.get("身份证"));
						request.setAttribute("jobRow", m.get("职务"));
						request.setAttribute("jobTitleRow", m.get("职称"));
						request.setAttribute("contactNumberRow", m.get("联系电话"));
						request.setAttribute("telephoneRow", m.get("手机"));
						request.setAttribute("faxRow", m.get("传真"));
						request.setAttribute("emailRow", m.get("email"));
						request.setAttribute("mailingAddressRow", m.get("通讯地址"));
						request.setAttribute("postcodeRow", m.get("邮编"));
						request.setAttribute("technicalExpertiseRow", m.get("技术专长"));
						request.setAttribute("jobResumeRow", m.get("工作简历"));
						request.setAttribute("mainPerformanceRow", m.get("主要业绩"));
						request.setAttribute("awardsRow", m.get("获奖情况"));
						request.setAttribute("papersRow", m.get("著作及论文"));
						request.setAttribute("remarkRow", m.get("备注"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
						request.setAttribute("verifierRow", m.get("审核人"));
						
					}
					request.setAttribute("op", "update");
					request.getRequestDispatcher("project_expert_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("project_expert_insert.jsp").forward(request, response);
				}
				
			}
			else if(op.equals("add")){
				request.setAttribute("op","insert");
				this.project_expert.setName(name);
				this.project_expert.setProfession(profession);
				this.project_expert.setDepartment(department);
				this.project_expert.setEducation_background(education_background);
				this.project_expert.setGraduation_school(graduation_school);
				this.project_expert.setWorking_time(working_time);
				this.project_expert.setIdentified_card(identified_card);
				this.project_expert.setJob(job);
				this.project_expert.setJob_title(job_title);
				this.project_expert.setContact_number(contact_number);
				this.project_expert.setTelephone(telephone);
				this.project_expert.setFax(fax);
				this.project_expert.setEmail(email);
				this.project_expert.setMailing_address(mailing_address);
				this.project_expert.setPostcode(postcode);
				this.project_expert.setTechnical_expertise(technical_expertise);
				this.project_expert.setJob_resume(job_resume);
				this.project_expert.setMain_performance(main_performance);
				this.project_expert.setAwards(awards);
				this.project_expert.setPapers(papers);
				this.project_expert.setRemark(remark);
				this.project_expert.setPreparation_one(preparation_one);
				this.project_expert.setPreparation_two(preparation_two);
				this.project_expert.setPreparation_three(preparation_three);
				this.project_expert.setPreparation_four(preparation_four);
				this.project_expert.setPreparation_five(preparation_five);
				this.project_expert.setEntry_time(this.date.format(new Date()));
				this.project_expert.setType_in_userNme(UserName);
				this.project_expert.setVerifier(verifier);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				request.setAttribute("nameRow", name);
				request.setAttribute("professionRow", profession);
				request.setAttribute("departmentRow", department);
				request.setAttribute("educationBackgroundRow", education_background);
				request.setAttribute("graduationSchoolRow",graduation_school);
				request.setAttribute("workingTimeRow",working_time );
				request.setAttribute("identifiedCardRow", identified_card);
				request.setAttribute("jobRow", job);
				request.setAttribute("jobTitleRow", job_title);
				request.setAttribute("contactNumberRow", contact_number);
				request.setAttribute("telephoneRow", telephone);
				request.setAttribute("faxRow", fax);
				request.setAttribute("emailRow", email);
				request.setAttribute("mailingAddressRow", mailing_address);
				request.setAttribute("postcodeRow", postcode);
				request.setAttribute("technicalExpertiseRow", technical_expertise);
				request.setAttribute("jobResumeRow", job_resume);
				request.setAttribute("mainPerformanceRow", main_performance);
				request.setAttribute("awardsRow", awards);
				request.setAttribute("papersRow", papers);
				request.setAttribute("remarkRow", remark);
				request.setAttribute("preparationOneRow", preparation_one);
				request.setAttribute("preparationTwoRow", preparation_two);
				request.setAttribute("preparationThreeRow", preparation_three);
				request.setAttribute("preparationFourRow", preparation_four);
				request.setAttribute("preparationFiveRow", preparation_five);
				request.setAttribute("verifierRow", verifier);
				if(this.projectExpertService.isSubmit(identified_card)){
					if(this.projectExpertService.isSave(identified_card)){
						request.setAttribute("msg", "<script>alert('已存在相同编号保存记录,无法继续保存第二条具有相同编号的记录,请核实身份证号！！')</script>");
					}
					else{
						if(this.projectExpertService.hasSave(UserName)){
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，并且您已有一条保存记录了,无法继续保存第二条的记录,请核实身份证号！')</script>");
						}
						else {
							request.setAttribute("msg", "<script>alert('已存在相同编号记录，请核实项身份证号后提交！')</script>");
						}
					}
				}
				else{
					this.project_expert.setVerify_state(1);
					if(this.projectExpertService.add(project_expert)){
						//添加入系统日志
						this.log.setOperation("录入");
						this.logService.add(log);
						Map[] primaryRows = this.projectExpertService.query(this.projectExpertService.getId(identified_card, 1));
						for(Map m : primaryRows){
							request.setAttribute("idRow", m.get("编号"));
							request.setAttribute("nameRow", m.get("姓名"));
							request.setAttribute("professionRow", m.get("专业"));
							request.setAttribute("departmentRow", m.get("所在单位"));
							request.setAttribute("educationBackgroundRow", m.get("学历"));
							request.setAttribute("graduationSchoolRow", m.get("毕业学校"));
							request.setAttribute("workingTimeRow", m.get("参加工作时间"));
							request.setAttribute("identifiedCardRow", m.get("身份证"));
							request.setAttribute("jobRow", m.get("职务"));
							request.setAttribute("jobTitleRow", m.get("职称"));
							request.setAttribute("contactNumberRow", m.get("联系电话"));
							request.setAttribute("telephoneRow", m.get("手机"));
							request.setAttribute("faxRow", m.get("传真"));
							request.setAttribute("emailRow", m.get("email"));
							request.setAttribute("mailingAddressRow", m.get("通讯地址"));
							request.setAttribute("postcodeRow", m.get("邮编"));
							request.setAttribute("technicalExpertiseRow", m.get("技术专长"));
							request.setAttribute("jobResumeRow", m.get("工作简历"));
							request.setAttribute("mainPerformanceRow", m.get("主要业绩"));
							request.setAttribute("awardsRow", m.get("获奖情况"));
							request.setAttribute("papersRow", m.get("著作及论文"));
							request.setAttribute("remarkRow", m.get("备注"));
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
				request.getRequestDispatcher("project_expert_insert.jsp").forward(request, response);
			}
			else if(op.equals("query")){
				request.setAttribute("op", "query");
				this.project_expert.setName(name);
				this.project_expert.setProfession(profession);
				this.project_expert.setDepartment(department);
				this.project_expert.setEducation_background(education_background);
				this.project_expert.setGraduation_school(graduation_school);
				this.project_expert.setWorking_time(working_time);
				this.project_expert.setIdentified_card(identified_card);
				this.project_expert.setJob(job);
				this.project_expert.setJob_title(job_title);
				this.project_expert.setContact_number(contact_number);
				this.project_expert.setTelephone(telephone);
				this.project_expert.setFax(fax);
				this.project_expert.setEmail(email);
				this.project_expert.setMailing_address(mailing_address);
				this.project_expert.setPostcode(postcode);
				this.project_expert.setTechnical_expertise(technical_expertise);
				this.project_expert.setJob_resume(job_resume);
				this.project_expert.setMain_performance(main_performance);
				this.project_expert.setAwards(awards);
				this.project_expert.setPapers(papers);
				this.project_expert.setRemark(remark);
				this.project_expert.setPreparation_one(preparation_one);
				this.project_expert.setPreparation_two(preparation_two);
				this.project_expert.setPreparation_three(preparation_three);
				this.project_expert.setPreparation_four(preparation_four);
				this.project_expert.setPreparation_five(preparation_five);
				Map[] rows = this.projectExpertService.query(project_expert);
				//添加入系统日志
				this.log.setOperation("查询");
				this.logService.add(log);
				request.setAttribute("rows", rows);
				if(ch!=null){
					String id = request.getParameter("id");
					Map[] primaryRows = this.projectExpertService.query(Integer.parseInt(id.toString()));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("nameRow", m.get("姓名"));
						request.setAttribute("professionRow", m.get("专业"));
						request.setAttribute("departmentRow", m.get("所在单位"));
						request.setAttribute("educationBackgroundRow", m.get("学历"));
						request.setAttribute("graduationSchoolRow", m.get("毕业学校"));
						request.setAttribute("workingTimeRow", m.get("参加工作时间"));
						request.setAttribute("identifiedCardRow", m.get("身份证"));
						request.setAttribute("jobRow", m.get("职务"));
						request.setAttribute("jobTitleRow", m.get("职称"));
						request.setAttribute("contactNumberRow", m.get("联系电话"));
						request.setAttribute("telephoneRow", m.get("手机"));
						request.setAttribute("faxRow", m.get("传真"));
						request.setAttribute("emailRow", m.get("email"));
						request.setAttribute("mailingAddressRow", m.get("通讯地址"));
						request.setAttribute("postcodeRow", m.get("邮编"));
						request.setAttribute("technicalExpertiseRow", m.get("技术专长"));
						request.setAttribute("jobResumeRow", m.get("工作简历"));
						request.setAttribute("mainPerformanceRow", m.get("主要业绩"));
						request.setAttribute("awardsRow", m.get("获奖情况"));
						request.setAttribute("papersRow", m.get("著作及论文"));
						request.setAttribute("remarkRow", m.get("备注"));
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
					}else{
						
					}
					request.getRequestDispatcher("project_expert_insert.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("project_expert_query.jsp").forward(request, response);
				}
			}
			else if(op.equals("update")){
				request.setAttribute("op", "update");
				String id = request.getParameter("id");
				if(this.projectExpertService.isSubmit(name)){
					if(this.projectExpertService.isSave(name)){
						this.project_expert.setId(Integer.parseInt(id));
						this.project_expert.setName(name);
						this.project_expert.setProfession(profession);
						this.project_expert.setDepartment(department);
						this.project_expert.setEducation_background(education_background);
						this.project_expert.setGraduation_school(graduation_school);
						this.project_expert.setWorking_time(working_time);
						this.project_expert.setIdentified_card(identified_card);
						this.project_expert.setJob(job);
						this.project_expert.setJob_title(job_title);
						this.project_expert.setContact_number(contact_number);
						this.project_expert.setTelephone(telephone);
						this.project_expert.setFax(fax);
						this.project_expert.setEmail(email);
						this.project_expert.setMailing_address(mailing_address);
						this.project_expert.setPostcode(postcode);
						this.project_expert.setTechnical_expertise(technical_expertise);
						this.project_expert.setJob_resume(job_resume);
						this.project_expert.setMain_performance(main_performance);
						this.project_expert.setAwards(awards);
						this.project_expert.setPapers(papers);
						this.project_expert.setRemark(remark);
						this.project_expert.setPreparation_one(preparation_one);
						this.project_expert.setPreparation_two(preparation_two);
						this.project_expert.setPreparation_three(preparation_three);
						this.project_expert.setPreparation_four(preparation_four);
						this.project_expert.setPreparation_five(preparation_five);
						this.project_expert.setEntry_time(this.date.format(new Date()));
						this.project_expert.setType_in_userNme(UserName);
						this.project_expert.setVerifier(verifier);
						this.project_expert.setVerify_state(1);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.projectExpertService.update(project_expert)){
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
						request.setAttribute("msg", "<script>alert('已存在相同编号项目，请核实身份证号后提交！')</script>");
					}
					//填充
					request.setAttribute("idRow", Integer.parseInt(id));
					request.setAttribute("nameRow", name);
					request.setAttribute("professionRow", profession);
					request.setAttribute("departmentRow", department);
					request.setAttribute("educationBackgroundRow", education_background);
					request.setAttribute("graduationSchoolRow",graduation_school);
					request.setAttribute("workingTimeRow",working_time );
					request.setAttribute("identifiedCardRow", identified_card);
					request.setAttribute("jobRow", job);
					request.setAttribute("jobTitleRow", job_title);
					request.setAttribute("contactNumberRow", contact_number);
					request.setAttribute("telephoneRow", telephone);
					request.setAttribute("faxRow", fax);
					request.setAttribute("emailRow", email);
					request.setAttribute("mailingAddressRow", mailing_address);
					request.setAttribute("postcodeRow", postcode);
					request.setAttribute("technicalExpertiseRow", technical_expertise);
					request.setAttribute("jobResumeRow", job_resume);
					request.setAttribute("mainPerformanceRow", main_performance);
					request.setAttribute("awardsRow", awards);
					request.setAttribute("papersRow", papers);
					request.setAttribute("remarkRow", remark);
					request.setAttribute("preparationOneRow", preparation_one);
					request.setAttribute("preparationTwoRow", preparation_two);
					request.setAttribute("preparationThreeRow", preparation_three);
					request.setAttribute("preparationFourRow", preparation_four);
					request.setAttribute("preparationFiveRow", preparation_five);
					request.setAttribute("verifierRow", verifier);
				}
				else{
					this.project_expert.setId(Integer.parseInt(id));
					this.project_expert.setName(name);
					this.project_expert.setProfession(profession);
					this.project_expert.setDepartment(department);
					this.project_expert.setEducation_background(education_background);
					this.project_expert.setGraduation_school(graduation_school);
					this.project_expert.setWorking_time(working_time);
					this.project_expert.setIdentified_card(identified_card);
					this.project_expert.setJob(job);
					this.project_expert.setJob_title(job_title);
					this.project_expert.setContact_number(contact_number);
					this.project_expert.setTelephone(telephone);
					this.project_expert.setFax(fax);
					this.project_expert.setEmail(email);
					this.project_expert.setMailing_address(mailing_address);
					this.project_expert.setPostcode(postcode);
					this.project_expert.setTechnical_expertise(technical_expertise);
					this.project_expert.setJob_resume(job_resume);
					this.project_expert.setMain_performance(main_performance);
					this.project_expert.setAwards(awards);
					this.project_expert.setPapers(papers);
					this.project_expert.setRemark(remark);
					this.project_expert.setPreparation_one(preparation_one);
					this.project_expert.setPreparation_two(preparation_two);
					this.project_expert.setPreparation_three(preparation_three);
					this.project_expert.setPreparation_four(preparation_four);
					this.project_expert.setPreparation_five(preparation_five);
					this.project_expert.setEntry_time(this.date.format(new Date()));
					this.project_expert.setType_in_userNme(UserName);
					this.project_expert.setVerifier(verifier);
					this.project_expert.setVerify_state(1);
					//重设默认审核人
					this.userService.setDefaultVerifier(UserName, verifier);
					
					//for 未审核更新处理
					if(ch==null||ch==""){
						if(this.projectExpertService.update(project_expert)){
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
						request.setAttribute("nameRow", name);
						request.setAttribute("professionRow", profession);
						request.setAttribute("departmentRow", department);
						request.setAttribute("educationBackgroundRow", education_background);
						request.setAttribute("graduationSchoolRow",graduation_school);
						request.setAttribute("workingTimeRow",working_time );
						request.setAttribute("identifiedCardRow", identified_card);
						request.setAttribute("jobRow", job);
						request.setAttribute("jobTitleRow", job_title);
						request.setAttribute("contactNumberRow", contact_number);
						request.setAttribute("telephoneRow", telephone);
						request.setAttribute("faxRow", fax);
						request.setAttribute("emailRow", email);
						request.setAttribute("mailingAddressRow", mailing_address);
						request.setAttribute("postcodeRow", postcode);
						request.setAttribute("technicalExpertiseRow", technical_expertise);
						request.setAttribute("jobResumeRow", job_resume);
						request.setAttribute("mainPerformanceRow", main_performance);
						request.setAttribute("awardsRow", awards);
						request.setAttribute("papersRow", papers);
						request.setAttribute("remarkRow", remark);
						request.setAttribute("preparationOneRow", preparation_one);
						request.setAttribute("preparationTwoRow", preparation_two);
						request.setAttribute("preparationThreeRow", preparation_three);
						request.setAttribute("preparationFourRow", preparation_four);
						request.setAttribute("preparationFiveRow", preparation_five);
						request.setAttribute("verifierRow", verifier);
					}
					else{
						if(ch.equals("unpass")){
							Map[] primaryRows = this.projectExpertService.query(Integer.parseInt(id));
							for(Map m : primaryRows){
								request.setAttribute("idRow", m.get("编号"));
								request.setAttribute("nameRow", m.get("姓名"));
								request.setAttribute("professionRow", m.get("专业"));
								request.setAttribute("departmentRow", m.get("所在单位"));
								request.setAttribute("educationBackgroundRow", m.get("学历"));
								request.setAttribute("graduationSchoolRow", m.get("毕业学校"));
								request.setAttribute("workingTimeRow", m.get("参加工作时间"));
								request.setAttribute("identifiedCardRow", m.get("身份证"));
								request.setAttribute("jobRow", m.get("职务"));
								request.setAttribute("jobTitleRow", m.get("职称"));
								request.setAttribute("contactNumberRow", m.get("联系电话"));
								request.setAttribute("telephoneRow", m.get("手机"));
								request.setAttribute("faxRow", m.get("传真"));
								request.setAttribute("emailRow", m.get("email"));
								request.setAttribute("mailingAddressRow", m.get("通讯地址"));
								request.setAttribute("postcodeRow", m.get("邮编"));
								request.setAttribute("technicalExpertiseRow", m.get("技术专长"));
								request.setAttribute("jobResumeRow", m.get("工作简历"));
								request.setAttribute("mainPerformanceRow", m.get("主要业绩"));
								request.setAttribute("awardsRow", m.get("获奖情况"));
								request.setAttribute("papersRow", m.get("著作及论文"));
								request.setAttribute("remarkRow", m.get("备注"));
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
							if(this.projectExpertService.update(project_expert)){
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
							request.setAttribute("nameRow", name);
							request.setAttribute("professionRow", profession);
							request.setAttribute("departmentRow", department);
							request.setAttribute("educationBackgroundRow", education_background);
							request.setAttribute("graduationSchoolRow",graduation_school);
							request.setAttribute("workingTimeRow",working_time );
							request.setAttribute("identifiedCardRow", identified_card);
							request.setAttribute("jobRow", job);
							request.setAttribute("jobTitleRow", job_title);
							request.setAttribute("contactNumberRow", contact_number);
							request.setAttribute("telephoneRow", telephone);
							request.setAttribute("faxRow", fax);
							request.setAttribute("emailRow", email);
							request.setAttribute("mailingAddressRow", mailing_address);
							request.setAttribute("postcodeRow", postcode);
							request.setAttribute("technicalExpertiseRow", technical_expertise);
							request.setAttribute("jobResumeRow", job_resume);
							request.setAttribute("mainPerformanceRow", main_performance);
							request.setAttribute("awardsRow", awards);
							request.setAttribute("papersRow", papers);
							request.setAttribute("remarkRow", remark);
							request.setAttribute("preparationOneRow", preparation_one);
							request.setAttribute("preparationTwoRow", preparation_two);
							request.setAttribute("preparationThreeRow", preparation_three);
							request.setAttribute("preparationFourRow", preparation_four);
							request.setAttribute("preparationFiveRow", preparation_five);
							request.setAttribute("verifierRow", verifier);
						}
					}
				}
				
				request.setAttribute("op", "update");
				request.getRequestDispatcher("project_expert_insert.jsp").forward(request, response);
				
			}
			else if(op.equals("verify")){
				request.setAttribute("op", "verify");
				if(ch!=null){
					Map[] primaryRows = this.projectExpertService.query(Integer.parseInt(ch));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("nameRow", m.get("姓名"));
						request.setAttribute("professionRow", m.get("专业"));
						request.setAttribute("departmentRow", m.get("所在单位"));
						request.setAttribute("educationBackgroundRow", m.get("学历"));
						request.setAttribute("graduationSchoolRow", m.get("毕业学校"));
						request.setAttribute("workingTimeRow", m.get("参加工作时间"));
						request.setAttribute("identifiedCardRow", m.get("身份证"));
						request.setAttribute("jobRow", m.get("职务"));
						request.setAttribute("jobTitleRow", m.get("职称"));
						request.setAttribute("contactNumberRow", m.get("联系电话"));
						request.setAttribute("telephoneRow", m.get("手机"));
						request.setAttribute("faxRow", m.get("传真"));
						request.setAttribute("emailRow", m.get("email"));
						request.setAttribute("mailingAddressRow", m.get("通讯地址"));
						request.setAttribute("postcodeRow", m.get("邮编"));
						request.setAttribute("technicalExpertiseRow", m.get("技术专长"));
						request.setAttribute("jobResumeRow", m.get("工作简历"));
						request.setAttribute("mainPerformanceRow", m.get("主要业绩"));
						request.setAttribute("awardsRow", m.get("获奖情况"));
						request.setAttribute("papersRow", m.get("著作及论文"));
						request.setAttribute("remarkRow", m.get("备注"));
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
					}else{
						
					}
					request.getRequestDispatcher("project_expert_insert.jsp").forward(request, response);
				}
				else{
					String id = request.getParameter("id");
					this.project_expert.setId(Integer.parseInt(id));
					this.project_expert.setName(name);
					this.project_expert.setProfession(profession);
					this.project_expert.setDepartment(department);
					this.project_expert.setEducation_background(education_background);
					this.project_expert.setGraduation_school(graduation_school);
					this.project_expert.setWorking_time(working_time);
					this.project_expert.setIdentified_card(identified_card);
					this.project_expert.setJob(job);
					this.project_expert.setJob_title(job_title);
					this.project_expert.setContact_number(contact_number);
					this.project_expert.setTelephone(telephone);
					this.project_expert.setFax(fax);
					this.project_expert.setEmail(email);
					this.project_expert.setMailing_address(mailing_address);
					this.project_expert.setPostcode(postcode);
					this.project_expert.setTechnical_expertise(technical_expertise);
					this.project_expert.setJob_resume(job_resume);
					this.project_expert.setMain_performance(main_performance);
					this.project_expert.setAwards(awards);
					this.project_expert.setPapers(papers);
					this.project_expert.setRemark(remark);
					this.project_expert.setPreparation_one(preparation_one);
					this.project_expert.setPreparation_two(preparation_two);
					this.project_expert.setPreparation_three(preparation_three);
					this.project_expert.setPreparation_four(preparation_four);
					this.project_expert.setPreparation_five(preparation_five);
					this.project_expert.setVerify_time(this.date.format(new Date()));
					this.project_expert.setVerify_comment(verify_comment);
					if(se!=null){
						if(se.equals("1")){
							this.project_expert.setVerify_state(2);
						}
						else if(se.equals("-1")){
							this.project_expert.setVerify_state(-1);
						}
					}
					this.project_expert.setVerify_comment(verify_comment);
					//填充
					request.setAttribute("idRow", Integer.parseInt(id));
					request.setAttribute("nameRow", name);
					request.setAttribute("professionRow", profession);
					request.setAttribute("departmentRow", department);
					request.setAttribute("educationBackgroundRow", education_background);
					request.setAttribute("graduationSchoolRow",graduation_school);
					request.setAttribute("workingTimeRow",working_time );
					request.setAttribute("identifiedCardRow", identified_card);
					request.setAttribute("jobRow", job);
					request.setAttribute("jobTitleRow", job_title);
					request.setAttribute("contactNumberRow", contact_number);
					request.setAttribute("telephoneRow", telephone);
					request.setAttribute("faxRow", fax);
					request.setAttribute("emailRow", email);
					request.setAttribute("mailingAddressRow", mailing_address);
					request.setAttribute("postcodeRow", postcode);
					request.setAttribute("technicalExpertiseRow", technical_expertise);
					request.setAttribute("jobResumeRow", job_resume);
					request.setAttribute("mainPerformanceRow", main_performance);
					request.setAttribute("awardsRow", awards);
					request.setAttribute("papersRow", papers);
					request.setAttribute("remarkRow", remark);
					request.setAttribute("preparationOneRow", preparation_one);
					request.setAttribute("preparationTwoRow", preparation_two);
					request.setAttribute("preparationThreeRow", preparation_three);
					request.setAttribute("preparationFourRow", preparation_four);
					request.setAttribute("preparationFiveRow", preparation_five);
					request.setAttribute("verifyCommentRow", verify_comment);
					if(this.projectExpertService.verify(project_expert)){
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
					request.getRequestDispatcher("project_expert_insert.jsp").forward(request, response);
				}
			}
			else if(op.equals("save")){
				request.setAttribute("op","save");
				String id = request.getParameter("id");
				this.project_expert.setName(name);
				this.project_expert.setProfession(profession);
				this.project_expert.setDepartment(department);
				this.project_expert.setEducation_background(education_background);
				this.project_expert.setGraduation_school(graduation_school);
				this.project_expert.setWorking_time(working_time);
				this.project_expert.setIdentified_card(identified_card);
				this.project_expert.setJob(job);
				this.project_expert.setJob_title(job_title);
				this.project_expert.setContact_number(contact_number);
				this.project_expert.setTelephone(telephone);
				this.project_expert.setFax(fax);
				this.project_expert.setEmail(email);
				this.project_expert.setMailing_address(mailing_address);
				this.project_expert.setPostcode(postcode);
				this.project_expert.setTechnical_expertise(technical_expertise);
				this.project_expert.setJob_resume(job_resume);
				this.project_expert.setMain_performance(main_performance);
				this.project_expert.setAwards(awards);
				this.project_expert.setPapers(papers);
				this.project_expert.setRemark(remark);
				this.project_expert.setPreparation_one(preparation_one);
				this.project_expert.setPreparation_two(preparation_two);
				this.project_expert.setPreparation_three(preparation_three);
				this.project_expert.setPreparation_four(preparation_four);
				this.project_expert.setPreparation_five(preparation_five);
				this.project_expert.setVerify_state(0);
				this.project_expert.setEntry_time(this.date.format(new Date()));
				this.project_expert.setVerifier(verifier);
				this.project_expert.setType_in_userNme(UserName);
				//重设默认审核人
				this.userService.setDefaultVerifier(UserName, verifier);
				
				if(id==null||id==""){
					if(this.projectExpertService.isSubmit(identified_card)){
						request.setAttribute("msg", "<script>alert('已存在相应相同编号记录，请认真核对身份证号后提交！')</script>");
					}
					else{
						this.projectExpertService.add(project_expert);
						request.setAttribute("idRow", this.projectExpertService.getId(identified_card, 0));
						request.setAttribute("msg", "<script>alert('保存成功！')</script>");
						//添加入系统日志
						this.log.setOperation("保存");
						this.logService.add(log);
					}
					request.setAttribute("nameRow", name);
					request.setAttribute("professionRow", profession);
					request.setAttribute("departmentRow", department);
					request.setAttribute("educationBackgroundRow", education_background);
					request.setAttribute("graduationSchoolRow",graduation_school);
					request.setAttribute("workingTimeRow",working_time );
					request.setAttribute("identifiedCardRow", identified_card);
					request.setAttribute("jobRow", job);
					request.setAttribute("jobTitleRow", job_title);
					request.setAttribute("contactNumberRow", contact_number);
					request.setAttribute("telephoneRow", telephone);
					request.setAttribute("faxRow", fax);
					request.setAttribute("emailRow", email);
					request.setAttribute("mailingAddressRow", mailing_address);
					request.setAttribute("postcodeRow", postcode);
					request.setAttribute("technicalExpertiseRow", technical_expertise);
					request.setAttribute("jobResumeRow", job_resume);
					request.setAttribute("mainPerformanceRow", main_performance);
					request.setAttribute("awardsRow", awards);
					request.setAttribute("papersRow", papers);
					request.setAttribute("remarkRow", remark);
					request.setAttribute("preparationOneRow", preparation_one);
					request.setAttribute("preparationTwoRow", preparation_two);
					request.setAttribute("preparationThreeRow", preparation_three);
					request.setAttribute("preparationFourRow", preparation_four);
					request.setAttribute("preparationFiveRow", preparation_five);
					request.setAttribute("verifierRow", verifier);
				}
				else {
					this.project_expert.setId(Integer.parseInt(id));
					//填充
					Map[] primaryRows = this.projectExpertService.query(Integer.parseInt(id));
					for(Map m : primaryRows){
						request.setAttribute("idRow", m.get("编号"));
						request.setAttribute("nameRow", m.get("姓名"));
						request.setAttribute("professionRow", m.get("专业"));
						request.setAttribute("departmentRow", m.get("所在单位"));
						request.setAttribute("educationBackgroundRow", m.get("学历"));
						request.setAttribute("graduationSchoolRow", m.get("毕业学校"));
						request.setAttribute("workingTimeRow", m.get("参加工作时间"));
						request.setAttribute("identifiedCardRow", m.get("身份证"));
						request.setAttribute("jobRow", m.get("职务"));
						request.setAttribute("jobTitleRow", m.get("职称"));
						request.setAttribute("contactNumberRow", m.get("联系电话"));
						request.setAttribute("telephoneRow", m.get("手机"));
						request.setAttribute("faxRow", m.get("传真"));
						request.setAttribute("emailRow", m.get("email"));
						request.setAttribute("mailingAddressRow", m.get("通讯地址"));
						request.setAttribute("postcodeRow", m.get("邮编"));
						request.setAttribute("technicalExpertiseRow", m.get("技术专长"));
						request.setAttribute("jobResumeRow", m.get("工作简历"));
						request.setAttribute("mainPerformanceRow", m.get("主要业绩"));
						request.setAttribute("awardsRow", m.get("获奖情况"));
						request.setAttribute("papersRow", m.get("著作及论文"));
						request.setAttribute("remarkRow", m.get("备注"));
						request.setAttribute("preparationOneRow", m.get("预留一"));
						request.setAttribute("preparationTwoRow", m.get("预留二"));
						request.setAttribute("preparationThreeRow", m.get("预留三"));
						request.setAttribute("preparationFourRow", m.get("预留四"));
						request.setAttribute("preparationFiveRow", m.get("预留五"));
						request.setAttribute("verifierRow", m.get("审核人"));
						
					}
					if(this.projectExpertService.update(project_expert)){
						//添加入系统日志
						this.log.setOperation("保存");
						this.logService.add(log);
						request.setAttribute("msg", "<script>alert('更新成功！')</script>");
					}
					else {
						request.setAttribute("msg", "<script>alert('更新失败！')</script>");
					}
				}
				request.getRequestDispatcher("project_expert_insert.jsp").forward(request, response);
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
						this.project_expert.setId(Integer.parseInt(id));
						this.project_expert.setName(name);
						this.project_expert.setProfession(profession);
						this.project_expert.setDepartment(department);
						this.project_expert.setEducation_background(education_background);
						this.project_expert.setGraduation_school(graduation_school);
						this.project_expert.setWorking_time(working_time);
						this.project_expert.setIdentified_card(identified_card);
						this.project_expert.setJob(job);
						this.project_expert.setJob_title(job_title);
						this.project_expert.setContact_number(contact_number);
						this.project_expert.setTelephone(telephone);
						this.project_expert.setFax(fax);
						this.project_expert.setEmail(email);
						this.project_expert.setMailing_address(mailing_address);
						this.project_expert.setPostcode(postcode);
						this.project_expert.setTechnical_expertise(technical_expertise);
						this.project_expert.setJob_resume(job_resume);
						this.project_expert.setMain_performance(main_performance);
						this.project_expert.setAwards(awards);
						this.project_expert.setPapers(papers);
						this.project_expert.setRemark(remark);
						this.project_expert.setPreparation_one(preparation_one);
						this.project_expert.setPreparation_two(preparation_two);
						this.project_expert.setPreparation_three(preparation_three);
						this.project_expert.setPreparation_four(preparation_four);
						this.project_expert.setPreparation_five(preparation_five);
						this.project_expert.setVerifier(verifier);
						//重设默认审核人
						this.userService.setDefaultVerifier(UserName, verifier);
						if(this.projectExpertService.maintenance(project_expert)){
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
				Map[] primaryRows = this.projectExpertService.query(Integer.parseInt(id));
				for(Map m : primaryRows){
					request.setAttribute("idRow", m.get("编号"));
					request.setAttribute("nameRow", m.get("姓名"));
					request.setAttribute("professionRow", m.get("专业"));
					request.setAttribute("departmentRow", m.get("所在单位"));
					request.setAttribute("educationBackgroundRow", m.get("学历"));
					request.setAttribute("graduationSchoolRow", m.get("毕业学校"));
					request.setAttribute("workingTimeRow", m.get("参加工作时间"));
					request.setAttribute("identifiedCardRow", m.get("身份证"));
					request.setAttribute("jobRow", m.get("职务"));
					request.setAttribute("jobTitleRow", m.get("职称"));
					request.setAttribute("contactNumberRow", m.get("联系电话"));
					request.setAttribute("telephoneRow", m.get("手机"));
					request.setAttribute("faxRow", m.get("传真"));
					request.setAttribute("emailRow", m.get("email"));
					request.setAttribute("mailingAddressRow", m.get("通讯地址"));
					request.setAttribute("postcodeRow", m.get("邮编"));
					request.setAttribute("technicalExpertiseRow", m.get("技术专长"));
					request.setAttribute("jobResumeRow", m.get("工作简历"));
					request.setAttribute("mainPerformanceRow", m.get("主要业绩"));
					request.setAttribute("awardsRow", m.get("获奖情况"));
					request.setAttribute("papersRow", m.get("著作及论文"));
					request.setAttribute("remarkRow", m.get("备注"));
					request.setAttribute("preparationOneRow", m.get("预留一"));
					request.setAttribute("preparationTwoRow", m.get("预留二"));
					request.setAttribute("preparationThreeRow", m.get("预留三"));
					request.setAttribute("preparationFourRow", m.get("预留四"));
					request.setAttribute("preparationFiveRow", m.get("预留五"));
					request.setAttribute("verifierRow", m.get("审核人"));
					
				}
				request.getRequestDispatcher("project_expert_insert.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msg", "<script>alert('非法访问，无相应参数！')</script>");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

}
