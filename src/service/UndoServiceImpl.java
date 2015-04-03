package service;

import dao.DbHelperImpl;
import dao.IDbHelper;
public class UndoServiceImpl implements IUndoService{
	private IDbHelper dao = new DbHelperImpl();
	@Override
	public int getProjectDataNum(String uname) {
		String sql1 = "select count(*) a from [dbo].[燃机项目] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params1 = {uname};
		int a = Integer.parseInt(this.dao.select(sql1,params1)[0].get("a").toString());
		String sql2 = "select count(*) b from [dbo].[燃煤项目] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params2 = {uname};
		int b = Integer.parseInt(this.dao.select(sql2,params2)[0].get("b").toString());
		String sql3 = "select count(*) c from [dbo].[光伏发电项目] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params3 = {uname};
		int c = Integer.parseInt(this.dao.select(sql3,params3)[0].get("c").toString());
		String sql4 = "select count(*) d from [dbo].[生物质、垃圾发电项目] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params4 = {uname};
		int d = Integer.parseInt(this.dao.select(sql4,params4)[0].get("d").toString());
		String sql5 = "select count(*) e from [dbo].[变电工程项目] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params5 = {uname};
		int e = Integer.parseInt(this.dao.select(sql5,params5)[0].get("e").toString());
		String sql6 = "select count(*) f from [dbo].[送电工程项目] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params6 = {uname};
		int f = Integer.parseInt(this.dao.select(sql6,params6)[0].get("f").toString());
		return a+b+c+d+e+f;
	}

	@Override
	public int getUnPassedNum(String uname) {
		String sql1 = "select count(*) a from [dbo].[燃机项目] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params1 = {uname};
		int a = Integer.parseInt(this.dao.select(sql1,params1)[0].get("a").toString());
		String sql2 = "select count(*) b from [dbo].[燃煤项目] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params2 = {uname};
		int b = Integer.parseInt(this.dao.select(sql2,params2)[0].get("b").toString());
		String sql3 = "select count(*) c from [dbo].[光伏发电项目] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params3 = {uname};
		int c = Integer.parseInt(this.dao.select(sql3,params3)[0].get("c").toString());
		String sql4 = "select count(*) d from [dbo].[生物质、垃圾发电项目] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params4 = {uname};
		int d = Integer.parseInt(this.dao.select(sql4,params4)[0].get("d").toString());
		String sql5 = "select count(*) e from [dbo].[变电工程项目] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params5 = {uname};
		int e = Integer.parseInt(this.dao.select(sql5,params5)[0].get("e").toString());
		String sql6 = "select count(*) f from [dbo].[工程前期数据] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params6 = {uname};
		int f = Integer.parseInt(this.dao.select(sql6,params6)[0].get("f").toString());
		String sql7 = "select count(*) g from [dbo].[国内外规程规范及相关标准] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params7 = {uname};
		int g = Integer.parseInt(this.dao.select(sql7,params7)[0].get("g").toString());
		String sql8 = "select count(*) h from [dbo].[公司科技成果] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params8 = {uname};
		int h = Integer.parseInt(this.dao.select(sql8,params8)[0].get("h").toString());
		String sql9 = "select count(*) i from [dbo].[工程总结] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params9 = {uname};
		int i = Integer.parseInt(this.dao.select(sql9,params9)[0].get("i").toString());
		String sql10 = "select count(*) j from [dbo].[合同及技术协议] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params10 = {uname};
		int j = Integer.parseInt(this.dao.select(sql10,params10)[0].get("j").toString());
		String sql11 = "select count(*) k from [dbo].[设备及厂家资料] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params11 = {uname};
		int k = Integer.parseInt(this.dao.select(sql11,params11)[0].get("k").toString());
		String sql12 = "select count(*) l from [dbo].[技术文献] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params12 = {uname};
		int l = Integer.parseInt(this.dao.select(sql12,params12)[0].get("l").toString());
		String sql13 = "select count(*) m from [dbo].[煤质资料] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params13 = {uname};
		int m = Integer.parseInt(this.dao.select(sql13,params13)[0].get("m").toString());
		String sql14 = "select count(*) n from [dbo].[技经] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params14 = {uname};
		int n = Integer.parseInt(this.dao.select(sql14,params14)[0].get("n").toString());
		String sql15 = "select count(*) o from [dbo].[其他] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params15 = {uname};
		int o = Integer.parseInt(this.dao.select(sql15,params15)[0].get("o").toString());
		String sql16 = "select count(*) p from [dbo].[送电工程项目] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params16 = {uname};
		int p = Integer.parseInt(this.dao.select(sql16,params16)[0].get("p").toString());
		String sql17 = "select count(*) q from [dbo].[工程专家] where [审核人] = ? and [审核状态] = -1 ";
		Object[] params17 = {uname};
		int q = Integer.parseInt(this.dao.select(sql17,params17)[0].get("q").toString());
		return a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q;
	}

