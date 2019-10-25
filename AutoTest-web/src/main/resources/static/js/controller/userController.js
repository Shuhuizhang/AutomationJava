app.controller("userController", function ($scope,$controller,userService) {

    $controller('baseController',{$scope:$scope});//继承


    $scope.findOne=function (id) {
        userService.findOne(id).success(function (response) {
            $scope.entity = response
        })
    }

    
    $scope.save=function () {
        var object = null;
        if($scope.entity.id != null){
            object = userService.update($scope.entity);
        }else{
            object = userService.create($scope.entity);
        }
        object.success(function (response) {
            if (response.success){
                $scope.reloadList();
            }else {
                alert(response.message)
            }
        })

    };

    $scope.del=function () {
        userService.del($scope.selectIds).success(function (response) {
            if(response.success){
                $scope.reloadList();
                $scope.selectIds=[];
            }else{
                alert(response.message)}
        })
    };

   
    $scope.search=function () {
        userService.searchAll().success(function (response) {
            $scope.list = response
            $scope.paginationConf.totalItems = response.total
        })

    }

})