 //控制层 
app.controller('goodsControllerr', function($scope, $controller,$location, goodsService, itemCatService,typeTemplateService) {
	
	$controller('baseController',{$scope:$scope});//继承
	
	// 得到一级分类列表
	$scope.selectItemCat1List = function() {
		itemCatService.findByParentId(0).success(function(response) {
			$scope.itemCat1List = response;
		});
	}
	// 得到二级分类列表，采用的变量监控
	$scope.$watch("entity.goods.category1Id", function(newValue, oldValue) {
		itemCatService.findByParentId(newValue).success(function(response) {
			$scope.itemCat2List = response;
		});
	});
	// 得到三级
	$scope.$watch("entity.goods.category2Id", function(newValue, oldValue) {
		itemCatService.findByParentId(newValue).success(function(response) {
			$scope.itemCat3List = response;
		});
	});
	
	$scope.entity={ goods:[],goodsDesc:{itemImages:[],specificationItems:[]}  };
	//加载品牌列表和扩展属性，查询规格列表
	$scope.$watch("entity.goods.typeTemplateId",function(newValue, oldValue){
		typeTemplateService.findOne(newValue).success(function(response){
			 $scope.typeTemplate=response;//获取类型模板
			 $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);//品牌列表
			 if($location.search()['id']==null){//当id为空也就是说增加的时候加载
				 $scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems);//扩展属性
			 }
			 
		});
		//查询规格列表
		typeTemplateService.findSpecList(newValue).success(function(response){
			$scope.findSpecList = response;
		});
	});
	
	
	//查询实体 (商品修改)
	$scope.findOne = function(){
		var id = $location.search()['id'];//获取参数值
		if(id == null){
			return;
		}
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;	
				editor.html(response.goodsDesc.introduction);//商品介绍
				$scope.entity.goodsDesc.itemImages = JSON.parse($scope.entity.goodsDesc.itemImages);//图片回显
				//显示扩展属性
				response.goodsDesc.customAttributeItems = JSON.parse($scope.entity.goodsDesc.customAttributeItems);
				//显示规格勾选转换
				$scope.entity.goodsDesc.specificationItems = JSON.parse($scope.entity.goodsDesc.specificationItems);
				//SKU商品列表
				for(var i = 0;i<response.itemList.length;i++){
					$scope.entity.itemList[i].spec = JSON.parse($scope.entity.itemList[i].spec);
				}
			}
		);
	}
	//sku页面勾选
	$scope.checkAttributeValue = function(specName,optionName){
		var items = $scope.entity.goodsDesc.specificationItems;
		var object = $scope.searchObjectByKey(items,'attributeName',specName);
		if(object != null){
			if(object.attributeValue.indexOf(optionName) >= 0){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
});	
