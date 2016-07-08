  'use strict';

  angular.module('KPI')
    .controller('KPIctrl', ['KPIService', '$scope', 
      function(KPIService, $scope) {
        //var data = this;
        $scope.data = {};

        getData();
        function getData() {
          KPIService.getDataFromServer()
            .then(function(databasesData){
              $scope.data = databasesData.data;
            })
        }
  }]);
