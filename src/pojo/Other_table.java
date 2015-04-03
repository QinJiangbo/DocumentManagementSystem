package pojo;

public class Other_table {
	private String expert_lecture;
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
	public Other_table(Other other){
		setExpert_lecture(other.getExpert_lecture());
		setPreparation_one(other.getPreparation_one());
		setPreparation_two(other.getPreparation_two());
		setPreparation_three(other.getPreparation_three());
		setPreparation_four(other.getPreparation_four());
		setPreparation_five(other.getPreparation_five());
		setType_in_userNme(other.getType_in_userNme());
		setVerifier(other.getVerifier());
		setVerify_comment(other.getVerify_comment());
		setEntry_time(other.getEntry_time());
		setVerify_time(other.getVerify_time());
	}
	public String getExpert_lecture() {
		return expert_lecture;
	}
	public void setExpert_lecture(String expert_lecture) {
		if(expert_lecture!=null&expert_lecture!=""){
			this.expert_lecture = "[专家讲座] like '%"+expert_lecture+"%'";
		}
		else {
			this.expert_lecture = "";
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
