app.controller("indexController",function($scope,loginService){
	//获取当前登录人的用户名
	$scope.showLoginName = function(){
		loginService.loginName().success(
				function(response){
					$scope.loginName  = response.loginName;
				}
		);
	}
});