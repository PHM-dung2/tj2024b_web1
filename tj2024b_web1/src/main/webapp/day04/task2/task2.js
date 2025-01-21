
// 1. 대기 명단 등록 함수
const waitWrite = () => {
	// 1. HTML롭터 input dom객체 가져오기
	let phoneInput = document.querySelector('.phoneInput');
	let countInput = document.querySelector('.countInput');
	// 2. 입력받은 값 가져오기
	let phone = phoneInput.value;
	let count = countInput.value;
		// 2-2. 유효성 검사
		if( !phone || !count ){ alert('모든 항목을 입력해주세요.'); return; }
	// 3. 객체화
	let dataObj = { 'phone' : phone , 'count' : count };
	// 4. fetch 통신
	let option = {
		method : 'POST' ,
		headers : { 'Content-Type' : 'application/json' } ,
		body : JSON.stringify( dataObj )
	} // o end
	fetch( '/tj2024b_web1/day03/waiting2' , option )
		.then( r => r.json() )
		.then( data => {
			if( data == true ){ alert("대기번호 : " + (num+1) ); waitFindAll(); }
			else{ alert("명단 등록 실패"); }
		}) // then end 
		.catch( e => { console.log( e ); } )
	// input 정보 초기화	
	phoneInput.value = '010-';	countInput.value = '';
} // f end

let num = numFunc();
// 2. 대기 명단 전체 출력 함수
const waitFindAll = () => {
	// 1. 어디에
	let tbody = document.querySelector('.tbody');
	// 2. 무엇을
	let html = '';
		const option = { method : 'GET' };
		fetch( `/tj2024b_web1/day03/waiting2` , option )
			.then( r => r.json() )
			.then( data => {
				data.forEach( obj => {
					html += `<tr>
								<td> ${ obj.num } </td>
								<td> ${ obj.phone } </td>
								<td> ${ obj.count } </td>
								<td>
									<button onclick="waitUpdate( ${ obj.num } )" type="button" > 수정 </button>
									<button onclick="waitDelete( ${ obj.num } )" type="button" > 삭제 </button>
								</td>
							</tr>`
					if( num < obj.num ){ 
						num = obj.num; 
						localStorage.setItem( 'num' , JSON.stringify( num ) );
					} // if end
				}) // for end
				// 3. 출력
				tbody.innerHTML = html;
			}) // then end
			.catch( e => { console.log(e); } )		
} // f end
waitFindAll();

// 3. 특정 대기명단 수정 함수
const waitUpdate = ( num ) => {
	let newPhone = prompt('수정할 전화번호 : ');
	let newCount = prompt('수정할 인원수 : ');
	// 유효성 검사
		if( !newPhone || !newCount ){ 
			alert('모든 항목을 입력해주세요.'); 
			return; 
		}
		
	// 유효성 검사
		if( !confirm('정말 수정하시겠습니까?') ){ return; }
		
	let dataObj = { 'num' : num , 'phone' : newPhone , 'count' : newCount };
	const option = {
		method : 'PUT' ,
		headers : { 'Content-Type' : 'application/json'} ,
		body : JSON.stringify( dataObj )
	} // o end
	fetch( `/tj2024b_web1/day03/waiting2` , option )
		.then( r => r.json() )
		.then( data => {
			if( data == true ){ alert('대기명단 수정 완료'); waitFindAll()  }
			else{ alert('대기명단 수정 실패') }
		}) // then end
		.catch( e => { console.log( e ); } )
} // f end

// 4. 특정 대기명단 삭제 함수
const waitDelete = ( num ) => {
	// 유효성 검사
	if( !confirm('정말 삭제하시겠습니까?') ){ return; }
	const option = { method : 'DELETE' }
	fetch( `/tj2024b_web1/day03/waiting2?num=${ num }` , option )
		.then( r => r.json() )
		.then( data => {
			if( data == true ){ alert('대기명단 삭제 완료'); waitFindAll(); }
			else{ alert('대기명단 삭제 실패') }
		}) // then end
		.catch( e => { console.log( e ); } )
} // f end

// 5. 대기 명단 번호 쿠키 함수
function numFunc(){
	let wNum = localStorage.getItem( 'num' );
	if( wNum == null ){ wNum = 0; }
	else{ wNum = JSON.parse( wNum ); }
	
	return Number( wNum );
} // f end	
