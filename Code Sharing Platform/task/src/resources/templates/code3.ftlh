<#-- @ftlvariable name="code" type="java.lang.String" -->
<#-- @ftlvariable name="time" type="java.lang.Number" -->
<#-- @ftlvariable name="date" type="java.lang.String" -->
<#-- @ftlvariable name="views" type="java.lang.Number" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <meta charset="UTF-8">
    <title>Code</title>
</head>
<body>
<!--/*@thymesVar id="date" type="java"*/-->
<span id="load_date">${date}</span>

<#if viewsrest gt 0>
<#--<span id="views_restriction" th:text="${views}  more views allowed"></span>-->
<span id="views_restriction">${views}  more views allowed</span>
</#if>
<#if timerest gt 0>
<span id="time_restriction">The code will be available for ${time}  seconds</span>
</#if>
<!--<span id="time_restriction" th:text="${time}"></span>-->
<!--<span id="views_restriction" th:text="${views}"></span>-->
<!--/*@thymesVar id="code" type="java"*/-->
<pre id="code_snippet" ><code>${code}</code></pre>
</body>
</html>