function recensioneFormValidation(){
	var commento=document.recensione.commento;
	
	if(validateCommento(commento, 12))
		return true;

	return false;
}

function validateCommento(commento, minChar) {
    var cmm_len = commento.value.length;

    if(cmm_len < minChar){
    	document.getElementById("cmmErr").innerHTML="Recensione troppo corta (min 12 caratteri)";
    	document.getElementById("cmmErr").style.color="red";
    	commento.focus();
    	
        return false;
    }
    else{
        document.getElementById("cmmErr").innerHTML="";
    }

    return true;
}