	@Override
	public int getOtherNum(String uname) {
		String sql = "select count(*) n from [dbo].[其他] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params = {uname};
		int m = Integer.parseInt(this.dao.select(sql,params)[0].get("n").toString());
		return m;
	}

	@Override
	public int getPreEngineeringDataNum(String uname) {
		String sql = "select count(*) n from [dbo].[工程前期数据] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params = {uname};
		int m = Integer.parseInt(this.dao.select(sql,params)[0].get("n").toString());
		return m;
	}

	@Override
	public int getHomeBroadStandardNum(String uname) {
		String sql = "select count(*) n from [dbo].[国内外规程规范及相关标准] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params = {uname};
		int m = Integer.parseInt(this.dao.select(sql,params)[0].get("n").toString());
		return m;
	}

	@Override
	public int getCompanyTechnologyAchievementNum(String uname) {
		String sql = "select count(*) n from [dbo].[公司科技成果] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params = {uname};
		int m = Integer.parseInt(this.dao.select(sql,params)[0].get("n").toString());
		return m;
	}

	@Override
	public int getEngineeringSummaryNum(String uname) {
		String sql = "select count(*) n from [dbo].[工程总结] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params = {uname};
		int m = Integer.parseInt(this.dao.select(sql,params)[0].get("n").toString());
		return m;
	}

	@Override
	public int getContractTechnologyProtocolNum(String uname) {
		String sql = "select count(*) n from [dbo].[合同及技术协议] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params = {uname};
		int m = Integer.parseInt(this.dao.select(sql,params)[0].get("n").toString());
		return m;
	}

	@Override
	public int getDeviceVenderMeterialNum(String uname) {
		String sql = "select count(*) n from [dbo].[设备及厂家资料] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params = {uname};
		int m = Integer.parseInt(this.dao.select(sql,params)[0].get("n").toString());
		return m;
	}

	@Override
	public int getTechnologyEssayNum(String uname) {
		String sql = "select count(*) n from [dbo].[技术文献] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params = {uname};
		int m = Integer.parseInt(this.dao.select(sql,params)[0].get("n").toString());
		return m;
	}

	@Override
	public int getCoalMeterialNum(String uname) {
		String sql = "select count(*) n from [dbo].[煤质资料] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params = {uname};
		int m = Integer.parseInt(this.dao.select(sql,params)[0].get("n").toString());
		return m;
	}

	@Override
	public int getTechnologyNum(String uname) {
		String sql = "select count(*) n from [dbo].[技经] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params = {uname};
		int m = Integer.parseInt(this.dao.select(sql,params)[0].get("n").toString());
		return m;
	}

	@Override
	public int getProjectExpertNum(String uname) {
		String sql = "select count(*) n from [dbo].[工程专家] where [审核人] = ? and [审核状态] = 1 ";
		Object[] params = {uname};
		int m = Integer.parseInt(this.dao.select(sql,params)[0].get("n").toString());
		return m;
	}

}
