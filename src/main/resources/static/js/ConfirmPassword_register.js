function checkPassword(){
    var password =  document.getElementById("password").value;
    var password_confirm = document.getElementById("password-confirm").value;

    var notifyError = document.querySelectorAll(".notify");

    if(password !== password_confirm){
        for(var i = 0; i < notifyError.length ; i++) {
            notifyError[i].innerText = "Password incorrect!";
        }
    }else{
        for(var i = 0; i < notifyError.length ; i++) {
            notifyError[i].innerText = "";
        }
    }
    for(var i = 0; i < notifyError.length ; i++) {
        notifyError[i].innerText = "";
    }
}