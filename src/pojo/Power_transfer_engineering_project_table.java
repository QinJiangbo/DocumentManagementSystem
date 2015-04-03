package pojo;

public class Power_transfer_engineering_project_table {
	private String pid;
	private String name;
	private String type;
	private String nation;
	private String area;
	private String power_transfer_type;
	private String single_main_transformation_capacity;
	private String main_transformation_number;
	private String main_transformation_primary_side_voltage;
	private String main_transformation_second_side_voltage;
	private String main_transformation_third_winding_voltage;
	private String main_transformation_primary_side_voltage_power_distribution_main_wire;
	private String main_transformation_second_side_voltage_power_distribution_main_wire;
	private String main_transformation_third_winding_voltage_power_distribution_main_wire;
	private String main_transformation_primary_side_voltage_power_distribution_pattern;
	private String main_transformation_second_side_voltage_power_distribution_pattern;
	private String main_transformation_third_winding_voltage_power_distribution_pattern;
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
	public Power_transfer_engineering_project_table(Power_transfer_engineering_project power_transfer_engineering_project){
		setPid(power_transfer_engineering_project.getPid());
		setName(power_transfer_engineering_project.getName());
		setType(power_transfer_engineering_project.getType());
		setNation(power_transfer_engineering_project.getNation());
		setArea(power_transfer_engineering_project.getArea());
		setPower_transfer_type(power_transfer_engineering_project.getPower_transfer_type());
		setSingle_main_transformation_capacity(power_transfer_engineering_project.getSingle_main_transformation_capacity());
		setMain_transformation_number(power_transfer_engineering_project.getMain_transformation_number());
		setMain_transformation_primary_side_voltage(power_transfer_engineering_project.getMain_transformation_primary_side_voltage());
		setMain_transformation_second_side_voltage(power_transfer_engineering_project.getMain_transformation_second_side_voltage());
		setMain_transformation_third_winding_voltage(power_transfer_engineering_project.getMain_transformation_third_winding_voltage());
		setMain_transformation_primary_side_voltage_power_distribution_main_wire(power_transfer_engineering_project.getMain_transformation_primary_side_voltage_power_distribution_main_wire());
		setMain_transformation_second_side_voltage_power_distribution_main_wire(power_transfer_engineering_project.getMain_transformation_second_side_voltage_power_distribution_main_wire());
		setMain_transformation_third_winding_voltage_power_distribution_main_wire(power_transfer_engineering_project.getMain_transformation_third_winding_voltage_power_distribution_main_wire());
		setMain_transformation_primary_side_voltage_power_distribution_pattern(power_transfer_engineering_project.getMain_transformation_primary_side_voltage_power_distribution_pattern());
		setMain_transformation_second_side_voltage_power_distribution_pattern(power_transfer_engineering_project.getMain_transformation_second_side_voltage_power_distribution_pattern());
		setMain_transformation_third_winding_voltage_power_distribution_pattern(power_transfer_engineering_project.getMain_transformation_third_winding_voltage_power_distribution_pattern());
		setPreparation_one(power_transfer_engineering_project.getPreparation_one());
		setPreparation_two(power_transfer_engineering_project.getPreparation_two());
		setPreparation_three(power_transfer_engineering_project.getPreparation_three());
		setPreparation_four(power_transfer_engineering_project.getPreparation_four());
		setPreparation_five(power_transfer_engineering_project.getPreparation_five());
		setType_in_userNme(power_transfer_engineering_project.getType_in_userNme());
		setVerifier(power_transfer_engineering_project.getVerifier());
		setVerify_comment(power_transfer_engineering_project.getVerify_comment());
		setEntry_time(power_transfer_engineering_project.getEntry_time());
		setVerify_time(power_transfer_engineering_project.getVerify_time());
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
	public String getPower_transfer_type() {
		return power_transfer_type;
	}
	public void setPower_transfer_type(String power_transfer_type) {
		if(power_transfer_type!=null&power_transfer_type!=""){
			this.power_transfer_type = " and [变电站类型] = "+power_transfer_type;
		}
		else {
			this.power_transfer_type = "";
		}
	}
	public String getSingle_main_transformation_capacity() {
		return single_main_transformation_capacity;
	}
	public void setSingle_main_transformation_capacity(
			String single_main_transformation_capacity) {
		if(single_main_transformation_capacity!=null&single_main_transformation_capacity!=""){
			this.single_main_transformation_capacity = " and [单台主变容量] = "+single_main_transformation_capacity;
		}
		else {
			this.single_main_transformation_capacity = "";
		}
	}
	public String getMain_transformation_number() {
		return main_transformation_number;
	}
	public void setMain_transformation_number(String main_transformation_number) {
		if(main_transformation_number!=null&main_transformation_number!=""){
			this.main_transformation_number = " and [主变台数] = "+main_transformation_number;
		}
		else {
			this.main_transformation_number = "";
		}
	}
	public String getMain_transformation_primary_side_voltage() {
		return main_transformation_primary_side_voltage;
	}
	public void setMain_transformation_primary_side_voltage(
			String main_transformation_primary_side_voltage) {
		if(main_transformation_primary_side_voltage!=null&main_transformation_primary_side_voltage!=""){
			this.main_transformation_primary_side_voltage = " and [主变一次侧电压] = "+main_transformation_primary_side_voltage;
		}
		else {
			this.main_transformation_primary_side_voltage = "";
		}
	}
	public String getMain_transformation_second_side_voltage() {
		return main_transformation_second_side_voltage;
	}
	public void setMain_transformation_second_side_voltage(
			String main_transformation_second_side_voltage) {
		if(main_transformation_second_side_voltage!=null&main_transformation_second_side_voltage!=""){
			this.main_transformation_second_side_voltage = " and [主变二次侧电压] = "+main_transformation_second_side_voltage;
		}
		else {
			this.main_transformation_second_side_voltage = "";
		}
	}
	public String getMain_transformation_third_winding_voltage() {
		return main_transformation_third_winding_voltage;
	}
	public void setMain_transformation_third_winding_voltage(
			String main_transformation_third_winding_voltage) {
		if(main_transformation_third_winding_voltage!=null&main_transformation_third_winding_voltage!=""){
			this.main_transformation_third_winding_voltage = " and [主变第三绕组电压] = "+main_transformation_third_winding_voltage;
		}
		else {
			this.main_transformation_third_winding_voltage = "";
		}
	}
	public String getMain_transformation_primary_side_voltage_power_distribution_main_wire() {
		return main_transformation_primary_side_voltage_power_distribution_main_wire;
	}
	public void setMain_transformation_primary_side_voltage_power_distribution_main_wire(
			String main_transformation_primary_side_voltage_power_distribution_main_wire) {
		if(main_transformation_primary_side_voltage_power_distribution_main_wire!=null&main_transformation_primary_side_voltage_power_distribution_main_wire!=""){
			this.main_transformation_primary_side_voltage_power_distribution_main_wire = " and [主变一次侧电压配电装置电气主接线] = "+main_transformation_primary_side_voltage_power_distribution_main_wire;
		}
		else {
			this.main_transformation_primary_side_voltage_power_distribution_main_wire = "";
		}
	}
	public String getMain_transformation_second_side_voltage_power_distribution_main_wire() {
		return main_transformation_second_side_voltage_power_distribution_main_wire;
	}
	public void setMain_transformation_second_side_voltage_power_distribution_main_wire(
			String main_transformation_second_side_voltage_power_distribution_main_wire) {
		if(main_transformation_second_side_voltage_power_distribution_main_wire!=null&main_transformation_second_side_voltage_power_distribution_main_wire!=""){
			this.main_transformation_second_side_voltage_power_distribution_main_wire = " and [主变二次侧电压配电装置电气主接线] = "+main_transformation_second_side_voltage_power_distribution_main_wire;
		}
		else {
			this.main_transformation_second_side_voltage_power_distribution_main_wire = "";
		}
	}
	public String getMain_transformation_third_winding_voltage_power_distribution_main_wire() {
		return main_transformation_third_winding_voltage_power_distribution_main_wire;
	}
	public void setMain_transformation_third_winding_voltage_power_distribution_main_wire(
			String main_transformation_third_winding_voltage_power_distribution_main_wire) {
		if(main_transformation_third_winding_voltage_power_distribution_main_wire!=null&main_transformation_third_winding_voltage_power_distribution_main_wire!=""){
			this.main_transformation_third_winding_voltage_power_distribution_main_wire = " and [主变第三绕组侧电压配电装置电气主接线] = "+main_transformation_third_winding_voltage_power_distribution_main_wire;
		}
		else {
			this.main_transformation_third_winding_voltage_power_distribution_main_wire = "";
		}
	}
	public String getMain_transformation_primary_side_voltage_power_distribution_pattern() {
		return main_transformation_primary_side_voltage_power_distribution_pattern;
	}
	public void setMain_transformation_primary_side_voltage_power_distribution_pattern(
			String main_transformation_primary_side_voltage_power_distribution_pattern) {
		if(main_transformation_primary_side_voltage_power_distribution_pattern!=null&main_transformation_primary_side_voltage_power_distribution_pattern!=""){
			this.main_transformation_primary_side_voltage_power_distribution_pattern = " and [主变一次侧电压配电装置型式] = "+main_transformation_primary_side_voltage_power_distribution_pattern;
		}
		else {
			this.main_transformation_primary_side_voltage_power_distribution_pattern = "";
		}
	}
	public String getMain_transformation_second_side_voltage_power_distribution_pattern() {
		return main_transformation_second_side_voltage_power_distribution_pattern;
	}
	public void setMain_transformation_second_side_voltage_power_distribution_pattern(
			String main_transformation_second_side_voltage_power_distribution_pattern) {
		if(main_transformation_second_side_voltage_power_distribution_pattern!=null&main_transformation_second_side_voltage_power_distribution_pattern!=""){
			this.main_transformation_second_side_voltage_power_distribution_pattern = " and [主变二次侧电压配电装置型式] = "+main_transformation_second_side_voltage_power_distribution_pattern;
		}
		else {
			this.main_transformation_second_side_voltage_power_distribution_pattern = "";
		}
	}
	public String getMain_transformation_third_winding_voltage_power_distribution_pattern() {
		return main_transformation_third_winding_voltage_power_distribution_pattern;
	}
	public void setMain_transformation_third_winding_voltage_power_distribution_pattern(
			String main_transformation_third_winding_voltage_power_distribution_pattern) {
		if(main_transformation_third_winding_voltage_power_distribution_pattern!=null&main_transformation_third_winding_voltage_power_distribution_pattern!=""){
			this.main_transformation_third_winding_voltage_power_distribution_pattern = " and [主变第三绕组侧电压配电装置型式] = "+main_transformation_third_winding_voltage_power_distribution_pattern;
		}
		else {
			this.main_transformation_third_winding_voltage_power_distribution_pattern = "";
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
