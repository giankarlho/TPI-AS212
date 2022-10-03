"use strict";

var nombre = document.getElementById('nomId');
//var apellido = String(document.getElementById("apeId").value);
//var apellido = document.getElementById('apeId');
//var celular = document.getElementById('celularId');
var correo = document.getElementById('correoId');

function validarApellido() {
    var apellido = String(document.getElementById('formId:apeId').value).trim();    
    var spaceCount =(apellido.split(" ").length-1);
    console.log("Cantidad de espacios en blanco" + spaceCount);
    if (spaceCount > 1) {
        PF('wbtnregistraremp').enable();        
    }else{
        PF('wbtnregistraremp').disable();
    }
    
}

function validarCelular() {
    if (document.getElementById(PF('formId:celularId')).value != null) {
        PF('wbtnregistraremp').disable();
    }else{
        PF('wbtnregistraremp').enable();
    }
}

