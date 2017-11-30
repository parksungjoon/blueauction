/* 숫자 자릿수 찍어주기 */
var rgx1 = /\D/g;
var rgx2 = /(\d+)(\d{3})/; 

function getNumber(obj){
	
     var num01;
     var num02;
     num01 = obj.value;
     num02 = num01.replace(rgx1,"");
     num01 = setComma(num02);
     obj.value =  num01;

}

function setComma(inNum){
     
     var outNum;
     outNum = inNum; 
     while (rgx2.test(outNum)) {
          outNum = outNum.replace(rgx2, '$1' + ',' + '$2');
      }
     return outNum;

}