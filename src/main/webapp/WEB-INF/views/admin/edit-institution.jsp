<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<jsp:include page="./../templates/head.jsp">
    <jsp:param name="title" value="Oddam w dobre ręce"/>
</jsp:include>

<body>

<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj ${username}
                <ul class="dropdown">
                    <li><a href="#">Profil</a></li>
                    <li><a href="#">Moje zbiórki</a></li>
                    <li>
                        <form:form action="/logout" method="post">
                            <input class="btn btn--without-border" type="submit" value="Wyloguj">
                        </form:form></li>
                </ul>
            </li>
        </ul>
    </nav>
</header>

<section class="steps" id="steps">

    <h2>Edytuj - Instytucje</h2>

    <div class="container--70 mx-auto mt-5">

        <form:form cssStyle="font-size: medium" modelAttribute="editedInstitution" method="post">

            <div class="form-group">
                <form:input path="name" type="text" placeholder="Nazwa Fundacji"/></br>
                <form:errors path="name"/>
            </div>

            <div class="form-group">
                <form:input path="description" type="text" placeholder="Cel i misja"/></br>
                <form:errors path="description"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn--without-border">Zatwierdź zmiany</button>
            </div>
        </form:form>
        <a href="/admin" class="btn btn--without-border">Wróc</a>
    </div>
</section>

<jsp:include page="./../templates/footer.jsp"/>

</body>
</html>
