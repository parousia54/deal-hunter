<div class="clearfix fieldcontain ${hasErrors(bean: user, field: 'username', 'error')} ">
    <label class="property-label" for="username">
        <g:message code="user.username.label" default="Username"/>

    </label>

    <div class="input">
        <g:textField name="username" value="${user?.username}"/>
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: user, field: 'password', 'error')} ">
    <label class="property-label" for="password">
        <g:message code="user.password.label" default="Password"/>

    </label>

    <div class="input">
        <g:passwordField name="password" value=""/>
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: user, field: 'businessPhone', 'error')} ">
    <label class="property-label" for="businessPhone">
        <g:message code="user.businessPhone.label" default="Business Phone"/>
    </label>

    <div class="input">
        <g:textField name="businessPhone" value="${user?.businessPhone}"/>
    </div>
</div>

<div class="clearfix">
    <h5>Business Address</h5>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: user, field: 'businessPhone', 'error')} ">
    <label class="property-label" for="businessAddress.streetName">
        Street Name
    </label>

    <div class="input">
        <g:textField name="businessAddress.streetName" value="${user?.businessAddress?.streetName}"/>
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: user, field: 'businessPhone', 'error')} ">
    <label class="property-label" for="businessAddress.suburb">
        Suburb
    </label>

    <div class="input">
        <g:textField name="businessAddress.suburb" value="${user?.businessAddress?.suburb}"/>
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: user, field: 'businessPhone', 'error')} ">
    <label class="property-label" for="businessAddress.state">
        State
    </label>

    <div class="input">
        <g:textField name="businessAddress.state" value="${user?.businessAddress?.state}"/>
    </div>
</div>
<div class="clearfix fieldcontain ${hasErrors(bean: user, field: 'businessPhone', 'error')} ">
    <label class="property-label" for="businessAddress.postCode">
        Postcode
    </label>

    <div class="input">
        <g:textField name="businessAddress.postCode" value="${user?.businessAddress?.postCode}"/>
    </div>
</div>