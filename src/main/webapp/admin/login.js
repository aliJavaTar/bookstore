let btnLogin = document.getElementById('do-login');
let idLogin = document.getElementById('login');
let username = document.getElementById('username');
btnLogin.onclick = function () {
    idLogin.innerHTML = '<p>We\'re happy to see you again, </p><h1>' + username.value + '</h1>';
}