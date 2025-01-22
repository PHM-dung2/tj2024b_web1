
// bno 가져오기
const findBno = ( ) => {
	const url = new URL( location.href ).searchParams;
	let bno = url.get('bno');
	return bno;
} // f end

// 페이지 이동함수
const hrefPage = ( str ) => {
	location.href = `/tj2024b_web1/day05/boardservice11/board${ str }.jsp?bno=${ findBno() }`; 
} // f end

let bpwdState = null;
// 3. 게시물 개별 조회
const boardFind = ( ) => {
	// bno 가져오기
	let bno = findBno();
	// 1. 어디에
	let btitleInput = document.querySelector('.btitleInput');
	let bwriterInput = document.querySelector('.bwriterInput');
	let bdateInput = document.querySelector('.bdateInput');
	let bcontentInput = document.querySelector('.bcontentInput');
	// 2. 무엇을
	const option = { method : 'GET' }
	fetch( `/tj2024b_web1/day05/board2` , option )
		.then( r => r.json() )
		.then( data => {
			data.forEach( obj => {
				if( obj.bno == bno ){ 
					btitleInput.value = `${ obj.btitle }`;
					bwriterInput.value = `${ obj.bwriter } / ${ obj.bview }` ;
					bdateInput.value = `${ obj.bdate }`;
					bcontentInput.value = `${ obj.bcontent }`;
					bpwdState = obj.bpwd;
				}
			}) // for end
		}) // then end
		.catch( e => { console.log(e); } )
	
} // f end
boardFind();

// 4. 게시물 수정
const boardUpdate = () => {
	// 1. dom객체 가져오기
	let bno = findBno();
	let btitle = document.querySelector('.btitleInput').value;
	let bcontent = document.querySelector('.bcontentInput').value;
		// 1-1. 유효성검사
	if( !btitle ){ alert('제목을 입력해주세요.'); return; }
	if( !bcontent ){ alert('내용을 입력해주세요.'); return; }
	
	let bpwd = prompt('비밀번호를 입력해주세요.');
	if( bpwd+'' != bpwdState+'' ){ alert('비밀번호가 일치하지 않습니다.'); return; }
	if( !confirm('게시물을 수정하시겠습니까?') ){ return; }
	
	// 2. 객체화
	let dataObj = { bno : bno , btitle : btitle , bcontent : bcontent , bpwd : bpwd }
	// 3. fetch 통신
	let option = {
		method : 'PUT',
		headers : { 'Content-Type' : 'application/json' },
		body : JSON.stringify( dataObj )
	} // o end
	fetch( `/tj2024b_web1/day05/board2` , option )
		.then( r => r.json() )
		.then( data => {
			if( data == true ){ alert('게시물 수정이 완료되었습니다.'); hrefPage('view'); }
			else{ alert('게시물 수정 실패') }
		}) // then end
		.catch( e => { console.log(e) } )
	
} // f end

// 5. 게시물 삭제
const boardDelete = () => {
	// 유효성 검사
	let bpwd = prompt('비밀번호를 입력해주세요.');
	if( bpwd+'' != bpwdState+'' ){ alert('비밀번호가 일치하지 않습니다.'); return; }
	if( !confirm('정말 삭제하시겠습니까?') ){ return; }
	let bno = findBno();
	let option = { method : 'DELETE' }
	fetch( `/tj2024b_web1/day05/board2?bno=${ bno }` , option )
		.then( r => r.json() )
		.then( data => {
			console.log( data );
			if( data == true ){ alert('게시물 삭제가 완료되었습니다.'); hrefPage('index')}
			else{ alert('게시물 삭제 실패') }
		})
		.catch( e => { console.log(e) } )
} // f end

// 6. 비밀번호 검증
function pwdTest(){
	let bpwd = prompt('비밀번호를 입력해주세요.');
	if( bpwd+'' != bpwdState+'' ){ alert('비밀번호가 일치하지 않습니다.'); return null; }
	return bpwd;
} // f end