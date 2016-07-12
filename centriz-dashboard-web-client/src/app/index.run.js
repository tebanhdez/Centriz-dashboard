(function() {
  'use strict';

  angular
    .module('centrizApp')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log) {

    $log.debug('runBlock end');
  }

})();
