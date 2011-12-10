<%@ page contentType="text/html; charset=utf-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>註冊會員</title>
<script language="javascript" type="text/javascript" src="/js/jquery-1.7.1.min.js"></script>
<link href="/css/templatemo_style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="/js/email.checker.js"></script>

<script>
$(document).ready(function(){
	$("#email_error").hide();	
	$("#repassword_error").hide();		
	
	$("#email").focusout(function(){
		var email = $("#email").val();
		if(isEmail(email)){
			$(this).removeClass("input_field_error");
			$(this).addClass("input_field");			
			$("#email_error").hide();			
		}
		else {
			$(this).removeClass("input_field");
			$(this).addClass("input_field_error");
			$("#email_error").show();			
		}
	});
	
	$("#repassword").focusout(function(){
		var repassword = $("#repassword").val();
		var password = $("#password").val();
		if(password == repassword){
			$(this).removeClass("input_field_error");
			$(this).addClass("input_field");			
			$("#repassword_error").hide();			
		}
		else {
			$(this).removeClass("input_field");
			$(this).addClass("input_field_error");
			$("#repassword_error").show();			
		}
	});
	
	
	
});
</script>


</head>

<body>
<div id="templatemo_login">
  <div class="col_w400 hr_divider">
    
      <h2>ITHub</h2>
    <p><a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow"><strong>註冊</strong></a>您在ITHub的帳號</p>
    
    <div class="col_w420 float_l">
          <div id="cp_contact_form">
            <form action="#" method="post" name="contact" id="contact">
              <label for="author3">本名:</label>
              <input type="text" id="author3" name="author" class="required input_field" />
              
              <label for="email">Email:</label>
              
              <input type="text" id="email" name="author" class="required input_field" />
              <img id="email_error" src="/images/register_error.png" width="20" height="20"/>
              
              
              <label for="email">密碼:</label>
              <input type="password" class="validate-email required input_field" name="email" id="password" />
              <label for="email">確認密碼:</label>
              <input type="password" class="validate-email required input_field" name="email" id="repassword" />
              <img id="repassword_error" src="/images/register_error.png" width="20" height="20"/>              
              <div class="cleaner h10"></div>
              <input type="reset" value="確認註冊" id="reset" name="reset" class="submit_btn float_r" />
            </form>
      </div>
    </div>
    </div>
    <div class="col_w400"></div> 
    <div class="col_w400"></div>    
  
</div>

</body>
</html>