/** 
* Copyright (c) 2014-2015 Founder QinJiangbo All Rights Reserved   
* @author Qinjiangbo Wuhan University
* @version 1.0, 2014-8-1 下午10:21:02  
*/   

package pojo;

public class MyFile {
	public String fileName;
	public String filePath;
	public String fileType;
	public String lastModified;
	public long fileSize;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

}
