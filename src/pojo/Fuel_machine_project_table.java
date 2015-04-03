package pojo;

public class Fuel_machine_project_table {
	private String pid;
	private String name;
	private String type;
	private String nation;
	private String area;
	private String average_temperature;
	private String extreme_high_temperature;
	private String extreme_low_temperature;
	private String average_relative_humid;
	private String barometric_pressure;
	private String water_source;
	private String fuel_power_station_pattern;
	private String fuel_station_fuel_type;
	private String fuel_machine_level;
	private String fuel_machine_version;
	private String waste_heat_boiler_circulate_type;
	private String waste_heat_boiler_structure_type;
	private String waste_heat_boiler_afterburning_type;
	private String combined_circulation_aerated_water_system_pattern;
	private String combined_circulation_mainframe_layout_pattern;
	private String factory_area;
	private String water_circulation_system_overview;
	private String preparation_one;
	private String preparation_two;
	private String preparation_three;
	private String preparation_four;
	private String preparation_five;
	private String preparation_six;
	private String preparation_seven;
	private String preparation_eight;
	private String preparation_nine;
	private String preparation_ten;
	private String type_in_userNme;
	private String verifier;
	private int verify_state;
	private String verify_comment;
	private String entry_time;
	private String verify_time;
	public Fuel_machine_project_table(Fuel_machine_project fuel_machine_project){
		setPid(fuel_machine_project.getPid());
		setName(fuel_machine_project.getName());
		setType(fuel_machine_project.getType());
		setNation(fuel_machine_project.getNation());
		setArea(fuel_machine_project.getArea());
		setAverage_temperature(fuel_machine_project.getAverage_temperature());
		setExtreme_high_temperature(fuel_machine_project.getExtreme_high_temperature());
		setExtreme_low_temperature(fuel_machine_project.getExtreme_low_temperature());
		setAverage_relative_humid(fuel_machine_project.getAverage_relative_humid());
		setBarometric_pressure(fuel_machine_project.getBarometric_pressure());
		setWater_source(fuel_machine_project.getWater_source());
		setFuel_power_station_pattern(fuel_machine_project.getFuel_power_station_pattern());
		setFuel_station_fuel_type(fuel_machine_project.getFuel_station_fuel_type());
		setFuel_machine_level(fuel_machine_project.getFuel_machine_level());
		setFuel_machine_version(fuel_machine_project.getFuel_machine_version());
		setWaste_heat_boiler_circulate_type(fuel_machine_project.getWaste_heat_boiler_circulate_type());
		setWaste_heat_boiler_structure_type(fuel_machine_project.getWaste_heat_boiler_structure_type());
		setWaste_heat_boiler_afterburning_type(fuel_machine_project.getWaste_heat_boiler_afterburning_type());
		setCombined_circulation_aerated_water_system_pattern(fuel_machine_project.getCombined_circulation_aerated_water_system_pattern());
		setCombined_circulation_mainframe_layout_pattern(fuel_machine_project.getCombined_circulation_mainframe_layout_pattern());
		setFactory_area(fuel_machine_project.getFactory_area());
		setWater_circulation_system_overview(fuel_machine_project.getWater_circulation_system_overview());
		setPreparation_one(fuel_machine_project.getPreparation_one());
		setPreparation_two(fuel_machine_project.getPreparation_two());
		setPreparation_three(fuel_machine_project.getPreparation_three());
		setPreparation_four(fuel_machine_project.getPreparation_four());
		setPreparation_five(fuel_machine_project.getPreparation_five());
		setPreparation_six(fuel_machine_project.getPreparation_six());
		setPreparation_seven(fuel_machine_project.getPreparation_seven());
		setPreparation_eight(fuel_machine_project.getPreparation_eight());
		setPreparation_nine(fuel_machine_project.getPreparation_nine());
		setPreparation_ten(fuel_machine_project.getPreparation_ten());
		setType_in_userNme(fuel_machine_project.getType_in_userNme());
		setVerifier(fuel_machine_project.getVerifier());
		setVerify_comment(fuel_machine_project.getVerify_comment());
		setEntry_time(fuel_machine_project.getEntry_time());
		setVerify_time(fuel_machine_project.getVerify_time());
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
	public String getAverage_temperature() {
		return average_temperature;
	}
	public void setAverage_temperature(String average_temperature) {
		if(average_temperature!=null&average_temperature!=""){
			this.average_temperature = " and [年平均气温] = "+average_temperature;
		}
		else {
			this.average_temperature = "";
		}
	}
	public String getExtreme_high_temperature() {
		return extreme_high_temperature;
	}
	public void setExtreme_high_temperature(String extreme_high_temperature) {
		if(extreme_high_temperature!=null&extreme_high_temperature!=""){
			this.extreme_high_temperature = " and [极端最高温度] = "+extreme_high_temperature;
		}
		else {
			this.extreme_high_temperature = "";
		}
	}
	public String getExtreme_low_temperature() {
		return extreme_low_temperature;
	}
	public void setExtreme_low_temperature(String extreme_low_temperature) {
		if(extreme_low_temperature!=null&extreme_low_temperature!=""){
			this.extreme_low_temperature = " and [极端最低气温] = "+extreme_low_temperature;
		}
		else {
			this.extreme_low_temperature = "";
		}
	}
	public String getAverage_relative_humid() {
		return average_relative_humid;
	}
	public void setAverage_relative_humid(String average_relative_humid) {
		if(average_relative_humid!=null&average_relative_humid!=""){
			this.average_relative_humid = " and [平均相对湿度] = "+average_relative_humid;
		}
		else {
			this.average_relative_humid = "";
		}
	}
	public String getBarometric_pressure() {
		return barometric_pressure;
	}
	public void setBarometric_pressure(String barometric_pressure) {
		if(barometric_pressure!=null&barometric_pressure!=""){
			this.barometric_pressure = " and [大气压] = "+barometric_pressure;
		}
		else {
			this.barometric_pressure = "";
		}
	}
	public String getWater_source() {
		return water_source;
	}
	public void setWater_source(String water_source) {
		if(water_source!=null&water_source!=""){
			this.water_source = "and [水源] = "+water_source;
		}
		else {
			this.water_source = "";
		}
	}
	public String getFuel_power_station_pattern() {
		return fuel_power_station_pattern;
	}
	public void setFuel_power_station_pattern(String fuel_power_station_pattern) {
		if(fuel_power_station_pattern!=null&fuel_power_station_pattern!=""){
			this.fuel_power_station_pattern = " and [燃机电站型式] = "+fuel_power_station_pattern;
		}
		else {
			this.fuel_power_station_pattern = "";
		}
	}
	public String getFuel_station_fuel_type() {
		return fuel_station_fuel_type;
	}
	public void setFuel_station_fuel_type(String fuel_station_fuel_type) {
		if(fuel_station_fuel_type!=null&fuel_station_fuel_type!=""){
			this.fuel_station_fuel_type = " and [燃机电站燃料类型] = "+fuel_station_fuel_type;
		}
		else {
			this.fuel_station_fuel_type = "";
		}
	}
	public String getFuel_machine_level() {
		return fuel_machine_level;
	}
	public void setFuel_machine_level(String fuel_machine_level) {
		if(fuel_machine_level!=null&fuel_machine_level!=""){
			this.fuel_machine_level = " and [燃机级别] = "+fuel_machine_level;
		}
		else {
			this.fuel_machine_level = "";
		}
	}
	public String getFuel_machine_version() {
		return fuel_machine_version;
	}
	public void setFuel_machine_version(String fuel_machine_version) {
		if(fuel_machine_version!=null&fuel_machine_version!=""){
			this.fuel_machine_version = " and [燃机型号] = "+fuel_machine_version;
		}
		else {
			this.fuel_machine_version = "";
		}
	}
	public String getWaste_heat_boiler_circulate_type() {
		return waste_heat_boiler_circulate_type;
	}
	public void setWaste_heat_boiler_circulate_type(String waste_heat_boiler_circulate_type) {
		if(waste_heat_boiler_circulate_type!=null&waste_heat_boiler_circulate_type!=""){
			this.waste_heat_boiler_circulate_type = " and [余热锅炉循环类别] = "+waste_heat_boiler_circulate_type;
		}
		else {
			this.waste_heat_boiler_circulate_type = "";
		}
	}
	public String getWaste_heat_boiler_structure_type() {
		return waste_heat_boiler_structure_type;
	}
	public void setWaste_heat_boiler_structure_type(String waste_heat_boiler_structure_type) {
		if(waste_heat_boiler_structure_type!=null&waste_heat_boiler_structure_type!=""){
			this.waste_heat_boiler_structure_type = " and [余热锅炉结构类别] = "+waste_heat_boiler_structure_type;
		}
		else {
			this.waste_heat_boiler_structure_type = "";
		}
	}
	public String getWaste_heat_boiler_afterburning_type() {
		return waste_heat_boiler_afterburning_type;
	}
	public void setWaste_heat_boiler_afterburning_type(String waste_heat_boiler_afterburning_type) {
		if(waste_heat_boiler_afterburning_type!=null&waste_heat_boiler_afterburning_type!=""){
			this.waste_heat_boiler_afterburning_type = " and [余热锅炉补燃类别] = "+waste_heat_boiler_afterburning_type;
		}
		else {
			this.waste_heat_boiler_afterburning_type = "";
		}
	}
	public String getCombined_circulation_aerated_water_system_pattern() {
		return combined_circulation_aerated_water_system_pattern;
	}
	public void setCombined_circulation_aerated_water_system_pattern(String combined_circulation_aerated_water_system_pattern) {
		if(combined_circulation_aerated_water_system_pattern!=null&combined_circulation_aerated_water_system_pattern!=""){
			this.combined_circulation_aerated_water_system_pattern = " and [联合循环汽水循环系统型式] = "+combined_circulation_aerated_water_system_pattern;
		}
		else {
			this.combined_circulation_aerated_water_system_pattern = "";
		}
	}
	public String getCombined_circulation_mainframe_layout_pattern() {
		return combined_circulation_mainframe_layout_pattern;
	}
	public void setCombined_circulation_mainframe_layout_pattern(String combined_circulation_mainframe_layout_pattern) {
		if(combined_circulation_mainframe_layout_pattern!=null&combined_circulation_mainframe_layout_pattern!=""){
			this.combined_circulation_mainframe_layout_pattern = " and [联合循环主机布置型式] = "+combined_circulation_mainframe_layout_pattern;
		}
		else {
			this.combined_circulation_mainframe_layout_pattern = "";
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
	public String getWater_circulation_system_overview() {
		return water_circulation_system_overview;
	}
	public void setWater_circulation_system_overview(String water_circulation_system_overview) {
		if(water_circulation_system_overview!=null&water_circulation_system_overview!=""){
			this.water_circulation_system_overview = " and [循环水系统概述] = "+water_circulation_system_overview;
		}
		else {
			this.water_circulation_system_overview = "";
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
	public String getPreparation_six() {
		return preparation_six;
	}
	public void setPreparation_six(String preparation_six) {
		if(preparation_six!=null&preparation_six!=""){
			this.preparation_six = " and [预留六] = "+preparation_six;
		}
		else {
			this.preparation_six = "";
		}
	}
	public String getPreparation_seven() {
		return preparation_seven;
	}
	public void setPreparation_seven(String preparation_seven) {
		if(preparation_seven!=null&preparation_seven!=""){
			this.preparation_seven = " and [预留七] = "+preparation_seven;
		}
		else {
			this.preparation_seven = "";
		}
	}
	public String getPreparation_eight() {
		return preparation_eight;
	}
	public void setPreparation_eight(String preparation_eight) {
		if(preparation_eight!=null&preparation_eight!=""){
			this.preparation_eight = " and [预留八] = "+preparation_eight;
		}
		else {
			this.preparation_eight = "";
		}
	}
	public String getPreparation_nine() {
		return preparation_nine;
	}
	public void setPreparation_nine(String preparation_nine) {
		if(preparation_nine!=null&preparation_nine!=""){
			this.preparation_nine = " and [预留九] = "+preparation_nine;
		}
		else {
			this.preparation_nine = "";
		}
	}
	public String getPreparation_ten() {
		return preparation_ten;
	}
	public void setPreparation_ten(String preparation_ten) {
		if(preparation_ten!=null&preparation_ten!=""){
			this.preparation_ten = " and [预留十] = "+preparation_ten;
		}
		else {
			this.preparation_ten = "";
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
	public int getVerify_state() {
		return verify_state;
	}
	public void setVerify_state(int verify_state) {
		this.verify_state = verify_state;
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
