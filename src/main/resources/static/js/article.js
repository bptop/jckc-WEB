document.write("<script src='../js/profile.js'></script>");
window.onload = function () {
	// 获取页面参数type
	var id = GetQueryString("id");
	$.ajax({
		url: ENV.domain + '/article/article',
		data: {
			id: id,
		},
		success: function (res) {
			window.article = JSON.parse(res);
			// vue实例化
			new Vue({
				el: '#article',
				data: {
					article: JSON.parse(res),
				},
			});
			document.title = res.aarticleTitle;
			$('.main').append(article.acontent);
			console.log(article.acontent)
		}
	});
};


