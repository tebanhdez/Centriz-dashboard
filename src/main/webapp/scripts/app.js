'use strict';

/**
 * @ngdoc overview
 * @name centrizApp
 * @description
 * # centrizApp
 *
 * Main module of the application.
 */
  // declare modules
angular.module('partials', []);
angular.module('centrizApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ui.router',
    'ngSanitize',
    'ngTouch',
    'partials'
  ])
  .config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/dashboard"); //$urlRouterProvider.otherwise("/login");  por default a login
    $stateProvider
      .state('login', {
        url: '/login',
        templateUrl: 'views/login.html',
        //controller: 'LoginCtrl'
      })
      .state('dashboard', {
        url: '/dashboard',
        templateUrl: 'views/dashboard.html',
        //controller: 'LoginCtrl'
      })
  });
