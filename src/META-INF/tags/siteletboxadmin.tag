<%@ tag isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="cmfaur" tagdir="/WEB-INF/tags/cmfaur" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="id" required="true" %>
<script type="text/javascript">
	(function() {
		var id = "sitelet-admin-css";
		var script = document.getElementById(id);
		if (script) {
			//css already loaded
			return;
		}
		var cssElem = document.createElement("link");
		cssElem.setAttribute("href", "/cmfaur/siteletadmin.css");
		cssElem.setAttribute("rel", "stylesheet");
		cssElem.setAttribute("type", "text/css");
		cssElem.setAttribute("id", id);
		document.getElementsByTagName("head")[0].appendChild(cssElem);
	})();
</script>
<div class="sitelets-admin-header-wrapper">
	<div class="sitelets-admin-header">
		<span><cmfaur:message key="sitelet_container" extra="${id}"/></span>
		&nbsp;|&nbsp; 
		<a class="sitelets-admin-header-edit" href="#" title="${id}" onclick="window.open('/admin?container=${id}','_blank','left=20,top=20,width=1024,height=800,toolbar=1,resizable=1,scrollbars=1'); return false;">
			<c:set var="title"><cmfaur:message key="sitelet_container_admin"/></c:set>
			<span title="${title}"><cmfaur:message key="sitelet_container_edit"/></span>
		</a>
	</div>
</div>