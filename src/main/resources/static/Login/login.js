document.getElementById("login-form").addEventListener('submit',postLogin);

function postLogin(e) {
    e.preventDefault();

    var login = document.getElementById("login").value;
    var password = document.getElementById("password").value;
    var params = "login=" + login + "&password=" + password; 

    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/gym/login', true);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');

    xhr.onload = function(){
        if( (this.status == 200) && (JSON.parse(this.responseText) == true) ) {
            window.location.href = "http://localhost:8090";
        }
        else {
            alert("Что-то пошло не так..");
        }
    }

    xhr.send(params);
}

