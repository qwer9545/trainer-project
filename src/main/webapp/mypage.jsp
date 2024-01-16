<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglibprefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@pagecontentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kakao Login Example</title>
    <!-- 카카오 SDK 추가 -->
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
</head>
<body>
    <div>
        <h1>로그인</h1>
        <a href="javascript:kakaoLogin()"><img src="/images/kakao_login.png"> style="width: 200px"></a>
        <button>카카오 계정으로 로그인</button>
    </div>
   <!-- JavaScript 코드 -->
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
    Kakao.init('99b4852510033be3764165ffeaf1fbbe');
    console.log(kakao.isInitialized() );

       // 카카오 로그인 버튼 클릭 시 실행될 함수
        document.getElementById('kakao-login-btn').addEventListener('click', function() {
            Kakao.Auth.login({
                success: function(authObj) {
                    alert('로그인 성공\n' + JSON.stringify(authObj));
                },
                fail: function(err) {
                    alert('로그인 실패\n' + JSON.stringify(err));
                }
            });
        });
    </script>

<!-- 
    function kakaoLogin() {
        Kakao.Auth.login({
            success: function (response) {
                Kakao.API.request({
                    url: '/v2/user/me',
                    success: function (response) {
                        alert(JSON.stringify(response))
                    },
                    fail: function (error) {
                        alert(JSON.stringify(error))
                    },
                })
            },
            fail: function (error) {
                alert(JSON.stringify(error))
            },
        })
    }
</script> -->
</body>
</html>