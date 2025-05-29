package com.example.workshop.service

import com.example.workshop.exceptions.WrongGuessesException
import com.example.workshop.exceptions.WrongInputException
import com.example.workshop.model.NewGameRequest
import com.example.workshop.repository.GameRepository
import org.springframework.stereotype.Service

@Service
class GameService(val gameRepository: GameRepository) {

    fun createGame(newGameRequest: NewGameRequest) {
        val randomSequence = createRandomSequence(newGameRequest.sequenceSize)
        this.gameRepository.saveGame(newGameRequest.maxAttempts, randomSequence)
    }

    private fun createRandomSequence(sequenceSize: Int) =
        List(sequenceSize) { (0..9).random() }.joinToString("")

    fun checkGuesses(guesses: List<String>): String {
        if(guesses.size != this.gameRepository.getMaxAttempts())
            throw WrongInputException("input errado")
        if (!guesses.contains(this.gameRepository.getSequence()))
            throw WrongGuessesException("você perdeu")
        return "parabéns você acertou"
    }

    fun endGame() {
        this.gameRepository.cleanUp()
    }
}
