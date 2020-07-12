document.getElementById("login-form").addEventListener('submit',forgotPassword);

function forgotPassword(e) {
    e.preventDefault();

    var login = document.getElementById("login").value;
    var params = "login=" + login; 

    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/gym/reset_password', true);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');

    xhr.onload = function(){
        if( JSON.parse(this.responseText) == true ) {
            alert("На ваш Email отправлено письмо :)");
        }
        else {
            alert("Что-то пошло не так..");
        }
    }

    xhr.send(params);
}