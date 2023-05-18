<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quest</title>
    <link href="static/main.css" rel="stylesheet">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <script src="<c:url value="/static/main.js"/>"></script>
</head>
<body>
    <div class="survey-container">
        <div class="survey-container__options hide">
            <div class="survey-container__header"></div>
            <div>
                <input type="radio" id="optionA" name="option" value="">
                <label for="optionA"></label>
            </div>
            <div>
                <input type="radio" id="optionB" name="option" value="">
                <label for="optionB"></label>
            </div>
        </div>
        <div class="survey-container__result-message"></div>
        <div class="survey-container__button">
            <button id="start" class="button button_start" onclick="onGameStart()">Начать игру</button>
            <button id="submit" class="button button_submit hide" onclick="onSubmit()">Ответить</button>
            <button id="reset" class="button button_reset hide" onclick="onReset()">Начать заново</button>
        </div>
    </div>
    <div class="games-counter">Число игр: ${gamesCounter}</div>
</body>
</html>
