(function() {
  'use strict';

  angular
  .module('centriz')
  .directive('level', level);

  /** @ngInject */
  function level() {
    var directive = {
      restrict: 'E',
      templateUrl: 'app/components/level/view.html'
    };

    return directive;
  }

})();
