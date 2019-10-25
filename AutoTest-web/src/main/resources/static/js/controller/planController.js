app.controller("planController", function ($scope,$controller,planService,testCaseService) {

    $controller('baseController',{$scope:$scope});//继承


    $scope.findOne=function (id) {
        planService.findOne(id).success(function (response) {
            $scope.entity = response
        })
    }


    $scope.save=function () {
        var object = null;
        if($scope.entity.id != null){
            object = planService.update($scope.entity);
        }else{
            object = planService.create($scope.entity);
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
        planService.del($scope.selectIds).success(function (response) {
            if(response.success){
                $scope.reloadList();
                $scope.selectIds=[];
            }else{
                alert(response.message)}
        })
    };


    $scope.searchEntity={};

    $scope.search=function (page,size) {
        planService.search(page,size,$scope.searchEntity ).success(function (response) {
            $scope.list = response.row
            $scope.paginationConf.totalItems = response.total
        })

    }


    $scope.run=function (id) {
        planService.run(id).success(function (response) {
            if (response.success){
                alert(response.message);
            }else {
                alert(response.message)
            }
        })
    }

    $scope.moduleOption={data:[]}

    $scope.methodOption={data:[]}

    $scope.findModuleOption=function () {
        testCaseService.moduleOption().success(function (response) {
            $scope.moduleOption={data:response}
        })
    }


    $scope.$watch('entity.module',function(newValue,oldValue){
        testCaseService.methodOption(newValue).success(
            function(response){
                $scope.methodOption={data:response};
            }
        );

    });

})