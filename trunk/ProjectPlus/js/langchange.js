/* ------------------------------------------------------
 * -----  LangChanger+ ver1.5 (��h��HTML�ݩʦP�ɧ󴫥\��) ----+
 * -----------------------------------------------------+
 * �@�� : Augus                                         +
 * -----------------------------------------------------+
 * LangChanger+ �O�@��jQuery������A�����Ѥ@��²�檺��k+
 * ���A�b�e�ݳB�z�h��y�������D�A�ثe���ѥH�U�\��       +
 * -----------------------------------------------------+ 
 * I.	�̤��P�y���������P���Ϥ�                        +
 * II.	�̤��P�y���������P��js/css�ɮ�     				+
 * III.	�ϥ�langTag()�禡���o�����r��					+
 * IV.	�Ȧs�r���ɦbLocal��								+
 * V. 	�Ȧs�Τ�]�w�bLocal��							+
 * VI.  �h��HTML�ݩʤ����\��							+	
 --------------------------------------------------------
 
 ****************************************************************************
 *  �`�N�ƶ� !!!!!!
 ****************************************************************************  
 *
 * 1.4���[�JLocal Storage�\��A�̿��B�~��jQuery����jStorage
 * �]���b�ϥ�LangChanger+�e�����ޤJ(import)jQuery.js��jStorage.js���js�ɮ�
 *
 *
 ****************************************************************************
 
 ****************************************************************************
 * �p��ϥ�LangChanger+ ?
 **************************************************************************** 
 * 1) �ޤJ�H�Ujs�ɮסA�åB�n�HjQuery, jStorage.js/langChanger.js/langchange.js ���ǤޤJ
 *		
 * 		<script src="jQuery.js" type="text/javascript"></script>	
 * 	    <script src="jStorage.js" type="text/javascript"></script>
 *      <script src="langChanger.js" type="text/javascript"></script>
 *
 **************************************************************************** 
 * 2) �ϥΥH�U���榡�A�Ыرz�ۤv���r��xml�ɮסC
 *    
 * 		<content>
 *	  		<text id="your_tagId">
 *		  		<fr>LangChange - un Plug-in jQuery</fr>
 *		  		<en>LangChange - a jQuery Plug-in</en>
 *	  		</text>
 *			// �Ϥ��d��
 *			<text id="country">
 *				<fr_src>http://van.tiao.com/images/upload/team/48_48/france.gif</fr_src>
 *				<en_src>http://img3.douban.com/icon/g294805-1.jpg</en_src>
 *				<fr_title>�k��</fr_title>
 *				<en_title>�^��</en_title>		
 *			</text> 
 * 		</content>
 *    
 ****************************************************************************
 * 3) �[�Jlangtag�ݩʨ�html���Ҥ��C
 *    
 * 		<body>
 * 			<p langtag="your_tagId"></p>
 * 			<p langtag="your_tagId"></p>
 * 		</body>
 *    
 *
 ****************************************************************************
 * 4) �b�A�������W�I�s(ready)�ϥ�$['langChanger'].langInit({�Ѽ�})�A�w�]���p�U�|�۰ʧ����y������
 *    
 * 		$(document).ready(function(){
 * 			$['langChanger'].langInit({version:2, lang: "en", file: "files/lang-example.xml", css: ['main','front']});
 * 		}
 *    
 *    ###### Important : your js/css file must be use this format #####
 *    ###### [name]_[language].js/[name]_[language].css			  #####
 *
 **************************************************************************** 
 * 5) �A�]�i�H��ʩI�s$['langChanger'].changeLang()��k���ܭ����y��
 *   
 *		// ����'�k��'�y�t
 *  	$("body").changeLang({lang: "fr", file: "files/lang-example.xml"});	
 *    
 **************************************************************************** 
 
 
 **************************************************************************** 
 *  ��1 : �ϥ�javaScript�ഫ�r�����(langTag)���o�r��
 **************************************************************************** 
 * �b�@�Ǳ��p�U�A�|��Server�ݦ^�Ǵ��ܰT�����Ȥ�A���A�L�k�o���Τ�ثe�y���A
 * �]���o�ɭԧA�i�H��ܦ^�Ǧr�����(langTag)����k�A�A��Server�u�ݭn�^�ǹ�����
 * �r�����(langTag)�A�y���ഫ���u�@�N�i�H�浹�e�ݪ�langChanger�ӧ����C
 *
 *   $['langChanger'].langTag('���ҦW��')
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
 *  ��2 : �[�JCallBack�禡
 **************************************************************************** 
 * �b�Y�ǰʺA�����p�U�A�@�w�n����½Ķ������~��B�z���u�@�A���o�Ӥu�@�һ�
 * ���e�O�ݭn�r�嵲�G���A�o�ɧA�i�H�[�JCallBack��Ƶ�LangChanger�ALangChanger
 * �|�b½Ķ��I�s�o�Ǩ�ơC
 *
 *   ex:
 *      // Alert�Y��Tag�@�w�O�n����Init�����~�i��F��
 *		function initPage(){
 *			alert($['langChanger'].langTag('myTag'));		
 *		}
 *
 *      $['langChanger'].addLangInitHandler(initPage);
 *
 *
 ***************************************************************************** 
 *  ��3 : ����r�媩��
 *****************************************************************************
 * �r���ɷ|�ϥ�Local Storage�覡�s��b�Ȥ�ݡA���p�G�r���ɧ�s�ɦp��q���Τ�
 * ��s�O?
 *
 * �ϥΤ�k : �b$['LangChanger'].langInit()���[�J�Ѽ�version�ӱ���r�媩��
 *
 * ���p�Ĥ@�������ڭ̳]�wversion��1 :
 * $['LangChanger'].langInit({version: 1});
 * �o�ɭ�LangChanger�|�x�s����1�b�Ȥ᪺Local Storage��
 *
 * ����r���s�F���wversion��2:
 * $['LangChanger'].langInit({version: 2});
 * �b�o�Ӯɭ�LangChanger�N�|�o�{�Ȥ�LocalStorage���������P�����P�A�]���N�|���s
 *
 *
 **************************************************************************** 
 */

