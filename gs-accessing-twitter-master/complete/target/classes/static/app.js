'use strict';


var App = angular.module('course', []);

App.controller('MainController', function ($scope, $http) {
    
  $http.get('users').success(function (data) {
    $scope.users = data;
  });

  $scope.addContact = function () {
    $http.post('users', $scope.user).success(function (data) {
      $scope.users = data;
      $scope.user = {};
    });
  };

  $scope.remove = function (contact) {
    $http.delete('contact', {params: {userId: user.id}}).success(function (data) {
      $scope.users = data;
    });
  };

});