/** 
* Copyright (c) 2014-2015 Founder QinJiangbo All Rights Reserved   
* @author Qinjiangbo Wuhan University
* @version 1.0, 2014-8-1 下午12:14:10  
*/   

package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;

import pojo.Config;

public class FileService {
	/**
	 * 获取指定目录下的指定后缀名的文件及其所在目录
	 * @param fileList 存储文件路径的数组链表
	 * @param path 文件路径
	 * @param fileSuffix 文件后缀名
	 */
	public void getFiles(List<File> fileList, String path, String fileSuffix )
	{
		File file=new File(path);
		File[] files=file.listFiles();
		if(files==null){
			//System.out.println("该目录不存在或该目录下不存在任何文件！");
			return;
		}else
		{
			for(int i=0;i<files.length;i++)
			{
				if(files[i].isDirectory())
				{
					getFiles(fileList,getAvailablePath(files[i]),fileSuffix);
					fileList.add(files[i]);
				}else if(files[i].getName().lastIndexOf(fileSuffix)!=-1)
				{
					fileList.add(files[i]);
				}
			}
		}
	}
	
	/**
	 * 获取文件的路径
	 * @param file
	 * @return 文件的路径
	 */
	public String getAvailablePath(File file)
	{
		return file.getPath().replace("\\", "/");
	}
	
