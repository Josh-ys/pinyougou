
/*购物车效果*/
function hovercar() {
	$("#shopcar").mouseover(function() {
		$("#shopcarlist").show("fast");
	});
	$("#shopcarlist").mouseleave(function() {
		$("#shopcarlist").hide("fast");
	});
}

/*自动完成*/
$(function(){
	
	var availableTags = [
		"ActionScript",
		"AppleScript",
		"Asp",
		"BASIC",
		"C",
		"C++",
		"Clojure",
		"COBOL",
		"ColdFusion",
		"Erlang",
		"Fortran",
		"Groovy",
		"Haskell",
		"Java",
		"JavaScript",
		"Lisp",
		"Perl",
		"PHP",
		"Python",
		"Ruby",
		"Scala",
		"Scheme"
	];
	$( "#autocomplete" ).autocomplete({
		source: availableTags
//		source: "../data/autocomplete.json",
//		minLength: 2
	});

});
