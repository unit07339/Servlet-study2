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






















<%--
<%@ page import="java.util.List" %> <!-- 자바의 List 클래스 사용을 위한 import -->
<%@ page import="com.korai.servletstudy2.model.Book" %> <!-- 우리가 만든 Book 모델 클래스 import -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <!-- JSP 인코딩 지정 -->

<%
    // 컨트롤러(BookListController)에서 req.setAttribute("bookList", ...)로 보낸 데이터를 꺼냅니다.
    // Object 타입으로 들어오므로 원래 타입인 List<Book>으로 다운캐스팅(형변환) 합니다.
    List<Book> bookList = (List<Book>) request.getAttribute("bookList");
%>

<html>
<head>
    <title>도서 목록</title>
    <style>
        /* HTML 표 테두리 스타일 지정 */
        table {
            border: 1px solid #222;
            border-collapse: collapse;
        }

        /* 표 내부 셀 스타일 지정 */
        th, td {
            border: 1px solid #222;
            width: 300px;
            height: 40px;
            text-align: center;
        }
    </style>
</head>
<body>
    <!-- 등록 페이지(/book/register)로 이동하는 버튼 -->
    <button onclick="location.href='http://localhost:8080/book/register'">등록</button>
    <div>
        <table>
            <thead>
                <tr>
                    <th>번호</th> <!-- 테이블 헤더: 번호 컬럼 -->
                    <th>도서명</th> <!-- 테이블 헤더: 도서명 컬럼 -->
                    <th>가격</th> <!-- 테이블 헤더: 가격 컬럼 -->
                </tr>
            </thead>
            <tbody>
                <%
                    // 스크립틀릿(자바 코드 사용 영역): bookList가 null이 아닐 때만 반복문 실행
                    if (bookList != null) {
                        for (Book book : bookList) { // 도서 목록 개수만큼 하나씩 반복
                %>
                    <tr>
                        <!-- 표현식 <%= %> : 자바 변수의 값을 HTML 문서에 직접 출력합니다. -->
                        <td><%=book.getId()%></td> <!-- 도서 ID 출력 -->
                        <td><%=book.getBookName()%></td> <!-- 도서명 출력 -->
                        <td><%=book.getPrice()%>원</td> <!-- 가격 출력 -->
                    </tr>
                <%
                        } // for문 종료
                    } // if문 종료
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
--%>