//控制层 
app.controller('itemCatController', function($scope, $controller,
		itemCatService,typeTemplateService) {

	$controller('baseController', {
		$scope : $scope
	});// 继承

	// 读取列表数据绑定到表单中
	$scope.findAll = function() {
		itemCatService.findAll().success(function(response) {
			$scope.list = response;
		});
	}

	// 分页
	$scope.findPage = function(page, rows) {
		itemCatService.findPage(page, rows).success(function(response) {
			$scope.list = response.rows;
			$scope.paginationConf.totalItems = response.total;// 更新总记录数
		});
	}

	// 查询实体
	$scope.findOne = function(id) {
		itemCatService.findOne(id).success(function(response) {
			$scope.entity = response;
		});
	}

	// 保存
	$scope.save = function() {
		var serviceObject;// 服务层对象
		if ($scope.entity.id != null) {// 如果有ID
			serviceObject = itemCatService.update($scope.entity); // 修改
		} else {
			$scope.entity.parentId = $scope.parentId;
			serviceObject = itemCatService.add($scope.entity);// 增加
		}
		serviceObject.success(function(response) {
			if (response.success) {
				// 重新查询
				$scope.findByParentId($scope.parentId);// 重新加载
			} else {
				alert(response.message);
			}
		});
	}

	// 批量删除
	$scope.dele = function() {
		// 获取选中的复选框
		itemCatService.dele($scope.selectIds).success(function(response) {
			if (response.success) {
				if($scope.selectIds != null){
					$scope.selectIds=[];
				}
				$scope.findByParentId($scope.parentId);// 重新加载
			}else{
				alert(response.message);
				$("#selall").prop("checked", false);
				$(":checkbox[name = 'as']").prop("checked", false);
				if($scope.selectIds != null){
					$scope.selectIds=[];
				}
			}
		});
	}

	$scope.searchEntity = {};// 定义搜索对象
	// 搜索
	$scope.search = function(page, rows) {
		itemCatService.search(page, rows, $scope.searchEntity).success(
				function(response) {
					$scope.list = response.rows;
					$scope.paginationConf.totalItems = response.total;// 更新总记录数
				});
	}

	// 查询时记录上级ID
	$scope.parentId = 0;// 上级ID
	//记录当前页的所有记录的id
	// 根据parent_id查询
	$scope.findByParentId = function(parentId) {
		// 记住上级ID
		$scope.parentId = parentId;
		itemCatService.findByParentId(parentId).success(
			function(response) {
				//将加载的数据的id加在当前页的所有记录的id的数组
				for(var i = 0;i<response.length;i++){
					$scope.AllRecordsId.push(response[i].id);
				}
				$scope.list = response;
			}
		);
	}

	// 面包屑
	$scope.grade = 1;// 默认为1级
	// 设置级别
	$scope.setGrade = function(value) {
		$scope.grade = value;
	}
	$scope.selectList = function(p_entity) {
		// 当前级别为1
		if ($scope.grade == 1) {
			$scope.entity_1 = null;
			$scope.entity_2 = null;
		} else if ($scope.grade == 2) {
			// 当前级别为2
			$scope.entity_1 = p_entity;
			$scope.entity_2 = null;
		} else if ($scope.grade == 3) {
			// 当前级别为3
			$scope.entity_2 = p_entity;
		}
		$scope.findByParentId(p_entity.id);
	}
	
	// 模板选项
	$scope.typeTemplate = {};
	$scope.selectOptionList = function(){
		typeTemplateService.selectOptionList().success(
			function(response){
				$scope.typeTemplate = response;
		});
	};
	
});