	/**
	 * 删除指定文件
	 * @param pathAndName 文件路径和名称
	 */
	public void deleteFile(String pathAndName,HttpServletRequest request)
	{
		try{
			File file = new File(pathAndName);
			if (!file.exists()){
				request.setAttribute("msg", "<script>alert('文件不存在！')</script>");
				//System.out.println("文件不存在！");
			}
			else 
			{
				if (file.delete()) {
					request.setAttribute("msg", "<script>alert('删除文件成功！')</script>");
					//System.out.println("删除文件成功！");
				} else {
					request.setAttribute("msg", "<script>alert('删除文件失败！')</script>");
					//System.out.println("删除文件失败！");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void deleteFile(String pathAndName){
		try{
			File file = new File(pathAndName);
			if (!file.exists()){
				//System.out.println("文件不存在！");
			}
			else 
			{
				if (file.delete()) {
					//System.out.println("删除文件成功！");
				} else {
					//System.out.println("删除文件失败！");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 删除文件夹
	 * @param folderPath 文件夹路径
	 */
	public boolean deleteFolder(String folderPath)
	{
		try{
			deleteFolderAll(folderPath);
			File file=new File(folderPath);
			file.delete();
			return true;
		}catch(Exception ex)
		{
			//System.out.println("删除文件夹操作出错！");
			ex.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 递归删除指定文件夹里面的全部文件
	 * @param path 文件夹路径
	 */
	public void deleteFolderAll(String path)
	{	
		File file=new File(path);
		if(!file.exists())
		{
			//System.out.println("指定目录不存在！");
			return;
		}
		if(!file.isDirectory())
		{
			//System.out.println("该目录指向的不是文件夹！");
			return;
		}
		File[] tempList=file.listFiles();
		File temp=null;
		for(int i=0;i<tempList.length;i++)
		{
			if(path.endsWith(File.separator))
			{
				temp=new File(path+tempList[i].getName().toString());
			}else
			{
				temp=new File(path+File.separator+tempList[i].getName().toString());
			}
			if(temp.isFile())
			{
				temp.delete();
			}
			if(temp.isDirectory())
			{
				deleteFolderAll(path+"/"+tempList[i].getName().toString());//先删除文件夹里面的所有文件
				deleteFolder(path+"/"+tempList[i].getName().toString()); //再删除空文件夹
			}
		}
		//System.out.println("文件夹删除成功！");
	}
	
	/**
	 * 获取当前文件路径下面的所有文件夹和文件
	 * @param fileList 文件链表
	 * @param path 文件当前路径
	 */
	public void getCurrentDirectoryFiles(List<File> fileList, String path)
	{
		File file=new File(path);
		File[] files=file.listFiles();
		if(files==null){
			//System.out.println("该文件夹为空！");
			return;
		}else
		{
			for(int i=0;i<files.length;i++)
			{
				fileList.add(files[i]);
			}
		}
	}
	
	/**
	 * 新建一个文件并且给它输入内容
	 * @param filePathAndName 文件路径和文件名
	 * @param fileContent 文件内容
	 */
	public void newFile(String filePathAndName,String fileContent)
	{
		try{
			File file=new File(filePathAndName);
			if(!file.exists())
			{
				file.createNewFile();
				//System.out.println("新建文件成功！");
			}else
			{
				//System.out.println("文件已经存在，无法创建！");
			}
			FileWriter fw=new FileWriter(filePathAndName);
			PrintWriter pw=new PrintWriter(fw);
			pw.println(fileContent);
			fw.close();
		}catch(Exception ex){
			//System.out.println("新建文件出错！");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 根据父目录创建一个文件夹
	 * @param path 
	 * @param dirName
	 */
	public void newFolder(String path,String folderName,HttpServletRequest request)
	{
		File file=new File(path+"/"+folderName);
		if(file.exists())
		{
			request.setAttribute("msg", "<script>alert('该目录已存在，无法创建新的目录！')</script>");
			//System.out.println("该目录已存在，无法创建新的目录！");
		}else
		{
			if(file.mkdir())
			{
				request.setAttribute("msg", "<script>alert('目录创建成功！')</script>");
				//System.out.println("目录创建成功！");
			}else
			{
				request.setAttribute("msg", "<script>alert('目录创建失败！')</script>");
				//System.out.println("目录创建失败！");
			}
		}
	}
	
	/**
	 * 复制一个文件
	 * @param oldPathAndName 原始路径及名称
	 * @param newPathAndName 目标路径及名称
	 */
	@SuppressWarnings("resource")
	public void copyFile(String oldPathAndName,String newPathAndName)
	{
		try{
			int byteread=0;
			File oldFile=new File(oldPathAndName);
			if(oldFile.exists())
			{
				InputStream inStream=new FileInputStream(oldPathAndName);//读入文件
				FileOutputStream outStream=new FileOutputStream(newPathAndName);  //写入文件
				byte[] buffer=new byte[1444];
				while((byteread=inStream.read(buffer))!=-1)
				{
					outStream.write(buffer,0,byteread);
				}
				//System.out.println("复制成功！");
				inStream.close();
			}
		}catch(Exception e)
		{
			//System.out.println("复制单个文件出错！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 复制一个文件夹
	 * @param oldPath 原始路径
	 * @param newPath 目标路径
	 */
	public void copyFolder(String oldPath,String newPath)
	{
		try{
			File myFile=new File(newPath);
			myFile.mkdirs();//若文件不存在就新建一个
			File file=new File(oldPath);
			if(!file.exists())
			{
				//System.out.println("指定目录不存在！");
				return;
			}
			if(!file.isDirectory())
			{
				//System.out.println("该目录指向的不是文件夹！");
				return;
			}
			File[] fileList=file.listFiles();
			File temp=null;
			for(int i=0;i<fileList.length;i++)
			{
				if(oldPath.endsWith(File.separator))
				{
					temp=new File(oldPath+fileList[i].getName().toString());
				}else
				{
					temp=new File(oldPath+File.separator+fileList[i].getName().toString());
				}
				
				if(fileList[i].isFile())
				{
					FileInputStream input=new FileInputStream(temp);
					FileOutputStream output=new FileOutputStream(newPath+"/"+(temp.getName()).toString());
					byte[] buffer=new byte[1024*5];
					int length;
					while((length=input.read(buffer))!=-1)
					{
						output.write(buffer, 0, length);
					}
					output.flush();
					output.close();
					input.close();
				}
				if(fileList[i].isDirectory())
				{
					copyFolder(oldPath+"/"+fileList[i].getName().toString(),newPath+"/"+fileList[i].getName().toString());
				}
			}
		}catch(Exception ex)
		{
			//System.out.println("复制文件夹操作出错！");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 移动文件操作
	 * @param oldPath 原始路径
	 * @param newPath 目标路径
	 */
	public void removeFile(String oldPath,String newPath,HttpServletRequest request)
	{
		copyFile(oldPath,newPath);
		deleteFile(oldPath,request);
	}
	
	/**
	 * 移动文件夹
	 * @param oldPath 原始路径
	 * @param newPath 目标路径
	 * @throws IOException
	 */
	public void removeFolder(String oldPath,String newPath)
	{
		copyFolder(oldPath,newPath);
		deleteFolderAll(oldPath);
		deleteFolder(oldPath);
	}
	
	/**
	 * 获取当前路径的上一级路径
	 * @param currentPath 当前路径
	 * @return 上一级路径
	 */
	public String getParentPath(String currentPath)
	{
		String parentPath="";
		if(currentPath.lastIndexOf("/")==2)
		{
			parentPath=currentPath;
		}else
		{
			File file=new File(currentPath);
			parentPath=currentPath.substring(0, currentPath.lastIndexOf(file.getName()));
		}
		return parentPath;
	}
	
	/**
	 * 获取单个文件的大小
	 * @param file 当前文件
	 * @return long 文件大小
	 */
	public long getFileSize(File file){
		long size=0;
		try{
			if(file.exists())
			{
				FileInputStream input=new FileInputStream(file);
				size=input.available();
				input.close();//这个地方尤其关键，一定要关闭，否则文件删除不掉的！
			}else
			{
				file.createNewFile();
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return size;
	}
	
	/**
	 * 获取单个文件夹的大小
	 * @param file 当前文件夹
	 * @return long 文件夹大小
	 */
	public long getFolderSize(File file){
		long size=0;
		File[] files=file.listFiles();
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isDirectory())
			{
				size=size+getFolderSize(files[i]);
			}else
			{
				size=size+files[i].length();
			}
		}
		return size;
	}
	
	/**
	 * 压缩全部选中文件
	 * @param srcfile 源文件列表
	 * @param zipfile 目标压缩文件
	 */
	public void zipFiles(File[] srcfile,File zipfile){
        byte[] buf=new byte[1024];
        try {
            //ZipOutputStream类：完成文件或文件夹的压缩
            ZipOutputStream out=new ZipOutputStream(new FileOutputStream(zipfile));
            for(int i=0;i<srcfile.length;i++){
                FileInputStream in=new FileInputStream(srcfile[i]);
                out.putNextEntry(new ZipEntry(srcfile[i].getName()));
                int len;
                while((len=in.read(buf))>0){
                    out.write(buf,0,len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
            //System.out.println("压缩完成!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * 获取相对路径
	 * @param rootPath 根目录
	 * @param path 文件目录
	 * @return 相对路径
	 */
	public String getRelativePath(String rootPath,String path)
	{
		int index=rootPath.length();
		String relativePath=path.substring(index, path.length());
		return relativePath;
	}
	
	/**
	 * 定时清理temp目录
	 */
	@SuppressWarnings("deprecation")
	public void ClearTempDir(){
		Date date=new Date();
		SimpleDateFormat DateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		String tempDir=Config.tempDir;
		if(Calendar.getInstance().getTime().getHours()>12){
			List<File> fileList = new ArrayList<File>();
			getCurrentDirectoryFiles(fileList,tempDir);
			long threeDaysAgoTime=Long.parseLong(DateFormat.format(date).toString())-1000000;
			for(int i=0;i<fileList.size();i++){
				long tempFileTime=Long.parseLong(fileList.get(i).getName().substring(0,14));
				if(tempFileTime<threeDaysAgoTime){
					deleteFile(getAvailablePath(fileList.get(i)));
				}
			}
		}
	}
}
