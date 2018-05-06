//控制层 
app.controller('goodsController', function($scope, $controller,$location, goodsService,
		uploadService, itemCatService,typeTemplateService) {

	$controller('baseController', {
		$scope : $scope
	});// 继承

	// 读取列表数据绑定到表单中
	$scope.findAll = function() {
		goodsService.findAll().success(function(response) {
			$scope.list = response;
		});
	}

	// 分页
	$scope.findPage = function(page, rows) {
		goodsService.findPage(page, rows).success(function(response) {
			$scope.list = response.rows;
			$scope.paginationConf.totalItems = response.total;// 更新总记录数
		});
	}

	// 查询实体
	$scope.findOne = function(id) {
		goodsService.findOne(id).success(function(response) {
			$scope.entity = response;
		});
	}

	// 保存
	$scope.save = function() {
		$scope.entity.goodsDesc.introduction = editor.html();
		var serviceObject;// 服务层对象
		if ($scope.entity.goods.id != null) {// 如果有ID
			serviceObject = goodsService.update($scope.entity); // 修改
		} else {
			serviceObject = goodsService.add($scope.entity);// 增加
		}
		serviceObject.success(function(response) {
			if (response.success) {
				alert("保存成功！！");
				$scope.entity = {};
				editor.html("");
				$(":checkbox[name = 'fis']").prop("checked", false);
			} else {
				alert(response.message);
			}
		});
	}

	// 保存
	$scope.add = function() {
		$scope.entity.goodsDesc.introduction = editor.html();
		goodsService.add($scope.entity).success(function(response) {
			if (response.success) {
				alert("商品添加成功！！");
				location.href="goods.html";//跳转到商品列表页
				/*$scope.entity = {};
				editor.html("");
				$(":checkbox[name = 'fis']").prop("checked", false);*/
			} else {
				alert(response.message);
			}
		});
	}

	// 批量删除
	$scope.dele = function() {
		// 获取选中的复选框
		goodsService.dele($scope.selectIds).success(function(response) {
			if (response.success) {
				$scope.reloadList();// 刷新列表
			}
		});
	}

	$scope.searchEntity = {};// 定义搜索对象

	// 搜索
	$scope.search = function(page, rows) {
		goodsService.search(page, rows, $scope.searchEntity).success(
				function(response) {
					$scope.list = response.rows;
					$scope.paginationConf.totalItems = response.total;// 更新总记录数
					//将加载的数据的id加在当前页的所有记录的id的数组
					for(var i = 0;i<$scope.list.length;i++){
						$scope.AllRecordsId.push($scope.list[i].id);
					}
				});
	}

	$scope.image_entity = [];
	// 图片上传
	$scope.uploadFile = function() {
		uploadService.uploadFile().success(function(response) {
			if (response.success) {
				// 如果上传成功，取出url
				$scope.image_entity.url = response.message;// 设置文件地址
			} else {
				alert(response.message);
			}
		});
	}

	// 定义页面实体结构
	$scope.entity = {
		goods : {},
		goodsDesc : {
			itemImages : []
		}
	};
	// 添加图片列表
	$scope.add_image_entity = function() {
		$scope.entity.goodsDesc.itemImages.push($scope.image_entity);
	}

	// 删除图片
	$scope.del_image_entity = function(index) {
		$scope.entity.goodsDesc.itemImages.splice(index, 1);
	}

	// 得到一级分类列表
	$scope.selectItemCat1List = function() {
		itemCatService.findByParentId(0).success(function(response) {
			$scope.itemCat1List = response;
		});
	}

	// 得到二级分类列表，采用的变量监控
	$scope.$watch("entity.goods.category1Id", function(newValue, oldValue) {
	//	$scope.entity.goods.category3Id = "";
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

	// 得到模板id
	$scope.$watch("entity.goods.category3Id", function(newValue, oldValue) {
		itemCatService.findOne(newValue).success(function(response) {
			$scope.entity.goods.typeTemplateId = response.typeId;// 更新模板ID
		});
	});
	
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
	
	
	
	$scope.entity={ goodsDesc:{itemImages:[],specificationItems:[]}  };
	
	$scope.updateSpecAttribute = function($event,name,value){
		var object = $scope.searchObjectByKey($scope.entity.goodsDesc.specificationItems,'attributeName',name);
		if(object != null){
			if($event.target.checked){
				object.attributeValue.push(value);
			}else{
				object.attributeValue.splice(object.attributeValue.indexOf(value),1);
				if(object.attributeValue.length == 0){
					$scope.entity.goodsDesc.specificationItems.splice($scope.entity.goodsDesc.specificationItems.indexOf(object),1);
				}
			}
		}else{
			$scope.entity.goodsDesc.specificationItems.push({"attributeName":name,"attributeValue":[value]});
		}
	}
	
	//创建SKU列表
	$scope.createItemList = function(){
		//初始化
		$scope.entity.itemList = [{spec:{},price:0,num:9999,status:'0',isDefault:'0'}];
		var items = $scope.entity.goodsDesc.specificationItems;
		if(items.length==0){
			$scope.entity.itemList = [];
		}
		for(var i = 0;i<items.length;i++){
			$scope.entity.itemList = addColumn($scope.entity.itemList,items[i].attributeName,items[i].attributeValue);
		}
	}
	
	//添加列值 
	addColumn = function(list,columnName,columnValue){
		var newList = [];//新的集合
		for(var i = 0;i < list.length; i++){
			var oldRows = list[i];
			for(var j = 0;j < columnValue.length; j++){
				var newRows = JSON.parse(JSON.stringify(oldRows));//深克隆
				newRows.spec[columnName] = columnValue[j];
				newList.push(newRows);
			}
		}
		return newList;
	}
	
	$scope.status=['未审核','已审核','审核未通过','关闭'];//商品状态
	
	$scope.itemCatList=[];//商品分类列表
	$scope.findItemCatList = function(){
		itemCatService.findAll().success(function(response){
			for(var i = 0;i<response.length;i++){
				$scope.itemCatList[response[i].id] = response[i].name;
			}
		});
	}
	
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
	
	$scope.calcel = function(){
		var r=confirm("确定取消操作返回商品管理页面?")
		if(r == true){
			location.href = "goods.html";
		}
	}
	
	//上下架
	$scope.updateIsMarketable = function(isMarketable){
		goodsService.updateIsMarketable($scope.selectIds,isMarketable).success(function(response){
			if(response.success){
				$scope.reloadList();
			}else{
				$(":checkbox[name = 'as']").prop("checked",false);
				alert(response.message);
			}
		});
	}
});
