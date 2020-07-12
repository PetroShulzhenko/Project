document.getElementById("login-form").addEventListener('submit',changePassword);

function changePassword(e) {
    e.preventDefault();

    var password = document.getElementById("newPassword").value;
    var str = window.location.search;
    var login = str.replace("?email=", "");
    var params = "newPassword=" + password + "&login=" + login;

    var xhr = new XMLHttpRequest();
    xhr.open('PUT', 'http://localhost:8080/gym/reset_password', true);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');

    xhr.onload = function(){
        if( (this.status == 200) && (JSON.parse(this.responseText) == true) ) {
            alert("Ваш пароль успешно изменен :)");
            window.location.href = "./login.html";
        }
        else {
            alert("Что-то пошло не так..");
        }
    }

    xhr.send(params);
}