package pojo;

public class Power_deliver_project_table {
	private String pid;
	private String name;
	private String type;
	private String nation;
	private String area;
	private String line_voltage_level;
	private String design_wind_speed;
	private String icing_thickness;
	private String landform;
	private String wire_pattern;
	private String wire_divide_number;
	private String wire_cross_section;
	private String loop_numbers;
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
	public Power_deliver_project_table (Power_deliver_project power_deliver_project){
		setPid(power_deliver_project.getPid());
		setName(power_deliver_project.getName());
		setType(power_deliver_project.getType());
		setNation(power_deliver_project.getNation());
		setArea(power_deliver_project.getArea());
		setLine_voltage_level(power_deliver_project.getLine_voltage_level());
		setDesign_wind_speed(power_deliver_project.getDesign_wind_speed());
		setIcing_thickness(power_deliver_project.getIcing_thickness());
		setLandform(power_deliver_project.getLandform());
		setWire_pattern(power_deliver_project.getWire_pattern());
		setWire_divide_number(power_deliver_project.getWire_divide_number());
		setWire_cross_section(power_deliver_project.getWire_cross_section());
		setLoop_numbers(power_deliver_project.getLoop_numbers());
		setPreparation_one(power_deliver_project.getPreparation_one());
		setPreparation_two(power_deliver_project.getPreparation_two());
		setPreparation_three(power_deliver_project.getPreparation_three());
		setPreparation_four(power_deliver_project.getPreparation_four());
		setPreparation_five(power_deliver_project.getPreparation_five());
		setType_in_userNme(power_deliver_project.getType_in_userNme());
		setVerifier(power_deliver_project.getVerifier());
		setVerify_comment(power_deliver_project.getVerify_comment());
		setEntry_time(power_deliver_project.getEntry_time());
		setVerify_time(power_deliver_project.getVerify_time());
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
			this.nation = " and [项目类别] = "+nation;
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
	public String getLine_voltage_level() {
		return line_voltage_level;
	}
	public void setLine_voltage_level(String line_voltage_level) {
		if(line_voltage_level!=null&line_voltage_level!=""){
			this.line_voltage_level = " and [线路电压等级] = "+line_voltage_level;
		}
		else {
			this.line_voltage_level = "";
		}
	}
	public String getDesign_wind_speed() {
		return design_wind_speed;
	}
	public void setDesign_wind_speed(String design_wind_speed) {
		if(design_wind_speed!=null&design_wind_speed!=""){
			this.design_wind_speed = " and [设计风速] = "+design_wind_speed;
		}
		else {
			this.design_wind_speed = "";
		}
	}
	public String getIcing_thickness() {
		return icing_thickness;
	}
	public void setIcing_thickness(String icing_thickness) {
		if(icing_thickness!=null&icing_thickness!=""){
			this.icing_thickness = " and [覆冰厚度] = "+icing_thickness;
		}
		else {
			this.icing_thickness = "";
		}
	}
	public String getLandform() {
		return landform;
	}
	public void setLandform(String landform) {
		if(landform!=null&landform!=""){
			this.landform = " and [地形地貌] = "+landform;
		}
		else {
			this.landform = "";
		}
	}
	public String getWire_pattern() {
		return wire_pattern;
	}
	public void setWire_pattern(String wire_pattern) {
		if(wire_pattern!=null&wire_pattern!=""){
			this.wire_pattern = " and [导线型式] = "+wire_pattern;
		}
		else {
			this.wire_pattern = "";
		}
	}
	public String getWire_divide_number() {
		return wire_divide_number;
	}
	public void setWire_divide_number(String wire_divide_number) {
		if(wire_divide_number!=null&wire_divide_number!=""){
			this.wire_divide_number = " and [导线分裂数] = "+wire_divide_number;
		}
		else {
			this.wire_divide_number = "";
		}
	}
	public String getWire_cross_section() {
		return wire_cross_section;
	}
	public void setWire_cross_section(String wire_cross_section) {
		if(wire_cross_section!=null&wire_cross_section!=""){
			this.wire_cross_section = " and [导线截面] = "+wire_cross_section;
		}
		else {
			this.wire_cross_section = "";
		}
	}
	public String getLoop_numbers() {
		return loop_numbers;
	}
	public void setLoop_numbers(String loop_numbers) {
		if(loop_numbers!=null&loop_numbers!=""){
			this.loop_numbers = " and [回路数] = "+loop_numbers;
		}
		else {
			this.loop_numbers = "";
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
