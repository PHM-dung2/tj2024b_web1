console.log('view.js open');

// [1] 게시물 1개 조회
const findByBno = () => {
	
	// 1. URL 주소상의 bno(조회할 번호)를 가져오기
	const bno = new URL( location.href ).searchParams.get('bno');
	
	// 2. 
	const option = { method : 'GET' }
	fetch( `/tj2024b_web1/board/view?bno=${ bno }` , option )
		.then( r => r.json() )
		.then( data=> {
			console.log( data );
			document.querySelector('.titlebox').innerHTML = data.btitle;
			document.querySelector('.contentbox').innerHTML = data.bcontent;
			document.querySelector('.midbox').innerHTML = data.mid;
			document.querySelector('.viewbox').innerHTML = data.bview;
			document.querySelector('.datebox').innerHTML = data.bdate;
		}) // then end
		.catch( e => { console.log(e); })
} // f end
findByBno();

// [2] 
const onReplyWrite = () => {
	
	// 1. 입력받은 값 가져오기
	const rcontentinput = document.querySelector('.rcontentinput');
	const rcontent = rcontentinput.value;
	// 2. 현재 게시물의 번호 구하기
	const bno = new URL( location.href ).searchParams.get("bno")
	// 3. 보낼 자료를 객체로 만들기
	const obj = { rcontent : rcontent , bno : bno }
	// 4. fetch 이용한 servlet 통신( 주고=request 받기=response )
	const option = {
		method : 'POST',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify( obj )
	} // o end
	
	fetch( '/tj2024b_web1/board/reply' , option )
		.then( r => r.json() )
		.then( data => {
			if( data ){
				alert('댓글쓰기 성공')
				replyFindAll();
			}else{
				alert('댓글쓰기 실패')
			}
		}) // then end
		.catch( e => { console.log(e); })
} //  f end

// [3] 현재 게시물의 댓글 전체 조회
const replyFindAll = () => {
	
	// 1. [준비물] bno
	const bno = new URL( location.href ).searchParams.get("bno");
	// fetch queryString
	fetch( `/tj2024b_web1/board/reply?bno=${ bno }` )
		.then( r => r.json() )
		.then( data => {
			console.log( data );
			
			const replybox = document.querySelector('.replybox');
			let html = '';
			data.forEach( reply => {
				html += `<div class="card mt-3">
							<div class="card-header">
         	                   <img src="/tj2024b_web1/upload/${ reply.mimg}" style="width:30px;" />
                               		${ reply.mid }
                               </div>
							<div class="card-body">
								${ reply.rcontent }
							</div>
						</div>`;
				}) // for end
			replybox.innerHTML = html;
			}) // then end
		.catch( e => { console.log(e); })
	
} // f end
replyFindAll();
