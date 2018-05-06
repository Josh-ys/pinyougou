//为了达到代码的复用和维护性，将服务进行抽取
app.service("brandService", function($http) {
	this.search = function(page, size, searchEntity) {
		return $http.post('../brand/search.do?page=' + page + '&size=' + size,
				searchEntity);
	}
	this.add = function(entity) {
		return $http.post('../brand/add.do', entity);
	}
	this.update = function(entity) {
		return $http.post('../brand/update.do', entity);
	}
	this.findOne = function(id) {
		return $http.get("../brand/findOne.do?id=" + id);
	}
	this.del = function(selectIds) {
		return $http.get('../brand/delete.do?ids=' + selectIds);
	}
	this.selectOptionList = function() {
		return $http.get('../brand/selectOptionList.do');
	}
});