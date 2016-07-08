'use strict';

angular.module('partials')

.directive('mainNavbar', function() {
  return {
    restrict: 'E',
    templateUrl: "views/partials/navbar.html"
  }
})

.directive('sidebarLeft', function() {
  return {
    restrict: 'E',
    templateUrl: "views/partials/sidebar-left.html"
  }
})

.directive('sidebarRigth', function() {
  return {
    restrict: 'E',
    templateUrl: "views/partials/sidebar-rigth.html"
  }
})

.directive('workArea', function() {
  return {
    restrict: 'E',
    templateUrl: "views/partials/work-areaAngular.html"
  }
})

.directive('indicador', function() {
  return {
    restrict: 'E',
    templateUrl: "views/partials/KPI.html"
  }
});
