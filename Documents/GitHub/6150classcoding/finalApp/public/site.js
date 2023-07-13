let subMenuOpen = false;
const menuButton = document.getElementById("menu_button")

menuButton.addEventListener("click", function () {
  let a = document.getElementById("submenu");
  if (subMenuOpen) {
    a.style.visibility = "hidden";
    // a.style.display = "none";
    subMenuOpen = false;
  } else {
    a.style.visibility = "visible";
    subMenuOpen = true;
  }
});
addEventListener("click", function (e) {
  if (e.target.id != "button_img") {
    this.document.getElementById("submenu").style.visibility = "hidden";
    subMenuOpen = false;
  }
});

const subscribe = document.querySelectorAll(".open_subscribe");
const modal = document.querySelector(".modal");
const close = document.querySelector(".close_subscribe");
function addEventListenerForSubscribe(list){
    for(let i = 0; i < subscribe.length; i++){
        subscribe[i].addEventListener("click", function(e){
            console.log(e.target);
            modal.showModal();
        });
    }
}
addEventListenerForSubscribe(subscribe);
function closeModal(e){
    modal.close();
}

// check the register form
function checkSubmission(e) {
    checkEmail(e)
    checkConfirm(e)
  };
  
function checkEmail(e){
    try{
        const emailInput = document.getElementById("emailInput")
        const emailErrorMessage = document.getElementById("emailErrorMessage")
        // const reg = /^([a-zA-Z0-9_-]) + @([a-zA-Z0-9_-]) + (.[a-zA-Z0-0_-]) + /;
        const reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
        
        if(emailInput.value == ""){
            e.preventDefault();
            emailErrorMessage.innerText = "Email is required";
        }else if(!reg.test(emailInput.value)){
            console.log(emailInput.value)
            e.preventDefault();
            emailErrorMessage.innerText = "Email format invalid";
        }else{
            emailErrorMessage.innerText = ""
        }
    }catch(error){
        console.log(error);
    }
    
}
function checkConfirm(e){
const confirmInput = document.getElementById("confirmInput")
const confirmErrorMessage = document.getElementById("confirmErrorMessage")
const emailInput = document.getElementById("emailInput")
if(confirmInput.value == "" || emailInput.value == "" || confirmInput.value != emailInput.value){
    e.preventDefault();
    confirmErrorMessage.innerText = "Email not matched"
}else{
    confirmErrorMessage.innerText = ""
}
}


