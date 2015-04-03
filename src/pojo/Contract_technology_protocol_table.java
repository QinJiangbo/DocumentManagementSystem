package pojo;

public class Contract_technology_protocol_table {
	private String pid;
	private String name;
	private String capacity;
	private String profession_name;
	private String device_name;
	private String nation;
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
	public Contract_technology_protocol_table(Contract_technology_protocol contract_technology_protocol){
		setPid(contract_technology_protocol.getPid());
		setName(contract_technology_protocol.getName());
		setCapacity(contract_technology_protocol.getCapacity());
		setProfession_name(contract_technology_protocol.getProfession_name());
		setDevice_name(contract_technology_protocol.getDevice_name());
		setNation(contract_technology_protocol.getNation());
		setPreparation_one(contract_technology_protocol.getPreparation_one());
		setPreparation_two(contract_technology_protocol.getPreparation_two());
		setPreparation_three(contract_technology_protocol.getPreparation_three());
		setPreparation_four(contract_technology_protocol.getPreparation_four());
		setPreparation_five(contract_technology_protocol.getPreparation_five());
		setType_in_userNme(contract_technology_protocol.getType_in_userNme());
		setVerifier(contract_technology_protocol.getVerifier());
		setVerify_comment(contract_technology_protocol.getVerify_comment());
		setEntry_time(contract_technology_protocol.getEntry_time());
		setVerify_time(contract_technology_protocol.getVerify_time());
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
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		if(capacity!=null&capacity!=""){
			if(capacity.equals("0~150")){
				this.capacity = " and [机组容量]>0 and [机组容量]< 150 ";
			}
			else if(capacity.equals("150")){
				this.capacity = " and [机组容量] = 150 ";
			}
			else if(capacity.equals("150~200")){
				this.capacity = " and [机组容量]>150 and [机组容量]< 200 ";
			}
			else if(capacity.equals("200")){
				this.capacity = " and [机组容量] = 200 ";
			}
			else if(capacity.equals("200~300")){
				this.capacity = " and [机组容量]>200 and [机组容量]< 300 ";
			}
			else if(capacity.equals("300")){
				this.capacity = " and [机组容量] = 300 ";
			}
			else if(capacity.equals("300~350")){
				this.capacity = " and [机组容量]>300 and [机组容量]< 350 ";
			}
			else if(capacity.equals("350")){
				this.capacity = " and [机组容量] = 350 ";
			}
			else if(capacity.equals("350~600")){
				this.capacity = " and [机组容量]> 350 and [机组容量]< 600 ";
			}
			else if(capacity.equals("600")){
				this.capacity = " and [机组容量] = 600 ";
			}
			else if(capacity.equals("600以上")){
				this.capacity = " and [机组容量]>600 ";
			}
		}
		else {
			this.capacity = "";
		}
	}
	public String getProfession_name() {
		return profession_name;
	}
	public void setProfession_name(String profession_name) {
		if(profession_name!=null&profession_name!=""){
			this.profession_name = " and [专业名称] = "+profession_name;
		}
		else {
			this.profession_name = "";
		}
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		if(device_name!=null&device_name!=""){
			this.device_name = " and [设备名称] = "+device_name;
		}
		else {
			this.device_name = "";
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
