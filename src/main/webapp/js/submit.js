// function beforeSubmit(form) {
//
//     if (form.name.value == '') {
//         alert('姓名不能为空！');
//         form.name.focus();
//         return false;
//     }
//
//     if (form.phone.value == '') {
//         alert('电话号码不能为空！');
//         form.phone.focus();
//         return false;
//     }
//
//     if (form.idCard.value == '') {
//         alert('身份证号不能为空！');
//         form.idCard.focus();
//         return false;
//     }
//
//
//     if (form.name.value.length > 6 || form.name.value.length < 2) {
//         alert("姓名长度必须大于2位小于7位!");
//         form.name.focus();
//         return false;
//     }
//
//     if (isNaN(form.phone.value) || form.phone.value.length != 11) {
//         alert("电话长度必须为11位,且全为数字");
//         form.phone.focus();
//         return false;
//     }
//
//     var reg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
//     if (!(reg.test(form.idCard.value))) {
//         alert("身份证号码不合规范!");
//         form.idCard.focus();
//         return false;
//     }
//
//     return true;
// }


function resetSpan() {

    var idCardSpan = document.getElementsByName("idCardSpan")[0];
    var nameSpan = document.getElementsByName("nameSpan")[0];
    var phoneSpan = document.getElementsByName("phoneSpan")[0];
    idCardSpan.innerHTML = "";
    nameSpan.innerHTML = "";
    phoneSpan.innerHTML = "";
}