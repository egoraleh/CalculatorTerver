<link rel="stylesheet" href="${contextPath}/styles.css">
<html lang="ru" charset="UTF-8">
<head>
    <title>
        Калькулятор вероятностей
    </title>
</head>
<body>
<div class="field">
    <div class="formula">
        <h2 class="name">Сочетания без повторений</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=сочетания_без_повторений.jpg"
             style="width: 300px; height: 200px">
    </div>
    <br>
    <div class="post">
        <form method='GET' action="${contextPath}/soch-bez-povt">
            <button class="btn" type="submit">
                Посчитать
            </button>
        </form>
    </div>
</div>
<br>
<div class="field">
    <div class="formula">
        <h2 class="name">Сочетания с повторениями</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=сочетания_с_повторениями.jpg"
             style="width: 300px; height: 200px">
    </div>
    <br>
    <div class="post">
        <form method="GET" action="${contextPath}/soch-s-povt">
            <button class="btn" type="submit">
                Посчитать
            </button>
        </form>
    </div>
</div>
<br>
<div class="field">
    <div class="formula">
        <h2 class="name">Размещения без повторений</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=размещение_без_повторений.jpg"
             style="width: 300px; height: 200px">
    </div>
    <br>
    <div class="post">
        <form method='GET' action="${contextPath}/razm-bez-povt">
            <button class="btn" type="submit">
                Посчитать
            </button>
        </form>
    </div>
</div>
<br>
<div class="field">
    <div class="formula">
        <h2 class="name">Размещения с повторениями</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=размещение_с_повторениями.jpg"
             style="width: 300px; height: 200px">
    </div>
    <br>
    <div class="post">
        <form method='GET' action="${contextPath}/razm-s-povt">
            <button class="btn" type="submit">
                Посчитать
            </button>
        </form>
    </div>
</div>
<br>
<div class="field">
    <div class="formula">
        <h2 class="name">Перестановки без повторений</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=перестановки_без_повторений.jpg"
             style="width: 300px; height: 200px">
    </div>
    <br>
    <div class="post">
        <form method='GET' action="${contextPath}/per-bez-povt">
            <button class="btn" type="submit">
                Посчитать
            </button>
        </form>
    </div>
</div>
<br>
<div class="field">
    <div class="formula">
        <h2 class="name">Перестановки с повторениями</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=перестановки_с_повторениями.jpg"
             style="width: 300px; height: 200px">
    </div>
    <br>
    <div class="post">
        <form method='GET' action="${contextPath}/per-s-povt-helper">
            <button class="btn" type="submit">
                Посчитать
            </button>
        </form>
    </div>
</div>
<br>
<div class="field">
    <div class="formula">
        <h2 class="name">Вероятность, что среди выбранных все окажутся мечеными</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=все_меченные.jpg"
             style="width: 300px; height: 200px">
    </div>
    <br>
    <div class="post">
        <form method='GET' action="${contextPath}/vse-mech">
            <button class="btn" type="submit">
                Посчитать
            </button>
        </form>
    </div>
</div>
<br>
<div class="field">
    <div class="formula">
        <h2 class="name">Вероятность, что среди выбранных мечеными окажется какая-то часть</h2>
        <img class="image" src="${contextPath}/show-picture?image_name=не_все_меченные.jpg"
             style="width: 300px; height: 200px">
    </div>
    <br>
    <div class="post">
        <form method='GET' action="${contextPath}/ne-vse-mech">
            <button class="btn" type="submit">
                Посчитать
            </button>
        </form>
    </div>
</div>
</body>
</html>