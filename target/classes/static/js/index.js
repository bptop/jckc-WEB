document.write("<script src='./js/profile.js'></script>");
var navTop;
window.onload = function () {
	//获取首页新闻
	$.ajax({
		url: ENV.domain + "/index/articleList",
		success: function (res) {
			window.list = JSON.parse(res);
			// vue实例化
			new Vue({
				el: '#news',
				data: {
					list: window.list,
				},
			});
		}
	});
// 钉钉免登
	dd.ready(function () {
		dd.runtime.permission.requestAuthCode({
			corpId: "ding23a973f9601037ef35c2f4657eb6378f", // 企业id
			onSuccess: function (result) {
				$.ajax({
					url: ENV.domain + "/user/ddLogin",
					data: {
						code: result.code,
					},
					success: function (result) {
						if (localStorage !== JSON.stringify(JSON.parse(result).kcUser)) {
							localStorage.user = JSON.stringify(JSON.parse(result).kcUser);
						}
					}
				});
			},
			onFail: function (err) {
				alert(err)
			}
		});
	});
	// 获取nav高度
	navTop = $('#nav').offset().top;
	// 点击nav滚动页面
	$('#nav').on('click', function (e) {
		$('#nav1,#nav2,#nav3,#nav4,#nav5').removeClass('nav-selected');
		switch (e.target.id) {
			case "nav1":
				$('html,body').animate({scrollTop: $('#news1').offset().top - 32}, 100);
				$('#nav1').addClass('nav-selected');
				break;
			case "nav2":
				$('html,body').animate({scrollTop: $('#news2').offset().top - 32}, 100);
				$('#nav2').addClass('nav-selected');
				break;
			case "nav3":
				$('html,body').animate({scrollTop: $('#news3').offset().top - 32}, 100);
				$('#nav3').addClass('nav-selected');
				break;
			case "nav4":
				$('html,body').animate({scrollTop: $('#news4').offset().top - 32}, 100);
				$('#nav4').addClass('nav-selected');
				break;
			case "nav5":
				$('html,body').animate({scrollTop: $('#news5').offset().top - 32}, 100);
				$('#nav5').addClass('nav-selected');
				break;
		}
	});
};
// 导航吸顶
window.addEventListener('scroll', function () {
	let t = $('body, html').scrollTop();   // 目前监听的是整个body的滚动条距离
	let n = $('#nav').outerHeight();
	if (t > navTop) {
		$('#nav').addClass('nav-main-ad');
		$('#news1').css({"margin-top": n + 24})
	}
	else {
		$('#nav').removeClass('nav-main-ad');
		$('#news1').css({"margin-top": 8})
	}
});

function toList(res) {
	window.location.replace(ENV.domain + '/html/articleList.html?type=' + res.target.dataset.text);
}

function toArticle(res) {
	window.location.replace(ENV.domain + '/html/article.html?id=' + res);
}

