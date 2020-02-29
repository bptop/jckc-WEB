document.write("<script src='../js/profile.js'></script>");
var vm;
window.onload = function () {
	// vue实例化
	vm = new Vue({
		el: '#news',
		data: {
			list: [],
		},
	});
	// 获取页面参数type
	var type = GetQueryString("type");
	document.title = type;
	$('.head-title').html(type)
	window.list = window.getList(type, 1, 10);
	$.ajax({
		url: ENV.domain + '/article/size',
		data: {
			type: type,
		},
		success: function (res) {
			$('.M-box11').pagination({
				mode: 'fixed',
				totalData: res,
				callback: function (api) {
					getList(type, api.getCurrent(), 10);
				}
			});
		}
	});
};

function getList(type, pageNum, pageSize) {
	$.ajax({
		url: ENV.domain + "/article/articleList",
		data: {
			type: type,
			pageNum: pageNum,
			pageSize: pageSize,
		},
		success: function (res) {
			vm.list = JSON.parse(res);
			console.log(vm.list);
			vm.$forceUpdate();
		}
	})
};
$(function () {
})