const CURRENT = 'dev';
// const CURRENT = 'prod'
const PROFILES = {
	'dev': {
		'online': false,
		'domain': 'http://bptop.vaiwan.com'
	},
	'test': {
		'online': false,
		'domain': 'http://test-api.xxx.com'
	},
	'prod': {
		'online': true,
		'domain': 'http://39.100.242.205:8073'
	}
};
const ENV = PROFILES[CURRENT];
Object.defineProperty(window, ENV, ENV);

//获取参数
function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return decodeURI(r[2]);
	}
	return null;
}

