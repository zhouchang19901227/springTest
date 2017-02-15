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
			<div class="col-md-12 page-505">
				<div class="number">
					404
				</div>
				<div class="details">
					<h3><ht:lang key="httpStatus.505.h3"/></h3>
					<p>
						<ht:lang key="httpStatus.505.p"/>
						<div class="btn-group">
						  <button type="button" onclick="history.go(-1);" class="btn btn-default"><i class="icon arrow-left"></i><ht:lang key="btn.back"/></button>
						  <a type="button" href="/home"  class="btn btn-default"><i class="icon house"></i><ht:lang key="home"/></a>
						</div>
					</p>
					<!--<form action="#">
						<div class="input-group input-medium">
							<input type="text" class="form-control" placeholder="keyword...">
							<span class="input-group-btn">                   
							<button type="submit" class="btn blue"><i class="icon search"></i></button>
							</span>
						</div>
					</form>-->
				</div>
			</div>
		</div>
	</div>

</body>
</html>
