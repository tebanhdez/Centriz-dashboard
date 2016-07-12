(function() {
  'use strict';

  angular
    .module('centrizApp')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
    .state('dashboard', {
        url: '/dashboard',
        templateUrl: 'app/dashboard/view.html',
        controller: 'DashboardCtrl'
      })
    .state('dashboard.metrics', {
      url: '/metrics',
      templateUrl: 'app/dashboard/views/metrics/view.html',
      controller: 'MetricsCtrl as vm'
    });
  }
})();