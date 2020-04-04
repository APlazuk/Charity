<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">

<jsp:include page="templates/head.jsp">
  <jsp:param name="title" value="Oddam w dobre ręce"/>
</jsp:include>

<body>
<jsp:include page="templates/header.jsp"/>

    <section class="login-page">
      <h2>Załóż konto</h2>

        <form:form id="registration-form" modelAttribute="registrationUserData" action="/registration" method="post">
          <div class="form-group">
            <input type="text" name="username" placeholder="Nazwa użytkowika"/></br>
            <form:errors path="username" cssClass="error-small"/>
          </div>
          <div class="form-group">
            <input type="text" name="firstName" placeholder="Imię"/></br>
            <form:errors path="firstName" cssClass="error-small"/>

          </div>
          <div class="form-group">
            <input type="text" name="lastName" placeholder="Nazwisko"/></br>
            <form:errors path="lastName" cssClass="error-small"/>
          </div>
          <div class="form-group">
            <input type="text" name="email" placeholder="Email"/></br>
            <form:errors path="email" cssClass="error-small"/>
          </div>
          <div class="form-group">
            <input id="password" type="password" name="password" placeholder="Hasło"/></br>
            <form:errors path="password" cssClass="error-small"/>
          </div>
          <div class="form-group">
            <input id="password2" type="password" name="password2" placeholder="Powtórz hasło"/></br>
            <form:errors path="password" cssClass="error-small"/>
          </div>

          <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
          </div>
          <security:csrfInput/>
        </form:form>
    </section>

    <jsp:include page="templates/footer.jsp"/>

  </body>
</html>
