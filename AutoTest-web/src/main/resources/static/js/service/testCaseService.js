app.service("testCaseService",function ($http) {

    this.findOne=function (id) {
        return $http.get("../cases/findOne?id="+id)
    }

    this.create=function (entity) {
        return $http.post("../cases/create", entity)
    }

    this.del = function (ids) {
        return $http.get("../cases/del?ids="+ids)
    }

    this.update=function (entity) {
        return $http.post("../cases/update", entity)
    }

    this.findPage=function (page, size) {
        return $http.get("../cases/findAll?page="+page+"&size="+size)
    }

    this.search=function (page, size, searchEntity) {
        return $http.post('../cases/search?page='+page+'&size='+size, searchEntity)
    };

    this.moduleOption=function () {
        return $http.get("../cases/getModuleOption")
    }

    this.methodOption=function (module) {
        return $http.get("../cases/getMethodOption?module="+module)
    }


})