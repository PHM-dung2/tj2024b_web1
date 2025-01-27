const parkingInoutAllList = async () => {
	let tbodyElement = document.querySelector('tbody');

	let html = '';
	const option = { method: 'GET' }

	try {
		const response = await fetch('/tj2024b_web1/day06/admin-all', option);
		const dtoList = await response.json();

		let index = 1;
		dtoList.forEach(dto => {
			switch (dto.state) {
				case 0:
					dto.state = '입차';
					break;
				case 1:
					dto.state = '출차';
			}
			html += `
					<tr>
						<td>${index++}</td>
						<td>${dto.car}</td>
						<td>${dto.state}</td>
						<td>${dto.time}</td>						
						<td>${dto.price}</td>												
					</tr>
				`;
		});
	} catch (error) {
		console.error('error:', error.message);
	}

	tbodyElement.innerHTML = html;
} // f end

const parkingInoutList = async (state) => {
	let tbodyElement = document.querySelector('tbody');

	let html = '';
	const option = { method: 'GET' }

	try {
		const response = await fetch(`/tj2024b_web1/day06/admin-inout?state=${state}`, option);
		const dtoList = await response.json();

		let index = 1;
		dtoList.forEach(dto => {
			switch (dto.state) {
				case 0:
					dto.state = '입차';
					break;
				case 1:
					dto.state = '출차';
			}
			html += `
					<tr>
						<td>${index++}</td>
						<td>${dto.car}</td>
						<td>${dto.state}</td>
						<td>${dto.time}</td>						
						<td>${dto.price}</td>												
					</tr>
				`;
		});
	} catch (error) {
		console.error('error:', error.message);
	}

	tbodyElement.innerHTML = html;
} // f end