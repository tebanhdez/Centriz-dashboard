  'use strict';

  angular.module('KPI')
    .controller('KPIctrl', ['KPIService', '$scope', 
      function(KPIService, $scope) {
        var vm = this;
        $scope.data = {};

        getData();
        function getData() {
          KPIService.getDataFromServer()
            .then(function(databasesData){
              vm.data = databasesData.data;
              console.log(vm.data);
            })
        }
  }]);
