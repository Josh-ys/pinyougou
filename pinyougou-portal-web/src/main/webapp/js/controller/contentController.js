app.controller('contentController',function($scope,contentService){

	//广告控制层（运营商后台）
	$scope.contentList = [];//广告集合	
	$scope.findByCategoryId = function(categoryId){
		contentService.findByCategoryId(categoryId).success(function(response){
			$scope.contentList[categoryId] = response;
		});
	}
	
	//搜索跳转
	$scope.search = function(){
		location.href="http://localhost:9106/search.html#?keywords="+$scope.keywords;
	}
	
});