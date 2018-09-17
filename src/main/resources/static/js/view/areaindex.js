$(document).ready(function () {
	
	$('#dgAreas').datagrid({
		title: 'Control de Areas',
  	    toolbar: '#toolbar',
  	    rownumbers: true,fitColumns: true, singleSelect: true,pagination: true,
  	    method: 'post', url: 'areas/findAllAreas',
  	    loader: function(param, success, error){
  	    var opts = $(this).datagrid('options');
  	        	   if (!opts.url) return false;
  		           $.ajax({
  		        	   type: opts.method,url: opts.url,data: param,dataType: 'json',
  		        	   success: function(data){
  		        		   if (data.isError){
  		       					$.messager.alert("Mensaje del Sistema",data.message, 'error');
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
});