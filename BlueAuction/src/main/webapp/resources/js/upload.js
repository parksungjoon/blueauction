function checkImageType(fileName){
	
	var pattern = /jpg|gif|png|jpeg/i;
	
	return fileName.match(pattern);

}

function getFileInfo(fullName){
		
	var fileName,imgsrc, getLink;
	
	var fileLink;
	
	if(checkImageType(fullName)){
		imgsrc = "/product/attach/displayFile?fileName="+fullName;
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0,12); // /2015/07/01/ 
		var end = fullName.substr(14);
		
		getLink = "/product/attach/displayFile?fileName="+front + end;
		
	}else{
		imgsrc ="/resources/dist/img/file.png";
		fileLink = fullName.substr(12);
		getLink = "/displayFile?fileName="+fullName;
	}
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	
	return  {fileName:fileName.substring(0, 6) + '...', imgsrc:imgsrc, getLink:getLink, fullName:fullName};
	
}


