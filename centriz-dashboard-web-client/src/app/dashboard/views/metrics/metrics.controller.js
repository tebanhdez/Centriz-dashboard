(function() {
  'use strict';

  angular
    .module('centrizApp')
    .controller('MetricsController', MetricsController);

  MetricsController.$inject = ['MetricService'];

  /* @ngInject */
  function MetricsController(MetricService) {
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