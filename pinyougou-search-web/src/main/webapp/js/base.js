//定义品优购模块,不带分页
var app = angular.module('pinyougou', []);

//$sce服务写成过滤器,$sce服务的trustAsHtml方法来实现转换。信任html，高亮颜色显示
app.filter('trustHtml',['$sce',function($sce){
	return function(data){
		return $sce.trustAsHtml(data);
	}
}]);

//字符串过滤显示
app.filter('textLengthSet', function() {
	return function(value, wordwise, max, tail) {
		if (!value)
			return '';

		max = parseInt(max, 10);
		if (!max)
			return value;
		if (value.length <= max)
			return value;
		value = value.substr(0, max);
		if (wordwise) {
			var lastspace = value.lastIndexOf(' ');
			if (lastspace != -1) {
				value = value.substr(0, lastspace);
			}
		}

		return value + (tail || ' …');// '...'可以换成其它文字
	};
});