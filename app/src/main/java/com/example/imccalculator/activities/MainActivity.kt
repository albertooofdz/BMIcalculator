package com.example.imccalculator.activities
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
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
    lateinit var imcDescription : TextView
    lateinit var background : ConstraintLayout







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initView()
        }








        fun initView() {

            btnAddWeight= findViewById(R.id.PlusBtn)
            btnMinusWeight= findViewById(R.id.MinusBtn)
            weightText= findViewById(R.id.weightNmbr)
            heightSlider=findViewById(R.id.heightRangeSlider)
            heightText=findViewById(R.id.heightText)
            resultText=findViewById(R.id.resultText)
            calculateButton=findViewById(R.id.calculateButton)
            age=findViewById(R.id.ageEditText)
            maleSign=findViewById(R.id.maleButton)
            femaleSign=findViewById(R.id.femaleButton)
            imcDescription=findViewById(R.id.imcDescription)
            background=findViewById(R.id.background)


            btnAddWeight.setOnClickListener{

                ++initialWeight
                weightText.text = "${initialWeight.toString()} Kg"

            }

            btnMinusWeight.setOnClickListener {

                --initialWeight
                weightText.text="${initialWeight.toString()} Kg"


            }

            heightSlider.addOnChangeListener{_, value, _ ->

                initialHeight= value.toInt()
                heightText.text="${getString(R.string.Altura)} ${initialHeight.toString()} cm"

            }
            calculateButton.setOnClickListener {
                val decimalFormat = DecimalFormat("#.##")
                initialIMC = initialWeight / (initialHeight.toFloat() / 100).pow(2)
                resultText.text = "${decimalFormat.format(initialIMC)}"

                when(initialIMC){
                    in 0.0..18.5 -> {imcDescription.text="Bajo peso"
                        background.setBackgroundResource(R.color.red)}
                    in 18.5..24.9-> {imcDescription.text = "Peso ideal"
                        background.setBackgroundResource(R.color.green)}
                    in 24.9..29.9->{imcDescription.text="Sobrepeso"
                        background.setBackgroundResource(R.color.orange)}
                    in 29.9..39.9->{imcDescription.text="Obesidad Tipo I"
                        background.setBackgroundResource(R.color.red)}
                    else ->{imcDescription.text="Obesidad Tipo II"
                        background.setBackgroundResource(R.color.red)}

                }

            }

            maleSign.setOnClickListener {
                femaleSign.setBackgroundResource(R.drawable.female_sign_unselected)
                maleSign.setBackgroundResource(R.drawable.male_sign_selected)
            }

            femaleSign.setOnClickListener {
                femaleSign.setBackgroundResource(R.drawable.female_sign_selected)
                maleSign.setBackgroundResource(R.drawable.male_sign_unselected)
            }
            

        }



    }







