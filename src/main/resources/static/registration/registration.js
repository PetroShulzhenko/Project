
const pass = document.querySelector('.password');
const email = document.querySelector('.email');
const confirm_email = document.querySelector('.confirm-email');
const fathers_name = document.querySelector('.fathers-name');
const name = document.querySelector('.name');
const surname = document.querySelector('.surname');

function checkPassword(event){
    
    var password = document.getElementById('password').value;
    submitOK = "true";
    if( password.length < 10){
        document.getElementById('password-valid').innerHTML = "Пароль должен содержать больше 10 символов";
        document.getElementById('password-valid').style.color = "red";
        document.getElementById('cross-password').style.opacity = 1;
        document.getElementById('tick-password').style.opacity = 0;
        submitOK = "false";
    }
    if( password.length >= 10){
        document.getElementById('password-valid').innerHTML = "Норм пароль. Запомни :)";
        document.getElementById('password-valid').style.color = "green";
        document.getElementById('cross-password').style.opacity = 0;
        document.getElementById('tick-password').style.opacity = 1;
        
        document.getElementById('tick-password').style.top = "46vh";
        submitOK = "true";
    }
    if (submitOK == "false") {
        return false;
      }
      
}
pass.addEventListener('input', checkPassword);

function Email(event) {
var at = document.getElementById("email").value.indexOf("@");
var email0 = document.getElementById("email").value;
submitOK = "true";
if( email0.length < 1){
    document.getElementById('email-valid').innerHTML = "Странный Email..";
    document.getElementById('email-valid').style.color = "red";
    document.getElementById('cross-email').style.opacity = 1;
    document.getElementById('tick-email').style.opacity = 0;
    submitOK = "false";
}
if (at == -1) {
    document.getElementById('email-valid').innerHTML = "Email должен содержать @";
    document.getElementById('cross-email').style.opacity = 1;
   document.getElementById('tick-email').style.opacity = 0;
    submitOK = "false";
  }
  else{
    document.getElementById('email-valid').innerHTML = "";
    document.getElementById('cross-email').style.opacity = 0;
    document.getElementById('tick-email').style.opacity = 1;
    submitOK="true";
  }
  if (submitOK == "false") {
    return false;
  }
}
email.addEventListener('input', Email);


function EmailCheck(event) {
    var email1 = document.getElementById("email").value;
    var email2 = document.getElementById("confirm-email").value;
    submitOK = "true";
    if( email2.length === 0){
        document.getElementById('email2-valid').innerHTML = "Странный Email..";
        document.getElementById('email2-valid').style.color = "red";
        document.getElementById('cross-email2').style.opacity = 1;
        document.getElementById('tick-email2').style.opacity = 0;
        submitOK = "false";
    }
    if ( email1 !== email2 ) {
        document.getElementById('email2-valid').innerHTML = "Email должны совпадать";
        document.getElementById('email2-valid').style.color = "red";
        document.getElementById('cross-email2').style.opacity = 1;
        document.getElementById('tick-email2').style.opacity = 0;
        submitOK = "false";
      }
    if ( email1 === email2 && email2.length !== 0) {
        document.getElementById('email2-valid').innerHTML = "Получилось :)";
        document.getElementById('email2-valid').style.color = "green";
        document.getElementById('cross-email2').style.opacity = 0;
        document.getElementById('tick-email2').style.opacity = 1;
        submitOK = "true";
      }  
      if (submitOK == "false") {
        return false;
      }
    }
    confirm_email.addEventListener('input', EmailCheck);


function FathersName(event) {
        var fn = document.getElementById("fathers-name").value;
        submitOK = "true";
        if ( fn.length < 1 ) {
            document.getElementById('fn-valid').innerHTML = "Введите отчество";
            document.getElementById('cross-fn').style.opacity = 1;
            document.getElementById('tick-fn').style.opacity = 0;
            submitOK = "false";
          }
          if ( fn.length >= 1 ) {
            document.getElementById('fn-valid').innerHTML = "";
            document.getElementById('cross-fn').style.opacity = 0;
            document.getElementById('tick-fn').style.opacity = 1;
            submitOK = "true";
          }
          if (submitOK == "false") {
            return false;
          }
        }
        fathers_name.addEventListener('input', FathersName);


function Name(event) {
    var n = document.getElementById("name").value;
    submitOK = "true";
    if ( n.length < 1 ) {
        document.getElementById('name-valid').innerHTML = "Введите имя";
        document.getElementById('cross-name').style.opacity = 1;
        document.getElementById('tick-name').style.opacity = 0;
        submitOK = "false";
      }
      if ( n.length >= 1 ) {
        document.getElementById('name-valid').innerHTML = "";
        document.getElementById('cross-name').style.opacity = 0;
        document.getElementById('tick-name').style.opacity = 1;
        submitOK = "true";
      }
      if (submitOK == "false") {
        return false;
      }
    }
     name.addEventListener('input', Name);

function Surname(event) {
        var sn = document.getElementById("surname").value;
        submitOK = "true";
        if ( sn.length < 1 ) {
            document.getElementById('surname-valid').innerHTML = "Введите фамилию";
            document.getElementById('cross-surname').style.opacity = 1;
            document.getElementById('tick-surname').style.opacity = 0;
            submitOK = "false";
          }
        if ( sn.length >= 1 ) {
            document.getElementById('surname-valid').innerHTML = "";
            document.getElementById('cross-surname').style.opacity = 0;
            document.getElementById('tick-surname').style.opacity = 1;
            submitOK = "true";
          }
          if (submitOK == "false") {
            return false;
          }
        }
         surname.addEventListener('input', Surname);


         document.getElementById("login-form").addEventListener('submit',postReg);

          function postReg(e) {
              e.preventDefault();

              var surname = document.getElementById("surname").value;
              var name = document.getElementById("name").value;
              var fathersName = document.getElementById("fathers-name").value;
              var email = document.getElementById("email").value;
              var password = document.getElementById("password").value;
              var params = "surname=" + surname + "&name=" + name +"&fathersName=" + fathersName + "&email=" + email +"&password=" + password; 

              var xhr = new XMLHttpRequest();
              xhr.open('POST', 'http://localhost:8080/gym/register', true);
              xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');

              xhr.onload = function(){
                  if( (this.status == 200) && (JSON.parse(this.responseText) == true) ) {
                      window.location.href = "../Login/login.html";
                  }
                  else {
                      alert("Что-то пошло не так..");
                  }
              }

              xhr.send(params);
          }