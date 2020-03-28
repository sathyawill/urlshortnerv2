<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Url Shortening</title>
        <link href="/css/main.css" rel="stylesheet">
    </head>
    <body>
        
        <#if urlShortener?? >
       <h3> Your submitted data</h3><br>
        
        Original Url: ${urlShortener.url}<br>
        <br>
        Shortened: <a href="/${urlShortener.shortened}">${urlShortener.shortened}</a><br>
        <#else>
        <h2>Enter the Url to shorten</h2>
        <form action="/url/shortner" method="post">
            Url:<br>
            <input type="text" name="url">
            <br><br>
            <input type="submit" value="Submit">
        </form>
        </#if>
    </body>
</html>