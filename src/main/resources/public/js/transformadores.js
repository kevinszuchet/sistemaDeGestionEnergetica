var transformadores = {{ transformadores }};

$( document ).ready(function() {
	mapa = L.map('mapa', {
	    center: [-34.598313, -58.463745],
	    zoom: 11.2,  
	    minZoom: 4,
	    maxZoom:17,
	    zoomControl:true 
	});

	L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {attribution: ''}).addTo(mapa);

	transformadores.forEach(function(Transformador) {
		console.log(transformador);
		L.marker([-34.578422, -58.425744]).addTo(mapa).bindPopup(transformador.nombre + "<br/> Consumo: <b>" + transformador.consumo + "</b>")
	});


	var marker = L.marker([-34.578422, -58.425744]).addTo(mapa).bindPopup("Transformador de Palermo<br/> consumo:2344443");			
	var marker2 = L.marker([-34.619188, -58.443747]).addTo(mapa).bindPopup("Transformador de Caballito<br/> consumo:2788489");
	var marker3 = L.marker([-34.58712, -58.39754]).addTo(mapa).bindPopup("Transformador de Recoleta<br/> consumo:999879");
	
	var polygon = L.polygon([
			[-34.697878, -58.468897],
		    [-34.686919, -58.486813],
		    [-34.651905, -58.530758],
		    [-34.614052, -58.529385],
		    [-34.552432, -58.499172],
		    [-34.533202, -58.46484],
		    [-34.582965, -58.381756],
		    [-34.634075, -58.35159],
		    [-34.65924, -58.418313]
		],{
			color: 'red',
			fillColor: 'blue',
		    fillOpacity: 0.1,
		    radius: 500
		})/*.addTo(mapa).on('click', onMapClick);
	function onMapClick(e) {
	    alert("Latitud y Longitud: " + e.latlng);
	}*/
});

function onClick(e){
	var r = confirm("Ir a medrano?");
	if (r == true) {
		mapa.setView(new L.LatLng((-34.598494), (-58.420186)), parseInt(17));
	} else {
	    
	}
}