package service;

import java.util.Map;

import pojo.User;
import dao.DbHelperImpl;
import dao.IDbHelper;
@SuppressWarnings("rawtypes")
public class UserServiceImpl implements IUserService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean add(User user) {
		String sql = "insert into [dbo].[账户管理]([用户名],[用户姓名],[密码],[邮箱],[默认审核人],[权限]) values(?,?,?,?,'刘璟',?)";
		Object[] params = {user.getUserName(),user.getRealName(),user.getPassword(),user.getEmail(),user.getAuthority()};
		dao.update(sql, params);
		return true;
	}
	@Override
	public boolean update(User user) {
		String sql = "update [dbo].[账户管理] set [用户名]=?,[用户姓名]=?,[密码]=?,[邮箱]=?,[权限]=? where [用户编号] = ?";
		Object[] params = {user.getUserName(),user.getRealName(),user.getPassword(),user.getEmail(),user.getAuthority(),user.getId()};
		dao.update(sql, params);
		return true;
	}
	@Override
	public boolean delete(String name) {
		String sql = "delete from [dbo].[账户管理] where [用户姓名] = ?";
		Object[] params = {name};
		dao.update(sql, params);
		return true;
	}
	@Override
	public boolean changePwd(String uname, String newPwd) {
		String sql = "update [dbo].[账户管理] set [密码]=? where [用户姓名] = ?";
		Object[] params = {newPwd,uname};
		dao.update(sql, params);
		return true;
	}
	@Override
	public boolean login(String name, String pwd) {
		String sql="SELECT count(*) n FROM [dbo].[账户管理] where [用户名] = ? and [密码] = ?";
		Object[] params={name,pwd};
		Map row=dao.select(sql, params)[0];
		int n=Integer.parseInt(row.get("n").toString());
		return n==1;
	}
	@Override
	public boolean checkName(String name) {
		String sql = "select count(*) n from [dbo].[账户管理] where [用户姓名]=?";
		Object[] params = {name};
		return Integer.parseInt(dao.select(sql, params)[0].get("n").toString())==1;
	}
	@Override
	public boolean register(User user) {
		String sql = "insert into [dbo].[账户管理]([用户名],[用户姓名],[密码],[邮箱],[权限]) values(?,?,?,?,5)";
		Object[] params = {user.getUserName(),user.getRealName(),user.getPassword(),user.getEmail()};
		dao.update(sql, params);
		return true;
	}
	@Override
	public int getLevel(String name) {
		String sql = "select [权限] from [dbo].[账户管理] where [用户名]=?";
		Object[] params = {name};
		return Integer.parseInt(dao.select(sql, params)[0].get("权限").toString());
	}
	@Override
	public Map[] getDefaultVerifierRows() {
		String sql = "select [用户姓名] from [账户管理] ";
		return this.dao.select(sql);
	}
	@Override
	public Map[] getUserMsg(int UserLevel) {
		String sql = "select [用户编号],[用户姓名],[权限] from [dbo].[账户管理] where [权限]>?";
		Object[] params = {UserLevel};
		return this.dao.select(sql, params);
	}
	@Override
	public Map[] getUserDetail(int id) {
		String sql = "select * from [dbo].[账户管理] where [用户编号]=?";
		Object[] params = {id};
		return this.dao.select(sql, params);
	}
	@Override
	public String getRealName(String name) {
		String sql = "select [用户姓名] from [dbo].[账户管理] where [用户名] = ?";
		Object[] params = {name};
		return this.dao.select(sql,params)[0].get("用户姓名").toString();
	}
	@Override
	public void setDefaultVerifier(String UserName, String verify) {
		String sql = "update [dbo].[账户管理] set [默认审核人] = ? where [用户姓名] = ?";
		Object[] params = {UserName,verify};
		this.dao.update(sql, params);
	}
	@Override
	public boolean checkPwd(String name, String oldPwd) {
		String sql = "select count(*) n from [dbo].[账户管理] where [用户姓名] = ? and [密码] = ?";
		Object[] params = {name,oldPwd};
		return Integer.parseInt(this.dao.select(sql, params)[0].get("n").toString())==1;
	}
	@Override
	public String getDefaultVerifier(String UserName) {
		String sql = "select [默认审核人] from [dbo].[账户管理] where [用户姓名] = ?";
		Object[] params = {UserName};
		return this.dao.select(sql, params)[0].get("默认审核人").toString();
	}
	
}
