;(function(global,$){
	
	function ajax(params){
		var multipart = params && params.multipart?true:false;
		var contentType = 'application/json; charset=utf-8';
		var dataType = 'json';
		var jwt = global.sessionStorage.getItem('imk');
		var options = $.extend({dataType:dataType,contentType:contentType},params);
		if(multipart){
			options.cache = false;
			options.contentType = false;
    	    options.processData = false;
		}
		options.beforeSend = function(jqXhr,settings){
			var headers = jqXhr.getAllResponseHeaders();
			if(jwt){
				jqXhr.setRequestHeader('Authorization','Imking '+jwt)
			}
			// show loading
			global._loading.show();
		};
		options.complete = function(jqXhr,textStatus){
			// textStatus: "success", "notmodified", "nocontent", "error", "timeout", "abort", or "parsererror"
			// close loading
			console.log('complete',jqXhr,textStatus)
			global._loading.hide();
			if(401 == jqXhr.status){
				document.location.href = '/auth/login.html?redirectUrl='+window.encodeURIComponent(window.location.href);
			}
		};
		options.error = function(jqXhr,status){ // "timeout" "error" "abort" "parsererror"
			console.log('error',jqXhr,status)
		}
		//console.log(options)
		$.ajax(options);
		// res, status,jqxhr
		// err,status
	}
	
	var _ajax = {
			get:function(options){
				options.method = 'GET';
				ajax(options);
			},
			post:function(options){
				options.method = 'POST';
				ajax(options);
			},
			put:function(options){
				options.method = 'PUT';
				ajax(options);
			},
			del:function(options){
				options.method = 'DELETE';
				ajax(options);
			},
			multipart:function(options){
				// 
				ajax(options);
			}
	};
	
	global._ajax = _ajax;
	
}(window,jQuery,undefined));

(function(global,jQuery){
	var _loading = {
		show:function(options){
			var loadingEl = $('#loading');
			if(loadingEl.length<=0){
				loadingEl = $('<div id="loading" class="loading show"><div class="loading-box"><div class="mask"></div><div class="loading-text">请稍候。。。</div></div></div>');
				$('body').append(loadingEl);
			}else{
				loadingEl.removeClass('hide').addClass('show');
			}
		},
		hide:function(){
			$('#loading').remove();
		}
	}
	global._loading = _loading;
	
})(window,jQuery,undefined)
