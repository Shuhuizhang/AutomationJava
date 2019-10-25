app.controller("testCaseController", function ($scope,$controller,testCaseService,userService,apiDocService, planService) {

    $controller('baseController',{$scope:$scope});//继承


    $scope.findOne=function (id) {
        testCaseService.findOne(id).success(function (response) {
            $scope.entity = response
        })
    }

    $scope.findPage=function (page,size) {
        testCaseService.findPage(page,size).success(function (response) {
            $scope.list = response.row
            $scope.paginationConf.totalItems = response.total
        })
    };


    $scope.save=function () {
        var object = null;
        if($scope.entity.id != null){
            object = testCaseService.update($scope.entity);
        }else{
            object = testCaseService.create($scope.entity);
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
        testCaseService.del($scope.selectIds).success(function (response) {
            if(response.success){
                $scope.reloadList();
                $scope.selectIds=[];
            }else{
                alert(response.message)}
        })
    };

    $scope.testPlan={planId: 0,caseList:[]}

    $scope.addToPlan=function(){
        $scope.testPlan.caseList = $scope.selectIds
        planService.addToPlan($scope.testPlan).success(function (response) {
            if(response.success){
                $scope.reloadList();
                $scope.selectIds=[];
            }else{
                alert(response.message)}
        })
    }


    $scope.userList={data:[]}

    $scope.apiList = {data:[]}

    $scope.planList = {data:[]}



    //读取测试用户列表
    $scope.findUserList=function(){
        userService.selectOptionList().success(
            function(response){
                $scope.userList={data:response};
            }
        );
    }


    //读取api列表
    $scope.findApiList=function(){
        apiDocService.selectOptionList().success(
            function(response){
                $scope.apiList={data:response};
            }
        );
    }

    //读取api列表
    $scope.findPlanList=function(){
        planService.selectOptionList().success(
            function(response){
                $scope.planList={data:response};
            }
        );
    }


    $scope.searchEntity={};

    $scope.search=function (page,size) {
        testCaseService.search(page,size,$scope.searchEntity ).success(function (response) {
            $scope.list = response.row
            $scope.paginationConf.totalItems = response.total
        })

    }

    $scope.findModuleOption=function () {
        testCaseService.moduleOption().success(function (response) {
            $scope.moduleList=response
        })
    }
})