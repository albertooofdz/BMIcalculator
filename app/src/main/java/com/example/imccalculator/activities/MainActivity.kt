package com.example.imccalculator.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.imccalculator.R
import com.google.android.material.slider.RangeSlider
import kotlinx.coroutines.awaitAll

class MainActivity : AppCompatActivity() {

    lateinit var btnAddWeight: AppCompatButton
    lateinit var btnMinusWeight: AppCompatButton
    lateinit var weightText: TextView
    lateinit var heightSlider: RangeSlider
    lateinit var heightText: TextView
    var initialHeight = 160
    var initialWeight = 60






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initView()
        }






        fun initView() {

            btnAddWeight= findViewById(R.id.PlusBtn)
            btnMinusWeight= findViewById(R.id.MinusBtn)
            weightText= findViewById(R.id.weightText)
            heightSlider=findViewById(R.id.heightRangeSlider)
            heightText=findViewById(R.id.heightText)

            btnAddWeight.setOnClickListener{

                ++initialWeight
                weightText.text = "${getString(R.string.Peso)} ${initialWeight.toString()} Kg"

            }

            btnMinusWeight.setOnClickListener {

                --initialWeight
                weightText.text="${getString(R.string.Peso)} ${initialWeight.toString()} Kg"


            }

            heightSlider.addOnChangeListener{_, value, _ ->

                initialHeight= value.toInt()
                heightText.text="${getString(R.string.Altura)} ${initialHeight.toString()} cm"

            }







        }



    }

