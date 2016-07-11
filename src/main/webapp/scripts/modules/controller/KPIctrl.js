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
              vm.data = databasesData.data; //linea correcta, se esta trabajando con Json de prueba
             /* vm.data = {
  "name": "Centriz",
  "headers": [
    {
      "name": "Unidad de negocios"
    },
    {
      "name": "KPI Primario"
    },
    {
      "name": "KPI Secundario"
    }
  ],
  "levels": [
    {
      "name": "Financiera",
      "levels": [
        {
          "name": "EBITDA",
          "levels": [
            {
              "name": "Renting",
              "levels": [
                {
                  "name": "Renting",
                  "startDate": "Jan 1, 2016 12:00:00 AM",
                  "endDate": "Dec 31, 2016 12:00:00 AM",
                  "average": 100,
                  "base": 100,
                  "tags": [
                    {
                      "name": "Location",
                      "value": "San Jose"
                    },
                    {
                      "name": "Brand",
                      "value": "Renting"
                    }
                  ],
                  "values": [
                    {
                      "date": "Jan 1, 2016 12:00:00 AM",
                      "value": 100
                    },
                    {
                      "date": "Jan 2, 2016 12:00:00 AM",
                      "value": 100
                    },
                    {
                      "date": "Jan 3, 2016 12:00:00 AM",
                      "value": 100
                    }
                  ]
                }
              ]
            }
          ]
        }
      ]
    },
    {
      "name": "Clientes",
      "levels": [
        {
          "name": "Satisfacción de Clientes1",
          "levels": [
            {
              "name": "Renting",
              "levels": [
                {
                  "name": "Renting",
                  "startDate": "Jan 1, 2016 12:00:00 AM",
                  "endDate": "Dec 31, 2016 12:00:00 AM",
                  "average": 100,
                  "base": 100,
                  "tags": [
                    {
                      "name": "Location",
                      "value": "San Jose"
                    },
                    {
                      "name": "Brand",
                      "value": "Renting"
                    }
                  ],
                  "values": [
                    {
                      "date": "Jan 1, 2016 12:00:00 AM",
                      "value": 100
                    },
                    {
                      "date": "Jan 2, 2016 12:00:00 AM",
                      "value": 100
                    },
                    {
                      "date": "Jan 3, 2016 12:00:00 AM",
                      "value": 100
                    }
                  ]
                }
              ]
            }
          ]
        }
      ]
    },
    {
      "name": "Procesos",
      "levels": [
        {
          "name": "Reduccion de gastos",
          "levels": [
            {
              "name": "Renting",
              "levels": [
                {
                  "name": "Renting",
                  "startDate": "Jan 1, 2016 12:00:00 AM",
                  "endDate": "Dec 31, 2016 12:00:00 AM",
                  "average": 100,
                  "base": 100,
                  "tags": [
                    {
                      "name": "Location",
                      "value": "San Jose"
                    },
                    {
                      "name": "Brand",
                      "value": "Renting"
                    }
                  ],
                  "values": [
                    {
                      "date": "Jan 1, 2016 12:00:00 AM",
                      "value": 100
                    },
                    {
                      "date": "Jan 2, 2016 12:00:00 AM",
                      "value": 100
                    },
                    {
                      "date": "Jan 3, 2016 12:00:00 AM",
                      "value": 100
                    }
                  ]
                }
              ]
            }
          ]
        }
      ]
    },
    {
      "name": "Crecimiento & Aprendizaje",
      "levels": [
        {
          "name": "RSC",
          "levels": [
            {
              "name": "Renting",
              "levels": [
                {
                  "name": "Renting",
                  "startDate": "Jan 1, 2016 12:00:00 AM",
                  "endDate": "Dec 31, 2016 12:00:00 AM",
                  "average": 100,
                  "base": 100,
                  "tags": [
                    {
                      "name": "Location",
                      "value": "San Jose"
                    },
                    {
                      "name": "Brand",
                      "value": "Renting"
                    }
                  ],
                  "values": [
                    {
                      "date": "Jan 1, 2016 12:00:00 AM",
                      "value": 100
                    },
                    {
                      "date": "Jan 2, 2016 12:00:00 AM",
                      "value": 100
                    },
                    {
                      "date": "Jan 3, 2016 12:00:00 AM",
                      "value": 100
                    }
                  ]
                }
              ]
            }
          ]
        }
      ]
    }
  ]
}*/
              console.log(vm.data);
            })
        }
  }]);


