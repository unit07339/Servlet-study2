<%--
  Created by IntelliJ IDEA.
  User: Ohyoonseul
  Date: 26. 10. 26.
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.

  입력 양식을 화면과 JacaScript fetch 를 이용해 백엔드 API로 가입 데이터를 비동기 전송(JSON) 함
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body> <%--양식을 제출할 때 기본 Form전송 대신 자바스크립트 함수를 실행하도록 연결--%>
    <form method="post" onSubmit="handleOnsubmit(event)">
        <div> <%--input 태그에서 키보드를 뗄 때마다 해당 입력값을 실시간으로 자바스크립트 객체에 반영--%>
            <input type="text" name="username" placeholder="사용자이름" onkeyup="handleOnChange(event)">
        </div>
        <div>
            <input type="password" name="password" placeholder="비밀번호" onkeyup="handleOnChange(event)">
        </div>
        <div>
            <input type="text" name="name" placeholder="이름" onkeyup="handleOnChange(event)">
        </div>
        <button type="submit">등록하기</button>
    </form>

    <script>
        let user = {
            username: "",
            password: "",
            name: "",
        }

        function handleOnChange(event) {
            const name = event.target.name;    // 첫 번째 target은 username
            const value = event.target.value; // 이벤트를 일으킨 input 태그의 name 속성값(username, password, name)과 실제 입력된 텍스트(value)를 동적으로 추출
            user = {
                ...user,
                [name]: value,     // [username]: 값
            }; // 기존 user 객체의 나머지 값은 유지하면서 현재 타이핑 중인 필드의 값만 덮어쓰기 위해 작성

            console.log(user);
        }

        async function registerApi(data) {
            const jsonData = JSON.stringify(data);   // 공통언어, 객체를 JSON 문자열로 변환
            const response = await fetch("http://localhost:8080/api/users", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: jsonData,    // 주 데이터
            }); // REST API 백엔드 서블릿으로 비동기 HTTP POST 요청 전송, "Content-Type": "application/json"를 헤더에 지정하여 우리가 보내는 데이터가 JSON 파일이다 라고 서버에 알려줌
            console.log(response);

            const responseBody = await response.json();
            console.log(responseBody);
            alert(responseBody.message); // 백엔드(UserApiController)에서 응답해준 성공/실패 JSON 메시지를 팝업 창으로 노출함

            if (response.status !== 200) {
                return;
            }

            location.replace("/user/list");  // replace 페이지 이동
            // 백엔드 응답 상태코드가 200(성공)인 경우에만 사용자 목록 페이지로 화면을 전환(이동)함
        }


        function handleOnsubmit(event) {
            event.preventDefault();        // submit 기능 없애줌, HTML Form의 기본 제출 동작을 막고, fetch 통신을 통해 비동기 처리
            registerApi(user);
        }
    </script>
</body>
</html>
