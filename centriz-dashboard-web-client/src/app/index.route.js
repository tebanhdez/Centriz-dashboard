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
        controller: 'DashboardController'
      });

    $urlRouterProvider.otherwise('/login');
  }

})();
