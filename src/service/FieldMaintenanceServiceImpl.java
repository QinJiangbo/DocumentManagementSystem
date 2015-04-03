package service;

import java.util.Map;

import dao.DbHelperImpl;
import dao.IDbHelper;
@SuppressWarnings("rawtypes")
public class FieldMaintenanceServiceImpl implements IFieldMaintenanceService {
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public boolean changeNewName(String tableName,String oldName, String NewName) {
		String sql  = "update [dbo].[字段维护] set [新名称] = ? where [表名] = ? and [旧名称] = ?";
		Object[] params = {NewName,tableName,oldName};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean add(String tableName, String NewName, String defaultValue) {
		String sql = "insert into [dbo].[字段维护]([表名],[新名称],[缺省值]) values(?,?,?)";
		Object[] params = {tableName,NewName,defaultValue};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public boolean delete(String tableName, String NewName, String defaultValue) {
		String sql = "delete from [dbo].[字段维护] where [表名]=? and [新名称]=? and [缺省值]=?";
		Object[] params = {tableName,NewName,defaultValue};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public Map[] query(String tableName, String NewName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Use(String tableName, String NewName, int state) {
		String sql  = "update [dbo].[字段维护] set [状态] = ? where [表名] = ? and [新名称] =?";
		Object[] params = {state,tableName,NewName};
		this.dao.update(sql, params);
		return true;
	}

	@Override
	public int isUse(String tableName, String oldName) {
		String sql  = "select [状态] from [dbo].[字段维护] where [表名] = ? and [旧名称] =?";
		Object[] params = {tableName,oldName};
		return Integer.parseInt((String) this.dao.select(sql, params)[0].get("状态"));
	}

	@Override
	public String getNewName(String tableName, String oldName) {
		String sql  = "select [新名称] from [dbo].[字段维护] where [表名] = ? and [旧名称] =?";
		Object[] params = {tableName,oldName};
		return (String) this.dao.select(sql, params)[0].get("新名称");
	}

}
