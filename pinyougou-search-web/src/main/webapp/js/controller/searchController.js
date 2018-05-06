app.controller('searchController', function($scope,$location,searchService) {
	
	//定义搜索对象的结构 category：商品分类
	$scope.searchMap = {'keywords':'','category':'','brand':'','price':'','spec':{},'currPage':1,'pageSize':20,'sortField':'','sort':''};
	
	// 搜索
	$scope.search = function() {
		$scope.searchMap.currPage= parseInt($scope.searchMap.currPage) ;//转换为数字
		searchService.search($scope.searchMap).success(function(response) {
			$scope.resultMap = response;// 返回搜索结果
			
			buildPageLabel();//构建分页栏
		});
	}
	
	//构建分页栏
	buildPageLabel = function(){
		$scope.pageLabel = []; //新增分页栏属性	
		var firstPage  = 1;	//开始页码
		var lastPage = $scope.resultMap.totalPages;//得到最后页码
		$scope.firstDot=true;//前面有点
		$scope.lastDot=true;//后边有点	
		if($scope.resultMap.totalPages>5){//如果总页数大于5页,显示部分页码
			if($scope.searchMap.currPage<=3){//如果当前页小于等于3
				lastPage = 5; //前5页
				$scope.firstDot=false;	//前面没点
			}else if($scope.searchMap.currPage >= lastPage-2){//如果当前页大于等于最大页码-2
				firstPage = $scope.resultMap.totalPages-4; //后5页	
				$scope.lastDot=false;	//后面没点
			}else{//显示当前页为中心的5页
				firstPage = $scope.searchMap.currPage-2;
				lastPage = $scope.searchMap.currPage+2;
			}
		}else{
			$scope.firstDot=false;//前面没点
			$scope.lastDot=false;//后边没点	
		}
		for(var i = firstPage;i<=lastPage; i++){
			$scope.pageLabel.push(i);
		}
	}
	
	//分页查询
	$scope.queryByPage = function(currPage){
		if(currPage < 1 || currPage > $scope.resultMap.totalPages){
			return ;
		}
		$scope.searchMap.currPage = currPage;
		$scope.search();
	}
	
	
	$scope._key = function(){
		if (event.keyCode == 13)
			$scope.search();
	}
	
	//添加搜索项方法
	$scope.addSearchItem = function(key,value){
		//如果点击的是分类或者是品牌
		if(key == "category"||key=="brand"||key=="price"){
			$scope.searchMap[key] = value;
		}else{
			$scope.searchMap.spec[key] = value;
		}
		//调用搜索
		$scope.search();
	}
	
	//移除搜索项
	$scope.removeSearchItem = function(key){
		if(key == "category"||key=="brand"||key=="price"){
			$scope.searchMap[key] = '';
		}else{
			delete $scope.searchMap.spec[key];
		}
		//调用搜索
		$scope.search();
	}
	
	//判断当前页为第一页
	$scope.isTopPage = function(){
		if($scope.searchMap.currPage == 1){
			return true;
		}else{
			return false;
		}
	}
	
	//判断当前页是否未最后一页
	$scope.isEndPage = function(){
		if($scope.searchMap.currPage == $scope.resultMap.totalPages){
			return true;
		}else{
			return false;
		}
	}
	
	//设置排序规则
	$scope.sortSearch = function(sortField,sort){
		$scope.searchMap.sortField = sortField;
		$scope.searchMap.sort = sort;
		
		$scope.search();
	}
	
	//判断关键字是不是品牌
	$scope.keywordsIsBrand = function(){
		for(var i = 0;i<$scope.resultMap.brandList.length;i++){
			if($scope.searchMap.keywords.indexOf($scope.resultMap.brandList[i].text)>=0){
				return true;
			}
		}
		return false;
	}
	
	//加载查询字符串
	$scope.loadkeywords = function(){
		$scope.searchMap.keywords = $location.search()['keywords'];
		$scope.search();
	}
});
