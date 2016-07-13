(function() {
  'use strict';

  angular
    .module('centriz')
    .directive('leftbar', leftbar);

  /** @ngInject */
  function leftbar() {
    var directive = {
      restrict: 'E',
      templateUrl: 'app/components/leftbar/view.html',

    };

    return directive;
  }

})();
