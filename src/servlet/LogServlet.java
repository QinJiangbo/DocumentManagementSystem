package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Log;
import service.ILogService;
import service.IUserService;
import service.LogServiceImpl;
import service.UserServiceImpl;

/**
 * Servlet implementation class LogServlet
 */
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
	private IUserService userService = new UserServiceImpl();
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServlet() {
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
			this.log.setTable("日志");
			this.log.setTime(this.date.format(new Date()));
			String act = request.getParameter("act");
			if(session.getAttribute("Userlevel")==null){
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				request.setAttribute("Uname",this.userService.getDefaultVerifierRows());
				if(act.equals("delete")){
					String id = request.getParameter("id");
					String uname = request.getParameter("uname");
					this.logService.delete(Integer.parseInt(id));
					if(uname!=null){
						uname = new String(uname.getBytes("ISO-8859-1"),"UTF-8");
						request.setAttribute("rows", this.logService.getAllLog(uname));
					}
					else{
						request.setAttribute("rows", this.logService.getAllLog());
					}
					this.log.setOperation("删除");
					this.logService.add(log);
					request.setAttribute("msg", "<script>alert('删除成功！')</script>");
					request.getRequestDispatcher("system_journal.jsp").forward(request, response);
				}
				else if(act.equals("batDelete")){
					String username = request.getParameter("username");
					String starttime = request.getParameter("starttime");
					String endtime = request.getParameter("endtime");
					if(username==null||username==""){
						this.logService.delete(starttime, endtime);
					}
					else{
						this.logService.delete(username, starttime, endtime);
					}
					this.log.setOperation("批量删除");
					this.logService.add(log);
					request.setAttribute("rows", this.logService.getAllLog());
					request.setAttribute("msg", "<script>alert('删除成功！')</script>");
					request.getRequestDispatcher("system_journal.jsp").forward(request, response);
				}
				else if(act.equals("view")){
					String uname = new String(request.getParameter("uname").getBytes("ISO-8859-1"),"UTF-8");
					request.setAttribute("rows", this.logService.getAllLog(uname));
					request.setAttribute("uname", uname);
					this.log.setOperation("查看日志");
					this.logService.add(log);
					request.getRequestDispatcher("system_journal.jsp").forward(request, response);
				}
			}
		}
		
	}

}
