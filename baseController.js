//基本控制层
app.controller('baseController', function ($scope) {
    //为了防止页面初始化的时候重复刷新，所做的处理。
    // count：用来记录记录的次数。
    // ins：用来记录记录页面刷新的次数
    //区别：双个条件，因为页面进来有两次刷新，第一次是初始化，第二次也是，都会向后台发送请求。但第一次没有的话就没有第二次，第二次又的话会影响页面的切换。
    // 所以用两个，让页面初始化第一次的同时不会进行第二次刷新但也不会影响后面的切换，因为第二次是进行了的，只是没向服务器发送请求。
    // 两个变量都是递增，不同的是第二个会一直增加，只是把服务器的所有请求的第二次请求屏蔽，其余的都只有一次。
    var count = 0;
    var ins = 0;
    $scope.paginationConf = {
        // 分页控件配置
        // currentPage:当前页
        // totalItems :总记录数
        // itemsPerPage:每页记录数
        // perPageOptions:选择每页显示的条数
        // 分页选项 onChange:当页码变更后自动触发的方法
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            if (count >= 1 && ins != 1) {
                count = 0;
            }
            if (count == 0) {
                $scope.reloadList();// 重新加载
            }
            count++;
            ins++;
        }
    };

    // 为了后面调用的方便，把调用分页的方法封装为一个方法
    $scope.reloadList = function () {
        $scope.findByPage($scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    }
});