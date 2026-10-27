<%@ page import="java.util.List" %>
<%@ page import="com.korai.servletstudy2.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Ohyoonseul
  Date: 26. 10. 26.
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.

  전달받은 회원 리스트를 반복문으로 순회하여 HTML 테이블 형태로 렌더링함
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // UserListController가 request 객체에 보관해 둔 userList를 추출함
    List<User> userList = (List<User>) request.getAttribute("userList"); // getAttribute는 Object 타입을 반환, set 할 때 오브젝트로 업캐스팅 해서 List<User>로 다운캐스팅
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
<body> <%--클릭하면 다시 회원가입 페이지(user/register)로 이동시키는 단순 버튼 링크--%>
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
                    // 가져온 유저 리스트의 크기만큼 HTML <tr> 행을 반복 생성하기 위해 for문 사용
                    for (User user : userList) {
                %>
                    <tr> <%--반복 중인 User 객체의 Getter 메서드를 호출--%>
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
