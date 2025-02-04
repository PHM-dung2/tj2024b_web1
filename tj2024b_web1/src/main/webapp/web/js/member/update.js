console.log('update.js open');

// [1] 대부분 수정은 기존의 데이터를 먼저 보여줘야한다.
const getMyInfo = () => {
	
	// fetch 옵션
	const option = { method : 'GET' }
	// fetch 실행
	fetch( '/tj2024b_web1/member/info' , option )
		.then( r => r.json() )
		.then( data => {
			if( data != null ){ // 로그인 상태이면
				// 특정한 dom에 정보 대입하기
				document.querySelector(".mid").value = data.mid;
				document.querySelector(".mname").value = data.mname;
				document.querySelector(".mphone").value = data.mphone;
				// img 마크업에 이미지 경로 대입하는 방법 .src 속성 이용
				document.querySelector(".mimg").src = `/tj2024b_web1/upload/${ data.mimg }`;
			} // if end
		}) // then end
		.catch( e => { console.log(e); })
	
} // f end
getMyInfo();

// [2] 수정 버튼을 클릭했을 때
const onUpdate = () => {
	// * 입력받은 자료/값 가져오기
	const mpwd = document.querySelector('.mpwd').value;
	const mname = document.querySelector('.mname').value;
	const mphone = document.querySelector('.mphone').value;
	// * 객체화
	const obj = { mpwd : mpwd , mname : mname , mphone : mphone }
	
	const option = {
		method : 'PUT' ,
		headers : { 'Content-Type' : 'application/json' } ,
		body : JSON.stringify( obj )
	}
	fetch( `/tj2024b_web1/member/info` , option )
		.then( r => r.json() )
		.then( data => {
			if( data ){ alert('회원정보 수정 완료'); location.href="info.jsp" }
			else{ alert('회원정보 수정 실패 : 관리자에게 문의') }
		}) // then end
		.catch( e => { console.log(e); })
} // f end



