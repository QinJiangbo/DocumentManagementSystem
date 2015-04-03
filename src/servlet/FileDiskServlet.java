
package servlet;

import java.io.File;
import java.io.IOException;
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
import pojo.MyFile;
import service.FileService;
import service.ILogService;
import service.LogServiceImpl;
public class FileDiskServlet extends HttpServlet {
    private Log log = new Log();
    private ILogService logService = new LogServiceImpl();
	private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileService fileService=new FileService();

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
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
		HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		request.setAttribute("run", "1");//程序运行标识
		String Userlevel = session.getAttribute("Userlevel").toString();
		String UserName = (String) session.getAttribute("UserName");
		if(UserName==null){
			request.setAttribute("msg", "<script>alert('对不起，请先登录！')</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else{
			if(Integer.parseInt(Userlevel)>0){
				request.setAttribute("msg", "<script>alert('对不起，您无相应权限访问此页面！')</script>");
				request.getRequestDispatcher("ActionServlet?act=Undo&op=management").forward(request, response);
			}else{
				this.log.setUname(UserName);
				this.log.setTable("文件管理");
				this.log.setTime(this.date.format(new Date()));
				String method=request.getParameter("method");
				String displayDir=Config.downloadRootPath;
				if (method != null) {
					if (method.equals("init")) {
						String path = Config.ManagementPath;
						session.setAttribute("rootPath", path);
						List<File> fileList = new ArrayList<File>();
						List<MyFile> myFileList = new ArrayList<MyFile>();
						fileService.getCurrentDirectoryFiles(fileList, path);
						for (int i = 0; i < fileList.size(); i++) {
							MyFile myFile = new MyFile();
							myFile.setFileName(fileList.get(i).getName().toString());
							myFile.setFilePath(fileService.getAvailablePath(fileList
									.get(i)));
							Calendar cal = Calendar.getInstance();
							long time = fileList.get(i).lastModified();
							SimpleDateFormat formatter = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							cal.setTimeInMillis(time);
							myFile.setLastModified(formatter.format(cal.getTime()));
							if (fileList.get(i).isDirectory()) {
								myFile.setFileType("Folder");
								long size = fileService.getFolderSize(fileList.get(i)) / 1048576;
								myFile.setFileSize(size);
							} else {
								myFile.setFileType("File");
								long size = fileService.getFileSize(fileList.get(i)) / 1024;
								myFile.setFileSize(size);
							}
							myFileList.add(myFile);
						}
						request.setAttribute("currentPath", path);
						request.setAttribute("displayDir", fileService.getRelativePath(displayDir,path));
						request.setAttribute("myFileList", myFileList);
						request.getRequestDispatcher("file_management.jsp").forward(
								request, response);
					}
					if (method.equals("checkSubFiles")) {
						String path = request.getParameter("path");
						String pathTransfer = new String(path.getBytes("ISO-8859-1"),
								"UTF-8");
						List<File> fileList = new ArrayList<File>();
						List<MyFile> myFileList = new ArrayList<MyFile>();
						fileService.getCurrentDirectoryFiles(fileList, pathTransfer);
						for (int i = 0; i < fileList.size(); i++) {
							MyFile myFile = new MyFile();
							myFile.setFileName(fileList.get(i).getName().toString());
							myFile.setFilePath(fileService.getAvailablePath(fileList
									.get(i)));
							Calendar cal = Calendar.getInstance();
							long time = fileList.get(i).lastModified();
							SimpleDateFormat formatter = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							cal.setTimeInMillis(time);
							myFile.setLastModified(formatter.format(cal.getTime()));
							if (fileList.get(i).isDirectory()) {
								myFile.setFileType("Folder");
								long size = fileService.getFolderSize(fileList.get(i)) / 1048576;
								myFile.setFileSize(size);
							} else {
								myFile.setFileType("File");
								long size = fileService.getFileSize(fileList.get(i)) / 1024;
								myFile.setFileSize(size);
							}
							myFileList.add(myFile);
						}
						request.setAttribute("currentPath", pathTransfer);
						request.setAttribute("displayDir", fileService.getRelativePath(displayDir,pathTransfer));
						request.setAttribute("myFileList", myFileList);
						request.getRequestDispatcher("file_management.jsp").forward(
								request, response);
					}
					if (method.equals("checkParentFolder")) {
						String currentPath = request.getParameter("currentPath");
						String pathTransfer = new String(
								currentPath.getBytes("ISO-8859-1"), "UTF-8");
						List<File> fileList = new ArrayList<File>();
						List<MyFile> myFileList = new ArrayList<MyFile>();
						fileService.getCurrentDirectoryFiles(fileList,
								fileService.getParentPath(pathTransfer));
						for (int i = 0; i < fileList.size(); i++) {
							MyFile myFile = new MyFile();
							myFile.setFileName(fileList.get(i).getName().toString());
							myFile.setFilePath(fileService.getAvailablePath(fileList
									.get(i)));
							Calendar cal = Calendar.getInstance();
							long time = fileList.get(i).lastModified();
							SimpleDateFormat formatter = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							cal.setTimeInMillis(time);
							myFile.setLastModified(formatter.format(cal.getTime()));
							if (fileList.get(i).isDirectory()) {
								myFile.setFileType("Folder");
								long size = fileService.getFolderSize(fileList.get(i)) / 1048576;
								myFile.setFileSize(size);
							} else {
								myFile.setFileType("File");
								long size = fileService.getFileSize(fileList.get(i)) / 1024;
								myFile.setFileSize(size);
							}
							myFileList.add(myFile);
						}
						request.setAttribute("currentPath",
								fileService.getParentPath(pathTransfer));
						request.setAttribute("displayDir", fileService.getRelativePath(displayDir,fileService.getParentPath(pathTransfer)));
						request.setAttribute("myFileList", myFileList);
						request.getRequestDispatcher("file_management.jsp").forward(
								request, response);
					}
					if (method.equals("createNewFolder")) {
						String newFolderName = request.getParameter("newFolder");
						String currentPath = request.getParameter("currentPath");
						fileService.newFolder(currentPath, newFolderName, request);
						List<File> fileList = new ArrayList<File>();
						List<MyFile> myFileList = new ArrayList<MyFile>();
						fileService.getCurrentDirectoryFiles(fileList, currentPath);
						for (int i = 0; i < fileList.size(); i++) {
							MyFile myFile = new MyFile();
							myFile.setFileName(fileList.get(i).getName().toString());
							myFile.setFilePath(fileService.getAvailablePath(fileList
									.get(i)));
							Calendar cal = Calendar.getInstance();
							long time = fileList.get(i).lastModified();
							SimpleDateFormat formatter = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							cal.setTimeInMillis(time);
							myFile.setLastModified(formatter.format(cal.getTime()));
							if (fileList.get(i).isDirectory()) {
								myFile.setFileType("Folder");
								long size = fileService.getFolderSize(fileList.get(i)) / 1048576;
								myFile.setFileSize(size);
							} else {
								myFile.setFileType("File");
								long size = fileService.getFileSize(fileList.get(i)) / 1024;
								myFile.setFileSize(size);
							}
							myFileList.add(myFile);
						}
						this.log.setOperation("创建文件夹");
						this.logService.add(log);
						request.setAttribute("currentPath", currentPath);
						request.setAttribute("displayDir", fileService.getRelativePath(displayDir,currentPath));
						request.setAttribute("myFileList", myFileList);
						request.getRequestDispatcher("file_management.jsp").forward(
								request, response);
					}
					if (method.equals("deleteFile")) {
						String FilePathAndName = new String(request
								.getParameter("path").getBytes("ISO-8859-1"), "UTF-8");
						String currentPath = new String(request.getParameter(
								"currentPath").getBytes("ISO-8859-1"), "UTF-8");
						fileService.deleteFile(FilePathAndName, request);
						List<File> fileList = new ArrayList<File>();
						List<MyFile> myFileList = new ArrayList<MyFile>();
						fileService.getCurrentDirectoryFiles(fileList, currentPath);
						for (int i = 0; i < fileList.size(); i++) {
							MyFile myFile = new MyFile();
							myFile.setFileName(fileList.get(i).getName().toString());
							myFile.setFilePath(fileService.getAvailablePath(fileList
									.get(i)));
							Calendar cal = Calendar.getInstance();
							long time = fileList.get(i).lastModified();
							SimpleDateFormat formatter = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							cal.setTimeInMillis(time);
							myFile.setLastModified(formatter.format(cal.getTime()));
							if (fileList.get(i).isDirectory()) {
								myFile.setFileType("Folder");
								long size = fileService.getFolderSize(fileList.get(i)) / 1048576;
								myFile.setFileSize(size);
							} else {
								myFile.setFileType("File");
								long size = fileService.getFileSize(fileList.get(i)) / 1024;
								myFile.setFileSize(size);
							}
							myFileList.add(myFile);
						}
						request.setAttribute("currentPath", currentPath);
						request.setAttribute("displayDir", fileService.getRelativePath(displayDir,currentPath));
						request.setAttribute("myFileList", myFileList);
						request.getRequestDispatcher("file_management.jsp").forward(
								request, response);
					}
					if (method.equals("deleteFolder")) {
						String FolderPath = new String(request.getParameter("path")
								.getBytes("ISO-8859-1"), "UTF-8");
						String currentPath = new String(request.getParameter(
								"currentPath").getBytes("ISO-8859-1"), "UTF-8");
						fileService.deleteFolderAll(FolderPath);
						if (fileService.deleteFolder(FolderPath)) {
							request.setAttribute("msg",
									"<script>alert('文件夹删除成功！')</script>");
						} else {
							request.setAttribute("msg",
									"<script>alert('文件夹删除失败！')</script>");
						}
						List<File> fileList = new ArrayList<File>();
						List<MyFile> myFileList = new ArrayList<MyFile>();
						fileService.getCurrentDirectoryFiles(fileList, currentPath);
						for (int i = 0; i < fileList.size(); i++) {
							MyFile myFile = new MyFile();
							myFile.setFileName(fileList.get(i).getName().toString());
							myFile.setFilePath(fileService.getAvailablePath(fileList
									.get(i)));
							Calendar cal = Calendar.getInstance();
							long time = fileList.get(i).lastModified();
							SimpleDateFormat formatter = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							cal.setTimeInMillis(time);
							myFile.setLastModified(formatter.format(cal.getTime()));
							if (fileList.get(i).isDirectory()) {
								myFile.setFileType("Folder");
								long size = fileService.getFolderSize(fileList.get(i)) / 1048576;
								myFile.setFileSize(size);
							} else {
								myFile.setFileType("File");
								long size = fileService.getFileSize(fileList.get(i)) / 1024;
								myFile.setFileSize(size);
							}
							myFileList.add(myFile);
						}
						this.log.setOperation("删除文件夹");
						this.logService.add(log);
						request.setAttribute("currentPath", currentPath);
						request.setAttribute("displayDir", fileService.getRelativePath(displayDir,currentPath));
						request.setAttribute("myFileList", myFileList);
						request.getRequestDispatcher("file_management.jsp").forward(
								request, response);
					}
				}
			}
		}
		
		
	}
}
