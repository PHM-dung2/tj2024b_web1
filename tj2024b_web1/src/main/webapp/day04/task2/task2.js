
// 1. 대기 명단 등록 함수
const waitWrite = () => {
	// 1. HTML롭터 input dom객체 가져오기
	let phoneInput = document.querySelector('.phoneInput');
	let countInput = document.querySelector('.countInput');
	// 2. 입력받은 값 가져오기
	let phone = phoneInput.value;
	let count = countInput.value
	// 3. 객체화
	let dataObj = { 'phone' : phone , 'count' : count };
	// 4. fetch 통신
	let option = {
		method : 'POST' ,
		headers : { 'Content-Type' : 'application/json' } ,
		body : JSON.stringify( dataObj )
	} // o end
	fetch( '/tj2024b_web1/day03/visit2' , option )
		.then( r => r.json() )
		.then( data => {
			if( data == true ){ alert("명단 등록 성공"); waitFindAll(); }
			else{ alert("명단 등록 실패"); }
		}) // then end 
		.catch( e => { console.log( e ); } )
} // f end

// 2. 대기 명단 전체 출력 함수
const waitFindAll = () => {
	
} // f end
waitFindAll();

// 3. 특정 대기명단 수정 함수
const waitUpdate = () => {
	
} // f end

// 4. 특정 대기명단 삭제 함수
const waitDelete = () => {
	
} // f end