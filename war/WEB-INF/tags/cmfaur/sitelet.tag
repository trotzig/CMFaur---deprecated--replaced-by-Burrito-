<%@ tag pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="cmfaur" tagdir="/WEB-INF/tags/cmfaur" %>
<%@ attribute name="sitelet" type="cmfaur.sitelet.Sitelet" required="true" %>
<%
	cmfaur.sitelet.Sitelet sitelet = (cmfaur.sitelet.Sitelet)jspContext.getAttribute("sitelet");
	//exponera globalt för render.jsp att plocka upp
	jspContext.setAttribute("sitelet", sitelet, PageContext.REQUEST_SCOPE);
%>
<div class="sitelet-wrapper sitelet-wrapper-last-false">
	<div class="sitelet">
		<jsp:include page="/sitelets/${sitelet.class.simpleName}/render.jsp"/>
	</div>
</div>