(function($){
		// ���F�קK��ƦW�٪��Ĭ�A�b�o�Ӫ����}�l�A�ϥ�$['langChanger']���覡�s��LangChanger
		this.langChanger = 'langChanger'; 		// �Ψӵ��~���s�����W�١A�ϥ�$['langChanger']�Y�i�s��������k
		this.publicMethod;						// ����Method
		this.callBackMethod = new Array();		// �bchangeLang��ҩI�s��CallBack�禡
		this.language = "en"; 					// �x�s�W����ܪ��y�� language record
		this.version = "0";
		this.defaults = {						// �w�]����l��
			file: '/files/lang-example.xml',
			lang: 'tw',  // �w�]�Ȭ��c�餤��
			css: [''],	// your css file [ex: main_en.css, main_fr.css ==> then put "main" on this]
			js: [''],
			langData: '',
		};
		
		// ���}����k
		var publicMethod = $.fn[langChanger] = $[langChanger] = function (options, callback) {}				
		
		/**
		* ��l�ƨ禡
		*/
		publicMethod.langInit = function(params){	
			
			if(params) $.extend(defaults, params);
			// ��e�y������ : ��r���ɻݨD��s�ɡA�u�ݭn��ʦ��ƫȤ�ݦ۰ʧ�s
		
			var currentVer = $.jStorage.get('langVersion');		// ���o��e�r�媩��
			var lang = $.jStorage.get('lang');					// ���o��e�y��
			var localData = $.jStorage.get('langData');			// ���o��e�r����
			
			if(lang == null)
				lang = params.lang;
			
			// �Y�r���ɬ��ũλy�������L�� - Ū�������ɮ�
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
			// Ū��Local Storage
			else {
				//alert('Load by Local...');
				$("body").changeLang({lang: lang, langData: localData, file: params.file});
			}
			
		}
		
		/**
		* �ק�y��
		*/
		$.fn.changeLang = function(params){
			
			if(params) $.extend(defaults, params);
			
			$.jStorage.set('lang', defaults.lang);
			
			// �s��Local�r���ɮ�
			var localLangData = defaults.langData;
			var tags = new Array();
			var source_tags = new Array();
			var title_tags = new Array();

			// Ū��XML�ɮר�}�C��
			$(localLangData).find('text').each(function(){
				var textId = $(this).attr("id");
				var text = $(this).find(defaults.lang).text();
				var source = $(this).find(defaults.lang + '_src').text();
				var title = $(this).find(defaults.lang + '_title').text();
				
				tags[textId] = text;
				source_tags[textId] = source;
				title_tags[textId] = title;
			});	
			
			// ���N.js .css�ɮ�
			for(var i = 0; i < defaults.css.length; i++)
				replacejscssfile("styles/" + defaults.css[i] + "_" + language + ".css", "styles/" + defaults.css[i] + "_" + params.lang + ".css", "css");
			for(var i = 0; i < defaults.js.length; i++)
				replacejscssfile("styles/" + defaults.js[i] + "_" + language + ".js", "styles/" + defaults.js[i] + "_" + params.lang + ".js", "js");
			language = params.lang;
			
			// �j�M���Ҩè��N��r
			$.each($("*"), function(i, item) {
				// ���N��r
				var values = $(item).attr("langtag");
				if(values != null) {
					$(item).text(tags[values]);
					$(item).attr('src', source_tags[values]);
					$(item).attr('title', title_tags[values]);
				}
			});
			
			// ����CallBack���
			for(var i = 0; i < callBackMethod.length; i++) {
				callBackMethod[i]();
			}

		};

		// �s�WchangLang��CallBack�禡
		publicMethod.addLangInitHandler = function(fn){
			callBackMethod.push(fn);
		}
		
		// �z�L$['langChanger'].langTag()���o�ؼЦr��
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