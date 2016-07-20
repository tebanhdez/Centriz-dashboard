(function() {
  'use strict';

  angular
    .module('centriz')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider ) {
    $stateProvider
      .state('login', {
        url: '/login',
        templateUrl: 'app/login/view.html'
      });
  }

})();