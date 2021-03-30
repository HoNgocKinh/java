/**
 * 
 */
 var defaultModalAddContent = undefined;
		
		$(document).ready(function() {

			// config Stock DataTable
			$("#stock-tb").DataTable({
				"pageLength" : 6
			});
			$("#product-tb").DataTable({
				"pageLength" : 6
			});
			
			// storage default content Modal add
			defaultModalAddContent = $(".modal-body .container").html();
			
			// config tooltip
			$('[data-toggle="tooltip"]').tooltip();
		});
		
		function dupplicateInput(e) {
		    let dupplicateRow = `<div class="row pt-1">
		    						<input type="hidden" class="product" />
		                            <div class="col-2 pr-0">
		                                <input type="text" class="form-control product" />
		                            </div>
		                            <div class="col pr-0">
		                                <input type="text" class="form-control product" />
		                            </div>
		                            <div class="col-2 pr-0">
		                                <input type="date" class="form-control product" onchange="getLastExpiredDate()"/>
		                            </div>
		                            <div class="col pr-0">
		                                <select class="form-control product">
		                                    <option value="FOOD">Food</option>
		                                    <option value="DRINK">Drink</option>
		                                </select>
		                            </div>
		                            <div class="col pr-0">
		                                <input type="text" class="form-control product" />
		                            </div>
		                            <div class="col pr-0">
		                                <input type="text" class="form-control product boughtPrice" onchange="addPrice('boughtPrice')"/>
		                            </div>
		                            <div class="col pr-0">
		                                <input type="text" class="form-control product sellPrice" onchange="addPrice('sellPrice')"/>
		                            </div>
		                            <div class="col p-0 d-flex justify-content-around pt-1">
		                            	<button class="btn btn-primary btn-sm text-light"
		                            		onclick="uploadProductImage(this)" disabled="disabled">
		                            		<i class="fas fa-images"></i>
		                            	</button>
		                            	<input type="file" class="d-none p-file" />
			                            <button type="button" class="btn btn-danger btn-sm"
											onclick="removeDupplicateInputs(this)">
											<i class="fa fa-trash"></i>
										</button>
		                            </div>
		                        </div>`; 
		    $("div.modal-body div.container").append(dupplicateRow);
		}
		function removeDupplicateInputs(ele) {
			ele.parentNode.parentNode.remove();
			addPrice('sellPrice');
			addPrice('boughtPrice');
		}
		
		function getLastExpiredDate() {
			
			let productsExp = $(`input[type="date"]`).not("#m_expAt").toArray().map(x => x.value);
			productsExp = productsExp.sort((a, b) => new Date(a) - new Date(b)); // sort asc
			$("#m_expAt").val(productsExp.slice(-1).toString());
		}
		function addPrice(id) {
			
			let price = $(`.${id}`).toArray().reduce((total, ele) => total + parseFloat(ele.value), 0);
			$(`#m_${id}`).val(price);
		}
		function addPackage(e) {
			
			let products = $(".product");
			var productsForm = [];
			// check empty field in products
			// check empty field in package
			// TODO...
			for (let i = 0; i < products.length; i += 8) {
				let productId = products[i].value;
				let productName = products[i+1].value;
				let quantity = products[i+2].value;
				let expiredAt = products[i+3].value;
				let type = products[i+4].value;
				let unit = products[i+5].value;
				let boughtPrice = products[i+6].value;
				let sellPrice = products[i+7].value;
				let image = "";
				productsForm.push({productId, productName, quantity, expiredAt, type, unit, boughtPrice, sellPrice, image});
			}
			let packageId = $("#m_id").val();
			let packageCode = $("#m_packageCode").val();
			let supplierId = $("#m_supplier").val();
			let status = $("#m_status").val();
			let expAt = $("#m_expAt").val();
			let boughtPrice = $("#m_boughtPrice").val();
			let sellPrice = $("#m_sellPrice").val();
			
			let packagez = {packageId, packageCode, expAt, boughtPrice, sellPrice, supplierId, status};
			
			sendAjaxRequest(packagez, productsForm);
		}
		function sendAjaxRequest(packagez, productsForm) {
			
			let bodyData = {
					"package": packagez,
					"products": productsForm
			};
			
			fetch(`${window.location.origin}/warehouse/add`, {
				method: "POST",
				body: JSON.stringify(bodyData)
			})
			.then(res => res.text())
			.then(res => {
				window.location.reload();
			});
		}
		
		
		function uploadProductImage(btnClicked) {
			btnClicked.nextElementSibling.click();
		}
		
		function setUpDefaultModal() {
			$(".modal-body .container").html(defaultModalAddContent);
		}
		
		function openEditableModal(jsonObjectStr) {
			
			let packagez = JSON.parse(jsonObjectStr);
			$("#m_id").val(packagez.id);
			$("#m_packageCode").val(packagez.code);
			$("#m_supplier").val(packagez.supplier.id);
			$("#m_status").val(packagez.status);
			$("#m_boughtPrice").val(packagez.boughtPrice);
			$("#m_sellPrice").val(packagez.sellPrice);
			
			let products = $(".products");
			products.empty();
			packagez.products.forEach((product, index) => {
				
				let productExpiredAt = new Date(product.expiredAt).toISOString().substring(0, 10);
				
				let productData = `<div class="row pt-1">
									 <input type="hidden" class="product" value="${product.id}"/>
				                     <div class="col-2 pr-0">
					                    <input type="text" class="form-control product" value="${product.name}"/>
					                 </div>
					                 <div class="col pr-0">
					                    <input type="text" class="form-control product" value="${product.quantity}"/>
					                 </div>
					                 <div class="col-2 pr-0">
					                    <input type="date" class="form-control product" onchange="getLastExpiredDate()" value="${productExpiredAt}"/>
					                 </div>
					                 <div class="col pr-0">
					                    <select class="form-control product type">
					                        <option value="FOOD">Food</option>
					                        <option value="DRINK">Drink</option>
					                    </select>
					                 </div>
					                 <div class="col pr-0">
					                    <input type="text" class="form-control product" value="${product.unit}"/>
					                 </div>
					                 <div class="col pr-0">
					                    <input type="text" class="form-control product boughtPrice" onchange="addPrice('boughtPrice')" value="${product.boughtPrice}"/>
					                 </div>
					                 <div class="col pr-0">
					                    <input type="text" class="form-control product sellPrice" onchange="addPrice('sellPrice')" value="${product.sellPrice}"/>
					                 </div>
					                 <div class="col p-0 d-flex justify-content-around pt-1">
					                	<button class="btn btn-primary btn-sm text-light"
					                		onclick="uploadProductImage(this)" disabled="disabled">
					                		<i class="fas fa-images"></i>
					                	</button>
					                	<input type="file" class="d-none p-file" />
					                    <button type="button" class="btn btn-danger btn-sm"
											onclick="removeDupplicateInputs(this)">
											<i class="fa fa-trash"></i>
										</button>
					                 </div>
					             </div>`;

				products.append(productData);
				$(".type").eq(index).val(product.type);
			});
			
			$("#m_submit").text("Update");
			$("#stock").modal({show: true});
		}
		