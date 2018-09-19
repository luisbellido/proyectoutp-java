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
const TITLE_MSG_ERROR="Error de Validaci&oacute;n";
const TITLE_MSG_OK="Mensaje del Sistema";

function formatGridIcon(val,row,index){
	return "<img src='"+iconsurl+(val?"aceptar.png":"cancelar.png")+"'/>" //;
}

function println(msg){
	console.log(msg);
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
					height: opts.maxHeight
				})
			}
			
			$(this).window('center');
		})
	}
});
