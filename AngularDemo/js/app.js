angular.module('demoApp', []); //Empty brackets for dependencies

angular.module('demoApp').run(function ($rootScope){
  $rootScope.favoriteColor = 'red';
  $rootScope.firstName = "Rahman";
});