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
                <li><a href="/issues">Issues</a></li>
                <li class="active"><a href="/chat">Chat</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container wrapper">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">#reactor on gitter</h3>
        </div>
        <div class="panel-body">
            <dl class="dl-horizontal" id="chat-messages">
            </dl>
        </div>
    </div>
</div>
<script type="text/javascript" src="/webjars/jquery/2.1.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="application/javascript">

    $(function () {
        var appendChatMessage = function (message) {
            var chatZone = $("#chat-messages");
            chatZone.append($("<dt/>").text(message.fromUser.displayName))
                    .append($("<dd/>").text(message.text));
        }

    });
</script>
</body>
</html>