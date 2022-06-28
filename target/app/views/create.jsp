<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="headHtml.jsp" flush="true">
        <jsp:param name="head" value="Create product" />
    </jsp:include>

    <div class="w3-bar w3-padding-24">
        <div>
            <button class="w3-btn w3-blue w3-hover-light-blue w3-round-large"
                onclick="location.href='./products'">Products</button>
        </div>
    </div>

     <jsp:include page="footHtml.jsp" />