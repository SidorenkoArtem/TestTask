<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Add Log Messages</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<div>
    <div>
        <input placeholder="Tag" id="tag"/>
    </div>
    <div>
        <input placeholder="Message" id="messageId"/>
    </div>
    <div>
        <input placeholder="Ex" id="ex"/>
    </div>
    <div>
        <input type="submit" onclick="sendLogMessages()"/>
    </div>
</div>
</body>
<script>
    function sendLogMessages() {
        var mas = [];
        var logMessage = {
            tag : $("#tag").val(),
            message : $("#messageId").val(),
            ex : $("#ex").val()
        };
        mas.push(logMessage);
        $.ajax({
            type : "POST",
            dataType: "text",
            contentType : "application/json",
            url : "/log-messages/set-log-messages",
            data : JSON.stringify(mas),
            success : function(result) {
                console.log(result);
            },
            error : function(e) {
                alert("Error!");
                console.log("ERROR: " + e);
            }
        });
    }
</script>
</html>