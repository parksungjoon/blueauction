<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html class="wide wow-animation" lang="en">
  <head>
    <!-- Site Title-->
    <title>Shop Checkout</title>
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <!-- Stylesheets -->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Oswald:200,400%7CLato:300,400,300italic,700%7CMontserrat:900">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/mdi.css">
    <link rel="stylesheet" href="resources/css/fl-bigmug-line.css">
    
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
		<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]--> 
    <script>$('.date').datepicker({ dateFormat: 'yyyy-mm-dd' }).val();</script>
    <style type="text/css">
      input.file {
        opacity: 0;
        position: relative;
        width: 165px;
      }
      
      button.reg {
        position: absolute;
        left: 0;
        min-width: 50px;
        min-height: 10px;
      }
    </style>
  </head>
  <body>
    <%-- Page preloader--%>
    <jsp:include page="/WEB-INF/views/include/pageloader.jsp"/>
    
    <%-- Page--%>
    <div class="page">
      
      <%-- page Header START --%>
      <jsp:include page="/WEB-INF/views/include/header.jsp" />
      <%-- page Header END --%>
      
      <!-- Breadcrumbs-->
      <section class="breadcrumbs-custom breadcrumbs-custom-svg bg-gradient breadcrumbs-background-01">
        <div class="shell">
          <p class="heading-1 breadcrumbs-custom-title">Used Stuff Auction</p>
          <br>
          <br>
          <br>
        </div>
      </section>
      <!-- Product Page-->
      <section class="section section-lg bg-white">
        <div class="shell shell-wide">
          <div class="range range-50 range-md-center">
            <div class="cell-md-11 cell-lg-10 cell-xl-6">
                <!-- Tab panes-->
                    <form class="rd-mailform text-left" data-form-output="form-output-global" data-form-type="contact" method="post" action="bat/rd-mailform.php">
                      <div class="range range-20">
                        <div class="cell-sm-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-name">title</label>
                            <input class="form-input" id="forms-3-name" type="text" name="title" data-constraints="@Required">
                          </div>
                        </div>
                        <div class="cell-sm-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-last-name">seller</label>
                            <input class="form-input" id="forms-3-last-name" type="text" name="seller" data-constraints="@Required" readonly="readonly">
                          </div>
                        </div>
                        <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-company">Start Price</label>
                            <input class="form-input" id="forms-3-company" type="text" name="baseprice" data-constraints="@Required">
                          </div>
                        </div>
                        <div class="cell-sm-8">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Reason For Sale</label>
                            <input class="form-input" id="forms-3-city" type="text" name="salemotive" data-constraints="">
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Period Of Use</label>
                            <input class="form-input" id="forms-3-city" type="text" name="usingtime" data-constraints="">
                          </div>
                        </div>
                        <div class="cell-sm-4">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Delivery Type</label>
                              <div class="form-wrap box-width-1">
                                <select class="form-control select-filter" data-placeholder="All" data-minimum-results-for-search="Infinity" data-constraints="@Selected" name="city">
                                  <option value="1">Direct Dealing</option>
                                  <option value="2">Parcel Service</option>
                                </select>
                              </div>
                          </div>
                        </div>
                         <div class="cell-sm-6">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-city">Auction Date</label>
                            <!-- <input class="form-input" id="forms-3-city" type="date" name="usingtime" data-constraints=""> -->
                            <input class="form-input data" id="form-element-date" data-time-picker="date" name="date" >
                          </div>
                        </div>
                        <div class="cell-sm-3">
                          <div class="form-wrap form-wrap-validation row">
                            <label class="form-label-outside" for="forms-3-city">Photos</label>
                            <button class="button button-secondary reg" type="submit">Select File</button>
                            <input class="form-input file" id="forms-3-city" type="file" name="photo" required="required">
                          </div>
                        </div>
                        <div class="cell-sm-9	">
                          <ul class="mailbox-attachments clearfix uploadedList"></ul>
                        </div>
                        <div class="cell-sm-12">
                          <div class="form-wrap form-wrap-validation">
                            <label class="form-label-outside" for="forms-3-street-address">Product Information</label>
                            <textarea class="form-input" rows="6" cols="100%" name="productinfo" data-constraints="@Required"style="resize: none;"></textarea>
                          </div>
                        </div>
                        
                        <div class="cell-sm-12 offset-custom-1">
                          <div class="form-button text-sm-right">
                            <button class="button button-secondary" type="submit">Register</button>
                          </div>
                        </div>
                      </div>
                    </form>
            </div>
          </div>
        </div>
      </section>
      
     <%-- Page Footer--%>
      <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      
    </div>
    <!-- PANEL-->
    <!-- END PANEL-->
    <!-- Global Mailform Output-->
    <div class="snackbars" id="form-output-global"></div>
    <!-- Javascript-->
    <script src="resources/js/core.min.js"></script>
    <script src="resources/js/script.js"></script>
  </body>
</html>