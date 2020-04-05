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

    <h2>Panel Administartora - Administratorzy</h2>

    <div class="container--70 mx-auto mt-5">

        <table class="table text-left" style="font-size: medium">
            <thead class="thead-light" style="font-size: large">
            <th>Nazwa użytkownika</th>
            <th>E-mail</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Status</th>
            <th colspan="2"></th>
            </thead>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>
                        <c:if test="${user.active = true}">
                            <em>Aktywny</em>
                        </c:if>
                        <c:if test="${user.active = false}">
                            <em>Nieaktywny</em>
                        </c:if>
                    </td>
                    <td><a href="/admin/addUserAsAdmin/${user.id}" class="btn--small btn--without-border btn--highlighted">Dodaj do listy administratorów</a></td>
                </tr>

            </c:forEach>
        </table>
    </div>

    <br/>
    <a href="/admin/admins" class="btn btn--without-border">Wróc</a>
</section>

<jsp:include page="./../templates/footer.jsp"/>
</body>
</html>