console.log('header.js open');

const getLogInInfo = () => {
	const option = { method : "GET" } // get은 생략 가능
	
	let loginmenu = document.querySelector('.LogInMenu');
	
	let html = '';
	
	fetch( '/tj2024b_web1/member/info' , option )
	.then( r => r.json() )
	.then( data => {
		console.log(data); // 코드 변경후 서버가 자동 재실행이 되면 세션 초기화
		if( data == null ){	console.log('비로그인상태');
			html += `<li class="nav-item"><a class="nav-link" href="/tj2024b_web1/web/member/login.jsp">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="/tj2024b_web1/web/member/signup.jsp">회원가입</a></li>`
		}else{ console.log('로그인상태')
			html += `<li class="nav-item">
						<a class="header_id nav-link" href="#" > <img class="header_profile" src="/tj2024b_web1/upload/${ data.mimg }" /> ${ data.mid } 님 </a>
					</li>
					<li class="nav-item currentPoint"></li>
					<li class="nav-item"><a class="nav-link" href="/tj2024b_web1/web/member/info.jsp">마이페이지</a></li>
					<li class="nav-item"><a class="nav-link" href="#" onclick="onLogOut()">로그아웃</a></li>`
		} // if end
		loginmenu.innerHTML = html;
		currentPoint();
	}) // then end
	.catch( e => { console.log( e ); })
} // f end
getLogInInfo(); // JS가 열렸을 때 최초 1번 실행

// [2] 로그아웃 요청 함수
const onLogOut = () => {
	
	const option = { method : "DELETE" }
	fetch( '/tj2024b_web1/member/login' , option )
	.then( r => r.json() )
	.then( data => {
		if( data ){ alert('로그아웃합니다.'); location.href="/tj2024b_web1/web/member/login.jsp"; }
	})
	.catch( e => { console.log( e ); })
} // f end

// [3] 남은 포인트 조회
const currentPoint = () => {
	
	const currentPointInput = document.querySelector('.currentPoint');
	
	let option = { method : 'GET' }
	fetch( '/tj2024b_web1/web/point?type=current' , option )
		.then( r => r.text() )
		.then( data => {
			currentPointInput.innerHTML = `${ data } point`;
		}) // then end
		.catch( e => { console.log(e); })
} // f end

// [4] 클라이언트 소켓 만들기
const alarmSocket = new WebSocket('ws://localhost:8080/tj2024b_web1/alarmsocket');

// [5] 전송
const onMsgSend = ( mid ) => {
	alarmSocket.send( mid );
} // f end

// [6] 알람 출력
alarmSocket.onmessage = ( msgEvent ) => {
	console.log( alarmSocket );
	console.log('소켓 메세지 전송');
	console.log( msgEvent );
	console.log( msgEvent.data );
	
	// 1. 메세지 html에 출력
	//		1. 어디에
	const msgbox = document.querySelector('.msgbox');
	// 		2. 무엇을
	let html = '';
	html += `<div class="toast fade show" role="alert" aria-live="assertive" aria-atomic="true">
		       	<div class="toast-header">
		      		<svg class="bd-placeholder-img rounded me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#007aff"></rect></svg>
		       		<strong class="me-auto">tj2024b_web1</strong>
		       		<small class="text-body-secondary"></small>
		       		<button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
		       	</div>
			    <div class="toast-body"> 
					${ msgEvent.data } 님이 로그인하셨습니다.
				</div>
			</div>`;
	//		3. 출력
	msgbox.innerHTML = html;
}







