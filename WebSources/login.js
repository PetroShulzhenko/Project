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
        if (this.responseText == true) {
            window.location.href = "../test/src/pages/Home.vue";
        }
        else {
            alert("Что-то пошло не так..");
        }
    }

    xhr.send(params);
}