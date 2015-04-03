package pojo;

public class Project_expert_table {
	private String name;
	private String profession;
	private String department;
	private String education_background;
	private String graduation_school;
	private String working_time;
	private String identified_card;
	private String job;
	private String job_title;
	private String contact_number;
	private String telephone;
	private String fax;
	private String email;
	private String mailing_address;
	private String postcode;
	private String technical_expertise;
	private String job_resume;
	private String main_performance;
	private String awards;
	private String papers;
	private String remark;
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
	public Project_expert_table(Project_expert project_expert){
		setName(project_expert.getName());
		setProfession(project_expert.getProfession());
		setDepartment(project_expert.getDepartment());
		setEducation_background(project_expert.getEducation_background());
		setGraduation_school(project_expert.getGraduation_school());
		setWorking_time(project_expert.getWorking_time());
		setIdentified_card(project_expert.getIdentified_card());
		setJob(project_expert.getJob());
		setJob_title(project_expert.getJob_title());
		setContact_number(project_expert.getContact_number());
		setTelephone(project_expert.getTelephone());
		setFax(project_expert.getFax());
		setEmail(project_expert.getEmail());
		setMailing_address(project_expert.getMailing_address());
		setPostcode(project_expert.getPostcode());
		setTechnical_expertise(project_expert.getTechnical_expertise());
		setJob_resume(project_expert.getJob_resume());
		setMain_performance(project_expert.getMain_performance());
		setAwards(project_expert.getAwards());
		setPapers(project_expert.getPapers());
		setRemark(project_expert.getRemark());
		setPreparation_one(project_expert.getPreparation_one());
		setPreparation_two(project_expert.getPreparation_two());
		setPreparation_three(project_expert.getPreparation_three());
		setPreparation_four(project_expert.getPreparation_four());
		setPreparation_five(project_expert.getPreparation_five());
		setType_in_userNme(project_expert.getType_in_userNme());
		setVerifier(project_expert.getVerifier());
		setVerify_comment(project_expert.getVerify_comment());
		setEntry_time(project_expert.getEntry_time());
		setVerify_time(project_expert.getVerify_time());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name!=null&name!=""){
			this.name = "[姓名] like '%"+name+"%'";
		}
		else {
			this.name = "";
		}
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		if(profession!=null&profession!=""){
			this.profession = "and [专业] like '%"+profession+"%'";
		}
		else {
			this.profession = "";
		}
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		if(department!=null&department!=""){
			this.department = " and [所在单位] = "+department;
		}
		else {
			this.department = "";
		}
	}
	public String getEducation_background() {
		return education_background;
	}
	public void setEducation_background(String education_background) {
		if(education_background!=null&education_background!=""){
			this.education_background = " and [学历] = "+education_background;
		}
		else {
			this.education_background = "";
		}
	}
	public String getGraduation_school() {
		return graduation_school;
	}
	public void setGraduation_school(String graduation_school) {
		if(graduation_school!=null&graduation_school!=""){
			this.graduation_school = " and [毕业学校] = "+graduation_school;
		}
		else {
			this.graduation_school = "";
		}
	}
	public String getWorking_time() {
		return working_time;
	}
	public void setWorking_time(String working_time) {
		if(working_time!=null&working_time!=""){
			this.working_time = " and [参加工作时间] = "+working_time;
		}
		else {
			this.working_time = "";
		}
	}
	public String getIdentified_card() {
		return identified_card;
	}
	public void setIdentified_card(String identified_card) {
		if(identified_card!=null&identified_card!=""){
			this.identified_card = " and [身份证] = "+identified_card;
		}
		else {
			this.identified_card = "";
		}
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		if(identified_card!=null&identified_card!=""){
			this.identified_card = " and [职务] = "+identified_card;
		}
		else {
			this.identified_card = "";
		}
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		if(job_title!=null&job_title!=""){
			this.job_title = " and [职称] = "+job_title;
		}
		else {
			this.job_title = "";
		}
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		if(contact_number!=null&contact_number!=""){
			this.contact_number = " and [联系电话] = "+contact_number;
		}
		else {
			this.contact_number = "";
		}
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		if(telephone!=null&telephone!=""){
			this.telephone = " and [手机] = "+telephone;
		}
		else {
			this.telephone = "";
		}
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		if(fax!=null&fax!=""){
			this.fax = " and [传真] = "+fax;
		}
		else {
			this.fax = "";
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email!=null&email!=""){
			this.email = " and [email] = "+email;
		}
		else {
			this.email = "";
		}
	}
	public String getMailing_address() {
		return mailing_address;
	}
	public void setMailing_address(String mailing_address) {
		if(mailing_address!=null&mailing_address!=""){
			this.mailing_address = " and [通讯地址] = "+mailing_address;
		}
		else {
			this.mailing_address = "";
		}
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		if(postcode!=null&postcode!=""){
			this.postcode = " and [邮编] = "+postcode;
		}
		else {
			this.postcode = "";
		}
	}
	public String getTechnical_expertise() {
		return technical_expertise;
	}
	public void setTechnical_expertise(String technical_expertise) {
		if(technical_expertise!=null&technical_expertise!=""){
			this.technical_expertise = " and [技术专长] = "+technical_expertise;
		}
		else {
			this.technical_expertise = "";
		}
	}
	public String getJob_resume() {
		return job_resume;
	}
	public void setJob_resume(String job_resume) {
		if(job_resume!=null&job_resume!=""){
			this.job_resume = " and [工作简历] = "+job_resume;
		}
		else {
			this.job_resume = "";
		}
	}
	public String getMain_performance() {
		return main_performance;
	}
	public void setMain_performance(String main_performance) {
		if(main_performance!=null&main_performance!=""){
			this.main_performance = " and [主要业绩] = "+main_performance;
		}
		else {
			this.main_performance = "";
		}
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		if(awards!=null&awards!=""){
			this.awards = " and [获奖情况] = "+awards;
		}
		else {
			this.awards = "";
		}
	}
	public String getPapers() {
		return papers;
	}
	public void setPapers(String papers) {
		if(papers!=null&papers!=""){
			this.papers = " and [著作及论文] = "+papers;
		}
		else {
			this.papers = "";
		}
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		if(remark!=null&remark!=""){
			this.remark = " and [备注] = "+remark;
		}
		else {
			this.remark = "";
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
