$(document).ready(function () {
	$('#dgAreas').datagrid({
		title: 'Control de Areas',
  	    toolbar: '#toolbar_table_area',
  	    rownumbers: true,fitColumns: true, singleSelect: true,pagination: true,
  	    method: 'post', url: 'areas/findAllAreas',
  	    loader: function(param, success, error){
  	    var opts = $(this).datagrid('options');
  	        	   if (!opts.url) return false;
  		           $.ajax({
  		        	   type: opts.method,url: opts.url,data: param,dataType: 'json',
  		        	   success: function(data){
  		        		   if (data.isError){
  		       					$.messager.alert(TITLE_MSG_OK,data.message, 'error');
  		       				} else {
  		       					success(data);				
  		       			   }
  		        	   }
  		           });
  	     },onDblClickRow: function (index,row) {
  	    	 $( "#btnEdi" ).click();
  	   	 }
  	});
	
	$("#btnNew").click(function() {
		$('#dlgArea').dialog({
			 href:'areas/areaForm',
			 onLoad:function(){
				 $('#frmArea').form('clear');
				 $('#btnSav').prop('disabled', false);
				 $('#namearea').textbox('textbox').focus();
			 }
		}).dialog('open').dialog('setTitle', "Agregar Nueva Area").dialog('fluid');
	});
	
	$("#btnEdi").click(function() {
		 $("#btnSav").prop('disabled', true);
		   var row = $('#dgAreas').datagrid('getSelected');
		   if (row){
			   $('#dlgArea').dialog({
					 href:'areas/areaForm?idarea='+row.id,
					 onLoad:function(){
						 $('#btnSav').prop('disabled', false);
						 $('#namearea').textbox('textbox').focus();
					 }
			   }).dialog('open').dialog('setTitle', "Editar Area").dialog('fluid');
			   
		   }else{
			   $.messager.alert(TITLE_MSG_OK, "Seleccione una fila", 'warning');
		   }
	});
	
	$("#btnSav").click(function() {
	    $("#btnSav").prop('disabled', true);
	    
	    $('#frmArea').form('submit',{
	    	url:$(this).attr('action'),
			onSubmit: function(param){
				param.statusemail = true;
				var f = this;var opts = $.data(this, 'form').options;
            	if($(this).form('validate') == false){$('#btnSav').prop('disabled', false);return false;}
            	var onSubmit = opts.onSubmit;opts.onSubmit = function(){};
            	$(f).form('submit');opts.onSubmit = onSubmit;
            	return false;
			},
			success: function(result){
				var result = eval('('+result+')');
				if (result.errorMsg){
					var msgBody="";
					if(result.fieldValue){
						msgbody="<div class='messager-icon messager-warning'></div><div>"+"Del valor <b>"+result.fieldValue+"</b> ingresado<br><br>"+result.errorMsg+"</div>";
					}else{
						msgbody="<div class='messager-icon messager-error'></div><div>"+result.errorMsg+"</div>";
					}
					$.messager.show({
						iconCls:'icon-cancel', title: TITLE_MSG_ERROR,showType:'show',
						msg: msgbody,
				        style:{
				            left:'',bottom:'',right:0,
				            top:document.body.scrollTop+document.documentElement.scrollTop
				        },onClose: function(){
				        	$('#btnSav').prop('disabled', false);
				        }
					});
			  }else{
				  $.messager.alert(TITLE_MSG_OK, result.okMsg,"info",function(){
					  $('#dlgArea').dialog('close');
					  $('#dgAreas').datagrid('reload');
				  });
			  }
				
			}
	    });
	    
	});
	
	$("#btnDet").click(function() {
		   var row = $('#dgAreas').datagrid('getSelected');
		   if (row){
			   $('#dlgAreaVer').dialog({
					closed:true,
					href:'areas/areaDetails/'+row.id,
			   }).dialog('open').dialog('setTitle', "Detalle Area").dialog('fluid').window('center');
		   }else{
			   $.messager.alert(TITLE_MSG_OK, "Seleccione una fila", 'warning');
		   }
	 });
	
	
});