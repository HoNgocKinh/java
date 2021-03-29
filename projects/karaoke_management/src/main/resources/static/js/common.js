
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

function confirmModal(message, key, methodURL) {
	
	let isConfirmDelete = confirm(message);
	if (isConfirmDelete) {
		fetch(window.location.href + `/${methodURL}/${key}`, {
			method: "POST",
		})
		.then(res => res.text())
		.then(res => window.location.reload());
	}
}

