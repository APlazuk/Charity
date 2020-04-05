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

<section>

    <section class="steps" id="steps">
        <h2>Panel Administartora</h2>

        <div class="steps--container">
            <div class="steps--item">
                <span class="icon icon--glasses"></span>
                <h3>Instytucje</h3>
                <div class="form-group form-group--buttons">
                    <a href="/admin/institutions" type="button" class="btn btn--without-border" >Zarządzaj instytucjami</a>
                </div>
            </div>
            <div class="steps--item">
                <span class="icon icon--gear"></span>
                <h3>Administratorzy</h3>
                <div class="form-group form-group--buttons">
                    <a href="/admin/admins" type="button" class="btn btn--without-border" >Zarządzaj administratorami</a>
                </div>
            </div>
            <div class="steps--item">
                <span class="icon icon--courier"></span>
                <h3>Użytkownicy</h3>
                <div class="form-group form-group--buttons">
                    <a href="/admin/users" type="button" class="btn btn--without-border" >Zarządzaj użytkownikami</a>
                </div>
            </div>
        </div>
</section>



<jsp:include page="./../templates/footer.jsp"/>
</body>
</html>