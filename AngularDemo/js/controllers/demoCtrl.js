angular.module('demoApp').controller('demoCtrl', function demoCtrl($scope) {
  $scope.firstName = "Mehrab";
  $scope.newFirstName = "Merv";
  $scope.people = [{name:'Robert', state:'NC'}, {name:'Louis', state:'TX'}, {name:'Jesse', state:'NY'}];

  $scope.changeName = function() {
    $scope.firstName = $scope.newFirstName;
  };

  $scope.myFunction = function(myEvent) {
    $scope.x = myEvent.clientX;
    $scope.y = myEvent.clientY;
  }
}); 