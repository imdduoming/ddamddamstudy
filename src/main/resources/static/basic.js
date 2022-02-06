$(document).ready(function(){
    // 아이디 중복 검사
    $('#btncheckId').click(function(event){
        // id가 id인 input 태그에서 값 가져오기
        let id=$('#id').val();

        // id 입력란이 비어있으면 alert 후 중단
        if(id==""){
            alert("아이디 입력하쇼");
            return ;
        }

        // 중복 검사
        $.ajax({
            type: "POST",
            url: '/user/userIdChk',
            dataType:"JSON",
            data: JSON.stringify({id:id}),
            success: function (response) {
                if(response=="success"){
                    alert("사용 가능");
                    $('#check').attr('value', 'yes');
                } else{
                    alert("중복 아이디");
                    $('#check').attr('value', 'no');
                    return ;
                }
                return false;
            }
        });
    });

    // submit 전 유효성 검사
    $('#login-id-submit').click(function (event){
        let password=$('#pw').val();
        let checkPassword = $('#chkpw').val();

        if($('#id').val() == "") {
            alert("아이디를 입력하세요.");
            return false;
        }

        if($('#pw').val() == "") {
            alert("비밀번호를 입력하세요.");
            return false;
        }

        if($('#chkpw').val() == "") {
            alert("비번 확인");
            return false;
        }

        if($('#e-mail').val() == "") {
            alert("이메일을 입력하세요.");
            return false;
        }

        if($('#nick').val() == "") {
            alert("별명을 입력하세요.");
            return false;
        }

        if($('#check').val() == 'no') {
            alert("아이디 중복 체크 해라!");
            return false;
        }

        if(password != checkPassword) {
            alert("비밀번호를 확인하세요.");
            return false;
        }

        return true;
    });
});


function onclickAdmin() {
    // Get the checkbox
    var checkBox = document.getElementById("admin-check");
    // Get the output text
    var box = document.getElementById("admin-token");
    // If the checkbox is checked, display the output text
    if (checkBox.checked == true){
        box.style.display = "block";
    } else {
        box.style.display = "none";
    }
}