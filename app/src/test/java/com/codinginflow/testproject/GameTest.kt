package com.codinginflow.testproject

import com.codinginflow.testproject.initial.Answer
import com.codinginflow.testproject.initial.Game
import com.codinginflow.testproject.initial.MyQuestion
import org.junit.Assert
import org.junit.Before
import org.junit.Test


internal class GameTest {

    private lateinit var game : Game
    private lateinit var question : MyQuestion

    @Before
    fun setup() {
        game = Game()

        question = MyQuestion(
            question = "What country this flag belongs to ",
            optionsOne = Answer.OPTION_ONE,
            optionTwo = Answer.OPTION_TWO,
            optionThree = Answer.OPTION_THREE,
            optionFour = Answer.OPTION_FOUR,
            correctAnswer = Answer.OPTION_THREE
        )
    }

    @Test
    fun whenIncrementingScore_shouldIncrementCurrentScore() {
        game.incrementScore()
        game.incrementScore()
        game.decreaseScore()
        game.incrementScore()
        game.incrementScore()
        game.decreaseScore()

        Assert.assertTrue(game.highestScore > game.currentScore)
    }

    @Test
    fun ifCorrectAnswerPassExam() {
        Assert.assertFalse(game.passExam(question, Answer.OPTION_FOUR))

        Assert.assertFalse(game.passExam(question, Answer.OPTION_TWO))

        Assert.assertTrue(game.passExam(question, Answer.OPTION_THREE))

        Assert.assertFalse(game.passExam(question, Answer.OPTION_ONE))
    }
}