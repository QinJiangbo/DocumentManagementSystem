package pojo;

public class Device_vender_material {
	private int id;
	private String device_name;
	private String factory_name;
	private String profession;
	private String summary;
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
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		if(device_name==null){
			this.device_name = "";
		}
		else {
			this.device_name = device_name;
		}
	}
	public String getFactory_name() {
		return factory_name;
	}
	public void setFactory_name(String factory_name) {
		if(factory_name==null){
			this.factory_name = "";
		}
		else {
			this.factory_name = factory_name;
		}
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		if(profession==null){
			this.profession = "";
		}
		else {
			this.profession = profession;
		}
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		if(summary==null){
			this.summary = "";
		}
		else {
			this.summary = summary;
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
