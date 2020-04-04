<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="./templates/head.jsp">
    <jsp:param name="title" value="Oddam w dobre ręce"/>
</jsp:include>

<body>
<jsp:include page="./templates/header.jsp"/>

<section class="login-page">

    <h2>Zaloguj się</h2>
    <form action="/login" method="post">
        <div class="form-group">
            <input type="text" name="username" placeholder="Nazwa użytkowika"/>
        </div>

        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło"/>

            <c:if test="${param['error'] != null}">
                <p>Logowanie nieudane. Sprawdź poprawność nazwy użytkownika i hasła.</p>
            </c:if>

<%--            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>--%>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/registration" class="btn btn--without-border">Jesteś nowy? Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
        <security:csrfInput/>
    </form>
</section>

<jsp:include page="./templates/footer.jsp"/>
</body>
</html>
