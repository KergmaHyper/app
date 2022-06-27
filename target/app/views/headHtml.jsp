<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="./styles/w3.css">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><c:out value="${param.head}" default="App"/></title>
</head>

<body class="w3-light-grey">
    <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
        <h2><c:out value="${param.head}" default="App"/></h2>
    </div>
    <div class="w3-container w3-padding">
