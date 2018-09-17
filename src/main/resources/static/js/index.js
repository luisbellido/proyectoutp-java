
$('#loginForm').bootstrapValidator({
	feedbackIcons : {
		valid : 'glyphicon glyphicon-ok',
		invalid : 'glyphicon glyphicon-remove',
		validating : 'glyphicon glyphicon-refresh'
	},
	fields : {
		username : {
			validators : {
				notEmpty : {message : 'El nombre de usuario es requerido'},
				stringLength : {min : 2,max : 100,message : 'El nombre de usuario debe tener entre 2 y 100 caracteres'},
				regexp : {
					regexp : /^[a-zA-Z0-9_]+$/,
					message : 'El nombre de usuario solo puede contener números alfabéticos, números y guiones bajos'
				}
		}
	},
		passname : {
			validators : {
				notEmpty : {message : 'La contrase&ntilde;a es requerida'},
				stringLength : {min : 2,max : 100,message : 'La contrase&ntilde;a de usuario debe tener entre 2 y 100 caracteres'}
			}
		}
	}
})
/*on('success.form.bv', function(e) {
	 e.preventDefault();
	 // var valuesToSubmit = $(this).serialize();
     var $form = $(e.target);
     var bv = $form.data('bootstrapValidator');
     $.post($form.attr('action'), $form.serialize())
     .success( function(msg) { 
         alert('oJK');
      })
     .fail( function(xhr, status, error) {
         bv.updateStatus('email', 'INVALID', 'callback');
     })
     
});*/