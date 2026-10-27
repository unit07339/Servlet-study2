<%--
  Created by IntelliJ IDEA.
  User: Ohyoonseul
  Date: 26. 10. 27.
  Time: 오후 3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input placeholder="상품명" onkeyup="handleProductNameInputOnKeyUp(event)">
    <input placeholder="가격" onkeyup="handlePriceInputOnKeyUp(event)">
    <button onclick="handleRegisterButtonOnClick(event)">등록</button>

    <script> //자바스크립트 코드 적는 곳
        let product = {
            productName: "",
            price: 0,
        }

        function handleProductNameInputOnKeyUp(e) {
            console.log(e.target.value);
            product = {
                ...product,
                productName: e.target.value,
            }
        }

        function handlePriceInputOnKeyUp(e) {
            console.log(e.target.value);
            product = {
                ...product,
                price: e.target.value,
            }
        }

        function handleRegisterButtonOnClick(e) { // 함수명 handle + 구체적으로

            console.log(JSON.stringify(product));

            fetch("http://localhost:8080/api/products", {
                method: "POST",
                body: JSON.stringify(product), // product가 자바스크립트 문법이라서
                headers: {
                    'Content-Type': 'application/json',
                }
            }); // fetch 요청날리는 기능 POST 생성하는 기능(등록)
        }
    </script>

</body>
</html>
