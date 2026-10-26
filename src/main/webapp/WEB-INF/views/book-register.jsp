<%--
  Created by IntelliJ IDEA.
  User: Ohyoonseul
  Date: 26. 10. 26.
  Time: 오후 4:50
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
            <input type="text" name="bookName" placeholder="도서명" onkeyup="handleOnChange(event)">
        </div>
        <div>
            <input type="number" name="price" placeholder="가격" onkeyup="handleOnChange(event)">
        </div>
        <button type="submit">등록하기</button>
    </form>

    <script>
        let book = {
            bookName: "",
            price: 0,
        };

        function handleOnChange(event) {
        const name = event.target.name;
        const value =event.target.value;
        book = {
            ...book,
            [name]: value,
        };
        console.log(book);
    }

    async function registerApi(data) {
        const jsonData = JSON.stringify(data);
        const response = await fetch("http://localhost:8080/api/books", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: jsonData
        });

        const responseBody = await response.json();
        alert(responseBody.message);

        if (response.status != 200) {
            return;
        }

        location.replace("/book/list");
    }

    function handleOnsubmit(event) {
        event.preventDefault();
        registerApi(book);
    }
    </script>
</body>
</html>
