package com.example.workshop.controller

import com.example.workshop.exceptions.WrongGuessesException
import com.example.workshop.exceptions.WrongInputException
import com.example.workshop.model.GuessesResponse
import com.example.workshop.model.NewGameRequest
import com.example.workshop.model.NewGameResponse
import com.example.workshop.service.GameService
import org.apache.coyote.Response
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StartGameController(val gameService: GameService) {

    @PostMapping("/api/game")
    fun newGame(@RequestBody newGameRequest: NewGameRequest): NewGameResponse {
        println("New Game with parameters $newGameRequest")
        this.gameService.createGame(newGameRequest)
        return NewGameResponse("Jogo Iniciado")
    }

    @PostMapping("/api/guess")
    fun guess(@RequestBody guesses: List<String>): ResponseEntity<GuessesResponse> {
        println("New guess list arrived! $guesses")
        return try {
            ResponseEntity.ok(GuessesResponse(this.gameService.checkGuesses(guesses)))
        } catch (e: WrongInputException) {
            ResponseEntity.badRequest().body(GuessesResponse(e.message ?: "Unknown Error"))
        } catch (e: WrongGuessesException) {
            ResponseEntity.status(404).body(GuessesResponse(e.message ?: "Unknown Error"))
        } catch (e: Exception) {
            ResponseEntity.status(500).body(GuessesResponse(e.message ?: "Unknown Error"))
        }
        finally {
            this.gameService.endGame()
        }
    }
}