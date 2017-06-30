<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring"
uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <title>Cadastro de produtos</title>
    </head>
    <body>


        <form:form action="/produtos" method="post" commandName="product">

            <div>
                <label for="title">Titulo</label>
                <form:input path="title"/>
                <form:errors path="title"/>
            </div>

            <div>
                <label for="description">Description</label>
                <form:textarea path="description" rows="10" cols="20"/>
                <form:errors path="description"/>
            </div>

            <div>
                <label for="pages">Pages</label>
                <form:input path="pages"/>
                <form:errors path="pages"/>
            </div>

            <div>
                 <label for="releaseDate">Release Date</label>
                 <form:input path="releaseDate" type="date"/>
                 <form:errors path="releaseDate"/>
            </div>

            <c:forEach items="${types}" var="bookType" varStatus="status">
                <div>
                    <label for="price_${bookType}">${bookType}</label>

                    <input type="text" name="prices[${status.index}].value"
                         id="price_${bookType}"/>

                    <input type="hidden"
                         name="prices[${status.index}].bookType"
                         value="${bookType}"/>
                </div>
            </c:forEach>

            <div>
                <input type="submit" value="Send">
            </div>

        </form:form>

       <%-- <form method="post" action="/produtos">
            <div>
                <label for="title">Titulo</label>
                <input type="text" name="title" id="title"/>
            </div>
            <div>
                <label for="description">Descricao</label>
                <textarea rows="10" cols="20" name="description"
                id="description">
                </textarea>
            </div>
            <div>
                <label for="pages">Numero de paginas</label>
                <input type="text" name="pages" id="pages"/>
            </div>

            <c:forEach items="${types}" var="bookType" varStatus="status">
                <div>
                    <label for="price_${bookType}">${bookType}</label>

                    <input type="text" name="prices[${status.index}].value"
                         id="price_${bookType}"/>

                    <input type="hidden"
                         name="prices[${status.index}].bookType"
                         value="${bookType}"/>
                </div>
           </c:forEach>

            <div>
                <input type="submit" value="Enviar">
            </div>

        </form>--%>

    </body>
</html>
