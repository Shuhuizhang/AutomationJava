app.service("planService",function ($http) {

    // this.findAll=function () {
    //     return $http.get("../plan/findAll")
    // }


    this.findOne=function (id) {
        return $http.get("../plan/findOne?id="+id)
    }

    this.create=function (entity) {
        return $http.post("../plan/create", entity)
    }

    this.del = function (ids) {
        return $http.get("../plan/del?ids="+ids)
    }

    this.update=function (entity) {
        return $http.post("../plan/update", entity)
    }

    this.selectOptionList=function () {
        return $http.get("../plan/optionList")
    }

    this.addToPlan=function (entity) {
        return $http.post("../plan/addToPlan",entity)
    }

    this.search=function (page,size, planEntity) {
        return $http.post("../plan/search?page="+page+"&size="+size,planEntity)
    }

    this.run=function (id) {
        return $http.get("../plan/run?id="+id)
    }

})