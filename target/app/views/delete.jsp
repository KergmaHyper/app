<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="headHtml.jsp" flush="true">
        <jsp:param name="head" value="Delete product" />
    </jsp:include>



    <div class="w3-container  w3-padding">
        <div class=" w3-card-4">
            <div class="w3-padding">
                <table class="w3-gray w3-table-all w3-blue w3-padding">
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                    <tr>
                        <td>
                            <c:out value="${product.name}" />
                        </td>
                        <td>
                            <c:out value="${product.price}" />
                        </td>
                    </tr>
                </table>

                <form method="post" id="delete">
                    <input type="hidden" name="id" value="${product.id}" id="id">
                </form>

                <div style="display:inline;">
                    <button type="submit" class="w3-btn w3-green w3-round-large w3-padding" form="delete">
                        Delete
                    </button>
                </div>

                <div style="display:inline;">
                    <button class="w3-btn w3-blue w3-round-large w3-padding" onclick="location.href='./products'">
                        Products
                    </button>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footHtml.jsp" />