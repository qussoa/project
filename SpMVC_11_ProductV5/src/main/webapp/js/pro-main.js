$(function() {
	$("#pro-img-delete").click(
			function() {
				if (confirm("대표이미지를 삭제할까요")) {
					let p_code = $("#p_code").val()
					document.location.href = rootPath + "/proImgDelete?p_code="
							+ p_code
				}
			})

	$(document).on("click", "span.img-delete", function() {
		let file_name = $(this).attr("data-name")
		if (confirm(file_name + "이미지를 삭제합니다")) {
			let file_seq = $(this).attr("data-id")

			$.ajax({
				url : rootPath + "/rest/subImgDelete",
				data : {
					file_seq : file_seq
				},
				success : function(p_code) {
					getProInfo(p_code)
				}
			})
		}
	})

	$(document).on(
			"click",
			".img-view",
			function() {
				let file_name = $(this).attr("data-upload")
				window.open(rootPath + "/files/" + file_name, "_blank",
						"toolbar=no,scrollbars=no")

			})

	$("tr.p-row").click(function() {
		let p_code = $(this).attr("data-id")
		getProInfo(p_code)
	})
	var getProInfo = function(p_code) {

		$.ajax({

			// "getProduct?p_code=" + p_code
			url : rootPath + "/rest/getProduct",
			data : {
				p_code : p_code
			}, // p_code
			dataType : 'json',
			success : function(result) {

				$("#p_code").val(result.p_code)
				$("#p_name").val(result.p_name)
				$("#p_iprice").val(result.p_iprice)
				$("#p_oprice").val(result.p_oprice)
				$("#p_file").val(result.p_file)

				let proFileImage = rootPath + "/files/noimage.png"
				if (result.p_file != null) {
					proFileImage = rootPath + "/files/" + result.p_file
				}
				$("#p_image").attr("src", proFileImage)
				$("#pro-img-search").attr("data-upload", result.p_file)

				if (result.p_vat == "1") {
					$("#p_vat").attr("checked", "checked")
				} else {
					$("#p_vat").attr("checked", "")
				}

				$("#p_sub_list").html("")
				if (result.p_files.length > 0) {
					result.p_files.forEach(function(file) {

						var imgTag = $("<img/>", {
							width : "100px",
							heigh : "100px",
							margin : "10px",
							"class" : "sub-img",
							"data-id" : file.file_seq,
							"data-name" : file.file_origin_name,
							"alt" : file.file_origin_name,
							src : rootPath + "/files/" + file.file_upload_name
						})
						var delTag = $("<span/>", {
							"class" : "img-delete",

							"data-id" : file.file_seq,
							"data-name" : file.file_origin_name,
						}).append($("<i/>", {
							"class" : "fa fa-trash"
						}))

						var viewTag = $("<span/>", {
							"class" : "img-view",
							"data-id" : file.file_seq,
							"data-name" : file.file_origin_name,
							"data-upload" : file.file_upload_name
						}).append($("<i/>", {
							"class" : "fa fa-search"
						}))

						$("#p_sub_list").append($("<div/>", {
							"class" : "sub-img-box"
						}).append(imgTag, $("<div/>", {
							"class" : "img-menu"
						}).append(delTag, viewTag)))

					})
				}
			},
			error : function() {
				alert("서버 통신 오류")
			}
		})
	}
	if (bStart == 0) {
		var p_code = $("#p_code").val()
		if (p_code == "") {
			let tr = $("tr.p-row:ep(0)")
			p_code = tr.attr("data-id")
		}
		getProInfo(p_code)
		bStart++
	}
})