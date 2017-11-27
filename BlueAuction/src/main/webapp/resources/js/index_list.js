/* 리스트 출력 */
  		function printList(data){
  			var used = data.used;
  			var auction = data.auction;
  			
  			for ( var index in used) {
				console.log(used.toStrin());
			}
  			console.log("중고 물품 수 : " + used.length);
  			addHtml(used);
  			addHtml(auction);
  		}
  		
  		function addHtml(data){
  			var html = "";
  			
  			if(data.length != 0){
    			var category = data[0].categoryId;
    			
    			if(category == 2){
  	 			getAuctionTime(data);
  				setTime(seconds, minutes, hour); // 동적 생성 경매의 카운트 다운
    			}
    			
    			for ( var i in data) {
    				html += "<div class='cell-sm-6 cell-md-4 cell-lg-3 cell-xl-3'>";
                  html += "<div class='product product-counter product-auction'>";
                  html += "<div class='product-counter-inner'>"
                  if(category == '1'){
                  	html += "<div class='jjh-counter'>" + data[i].regdate + "</div>";
                  }else{
                  	html +=" <div class='countdown jjh-counter is-countdown jjh-timer' data-time='' data-format='DDHMS' data-type='until' data-layout='{hnn}{sep}{mnn}{sep}{snn}'></div>";
                  }
                  html += "</div>";
                  html += "<div class='product-image jjh-mainImg'><img src='/resources/images/img" + data[i].mainphoto + "' alt='image'></div>"
                  html += "<div class='product-title'>";
                  html += "  <h5><a>" + data[i].name + "</a></h5>";
                  html += "</div>";
                  if(category == 1){
                  	 html += "<div class='product-price-wrap'>";
                       html += "  <div class='product-price'>";
                       html +="   <p>Price</p>";
                       html += "    <h6>" + data[i].price + "원</h6>";
                       html += "  </div>";
                       html += "</div>";
                  }else{
                  	html +="        <div class='jjh-price'>";
      	  	  		html +="          <div class='product-price'>";
      	  	  		html +="            <p>Start Price</p>";
      	  	  		html +="            <h6>" + data[i].basicprice + "원</h6>";
      	  	  		html +="          </div>";
      	  	  		html +="          <br>";
      	  	  		html +="           <div class='jjh-currentPrice'>";
      	  	  		html +="             <p class=''><strong>Current Price</strong></p>";
      	  	  		
      	      	  	if(data[i].bidprice != 0){
      	            	html +="<h6>" + data[i].bidprice + "원</h6>";
      	            }else{
      	            	html +="<h6 class='jjh-notSuccess'>" + data[i].basicprice + "원</h6>";
      	            }
      	      	  	
      	  	  		html +="           </div>";
      	  	  		html +="        </div>";
                  }
                  
                  if(category == 1){
                	  html += "<div class='product-button'><a class='jjh-listButton button-secondary' href='/product/used/" + data[i].productId + "'>Detail</a></div>";
                  }else{
                	  html += "<div class='product-button'><a class='jjh-listButton button-secondary' href='/product/auction/readpage/" + data[i].productId + "'>Detail</a></div>";
                  }
                 
                  html += "</div>";
                  html += "</div>";
  			}
    			if(category == 1){
    				$("#jjh-usedList").html(html);
    			}else{
    				$("#jjh-auctionList").html(html);
    			}
  			}else{
  				html += "<h3 class='jjh-emptyList'>상품이 존재하지 않습니다</h3>";
  				$(".jjh-productList").html(html);
  			}
  		}