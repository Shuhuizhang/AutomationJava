app.service("userService",function ($http) {

    this.searchAll=function () {
        return $http.get("../manage/searchAll")
    }


    this.findOne=function (id) {
        return $http.get("../manage/findOne?id="+id)
    }

    this.create=function (entity) {
        return $http.post("../manage/create", entity)
    }

    this.del = function (ids) {
        return $http.get("../manage/del?ids="+ids)
    }

    this.update=function (entity) {
        return $http.post("../manage/update", entity)
    }

    this.selectOptionList=function () {
        return $http.get("../manage/optionList")
    }


})