const getJAmountsShopping = () => {
	let ids = []; 
	let amounts = [];
	$("table>tbody>tr td>input").each((i,o) => {
		let amount = $(o).val();
		if(parseInt(amount) > 0){
			ids.push($(o).parent().attr("id"));
			amounts.push(amount);
		}
	});
	return {ids: ids.join(), amounts: amounts.join()};
};

const deleteRow = function(){
	$(this).closest("tr").remove();
	updateTotals();
};

const validateRows = () => $("table>tbody>tr").length > 0;

const confirmShopping = () => {
	if(!validateRows()){
		alert("No hay libros en el carrito de compras. Volveremos a la listade selección");
		window.location.href = "/book/list";
		return;
	}
	if(!confirm("Está seguro de realizar la compra")){
		return;
	}
	let jParams = getJAmountsShopping();
	if(jParams.ids.trim().length === 0){
		alert("No ha ingresado libros para comprar. Por favor ingrese cantidades mayores a cero (0).");
		return;
	}
	alert("Hemos recibido so solicitud y será procesada por nuestros agentes. Gracias por su compra.")
	let jparamsStr = encodeURIComponent(JSON.stringify(jParams));
	window.location.href = `/shopping/save?jparams=${jparamsStr}`;
	
};

const updateTotals = () => {
	let $inputs = $("table>tbody>tr td>input");
	if($inputs.length === 0){
		$(".total-footer>span:last").text("0");
		return;
	}
	let total = 0;
	$inputs.each(function(i,o){
		let amount = $(o).val();
		let price = $(o).closest("tr").find(".price").text();
		let partialTotal = parseInt(amount)*parseFloat(price);
		$(o).closest("tr").find(".partial-total").text(partialTotal);
		total += partialTotal;
	});
	$(".total-footer>span:last").text(total);
};

const deleteAllRows = () => {
	$("table>tbody>tr").remove();
	updateTotals();
};

const cancelShopping = () => {
	if(confirm("Seguro desea cancelar la compra")){
		deleteAllRows();
		alert("Su compra se ha cancelado");
	}
};

$( document ).ready(function() {
	$("table>tbody>tr td>input").on("change", updateTotals);	
	$(".delete > span").on("click", deleteRow);
	$("#cancelShopping").on("click", cancelShopping);
	$("#confirmShopping").on("click", confirmShopping);
});