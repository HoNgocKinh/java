$(document).ready(function() {
			
	// config DataTable
	$("#table").DataTable({
		"columnDefs": [
	    	{ "width": "200px", "targets": 1 },
	    	{ "width": "250px", "targets": 3 }
	  	],
		"pageLength" : 6
	});
	
	// config tooltip
	$('[data-toggle="tooltip"]').tooltip();
})

function addSupplier(event) {
	
	let id = $("#m_id").val();
	let name = $("#m_name").val();
	let phone = $("#m_phone").val();
	let address = $("#m_address").val();
	
	let supplier = {id, name, phone, address};
	
	sendAjaxAddRequest(supplier);
}

function sendAjaxAddRequest(supplier) {
	
	let bodyData = {
			"supplier": supplier
	};
	
	fetch(`${window.location.origin}/suppliers/add`, {
		method: "POST",
		body: JSON.stringify(bodyData),
	})
	.then(res => res.text())
	.then(res => window.location.reload());
}