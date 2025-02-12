console.log( 'login.js open' );

// [1] 로그인 요청 함수
const onLogIn = () => {
	
	// 1. HTML INPUT DOM 가져오기
	const midinput = document.querySelector('.midinput');
	console.log( midinput );
	const mpwdinput = document.querySelector('.mpwdinput');
	console.log( mpwdinput );
	// 2. INPUT 입력값 가져오기
	const mid = midinput.value;
	console.log( mid );
	const mpwd = mpwdinput.value;
	console.log( mpwd );
	// 3. 유효성 검사
	
	// 4. fetch
	// * 보낼 데이터 객체(JOSN)화
	const obj = { mid : mid , mpwd : mpwd }
	const option = { 
		method : "POST" ,
		headers : {'Content-Type' : 'application/json' } ,
		body : JSON.stringify( obj ) // - 요청할 http 자료 , 자료를 JSON 형식의 문자열 타입으로 변환
	} // o end
	fetch( '/tj2024b_web1/member/login' , option )
	.then( r => r.json() )
	.then( data => {
		if( data > 0 ){ 
			alert("로그인 성공"); onMsgSend( mid ); location.href="../index.jsp"; } // ../ 상위 폴더로 이동 뜻
		else{ alert('로그인 실패'); }
	}) // then end
	.catch( e => { console.log( e ); })
	
} // f end