
//	1. 등록 함수 , 실행조건 : 등록버튼 클릭했을때
const visitWrite = ( ) => {
	// 1. HTML으로부터 input dom객체 가져오기
		// - documentl.querySelector(선택자) : 선택자 마크업을 객체로 반환함수
	let contentInput = document.querySelector('.contentInput');
	let ageInput = document.querySelector('.ageInput');
	// 2. 입력받은 값 가져오기
	// - .value : 마크업의 value 속성
	let content = contentInput.value;
	let age = ageInput.value;		
	// 3. 객체화
	// - { 속성명 : 값 , 속성명 : 값 }
	let dataObj = { 'content' : content , 'age' : age }
	// 4. fetch 통신
	let option = {
		method : 'POST' ,	// HTTP METHOD 방법 선택
		headers : { 'Content-Type' : 'application/json' } ,	// HTTP 요청 HEADERS CONTENT - TYPE
		body : JSON.stringify( dataObj ) // 본문에 보낼 자료를 문자열타입으로 변환
	} // o end
	fetch( `/tj2024b_web1/day03/visit2` , option )
		.then( r => r.json() ) // - 응답받은 body 자료를 json 타입으로 변환
		.then( data => { // - 변환된 body 자료
			// 5. 결과에 따른 화면 구현
			 if( data == true ){ alert('등록성공'); visitFindAll(); } // 만약에 받은 자료가 ture이면 성공
			 else{ alert('등록실패'); }
		 } ) // then2 end
		.catch( e => {  console.log(e); } )
	
	// 5. 결과에 따른 화면구성
	
} // f end

//	2. 전체 조회 함수 , 실행조건 : 1.JS열릴때 2.등록/수정/삭제 성골했을때
const visitFindAll = ( ) => {
	// 1. 어디에 , tbody
	let tbody = document.querySelector('tbody')
	// 2. 무엇을 , fetch로부터 받은 
	let html = '';
		// 2-1 fetch 이용한 서블릿에게 자료를 HTTP GET METHOD  요청
		const option = { method : 'GET' }
		fetch( `/tj2024b_web1/day03/visit2` , option )
			.then( r => r.json() )
			.then( data => {
				// 방법1 : for( int i = 0 ; i < data.length ; i++ ){}
				// 방법2 : data.forEach( obj => { } )
				data.forEach( obj => {
					html += `<tr> 
								<td> ${ obj.num } </td>
								<td> ${ obj.content } </td>
								<td> ${ obj.age } </td>
								<td> 
									<button onclick="visitUpdate( ${ obj.num } )" > 수정 </button>	
									<button onclick="visitDelete( ${ obj.num } )" > 삭제 </button>	
								</td>
							</tr>`
				} ) // for end
				// 3. 출력 // .innerHTML : 지정한 마크업에 html 문자열 대입하는 속성
				tbody.innerHTML = html;	
			} ) // then2 end
			.catch( e => { console.log(e); } ) // 통신 응답 오류/실패시
		
} // f end

visitFindAll(); // 1. JS 열릴때

//	3. 수정함수
const visitUpdate = ( num ) => {
	// 1. 수정할 식별자(num)
	// 2. 수정할 내용 content/age
	let newContent = prompt("수정할 content : ");
	let newAge = prompt("수정할 age : ");
	let dataObj = { 'num' : num , 'content' : newContent , 'age' : newAge }
	const option = { 
		method : 'PUT' ,	
		headers : { 'Content-Type' : 'application/json' } ,
		body : JSON.stringify( dataObj )
	} 
	fetch( `/tj2024b_web1/day03/visit2` , option )
		.then( r => r.json() )
		.then( data  => { 
			if( data == true ){	alert('수정 완료'); visitFindAll(); }
			else { alert('수정 실패') }
		} ) // then end
		.catch( e => { console.log( e ); } )
} // f end

// 	4. 삭제함수
const visitDelete = ( num ) => {
	// 1. 삭제할 식별자(num)
	// 2. fetch 이용한 서블릿에게 HTTP delete METHOD 처리 요청
	const option = { method : 'DELETE' }
	fetch( `/tj2024b_web1/day03/visit2?num=${ num }` , option )
		.then( r => r.json() ) // 응답 결과를 json타입으로 변환
		.then( data => { 
			if( data == true) { alert('삭제성공'); visitFindAll(); } // 만약에 응답이 true이면
			else{ alert('삭제실패'); }
		}) // then end
		.catch( e => { console.log( e ); })
	
} // f end
