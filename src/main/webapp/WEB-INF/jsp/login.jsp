<html>
<head>
<title>First Web Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container:>
<font color="red">${message}</font>
<form method="post">
<fieldset class="form-group">
<label>Name</label>
<input type="text" name="name" class="form-control"  />
<label>Password</label>
<input type="password" name="password" class="form-control"  />
</fieldset>
<button type="submit" class="btn btn-dark">LOGIN</button> 
</form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>