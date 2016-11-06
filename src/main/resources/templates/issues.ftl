<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="Reactor Community Dashboard"/>
    <meta name="author" content="Brian Clozel and Sebastien Deleuze"/>
    <title>Reactor Community Dashboard</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Community Dashboard</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li class="active"><a href="/issues">Issues</a></li>
                <li><a href="/chat">Chat</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container wrapper">
    <h2>Reactor Core project issues</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Issue title</th>
            <th>Reported By</th>
            <th>Online?</th>
        </tr>
        </thead>
        <tbody>
		<#list issues as issue>
			<tr>
				<th scope="row">${issue.number}</th>
				<td><a href="${issue.url}">${issue.title}</a></td>
				<td>${issue.userLogin}</td>
				<td><span class="glyphicon glyphicon-${issue.userOnline?string('earphone', 'user')}" aria-hidden="true"></span></td>
			</tr>
		</#list>
        </tbody>
    </table>
</div>
<script type="text/javascript" src="/webjars/jquery/2.1.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</body>
</html>