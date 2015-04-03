package pojo;

public class Device_vender_material_table {
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
	private String verify_comment;
	private String entry_time;
	private String verify_time;
	public Device_vender_material_table(Device_vender_material device_vender_material){
		setDevice_name(device_vender_material.getDevice_name());
		setFactory_name(device_vender_material.getFactory_name());
		setProfession(device_vender_material.getProfession());
		setSummary(device_vender_material.getSummary());
		setPreparation_one(device_vender_material.getPreparation_one());
		setPreparation_two(device_vender_material.getPreparation_two());
		setPreparation_three(device_vender_material.getPreparation_three());
		setPreparation_four(device_vender_material.getPreparation_four());
		setPreparation_five(device_vender_material.getPreparation_five());
		setType_in_userNme(device_vender_material.getType_in_userNme());
		setVerifier(device_vender_material.getVerifier());
		setVerify_comment(device_vender_material.getVerify_comment());
		setEntry_time(device_vender_material.getEntry_time());
		setVerify_time(device_vender_material.getVerify_time());
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		if(device_name!=null&device_name!=""){
			this.device_name = "[设备名称] like '%"+device_name+"%'";
		}
		else {
			this.device_name = "";
		}
	}
	public String getFactory_name() {
		return factory_name;
	}
	public void setFactory_name(String factory_name) {
		if(factory_name!=null&factory_name!=""){
			this.factory_name = "[厂家名称] like '%"+factory_name+"%'";
		}
		else {
			this.factory_name = "";
		}
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		if(profession!=null&profession!=""){
			this.profession = " and [专业] = "+profession;
		}
		else {
			this.profession = "";
		}
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		if(summary!=null&summary!=""){
			this.summary = " and [摘要] = "+summary;
		}
		else {
			this.summary = "";
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
