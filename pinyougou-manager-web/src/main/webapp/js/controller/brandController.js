app.controller('brandController', function($scope, $http,$controller,brandService) {
		
		//继承，实质就是把继承过来的js中的$scope让他和本js中的$scope相等，这实质是伪继承
		$controller('baseController',{$scope:$scope});
	
		 $scope.searchEntity={};//定义搜索对象 ,初始化， 避免页面进来加载的时候没有条件，也就没有对象
		//请求分页数据的获取
		 $scope.search = function(page,size){
			 brandService.search(page,size,$scope.searchEntity).success(
				function(response){
					$scope.paginationConf.totalItems = response.total;	//更新总记录数
					$scope.list = response.rows;	//显示当前页的数据
				}		 
			 );
			 $scope.idss();
		 }
		
		//添加和修改
		$scope.save = function(){
			var object=null;
			if($scope.entity.id != null){ //如果有ID
				object = brandService.update($scope.entity); //则执行修改方法 
			}else{
				object = brandService.add($scope.entity); //否则执行添加方法
			}
			object.success(
				function(response){
					if(response.success){
						$scope.reloadList();//重新加载
						$('#editModal').modal('hide');
					}else{
						alert(response.message);
					}
				}		
			);
		}
		
		//更新查询
		$scope.findOne = function(id){
			brandService.findOne(id).success(
				function(response){
					$scope.entity = response;
				}		
			);
		}
		
		//删除
		$scope.del = function(){
			brandService.del($scope.selectIds).success(
				function(response){
					if(response.success){
						$scope.reloadList();//重新加载
					}else{
						alert(response.message);
					}
				}		
			);
		}
	});