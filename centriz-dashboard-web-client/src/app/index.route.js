(function() {
  'use strict';

  angular
    .module('centrizApp')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('login', {
        url: '/login',
        templateUrl: 'app/dashboard/view.html',
        controller: 'DashboardCtrl',
        controllerAs: 'dashboard'
      });

    $urlRouterProvider.otherwise('/dashboard');
  }

})();
