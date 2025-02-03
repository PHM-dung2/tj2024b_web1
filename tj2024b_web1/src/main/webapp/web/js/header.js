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
						<a class="nav-link" href="#" > <img class="header_profile" src="" /> ${ data.mid } 님 </a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#" onclick="onLogOut()">로그아웃</a></li>`
		} // if end
		loginmenu.innerHTML = html;
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
		if( data ){ alert('로그아웃합니다.'); location.href="member/login.jsp"; }
	})
	.catch( e => { console.log( e ); })
} // f end






