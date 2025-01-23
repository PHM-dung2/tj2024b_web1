// 1. 회원 등록
const memberWrite = () => {
	
} // f end

// 2. 회원 목록 조회
const memberFindAll = () => {
	let tbody = document.querySelector('.viewtbody');
	
	let html = '';
	
	let option = { method : 'GET' }
	fetch( '/shoppingservice/hrdkorea/member' , option )
		.then( r => r.json() )
		.then( data => {
			data.forEach( obj => {
			 	html += `<tr>
							<td> <a href="/shoppingservice/hrdkorea/update.jsp?custno=${obj.custno}"> ${ obj.custno } </a> </td>
							<td> ${ obj.custname } </td>
							<td> ${ obj.phone } </td>
							<td> ${ obj.address } </td>
							<td> ${ obj.joindate } </td>
							<td> ${ obj.grade } </td>
							<td> ${ obj.city } </td>
						</tr>`
			}) // for end
			tbody.innerHTML = html;
		}) // then end
		.catch( e => { console.log(e); } );
} // f end
memberFindAll();

// 수정할 회원번호 가져오기

// 3. 회원 수정
const memberUpdate = () => {
	
} // f end

