<%--
  Created by IntelliJ IDEA.
  User: Ohyoonseul
  Date: 26. 10. 28.
  Time: 오전 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="text" name="carNumber" placeholder="차량번호 입력" onkeyup="handleOnChange(event)"/>
    <input type="text" name="time" placeholder="입차시간 입력" onkeyup="handleOnChange(event)"/>
    <button onclick="">등록</button>
</body>

    <script>
        let car = {
            carNumber: "",
            time: "",
        }

        function handleOnChange(e) {
            const name = e.target.name;
            const value = e.target.value;

            car = {
                ...car,
                [name]: value,
            }
        }

        function handleRegisterButtonOnclick(e) {
            fetch(/*주소*/, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(car)
            }).catch(error => console.log(error));
        }



    </script>
</html>
