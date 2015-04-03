package pojo;

public class Biomass_rubbish_project_table {
	private String pid;
	private String name;
	private String type;
	private String nation;
	private String area;
	private String installation_number;
	private String construction_mode;
	private String boiler_type;
	private String fuel_type;
	private String dusting_method;
	private String sulfur_removal_method;
	private String average_temperature;
	private String extreme_high_temperature;
	private String extreme_low_temperature;
	private String average_relative_humid;
	private String circulating_cooling_method;
	private String water_source;
	private String cooling_tower_pattern;
	private String fire_protection_standard;
	private String raw_water_preprocess;
	private String factory_area;
	private String design_basic_seismic_acceleration;
	private String foundation_type;
	private String main_factory_structure_pattern;
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
	private String verify_comment;
	private String entry_time;
	private String verify_time;
	public Biomass_rubbish_project_table(Biomass_rubbish_project biomass_rubbish_project){
		setPid(biomass_rubbish_project.getPid());
		setName(biomass_rubbish_project.getName());
		setType(biomass_rubbish_project.getType());
		setNation(biomass_rubbish_project.getNation());
		setArea(biomass_rubbish_project.getArea());
		setInstallation_number(biomass_rubbish_project.getInstallation_number());
		setConstruction_mode(biomass_rubbish_project.getConstruction_mode());
		setBoiler_type(biomass_rubbish_project.getBoiler_type());
		setFuel_type(biomass_rubbish_project.getFuel_type());
		setDusting_method(biomass_rubbish_project.getDusting_method());
		setSulfur_removal_method(biomass_rubbish_project.getSulfur_removal_method());
		setAverage_temperature(biomass_rubbish_project.getAverage_temperature());
		setExtreme_high_temperature(biomass_rubbish_project.getExtreme_high_temperature());
		setExtreme_low_temperature(biomass_rubbish_project.getExtreme_low_temperature());
		setAverage_relative_humid(biomass_rubbish_project.getAverage_relative_humid());
		setCirculating_cooling_method(biomass_rubbish_project.getCirculating_cooling_method());
		setWater_source(biomass_rubbish_project.getWater_source());
		setCooling_tower_pattern(biomass_rubbish_project.getCooling_tower_pattern());
		setFire_protection_standard(biomass_rubbish_project.getFire_protection_standard());
		setRaw_water_preprocess(biomass_rubbish_project.getRaw_water_preprocess());
		setFactory_area(biomass_rubbish_project.getFactory_area());
		setDesign_basic_seismic_acceleration(biomass_rubbish_project.getDesign_basic_seismic_acceleration());
		setFoundation_type(biomass_rubbish_project.getFoundation_type());
		setMain_factory_structure_pattern(biomass_rubbish_project.getMain_factory_structure_pattern());
		setWater_circulation_system_overview(biomass_rubbish_project.getWater_circulation_system_overview());
		setPreparation_one(biomass_rubbish_project.getPreparation_one());
		setPreparation_two(biomass_rubbish_project.getPreparation_two());
		setPreparation_three(biomass_rubbish_project.getPreparation_three());
		setPreparation_four(biomass_rubbish_project.getPreparation_four());
		setPreparation_five(biomass_rubbish_project.getPreparation_five());
		setPreparation_six(biomass_rubbish_project.getPreparation_six());
		setPreparation_seven(biomass_rubbish_project.getPreparation_seven());
		setPreparation_eight(biomass_rubbish_project.getPreparation_eight());
		setPreparation_nine(biomass_rubbish_project.getPreparation_nine());
		setPreparation_ten(biomass_rubbish_project.getPreparation_ten());
		setType_in_userNme(biomass_rubbish_project.getType_in_userNme());
		setVerifier(biomass_rubbish_project.getVerifier());
		setVerify_comment(biomass_rubbish_project.getVerify_comment());
		setEntry_time(biomass_rubbish_project.getEntry_time());
		setVerify_time(biomass_rubbish_project.getVerify_time());
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
	public String getInstallation_number() {
		return installation_number;
	}
	public void setInstallation_number(String installation_number) {
		if(installation_number!=null&installation_number!=""){
			this.installation_number = " and [装机数量] = "+installation_number;
		}
		else {
			this.installation_number = "";
		}
	}
	public String getConstruction_mode() {
		return construction_mode;
	}
	public void setConstruction_mode(String construction_mode) {
		if(construction_mode!=null&construction_mode!=""){
			this.construction_mode = " and [建设方式] = "+construction_mode;
		}
		else {
			this.construction_mode = "";
		}
	}
	public String getBoiler_type() {
		return boiler_type;
	}
	public void setBoiler_type(String boiler_type) {
		if(boiler_type!=null&boiler_type!=""){
			this.boiler_type = " and [锅炉类型] = "+boiler_type;
		}
		else {
			this.boiler_type = "";
		}
	}
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		if(fuel_type!=null&fuel_type!=""){
			this.fuel_type = " and [燃料类型] = "+fuel_type;
		}
		else {
			this.fuel_type = "";
		}
	}
	public String getDusting_method() {
		return dusting_method;
	}
	public void setDusting_method(String dusting_method) {
		if(dusting_method!=null&dusting_method!=""){
			this.dusting_method = " and [除尘方式] = "+dusting_method;
		}
		else {
			this.dusting_method = "";
		}
	}
	public String getSulfur_removal_method() {
		return sulfur_removal_method;
	}
	public void setSulfur_removal_method(String sulfur_removal_method) {
		if(sulfur_removal_method!=null&sulfur_removal_method!=""){
			this.sulfur_removal_method = " and [脱硫方式] = "+sulfur_removal_method;
		}
		else {
			this.sulfur_removal_method = "";
		};
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
			this.extreme_high_temperature = " and [极端最高气温] = "+extreme_high_temperature;
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
	public String getCirculating_cooling_method() {
		return circulating_cooling_method;
	}
	public void setCirculating_cooling_method(String circulating_cooling_method) {
		if(circulating_cooling_method!=null&circulating_cooling_method!=""){
			this.circulating_cooling_method = " and [循环冷却方式] = "+circulating_cooling_method;
		}
		else {
			this.circulating_cooling_method = "";
		}
	}
	public String getWater_source() {
		return water_source;
	}
	public void setWater_source(String water_source) {
		if(water_source!=null&water_source!=""){
			this.water_source = " and [水源] = "+water_source;
		}
		else {
			this.water_source = "";
		}
	}
	public String getCooling_tower_pattern() {
		return cooling_tower_pattern;
	}
	public void setCooling_tower_pattern(String cooling_tower_pattern) {
		if(cooling_tower_pattern!=null&cooling_tower_pattern!=""){
			this.cooling_tower_pattern = " and [冷却塔型式] = "+cooling_tower_pattern;
		}
		else {
			this.cooling_tower_pattern = "";
		}
	}
	public String getFire_protection_standard() {
		return fire_protection_standard;
	}
	public void setFire_protection_standard(String fire_protection_standard) {
		if(fire_protection_standard!=null&fire_protection_standard!=""){
			this.fire_protection_standard = " and [消防标准] = "+fire_protection_standard;
		}
		else {
			this.fire_protection_standard = "";
		}
	}
	public String getRaw_water_preprocess() {
		return raw_water_preprocess;
	}
	public void setRaw_water_preprocess(String raw_water_preprocess) {
		if(raw_water_preprocess!=null&raw_water_preprocess!=""){
			this.raw_water_preprocess = " and [原水预处理] = "+raw_water_preprocess;
		}
		else {
			this.raw_water_preprocess = "";
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
	public String getDesign_basic_seismic_acceleration() {
		return design_basic_seismic_acceleration;
	}
	public void setDesign_basic_seismic_acceleration(
			String design_basic_seismic_acceleration) {
		if(design_basic_seismic_acceleration!=null&design_basic_seismic_acceleration!=""){
			this.design_basic_seismic_acceleration = " and [设计基本地震加速度] = "+design_basic_seismic_acceleration;
		}
		else {
			this.design_basic_seismic_acceleration = "";
		}
	}
	public String getFoundation_type() {
		return foundation_type;
	}
	public void setFoundation_type(String foundation_type) {
		if(foundation_type!=null&foundation_type!=""){
			this.foundation_type = " and [基础型式] = "+foundation_type;
		}
		else {
			this.foundation_type = "";
		}
	}
	public String getMain_factory_structure_pattern() {
		return main_factory_structure_pattern;
	}
	public void setMain_factory_structure_pattern(
			String main_factory_structure_pattern) {
		if(main_factory_structure_pattern!=null&main_factory_structure_pattern!=""){
			this.main_factory_structure_pattern = " and [主厂房结构型式] = "+main_factory_structure_pattern;
		}
		else {
			this.main_factory_structure_pattern = "";
		}
	}
	public String getWater_circulation_system_overview() {
		return water_circulation_system_overview;
	}
	public void setWater_circulation_system_overview(
			String water_circulation_system_overview) {
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
