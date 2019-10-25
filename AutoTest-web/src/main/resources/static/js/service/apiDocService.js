app.service("apiDocService",function ($http) {

    this.findAll=function () {
        return $http.get("../apiDoc/findAll")
    }


    this.findOne=function (id) {
        return $http.get("../apiDoc/findOne?id="+id)
    }

    this.add=function (entity) {
        return $http.post("../apiDoc/add", entity)
    }

    this.del = function (ids) {
        return $http.get("../apiDoc/del?ids="+ids)
    }

    this.update=function (entity) {
        return $http.post("../apiDoc/update", entity)
    }

    this.findPage=function (page, size) {
        return $http.get("../apiDoc/findAll?page="+page+"&size="+size)
    }

    // this.search=function (page, size, searchEntity) {
    //     return $http.post('../brand/search.do?page='+page+'&size='+size, searchEntity)
    // };

    this.selectOptionList=function () {
        return $http.get("../apiDoc/optionList")
    }

})