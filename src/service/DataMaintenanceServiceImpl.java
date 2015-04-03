package service;

import dao.DbHelperImpl;
import dao.IDbHelper;

public class DataMaintenanceServiceImpl implements IDataMaintenanceService{
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public void clearDatabase() {
		String sql1 = "delete from [dbo].[燃机项目] where [审核状态] = -1 and [审核状态] = 0";
		this.dao.update(sql1);
		String sql2 = "delete from [dbo].[燃煤项目s] where [审核状态] = -1 and [审核状态] = 0";
		this.dao.update(sql2);
		String sql3 = "delete from [dbo].[光伏发电项目] where [审核状态] = -1 and [审核状态] = 0";
		this.dao.update(sql3);
		String sql4 = "delete from [dbo].[生物质、垃圾发电项目] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql4);
		String sql5 = "delete from [dbo].[变电工程项目] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql5);
		String sql6 = "delete from [dbo].[工程前期数据] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql6);
		String sql7 = "delete from [dbo].[国内外规程规范及相关标准] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql7);
		String sql8 = "delete from [dbo].[公司科技成果] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql8);
		String sql9 = "delete from [dbo].[工程总结] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql9);
		String sql10 = "delete from [dbo].[合同及技术协议] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql10);
		String sql11 = "delete from [dbo].[设备及厂家资料] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql11);
		String sql12 = "delete from [dbo].[技术文献] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql12);
		String sql13 = "delete from [dbo].[煤质资料] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql13);
		String sql14 = "delete from [dbo].[技经] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql14);
		String sql15 = "delete from [dbo].[其他] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql15);
		String sql16 = "delete from [dbo].[送电工程项目] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql16);
		String sql17 = "delete from [dbo].[工程专家] where [审核状态] = -1 and [审核状态] = 0 ";
		this.dao.update(sql17);
	}

}
