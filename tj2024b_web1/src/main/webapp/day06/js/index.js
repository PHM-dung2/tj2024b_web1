
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
			// 주차 데이터 배열에서 주차된 번호만 추출
		    const parkingArr = data.map(obj => obj.pno);
			
			// 20개 div 생성
			for( let i = 1 ; i <= 20 ; i++ ){
				// 주차여부 확인
				const isParking = parkingArr.includes(i);
				html += `<div class="parkingSpot ${ isParking ? 'full' : 'empty' }"> 
							${ isParking ? '불가능' : '주차구역 ' + i }
						</div> `
			} // for end
			
			// 20개 div 출력
			parkform.innerHTML = html;
		}) // then end
		.catch( e => { console.log(e); } )
	
} // f end