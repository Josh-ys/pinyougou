app.service('searchService', function($http) {
	//搜索服务层
	this.search = function(searchMap) {
		return $http.post('itemSearch/search.do',searchMap);
	}
});