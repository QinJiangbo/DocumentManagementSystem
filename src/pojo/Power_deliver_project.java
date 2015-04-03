package pojo;

public class Power_deliver_project {
	private int id;
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
	private int verify_state;
	private String verify_comment;
	private String entry_time;
	private String verify_time;
	private String project_file_address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name==null){
			this.name = "";
		}
		else {
			this.name = name;
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if(type==null){
			this.type = "";
		}
		else {
			this.type = type;
		}
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		if(nation==null){
			this.nation = "";
		}
		else {
			this.nation = nation;
		}
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		if(area==null){
			this.area = "";
		}
		else {
			this.area = area;
		}
	}
	public String getLine_voltage_level() {
		return line_voltage_level;
	}
	public void setLine_voltage_level(String line_voltage_level) {
		if(line_voltage_level==null){
			this.line_voltage_level = "";
		}
		else {
			this.line_voltage_level = line_voltage_level;
		}
	}
	public String getDesign_wind_speed() {
		return design_wind_speed;
	}
	public void setDesign_wind_speed(String design_wind_speed) {
		if(design_wind_speed==null){
			this.design_wind_speed = "";
		}
		else {
			this.design_wind_speed = design_wind_speed;
		}
	}
	public String getIcing_thickness() {
		return icing_thickness;
	}
	public void setIcing_thickness(String icing_thickness) {
		if(icing_thickness==null){
			this.icing_thickness = "";
		}
		else {
			this.icing_thickness = icing_thickness;
		}
	}
	public String getLandform() {
		return landform;
	}
	public void setLandform(String landform) {
		if(landform==null){
			this.landform = "";
		}
		else {
			this.landform = landform;
		}
	}
	public String getWire_pattern() {
		return wire_pattern;
	}
	public void setWire_pattern(String wire_pattern) {
		if(wire_pattern==null){
			this.wire_pattern = "";
		}
		else {
			this.wire_pattern = wire_pattern;
		}
	}
	public String getWire_divide_number() {
		return wire_divide_number;
	}
	public void setWire_divide_number(String wire_divide_number) {
		if(wire_divide_number==null){
			this.wire_divide_number = "";
		}
		else {
			this.wire_divide_number = wire_divide_number;
		}
	}
	public String getWire_cross_section() {
		return wire_cross_section;
	}
	public void setWire_cross_section(String wire_cross_section) {
		if(wire_cross_section==null){
			this.wire_cross_section = "";
		}
		else {
			this.wire_cross_section = wire_cross_section;
		}
	}
	public String getLoop_numbers() {
		return loop_numbers;
	}
	public void setLoop_numbers(String loop_numbers) {
		if(loop_numbers==null){
			this.loop_numbers = "";
		}
		else {
			this.loop_numbers = loop_numbers;
		}
	}
	public String getPreparation_one() {
		return preparation_one;
	}
	public void setPreparation_one(String preparation_one) {
		if(preparation_one==null){
			this.preparation_one = "";
		}
		else {
			this.preparation_one = preparation_one;
		}
	}
	public String getPreparation_two() {
		return preparation_two;
	}
	public void setPreparation_two(String preparation_two) {
		if(preparation_two==null){
			this.preparation_two = "";
		}
		else {
			this.preparation_two = preparation_two;
		}
	}
	public String getPreparation_three() {
		return preparation_three;
	}
	public void setPreparation_three(String preparation_three) {
		if(preparation_three==null){
			this.preparation_three = "";
		}
		else {
			this.preparation_three = preparation_three;
		}
	}
	public String getPreparation_four() {
		return preparation_four;
	}
	public void setPreparation_four(String preparation_four) {
		if(preparation_four==null){
			this.preparation_four = "";
		}
		else {
			this.preparation_four = preparation_four;
		}
	}
	public String getPreparation_five() {
		return preparation_five;
	}
	public void setPreparation_five(String preparation_five) {
		if(preparation_five==null){
			this.preparation_five = "";
		}
		else {
			this.preparation_five = preparation_five;
		}
	}
	public String getType_in_userNme() {
		return type_in_userNme;
	}
	public void setType_in_userNme(String type_in_userNme) {
		this.type_in_userNme = type_in_userNme;
	}
	public String getVerifier() {
		return verifier;
	}
	public void setVerifier(String verifier) {
		this.verifier = verifier;
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
		this.verify_comment = verify_comment;
	}
	public String getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(String entry_time) {
		this.entry_time = entry_time;
	}
	public String getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(String verify_time) {
		this.verify_time = verify_time;
	}
	public String getProject_file_address() {
		return project_file_address;
	}
	public void setProject_file_address(String project_file_address) {
		this.project_file_address = project_file_address;
	}
}
