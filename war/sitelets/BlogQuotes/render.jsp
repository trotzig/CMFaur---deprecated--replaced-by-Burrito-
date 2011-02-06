<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<c:forEach items="${sitelet.entries}" var="entry" varStatus="entryStatus">
			<div class="blog-entry-quote">
				<h4 class="quote-heading">
					<a href="${entry.url}">
						<c:out value="${entry.heading}"/>
					</a>
				</h4>
				<p class="quote-content">
					<a href="${entry.url}">
						"<c:out value="${entry.quote}"/>"
					</a>
					
				</p>
			</div>
	</c:forEach>
</div>