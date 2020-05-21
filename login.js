document.getElementById("login-form").addEventListener('submit',postLogin);

function postLogin(e) {
    e.preventDefault();

    var login = document.getElementById("login").value;
    var password = document.getElementById("password").value;
    var params = "login=" + login + "&password=" + password; 

    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'SERVER FILE HERE !!!!!!', true);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');

    xhr.onload = function(){
        if( (this.status == 200) && (JSON.parse(this.responseText) == true) ) {
            window.location.href = "../test/src/pages/Home.vue";
        }
        else {
            alert("Что-то пошло не так..");
        }
    }

    xhr.send(params);
}

document.getElementById("forgot-password").addEventListener('click',forgotPassword);

function forgotPassword(e) {
    e.preventDefault();

    var login = document.getElementById("login").value;
    var params = "login=" + login; 

    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'SERVER FILE HERE !!!!!!', true);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');

    xhr.onload = function(){
        if( (this.status == 200) && (JSON.parse(this.responseText) == true) ) {
            alert("На ваш Email отправлено письмо :)");
        }
        else {
            alert("Что-то пошло не так..");
        }
    }

    xhr.send(params);
}