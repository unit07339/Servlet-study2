<%--
  Created by IntelliJ IDEA.
  User: Ohyoonseul
  Date: 26. 10. 26.
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" onSubmit="handleOnsubmit(event)">
        <div>
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
            const value = event.target.value;
            user = {
                ...user,
                [name]: value,     // [username]: 값
            };

            console.log(user);
        }

        async function registerApi(data) {
            const jsonData = JSON.stringify(data);   // 공통언어
            const response = await fetch("http://localhost:8080/api/users", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: jsonData,    // 주 데이터
            });
            console.log(response);

            const responseBody = await response.json();
            console.log(responseBody);
            alert(responseBody.message);

            if (response.status !== 200) {
                return;
            }

            location.replace("/user/list");  // replace 페이지 이동

        }


        function handleOnsubmit(event) {
            event.preventDefault();        // submit 기능 없애줌
            registerApi(user);
        }
    </script>
</body>
</html>
