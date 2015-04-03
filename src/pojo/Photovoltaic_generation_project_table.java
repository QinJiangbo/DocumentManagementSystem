package pojo;

public class Photovoltaic_generation_project_table {
	private String pid;
	private String name;
	private String type;
	private String nation;
	private String area;
	private String total_capacity;
	private String sunshine_duration;
	private String total_solar_radiation;
	private String power_supply_type;
	private String building_type;
	private String running_mode;
	private String battery_type;
	private String factory_area;
	private String preparation_one;
	private String preparation_two;
	private String preparation_three;
	private String preparation_four;
	private String preparation_five;
	private String type_in_userNme;
	private String verifier;
	private String verify_comment;
	private String entry_time;
	private String verify_time;
	public Photovoltaic_generation_project_table(Photovoltaic_generation_project photovoltaic_generation_project){
		setPid(photovoltaic_generation_project.getPid());
		setName(photovoltaic_generation_project.getName());
		setType(photovoltaic_generation_project.getType());
		setNation(photovoltaic_generation_project.getNation());
		setArea(photovoltaic_generation_project.getArea());
		setTotal_capacity(photovoltaic_generation_project.getTotal_capacity());
		setSunshine_duration(photovoltaic_generation_project.getSunshine_duration());
		setTotal_solar_radiation(photovoltaic_generation_project.getTotal_solar_radiation());
		setPower_supply_type(photovoltaic_generation_project.getPower_supply_type());
		setBuilding_type(photovoltaic_generation_project.getBuilding_type());
		setRunning_mode(photovoltaic_generation_project.getRunning_mode());
		setBattery_type(photovoltaic_generation_project.getBattery_type());
		setFactory_area(photovoltaic_generation_project.getFactory_area());
		setPreparation_one(photovoltaic_generation_project.getPreparation_one());
		setPreparation_two(photovoltaic_generation_project.getPreparation_two());
		setPreparation_three(photovoltaic_generation_project.getPreparation_three());
		setPreparation_four(photovoltaic_generation_project.getPreparation_four());
		setPreparation_five(photovoltaic_generation_project.getPreparation_five());
		setType_in_userNme(photovoltaic_generation_project.getType_in_userNme());
		setVerifier(photovoltaic_generation_project.getVerifier());
		setVerify_comment(photovoltaic_generation_project.getVerify_comment());
		setEntry_time(photovoltaic_generation_project.getEntry_time());
		setVerify_time(photovoltaic_generation_project.getVerify_time());
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		if(pid!=null&pid!=""){
			this.pid = "[项目编号] like '%"+pid+"%'";
		}
		else {
			this.pid = "";
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name!=null&name!=""){
			this.name = " and [项目名称] like '%"+name+"%'";
		}
		else {
			this.name = "";
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if(type!=null&type!=""){
			this.type = " and [项目类别] = "+type;
		}
		else {
			this.type = "";
		}
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		if(nation!=null&nation!=""){
			this.nation = " and [项目所在国] = "+nation;
		}
		else {
			this.nation = "";
		}
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		if(area!=null&area!=""){
			this.area = " and [项目所在地区] = "+area;
		}
		else {
			this.area = "";
		}
	}
	public String getTotal_capacity() {
		return total_capacity;
	}
	public void setTotal_capacity(String total_capacity) {
		if(total_capacity!=null&total_capacity!=""){
			this.total_capacity = " and [总容量] = "+total_capacity;
		}
		else {
			this.total_capacity = "";
		}
	}
	public String getSunshine_duration() {
		return sunshine_duration;
	}
	public void setSunshine_duration(String sunshine_duration) {
		if(sunshine_duration!=null&sunshine_duration!=""){
			this.sunshine_duration = " and [日照时间] = "+sunshine_duration;
		}
		else {
			this.sunshine_duration = "";
		}
	}
	public String getTotal_solar_radiation() {
		return total_solar_radiation;
	}
	public void setTotal_solar_radiation(String total_solar_radiation) {
		if(total_solar_radiation!=null&total_solar_radiation!=""){
			this.total_solar_radiation = " and [太阳总辐射] = "+total_solar_radiation;
		}
		else {
			this.total_solar_radiation = "";
		}
	}
	public String getPower_supply_type() {
		return power_supply_type;
	}
	public void setPower_supply_type(String power_supply_type) {
		if(power_supply_type!=null&power_supply_type!=""){
			this.power_supply_type = " and [供电类型] = "+power_supply_type;
		}
		else {
			this.power_supply_type = "";
		}
	}
	public String getBuilding_type() {
		return building_type;
	}
	public void setBuilding_type(String building_type) {
		if(building_type!=null&building_type!=""){
			this.building_type = " and [建筑类型] = "+building_type;
		}
		else {
			this.building_type = "";
		}
	}
	public String getRunning_mode() {
		return running_mode;
	}
	public void setRunning_mode(String running_mode) {
		if(running_mode!=null&running_mode!=""){
			this.running_mode = " and [运行方式] = "+running_mode;
		}
		else {
			this.running_mode = "";
		}
	}
	public String getBattery_type() {
		return battery_type;
	}
	public void setBattery_type(String battery_type) {
		if(battery_type!=null&battery_type!=""){
			this.battery_type = " and [电池类型] = "+battery_type;
		}
		else {
			this.battery_type = "";
		}
	}
	public String getFactory_area() {
		return factory_area;
	}
	public void setFactory_area(String factory_area) {
		if(factory_area!=null&factory_area!=""){
			this.factory_area = " and [厂区面积] = "+factory_area;
		}
		else {
			this.factory_area = "";
		}
	}
	public String getPreparation_one() {
		return preparation_one;
	}
	public void setPreparation_one(String preparation_one) {
		if(preparation_one!=null&preparation_one!=""){
			this.preparation_one = " and [预留一] = "+preparation_one;
		}
		else {
			this.preparation_one = "";
		}
	}
	public String getPreparation_two() {
		return preparation_two;
	}
	public void setPreparation_two(String preparation_two) {
		if(preparation_two!=null&preparation_two!=""){
			this.preparation_two = " and [预留二] = "+preparation_two;
		}
		else {
			this.preparation_two = "";
		}
	}
	public String getPreparation_three() {
		return preparation_three;
	}
	public void setPreparation_three(String preparation_three) {
		if(preparation_three!=null&preparation_three!=""){
			this.preparation_three = " and [预留三] = "+preparation_three;
		}
		else {
			this.preparation_three = "";
		}
	}
	public String getPreparation_four() {
		return preparation_four;
	}
	public void setPreparation_four(String preparation_four) {
		if(preparation_four!=null&preparation_four!=""){
			this.preparation_four = " and [预留四] = "+preparation_four;
		}
		else {
			this.preparation_four = "";
		}
	}
	public String getPreparation_five() {
		return preparation_five;
	}
	public void setPreparation_five(String preparation_five) {
		if(preparation_five!=null&preparation_five!=""){
			this.preparation_five = " and [预留五] = "+preparation_five;
		}
		else {
			this.preparation_five = "";
		}
	}
	public String getType_in_userNme() {
		return type_in_userNme;
	}
	public void setType_in_userNme(String type_in_userNme) {
		if(type_in_userNme!=null&type_in_userNme!=""){
			this.type_in_userNme = " and [录入用户名] = "+type_in_userNme;
		}
		else {
			this.type_in_userNme = "";
		}
	}
	public String getVerifier() {
		return verifier;
	}
	public void setVerifier(String verifier) {
		if(verifier!=null&verifier!=""){
			this.verifier = " and [审核人] = "+verifier;
		}
		else {
			this.verifier = "";
		}
	}
	public String getVerify_comment() {
		return verify_comment;
	}
	public void setVerify_comment(String verify_comment) {
		if(verify_comment!=null&verify_comment!=""){
			this.verify_comment = " and [审核意见] = "+verify_comment;
		}
		else {
			this.verify_comment = "";
		}
	}
	public String getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(String entry_time) {
		if(entry_time!=null&entry_time!=""){
			this.entry_time = " and [录入时间] = "+entry_time;
		}
		else {
			this.entry_time = "";
		}
	}
	public String getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(String verify_time) {
		if(verify_time!=null&verify_time!=""){
			this.verify_time = " and [审核时间] = "+verify_time;
		}
		else {
			this.verify_time = "";
		}
	}
}
