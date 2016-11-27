function valueToText(str,value){
	str = str.substring(0,str.length-1);
	str = str.split(",");
	for(var i=0;i<str.length;i++){
		var array = str[i].split("=");
		if($.trim(array[0])==$.trim(value)){
			return array[1];
		}
	}
}