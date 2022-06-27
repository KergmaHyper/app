     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<jsp:include page="headHtml.jsp" flush="true">
    <jsp:param name="head" value="Products page"/>
</jsp:include>

<div class="w3-container w3-center">

<table class="w3-gray w3-table-all w3-blue w3-padding">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
</tr>
<div class="w3-bordered">
<c:forEach var="product" items="${products}">
<tr>
    <td><c:out value="${product.id}"/></td>
    <td><c:out value="${product.name}"/></td>
    <td><c:out value="${product.price}"/></td>
 </tr>   
</c:forEach>
</div>
</table>
</div>

<jsp:include page="footHtml.jsp" />
