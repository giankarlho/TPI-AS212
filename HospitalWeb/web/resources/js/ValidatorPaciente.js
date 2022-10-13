"use strict";

function validarApellido() {
    var apellido = String(document.getElementById('formId:apeId').value).trim();    
    var spaceCount =(apellido.split(" ").length-1);
    console.log("Cantidad de espacios en blanco" + spaceCount);
    if (spaceCount > 0) {
        PF('wbtnRegistrar').enable();        
    }else{
        PF('wbtnRegistrar').disable();
    }    
}