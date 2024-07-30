<%-- 
    Document   : updateItem
    Created on : Jul 30, 2024, 2:54:25 PM
    Author     : scott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Update Item</title>
        </head>
        <body>
            <h1><h:outputText value="Update Item"/></h1>
            <h:form>
                <h:outputLabel for="foodId" value="Food ID:"/>
                <h:inputHidden id="foodId" name="foodId" value="${item.id}"/><br/>
                
                <h:outputLabel for="foodName" value="Food Name:"/>
                <h:inputText id="foodName" name="foodName" value="${item.itemName}"/><br/>
                
                <h:outputLabel for="foodQuantity" value="Quantity:"/>
                <h:inputText id="foodQuantity" name="foodQuantity" value="${item.quantity}"/><br/>
                
                <h:outputLabel for="foodCost" value="Cost:"/>
                <h:inputText id="foodCost" name="foodCost" value="${item.cost}"/><br/>
                
                <h:outputLabel for="foodExpiry" value="Expiry Date (YYYY-MM-DD):"/>
                <h:inputText id="foodExpiry" name="foodExpiry" value="${item.expiryDate}"/><br/>
                
                <h:outputLabel for="isSurplus" value="Is Surplus:"/>
                <h:selectBooleanCheckbox id="isSurplus" name="isSurplus" value="${item.isSurplus}"/><br/>
                
                <h:outputLabel for="listingType" value="Listing Type:"/>
                <h:selectOneMenu id="listingType" name="listingType" value="${item.listingType}">
                    <f:selectItem itemValue="Donation" itemLabel="Donation"/>
                    <f:selectItem itemValue="Sale" itemLabel="Sale"/>
                </h:selectOneMenu><br/>
                
                <h:commandButton value="Update Item" action="retailer"/>
            </h:form>
        </body>
    </html>
</f:view>
