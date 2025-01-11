<link rel="stylesheet" href="${contextPath}/styles.css">
<html lang="ru" charset="UTF-8">
<head>
    <title>
        Сочетания без повторений
    </title>
</head>
<body>
<div class="field">
    <div class="formula">
        <h2 class="name">Сочетания без повторений</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=сочетания_без_повторений.jpg"
             style="width: 300px; height: 200px">
    </div>
    <div class="post">
        <form method='POST'>
            <p><span>Введите n:</span>
                <input class="input" name="n" type="number">
            </p>
            <p><span>Введите k:</span>
                <input class="input" name="k" type="number">
            </p>
            <button class="btn" type="submit">Посчитать</button>
        </form>
    </div>
</div>
<div class="answer">
    <#if incorrect??>
        <p>Значения n и k должны быть больше или равны 1, n должно быть не меньше k.</p>
    <#else>
        <#if answer??>
            <p>Ответ:</p>
            <p>${answer}</p>
        </#if>
    </#if>
</div>
</body>
</html>