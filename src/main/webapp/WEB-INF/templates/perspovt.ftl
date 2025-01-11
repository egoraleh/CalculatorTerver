<link rel="stylesheet" href="${contextPath}/styles.css">
<html lang="ru" charset="UTF-8">
<head>
    <title>
        Перестановки с повторениями
    </title>
</head>
<body>
<div class="field">
    <div class="formula">
        <h2 class="name">Перестановки с повторениями</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=перестановки_с_повторениями.jpg"
             style="width: 300px; height: 200px">
    </div>
    <div class="post">
        <form method='POST'>
            <#list 1..x as i>
                <p><span>Введите n${i}: </span></p>
                <p><input class="input" name="n${i}" type="number"></p>
            </#list>
            <button class="btn" type="submit">Посчитать</button>
        </form>
    </div>
</div>
<div class="answer">
    <#if incorrect??>
        <p>Введённые n должны принимать значения большие или равные 1.</p>
    <#else>
        <#if answer??>
            <p>Ответ:</p>
            <p>${answer}</p>
        </#if>
    </#if>
</div>
</body>
</html>