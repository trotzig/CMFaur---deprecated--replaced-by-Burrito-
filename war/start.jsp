<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="cmfaur" uri="/burrito-tags" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<layout:mainlayout pageTitle="Burrito CMF Demo">
	
	<div class="blog">
		<div class="blog-inside">
			<c:forEach items="${mvcaur}" var="entry" varStatus="entryStatus">
				<h2><a href="${entry.url}"><c:out value="${entry.heading}"/></a></h2>
				<p class="blog-entry-date">${entry.created}</p>
				<p class="blog-entry-content">
					${entry.content}
				</p>
			</c:forEach>
		</div>
	</div>
	<div class="side">
		<div class="side-inside">
			<p class="info">Here's an example of a Sitelet, showing the 5 latest blog entries</p> 
			<cmfaur:siteletbox id="start-right"/>
		</div>
	</div>
</layout:mainlayout>
