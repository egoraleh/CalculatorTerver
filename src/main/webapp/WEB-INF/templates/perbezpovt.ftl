<link rel="stylesheet" href="${contextPath}/styles.css">
<html lang="ru" charset="UTF-8">
<head>
    <title>
        Перестановки без повторений
    </title>
</head>
<body>
<div class="field">
    <div class="formula">
        <h2 class="name">Перестановки без повторений</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=перестановки_без_повторений.jpg"
             style="width: 300px; height: 200px">
    </div>
    <div class="post">
        <form method='POST'>
            <p><span>Введите n: </span></p>
            <p><input class="input" name="n" type="number"></p>
            <button class="btn" type="submit">Посчитать</button>
        </form>
    </div>
</div>
<div class="answer">
    <#if incorrect??>
        <p>Значение n должно быть больше или равное 1.</p>
    <#else>
        <#if answer??>
            <p>Ответ:</p>
            <p>${answer}</p>
        </#if>
    </#if>
</div>
</body>
</html>