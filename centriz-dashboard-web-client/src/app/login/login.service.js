(function() {
  'use strict';

  angular
    .module('centriz')
    .service('LoginService', LoginService);

  LoginService.$inject = ['$http'];

  /* @ngInject */
  function LoginService($http) {
  }

})();