const check = (event) => {
			
	console.log(event.keyCode);
	if (event.keyCode == 101 || event.keyCode == 69 || event.keyCode == 43 || event.keyCode == 45 || event.keyCode == 46)
		event.returnValue = false;
}

const openModal = () => {
	$("#myModal").modal("show");
}
$(document).ready(function() {
	$("#table").DataTable({
		"pageLength" : 6
	})
})

const orderRoom = (event) => {
	
	$("#phone").attr('type', 'text');
}

const tagging = (event) => {
	
	let quanlity = $("#quanlity").val();
	let food = $("#food").val();
	
	let foodId = food.split("_")[0];
	let foodName = food.split("_")[1];
	
	let roomName = $("#roomName").val();
	
	let tag = `<li class="list-group-item">
			<button class="btn btn-outline-info" type="button">
	            ${foodName}
	            <span class="badge badge-info">${quanlity}</span>
	            <span class="badge badge-pill badge-dark ml-1">
	            	<a style="text-decoration: none; color: white" onclick="removeObject(this)">X</a>
	            </span>
	        </button>
        </li>`;
	
	$(".list-group").append(tag);
	$("#listFood").val( $("#listFood").val() + `${foodId}-${quanlity};`);
}

const removeObject = (aTag) => {
	
	aTag.parentNode.parentNode.parentNode.remove();
}