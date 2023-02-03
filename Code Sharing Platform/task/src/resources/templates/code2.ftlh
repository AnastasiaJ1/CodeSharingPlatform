<#-- @ftlvariable name="codes" type="java.util.Collection<platform.models.Code>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
</head>
<body>
<#list codes as item>
    <div>
        <span>${item.date}</span>
        <pre>${item.code}</pre>
    </div>
</#list>
</body>
</html>