app.controller('indexController',function ($scope,$controller,planService) {

    $controller('baseController',{$scope:$scope});

    $scope.findAllPlan=function () {
        planService.findAll().success(function (resopnse) {
            $scope.list = resopnse
        })
    }


    $scope.setCurrentPlan=function (planId) {
        alert(planId)
        $scope.currentPlan.planId = planId

    }


})