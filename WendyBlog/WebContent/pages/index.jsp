
<html>
<head>
<script src="https://code.angularjs.org/1.3.9/angular.min.js"></script>
<script>
var blog = angular.module('blogApp',[]);
blog.controller('postController', function($scope) {
	$scope.posts=[{title:'first post', body:'first post body', date:"2012-04-23", comments:[{name:'wendy', comment:"wendy\'s comment", date:"2015-02-14"}]},
	              {title:'second post', body:'second post body', date:"2014-04-23"}];
});
</script>
<style>
p.title{
font-size : large;
font-weight:bold;  
}
p.body{
font-size : medium;
font-style: italic;
}
</style>
</head>
<body ng-app='blogApp'>
<div ng-controller='postController'>
<span ng-repeat="post in posts | orderBy: '-date' : reverse">
<p class = 'title'>{{post.title}}</p>
<p>Posted on: {{post.date}}</p>
<p class= 'body'>{{post.body}}</p>
<span ng-repeat="reply in post.comments | orderBy: '-date':reverse">
<p>{{reply.name}} says : {{reply.comment}}</p></span></span>
</div>
</body>
</html>