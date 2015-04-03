/** 
* Copyright (c) 2014-2015 Founder QinJiangbo All Rights Reserved   
* @author Qinjiangbo Wuhan University
* @version 1.0, 2014-9-11 下午11:49:02  
*/   

package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.MyFile;
import service.FileService;

public class AjaxFileServlet extends HttpServlet {

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

		doPost(request, response);
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
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		String method=request.getParameter("method");
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
			session.setAttribute("currentPath", pathTransfer);
			//request.setAttribute("myFileList", myFileList);
			out.print(myFileList); 
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
			session.setAttribute("currentPath",
					fileService.getParentPath(pathTransfer));
			//request.setAttribute("myFileList", myFileList);
			out.print(myFileList);
		};
	}

}
