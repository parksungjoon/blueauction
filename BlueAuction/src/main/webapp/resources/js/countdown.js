/** 동적 생성 경매의 카운트 다운 */
  	 function setTime(secs, mins, hours){
  		 var strs; // 초(문자열)
  		 var strm; // 분(문자열)
  		 var strh; // 시(문자열)
  		hour = hours;
  		min = mins;
  		sec = secs;
  		
  		var now = new Date(); // 현재 시간
  		var nowh = now.getHours(); // 현재 시간(시)
  		var nowm = now.getMinutes(); // 현재 시간(분)
  		var nows = now.getSeconds(); // 현재 시간(초)
  		
  		if(sec == 0){ // 초가 0일때
  			sec = 60; // 60초로 변환
  			min = min -1; // 분 -1
  		}
  		
  		lefts = sec - nows; // 남은 시간(초) = 경매 종료 시간(초) - 현재 시간(초)
  		
  		if(min == -1){ // 분이 음수
  			min = 59;
  			hour = hour -1; 
  		}
  		leftm = min - nowm; // 남은 시간(분) = 경매 종료 시간(분) - 현재 시간(분)
  		
  		lefth = hour - nowh; // 남은 시간(시) = 경매 종료 시간(시) - 현재 시간(시)
  		
  		countdown(); // 시간 - 1 setTimeout
  	 }
  	 
  	/** 1초에 시간 -1씩 */
  	 function countdown(){
  		 lefts = lefts - 1;
  		 
  		 if(lefts == -1){
  			lefts = 59;
  			leftm = leftm - 1;
  		 }
  		 
  		 if(lefts == 0){ // 남은 시간(초)가 0이면
  			lefts = "00"; // 문자열 '00' 할당
  		 }
  		 
  		 if(lefts > 0 && lefts <10){ // 남은 시간(초)가 한자리 수
  			 var strs = "0" + lefts; // 앞에 0이 붙는 문자열로 변환
  		 }else{
  			 strs = lefts;
  		 }
  		 
  		 if(leftm == -1){
  			leftm = 59;
  			lefth = lefth - 1;
  		 }
  		 
  		 if(leftm == 0){ // 남은 시간(분)가 0이면
  			 leftm = "00"; // 문자열 '00' 할당
  		 }
  		 
  		 if(leftm > 0 && leftm <10){ // 남은 시간(분)가 한자리 수
  			var strm = "0" + leftm; // 앞에 0이 붙는 분자열로 변환
  		 }else{
  			 strm = leftm;
  		 }
  		 
  		if(lefth == -1){
  			lefth = 23;
  		 }
  		 
  		 if(lefth == 0){ // 남은 시간(시)가 0이면
  			 lefth = "00"; // 문자열 '00' 할당
  		 }
  		 
  		if(lefth > 0 && lefth <10){ // 남은 시간(시)가 한자리 수
  			var strh = "0" + lefth; // 앞에 0이 붙는 분자열로 변환
  		 }else{
  			 strh = lefth;
  		 }
  		 
  		 if(lefts == 0 && leftm == 0 && lefth == 0){
  			$(".jjh-timer").html("Finished Countdown"); // 경매 종료시 종료 메시지 출력
  			return;
  		 }
  		 
  		$(".jjh-timer").html(strh + ":" + strm + ":" + strs); // 경매 남은 시간 출력
  		 window.setTimeout("countdown()", 1000); // 1초마다 함수 실행
  	 }
  	 
  	/** 경매 시간 시, 분, 초로 get */
  	 function getAuctionTime(list){
  		 auctionend = list[0].auctionend; // 경매 종료 시간(doing의 경매 종료 시간은 다 같음)
		 auctionend = new Date(auctionend);
		 hour = auctionend.getHours(); // 시간
		 minutes = auctionend.getMinutes(); // 분
		 seconds = auctionend.getSeconds(); // 초
  	 }
