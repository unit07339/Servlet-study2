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





















<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <!-- JSP 문서 설정: HTML 타입 및 UTF-8 인코딩 -->
     <html>
     <head>
         <title>도서 등록</title> <!-- 웹 브라우저 탭 제목 -->
     </head>
     <body>
         <!-- form 제출 시 handleOnsubmit 자바스크립트 함수가 실행되도록 설정 -->
         <form method="post" onSubmit="handleOnsubmit(event)">
             <div>
                 <!-- 도서명 입력창: 키를 뗄 때마다 handleOnChange 함수 실행 -->
                 <input type="text" name="bookName" placeholder="도서명" onkeyup="handleOnChange(event)">
             </div>
             <div>
                 <!-- 가격 입력창: 키를 뗄 때마다 handleOnChange 함수 실행 -->
                 <input type="number" name="price" placeholder="가격" onkeyup="handleOnChange(event)">
             </div>
             <!-- 서브밋 버튼 -->
             <button type="submit">등록하기</button>
         </form>

         <script>
             // 서버에 전송할 입력 데이터를 담아둘 자바스크립트 객체
             let book = {
                 bookName: "", // 도서명 초기값
                 price: 0,     // 가격 초기값
             };

             // 입력창 값이 변경될 때마다 호출되는 함수
             function handleOnChange(event) {
                 const name = event.target.name; // 이벤트를 발생시킨 input 태그의 name 속성값 ("bookName" 또는 "price")
                 const value = event.target.value; // 사용자가 입력한 실제 문자열 값
                 book = {
                     ...book, // 기존 book 객체 복사 (불변성 유지)
                     [name]: value, // 이벤트를 발생시킨 input의 name을 키로 사용해 value 업데이트
                 };
                 console.log(book); // 콘솔에 현재 입력 객체 출력
             }

             // 백엔드 REST API 서블릿과 비동기 통신하는 함수
             async function registerApi(data) {
                 const jsonData = JSON.stringify(data); // JS 객체를 JSON 문자열 텍스트로 변환

                 // fetch()로 백엔드의 /api/books (BookApiController)에 POST 방식으로 데이터를 전송
                 const response = await fetch("http://localhost:8080/api/books", {
                     method: "POST", // HTTP 요청 메서드를 POST로 지정
                     headers: {
                         "Content-Type": "application/json" // 보낼 데이터 종류가 JSON 데이터임을 알림
                     },
                     body: jsonData // 실제로 보낼 JSON 데이터 바디
                 });

                 const responseBody = await response.json(); // 서버에서 응답받은 JSON 데이터를 해석하여 JS 객체로 변환
                 alert(responseBody.message); // 서버가 전송해 준 메시지("도서 등록 성공" 등)를 팝업창으로 띄움

                 if (response.status !== 200) { // HTTP 응답 상태 코드가 200(성공)이 아니면
                     return; // 함수를 중단하고 그대로 유지
                 }

                 location.replace("/book/list"); // 성공했을 경우 목록 페이지(/book/list)로 페이지를 전환
             }

             // 폼 제출(등록하기 버튼 클릭) 시 작동하는 함수
             function handleOnsubmit(event) {
                 event.preventDefault(); // form의 기본 동작(페이지가 통째로 새로고침 되는 기능)을 방지함
                 registerApi(book); // API 전송 함수 호출
             }
         </script>
     </body>
     </html>
     --%>