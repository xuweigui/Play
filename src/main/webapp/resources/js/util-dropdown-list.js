//required jquery

//set dropdown options
function setSelectOptions(selector,options) {
    var op = "";
    if (options && options.length) {
        for (var i=0; i < options.length; i++) {
            op = op + "<option value='" + options[i].id + "'>" + options[i].name + "</option>";
        }
    }

    $(selector).append(op);
}

function setSelectOptions_2(selector, options, parentSelector) {
    //got related subtypes
    if (options && options.length) {
        var op = "";
        for (var i=0; i < options.length; i++) {
            op = op + "<option value='" + options[i].id + "'>" + options[i].name + "</option>";
        }
        $(selector).html(op);
    } else {
        //has not got related subtypes
        //replace the subtypes with the selected type
        $(selector).children()
            .replaceWith($(parentSelector + " > option:selected").clone());
    }

}