cc.namespace("common");

cc.common = (function () {
    "use strict";

    var _isInitialized = false;
    
    //Handlebar plugin facilitation function

    // To append html
    function setHandlebarTemplate(templateSelector, targetContainerselector, data, appendOnly, callbackFn) {
        if (appendOnly != true)
            $(targetContainerselector).html('');

        var source = $(templateSelector).html();
        var template = Handlebars.compile(source);
        var html = template(data);
        $(targetContainerselector).append(html);

        if (callbackFn)
            callbackFn();
    }

    // To set HTML After element
    function setHandlebarTemplateAfter(templateSelector, targetContainerselector, data, appendOnly, callbackFn) {
        if (appendOnly != true)
            $(targetContainerselector).html('');

        var source = $(templateSelector).html();
        var template = Handlebars.compile(source);
        var html = template(data);
        $(targetContainerselector).after(html);

        if (callbackFn)
            callbackFn();
    }

    // To set HTML Before element
    function setHandlebarTemplateBefore(templateSelector, targetContainerselector, data, appendOnly, callbackFn) {
        if (appendOnly != true)
            $(targetContainerselector).html('');

        var source = $(templateSelector).html();
        var template = Handlebars.compile(source);
        var html = template(data);
        $(targetContainerselector).before(html);

        if (callbackFn)
            callbackFn();
    }

    // To prepend HTML 
    function setHandlebarTemplatePrepend(templateSelector, targetContainerselector, data, appendOnly, callbackFn) {
        if (appendOnly != true)
            $(targetContainerselector).html('');

        var source = $(templateSelector).html();
        var template = Handlebars.compile(source);
        var html = template(data);
        $(targetContainerselector).prepend(html);

        if (callbackFn)
            callbackFn();
    }

    function getHandlebarHtml(templateSelector, data) {
        var source = $(templateSelector).html();
        var template = Handlebars.compile(source);
        var html = template(data);
        return html;
    }

    //General Functions
    function authorizedAjaxCallJSON(method, url, data, success, failure, token, beforeSend = null, complete = null, async = true) {
        if (token != null) {
            var headers = {
                "authorization": "bearer " + token
            };
            if (method.toLowerCase() != "get")
                data = JSON.stringify(data);
            ajaxCall(method, url, data, success, failure, "application/json", true, headers, beforeSend, complete, async);
        }
    }
    function authorizedAjaxCallJSONForArray(method, url, data, success, failure, token) {
        if (token != null) {
            var headers = {
                "authorization": "bearer " + token
            };



            data = data['newOrderLines'];
            console.log(data);
            data = JSON.stringify(data);
            ajaxCall(method, url, data, success, failure, "application/json", true, headers);
        }
    }

    function unthorizedAjaxCallJSON(method, url, data, success, failure) {
        var headers = {};
        if (method.toLowerCase() != "get")
            data = JSON.stringify(data);
        ajaxCall(method, url, data, success, failure, "application/json", true, headers);
    }

    function authorizedAjaxCallFormData(method, url, data, success, failure, token) {
        if (token != null) {
            var headers = {
                "authorization": "bearer " + token
            };
            ajaxCall(method, url, data, success, failure, false, false, headers);
        }
    }

    function ajaxCall(method, url, data, success, failure, contentType, processData, headers, beforeSend, complete, async = false) {
        $.ajax(url, {
            async,
            contentType: contentType,
            processData: processData,
            data: data,
            type: method,
            headers: headers,
            success: success,
            error: failure,
            beforeSend: beforeSend,
            complete: complete
        });
    } 
    return {
        setHandlebarTemplate,
        setHandlebarTemplateAfter,
        setHandlebarTemplateBefore,
        getHandlebarHtml,
        authorizedAjaxCallJSON,
        authorizedAjaxCallJSONForArray,
        unthorizedAjaxCallJSON,
        authorizedAjaxCallFormData,
        ajaxCall: ajaxCall
    };
}());