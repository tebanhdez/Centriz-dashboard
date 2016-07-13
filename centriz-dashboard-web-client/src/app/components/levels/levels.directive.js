(function() {
  'use strict';

  angular
  .module('centriz')
  .directive('levels', levels);

  /** @ngInject */
  function levels() {
    var directive = {
      restrict: 'E',
      templateUrl: 'app/components/levels/view.html'
    };

    return directive;
  }

})();
