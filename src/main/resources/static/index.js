var app = angular.module("test",[]);
app.controller('place',function($scope,$http){
    $http.get('http://localhost:8080/place').
    then(function(response){
        $scope.out = response.data;
    });
});