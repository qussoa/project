$(function() {

	var calc = function() {
		let price = parseInt($("#io_price").val())
		let qty = parseInt($("#io_qty").val())
		
		let total = price * qty
		$("#io_total").val(total)
	}

	$("#btn-save").click(function() {
		
		let dCode = $("#io_dcode").val()
		if(dCode == ""){
			alert("거래처코드가 비어있음")
			$("#io_dcode").focus()
			return false
		}
		let pCode = $("#io_pcode").val()
		if(pCode == ""){
			alert("상품코드가 비어있음")
			$("#io_pcode").focus()
			return false
		}
		
		
		if(confirm("저장할까요?")){
			$("form").submit()
		}
	})
	
	
	
	$("#io_price").on("change keyup paste input propertychange",calc)
	$("#io_qty").on("change keyup paste input propertychange",calc)
	
	// 입력박스에서 enter 키방지
	$("#io_dcode").keypress(function(e) {
		if (e.keyCode == 13) {
			// 현재까지 거래처 코드 input box에 입력 된 값 추출
			let strText = $(this).val()
			let query = rootPath
			query += "/dept/search?strText=" + strText
			let status = "toolbar=no,"
			status += "scrollbas=yes,"
			status += "resizable=no,"
			status += "top=300,"
			status += "left=800,"
			status += "width=1000,"
			status += "height=500"
			// _blank
			// 새 브라우저를 열어 조회창
			// 조회물 보이기
			window.open(query, "_blank", status)

		}
	})

	/*
	 * 입력박스에 키보드로 뭔가를 입력할 때마다 발생하는 이벤트 keydown 키보드를 누르는 순간 발생 keypress 글자가 입력이
	 * 되어서 컴퓨터로 입력되는 순간 발생 어떤 글자가 입력되었는가를 캐치하기 위한 이벤트 keyup 키보드에서 손을 떼는 순간
	 */
	$("#io_pcode").keypress(function(event) {
		// 키보드에서 어떤 문자를 입력하면 event의 keyCode라는 속성에
		// 문자의 ASCII 코드 값이 저장되어 전달된다
		if (event.keyCode == 13) {
			let str = $(this).val()
			let query = rootPath
			query += "/pro/search?strText=" + str

			let status = "toolbar=no,"
			status += "scrollbas=yes,"
			status += "resizable=no,"
			status += "top=300,"
			status += "left=500,"
			status += "width=700,"
			status += "height=500"

			window.open(query, "_blank", status)
		}

	})

})
