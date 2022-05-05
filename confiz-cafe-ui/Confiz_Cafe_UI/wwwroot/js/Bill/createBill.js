cc.namespace("UI.createBill");

cc.UI.createBill = (function () {
    //"use strict";

    var _isInitialized = false;
    const state = {
        
    }

    //to initialize page
    const initialisePage = () => {
        if (_isInitialized == false) {
            _isInitialized = true;
        }
    }
    
    //to bind events on elements
    const bindEvents = () => {
        $("#create-bill").click(e => {
            e.preventDefault();
            const employeeId = $("#employee-id").val().trim();
            cc.common.unthorizedAjaxCallJSON("Get", "https://jsonplaceholder.typicode.com/posts", { id:1 }, res =>
            {
                console.log(res);
                alert("bill created successfully")
            }, err => { });
        });
    }

    return {
        readyMain: () => {
            initialisePage();
            bindEvents();
        }
    };
}());
