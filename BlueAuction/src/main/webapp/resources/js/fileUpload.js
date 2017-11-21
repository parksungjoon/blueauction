/* 첨부파일 선택 시 자동 업로드 */
function autoUpload() {
	$("input[type=file]").change(function() {
		handleUpload();
		
	});
};

/* ajax로 이미지 파일 전송 및 썸네일 출력 */
function handleUpload() {

	var template = Handlebars.compile($("#template").html());
	
	var file = $("input[type=file]")[0].files[0];
	
	var formData = new FormData();
	
	formData.append("file", file);
	
	$.ajax({
		
		url: "/product/attach/",
		data: formData,
		dataType: "text",
		processData: false,
		contentType: false,
		type: "POST",
		success: function(data) {
			var fileInfo = getFileInfo(data);
	        
	        var html = template(fileInfo);
	        
	        $(".uploadedList").append(html);
			$("#photo").val(""); 
		}
		
	});
	
};

/* 첨부파일 정보 Form에 추가 후 submit */
function sendAttachment() {
	$("#registerForm").submit(function(event){
	  
	  event.preventDefault();
	  var inputFile =  $("input[type=file]");

	  if (inputFile.val() == "") {
		  inputFile[0].setCustomValidity("사진을 첨부해 주세요.");
		  return;
	  }else{
		  console.log("입력혀...3");
		  inputFile[0].setCustomValidity(" ");
	  }
	  var that = $(this);
	  
	  var str ="";
	  $(".uploadedList .delbtn").each(function(index){
	     str += "<input type='hidden' name='photo["+index+"]' value='"+$(this).attr("href") +"'> ";
	  });
	  
	  that.append(str);
	  that.get(0).submit();
	});
};

/* 첨부파일 삭제 */
$(document).on("click", ".uploadedList .delbtn", function(event){
	
	event.preventDefault();
	
	var that = $(this);
	 
 	$.ajax({
	   url:"/product/attach/deleteFile",
	   type:"post",
	   data: {fileName:$(this).attr("href")},
	   dataType:"text",
	   success:function(result){
		   if(result == 'deleted'){
			   that.closest("li").remove();
		   }
	   }
   }); 
 	
});