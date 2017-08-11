angular.module('demoApp').controller('forestCtrl', function($scope) {
  $scope.caves = [
    {id: 1, name:"Cave of Wonders", isPermanent: "true"},
    {id: 2, name:"Unicorn Cave", isPermanent: "true"},
    {id: 3, name:"Batcave", isPermanent: "true"}
  ];

  $scope.addCave = function() {
    if ($scope.newCaveId && $scope.newCaveName) {
      $scope.caves.push({id: $scope.newCaveId, name: $scope.newCaveName, isPermanent: false});
      $scope.newCaveId = "";
      $scope.newCaveName = "";
      $scope.inputStyle = {background:'white'};
    } else {
      $scope.inputStyle = {background:'red'};
    }
  }

  $scope.removeCave = function() {
    let oldCaves = $scope.caves;
    $scope.caves = [];
    angular.forEach(oldCaves, function(cave){
      if (!(cave.rm)) {
        $scope.caves.push(cave);
      }
    });
  };
});