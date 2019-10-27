document.addEventListener("DOMContentLoaded", function() {
	let jparams = {};
	const gotoShoppinCar = () => {
		let jparamsStr = JSON.stringify(jparams)
		window.location.href = `/book/shopping?jparams=${jparamsStr}`;
	};
	
	const addToShoppingCar = function(){
		jparams["id"] = this.closest("div").id;
		jparams["amount"] = this.querySelector("input").value;
		console.log(jparams);
	};
	
   document.getElementById('gotoShoppingCar').addEventListener("click", gotoShoppinCar, false);
   document.getElementsByName("addToShoppingCar").addEventListener("click", addToShoppingCar, false);
});