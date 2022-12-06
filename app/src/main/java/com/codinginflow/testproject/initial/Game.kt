package com.codinginflow.testproject.initial

class Game {

    var currentScore = 0
        private set

    var highestScore = 0
        private set

    fun incrementScore() {
        currentScore++
        highestScore = if (highestScore < currentScore) currentScore else return
    }

    fun decreaseScore() {
        currentScore--
    }

    fun passExam(
        question: MyQuestion, answer: Answer
    ) = answer == question.correctAnswer
}

enum class Answer {
    OPTION_ONE, OPTION_TWO, OPTION_THREE, OPTION_FOUR
}

data class MyQuestion(
    val question: String,
    val optionsOne: Answer,
    val optionTwo: Answer,
    val optionThree: Answer,
    val optionFour: Answer,
    val correctAnswer: Answer
)