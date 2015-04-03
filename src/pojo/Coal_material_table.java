package pojo;

public class Coal_material_table {
	private String pid;
	private String project_name;
	private String sulfur;
	private String ash;
	private String moisture;
	private String net_calorific_power;
	private String coal_producing_area;
	private String ARB_Car;
	private String ARB_Har;
	private String ARB_Oar;
	private String ARB_Nar;
	private String ARB_S;
	private String ARB_Mar;
	private String ARB_Aar;
	private String mad;
	private String vdaf;
	private String ARB_LHV;
	private String HGI;
	private String ke;
	private String IT;
	private String DT;
	private String ST;
	private String FT;
	private String SiO2;
	private String Al2O3;
	private String Fe2O3;
	private String CaO;
	private String SO3;
	private String grindability_judge;
	private String abradability_judge;
	private String fire_stability_judge;
	private String ash_quality_judge;
	private String pollution_quality_judge;
	private String slag_bonding_trend_judge;
	private String coal_dust_explode_judge;
	private String summary;
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
	public Coal_material_table(Coal_material coal_material){
		setPid(coal_material.getPid());
		setProject_name(coal_material.getProject_name());
		setSulfur(coal_material.getSulfur());
		setAsh(coal_material.getAsh());
		setMoisture(coal_material.getMoisture());
		setNet_calorific_power(coal_material.getNet_calorific_power());
		setCoal_producing_area(coal_material.getCoal_producing_area());
		setARB_Car(coal_material.getARB_Car());
		setARB_Har(coal_material.getARB_Har());
		setARB_Oar(coal_material.getARB_Oar());
		setARB_Nar(coal_material.getARB_Nar());
		setARB_S(coal_material.getARB_S());
		setARB_Mar(coal_material.getARB_Mar());
		setARB_Aar(coal_material.getARB_Aar());
		setMad(coal_material.getMad());
		setVdaf(coal_material.getVdaf());
		setARB_LHV(coal_material.getARB_LHV());
		setHGI(coal_material.getHGI());
		setKe(coal_material.getKe());
		setIT(coal_material.getIT());
		setDT(coal_material.getDT());
		setST(coal_material.getST());
		setFT(coal_material.getFT());
		setSiO2(coal_material.getSiO2());
		setAl2O3(coal_material.getAl2O3());
		setFe2O3(coal_material.getFe2O3());
		setCaO(coal_material.getCaO());
		setSO3(coal_material.getSO3());
		setGrindability_judge(coal_material.getGrindability_judge());
		setAbradability_judge(coal_material.getAbradability_judge());
		setFire_stability_judge(coal_material.getFire_stability_judge());
		setAsh_quality_judge(coal_material.getAsh_quality_judge());
		setPollution_quality_judge(coal_material.getPollution_quality_judge());
		setSlag_bonding_trend_judge(coal_material.getSlag_bonding_trend_judge());
		setCoal_dust_explode_judge(coal_material.getCoal_dust_explode_judge());
		setSummary(coal_material.getSummary());
		setPreparation_one(coal_material.getPreparation_one());
		setPreparation_two(coal_material.getPreparation_two());
		setPreparation_three(coal_material.getPreparation_three());
		setPreparation_four(coal_material.getPreparation_four());
		setPreparation_five(coal_material.getPreparation_five());
		setPreparation_six(coal_material.getPreparation_six());
		setPreparation_seven(coal_material.getPreparation_seven());
		setPreparation_eight(coal_material.getPreparation_eight());
		setPreparation_nine(coal_material.getPreparation_nine());
		setPreparation_ten(coal_material.getPreparation_ten());
		setType_in_userNme(coal_material.getType_in_userNme());
		setVerifier(coal_material.getVerifier());
		setVerify_comment(coal_material.getVerify_comment());
		setEntry_time(coal_material.getEntry_time());
		setVerify_time(coal_material.getVerify_time());
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		if(pid!=null&pid!=""){
			this.pid = "[标准编号] like '%"+pid+"%'";
		}
		else {
			this.pid = "";
		}
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		if(project_name!=null&project_name!=""){
			this.project_name = " and [工程名称] like '%"+project_name+"%'";
		}
		else {
			this.project_name = "";
		}
	}
	public String getSulfur() {
		return sulfur;
	}
	public void setSulfur(String sulfur) {
		if(sulfur!=null&sulfur!=""){
			this.sulfur = " and [硫] = "+sulfur;
		}
		else {
			this.sulfur = "";
		}
	}
	public String getAsh() {
		return ash;
	}
	public void setAsh(String ash) {
		if(ash!=null&ash!=""){
			this.ash = " and [灰分] = "+ash;
		}
		else {
			this.ash = "";
		}
	}
	public String getMoisture() {
		return moisture;
	}
	public void setMoisture(String moisture) {
		if(moisture!=null&moisture!=""){
			this.moisture = " and [水分] = "+moisture;
		}
		else {
			this.moisture = "";
		}
	}
	public String getNet_calorific_power() {
		return net_calorific_power;
	}
	public void setNet_calorific_power(String net_calorific_power) {
		if(net_calorific_power!=null&net_calorific_power!=""){
			this.net_calorific_power = " and [低位发热量] = "+net_calorific_power;
		}
		else {
			this.net_calorific_power = "";
		}
	}
	public String getCoal_producing_area() {
		return coal_producing_area;
	}
	public void setCoal_producing_area(String coal_producing_area) {
		if(coal_producing_area!=null&coal_producing_area!=""){
			this.coal_producing_area = " and [燃煤产地] = "+coal_producing_area;
		}
		else {
			this.coal_producing_area = "";
		}
	}
	public String getARB_Car() {
		return ARB_Car;
	}
	public void setARB_Car(String aRB_Car) {
		if(aRB_Car!=null&aRB_Car!=""){
			this.ARB_Car = " and [收到基碳] = "+aRB_Car;
		}
		else {
			this.ARB_Car = "";
		}
	}
	public String getARB_Har() {
		return ARB_Har;
	}
	public void setARB_Har(String aRB_Har) {
		if(aRB_Har!=null&aRB_Har!=""){
			this.ARB_Har = " and [收到基氢] = "+aRB_Har;
		}
		else {
			this.ARB_Har = "";
		}
	}
	public String getARB_Oar() {
		return ARB_Oar;
	}
	public void setARB_Oar(String aRB_Oar) {
		if(aRB_Oar!=null&aRB_Oar!=""){
			this.ARB_Oar = " and [收到基氧] = "+aRB_Oar;
		}
		else {
			this.ARB_Oar = "";
		}
	}
	public String getARB_Nar() {
		return ARB_Nar;
	}
	public void setARB_Nar(String aRB_Nar) {
		if(aRB_Nar!=null&aRB_Nar!=""){
			this.ARB_Nar = " and [收到基氮] = "+aRB_Nar;
		}
		else {
			this.ARB_Nar = "";
		}
	}
	public String getARB_S() {
		return ARB_S;
	}
	public void setARB_S(String aRB_S) {
		if(aRB_S!=null&aRB_S!=""){
			this.ARB_S = " and [收到基全硫] = "+aRB_S;
		}
		else {
			this.ARB_S = "";
		}
	}
	public String getARB_Mar() {
		return ARB_Mar;
	}
	public void setARB_Mar(String aRB_Mar) {
		if(aRB_Mar!=null&aRB_Mar!=""){
			this.ARB_Mar = " and [收到基水分] = "+aRB_Mar;
		}
		else {
			this.ARB_Mar = "";
		}
	}
	public String getARB_Aar() {
		return ARB_Aar;
	}
	public void setARB_Aar(String aRB_Aar) {
		if(aRB_Aar!=null&aRB_Aar!=""){
			this.ARB_Aar = " and [收到基灰分] = "+aRB_Aar;
		}
		else {
			this.ARB_Aar = "";
		}
	}
	public String getMad() {
		return mad;
	}
	public void setMad(String mad) {
		if(mad!=null&mad!=""){
			this.mad = " and [空气干燥基水分] = "+mad;
		}
		else {
			this.mad = "";
		}
	}
	public String getVdaf() {
		return vdaf;
	}
	public void setVdaf(String vdaf) {
		if(vdaf!=null&vdaf!=""){
			this.vdaf = " and [干燥无灰基挥发分] = "+vdaf;
		}
		else {
			this.vdaf = "";
		}
	}
	public String getARB_LHV() {
		return ARB_LHV;
	}
	public void setARB_LHV(String aRB_LHV) {
		if(aRB_LHV!=null&aRB_LHV!=""){
			this.ARB_LHV = " and [收到基低位发热量] = "+aRB_LHV;
		}
		else {
			this.ARB_LHV = "";
		}
	}
	public String getHGI() {
		return HGI;
	}
	public void setHGI(String hGI) {
		if(hGI!=null&hGI!=""){
			this.HGI = " and [可磨系数] = "+hGI;
		}
		else {
			this.HGI = "";
		}
	}
	public String getKe() {
		return ke;
	}
	public void setKe(String ke) {
		if(ke!=null&ke!=""){
			this.ke = " and [冲刷磨损指数] = "+ke;
		}
		else {
			this.ke = "";
		}
	}
	public String getIT() {
		return IT;
	}
	public void setIT(String iT) {
		if(iT!=null&iT!=""){
			this.IT = " and [煤粉气流着火温度] = "+iT;
		}
		else {
			this.IT = "";
		}
	}
	public String getDT() {
		return DT;
	}
	public void setDT(String dT) {
		if(dT!=null&dT!=""){
			this.DT = " and [变形温度] = "+dT;
		}
		else {
			this.DT = "";
		}
	}
	public String getST() {
		return ST;
	}
	public void setST(String sT) {
		if(sT!=null&sT!=""){
			this.ST = " and [软化温度] = "+sT;
		}
		else {
			this.ST = "";
		}
	}
	public String getFT() {
		return FT;
	}
	public void setFT(String fT) {
		if(fT!=null&fT!=""){
			this.FT = " and [流动温度] = "+fT;
		}
		else {
			this.FT = "";
		}
	}
	public String getSiO2() {
		return SiO2;
	}
	public void setSiO2(String siO2) {
		if(siO2!=null&siO2!=""){
			this.SiO2 = " and [二氧化硅] = "+siO2;
		}
		else {
			this.SiO2 = "";
		}
	}
	public String getAl2O3() {
		return Al2O3;
	}
	public void setAl2O3(String al2o3) {
		if(al2o3!=null&al2o3!=""){
			this.Al2O3 = " and [三氧化二铝] = "+al2o3;
		}
		else {
			this.Al2O3 = "";
		}
	}
	public String getFe2O3() {
		return Fe2O3;
	}
	public void setFe2O3(String fe2o3) {
		if(fe2o3!=null&fe2o3!=""){
			this.Fe2O3 = " and [三氧化二铁] = "+fe2o3;
		}
		else {
			this.Fe2O3 = "";
		}
	}
	public String getCaO() {
		return CaO;
	}
	public void setCaO(String caO) {
		if(caO!=null&caO!=""){
			this.CaO = " and [氧化钙] = "+caO;
		}
		else {
			this.CaO = "";
		}
	}
	public String getSO3() {
		return SO3;
	}
	public void setSO3(String sO3) {
		if(sO3!=null&sO3!=""){
			this.SO3 = " and [三氧化硫] = "+sO3;
		}
		else {
			this.SO3 = "";
		}
	}
	public String getGrindability_judge() {
		return grindability_judge;
	}
	public void setGrindability_judge(String grindability_judge) {
		if(grindability_judge!=null&grindability_judge!=""){
			this.grindability_judge = " and [可磨性判定] = "+grindability_judge;
		}
		else {
			this.grindability_judge = "";
		}
	}
	public String getAbradability_judge() {
		return abradability_judge;
	}
	public void setAbradability_judge(String abradability_judge) {
		if(abradability_judge!=null&abradability_judge!=""){
			this.abradability_judge = " and [磨损性判定] = "+abradability_judge;
		}
		else {
			this.abradability_judge = "";
		}
	}
	public String getFire_stability_judge() {
		return fire_stability_judge;
	}
	public void setFire_stability_judge(String fire_stability_judge) {
		if(fire_stability_judge!=null&fire_stability_judge!=""){
			this.fire_stability_judge = " and [着火稳定性判定] = "+fire_stability_judge;
		}
		else {
			this.fire_stability_judge = "";
		}
	}
	public String getAsh_quality_judge() {
		return ash_quality_judge;
	}
	public void setAsh_quality_judge(String ash_quality_judge) {
		if(ash_quality_judge!=null&ash_quality_judge!=""){
			this.ash_quality_judge = " and [燃烬特性判定] = "+ash_quality_judge;
		}
		else {
			this.ash_quality_judge = "";
		}
	}
	public String getPollution_quality_judge() {
		return pollution_quality_judge;
	}
	public void setPollution_quality_judge(String pollution_quality_judge) {
		if(pollution_quality_judge!=null&pollution_quality_judge!=""){
			this.pollution_quality_judge = " and [灰沾污性能判定] = "+pollution_quality_judge;
		}
		else {
			this.pollution_quality_judge = "";
		}
	}
	public String getSlag_bonding_trend_judge() {
		return slag_bonding_trend_judge;
	}
	public void setSlag_bonding_trend_judge(String slag_bonding_trend_judge) {
		if(slag_bonding_trend_judge!=null&slag_bonding_trend_judge!=""){
			this.slag_bonding_trend_judge = " and [结渣倾向判定] = "+slag_bonding_trend_judge;
		}
		else {
			this.slag_bonding_trend_judge = "";
		}
	}
	public String getCoal_dust_explode_judge() {
		return coal_dust_explode_judge;
	}
	public void setCoal_dust_explode_judge(String coal_dust_explode_judge) {
		if(coal_dust_explode_judge!=null&coal_dust_explode_judge!=""){
			this.coal_dust_explode_judge = " and [煤粉爆炸性判定] = "+coal_dust_explode_judge;
		}
		else {
			this.coal_dust_explode_judge = "";
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
		if(preparation_ten!=null&preparation_ten!=""){
			this.preparation_ten = " and [录入用户名] = "+preparation_ten;
		}
		else {
			this.preparation_ten = "";
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
