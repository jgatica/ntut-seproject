/* ------------------------------------------------------
 * -----  LangChanger+ ver1.5 (具多種HTML屬性同時更換功能) ----+
 * -----------------------------------------------------+
 * 作者 : Augus                                         +
 * -----------------------------------------------------+
 * LangChanger+ 是一個jQuery的插件，它提供一個簡單的方法+
 * 讓你在前端處理多國語言的問題，目前提供以下功能       +
 * -----------------------------------------------------+ 
 * I.	依不同語言切換不同的圖片                        +
 * II.	依不同語言切換不同的js/css檔案     				+
 * III.	使用langTag()函式取得對應字串					+
 * IV.	暫存字典檔在Local端								+
 * V. 	暫存用戶設定在Local端							+
 * VI.  多種HTML屬性切換功能							+	
 --------------------------------------------------------
 
 ****************************************************************************
 *  注意事項 !!!!!!
 ****************************************************************************  
 *
 * 1.4版加入Local Storage功能，依賴額外的jQuery插件jStorage
 * 因此在使用LangChanger+前必須引入(import)jQuery.js及jStorage.js兩個js檔案
 *
 *
 ****************************************************************************
 
 ****************************************************************************
 * 如何使用LangChanger+ ?
 **************************************************************************** 
 * 1) 引入以下js檔案，並且要以jQuery, jStorage.js/langChanger.js/langchange.js 順序引入
 *		
 * 		<script src="jQuery.js" type="text/javascript"></script>	
 * 	    <script src="jStorage.js" type="text/javascript"></script>
 *      <script src="langChanger.js" type="text/javascript"></script>
 *
 **************************************************************************** 
 * 2) 使用以下的格式，創建您自己的字典xml檔案。
 *    
 * 		<content>
 *	  		<text id="your_tagId">
 *		  		<fr>LangChange - un Plug-in jQuery</fr>
 *		  		<en>LangChange - a jQuery Plug-in</en>
 *	  		</text>
 *			// 圖片範例
 *			<text id="country">
 *				<fr_src>http://van.tiao.com/images/upload/team/48_48/france.gif</fr_src>
 *				<en_src>http://img3.douban.com/icon/g294805-1.jpg</en_src>
 *				<fr_title>法國</fr_title>
 *				<en_title>英國</en_title>		
 *			</text> 
 * 		</content>
 *    
 ****************************************************************************
 * 3) 加入langtag屬性到html標籤中。
 *    
 * 		<body>
 * 			<p langtag="your_tagId"></p>
 * 			<p langtag="your_tagId"></p>
 * 		</body>
 *    
 *
 ****************************************************************************
 * 4) 在你的網頁上呼叫(ready)使用$['langChanger'].langInit({參數})，預設情況下會自動完成語言切換
 *    
 * 		$(document).ready(function(){
 * 			$['langChanger'].langInit({version:2, lang: "en", file: "files/lang-example.xml", css: ['main','front']});
 * 		}
 *    
 *    ###### Important : your js/css file must be use this format #####
 *    ###### [name]_[language].js/[name]_[language].css			  #####
 *
 **************************************************************************** 
 * 5) 你也可以手動呼叫$['langChanger'].changeLang()方法改變頁面語言
 *   
 *		// 切換'法國'語系
 *  	$("body").changeLang({lang: "fr", file: "files/lang-example.xml"});	
 *    
 **************************************************************************** 
 
 
 **************************************************************************** 
 *  註1 : 使用javaScript轉換字典標籤(langTag)取得字串
 **************************************************************************** 
 * 在一些情況下你會使Server端回傳提示訊息給客戶，但你無法得知用戶目前語言，
 * 因此這時候你可以選擇回傳字典標籤(langTag)的方法，你的Server只需要回傳對應的
 * 字典標籤(langTag)，語言轉換的工作就可以交給前端的langChanger來完成。
 *
 *   $['langChanger'].langTag('標籤名稱')
 *
 *   ex:
 * 		$.getJSON('/action.do', { parms: parms }, function(data) {	
 *			var tagName = data; // server return a langtag name
 *			var content = $['langChanger'].langTag(tagName);
 *			alert(content);
 *		}); 
 *
 *
 ***************************************************************************** 
 *  註2 : 加入CallBack函式
 **************************************************************************** 
 * 在某些動態的情況下你一定要等到翻譯結束後才能處理的工作，但這個工作所需
 * 內容是需要字典結果的，這時你可以加入CallBack函數給LangChanger，LangChanger
 * 會在翻譯後呼叫這些函數。
 *
 *   ex:
 *      // Alert某個Tag一定是要等到Init結束才可能達成
 *		function initPage(){
 *			alert($['langChanger'].langTag('myTag'));		
 *		}
 *
 *      $['langChanger'].addLangInitHandler(initPage);
 *
 *
 ***************************************************************************** 
 *  註3 : 控制字典版本
 *****************************************************************************
 * 字典檔會使用Local Storage方式存放在客戶端，那如果字典檔更新時如何通知用戶
 * 更新呢?
 *
 * 使用方法 : 在$['LangChanger'].langInit()中加入參數version來控制字典版本
 *
 * 假如第一版本中我們設定version為1 :
 * $['LangChanger'].langInit({version: 1});
 * 這時候LangChanger會儲存版本1在客戶的Local Storage中
 *
 * 之後字典更新了假定version為2:
 * $['LangChanger'].langInit({version: 2});
 * 在這個時候LangChanger就會發現客戶LocalStorage中的版本與此不同，因此就會重新
 *
 *
 **************************************************************************** 
 */

