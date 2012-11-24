<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout"/>
    <title>Login</title>

</head>

<body>

<div class="container">

    <g:form controller="login" action="handleLogin" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="input-block-level" name="username" placeholder="Username">
        <input type="password" class="input-block-level" name="password" placeholder="Password">
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
    </g:form>

</div> <!-- /container -->
</body>
</html>