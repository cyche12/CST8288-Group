<%-- 
    Document   : inventory
    Created on : Jul 30, 2024, 2:56:31 PM
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
            <title>Inventory</title>
        </head>
        <body>
            <h1><h:outputText value="Inventory"/></h1>
            <h:dataTable value="#{items}" var="item">
                <h:column>
                    <f:facet name="header">Food ID</f:facet>
                    <h:outputText value="#{item.id}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">Food Name</f:facet>
                    <h:outputText value="#{item.itemName}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">Quantity</f:facet>
                    <h:outputText value="#{item.quantity}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">Cost</f:facet>
                    <h:outputText value="#{item.cost}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">Expiry Date</f:facet>
                    <h:outputText value="#{item.expiryDate}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">Is Surplus</f:facet>
                    <h:outputText value="#{item.isSurplus}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">Listing Type</f:facet>
                    <h:outputText value="#{item.listingType}"/>
                </h:column>
                <h:column>
                    <f:facet name="header">Actions</f:facet>
                    <h:commandLink value="Update" action="retailer?action=update&foodId=#{item.id}"/>
                </h:column>
            </h:dataTable>
            <h:commandLink value="Add New Item" action="retailer?action=add"/>
        </body>
    </html>
</f:view>
