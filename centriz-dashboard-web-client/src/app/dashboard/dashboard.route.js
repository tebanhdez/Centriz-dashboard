(function() {
  'use strict';

  angular
    .module('centriz')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
    .state('dashboard', {
        url: '/dashboard',
        templateUrl: 'app/dashboard/view.html',
        controller: 'DashboardController as vm'
      })
    .state('dashboard.metrics', {
      url: '/metrics',
      templateUrl: 'app/dashboard/views/metrics/view.html',
      controller: 'MetricsController as vm'
    });
  }
})();