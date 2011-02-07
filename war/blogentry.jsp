<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="cmfaur" uri="/burrito-tags" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:mainlayout pageTitle="Burrito CMF Demo - ${mvcaur.heading}">
	
	<div class="blog">
		<div class="blog-inside">
			<h2><c:out value="${mvcaur.heading}"/></h2>
			<p class="blog-entry-date">${entry.created}</p>
			<p class="blog-entry-content">
				${mvcaur.content}
			</p>
			<br/>
			<p>
				&laquo; Back to the <a href="/">entire blog</a>
			</p>
		</div>
	</div>
	<div class="side">
		<div class="side-inside">
			<p class="info">Here's an example of a Sitelet, showing the 5 latest blog entries</p> 
			<cmfaur:siteletbox id="start-right"/>
		</div>
	</div>
	
	
</layout:mainlayout>