(function($){
		// 為了避免函數名稱的衝突，在這個版本開始，使用$['langChanger']的方式存取LangChanger
		this.langChanger = 'langChanger'; 		// 用來給外面存取的名稱，使用$['langChanger']即可存取內部方法
		this.publicMethod;						// 公用Method
		this.callBackMethod = new Array();		// 在changeLang後所呼叫的CallBack函式
		this.language = "en"; 					// 儲存上次選擇的語言 language record
		this.version = "0";
		this.defaults = {						// 預設的初始值
			file: '/files/lang-example.xml',
			lang: 'tw',  // 預設值為繁體中文
			css: [''],	// your css file [ex: main_en.css, main_fr.css ==> then put "main" on this]
			js: [''],
			langData: '',
		};
		
		// 公開的方法
		var publicMethod = $.fn[langChanger] = $[langChanger] = function (options, callback) {}				
		
		/**
		* 初始化函式
		*/
		publicMethod.langInit = function(params){	
			
			if(params) $.extend(defaults, params);
			// 當前語言版本 : 當字典檔需求更新時，只需要更動此數客戶端自動更新
		
			var currentVer = $.jStorage.get('langVersion');		// 取得當前字典版本
			var lang = $.jStorage.get('lang');					// 取得當前語言
			var localData = $.jStorage.get('langData');			// 取得當前字典檔
			
			if(lang == null)
				lang = params.lang;
			
			// 若字典檔為空或語言版本過舊 - 讀取遠端檔案
			if( localData == null || currentVer != params.version){
				alert('Load by Remote...');
				$.ajax({
					type: "GET",
					url: params.file,
					dataType: "xml",
					success: function(xml) {
						$.jStorage.set('langVersion', params.version);
						$.jStorage.set("langData",xml);
						$("body").changeLang({lang: lang, langData: xml, file: params.file});
					}
				});	
			}
			// 讀取Local Storage
			else {
				//alert('Load by Local...');
				$("body").changeLang({lang: lang, langData: localData, file: params.file});
			}
			
		}
		
		/**
		* 修改語言
		*/
		$.fn.changeLang = function(params){
			
			if(params) $.extend(defaults, params);
			
			$.jStorage.set('lang', defaults.lang);
			
			// 存取Local字典檔案
			var localLangData = defaults.langData;
			var tags = new Array();
			var source_tags = new Array();
			var title_tags = new Array();

			// 讀取XML檔案到陣列中
			$(localLangData).find('text').each(function(){
				var textId = $(this).attr("id");
				var text = $(this).find(defaults.lang).text();
				var source = $(this).find(defaults.lang + '_src').text();
				var title = $(this).find(defaults.lang + '_title').text();
				
				tags[textId] = text;
				source_tags[textId] = source;
				title_tags[textId] = title;
			});	
			
			// 取代.js .css檔案
			for(var i = 0; i < defaults.css.length; i++)
				replacejscssfile("styles/" + defaults.css[i] + "_" + language + ".css", "styles/" + defaults.css[i] + "_" + params.lang + ".css", "css");
			for(var i = 0; i < defaults.js.length; i++)
				replacejscssfile("styles/" + defaults.js[i] + "_" + language + ".js", "styles/" + defaults.js[i] + "_" + params.lang + ".js", "js");
			language = params.lang;
			
			// 搜尋標籤並取代文字
			$.each($("*"), function(i, item) {
				// 取代文字
				var values = $(item).attr("langtag");
				if(values != null) {
					$(item).text(tags[values]);
					$(item).attr('src', source_tags[values]);
					$(item).attr('title', title_tags[values]);
				}
			});
			
			// 執行CallBack函數
			for(var i = 0; i < callBackMethod.length; i++) {
				callBackMethod[i]();
			}

		};

		// 新增changLang的CallBack函式
		publicMethod.addLangInitHandler = function(fn){
			callBackMethod.push(fn);
		}
		
		// 透過$['langChanger'].langTag()取得目標字串
		publicMethod.langTag = function(tag){
			var localLangData = $.jStorage.get("langData");
			var aTexts = new Array();
			
			// load xml file
			$(localLangData).find('text').each(function()
			{
				var textId = $(this).attr("id");
				var text = $(this).find(language).text();					
				aTexts[textId] = text;
			});
		
			// return langTag's String
			if(tag != null) {				
				return aTexts[tag];					
			}		
			return "can't not read the language file";
	
		};	
		
		/**
		* Create js/css file
		*/
		this.createjscssfile = function(filename, filetype){
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
		this.replacejscssfile = function(oldfilename, newfilename, filetype){
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
		
})(jQuery);