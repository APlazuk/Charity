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

    <h2>Edytuj - Użytkownika</h2>

    <div class="container--70 mx-auto mt-5">

        <form:form cssStyle="font-size: medium" modelAttribute="editedUser"  method="post">

            <div class="form-group">
                    <form:input path="username" type="text" placeholder="Nazwa Użytkownika" /></br>
                <form:errors path="username"/>
            </div>

            <div class="form-group">
                    <form:input path="email" type="text" placeholder="Email"/></br>
                <form:errors path="email"/>
            </div>
            <div class="form-group">
                    <form:input path="firstName" type="text" placeholder="Imię"/></br>
                <form:errors path="firstName"/>
            </div>
            <div class="form-group">
                    <form:input path="lastName" type="text" placeholder="Nazwisko"/></br>
                <form:errors path="lastName"/>
            </div>
            <div class="form-group">
                <input id="password" type="password" name="password" placeholder="Hasło"/></br>
                <form:errors path="password" cssClass="error-small"/>
            </div>
            <div class="form-group">
                <input id="password2" type="password" name="password2" placeholder="Powtórz hasło"/></br>
                <form:errors path="password" cssClass="error-small"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn--without-border">Zatwierdź zmiany</button>
            </div>
        </form:form>
        <a href="/admin/users" class="btn btn--without-border">Wróc</a>

    </div>
</section>

<jsp:include page="./../templates/footer.jsp"/>

</body>
</html>
