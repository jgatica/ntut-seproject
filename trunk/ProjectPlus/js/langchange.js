/**
 * LangChange+  ver1.2 (Fix cookie bug)
 * ---------------------------------------------
 * Author: Augus
 * --------------------------------------------- 
 * LangChange is a jQuery Plug-ing use for change webpage content¡¦s language,It offer those features :
 * I.	Replace image by language
 * II.	Replace js/css files
 * III.	Transform langTag to String
 * IV.	Temp the query
 * V. 	Cookie your lang
 *
 ****************************************************************************
 * What's news?
 ****************************************************************************  
 *
 * In this version , add the cookie feature, then your 
 * browser will remeber user's lang show the lang at next time
 *
 *
 *
 ****************************************************************************
 * How To Use It ?
 **************************************************************************** 
 * 1) Import langchange.js in your page
 *		
 * 		<script src="langchange.js" type="text/javascript"></script>	
 * 	
 **************************************************************************** 
 * 2) Create a XML file to edit your multi-language content.
 *    
 * 		<content>
 *	  		<text id="your_tagId">
 *		  		<fr>LangChange - un Plug-in jQuery</fr>
 *		  		<en>LangChange - a jQuery Plug-in</en>
 *	  		</text>
 * 		</content>
 *    
 ****************************************************************************
 * 3) Add langtag in html tag like
 *    
 * 		<body>
 * 			<p langtag="your_tagId"></p>
 * 			<p langtag="your_tagId"></p>
 * 		</body>
 *    
 *
 ****************************************************************************
 * 4) Call langInit() function in your page
 *    
 * 		$(document).ready(function(){
 * 			langInit({lang: "en", file: "files/lang-example.xml", css: ['main','front']});
 * 		}
 *    
 *    ###### Important : your js/css file must be use this format #####
 *    ###### [name]_[language].js/[name]_[language].css			  #####
 *
 **************************************************************************** 
 * 5) Call the changeLang () function to change your page language.
 *   
 *  	$("body").changeLang({lang: "fr", file: "files/lang-example.xml"});	
 *    
 **************************************************************************** 
 * Get content by langtag
 **************************************************************************** 
 * In some case you will attention some message to user¡A
 * Bug the message is return by the server, server can¡¦t 
 * decide which language to return.Now, Use ChageLang+ ,
 * Your server just return the langtag , and use this 
 * langtag to convert your multi-language message.
 *
 * 		$.getJSON('/action.do', { parms: parms }, function(data) {	
 *			var tagName = data; // server return a langtag name
 *			var content = langtagTransform(tagName);
 *			alert(content);
 *		}); 
 **************************************************************************** 
 */



(function($){
	var initFunction = new Array();;
	
	
	var language = "en"; // Last language record
	var tmpXml;			 // Xml query temp
	var defaults = {
		file: '/js/files/lang-example.xml',
		lang: 'en',
		css: [''],	// your css file [ex: main_en.css, main_fr.css ==> then put "main" on this]
		js: [''],
	};
	
	/**
	* Init LangChangePlus Plug-in
	*/
	langInit = function(params){	
	
		if(params) $.extend(defaults, params);
		
		var lang = getCookie('lang');
		
		if(lang != null){
			$("body").changeLang({lang: '' + lang, file: "/js/files/lang-example.xml"});
		} else {
			$("body").changeLang({lang: params.lang, file: "/js/files/lang-example.xml"});
		}	
	}

	/**
	* Change page language
	*/
	$.fn.changeLang = function(params){
	
		var aTexts = new Array();
		
		if(params) $.extend(defaults, params);
		
		$.ajax({
			type: "GET",
			url: defaults.file,
			dataType: "xml",
			success: function(xml) {			   
				tmpXml = xml;
				
				// load xml file
				$(xml).find('text').each(function()
				{
					var textId = $(this).attr("id");
					var text = $(this).find(defaults.lang).text();					
					aTexts[textId] = text;
				});				
				
				// replace js/css file
				for(var i = 0; i < defaults.css.length; i++)
					replacejscssfile("styles/" + defaults.css[i] + "_" + language + ".css", "styles/" + defaults.css[i] + "_" + params.lang + ".css", "css");
				for(var i = 0; i < defaults.js.length; i++)
					replacejscssfile("styles/" + defaults.js[i] + "_" + language + ".js", "styles/" + defaults.js[i] + "_" + params.lang + ".js", "js");
					
				// record language config
				language = params.lang;
				
				// set cookie
				setCookie('lang',language,100);

				// replace page content
				$.each($("*"), function(i, item)
				{
					//alert($(item).attr("langtag"));
					if($(item).attr("langtag") != null) {
						// replace text
						$(item).text(aTexts[$(item).attr("langtag")]);
						// replace img src
						//$(item).attr('src',aTexts[$(item).attr("langtag")]);
					}
				});
				for(var i = 0; i < initFunction.length; i++)				
					initFunction[i]();
			}
		});
	};
	
	
	addLangInitHandler = function(fn){
		initFunction.push(fn);
	}
	
	
	langtagTransform = function(langTag){
		
		var aTexts = new Array();
		
		// load xml file
		$(tmpXml).find('text').each(function()
		{
			var textId = $(this).attr("id");
			var text = $(this).find(language).text();					
			aTexts[textId] = text;
		});
	
		// return langTag's String
		if(langTag != null) {				
			return aTexts[langTag];					
		}		
		return "can't not read the language file";

	};	
	
	/**
	* Create js/css file
	*/
	createjscssfile = function(filename, filetype){
		//if filename is a external JavaScript file
		if (filetype=="js"){ 
			var fileref=document.createElement('script');
				fileref.setAttribute("type","text/javascript");
				fileref.setAttribute("src", filename);
			}
		//if filename is an external CSS file
		else if (filetype=="css"){ 
			var fileref=document.createElement("link");
			fileref.setAttribute("rel", "stylesheet");
			fileref.setAttribute("type", "text/css");
			fileref.setAttribute("href", filename);
		}
		return fileref;
	}
	
	/**
	* Replace js/css file
	*/
	replacejscssfile = function(oldfilename, newfilename, filetype){
		var targetelement=(filetype=="js")? "script" : (filetype=="css")? "link" : "none"; //determine element type to create nodelist using
		var targetattr=(filetype=="js")? "src" : (filetype=="css")? "href" : "none" ;//determine corresponding attribute to test for
		var allsuspects=document.getElementsByTagName(targetelement);
		for (var i=allsuspects.length; i>=0; i--){ //search backwards within nodelist for matching elements to remove
			if (allsuspects[i] && allsuspects[i].getAttribute(targetattr)!=null && allsuspects[i].getAttribute(targetattr).indexOf(oldfilename)!=-1){
				var newelement=createjscssfile(newfilename, filetype);
				allsuspects[i].parentNode.replaceChild(newelement, allsuspects[i]);
			}
		}
	}
	
	/**
	* Set an attribute into Cookie
	*/
function setCookie(c_name,value,exdays)
 {
 var exdate=new Date();
 exdate.setDate(exdate.getDate() + exdays);
 var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
 document.cookie=c_name + "=" + c_value;
 }
	
	/**
	* Get an attribute in Cookie
	*/
function getCookie(c_name)
 {
 var i,x,y,ARRcookies=document.cookie.split(";");
 for (i=0;i<ARRcookies.length;i++)
 {
   x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
   y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
   x=x.replace(/^\s+|\s+$/g,"");
   if (x==c_name)
     {
     return unescape(y);
     }
   }
 }
	
})(jQuery);