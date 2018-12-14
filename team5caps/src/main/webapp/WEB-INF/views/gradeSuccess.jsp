<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<META charset="ISO-8859-1">
<title>Operation Successful</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
	
  <link rel="stylesheet" href="css/popup.css">
<script src="js/popup.js"></script>
<style type="text/css">
html,
body {
  height: 100%;
}
a {
  font-size: 15px;
  text-decoration: underline;
  color: white
}

body {
  margin: 0;
  background: radial-gradient(#b3b3b3, #ffffff);
  overflow: hidden;
}

.moving-zone {
  position: absolute;
  top: 35%;
  left: 50%;
  width: 300px;
  height: 120px;
  margin: -60px 0 0 -150px;
  perspective: 800px;
}
.popup {
  position: absolute;
  width: 300px;
  padding: 10px;
  box-sizing: border-box;
  border-radius: 20px 0 20px 0;
  cursor: pointer;
  transform-style: preserve-3d;
  background: -webkit-linear-gradient(top left, white 50%, coral 50%);
  background: -moz-linear-gradient(top left, white 50%, coral 50%);
  background: -ms-linear-gradient(top left, white 50%, coral 50%);
  background: -o-linear-gradient(top left, white 50%, coral 50%);
  background: linear-gradient(top left, white 50%, coral 50%);
}
.popup:before {
  content: "";
  position: absolute;
  left: 5%;
  top: 5%;
  width: 90%;
  height: 90%;
  border-radius: inherit;
  background: rgba(0, 0, 0, 0.1);
  box-shadow: 0 0 40px 20px rgba(0, 0, 0, 0.1);
  transform: translateZ(-100px);
}
.popup-content {
  background: #444;
  padding: 20px;
  box-sizing: border-box;
  border-radius: 10px 0 10px 0;
}
.popup-text {
  color: white;
  font-family: "Roboto", sans-serif;
  font-size: 20px;
  line-height: 30px;
  font-weight: 100;
  text-align: center;
  transform: translateZ(15px);
}
.popup-text b {
  color: coral;
  font-weight: 300;
}

.popup-text h1{
  color:white;
}

</style>
<script>
var moveForce = 30; // max popup movement in pixels
var rotateForce = 20; // max popup rotation in deg

$(document).mousemove(function(e) {
    var docX = $(document).width();
    var docY = $(document).height();
    
    var moveX = (e.pageX - (docX/2)) / (docX/2) * -moveForce;
    var moveY = (e.pageY - (docY/2)) / (docY/2) * -moveForce;
    
    var rotateY = (e.pageX / docX * rotateForce*2) - rotateForce;
    var rotateX = -((e.pageY / docY * rotateForce*2) - rotateForce);
    
    $('.popup')
        .css('left', moveX+'px')
        .css('top', moveY+'px')
        .css('transform', 'rotateX('+rotateX+'deg) rotateY('+rotateY+'deg)');
});
</script>
</head>

<body>
<div style="line-height:4200%;">

<div class="moving-zone">
    <div class="popup">
        <div class="popup-content">
            <div class="popup-text">
<h1 align=center>Operation successful</h1>
	<center>Information Updated!</center>
		<center><a href="javascript:history.back()">Click here if to return if your browser does not redirect.</a></center> 
            </div>
        </div>
    </div>
</div>
    <br>
</div>
</body>
</html>