<%-- 
    Document   : addItem
    Created on : Jul 30, 2024, 2:52:11 PM
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
            <title>Add Item</title>
        </head>
        <body>
            <h1><h:outputText value="Add New Item"/></h1>
            <h:form>
                <h:outputLabel for="foodId" value="Food ID:"/>
                <h:inputText id="foodId" name="foodId"/><br/>
                
                <h:outputLabel for="foodName" value="Food Name:"/>
                <h:inputText id="foodName" name="foodName"/><br/>
                
                <h:outputLabel for="foodQuantity" value="Quantity:"/>
                <h:inputText id="foodQuantity" name="foodQuantity"/><br/>
                
                <h:outputLabel for="foodCost" value="Cost:"/>
                <h:inputText id="foodCost" name="foodCost"/><br/>
                
                <h:outputLabel for="foodExpiry" value="Expiry Date (YYYY-MM-DD):"/>
                <h:inputText id="foodExpiry" name="foodExpiry"/><br/>
                
                <h:outputLabel for="retailerId" value="Retailer ID:"/>
                <h:inputText id="retailerId" name="retailerId"/><br/>
                
                <h:commandButton value="Add Item" action="retailer"/>
            </h:form>
        </body>
    </html>
</f:view>
