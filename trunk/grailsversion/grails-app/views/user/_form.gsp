
<div class="clearfix fieldcontain ${hasErrors(bean: userInstance, field: 'businessAddress', 'error')} required">
    <label class="property-label" for="businessAddress">
        <g:message code="user.businessAddress.label" default="Business Address"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="input">
        
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: userInstance, field: 'businessPhone', 'error')} ">
    <label class="property-label" for="businessPhone">
        <g:message code="user.businessPhone.label" default="Business Phone"/>
        
    </label>

    <div class="input">
        <g:textField name="businessPhone" value="${userInstance?.businessPhone}"/>
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: userInstance, field: 'isVerified', 'error')} ">
    <label class="property-label" for="isVerified">
        <g:message code="user.isVerified.label" default="Is Verified"/>
        
    </label>

    <div class="input">
        <g:checkBox name="isVerified" value="${userInstance?.isVerified}" />
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} ">
    <label class="property-label" for="password">
        <g:message code="user.password.label" default="Password"/>
        
    </label>

    <div class="input">
        <g:textField name="password" value="${userInstance?.password}"/>
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} ">
    <label class="property-label" for="username">
        <g:message code="user.username.label" default="Username"/>
        
    </label>

    <div class="input">
        <g:textField name="username" value="${userInstance?.username}"/>
    </div>
</div>

