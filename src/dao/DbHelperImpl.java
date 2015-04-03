package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class DbHelperImpl implements IDbHelper {
	//定义驱动 
	private final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//com.mysql.jdbc.Driver
	//oracle.jdbc.driver.OracleDriver
	//com.microsoft.jdbc.sqlserver.SQLServerDriver
	//定义url
	private final String URL="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=DocumentManagementSystem";
	//jdbc:mysql://127.0.0.1:3306/orcl
	//jdbc:oracle:thin:@localhost:1521:XE
	//jdbc:sqlsever://127.0.0.1;DatabaseName=master
	//get the connection
	private Connection getConnection(){		
		try{
			Class.forName(DRIVER); 
			Connection conn=DriverManager.getConnection(URL, "sa", "cq08010907");
			return conn;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
	//run the select SQL with parameters
	@SuppressWarnings("rawtypes")
	public Map[] select(String sql,Object[] params){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{			
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			//get the parameters array
			int i=1;//really easy to be wrong!!!
			for(Object o:params){
				if(o ==null){
				   ps.setObject(i++,o,java.sql.Types.VARCHAR); 
				}else{
				   ps.setObject(i++,o); 
				}
			}		 	
			rs=ps.executeQuery();
			Result result=ResultSupport.toResult(rs);
			Map[] rows=result.getRows();			
			return rows;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{ //no matter how the program goes, this line will be executed
			try{
				rs.close();
				ps.close();				
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}				
	}
		
	
	//run the select SQL without parameters
	@SuppressWarnings("rawtypes")
	public Map[] select(String sql){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{			
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			Result result=ResultSupport.toResult(rs);
			Map[] rows=result.getRows();			
			return rows;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{ 
			try{
				rs.close();
				ps.close();				
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}				
	}
	
	//run the update SQL without parameters
	public void update(String sql){
		Connection conn=null;
		PreparedStatement ps=null;
		try{			
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();				
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}				
	}
	
	//run the select SQL with parameters
	public void update(String sql,Object[] params){
		Connection conn=null;
		PreparedStatement ps=null;
		try{			
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			//get the parameters array
			int i=1;//really easy to be wrong!!!
			for(Object o:params){
				if(o ==null){
				   ps.setObject(i++,o,java.sql.Types.VARCHAR); 
				}else{
				   ps.setObject(i++,o); 
				}
			}	
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();				
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}				
	}
		
}
