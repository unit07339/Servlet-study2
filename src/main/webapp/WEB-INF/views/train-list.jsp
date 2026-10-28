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
    <style>
        table {
            border: 1px solid #DDE36D;
            /*border-collapse: collapse;*/
        }
        th, td {
            border: 1px solid #DDE36D;
            width: 200px;
            height: 40px;

        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>기차번호</th>
                <th>출발시간</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>

</body>

<script>
    async function getTrainList(e) { // 리스트 요청
        const response = await fetch("http://192.168.2.4:8080/api/trains", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            }
        });
        const responseJson = await response.json(); // 응답
        console.log(responseJson);

        const tbody = document.querySelector('tbody');
        tbody.innerHTML = responseJson.map((train, index) => (
             `
                <tr>
                    <td>\${index + 1}</td>
                    <td>\${train.trainNumber}</td>
                    <td>\${train.time}</td>
                </tr>
              `
        )).join("");
    }
    getTrainList();

</script>
</html>
