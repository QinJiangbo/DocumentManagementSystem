package service;

import java.util.Map;

import pojo.User;
@SuppressWarnings("rawtypes")
public interface IUserService {
	public boolean add(User user);
	public boolean update(User user);
	public boolean delete(String name);
	public boolean changePwd(String uname,String newPwd);
	public boolean login(String name,String pwd);
	public boolean checkName(String name);
	public boolean checkPwd(String name,String oldPwd);
	public boolean register(User user);
	public int getLevel(String name);
	public String getRealName(String name);
	public String getDefaultVerifier(String UserName);
	public Map[] getDefaultVerifierRows();
	public Map[] getUserMsg(int UserLevel);
	public Map[] getUserDetail(int id);
	public void setDefaultVerifier(String UserName,String verfify);
}
