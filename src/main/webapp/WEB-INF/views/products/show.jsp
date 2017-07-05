<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
<%@ page isELIgnored="false"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
        charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <ul>
            <li><a href="/shopping" rel="nofollow">Cart (${shoppingCart.quantity})
            </a></li>
        </ul>
        <table>
            <tr><td>PRODUCT: </td><td>${product.title}</td><td>DESC:    ${product.description}</td></tr>
        </table>
        <form action="<c:url value="/shopping"/>" method="post" class="container">
            <input type="hidden" value="${product.id}" name="productId"/>
            <ul id="variants" class="clearfix">
            <c:forEach items="${product.prices}" var="price">
            <li class="buy-option">
                 <input type="radio" name="bookType" class="variant-radio" id="${product.id}-${price.bookType}" value="${price.bookType}" ${price.bookType.name()=='COMBO'?'checked':''}>
            <label class="variant-label" for="${product.id}-${price.bookType}">
                ${price.bookType}
            </label>
            <p class="variant-price">${price.value}</p>
            </li>
            </c:forEach>
            </ul>
            <input type="submit" class="submit-image icon-basket-alt" alt="Compre agora" title="Compre agora '${product.title}'!" value="Buy"/>
        </form>

    </body>
</html>