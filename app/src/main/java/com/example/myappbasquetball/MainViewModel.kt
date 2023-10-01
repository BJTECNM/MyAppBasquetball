package com.example.myappbasquetball

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var localScore = 0
    var visitorScore = 0

    fun resetScores() {
        var localScore = 0
        var visitorScore = 0
    }

    fun addPointsToScore(points: Int, islocal: Boolean) {
        if (islocal){
            localScore += points
        }else{
            visitorScore += points
        }
    }

    fun decreaseLocalScore(){
        if (localScore > 0){
            localScore--
        }
    }

    fun decreaseVisitorScore() {
        if (localScore > 0) {
            localScore--
        }
    }

}