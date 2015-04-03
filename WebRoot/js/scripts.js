function login_check(){
	var user_name=document.getElementById("name");
	var password=document.getElementById("pwd");
	var user_name_val=user_name.value;
	var password_val=password.value;
	if(user_name_val=="")
	{
		$("input[name='name']").attr("placeholder","用户名不能为空！");
		$("input[name='pwd']").attr("placeholder","");
		user_name.focus();
		return false;
	}
	else if(password_val=="")
	{
		$("input[name='pwd']").attr("placeholder","密码不能为空！");
		$("input[name='name']").attr("placeholder","");
		password.focus();
		return false;
	}
	return true;
}

function register_check(){
	var authorities=document.reg_form.authority;
	var reg_user_name=document.getElementById("reg_user_name");
	var reg_password=document.getElementById("reg_password");
	var email=document.getElementById("email");
	var real_name=document.getElementById("real_name");
	var reg_user_name_val=reg_user_name.value;
	var reg_password_val=reg_password.value;
	var email_val=email.value;
	var real_name_val=real_name.value;
	
	var selected_flag=0;
	for(var i=0;i<authorities.length;i++){
		if(authorities[i].checked==true){
			selected_flag=1;
			break;
		}
	}
	if(selected_flag==0){
		alert("请选择一个权限！");
		return false;
	}
	
	if(reg_user_name_val==""){
		$("input[name='reg_user_name']").attr("placeholder","用户名称不能为空！");
		$("input[name='reg_password']").attr("placeholder","");
		$("input[name='email']").attr("placeholder","");
		$("input[name='real_name']").attr("placeholder","");
		reg_user_name.focus();
		return false;
	}else if(reg_password_val==""){
		$("input[name='reg_password']").attr("placeholder","用户密码不能为空！");
		$("input[name='email']").attr("placeholder","");
		$("input[name='real_name']").attr("placeholder","");
		reg_password.focus();
		return false;
	}else if(email_val==""){
		$("input[name='email']").attr("placeholder","用户邮箱不能为空！");
		$("input[name='real_name']").attr("placeholder","");
		email.focus();
		return false;
	}else if(real_name_val==""){
		$("input[name='real_name']").attr("placeholder","真实姓名不能为空！");
		real_name.focus();
		return false;
	}
	return true;
}
//加载处理页面跳转以及输入锁定问题
window.onload = function(){
	$(".action_state").css('visibility','hidden');
	if($(".pageName").text()=="fuel_machine_project"){
		if($(".actionDo").text() == "update"){
			$("form:eq(0)").attr('action',"FuelMachineProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"FuelMachineProjectServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"FuelMachineProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"FuelMachineProjectServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}
	else if($(".pageName").text()=="fuel_coal_project"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"FuelCoalProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"FuelCoalProjectServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"FuelCoalProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"FuelCoalProjectServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}

	else if($(".pageName").text()=="photovoltaic_generation_project"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"PhotovoltaicGenerationProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"PhotovoltaicGenerationProjectServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"PhotovoltaicGenerationProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"PhotovoltaicGenerationProjectServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}

	else if($(".pageName").text()=="biomass_rubbish_project"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"BiomassRubbishProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"BiomassRubbishProjectServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"BiomassRubbishProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"BiomassRubbishProjectServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}

	else if($(".pageName").text()=="power_transfer_engineering_project"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"PowerTransferEngineeringProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"PowerTransferEngineeringProjectServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"PowerTransferEngineeringProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"PowerTransferEngineeringProjectServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}

	else if($(".pageName").text()=="power_deliver_project"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"PowerDeliverProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"PowerDeliverProjectServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"PowerDeliverProjectServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"PowerDeliverProjectServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}

	else if($(".pageName").text()=="pre_engineering_data"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"PreEngineeringDataServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"PreEngineeringDataServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"PreEngineeringDataServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"PreEngineeringDataServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}

	else if($(".pageName").text()=="home_broad_standard"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"HomeBroadStandardServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"HomeBroadStandardServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"HomeBroadStandardServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"HomeBroadStandardServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}

	else if($(".pageName").text()=="company_technology_achievement"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"CompanyTechnologyAchievementServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"CompanyTechnologyAchievementServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"CompanyTechnologyAchievementServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"CompanyTechnologyAchievementServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}
	else if($(".pageName").text()=="engineer_summary"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"EngineeringSummaryServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"EngineeringSummaryServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"EngineeringSummaryServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"EngineeringSummaryServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}
	else if($(".pageName").text()=="contract_technology_protocol"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"ContractTechnologyProtocolServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"ContractTechnologyProtocolServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"ContractTechnologyProtocolServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"ContractTechnologyProtocolServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}
	else if($(".pageName").text()=="device_vender_material"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"DeviceVenderMaterialServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"DeviceVenderMaterialServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"DeviceVenderMaterialServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"DeviceVenderMaterialServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}
	else if($(".pageName").text()=="technology_essay"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"TechnologyEssayServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"TechnologyEssayServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"TechnologyEssayServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"TechnologyEssayServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}
	else if($(".pageName").text()=="coal_material"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"CoalMaterialServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"CoalMaterialServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"CoalMaterialServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"CoalMaterialServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}
	else if($(".pageName").text()=="technology"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"TechnologyServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"TechnologyServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"TechnologyServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"TechnologyServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}
	else if($(".pageName").text()=="other"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"OtherServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"OtherServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"OtherServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"OtherServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}
	else if($(".pageName").text()=="project_expert"){
		if($(".actionDo").text() == "update"){
			
			$("form:eq(0)").attr('action',"ProjectExpertServlet?op=update");
		}
		else if($(".actionDo").text() == "verify"){
			$("form:eq(0)").attr('action',"ProjectExpertServlet?op=verify");
		}
		else if($(".actionDo").text() == "save"){
			$("form:eq(0)").attr('action',"ProjectExpertServlet?op=update");
		}
		else if($(".actionDo").text() == "maintenance"){
			$("form:eq(0)").attr('action',"ProjectExpertServlet?op=maintenance");
		}
		else if($(".actionDo").text() == "view"){
			$(".content input").attr('disabled','true');
			$(".content select").attr('disabled','true');
			$(".content textArea").attr('disabled','true');
			$(".input_menu_bar").css('visibility','hidden');
		}
	}
	else if($(".pageName").text()=="UserServlet"){
		if($(".actionDo").text() == "update"){
			var id = $('input[name=id]').val();
			$("form:eq(0)").attr('action',"UserServlet?act=update&op=update&id="+id);
		}
	}
	else{}
	/*preserved field blank dealing*/
	$(".project_input_item_left").each(function(){
        var preserved_field_left=$(this).html();
        if(/^\s*?$/.test(preserved_field_left)){
        	if($(this).next().length==0){
            	$(this).parent().hide();
        	}
        }
        else{
        	 $(this).parent().show();
        }
	});
	/*upass page ban the button of save*/
	if($(".ch").text()=="unpass"||$(".ch").text()=="maintenance"||$(".actionDo").text()=="maintenance"){
		$(".input_menu_bar_store").attr('disabled','true');
		$("textArea[name=verify_comment]").attr('disabled','true');
	}
};
function pass(pageName){
	if($(".pageName").text()=="fuel_machine_project"){
		$("form:eq(0)").attr('action',"FuelMachineProjectServlet?op=verify&se=1&method=init&projectType=燃机项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="fuel_coal_project"){
		$("form:eq(0)").attr('action',"FuelCoalProjectServlet?op=verify&se=1&method=init&projectType=燃煤项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="photovoltaic_generation_project"){
		$("form:eq(0)").attr('action',"PhotovoltaicGenerationProjectServlet?op=verify&se=1&method=init&projectType=光伏发电项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="biomass_rubbish_project"){
		$("form:eq(0)").attr('action',"BiomassRubbishProjectServlet?op=verify&se=1&method=init&projectType=生物质、垃圾发电项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="power_transfer_engineering_project"){
		$("form:eq(0)").attr('action',"PowerTransferEngineeringProjectServlet?op=verify&se=1&method=init&projectType=变电工程项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="power_deliver_project"){
		$("form:eq(0)").attr('action',"PowerDeliverProjectServlet?op=verify&se=1&method=init&projectType=送电工程项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="pre_engineering_data"){
		$("form:eq(0)").attr('action',"PreEngineeringDataServlet?op=verify&se=1&method=init&projectType=工程前期数据&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="home_broad_standard"){
		$("form:eq(0)").attr('action',"HomeBroadStandardServlet?op=verify&se=1&method=init&projectType=国内外规程规范及相关标准&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="company_technology_achievement"){
		$("form:eq(0)").attr('action',"CompanyTechnologyAchievementServlet?op=verify&se=1&method=init&projectType=公司科技成果&projectId="+$("input[name=name]").val());
	}
	else if($(".pageName").text()=="engineer_summary"){
		$("form:eq(0)").attr('action',"EngineeringSummaryServlet?op=verify&se=1&method=init&projectType=工程总结&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="contract_technology_protocol"){
		$("form:eq(0)").attr('action',"ContractTechnologyProtocolServlet?op=verify&se=1&method=init&projectType=合同及技术协议&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="device_vender_material"){
		$("form:eq(0)").attr('action',"DeviceVenderMaterialServlet?op=verify&se=1&method=init&projectType=设备及厂家资料&projectId="+$("input[name=device_name]").val());
	}
	else if($(".pageName").text()=="technology_essay"){
		$("form:eq(0)").attr('action',"TechnologyEssayServlet?op=verify&se=1&method=init&projectType=技术文献&projectId="+$("input[name=name]").val());
	}
	else if($(".pageName").text()=="coal_material"){
		$("form:eq(0)").attr('action',"CoalMaterialServlet?op=verify&se=1&method=init&projectType=煤质资料&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="technology"){
		$("form:eq(0)").attr('action',"TechnologyServlet?op=verify&se=1&method=init&projectType=技经&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="other"){
		$("form:eq(0)").attr('action',"OtherServlet?op=verify&se=1&method=init&projectType=其它&projectId="+$("input[name=expert_lecture]").val());
	}
	else if($(".pageName").text()=="project_expert"){
		$("form:eq(0)").attr('action',"ProjectExpertServlet?op=verify&se=1&method=init&projectType=工程专家&projectId="+$("input[name=identified_card]").val());
	}
	
}
function unpass(pageName){
	if($(".pageName").text()=="fuel_machine_project"){
		$("form:eq(0)").attr('action',"FuelMachineProjectServlet?op=verify&se=-1&method=init&projectType=燃机项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="fuel_coal_project"){
		$("form:eq(0)").attr('action',"FuelCoalProjectServlet?op=verify&se=-1&method=init&projectType=燃煤项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="photovoltaic_generation_project"){
		$("form:eq(0)").attr('action',"PhotovoltaicGenerationProjectServlet?op=verify&se=-1&method=init&projectType=光伏发电项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="biomass_rubbish_project"){
		$("form:eq(0)").attr('action',"BiomassRubbishProjectServlet?op=verify&se=-1&method=init&projectType=生物质、垃圾发电项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="power_transfer_engineering_project"){
		$("form:eq(0)").attr('action',"PowerTransferEngineeringProjectServlet?op=verify&se=-1&method=init&projectType=变电工程项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="power_deliver_project"){
		$("form:eq(0)").attr('action',"PowerDeliverProjectServlet?op=verify&se=-1&method=init&projectType=送电工程项目&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="pre_engineering_data"){
		$("form:eq(0)").attr('action',"PreEngineeringDataServlet?op=verify&se=-1&method=init&projectType=工程前期数据&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="home_broad_standard"){
		$("form:eq(0)").attr('action',"HomeBroadStandardServlet?op=verify&se=-1&method=init&projectType=国内外规程规范及相关标准&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="company_technology_achievement"){
		$("form:eq(0)").attr('action',"CompanyTechnologyAchievementServlet?op=verify&se=-1&method=init&projectType=公司科技成果&projectId="+$("input[name=name]").val());
	}
	else if($(".pageName").text()=="engineer_summary"){
		$("form:eq(0)").attr('action',"EngineeringSummaryServlet?op=verify&se=-1&method=init&projectType=工程总结&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="contract_technology_protocol"){
		$("form:eq(0)").attr('action',"ContractTechnologyProtocolServlet?op=verify&se=-1&method=init&projectType=合同及技术协议&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="device_vender_material"){
		$("form:eq(0)").attr('action',"DeviceVenderMaterialServlet?op=verify&se=-1&method=init&projectType=设备及厂家资料&projectId="+$("input[name=device_name]").val());
	}
	else if($(".pageName").text()=="technology_essay"){
		$("form:eq(0)").attr('action',"TechnologyEssayServlet?op=verify&se=-1&method=init&projectType=技术文献&projectId="+$("input[name=name]").val());
	}
	else if($(".pageName").text()=="coal_material"){
		$("form:eq(0)").attr('action',"CoalMaterialServlet?op=verify&se=-1&method=init&projectType=煤质资料&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="technology"){
		$("form:eq(0)").attr('action',"TechnologyServlet?op=verify&se=-1&method=init&projectType=技经&projectId="+$("input[name=pid]").val());
	}
	else if($(".pageName").text()=="other"){
		$("form:eq(0)").attr('action',"OtherServlet?op=verify&se=-1&method=init&projectType=其它&projectId="+$("input[name=expert_lecture]").val());
	}
	else if($(".pageName").text()=="project_expert"){
		$("form:eq(0)").attr('action',"ProjectExpertServlet?op=verify&se=-1&method=init&projectType=工程专家&projectId="+$("input[name=identified_card]").val());
	}
}
function save(){
	pidCheck();
	if(confirm("是否转化为保存记录？")){
		if($(".pageName").text()=="fuel_machine_project"){
			$("form:eq(0)").attr('action',"FuelMachineProjectServlet?op=save");
		}
		else if($(".pageName").text()=="fuel_coal_project"){
			$("form:eq(0)").attr('action',"FuelCoalProjectServlet?op=save");
		}
		else if($(".pageName").text()=="photovoltaic_generation_project"){
			$("form:eq(0)").attr('action',"PhotovoltaicGenerationProjectServlet?op=save");
		}
		else if($(".pageName").text()=="biomass_rubbish_project"){
			$("form:eq(0)").attr('action',"BiomassRubbishProjectServlet?op=save");
		}
		else if($(".pageName").text()=="power_transfer_engineering_project"){
			$("form:eq(0)").attr('action',"PowerTransferEngineeringProjectServlet?op=save");
		}
		else if($(".pageName").text()=="power_deliver_project"){
			$("form:eq(0)").attr('action',"PowerDeliverProjectServlet?op=save");
		}
		else if($(".pageName").text()=="pre_engineering_data"){
			$("form:eq(0)").attr('action',"PreEngineeringDataServlet?op=save");
		}
		else if($(".pageName").text()=="home_broad_standard"){
			$("form:eq(0)").attr('action',"HomeBroadStandardServlet?op=save");
		}
		else if($(".pageName").text()=="company_technology_achievement"){
			$("form:eq(0)").attr('action',"CompanyTechnologyAchievementServlet?op=save");
		}
		else if($(".pageName").text()=="engineer_summary"){
			$("form:eq(0)").attr('action',"EngineeringSummaryServlet?op=save");
		}
		else if($(".pageName").text()=="contract_technology_protocol"){
			$("form:eq(0)").attr('action',"ContractTechnologyProtocolServlet?op=save");
		}
		else if($(".pageName").text()=="device_vender_material"){
			$("form:eq(0)").attr('action',"DeviceVenderMaterialServlet?op=save");
		}
		else if($(".pageName").text()=="technology_essay"){
			$("form:eq(0)").attr('action',"TechnologyEssayServlet?op=save");
		}
		else if($(".pageName").text()=="coal_material"){
			$("form:eq(0)").attr('action',"CoalMaterialServlet?op=save");
		}
		else if($(".pageName").text()=="technology"){
			$("form:eq(0)").attr('action',"TechnologyServlet?op=save");
		}
		else if($(".pageName").text()=="other"){
			$("form:eq(0)").attr('action',"OtherServlet?op=save");
		}
		else if($(".pageName").text()=="project_expert"){
			$("form:eq(0)").attr('action',"ProjectExpertServlet?op=save");
		}
	}
}
function clearField(){
	$("input").val("");
	$("select").val("");
	$("textArea").val("");
}

function isDate(str){
	if(!/^(\d{4})\-(\d{1,2})\-(\d{1,2})$/.test(str)){
		return false;
	}
	var year=RegExp.$1-0;
	var month=RegExp.$2-1;
	var date=RegExp.$3-0;
	var obj=new Date(year,month,date);
	return (obj.getFullYear()==year&&obj.getMonth()==month&&obj.getDate()==date);
}

function compareDate(){
	if(isDate($("input[name=starttime]").val())==false){
		alert("开始时间格式不正确！请严格按照指定格式输入！");
		$("input[name=starttime]").focus();
		return false;
	}
	else if(isDate($("input[name=endtime]").val())==false){
		alert("结束时间格式不正确！请严格按照指定格式输入！");
		$("input[name=endtime]").focus();
		return false;
	}
	var startTime=$("input[name=starttime]").val();
	/*var arrA=startTime.split("/");
	var dateA=new Date(arrA[0]);*/
	var dateAT=startTime.getTime();
	var endTime=$("input[name=endtime]").val();
	/*var arrB=endTime.split("/");
	var dateB=new Date(arrB[0]);*/
	var dateBT=endTime.getTime();
	if(startTime==""||startTime==null){
		alert("请选择开始时间！");
		return false;
	}
	else if(endTime==""||endTime==null){
		alert("请选择截止时间！");
		return false;
	}
	else if(dateAT>dateBT){
		alert("开始时间不能大于结束时间！请重新选择！");
		return false;
	}
	return true;
}
function pidCheck(){
	if($(".pageName").text()=="other"){
		if($("input[name=expert_lecture]").val()==null||$("input[name=expert_lecture]").val()==""){
			alert("请输入专家讲座内容！");
			return false;
		}
	}
	else if($(".pageName").text()=="technology_essay"){
		if($("input[name=name]").val()==null||$("input[name=name]").val()==""){
			alert("请输入文献名称！");
			return false;
		}
	}
	else if($(".pageName").text()=="company_technology_achievement"){
		if($("input[name=name]").val()==null||$("input[name=name]").val()==""){
			alert("请输入科技成果名称！");
			return false;
		}
	}
	else if($(".pageName").text()=="device_vender_material"){
		if($("input[name=device_name]").val()==null||$("input[name=device_name]").val()==""){
			alert("请输入设备名称！");
			return false;
		}
	}
	else if($(".pageName").text()=="project_expert"){
		if(($("input[name=name]").val()==null||$("input[name=name]").val()=="")||($("input[name=identified_card]").val()==null||$("input[name=identified_card]").val()=="")){
			alert("请输入姓名和身份证号！");
			return false;
		}
	}
	else {
		if($("input[name=pid]").val()==null||$("input[name=pid]").val()==""){
			alert("请输入项目编号！");
			return false;
		}
	}
	if($(".actionDo").text()!='verify'){
		if($("input[name=verifier]").val()==null||$("input[name=verifier]").val()==""){
			alert("请选择审核人！");
			return false;
		}
	}
}
/*入库记录维护  获取pid*/
function getPid(){
	var table = $("select option:selected").val();
	window.location = "DataMaintenanceServlet?op=recordMaintenance&tableName="+table;
}

/*获取预留字段选项*/
function getPreservedField(){
	var url = "DataMaintenanceServlet?op=fieldMaintenance&ch=getField&tableName="+$('#filed_maintained_table_name option:selected').val();
	url = encodeURI(url);
	$.ajax({
		type:"post",//请求方式
		url:url,//发送请求地址
		data:{
		},
		//请求成功后的回调函数有两个参数
		success:function(data){
			$("#preserved_field_id").text("");
			$("#preserved_field_id").append(data);
		},
		error:function(){
			
		}
	});
}
/**/
function preFieldChoosed(){
	var url = "DataMaintenanceServlet?op=fieldMaintenance&ch=getNewName&tableName="+$('#filed_maintained_table_name option:selected').val()+"&oldName="+$('#preserved_field_id option:selected').val();
	url = encodeURI(url);
	$.ajax({
		type:"post",//请求方式
		url:url,//发送请求地址
		data:{
		},
		//请求成功后的回调函数有两个参数
		success:function(data){
			if(data=="NO"){
				$(".new_user_input_label:eq(2)").text("字段未启用：");
				$("input[name=preserved_field_used]").val($('#preserved_field_id option:selected').val());
				$(".maintenance_button:eq(0)").attr("onclick","");
				$(".maintenance_button:eq(1)").text("启用该字段");
				$(".maintenance_button:eq(1)").attr("onclick","useField()");
			}
			else{
				$(".new_user_input_label:eq(2)").text("字段已启用：");
				$("input[name=preserved_field_used]").val(data);
				$(".maintenance_button:eq(0)").attr("onclick","changeField()");
				$(".maintenance_button:eq(1)").text("不启用该字段");
				$(".maintenance_button:eq(1)").attr("onclick","unUseField()");
			}
		},
		error:function(){
			
		}
	});
}
function changeField(){
	var url = "DataMaintenanceServlet?op=fieldMaintenance&ch=changeField&tableName="+$('#filed_maintained_table_name').val()+"&oldName="+$('#preserved_field_id option:selected').val()+"&NewName="+$('input[name=preserved_field_used]').val();
	$.ajax({
		type:"post",//请求方式
		url:encodeURI(url),//发送请求地址
		data:{
		},
		success:function(data){
			$("input[name=preserved_field_used]").val(data);
			alert("替换成功！");
		},
		error:function(){
			alert("error");
		}
	});
	
}
function useField(){
	var url = "DataMaintenanceServlet?op=fieldMaintenance&ch=useField&tableName="+$('#filed_maintained_table_name').val()+"&NewName="+$('input[name=preserved_field_used]').val();
	$.ajax({
		type:"post",//请求方式
		url:encodeURI(url),//发送请求地址
		data:{
		},
		success:function(data){
			$("input[name=preserved_field_used]").val(data);
			alert("启用成功");
			$(".new_user_input_label:eq(2)").text("字段已启用：");
			$(".maintenance_button:eq(0)").attr("onclick","changeField()");
			$(".maintenance_button:eq(1)").text("不启用该字段");
			$(".maintenance_button:eq(1)").attr("onclick","unUseField()");
		},
		error:function(){
			alert("error");
		}
	});
}
function unUseField(){
	var url = "DataMaintenanceServlet?op=fieldMaintenance&ch=unUseField&tableName="+$('#filed_maintained_table_name').val()+"&NewName="+$('input[name=preserved_field_used]').val();
	$.ajax({
		type:"post",//请求方式
		url:encodeURI(url),//发送请求地址
		data:{
		},
		success:function(data){
			$("input[name=preserved_field_used]").val(data);
			alert("禁用成功");
			$(".new_user_input_label:eq(2)").text("字段未启用：");
			$(".maintenance_button:eq(0)").attr("onclick","");
			$(".maintenance_button:eq(1)").text("启用该字段");
			$(".maintenance_button:eq(1)").attr("onclick","useField()");
		},
		error:function(){
			alert("error");
		}
	});
}
/*跳转上传文件界面*/
function uploadFile(pageName){
	if($(".pageName").text()=="fuel_machine_project"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=fuel_machine_project&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=燃机项目&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入项目编号！");
		}
	}
	else if($(".pageName").text()=="fuel_coal_project"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=fuel_coal_project&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=燃煤项目&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入项目编号！");
		}
	}
	else if($(".pageName").text()=="photovoltaic_generation_project"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=photovoltaic_generation_project&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=光伏发电项目&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入项目编号！");
		}
	}

	else if($(".pageName").text()=="biomass_rubbish_project"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=biomass_rubbish_project&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=生物质、垃圾发电项目&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入项目编号！");
		}
	}

	else if($(".pageName").text()=="power_transfer_engineering_project"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=power_transfer_engineering_project&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=变电工程项目&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入项目编号！");
		}
	}

	else if($(".pageName").text()=="power_deliver_project"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=power_deliver_project&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=送电工程项目&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入项目编号！");
		}
	}

	else if($(".pageName").text()=="pre_engineering_data"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=pre_engineering_data&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=工程前期数据&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入序号！");
		}
	}

	else if($(".pageName").text()=="home_broad_standard"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=home_broad_standard&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=国内外规程规范及相关标准&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入标准编号！");
		}
	}

	else if($(".pageName").text()=="company_technology_achievement"){
		if($("input[name=name]").val()!=null||$("input[name=name]").val()!=""){
			var url = "CheckServlet?act=company_technology_achievement&pid="+$("input[name=name]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=公司科技成果&pid="+$("input[name=name]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入名称！");
		}
	}
	else if($(".pageName").text()=="engineer_summary"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=engineer_summary&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=工程总结&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入项目编号！");
		}
	}
	else if($(".pageName").text()=="contract_technology_protocol"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=contract_technology_protocol&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=合同及技术协议&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入项目编号！");
		}
	}
	else if($(".pageName").text()=="device_vender_material"){
		if($("input[name=device_name]").val()!=null||$("input[name=device_name]").val()!=""){
			var url = "CheckServlet?act=device_vender_material&pid="+$("input[name=device_name]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=设备及厂家资料&pid="+$("input[name=device_name]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入设备名称！");
		}
	}
	else if($(".pageName").text()=="technology_essay"){
		if($("input[name=name]").val()!=null||$("input[name=name]").val()!=""){
			var url = "CheckServlet?act=technology_essay&pid="+$("input[name=name]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=技术文献&pid="+$("input[name=name]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入名称！");
		}
	}
	else if($(".pageName").text()=="coal_material"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=coal_material&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=煤质资料&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入标准编号！");
		}
	}
	else if($(".pageName").text()=="technology"){
		if($("input[name=pid]").val()!=null||$("input[name=pid]").val()!=""){
			var url = "CheckServlet?act=technology&pid="+$("input[name=pid]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=技经&pid="+$("input[name=pid]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入项目名称或编号！");
		}
	}
	else if($(".pageName").text()=="other"){
		if($("input[name=expert_lecture]").val()!=null||$("input[name=expert_lecture]").val()!=""){
			var url = "CheckServlet?act=other&pid="+$("input[name=expert_lecture]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=其他&pid="+$("input[name=expert_lecture]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入专家讲座！");
		}
	}
	else if($(".pageName").text()=="project_expert"){
		if(($("input[name=name]").val()!=null||$("input[name=name]").val()!="")&&($("input[name=identified_card]").val()!=null||$("input[name=identified_card]").val()!="")){
			var url = "CheckServlet?act=project_expert&pid="+$("input[name=identified_card]").val();
			$.ajax({
				type:"post",//请求方式
				url:encodeURI(url),//发送请求地址
				data:{
				},
				success:function(data){
					if(data=="YES"){
						window.open("../HttpUploaderSQL/index.jsp?type=工程专家&pid="+$("input[name=identified_card]").val());
					}
					else{
						alert("您还没提交该项目，不能上传文件");
					}
				},
				error:function(){
					alert("error!");
				}
			});
		}
		else{
			alert("请输入姓名和身份证！");
		}
	}
}
/* 文件删除警告 */
function deleteAlert(url){
	if(confirm("确定要删除吗?")){
		window.location = encodeURI(url);
	}
	else{
		return false;
	}
}
/*url 编码处理*/
function urlEncode(uri){
	var url = encodeURI(uri);
	window.location = url;
}
function urlEncode2(uri){
	var url = encodeURI(uri);
	window.open(url);
}
/*ftp download*/
function FtpDownload(url){
	$.ajax({
		type:"post",//请求方式
		url:encodeURI(url),//发送请求地址
		data:{
		},
		success:function(data){
			window.open(decodeURI(data));
		},
		error:function(){
			alert("error!");
		}
	});
}
/*delete session*/
function logout(){
	$.ajax({
		type:"post",//请求方式
		url:encodeURI("UserServlet?act=logout"),//发送请求地址
		data:{
		},
		success:function(data){
			if(data=="OK"){
				window.location = "login.jsp";
			}
		},
		error:function(){
			alert("error!");
		}
	});
}
/*zip file download*/
function zipFileDownload(){
	var checkFiles = new Array();
	$("input[name=downloadFile]:checked").each(function(){
		checkFiles.push($(this).val());
	});
	if(isChecked(checkFiles)){
		checkFiles = toJSON(checkFiles);
		$.ajax({
			type:"post",
			url:"DownloadServlet?method=zipFilesDownload",
			data:{'files':checkFiles},
			success:function(data){
				if(data=="NO"){
					alert("FTP连接失败！");
				}
				else{
					window.open(data);
				}
			},
			error:function(){
				alert("FTP连接失败!");
			}
		});
	}
	else{
		alert("请选择要下载的内容！");
	}
}
function isChecked(checkFiles){
	var n = 0;
	for(var i=0;i<checkFiles.length;i++){
		if(checkFiles[i]!=null||checkFiles[i]!=""){
			n = 1;
		}
	}
	return n==1;
}
function toJSON(obj){
    var json = '({';
   $.each(obj, function(k,v){
     var q = typeof v == 'string' ? ~v.indexOf("'") ? '"' : "'" : '';
     if (typeof v == 'object')
        v = toJSON(v).slice(0,-1).substr(1);
     json+= k + ':'+ q + v + q + ',';
   });
    return json.slice(0,-1)+'})';
}

/* 无刷新页面动态查看文件 */
$(document).ready(function(){
	//查看下级目录
	function checkSubFiles(){
		$.ajax({
			type:"post",
			dataType:"json",
			url:"AjaxFileServlet?method=checkSubFiles",
			data:{
			},
			success:function getCallback(data){
				var myFileList=eval("("+data+")");
				refreshDiv(data);
			},
			error:function(){
				alert("没有下级目录了！");
			}
		});
	}
	
	//刷新页面
	function refreshDiv(myFileList){
		if(myFileList.length>1){
			
		}
	} 
})











