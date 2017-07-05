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
        <table>
            <c:forEach items="${shoppingCart.list}" var="item">
                <tr>
                    <td class="cart-img-col">
                     <img src="" alt="${item.product.title}"/>
                    </td>

                    <td class="item-title">
                        ${item.product.title} - ${item.bookType}
                        ${item.price}
                    </td>


                    <td class="quantity-input-cell">
                        <input type="number" min="0" readonly="readonly" value="${shoppingCart.getQuantity(item)}">
                    </td>

                    <td class="numeric-cell">
                        ${shoppingCart.getTotal(item)}
                    </td>
                </tr>
            </c:forEach>
        </table>
        <tfoot>
            <tr>
                <td colspan="2">
                    <form
                    action="${spring:mvcUrl('PC#checkout').build()}"
                    method="post">
                         <input type="submit" class="checkout" name="checkout" value="Finalizar compra " id="checkout"/>
                    </form>
                </td>
                <td class="numeric-cell">
                     ${shoppingCart.total}
                </td>
                <td></td>
            </tr>
        </tfoot>
    </body>
</html>