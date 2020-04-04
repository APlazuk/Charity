<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<jsp:include page="./templates/head.jsp">
  <jsp:param name="title" value="Oddam w dobre ręce"/>
</jsp:include>

<body>
    <header class="header--form-page">
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

      <div class="slogan container container--90">
        <div class="slogan--item">
          <h1>
            Oddaj rzeczy, których już nie chcesz<br />
            <span class="uppercase">potrzebującym</span>
          </h1>

          <div class="slogan--steps">
            <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
            <ul class="slogan--steps-boxes">
              <li>
                <div><em>1</em><span>Wybierz rzeczy</span></div>
              </li>
              <li>
                <div><em>2</em><span>Spakuj je w worki</span></div>
              </li>
              <li>
                <div><em>3</em><span>Wybierz fundację</span></div>
              </li>
              <li>
                <div><em>4</em><span>Zamów kuriera</span></div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </header>

    <section class="form--steps">
      <div class="form--steps-instructions">
        <div class="form--steps-container">
          <h3>Ważne!</h3>
          <p data-step="1" class="active">
            Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
            wiedzieć komu najlepiej je przekazać.
          </p>
          <p data-step="2">
            Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
            wiedzieć komu najlepiej je przekazać.
          </p>
          <p data-step="3">
           Wybierz jedną, do
            której trafi Twoja przesyłka.
          </p>
          <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
      </div>

      <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form action="/app/donation/add" method="post" id="add-donation-form" modelAttribute="donations">
          <!-- STEP 1: class .active is switching steps -->
          <div data-step="1" class="active">
            <h3>Zaznacz co chcesz oddać:</h3>

            <c:forEach items="${categories}" var="category">
            <div class="form-group form-group--checkbox">
              <label>

                <input items="${category}"
                       type="checkbox"
                       name="categories"
                       value="${category.id}"
                       id="categories"
                />

                <span class="checkbox"></span>
                <span class="description"
                  >${category.name}</span
                >
              </label></br>
              <form:errors path="categories" cssClass="error-small"/>
            </div>
            </c:forEach>

            <div class="form-group form-group--buttons">
              <button type="button" class="btn next-step" id="confirm-step-1">Dalej</button>
            </div>
          </div>

          <!-- STEP 2 -->
          <div data-step="2">
            <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

            <div class="form-group form-group--inline">
              <label>
                Liczba 60l worków:
                <input type="number" name="quantity" step="1" min="1" id="bags-quantity" value="${donations.quantity}" />
              </label></br>
              <form:errors path="quantity" cssClass="error-small"/>
            </div>

            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="button" class="btn next-step" id="confirm-step-2">Dalej</button>
            </div>
          </div>



          <!-- STEP 4 -->
          <div data-step="3">
            <h3>Wybierz organizacje, której chcesz pomóc:</h3>

            <c:forEach items="${institutions}" var="institution">
            <div class="form-group form-group--checkbox">
              <label>

                <input type="radio"
                       name="institution"
                       value="${institution.id}"
                       data-institution = "${institution.name}"
                       id="institution"
                       />
                <span class="checkbox radio"></span>
                <span class="description">
                  <div class="title">${institution.name}</div>
                  <div class="subtitle">
                    ${institution.description}
                  </div>
                </span>
              </label>
              </br>
              <form:errors path="institution" cssClass="ui-state-error"/>
            </div>
            </c:forEach>

            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="button" class="btn next-step" id="confirm-step-3">Dalej</button>
            </div>
          </div>

          <!-- STEP 5 -->
          <div data-step="4">
            <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

            <div class="form-section form-section--columns">
              <div class="form-section--column">
                <h4>Adres odbioru</h4>
                <div class="form-group form-group--inline">
                  <label> Ulica <input type="text" name="street" id="address" value="${donations.street}"/>
                  </label></br>
                  <form:errors path="street" cssClass="error-small"/>
                </div>

                <div class="form-group form-group--inline">
                  <label> Miasto <input type="text" name="city" id="city" value="${donations.city}"/>
                  </label></br>
                  <form:errors path="city" cssClass="error-small"/>
                </div>

                <div class="form-group form-group--inline">
                  <label>
                    Kod pocztowy <input type="text" name="zipCode" id="postcode" value="${donations.zipCode}"/>
                  </label></br>
                  <form:errors path="zipCode" cssClass="error-small"/>
                </div>

                <div class="form-group form-group--inline">
                  <label>
                    Numer telefonu <input type="text" name="phoneNumber" id="phone" value="${donations.phoneNumber}"/>
                  </label></br>
                  <form:errors path="phoneNumber" cssClass="error-small"/>
                </div>
              </div>

              <div class="form-section--column">
                <h4>Termin odbioru</h4>
                <div class="form-group form-group--inline">
                  <label> Data <input pattern="yyyy-MM-dd" type="date" name="pickUpDate" id="pickUpDate" value="${donations.pickUpDate}"/>
                  </label></br>
                  <form:errors path="pickUpDate" cssClass="error-small"/>
                </div>

                <div class="form-group form-group--inline">
                  <label> Godzina <input type="time" name="pickUpTime" id="pickUpTime" value="${donations.pickUpTime}"/>
                  </label></br>
                  <form:errors path="pickUpTime" cssClass="error-small"/>
                </div>

                <div class="form-group form-group--inline">
                  <label>
                    Uwagi dla kuriera
                    <textarea name="pickUpComment" rows="5" id="pickUpComment">
                    </textarea></br>
                    <form:errors path="pickUpComment" cssClass="error-small"/>
                  </label>
                </div>
              </div>
            </div>
            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="button" class="btn next-step" id="confirm-step-4">Dalej</button>
            </div>
          </div>

          <!-- STEP 6 -->
          <div data-step="5">
            <h3>Podsumowanie Twojej darowizny</h3>

            <div class="summary" id="donation-summary">
              <div class="form-section">
                <h4>Oddajesz:</h4>
                <ul>
                  <li>
                    <span class="icon icon-bag"></span>
                    <span class="summary--text" id="summary-text-quantity"
                      ></span
                    >
                  </li>

                  <li>
                    <span class="icon icon-hand"></span>
                    <span class="summary--text" id="summary-text-institution"
                      >Dla fundacji</span
                    >
                  </li>
                </ul>
              </div>

              <div class="form-section form-section--columns">
                <div class="form-section--column">
                  <h4>Adres odbioru:</h4>
                  <ul id="address-list">
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                  </ul>
                </div>

                <div class="form-section--column">
                  <h4>Termin odbioru:</h4>
                  <ul id="dispatch-list">
                    <li></li>
                    <li></li>
                    <li>Brak uwag</li>
                  </ul>
                </div>
              </div>
            </div>

            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="submit" class="btn">Potwierdzam</button>
            </div>
          </div>
        </form:form>
      </div>
    </section>

    <jsp:include page="./templates/footer.jsp"/>

  </body>
</html>
