$(document).ready(function() {
    
   $('#signupform').submit(function(event) {
	   
	   //alert($('#pw1').val()+"   "+$('#email').val()+"    "+$('#realN').val()+"     "+$('#tel').val()+"     "+$('#address').val());
	    //alert("submit");
	   if (validateRegInfo()) 
	   connectDB();
		event.preventDefault();
	});
});

function clearRegMsg(){
     if  ($('#name-gp').hasClass('has-error'))
            $('#name-gp').removeClass('has-error');
        if  ($('#pw1-gp').hasClass('has-error'))
            $('#pw1-gp').removeClass('has-error');
        if  ($('#pw2-gp').hasClass('has-error'))
            $('#pw2-gp').removeClass('has-error');
        if  ($('#email-gp').hasClass('has-error'))
            $('#email-gp').removeClass('has-error');
        if  ($('#realN-gp').hasClass('has-error'))
            $('#realN-gp').removeClass('has-error');
        if  ($('#tel-gp').hasClass('has-error'))
            $('#tel-gp').removeClass('has-error');
        if  ($('#address-gp').hasClass('has-error'))
            $('#address-gp').removeClass('has-error');
        
        $('.help-block').remove();
        
        //alert("clear msg");
}

function validateRegInfo() {
	
	   clearRegMsg();
        //alert("uname "+ $('#uname').val());
        
        var criterion=/^[a-zA-Z0-9]*$/;
        var mailCriterion= /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        var telCriterion= /^[0-9\-]*$/;
        var addressCriterion=/^[A-Za-z0-9'\.\-\s\,]*$/;
       
        
        if ( $('#uname').val()==="" ){
        $('#name-gp').addClass('has-error'); 
        $('#name-gp').append('<div class="help-block">ユーザネームを入力してください。</div>'); }
        else{ if ((($('#uname').val().length<6)||$('#uname').val().length>12)){
        $('#name-gp').addClass('has-error'); 
        $('#name-gp').append('<div class="help-block">ユーザネームの長さは6-12文字でお願いします。</div>'); }
        if (!criterion.test($('#uname').val())){
        $('#name-gp').addClass('has-error'); 
        $('#name-gp').append('<div class="help-block">ユーザネームはアルファベットと数字のみでお願いします。</div>'); }}
        
        if ( $('#pw1').val()==="" ){
        $('#pw1-gp').addClass('has-error'); 
        $('#pw1-gp').append('<div class="help-block">パスワードを入力してください。</div>'); }
        else{if ((($('#pw1').val().length<6)||$('#pw1').val().length>10)){
        $('#pw1-gp').addClass('has-error'); 
        $('#pw1-gp').append('<div class="help-block">パスワードの長さは6-10文字でお願いします。</div>'); }
        if (!criterion.test($('#pw1').val())){
        $('#pw1-gp').addClass('has-error'); 
        $('#pw1-gp').append('<div class="help-block">パスワードはアルファベットと数字のみでお願いします。</div>'); }}
        
        if ( $('#pw2').val()==="" ){
        $('#pw2-gp').addClass('has-error'); 
        $('#pw2-gp').append('<div class="help-block">パスワードを入力してください。</div>'); }
        else {if ((($('#pw2').val().length<6)||$('#pw2').val().length>10)){
        $('#pw2-gp').addClass('has-error'); 
        $('#pw2-gp').append('<div class="help-block">パスワードの長さは6-10文字でお願いします。</div>'); }
        if (!criterion.test($('#pw2').val())){
        $('#pw2-gp').addClass('has-error'); 
        $('#pw2-gp').append('<div class="help-block">パスワードはアルファベットと数字のみでお願いします。</div>'); }}
        
        if (!$('#pw2').val().match($('#pw1').val())){
        $('#pw1-gp').addClass('has-error'); 
        $('#pw2-gp').addClass('has-error'); 
        $('#pw1-gp').append('<div class="help-block">入力されたパスワードが一致していません。</div>'); 
        $('#pw2-gp').append('<div class="help-block">入力されたパスワードが一致していません。</div>'); }
        
        if ($('#email').val()===""){
        $('#email-gp').addClass('has-error'); 
        $('#email-gp').append('<div class="help-block">メールを入力してください。</div>');  
        }
        else if (!mailCriterion.test($('#email').val())){
        $('#email-gp').addClass('has-error'); 
        $('#email-gp').append('<div class="help-block">入力されたメールが有効ではありません。</div>'); }
       
        if ( $('#realN').val()==="" ){
            $('#realN-gp').addClass('has-error'); 
            $('#realN-gp').append('<div class="help-block">本名を入力してください。</div>'); }
            else{ if ((($('#realN').val().length<2)||$('#realN').val().length>40)){
            $('#realN-gp').addClass('has-error'); 
            $('#realN-gp').append('<div class="help-block">本名の長さは2-40文字でお願いします。</div>'); }
            if (!criterion.test($('#realN').val())){
            $('#realN-gp').addClass('has-error'); 
            $('#realN-gp').append('<div class="help-block">本名はアルファベットと数字のみでお願いします。</div>'); }}
           
        
        if ($('#tel').val()===""){
            $('#tel-gp').addClass('has-error'); 
            $('#tel-gp').append('<div class="help-block">電話番号を入力してください。</div>');  
            }
            else {if ((($('#tel').val().length<10)||$('#tel').val().length>13)){
            	 $('#tel-gp').addClass('has-error'); 
                 $('#tel-gp').append('<div class="help-block">入力された電話の長さは有効ではありません。</div>'); }
            if (!telCriterion.test($('#tel').val())){
                $('#tel-gp').addClass('has-error'); 
                $('#tel-gp').append('<div class="help-block">半角数字と"-"のみの組み合わせが有効と見なされます。</div>'); }}
        	
            
        if ($('#address').val()===""){
                $('#address-gp').addClass('has-error'); 
                $('#address-gp').append('<div class="help-block">住所を入力してください。</div>');  
            }
                else{ if (($('#address').val().length<10)){
            	 $('#address-gp').addClass('has-error'); 
                 $('#address-gp').append('<div class="help-block">入力された住所の長さは短過ぎます。</div>'); }
                else if ($('#address').val().length>200){
                	$('#address-gp').addClass('has-error'); 
                    $('#address-gp').append('<div class="help-block">入力された住所の長さは長過ぎます。</div>'); }
                if (!addressCriterion.test($('#address').val())){
                    $('#address-gp').addClass('has-error'); 
                    $('#address-gp').append('<div class="help-block">入力された住所が許可されない特別記号が入っています。</div>'); }}
                
                
       if  ($('#name-gp').hasClass('has-error')||$('#pw1-gp').hasClass('has-error')
            ||$('#pw2-gp').hasClass('has-error')||$('#email-gp').hasClass('has-error')
            ||$('#realN-gp').hasClass('has-error')
            ||$('#tel-gp').hasClass('has-error')||$('#address-gp').hasClass('has-error'))
        {return false;}
	else { return true;}}//end validate

function connectDB(){
	
    $.ajax({
                url: 'RegistrationServlet',
                data: {
                    'uname': $('#uname').val(),
                    'pw': $('#pw1').val(),
                    'email': $('#email').val(),
                    'cus_name': $('#realN').val(),
                    'tel': $('#tel').val(),
                    'address': $('#address').val()
                },
                type: 'post',
                dataType: 'json',
                encode: true,
                success: function(data) {
                	alert("connentDB success");
                if (data.memExist!== null){
                	alert(data.memExist);
                $('form').addClass('has-error'); 
                $('form').append('<div class="help-block">'+ data.memExist +'</div>');
                }
                
               },
                error:  function(data) {
                	alert("connentDB error");
                errorMsg();
           }
	     });

}
	
function errorMsg(){
            $('form').addClass('has-error'); 
            $('form').append('<div class="help-block"><h1>データベースに接続に問題があるようです。</h1></div>'); 
	
}
