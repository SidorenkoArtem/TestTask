<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Add Log Messages</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
</head>
<body>
<div>
    <div>
        <input placeholder="AppId" id="AppId"/>
    </div>
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
    <div>
        <input placeholder="AppID через запятую" id="appIdList"/>
        <input type="submit" onclick="getLogMessages()"/>
    </div>
    <div id="tableSpace">
        <table  id="table_id" class="display" style="width:100%">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>AppId</th>
                    <th>Tag</th>
                    <th>TimeStamp</th>
                    <th>Message</th>
                    <th>Ex</th>
                </tr>
            </thead>
         <tbody>
        </tbody>
    </table>
    </div>
</div>
</body>
<script>
    var table;
    $(document).ready( function () {
        table = $('#table_id').DataTable();
    });

    $("#appIdList").keypress(function(event){
        event = event || window.event;
        if (event.charCode && event.charCode!=0 && event.charCode!=44 && (event.charCode < 48 || event.charCode > 57) )
            return false;
    });

    function sendLogMessages() {
        var mas = [];
        var logMessage = {
            appId : $("#AppId").val(),
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

    function getLogMessages() {
        var appIdList = $("#appIdList").val();
        var masAppId = appIdList.split(",");
        table.clear();
        $.ajax({
            type : "POST",
            dataType: "json",
            data : JSON.stringify(masAppId),
            contentType : "application/json",
            url : "/log-messages/get-log-messages",
            success : function(result) {
                 result.forEach(function(element){
                     table.row.add([
                         element.id,
                         element.appId,
                         element.tag,
                         element.message,
                         element.timeStamp,
                         element.ex
                     ]).draw(false);
                 });
            },
            error : function(e) {
                alert("Error!");
                console.log("ERROR: " + e);
            }
        });
    }
</script>
</html>