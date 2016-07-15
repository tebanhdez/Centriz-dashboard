(function() {
  'use strict';

  angular
    .module('centriz')
    .controller('MetricsController', MetricsController);

  MetricsController.$inject = ['MetricService'];

  /* @ngInject */
  function MetricsController(MetricService) {
    var vm = this;
    vm.showDiv = showDiv;
    vm.isDivDisplayed = false;

    vm.data = {};

    getData();

    function getData() {
      MetricService.getDataFromService()
      .then(function(metricsData){
        vm.data = metricsData.data;
      })
    }

    function showDiv(){
      vm.isDivDisplayed = !vm.isDivDisplayed;  
    }
  }
})();