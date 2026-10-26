<%@ page import="java.util.List" %>
<%@ page import="com.korai.servletstudy2.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: Ohyoonseul
  Date: 26. 10. 26.
  Time: 오후 4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Book> bookList = (List<Book>) request.getAttribute("bookList");
%>

<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px solid #222;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #222;
            width: 300px;
            height: 40px;
            text-align: center;
        }
    </style>
</head>
<body>
    <button onclick="location.href='http://localhost:8080/book/register'">등록</button>
    <div>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>도서명</th>
                    <th>가격</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Book book : bookList) {
                %>
                    <tr>
                        <th><%=book.getId()%></th>
                        <th><%=book.getBookName()%></th>
                        <th><%=book.getPrice()%></th>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
