(function() {
  'use strict';

  angular
    .module('centrizApp')
    .directive('leftSidebar', leftSidebar);

  /** @ngInject */
  function leftSidebar() {
    var directive = {
      restrict: 'E',
      templateUrl: 'app/components/left-sidebar/view.html'
    };
    return directive;
  }
})();
