<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
		
		<form:form method="post" modelAttribute="todo">
			<fieldset class="form-group">
				<form:hidden path="id"/>  
				<form:label path="desc">Description</form:label>
				<form:input placeholder="PLEASE ENTER HERE" path="desc" type="text" class="form-control" required="required"/>
				<form:errors path="desc" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:hidden path="id"/>  
				<form:label path="targetDate">Target Date</form:label>
				<form:input placeholder="PLEASE ENTER HERE" path="targetDate" type="text" class="form-control" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
			</form:form>
	</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
</script>
</body>
</html>
<%@ include file="common/footer.jspf" %>