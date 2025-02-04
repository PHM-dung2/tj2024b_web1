console.log('info.js open');

// [1] 현재 로그인된 회원정보 요청 함수
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
	
} //  f end
getMyInfo();

// [2] 회원탈퇴
const onDelete = () => {
	
	// * alert : 알림참 , confirm : 확인/취소 알림창 , prompt : 입력상자 알림창
	let result = confirm('정말 탈퇴하시겠습니까?');
	if( !result ){}
	
	const option = { method : "DELETE"	}
	fetch( `/tj2024b_web1/member/info` , option )
		.then( r => r.json() )
		.then( data => {
			if( data ){ alert('회원탈퇴 성공'); location.href="/tj2024b_web1/web/index.jsp" }
			else{ alert('탈퇴 실패 : 관리자에게 문의') }
		}) // then end
		.catch( e => { console.log(e); })
} // f end

// [3] 회원수정 페이지로 이동
const onUpdate = () => {
	location.href="./update.jsp"; 
	// 게시판에서는 게시물번호가 세션 없으므로 ?bno=3 , 하지만 수정할 회원번호(로그인된 회원번호)가 세션에 있으므로 굳이 할 필요가 없다.
	// 현재 페이지와 이동할 페이지가 같은 폴더이면 지정 파일명 작성 , 만일 다른 폴더이면 프로젝트명부터 작성 , ./ : 현재폴더 , ../ : 이전폴더 상대참조 작성
	
} // f end







