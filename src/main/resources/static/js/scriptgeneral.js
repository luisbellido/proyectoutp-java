class FormsProperty{
	constructor(idContent,url,title,width,height){
		this.idContent=idContent;
		this.url=url;
		this.title=title;
		this.width=width;
		this.height=height;
	}
}

const iconsurl="lib/jquery-easyui-1.6.2/themes/icons/";

function formatGridIcon(val,row,index){
	return "<img src='"+iconsurl+(val?"aceptar.png":"cancelar.png")+"'/>" //;
}

function loadFormClass(formDlg,onloadCallback){
	$(formDlg.idContent).dialog({
			closed:true,
			href:formDlg.url,
			inline:true,
			onLoad:onloadCallback(),
			maxWidth:formDlg.width,
			maxHeight:formDlg.height
	}).dialog('open').dialog('setTitle', formDlg.title).dialog('fluid');//.window('center');
}

/*function loadForm(idContent,url,title,onloadCallback){
	$(idContent).dialog({
			closed:true,
			href:url,
			inline:true,
			onLoad:onloadCallback(),
			maxWidth:400,
			maxHeight:400
	}).dialog('open').dialog('setTitle', title).dialog('fluid');//.window('center');
}*/
//loadForm('#dlgCorreo','correos/correoForm',"Agregar Nuevo Correo",function() {
/*$('#namearea').validatebox({
     required: true,
});
$('#frmArea').form('clear');*/
//  $('#btnSav').linkbutton('enable');
//$('#namearea').focus();
//});




$.extend($.fn.window.methods,{
	fluid: function(jq){
		if (!$._fluid){
			$._fluid = true;
			$(window).unbind('.fluid').bind('resize.fluid',function(){
				$('div.window').children('div.window-body').window('fluid');
			})
		}
		return jq.each(function(){
			var ww = $(window).width();
			var hh = $(window).height();
			var opts = $(this).window('options');
			if (ww < opts.maxWidth + 50){
				$(this).window('resize',{
					width: ww - 50,
					height: hh-50
				});
			} else {
				$(this).window('resize',{
					width:opts.maxWidth,
					height: hh-50
				})
			}
			$(this).window('center');
		})
	}
});
