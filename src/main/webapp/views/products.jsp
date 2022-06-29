<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="headHtml.jsp" flush="true">
        <jsp:param name="head" value="Products page" />
    </jsp:include>

    <div class="w3-container w3-center">

        <div style="display:inline;">
            <table class="w3-gray w3-table-all w3-blue w3-padding">
                <tr>
                    <!-- <th>ID</th> -->
                    <th>Name</th>
                    <th>Price</th>
                    <th>
                        <!-- Action -->
                        <button class="w3-btn w3-blue w3-round-large "
                            onclick="location.href='./create'">create</button>
                    </th>
                </tr>
                <div class="w3-bordered">
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <!-- <td>
                                <c:out value="${product.id}" />
                            </td> -->
                            <td>
                                <a href="<c:url value='/edit?id=${product.id}' />">
                                    <c:out value="${product.name}" />
                                </a>
                            </td>
                            <td>
                                <c:out value="${product.price}" />
                            </td>
                            <td>
                                <!-- <form method="get" action="<c:url value='/edit?id=${product.id}' />"
                                    style="display:inline;">
                                    <input type="hidden" name="id" value="${product.id}" />
                                    <div style="display:inline;">
                                        <button type="submit" class="w3-btn w3-yellow w3-round-large ">edit</button>
                                    </div>
                                </form> -->
                                <form method="POST" action="<c:url value='/delete'/>" style="display:inline;">
                                    <input type="hidden" name="id" value="${product.id}" />
                                    <div style="display:inline;">
                                        <button type="submit" class="w3-btn w3-green w3-round-large ">delete</button>
                                    </div>
                                </form>

                            </td>
                        </tr>
                    </c:forEach>
                </div>
            </table>
        </div>
    </div>

    <jsp:include page="footHtml.jsp" />