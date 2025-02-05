
// 입차
const inCar = () => {
	let carNumInput = document.querySelector('.carNumInput').value
	let carLoInput = document.querySelector('.carLoInput').value
	
	let dataObj = {
		carNum : carNumInput,
		carLo : carLoInput
	}
	
	const option = {
		method : 'POST',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	
	fetch('/tj2024b_web1/clone', option)
		.then(response => response.json())
		.then(data => {
			if(data == true){
				alert('입차 성공');
			}else{
				alert('입차 실패')
			}
		})
		.catch(e => {alert(e + '[시스템 오류] \n 관리자에게 문의하세요')})

}

// 출차시간 소환
const updateOutCar = () => {
	let carNum = document.querySelector('.carNumInput').value
	const obj = {
		carNum : carNum
	}
	
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(obj)
	}
	
	fetch(`/tj2024b_web1/clone2`, option)
		.then(r => r.json())
		.then(data => {
			console.log(data);
			serchCar();
			
		})
		.catch(e => {console.log(e);})
	
}


// 조회
const serchCar = () => {
	let carValue = document.querySelector('.carValue')
	let carNum = document.querySelector('.carNumInput').value
	// 조회 버튼을 누르면 입력된 차량번호를 가져와서
	
	//const obj = {carNum : carNum}
	 //객체에 담고
	
	let html = '';
	
	const option = {
		method : 'GET',
		//headers: {'Content-Type': 'application/json'},
		//body : JSON.stringify(obj) // body에 요청하려고 했으나
		// get은 body가 없음
		// 페이지 전환을 하지 않는 구조라서 쿼리스트링 getParameter를 할 수 없음
		// 한 페이지에서 해결하려면 어떻게 해야 합니까
	}
	
	fetch(`/tj2024b_web1/clone?carNum=${carNum}`, option)
		.then(response => response.json())
		.then(data => {
			let totalSum = 0
			
			let inCar = data.inCar.split(' ');
			let outCar = data.outCar.split(' ');
			
			let inCarTime = inCar[1].split(':')
			let outCarTime = outCar[1].split(':')
			
			
			
			let inCarMin = parseInt(inCarTime[1])
			let inCarSec = parseInt(inCarTime[2])
			
			let outCarMin = parseInt(outCarTime[1])
			let outCarSec = parseInt(outCarTime[2])
			
			
			let inTotal = (parseInt(inCar[0].split('-')[2]) * 24 * 60 * 60) + (inCarMin * 60) + inCarSec;
			let outTotal = (parseInt(outCar[0].split('-')[2]) * 24 * 60 * 60) + (outCarMin * 60) + outCarSec;
			
			let totalP = outTotal - inTotal
			
			
			// 100초 이상이면 무조건 10000원
			if (totalP >= 100) {
			  totalSum = 10000;
			} else {
			  // 1초당 100원 부과
			  totalSum = totalP * 100;
			}
				html += `
							<div>
								입차시간 :
								${data.inCar}
								<br/>
								출차시간 : 
								${data.outCar}
								<br/> <hr/>
								주차료 : 
								${totalSum}
							</div>
							<button onclick="outCar()">출차(결제)</button>
						`
			
			carValue.innerHTML = html;
		})
		.catch(e => {console.log(e);})
}





// 진짜 출차
const outCar = () => {
	let carNum = document.querySelector('.carNumInput').value

	const option = { method : 'PUT' }
	
	fetch(`/tj2024b_web1/clone?carNum=${carNum}`, option)
		.then(r => r.text())
		.then(data => {
			console.log(data);
			
		})
		.catch(e => {console.log(e);})
	
}



