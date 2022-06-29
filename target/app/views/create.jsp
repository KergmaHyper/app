<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="headHtml.jsp" flush="true">
        <jsp:param name="head" value="Create product" />
    </jsp:include>



    <div class="w3-container w3-padding">
        <div class="w3-card-4">
            <form method="post" action="<c:url value='/create'/>" class="w3-selection w3-light-grey w3-padding">
                <!-- <div><input type="hidden" name="id" id="id" value="${product.id}"><br><br></div> -->

                <div><label for="name">Product name:</label></div>
                <div><input type="text" name="name" id="name" value="${product.name}"
                        class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br><br>
                </div>
                <div><label for="price">Price:</label></div>
                <div><input type="text" name="price" id="price" value="${product.price}"
                        class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br><br>
                </div>

                <div style="display:inline;">
                    <button type="submit" class="w3-btn w3-green w3-round-large ">
                        Insert
                    </button>
                </div>

                <div style="display:inline;">
                    <button class="w3-btn w3-blue w3-round-large" onclick="location.href='./products'" formmethod="get"
                        formaction="<c:url value='/products'/>" form="empty">
                        Products
                    </button>
                </div>

            </form>
            <form id="empty"/>
        </div>
    </div>

    <!-- <div class="w3-bar w3-padding-24">
        <div>
            <button class="w3-btn w3-blue w3-hover-light-blue w3-round-large"
                onclick="location.href='./products'">Products</button>
        </div>
    </div> -->

    <jsp:include page="footHtml.jsp" />