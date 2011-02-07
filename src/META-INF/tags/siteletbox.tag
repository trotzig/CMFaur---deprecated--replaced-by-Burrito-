<%@ tag isELIgnored="false" body-content="empty" pageEncoding="UTF-8"%>
<%@ taglib prefix="cmfaur" tagdir="/WEB-INF/tags/cmfaur" %>
<%@ attribute name="id" required="true" %>

<%@tag import="java.util.List"%>
<%@tag import="cmfaur.util.SiteletHelper"%>
<%@tag import="cmfaur.services.SiteletProperties"%>
<%@tag import="cmfaur.sitelet.Sitelet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${mvcaur_userIsAdmin}">
	<cmfaur:siteletboxadmin id="${id}"/>
</c:if>
<div id="${id}" class="sitelet-container">

<%
	List<SiteletProperties> sitelets = SiteletHelper.getSiteletProperties((String)jspContext.getAttribute("id")); 
	int i = 1;
	for (SiteletProperties siteletProperties : sitelets) {
		jspContext.setAttribute("siteletProperties", siteletProperties);
%>
	<c:choose>
		<c:when test="${siteletProperties.cacheEnabled}">
			<cmfaur:cache key="${siteletProperties.cacheKey}" expirationSeconds="${siteletProperties.cacheExpirationInSeconds}">
				<cmfaur:sitelet sitelet="${siteletProperties.associatedSitelet}"/>
			</cmfaur:cache>
		</c:when>
		<c:otherwise>
			<cmfaur:sitelet sitelet="${siteletProperties.associatedSitelet}"/>
		</c:otherwise>
	</c:choose>
<%
		i++;
	}
%>
</div>

