const getJParamsShopping = () => {
	let ids = []; 
	let amounts = [];
	$("div.item-detail div.added").each((i,o) => {
		let amount = $(o).find(">span:last").text();
		if(parseInt(amount) > 0){
			ids.push(o.id);
			amounts.push(amount);
		}
	});
	return {ids: ids.join(), amounts: amounts.join()};
};

const gotoShoppinCar = () => {
	let jParams = getJParamsShopping();
	if(jParams.ids.trim().length === 0){
		alert("No ha agregado ningún libro. De clic en [Agregar] el libro y cantidad que desee.");
		return;
	}
	let jparamsStr = encodeURIComponent(JSON.stringify(jParams));
	window.location.href = `/book/shopping?jparams=${jparamsStr}`;
};

const addToShoppingCar = function(){
	let $itemDetail = $(this).closest("div");
	let amount = $itemDetail.find("input").val();
	$itemDetail.siblings(".added").find(">span:last").text(amount);
};

$( document ).ready(function() {
   document.getElementById('gotoShoppingCar').addEventListener("click", gotoShoppinCar, false);
   $("button[name=addToShoppingCar]").on("click", addToShoppingCar);
});