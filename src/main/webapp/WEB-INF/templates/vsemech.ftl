<link rel="stylesheet" href="${contextPath}/styles.css">
<html lang="ru" charset="UTF-8">
<head>
    <title>
        Все меченные
    </title>
</head>
<body>
<div class="field">
    <div class="formula">
        <h2  class="name">Вероятность, что среди выбранных все окажутся мечеными</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=все_меченные.jpg"
             style="width: 300px; height: 200px">
    </div>
    <div class="post">
        <form method='POST'>
            <p><span>Введите n: </span></p>
            <p><input class="input" name="n" type="number"></p>
            <p><span>Введите m: </span></p>
            <p><input class="input" name="m" type="number"></p>
            <p><span>Введите k: </span></p>
            <p><input class="input" name="k" type="number"></p>
            <button class="btn" type="submit">Посчитать</button>
        </form>
    </div>
</div>
<div class="answer">
    <#if incorrect??>
        <p>Значения n, m и k должны быть больше или равны 1, n должно быть не меньше k, а k должно быть меньше m.</p>
    <#else>
        <#if answer??>
            <p>Ответ:</p>
            <p>${answer}</p>
        </#if>
    </#if>
</div>
</body>
</html>