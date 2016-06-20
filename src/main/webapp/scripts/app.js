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
angular
  .module('centrizApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ui.router',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/login");
    $stateProvider
      .state('centriz', {
        url: '/',
        templateUrl: 'views/main.html'
      })
      .state('login', {
        url: '/login',
        templateUrl: 'views/login.html',
        //controller: 'LoginCtrl'
      })
  });
