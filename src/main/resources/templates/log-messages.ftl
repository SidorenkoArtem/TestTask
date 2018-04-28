<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Add Log Messages</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<div>
    <input placeholder="Tag" id="tag"/>
    <input placeholder="Message" id="messageId"/>
    <input placeholder="Ex" id="ex"/>
    <input type="submit" onclick="sendLogMessages()"></input>
</div>
</body>
<script>
    function sendLogMessages() {
        var logMessage = {
            tag : $("#tag").val(),
            message : $("#messageId").val(),
            ex : $("#ex").val()};
        $.ajax({
            type : "POST",
            url : "/log-messages/set-log-messages",
            data : logMessage
        });
    }
</script>
</html>