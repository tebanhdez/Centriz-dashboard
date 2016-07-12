(function() {
  'use strict';

  angular
    .module('centrizApp')
    .controller('MetricsCtrl', MetricsCtrl);

  MetricsCtrl.$inject = ['MetricService', 'UserDataService'];

  /* @ngInject */
  function MetricsCtrl(MetricService) {
    var vm = this;

    vm.data = {};

    getData();

    function getData() {
      MetricService.getDataFromService()
      .then(function(metricsData){
        vm.data = metricsData.data;
      })
    }
  }
})();