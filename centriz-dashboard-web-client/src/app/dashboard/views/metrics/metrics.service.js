(function() {
  'use strict';

  angular
    .module('centriz')
    .service('MetricService', MetricService);

  MetricService.$inject = ['$http'];

  /* @ngInject */
  function MetricService($http) {

    this.getDataFromService = getDataFromService;

    function getDataFromService() {

      var request = {
        method: 'GET',
        url: 'http://'+location.hostname+':9999/centriz-dashboard-web-service/rest/v1/metric/20160101/20161231',
        headers: {
          'Content-Type': 'application/json'
        }
      };

      return $http(request);
    }

  }

})();