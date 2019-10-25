app.controller("apiDocController", function ($scope,$controller,apiDocService) {

    $controller('baseController',{$scope:$scope});//继承

    // $scope.findAll=function () {
    //     apiDocService.findAll().success(function (response) {
    //         $scope.list = response
    //     })
    // };

    $scope.findOne=function (id) {
        apiDocService.findOne(id).success(function (response) {
            $scope.entity = response
        })
    }

    $scope.findPage=function (page,size) {
        apiDocService.findPage(page,size).success(function (response) {
            $scope.list = response.row
            $scope.paginationConf.totalItems = response.total
        })
    };


    $scope.save=function () {
        var object = null;
        if($scope.entity.id != null){
            object = apiDocService.update($scope.entity);
        }else{
            object = apiDocService.add($scope.entity);
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
        apiDocService.del($scope.selectIds).success(function (response) {
            if(response.success){
                $scope.reloadList();
                $scope.selectIds=[];
            }else{
                alert(response.message)}
        })
    };

    // $scope.searchEntity={};
    //
    $scope.search=function (page,size) {
        apiDocService.findPage(page,size).success(function (response) {
            $scope.list = response.row
            $scope.paginationConf.totalItems = response.total
        })

    }

})