const CONTENT_TYPE = 'application/json;charset=UTF-8';

function getOptions(onSuccess) {
    $.ajax({
        url: '/play',
        type: 'GET',
        contentType: CONTENT_TYPE,
        async: false,
        success: onSuccess,
    });
}

function onGameStart() {
    fadingIn();

    fadingOut(function (){
        getOptions(function (data) {
            const startButton = document.getElementById('submit');
            const submitButton = document.getElementById('start');
            const optionsContainer = document.querySelector('.survey-container__options');

            submitButton.classList.add('hide');
            startButton.classList.remove('hide');
            optionsContainer.classList.remove('hide');

            setRadioInput(data)
        })

    });


}

function setRadioInput({description, options}) {
    const [optionConfigA, optionConfigB] = options;

    const optionsHeader = document.querySelector('.survey-container__header');

    const inputA = document.getElementById('optionA');
    const inputB = document.getElementById('optionB');
    const labelA = document.querySelector('label[for="optionA"]');
    const labelB = document.querySelector('label[for="optionB"]');

    labelA.innerText = optionConfigA.description;
    labelB.innerText = optionConfigB.description;
    optionsHeader.innerText = description;

    inputA.setAttribute('value', optionConfigA.id)
    inputB.setAttribute('value', optionConfigB.id)
}

function onEnd(message) {
    const messageResultContainer = document.querySelector('.survey-container__result-message');
    const optionsContainer = document.querySelector('.survey-container__options');
    const startButton = document.getElementById('submit');
    const resetButton = document.getElementById('reset');

    optionsContainer.classList.add('hide');
    startButton.classList.add('hide');
    resetButton.classList.remove('hide');
    messageResultContainer.innerText = message;
}

function onSubmit() {
    fadingIn();

    const inputA = document.getElementById('optionA');
    const inputB = document.getElementById('optionB');

    const answerOptionId = inputA.checked ? inputA.value : inputB.value;

    $.ajax({
        url: `/play?answerOptionId=${answerOptionId}`,
        type: 'POST',
        contentType: CONTENT_TYPE,
        async: false,
        success: function ({success, message}) {
            fadingOut(function (){
                if (success) {
                    if (message) {
                        onEnd(message);
                        return;
                    }
                    getOptions(function (data) {
                        setRadioInput(data)
                    })
                } else {
                    onEnd(message);
                }
            })
        }
    });
}

function onReset(){
    $.ajax({
        url: '/reset',
        type: 'POST',
        contentType: CONTENT_TYPE,
        async: false,
        success: function (){
            location.reload();
        }
    });
}

function fadingIn(){
    const surveyContainer = document.querySelector('.survey-container');
    surveyContainer.classList.add('fade-in-hide');
    surveyContainer.classList.remove('fade-out-show');
}

function fadingOut(onFadeOut){
    setTimeout(() => {
        const surveyContainer = document.querySelector('.survey-container');
        surveyContainer.classList.remove('fade-in-hide');
        surveyContainer.classList.add('fade-out-show');

        onFadeOut();

    },500);
}
