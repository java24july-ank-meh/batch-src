angular.module('demoApp', []); //Empty brackets for dependencies

angular.module('demoApp').run(function ($rootScope){
  $rootScope.favoriteColor = 'red';
  $rootScope.firstName = "Rahman";
});

angular.module('demoApp').directive("customDirective", function(){
  'use strict';
  return {template: "{{caves.length}}"};
});

angular.module('demoApp').filter("customFilter", function() {
  return function(inCaves) {
    let outCaves = [];
    angular.forEach(inCaves, function(cave) {
      if(!cave.isPermanent) {
        outCaves.push(cave);
      }
    });
    return outCaves;
  };
});