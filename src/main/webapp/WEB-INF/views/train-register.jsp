<%--
  Created by IntelliJ IDEA.
  User: Ohyoonseul
  Date: 26. 10. 28.
  Time: 오후 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="text" name="trainNumber" placeholder="기차번호 입력" onkeyup="handleOnChange(event)">
    <input type="text" name="time" placeholder="출발시간 입력" onkeyup="handleOnChange(event)">
    <button onclick="handleRegisterButtonOnClick()">등록</button>
</body>

    <script>

        let train = {
            trainNumber: "",
            time: "",
        }

        function handleOnChange(e) {
            const name = e.target.name;
            const value = e.target.value;

            train = {
                ...train,
                [name]: value,
            }
        }

        async function handleRegisterButtonOnClick(e) { // 요청
            const response = await fetch("http://192.168.2.4:8080/api/trains", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(train)
            })

            const responseJson = await response.json() // 응답
            console.log(responseJson)
        }

    </script>
</html>
