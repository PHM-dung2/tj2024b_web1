
// 주차 상태 확인
const parkingPrint = () => {
	// 1. DOM 객체 가져오기
	let parkform = document.querySelector('.parkform');
	// 2. fetch 통신
	let html = '';
	const option = { method : 'GET' }
	fetch( `/tj2024b_web1/day06/parking` , option )
		.then( r => r.json() )
		.then( data => {
			data.forEach( obj => {
				let parkingState = false;
				if( obj == null ) { parkingState = true; }
				
				if( parkingState ) { html += `<div> 불가능 </div>` }
				else{ html += `<div> 불가능 </div>`}
			}) // for end
			parkform.innerHTML = html;
		}) // then end
		.catch( e => { console.log(e); } )
	
} // f end