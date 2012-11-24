<%@ page import="dealhunter.Deal" %>



<div class="clearfix fieldcontain ${hasErrors(bean: deal, field: 'dealTitle', 'error')} ">
    <label class="property-label" for="dealTitle">
        <g:message code="deal.dealTitle.label" default="Deal Title"/>
        
    </label>

    <div class="input">
        <g:textField name="dealTitle" value="${deal?.dealTitle}"/>
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: deal, field: 'dealDescription', 'error')} ">
    <label class="property-label" for="dealDescription">
        <g:message code="deal.dealDescription.label" default="Deal Description"/>
        
    </label>

    <div class="input">
        <g:textField name="dealDescription" value="${deal?.dealDescription}"/>
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: deal, field: 'dealStartDate', 'error')} required">
    <label class="property-label" for="dealStartDate">
        <g:message code="deal.dealStartDate.label" default="Deal Start Date"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="input">
        <g:datePicker name="dealStartDate" precision="day"  value="${deal?.dealStartDate}"  />
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: deal, field: 'dealEndDate', 'error')} required">
    <label class="property-label" for="dealEndDate">
        <g:message code="deal.dealEndDate.label" default="Deal End Date"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="input">
        <g:datePicker name="dealEndDate" precision="day"  value="${deal?.dealEndDate}"  />
    </div>
</div>

<div class="clearfix fieldcontain ${hasErrors(bean: deal, field: 'dealImage', 'error')} required">
    <label class="property-label" for="dealImage">
        <g:message code="deal.dealImage.label" default="Deal Image"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="input">
        <input type="file" id="dealImage" name="dealImage" />
    </div>
</div>

