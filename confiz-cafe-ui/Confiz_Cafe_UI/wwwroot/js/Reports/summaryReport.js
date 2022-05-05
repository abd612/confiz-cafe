cc.namespace("UI.summaryReport");

cc.UI.summaryReport = (function () {
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

    }

    return {
        readyMain: () => {
            initialisePage();
            bindEvents();
        }
    };
}());
