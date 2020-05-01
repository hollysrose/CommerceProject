<!DOCTYPE html>
<html lang="en">
<head>
<title>Fab Four Corp</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #4D9835;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}

a:link
{
    color:#FFFFFF;
}
a:hover 
{
    color:#FFFFFF;
    font-size: 25px;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 15%;
  height: 400px; /* only for demonstration, should be removed */
  background: #304629;
  padding: 20px;
  color: white;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
  color: white;
}

article {
  float: left;
  padding: 20px;
  width: 85%;
  background-color: #DAEAD4;
  height: 400px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #000000;
  padding: 10px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
</style>
</head>

<header>
  <h2>Fab Four Bank</h2>
</header>

<section>
  <nav>
    <ul>
      <li><a href="#">File Validation</a></li>
      <li><a href="#">Account</a></li>
      <li><a href="#">About Us</a></li>
    </ul>
  </nav>
  
  <article>
    <h1>Upload Status</h1>
	<h2>Message : ${message}</h2>
	
  <form method="POST" action="${pageContext.request.contextPath}/validate" enctype="multipart/form-data">
    <input type="submit"  value="Validate">
  </form>
	
  </article>
</section>

<footer>
  <p>Footer</p>
</footer>

</body>
</html>