$(document).ready(function() {
    
   $('#loginform').submit(function(event) {
	   
	   alert("submit");
	   if (validateLoginInfo()) 
	   connectDB();
		event.preventDefault();
	});
});

function clearRegMsg(){
     if  ($('#name-gp').hasClass('has-error'))
            $('#name-gp').removeClass('has-error');
        if  ($('#pw1-gp').hasClass('has-error'))
            $('#pw1-gp').removeClass('has-error');
        
        $('.help-block').remove();
        
        //alert("clear msg");
}

function validateLoginInfo() {
	
	   clearRegMsg();
      
        var criterion=/^[a-zA-Z0-9]*$/;
        
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
                 
       if  ($('#name-gp').hasClass('has-error')||$('#pw1-gp').hasClass('has-error'))
        {return false;}
	else { return true;}}//end validate

function connectDB(){
	
    $.ajax({
                url: 'LoginServlet',
                data: {
                	'action':'login',
                    'uname': $('#uname').val(),
                    'pw': $('#pw1').val(),
                },
                type: 'post',
                dataType: 'json',
                encode: true,
                success: function(data) {
                	alert("connentDB success");
                
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
