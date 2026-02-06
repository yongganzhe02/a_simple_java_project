window.onload=function() {


//名字，大于2位,小于7位
    var name = document.getElementsByName("name")[0];
    var nameSpan = document.getElementsByName("nameSpan")[0];
    name.onblur = function () {
        var str = name.value;
        if (str.length > 6) {
            nameSpan.innerHTML = "姓名长度必须小于7位";
            nameSpan.style.color = "red";

        } else {
            if (str.length < 2) {
                nameSpan.innerHTML = "姓名长度必须大于2位";
                nameSpan.style.color = "red";
            } else {
                nameSpan.innerHTML = "正确";
                nameSpan.style.color = "green";
            }
        }

    }


//电话必须为11位数字
    var phone = document.getElementsByName("phone")[0];
    var phoneSpan = document.getElementsByName("phoneSpan")[0];
    phone.onblur = function () {


        var str = phone.value;

        if (str.length != 11) {
            phoneSpan.innerHTML = "电话长度必须为11位数字";
            phoneSpan.style.color = "red";
        } else {
            if (isNaN(str)) {
                phoneSpan.innerHTML = "电话号码必须为数字";
                phoneSpan.style.color = "red";
            } else {
                phoneSpan.innerHTML = "正确";
                phoneSpan.style.color = "green";
            }
        }

    }


//身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
    var idCard = document.getElementsByName("idCard")[0];
    var idCardSpan = document.getElementsByName("idCardSpan")[0];
    idCard.onblur = function () {
        var reg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
        var str = idCard.value;
        if (!(reg.test(str))) {
            idCardSpan.innerHTML = "身份证号码不合规范";
            idCardSpan.style.color = "red";
        } else {
            idCardSpan.innerHTML = "正确";
            idCardSpan.style.color = "green";
        }

    }




  //图片预览
    /*获取到了文件表单元素*/
    var file = document.getElementsByName("file")[0];
    /*选择文件后触发*/
    file.onchange = function () {
            /*初始化了一个文件读取对象*/
            var reader = new FileReader();
            /*读取文件数据  this.files[0] 文件表单元素选择的第一个文件 */
            reader.readAsDataURL(this.files[0]);
            /*读取的过程就相当于 加载过程 */
            /*读取完毕  预览 */
            reader.onload = function () {
                /*读取完毕 base64位数据  表示图片*/
                console.log(this.result);
                document.getElementById("preview").src = this.result;

            }
        }



}