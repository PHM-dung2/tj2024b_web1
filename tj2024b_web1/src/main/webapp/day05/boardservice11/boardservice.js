
// 1. 게시물 등록
const boardWrite = ( ) => {
	// 1. HTML로부터 input dom 객체 가져오기
	let btitleInput = document.querySelector('.btitleInput');
	let bcontentInput = document.querySelector('.bcontentInput');
	let bwriterInput = document.querySelector('.bwriterInput');
	let bpwdInput = document.querySelector('.bpwdInput');
	// 2. 입력받은 값 가져오기
	let btitle = btitleInput.value;
	let bcontent = bcontentInput.value;
	let bwriter = bwriterInput.value;
	let bpwd = bpwdInput.value;
		// 2-1. 유효성검사
	if( !btitle){ alert('제목을 입력해주세요.'); return; }
	if( !bcontent ){ alert('내용을 입력해주세요.'); return; }
	if( !bwriter ){ alert('작성자를 입력해주세요.'); return; }
	if( !bpwd || bpwd.length < 4 ){ alert('비빌번호를 4~30자 사이로 입력해주세요.'); return; }
	// 3. 객체화
	let dataObj = { btitle : btitle , bcontent : bcontent , 
					bwriter : bwriter , bpwd : bpwd }
	// 4. fetch 통신
	let option = {
		method : 'POST',
		headers : { 'Content-Type' : "application/json" },
		body : JSON.stringify( dataObj )
	} // o end
	fetch( '/tj2024b_web1/day05/board2' , option )
		.then( r => r.json() )
		.then( data => {
			if( data == true ){
				alert('게시물 등록이 완료되었습니다.');
				location.href = "http://192.168.40.45:8080/tj2024b_web1/day05/boardservice11/boardindex.jsp";
			}else{ alert('게시물 등록 실패');}
			// 5. 게시판으로 이동
		}) // then end
		.catch( e => { console.log(e);})
} // f end

// 2. 게시물 전체 조회
const boardFindAll = ( ) => {
	// 1. 어디에
	let tbody = document.querySelector('.tbody')
	// 2. 무엇을
	let html = '';
	const option = { method : 'GET' }
	fetch( `/tj2024b_web1/day05/board2` , option )
		.then( r => r.json() )
		.then( data => {
			data.forEach( obj => {
				html += `<tr>
							<td> ${ obj.bno } </td>
							<td> <a href="/tj2024b_web1/day05/boardservice11/boardview.jsp?bno=${ obj.bno }" > ${ obj.btitle } </a> </td>
							<td> ${ obj.bwriter } </td>
							<td> ${ obj.bview } </td>
							<td> ${ obj.bdate } </td>
						</tr>`
			}) // for end
			tbody.innerHTML = html;
		}) // then end
		.catch( e => { console.log(e); } )
} // f end
boardFindAll();