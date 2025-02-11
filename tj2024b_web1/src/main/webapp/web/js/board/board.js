console.log('board.js open');

// [1] 현재 게시판의 cno 구하기
// /tj2024b_web1/web/board/board.jsp?cno=1
// /tj2024b_web1/web/board/board.jsp?cno=2
// /tj2024b_web1/web/board/board.jsp?cno=3
// - URL 상의 쿼리스트링 매개변수 : new URL( location.href ).searchParams
// - 
 	console.log( new URL( location.href ).searchParams )
 	console.log( new URL( location.href ).searchParams.get("cno") )

// [2] 지정한 카테고리별 게시물 조회 요청 + 페이징 처리
const findAll = () => {
	const cno = new URL( location.href ).searchParams.get( "cno" );
	// * 현재 페이지번호 찾기 = 현재 URL 경로상
	let page = new URL( location.href ).searchParams.get( "page" );
	if( page == null ){ page = 1; } // 만약에 page가 없으면 1페이지 설정
	const option = { method : "GET" }
	fetch( `/tj2024b_web1/board?cno=${ cno }&page=${ page }` , option )
		.then( r => r.json() )
		.then( response => {
			console.log(response);
			
			const boardlist = document.querySelector('.boardlist > tbody');
			let html = '';
			
			let boardList = response.data;
			boardList.forEach( (board) => {
				
				html += `<tr>
							<td> ${ board.bno } </td>
							<td><a href="view.jsp?bno=${ board.bno }"> ${ board.btitle } </a></td>
							<td> ${ board.mid } </td>
							<td> ${ board.bdate } </td>
							<td> ${ board.bview } </td>
						</tr>`;
				
			}) // for end
			boardlist.innerHTML = html;
			getpageBtn(cno, response);
		}) // then end
		.catch( e => { console.log(e); })
} // f end
findAll();// [2] 지정한 카테고리별 게시물 조회 요청

// [3] 페이지 버튼 생성 함수
const getpageBtn = ( cno, response ) => {
	
	page = parseInt(response.page);
	// 1. 어디에
	const pagebtnbox = document.querySelector('.pagebtnbox');
	// 2. 무엇을
	let html = '';
		// (1) 이전 버튼, 만약에 현재페이지가 1 이하 1로 고정 , 아니면 -1
		html += `<li class="page-item">
					<a class="page-link" href="board.jsp?cno=${ cno }&page=${ page <= 1 ? 1 : page-1 }">
						이전
					</a>
				</li>`;
	// * 1부터 10까지 버튼 만들기. // 최대페이지 , 현재페이지의 시작버튼 번호 , 현재펭지의 끝버튼 번호 
	// * startbtn부터 endbtn까지 버튼 만들기
	// for( let i = 1 ; i <= 5 ; i++ ){
	for( let i = response.startbtn ; i <= response.endbtn ; i++ ){
		html += `<li class="page-item">
					<a class="page-link ${ page == i ? 'active' : '' }" href="board.jsp?cno=${ cno }&page=${ i }">
						${ i }
					</a>
				</li>`;
	} // for end
		//(2) 다음 버튼 , 만약에 현재페이지가 마지막페이지( 전체페이지수 )이면 마지막페이지 고정
		html += `<li class="page-item">
					<a class="page-link" href="board.jsp?cno=${ cno }&page=${ page >= response.totalpage? page : page+1 }">
						다음
					</a>
				</li>`;
		
	// 3. 출력
	pagebtnbox.innerHTML = html;
	
} // f end

/*const findAll = () => {
	
	// 1. 현재 페이지의 카테고리 구하기
	const cno = new URL( location.href ).searchParams.get( "cno" );
	// 2. fetch option
	const option = { method : "GET" }
	// 3. fetch , querystring url?매개변수명=값
	fetch( `/tj2024b_web1/board?cno=${ cno }` , option )
		.then( r => r.json() )
		.then( data => {
			console.log(data);
			
			// 4. 출력할 위치의 DOM 객체 반환
			const boardlist = document.querySelector('.boardlist > tbody');
			// 5. 출력할 내용을 담을 변수 선언
			let html = '';
			// 6. 서블릿으로부터 응답받은 자료들을
			data.forEach( (board) => {
				
				// 7. 게시물 하나씩 html 테이블의 행으로 표현하기
				html += `<tr>
							<td> ${ board.bno } </td>
							<td><a href="view.jsp?bno=${ board.bno }"> ${ board.btitle } </a></td>
							<td> ${ board.mid } </td>
							<td> ${ board.bdate } </td>
							<td> ${ board.bview } </td>
						</tr>`
				
			}) // for end
			// 8. 반복문 종료 표현할 html 출력
			boardlist.innerHTML = html;
		}) // then end
		.catch( e => { console.log(e); })
} // f end
findAll();*/

