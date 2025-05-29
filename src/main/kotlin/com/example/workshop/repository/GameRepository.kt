package com.example.workshop.repository

import com.example.workshop.entity.GameData
import org.springframework.stereotype.Repository

@Repository
class GameRepository {

    private var gameData: GameData? = null

    fun saveGame(maxAttempts: Int, randomSequence: String) {
        this.gameData = GameData(randomSequence, maxAttempts)
    }

    fun getMaxAttempts(): Int = this.gameData?.maxAttempts ?: throw RuntimeException("Game not initialized")
    fun getSequence(): String = this.gameData?.sequence ?: throw RuntimeException("Game not initialized")
    fun cleanUp() {
        this.gameData = null
    }
}
