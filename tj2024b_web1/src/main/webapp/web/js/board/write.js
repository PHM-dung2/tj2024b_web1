console.log('write.js open');

// [*] 썸머노트 실행 코드
$(document).ready(function() {
  $('#summernote').summernote({
	placeholder : '게시물 내용을 입력해주세요.',
	tabsize : 2,
	height: 500,
	lang : 'ko-KR'
  }); // f end
}); // f end

// [1] 글스기 요청 메소드
const onWrite = () => {
	
	// 첨부파일 있다 = form 전송 vs 첨부파일 없다 = form 또는 JSON
	
	// 1. 입력받은 값들을 가져오기 위해서 DOM 객체 호출
	const cnoselect = document.querySelector('.cnoselect'); 
	const titleinput = document.querySelector('.titleinput');
	const contentinput = document.querySelector('.contentinput');
	
	// 2. DOM 객체에서의 입력받은 (value속성)값 호출
	const cno = cnoselect.value;
	const btitle = titleinput.value;
	const bcontent = contentinput.value;
	
	// 3. 값들을 묶어주는 객체(json) 만들기
	let obj = { cno : cno , btitle : btitle , bcontent : bcontent }
	
	// 4. fetch option
	const option = { 
		method : 'POST' ,
		headers : {'Content-Type' : 'application/json'} ,
		body : JSON.stringify( obj ) // JSON형식의 문자열 타입으로 변환
	} // o end
	fetch( `/tj2024b_web1/board` , option )
		.then( r => r.json() )
		.then( data => {
			console.log( data );
			if( data ){ 
				alert('게시물 등록 완료'); 
				location.href=`board.jsp?cno=${ cno }`   
			}else{ alert('게시물 등록 실패'); }
		}) // then end
		.catch( e => { console.log(e); })
	
} // f end