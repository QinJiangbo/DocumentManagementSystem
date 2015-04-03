
package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Config;
import pojo.Log;
import service.FileService;
import service.ILogService;
import service.LogServiceImpl;
public class DownloadServlet extends HttpServlet {
	private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	FileService fileService=new FileService();

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			this.log.setUname(UserName);
			this.log.setTime(this.date.format(new Date()));
			fileService.ClearTempDir();
			String method=request.getParameter("method");
			if(method.equals("zipFilesDownload"))
			{
				//String[] srcfiles=request.getParameterValues("downloadFile");
				String files = request.getParameter("files");
				files = java.net.URLDecoder.decode(files, "utf-8");
			    List<String> srcfiles = parseJsonToArray(files);
				List<File> fileList=new ArrayList<File>();
				for(int i=0;i<srcfiles.size();i++)
				{
					File downloadFile=new File(srcfiles.get(i));
					fileList.add(downloadFile);
				}
				
				File[] destFile=new File[fileList.size()];
				fileList.toArray(destFile);
				Date date=new Date();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
				String zipPath=Config.downloadRootPath+"temp/"+dateFormat.format(date).toString()+".zip";
				File zipfile=new File(zipPath);
				if(!zipfile.exists()){
					zipfile.createNewFile();
				}
				//System.out.println("正在压缩...");
				fileService.zipFiles(destFile, zipfile);
				
				/* 得到一个下载路径 */
				String zipFileDownloadPath=Config.ip+"temp/"+zipfile.getName();
				
				//request.setAttribute("msg", "<script>window.open("+zipFileDownloadPath+")</script>");
				//System.out.println(zipFileDownloadPath);
				//连接配置ftp连接
				PrintWriter out = response.getWriter();
				try{
					out.print(zipFileDownloadPath);
				}finally{
					out.close();
				}
				//添加入系统日志
				this.log.setTable("项目文件");
				this.log.setOperation("下载");
				this.logService.add(log);
			}
			else if(method.equals("singleFileDownload")){
				String downloadPath=new String(request.getParameter("path").getBytes("ISO-8859-1"),"UTF-8");
				//System.out.println(downloadPath);
				
				//得到当前文件
				File srcfile=new File(downloadPath);
				
				//添加到链表中去
				List<File> fileList=new ArrayList<File>();
				fileList.add(srcfile);
				File[] destFile=new File[fileList.size()];
				fileList.toArray(destFile);
				
				//获取相对路径
				//String filedownload=fileService.getRelativePath(Config.initPath, downloadPath);
				//System.out.println(filedownload);
				
				Date date=new Date();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
				String zipPath=Config.downloadRootPath+"temp/"+dateFormat.format(date).toString()+".zip";
				File zipfile=new File(zipPath);
				if(!zipfile.exists()){
					zipfile.createNewFile();
				}
				fileService.zipFiles(destFile, zipfile);
				/* 得到一个下载路径 */
				String zipFileDownloadPath=Config.ip+"temp/"+zipfile.getName();
				//String fileDownloadPath=Config.ip+"upload"+filedownload;
				//连接配置ftp连接
				PrintWriter out = response.getWriter();
				try{
					out.print(zipFileDownloadPath);
				}finally{
					out.close();
				}
				//添加入系统日志
				this.log.setTable("项目文件");
				this.log.setOperation("下载");
				this.logService.add(log);
			}

		}
}

	private List<String> parseJsonToArray(String data) {
		 List<String> list = new ArrayList<String>();
         if (null == data || data.length() == 0) {
             return null;
         }
         String temp = data.substring(2, data.length() - 2);
         temp = temp.replaceAll("\\'", "");
         String splitResult[] = temp.split(",");
         for (int i = 0; i < splitResult.length; i++) {
             list.add(splitResult[i].substring(splitResult[i].indexOf(":") + 1));
         }
         return list;
	}

}




















