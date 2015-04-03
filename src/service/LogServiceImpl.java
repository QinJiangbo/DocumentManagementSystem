package service;

import java.util.Map;

import pojo.Log;
import dao.DbHelperImpl;
import dao.IDbHelper;
@SuppressWarnings("rawtypes")

public class LogServiceImpl implements ILogService{
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public Map[] getAllLog() {
		String sql = "select * from [dbo].[系统日志]";
		return this.dao.select(sql);
	}

	@Override
	public Map[] getAllLog(String uname) {
		String sql = "select * from [dbo].[系统日志] where [用户姓名] = ?";
		Object[] params = {uname};
		return this.dao.select(sql,params);
	}
	@Override
	public void delete(int id) {
		String sql = "delete from [dbo].[系统日志] where [编号] = ?";
		Object[] params = {id};
		this.dao.update(sql, params);
	}

	@Override
	public void delete(String fromTime, String EndTime) {
		String sql = "delete from [dbo].[系统日志] where ? < [时间] and ? > [时间] ";
		Object[] params = {fromTime,EndTime};
		this.dao.update(sql, params);
	}

	@Override
	public void delete(String name, String fromTime, String EndTime) {
		String sql = "delete from [dbo].[系统日志] where ? <[时间] and ? >[时间] and [用户姓名]= ? ";
		Object[] params = {fromTime,EndTime,name};
		this.dao.update(sql, params);
		
	}

	@Override
	public void add(Log log) {
		String sql = "insert into [dbo].[系统日志]([用户姓名],[操作],[表名],[时间]) values(?,?,?,?)";
		Object[] params = {log.getUname(),log.getOperation(),log.getTable(),log.getTime()};
		this.dao.update(sql, params);
	}

}
