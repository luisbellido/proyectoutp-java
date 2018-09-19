$(document).ready(function () {
		
	$('#dgCorreo').datagrid({
			title: 'Control de Correos',
  	        toolbar: '#toolbar_table_correo',
  	        rownumbers: true,fitColumns: true, singleSelect: true,pagination: true,
  	        method: 'post', url: 'correos/getEmailAddresses',
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
  	        },
  	        onDblClickRow: function (index,row) {
  	        	$( "#btnEdi" ).click();
  	   	    }
  		});
		
		$("#btnNew").click(function() {
			$('#dlgCorreo').dialog({
				 href:'correos/correoForm',
				 onLoad:function(){
					 $('#frmCorreo').form('clear');
					 $('#btnSav').prop('disabled', false);
					 $('#emaildata').textbox('textbox').focus();
				 }
			}).dialog('open').dialog('setTitle', "Agregar Nuevo Correo").dialog('fluid').window('center');
		});
		
		$("#btnEdi").click(function() {
			 $("#btnSav").prop('disabled', true);
			   var row = $('#dgCorreo').datagrid('getSelected');
			   if (row){
				   $('#dlgCorreo').dialog({
						 href:'correos/correoForm?idcorreo='+row.id,
						 onLoad:function(){
							 $('#btnSav').prop('disabled', false);
							 $('#emaildata').textbox('textbox').focus();
						 }
				   }).dialog('open').dialog('setTitle', "Editar Correo").dialog('fluid').window('center');
				   
			   }else{
				   $.messager.alert(TITLE_MSG_OK, "Seleccione una fila", 'warning');
			   }
		});
		
		$("#btnSav").click(function() {
		    $("#btnSav").prop('disabled', true);
		    
		    $('#frmCorreo').form('submit',{
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
						  $('#dlgCorreo').dialog('close');
						  $('#dgCorreo').datagrid('reload');
					  });
				  }
					
				}
		    });
		    
		});
		
		$("#btnDet").click(function() {
			   var row = $('#dgCorreo').datagrid('getSelected');
			   if (row){
				   $('#dlgCorreoVer').dialog({
						closed:true,
						href:'correos/correosDetails/'+row.id,
				   }).dialog('open').dialog('setTitle', "Detalle Correo").dialog('fluid').window('center');
			   }else{
				   $.messager.alert(TITLE_MSG_OK, "Seleccione una fila", 'warning');
			   }
		 });
		
});

//$('#statusemail').val()
//$('#xstatusemail').checkbox({checked: true});
	//$('#emaildata').textbox('clear').textbox('textbox').focus();
