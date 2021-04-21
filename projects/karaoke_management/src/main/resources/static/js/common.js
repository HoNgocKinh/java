
function openModal(id, objectStr, actionName, setUpDefault = false) {
		
	if (setUpDefault) {
		// implements at each screen. ex: warehouse/index.html
		setUpDefaultModal();
	}
	
	if (!!objectStr) {
		let object = JSON.parse(objectStr);
		Object.keys(object).forEach(k => {
			console.log(object[k]);
			$(`#m_${k}`).val(object[k]);
		});
	}
	
	$("#m_submit").val(actionName);
	$(`#${id}`).modal({show: true});
}

function showModalNotification(code, message) {
	const statusCode = {
		SUCCESS: 200
	};
	
	let notifyElement = "#notification";
	let modalHeaderClass = ".modal-header";
	let modalBodyMessage = ".modal-body-message";
	
	if (code == statusCode.SUCCESS) {
		$(notifyElement).find(modalHeaderClass).removeClass("alert-danger").addClass("alert-success");
	}
	else {
		$(notifyElement).find(modalHeaderClass).removeClass("alert-success").addClass("alert-danger");
	}
	$(modalBodyMessage).html(message);
	$("#notification").modal({show: true});
}
		
function confirmModal(message, key, methodURL) {
	
	let isConfirmDelete = confirm(message);
	if (isConfirmDelete) {
		fetch(window.location.origin + `/${methodURL}/${key}`, {
			method: "POST",
		})
		.then(res => res.text())
		.then(res => window.location.reload());
	}
}

