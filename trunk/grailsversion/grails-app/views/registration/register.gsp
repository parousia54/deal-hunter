<html>
<head>
    <meta content="main" name="layout">
    <title>Register</title>
</head>

<body>
<div class="page-header">
    <h1>Register</h1>
</div>

<div class="row">
    <div id="create-user" class="span9 scaffold-create" role="main">
        <g:uploadForm  action="handleRegister">
            <fieldset class="form">
                <g:render template="form"/>
            </fieldset>
            <fieldset class="buttons">
                <g:submitButton name="create" class="save btn btn-primary"
                                value="${message(code: 'default.button.create.label', default: 'Register')}"/>
            </fieldset>
        </g:uploadForm>
    </div>
</div>
</body>
</html>