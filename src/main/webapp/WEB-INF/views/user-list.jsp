<%@ page import="java.util.List" %>
<%@ page import="com.korai.servletstudy2.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Ohyoonseul
  Date: 26. 10. 26.
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<User> userList = (List<User>) request.getAttribute("userList"); // 다운캐스팅 (set 할 때 오브젝트로 업캐스팅 해서)
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
        }
        </style>
    </style>
</head>
<body>
    <button onclick="location.href='http://localhost:8080/user/register'">등록</button>
    <div>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>사용자이름</th>
                    <th>비밀번호</th>
                    <th>성명</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // 스크립틀릿 (자바 코드를 쓸 수 있는 공간)
                    for (User user : userList) {
                %>
                    <tr>
                        <td><%=user.getId()%></td>
                        <td><%=user.getUsername()%></td>
                        <td><%=user.getPassword()%></td>
                        <td><%=user.getName()%></td>
                    </tr>
                <%
                    } // 자바 코드는 무조건 <
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
