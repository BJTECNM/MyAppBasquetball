package com.example.myappbasquetball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myappbasquetball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var countLocal = 0
    private var countVisitor = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButtons()
    }

    private fun setupButtons() {

        binding.localMinusButton.setOnClickListener {
            countLocal--
            if (countLocal<0){
                countLocal=0
                Toast.makeText(this, "Ya es Cero", Toast.LENGTH_LONG).show()
            }
            else
                binding.localScoreText.text= countLocal.toString()
        }

        binding.localPlusButton.setOnClickListener {
            countLocal++
            binding.localScoreText.text= countLocal.toString()
        }

        binding.localTwoPointsButton.setOnClickListener {
            countLocal += 2
            binding.localScoreText.text= countLocal.toString()
        }

        binding.visitorMinusButton.setOnClickListener {
            countVisitor--
            if (countVisitor<0){
                countVisitor = 0
                Toast.makeText(this, "Ya es Cero", Toast.LENGTH_LONG).show()
            }
            else
                binding.visitorScoreText.text= countVisitor.toString()
        }

        binding.visitorPlusButton.setOnClickListener {
            countVisitor++
            binding.visitorScoreText.text= countVisitor.toString()
        }

        binding.visitorTwoPointsButton.setOnClickListener {
            countVisitor+=2
            binding.visitorScoreText.text= countVisitor.toString()
        }

        binding.restartButton.setOnClickListener {
            countVisitor = 0
            countLocal = 0
        }

        binding.resultsButton.setOnClickListener {
            if (countVisitor == countLocal)
                Toast.makeText(this, "Fue un empate", Toast.LENGTH_LONG).show()
            else if (countVisitor > countLocal)
                Toast.makeText(this, "Gana el equipo Visitante", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Gana el equipo Local", Toast.LENGTH_LONG).show()
        }
    }
}