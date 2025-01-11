<link rel="stylesheet" href="${contextPath}/styles.css">
<html lang="ru" charset="UTF-8">
<head>
    <title>
        Введите количество n
    </title>
</head>
<body>
<form method="POST">
    <p>Введите количество n</p>
    <input class="input" type="number" name="ncount">
    <button class="btn" type="submit">Продолжить</button>
    <#if incorrect??>
        <p>Количество введённых n должно быть не меньше 1.</p>
    </#if>
</form>
</body>
</html>