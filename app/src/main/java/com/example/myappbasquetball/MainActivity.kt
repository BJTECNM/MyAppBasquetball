package com.example.myappbasquetball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myappbasquetball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.localScore.observe(this, Observer {
            binding.localScoreText.text = it.toString()
        })

        viewModel.visitorScore.observe(this, Observer {
            binding.visitorScoreText.text = it.toString()
        })

        binding.resultsButton.setOnClickListener {
            startScoreActivity()
        }
    }

    private fun startScoreActivity() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY, viewModel.localScore.value)
        intent.putExtra(ScoreActivity.VISITOR_SCORE_KEY, viewModel.visitorScore.value)
        startActivity(intent)
    }

    /*
    private lateinit var binding : ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setupButtons()
    }

    private fun setupButtons() {

        binding.localMinusButton.setOnClickListener { viewModel.decreaseLocalScore()
            binding.localScoreText.text = viewModel.localScore.toString()

        }
        binding.localPlusButton.setOnClickListener {
            addPointsToScore(1, islocal = true)
        }
        binding.localTwoPointsButton.setOnClickListener {
            addPointsToScore(2, islocal = true)
        }
        binding.visitorMinusButton.setOnClickListener {
            viewModel.decreaseVisitorScore()
            binding.visitorScoreText.text = viewModel.visitorScore.toString()
        }
        binding.visitorPlusButton.setOnClickListener {
            addPointsToScore(1, islocal = false)
        }
        binding.visitorTwoPointsButton.setOnClickListener {
            addPointsToScore(2, islocal = false)
        }
        binding.restartButton.setOnClickListener {
            resetScores()
        }
        binding.resultsButton.setOnClickListener {
            startScoreActivity()
        }
    }

    private fun resetScores(){
        viewModel.resetScores()
        binding.visitorScoreText.text = viewModel.localScore.toString()
        binding.localScoreText.text = viewModel.visitorScore.toString()
    }

    private fun addPointsToScore(points: Int, islocal: Boolean) {
        viewModel.addPointsToScore(points,islocal)
        if (islocal){
            binding.localScoreText.text = viewModel.localScore.toString()
        }else{
            binding.visitorScoreText.text = viewModel.visitorScore.toString()
        }
    }

    private fun startScoreActivity(){
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY, viewModel.localScore)
        intent.putExtra(ScoreActivity.VISITOR_SCORE_KEY, viewModel.visitorScore)
        startActivity(intent)
    }
     */
}