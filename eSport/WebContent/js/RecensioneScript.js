function recensioneFormValidation(){
	var commento=document.rec.commento;
	
	if(validateCommento(commento, 12, 512))
		return true;

	return false;
}

function validateCommento(commento, minChar, maxChar) {
    var cmm_len = commento.value.length;
    if (cmm_len > maxChar) {
    	document.getElementById("cmmErr").innerHTML="Recensione troppo lunga (max 512 caratteri)";
    	document.getElementById("cmmErr").style.color="red";
    	pass.focus();
    	
        return false;
    }
    else if(cmm_len < minChar){
    	document.getElementById("cmmErr").innerHTML="Recensione troppo corta (min 12 caratteri)";
    	document.getElementById("cmmErr").style.color="red";
    	pass.focus();
    	
        return false;
    }
    else{
        document.getElementById("cmmErr").innerHTML="";
    }

    return true;
}