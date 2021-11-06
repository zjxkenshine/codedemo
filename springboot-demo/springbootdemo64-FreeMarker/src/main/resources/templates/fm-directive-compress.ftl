<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>compress</title>
</head>
<body>
<#assign x = "    moo  \n\n   ">
(<#compress>
    1 2  3   4    5  <br/>
${x}                  <br/>
test only   <br/>

    I said, test only

</#compress>)
</body>
</html>
