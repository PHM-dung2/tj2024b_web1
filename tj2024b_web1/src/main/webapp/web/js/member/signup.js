console.log("signup.js.open");

// [1] 회원가입 요청 함수
const onSignUp = () => {
	
	// 1. form을 한번에 가져오기 application/json ---> multipart/form-data( 첨부파일 )
		// * form-data로 전송할 경우에는 속성명들을 'name' 속성으로 식별한다.
	const signupform = document.querySelector('#signupform'); // 폼 전체를 가져오기
		console.log( signupform );
	// 2. Fetch 이용한 multipart/form-data를 전송하는 방법
		// (1) 전송할 폼을 바이트(바이너리) 데이터로 변환 , FromData 클래스 , new FormData( 폼DOM );
	const signupformData = new FormData( signupform );
			// signupformData.append( "속성명" , "값" ); // 만일 html 폼에 없는 데이터를 폼데이터에 추가하는 방법
		// (2) fetch 옵션 , content-type 생략하면 자동으로 'multipart/form-data' 적용된다.
	const option = {
		method : "POST" ,
		// headers : { 'Content-Type : '' } , // 생략한다.
		body : signupformData // JSON.stringify() : 폼전송은 json 형식이 아니므로 생략한다.
	}
		// (3) fetch 요청과 응답
	fetch( '/tj2024b_web1/member/signup' , option )
		.then( r => r.json() ) // 응답 자료를 'application/json' 타입으로 변환
		.then( data => {
			if( data ){ alert('회원가입 성공'); location.href="/tj2024b_web1/web/member/login.jsp" } // 회원가입 성공시 메시지 후 로그인페이지 이동
			else{ alert('회원가입 실패'); } 
		}) // 응답 자료
		.catch( e => { console.log(e); }) // fetch 통신 간 오류 발생시
	
} // f end