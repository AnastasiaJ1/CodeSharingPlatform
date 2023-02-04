<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="./mystyle.css">
    <meta charset="UTF-8">
    <title>Create</title>
</head>
<body>
<script>
    function send() {
        let object = {
            "code": document.getElementById("code_snippet").value,
            "time": document.getElementById("time_snippet").value,
            "views": document.getElementById("views_snippet").value
        };

        let json = JSON.stringify(object);

        let xhr = new XMLHttpRequest();
        xhr.open("POST", '/api/code/new', false)
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(json);

        if (xhr.status == 200) {
            alert("Success!");
        }
    }</script>
<p>
<pre><b>Code:</b></pre>
<textarea id="code_snippet"> // write your code here </textarea>
</p>
<!--<span>Time restriction:</span>-->
<!--<textarea id="time_snippet"> 0 </textarea>-->
<p>
<form>
    <pre><b>Time restriction: </b></pre>
    <input type="number" id="time_snippet" placeholder=0>
</form>
</p>
<p>
<form>
    <pre><b>Views restriction: </b></pre>
    <input type="number" id="views_snippet" placeholder=0>
</form>
</p>
<button id="send_snippet" type="submit" onclick="send()">Submit</button>
</body>
</html>