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
import pojo.User;
import service.ILogService;
import service.IUserService;
import service.LogServiceImpl;
import service.UserServiceImpl;
@SuppressWarnings("rawtypes")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService UService=new UserServiceImpl();
	private User user = new User();
    private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			 HttpSession session = request.getSession(true);
			 request.setCharacterEncoding("utf-8");
			 response.setContentType("text/html;charset=utf-8");
			 request.setAttribute("run", "1");//程序运行标识
			 String UserName = (String)session.getAttribute("UserName");
			 String act = request.getParameter("act");
			 String op = request.getParameter("op");
			 
			 if(act.equals("login")){
				 String name = request.getParameter("name");
				 String pwd = request.getParameter("pwd");
				 if(this.UService.login(name, pwd)){
					 int level = this.UService.getLevel(name);
					 session.setAttribute("UserName", this.UService.getRealName(name));
					 session.setAttribute("Userlevel", level);
					 session.setMaxInactiveInterval(3600);//1小时断开连接，需重新登录
					 //添加系统日志
					 this.log.setUname(this.UService.getRealName(name));
					 this.log.setTable("账户管理");
					 this.log.setTime(this.date.format(new Date()));
					 this.log.setOperation("登录");
					 this.logService.add(log);
					 request.getRequestDispatcher("index.jsp").forward(request, response);
					 return;
				 }
				 else{
					 request.setAttribute("msg","<script>alert('用户名或密码错误！');</script>");
					 request.getRequestDispatcher("login.jsp").forward(request, response);
					 return;
				 }
			 }
			 else if(act.equals("add")){
				 if(this.UService.checkName(request.getParameter("reg_user_name"))){
					 request.setAttribute("msg","<script>alert('已存在相同用户名，添加失败！')</script>");
				 }
				 else{
					 this.user.setAuthority(Integer.parseInt(request.getParameter("authority")));
					 this.user.setUserName(request.getParameter("reg_user_name"));
					 this.user.setPassword(request.getParameter("reg_password"));
					 this.user.setRealName(request.getParameter("real_name"));
					 this.user.setEmail(request.getParameter("email"));
					 this.UService.add(user);
					 //添加系统日志
					 this.log.setUname(UserName);
					 this.log.setTable("账户管理");
					 this.log.setTime(this.date.format(new Date()));
					 this.log.setOperation("添加用户");
					 this.logService.add(log);
					 request.setAttribute("msg","<script>alert('添加成功！')</script>");
				 }
				 request.getRequestDispatcher("new_user.jsp").forward(request, response);
			 }
			 else if(act.equals("update")){
				 Map[] rows = this.UService.getUserDetail(Integer.parseInt(request.getParameter("id")));
				 for(Map m : rows){
					 request.setAttribute("uid",m.get("用户编号"));
					 request.setAttribute("uname",m.get("用户名"));
					 request.setAttribute("urname",m.get("用户姓名"));
					 request.setAttribute("uemail",m.get("邮箱"));
					 request.setAttribute("upwd",m.get("密码"));
					 request.setAttribute("ulevel",m.get("权限"));
				 }
				 if(op!=null){
					 if(op.equals("update")){
						 this.user.setId(Integer.parseInt(request.getParameter("id")));
						 this.user.setAuthority(Integer.parseInt(request.getParameter("authority")));
						 this.user.setUserName(request.getParameter("reg_user_name"));
						 this.user.setPassword(request.getParameter("reg_password"));
						 this.user.setRealName(request.getParameter("real_name"));
						 this.user.setEmail(request.getParameter("email"));
						 this.UService.update(user);
						 request.setAttribute("msg","<script>alert('修改成功！')</script>");
						 Map[] rows2 = this.UService.getUserDetail(Integer.parseInt(request.getParameter("id")));
						 for(Map m : rows2){
							 request.setAttribute("uid",m.get("用户编号"));
							 request.setAttribute("uname",m.get("用户名"));
							 request.setAttribute("urname",m.get("用户姓名"));
							 request.setAttribute("uemail",m.get("邮箱"));
							 request.setAttribute("upwd",m.get("密码"));
							 request.setAttribute("ulevel",m.get("权限"));
						 }
					 }
					 //添加系统日志
					 this.log.setUname(UserName);
					 this.log.setTable("账户管理");
					 this.log.setTime(this.date.format(new Date()));
					 this.log.setOperation("更新用户");
					 this.logService.add(log);
				 }
				 request.setAttribute("pageName", "UserServlet");
				 request.setAttribute("op", "update");
				 request.getRequestDispatcher("new_user.jsp").forward(request, response);
			 }
			 else if(act.equals("changePwd")){
				 String old_password= request.getParameter("old_password");
				 request.setAttribute("UserName", UserName);
				 if(!this.UService.checkPwd(UserName,old_password)){
					 request.setAttribute("msg","<script>alert('旧密码输入错误！')</script>");
					 request.getRequestDispatcher("change_password.jsp").forward(request, response);
				 }
				 else{
					 String new_password = request.getParameter("new_password");
					 if(this.UService.changePwd(session.getAttribute("UserName").toString(),new_password)){
						 //添加系统日志
						 this.log.setUname(UserName);
						 this.log.setTable("账户管理");
						 this.log.setTime(this.date.format(new Date()));
						 this.log.setOperation("修改密码");
						 this.logService.add(log);
						 request.setAttribute("msg","<script>alert('修改密码成功！')</script>");
						 request.getRequestDispatcher("change_password.jsp").forward(request, response);
					 }
					 else{
						 request.setAttribute("msg","<script>alert('修改密码失败！')</script>");
						 request.getRequestDispatcher("change_password.jsp").forward(request, response);
					 }
				 }
			 }
			 else if(act.equals("logout")){
				 PrintWriter out = response.getWriter();
				 try{
					 //添加系统日志
					 this.log.setUname(UserName);
					 this.log.setTable("账户管理");
					 this.log.setTime(this.date.format(new Date()));
					 this.log.setOperation("注销");
					 this.logService.add(log);
					 session.invalidate();//注销session
					 out.print("OK");
				 }finally{
					 out.close();
				 }
			 }
			 else if(act.equals("index")){
				 if(session.getAttribute("UserName")!=null){
					 request.getRequestDispatcher("index.jsp").forward(request, response);
				 }
				 else{
					 request.getRequestDispatcher("login.jsp").forward(request, response);
				 }
			 }
			 
			 
	}

}
