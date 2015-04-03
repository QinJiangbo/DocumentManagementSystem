package service;

public interface IUndoService {
	public int getProjectDataNum(String uname);
	public int getUnPassedNum(String uname);
	public int getOtherNum(String uname);
	public int getPreEngineeringDataNum(String uname);
	public int getHomeBroadStandardNum(String uname);
	public int getCompanyTechnologyAchievementNum(String uname);
	public int getEngineeringSummaryNum(String uname);
	public int getContractTechnologyProtocolNum(String uname);
	public int getDeviceVenderMeterialNum(String uname);
	public int getTechnologyEssayNum(String uname);
	public int getCoalMeterialNum(String uname);
	public int getTechnologyNum(String uname);
	public int getProjectExpertNum(String uname);
}
