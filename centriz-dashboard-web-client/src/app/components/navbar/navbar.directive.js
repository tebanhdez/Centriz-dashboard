(function() {
  'use strict';

  angular
    .module('centrizApp')
    .directive('mainNavbar', mainNavbar);

  /** @ngInject */
  function mainNavbar() {
    var directive = {
      restrict: 'E',
      templateUrl: 'app/components/navbar/view.html'
    };
    return directive;
  }
})();
