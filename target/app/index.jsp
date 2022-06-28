<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="views/headHtml.jsp" flush="true">
        <jsp:param name="head" value="Manage product pages" />
    </jsp:include>

    <!-- <%-- <a href="./products">products</a> --%> -->


    <!-- <div class="w3-container w3-grey w3-opacity w3-right-align">
    <h3>manage product pages</h3>
</div> -->


    <div class="w3-container w3-center">
        <div class="w3-bar w3-padding-24">
            <div><button class="w3-btn w3-blue w3-hover-light-blue w3-round-large"
                    onclick="location.href='./products'">Products</button></div>
            <!-- <%-- <div><button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='./add'">Add user</button></div>
    <div><button class="w3-btn w3-hover-red w3-round-large" onclick="location.href='./list'">List users</button></div>
    <div><button class="w3-btn w3-hover-yellow w3-round-large" onclick="location.href='./set'">Set coockie user</button></div>
    <div><button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='./products'">products</button></div>
     --%> -->
        </div>
    </div>





    <jsp:include page="views/footHtml.jsp" flush="true" />