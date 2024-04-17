const questions = [
    {
        question: "Which is largest animal in the world?",
        answers:[
            {text: "Shark", correct: "false"},
            {text: "Elephant", correct: "false"},
            {text: "Blue Whale", correct: "true"},
            {text: "Monkey", correct: "false"},
        ]
    }
    
];

function populateQuestions(){

    const apiUrl = 'http://localhost:8090/api/quiz/tags';
    fetch(apiUrl)
  .then(response => {
    // Check if the response is successful
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    // Parse the JSON data from the response
    return response.json();
  })
  .then(data => {
    // Work with the JSON data
    data.forEach((singleQuestion)=>{
        questions.push({
            question: singleQuestion.question,
            answers:[
                {text: singleQuestion.answers.answer_a, correct: singleQuestion.correct_answers.answer_a_correct},
                {text: singleQuestion.answers.answer_b, correct: singleQuestion.correct_answers.answer_b_correct},
                {text: singleQuestion.answers.answer_c, correct: singleQuestion.correct_answers.answer_c_correct},
                {text: singleQuestion.answers.answer_d, correct: singleQuestion.correct_answers.answer_d_correct},
            ]
        });
    });
    console.log(data);
  })
  .catch(error => {
    // Handle any errors that occurred during the fetch
    console.error('There was a problem with the fetch operation:', error);
  });
}

const questionElement = document.getElementById("question");
const answerButtons = document.getElementById("answer-buttons");
const nextButton = document.getElementById("next-btn");


let currentQuestionIndex = 0;
let score = 0;

function startQuiz(){
    currentQuestionIndex = 0;
    score = 0;
    nextButton.innerHTML = "Next";
    showQuestion();
}

function showQuestion(){
    resetState();
    let currentQuestion = questions[currentQuestionIndex];
    let questionNo = currentQuestionIndex + 1;
    questionElement.innerHTML = questionNo + ") " + currentQuestion.question;
    currentQuestion.answers.forEach(answer => {
        const button = document.createElement("button")
        button.innerHTML = answer.text;
        button.classList.add("btn");
        answerButtons.appendChild(button);
        if(answer.correct){
            //console.log(answer.text + "= " + answer.correct);
            button.dataset.correct = answer.correct;
        }
        button.addEventListener("click", selectAnswer);
    });
}

function resetState(){
    nextButton.style.display = "none";
    while(answerButtons.firstChild){
        answerButtons.removeChild(answerButtons.firstChild);
    }
}

function selectAnswer(e){
    const selectedBtn = e.target;
    const isCorrect = selectedBtn.dataset.correct === "true";
    if(isCorrect){
        console.log("is corret");
        selectedBtn.classList.add("correct");
        score++;
    }
    else{
        console.log("is incorret");
        selectedBtn.classList.add("incorrect")
    }
    Array.from(answerButtons.children).forEach(button =>{
        if(button.dataset.correct === "true"){
            button.classList.add("correct");
        }
        button.disabled = true;
    });
    nextButton.style.display = "block";
}


function handleNextButton(){
    currentQuestionIndex++;
    if(currentQuestionIndex < questions.length){
        showQuestion();
    }
    else{
        showScore();
    }
}

function showScore(){
    resetState();
    questionElement.innerHTML = `You scored ${score} out of ${questions.length}!`
    nextButton.innerHTML = "Play Again";
    nextButton.style.display = "block";
}


nextButton.addEventListener("click", () =>{
    if(currentQuestionIndex < questions.length){
        handleNextButton();
    }
    else{
        startQuiz();
    }
})
populateQuestions();
startQuiz();