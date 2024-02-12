package com.example.imccalculator.activities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.graphics.drawable.toDrawable
import com.example.imccalculator.R
import com.example.imccalculator.R.drawable
import com.google.android.material.slider.RangeSlider
import kotlinx.coroutines.awaitAll
import java.text.DecimalFormat
import kotlin.math.pow





class MainActivity : AppCompatActivity() {

    lateinit var btnAddWeight: AppCompatButton
    lateinit var btnMinusWeight: AppCompatButton
    lateinit var weightText: TextView
    lateinit var heightSlider: RangeSlider
    lateinit var heightText: TextView
    var initialHeight = 160
    var initialWeight = 60
    var initialIMC: Float = 1f
    lateinit var resultText : TextView
    lateinit var calculateButton:Button
    lateinit var age : EditText
    lateinit var maleSign : AppCompatButton
    lateinit var femaleSign : AppCompatButton







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
            resultText=findViewById(R.id.resultText)
            calculateButton=findViewById(R.id.calculateButton)
            age=findViewById(R.id.ageEditText)
            maleSign=findViewById(R.id.maleButton)
            femaleSign=findViewById(R.id.femaleButton)


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
            calculateButton.setOnClickListener {
                val decimalFormat = DecimalFormat("#.##")
                initialIMC = initialWeight / (initialHeight.toFloat() / 100).pow(2)
                resultText.text = "${decimalFormat.format(initialIMC)}"
            }

            maleSign.setOnClickListener { 
                femaleSign.background = femaleSign.(R.drawable.female_sign_unselected)

                maleSign.background =
                
                
            }
            

        }



    }



