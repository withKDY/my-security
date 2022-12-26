const err = location.href;
console.log("err: ", err);

if (err.includes("errMsg")) {
    let errText = err.split("?");
    errText[errText.length - 1].includes("password")
        ? err_text.classList.add("on")
        : err_text.classList.remove("on");

    let errText2 = err.split("?");
    errText2[errText2.length - 1].includes("userID")
        ? err_text2.classList.add("on")
        : err_text2.classList.remove("on");

    let errText3 = err.split("?");
    errText3[errText3.length - 1].includes("disabled")
        ? err_text3.classList.add("on")
        : err_text3.classList.remove("on");
}

function logoutFuc() {
    sessionStorage.removeItem('navIndex');
}