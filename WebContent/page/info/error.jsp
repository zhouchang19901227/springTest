<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>home -- nncity</title>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 page-500">
				<div class=" number">
					Error
				</div>
				<div class="details">
					<h3>${ex}</h3>
					<p>
						<ht:lang key="httpStatus.500.p"/>
						<div class="btn-group">
						  <button type="button" onclick="history.go(-1);" class="btn btn-default"><i class="icon arrow-left"></i><ht:lang key="btn.back"/></button>
						  <a type="button" href="/home"  class="btn btn-default"><i class="icon house"></i><ht:lang key="home"/></a>
						</div>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
