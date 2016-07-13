(function() {
  'use strict';

  angular
  .module('centriz')
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
