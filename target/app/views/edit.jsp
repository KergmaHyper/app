<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="headHtml.jsp" flush="true">
        <jsp:param name="head" value="Edit product" />
    </jsp:include>

    <p>
        <c:out value="${product.id}" />
    </p>
    <p>
        <c:out value="${product.name}" />
    </p>
    <p>
        <c:out value="${product.price}" />
    </p>






    <div class="w3-bar w3-padding-24">
        <div>
            <button class="w3-btn w3-blue w3-hover-light-blue w3-round-large"
                onclick="location.href='./products'">Products</button>
        </div>
    </div>

    <jsp:include page="footHtml.jsp" />