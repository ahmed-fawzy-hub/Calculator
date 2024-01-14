package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    var isNewOp=true
    var op="*"
    fun buNumberEvent(view: View) {
        if(isNewOp){
            binding.etShowNumber.setText("")
        }
        isNewOp=false
        var tvNumber: String = binding.etShowNumber.text.toString()
        val buSelect = view as Button
        when (buSelect.id) {
            binding.bu0.id -> {
                tvNumber += "0"

            }

            binding.bu1.id -> {
                tvNumber += "1"
            }

            binding.bu2.id -> {
                tvNumber += "2"
            }

            binding.bu3.id -> {
                tvNumber += "3"
            }

            binding.bu4.id -> {
                tvNumber += "4"
            }

            binding.bu5.id -> {
                tvNumber += "5"
            }

            binding.bu6.id -> {
                tvNumber += "6"
            }

            binding.bu7.id -> {
                tvNumber += "7"
            }

            binding.bu8.id -> {
                tvNumber += "8"
            }

            binding.bu9.id -> {
                tvNumber += "9"
            }
            binding.buDot.id->{
                //TODO: prevent adding morve than 1 dot
                tvNumber+="."
            }
            binding.buPlusMins.id->{
                tvNumber= "-"+tvNumber
            }

        }
        binding.etShowNumber.setText(tvNumber)
    }
    var oldNumber=""
    fun buOpEevent(view:View){
        isNewOp=true
        oldNumber=binding.etShowNumber.text.toString()
        val buSelect= view as Button
        when(buSelect.id) {
            binding.buMul.id -> {

                op = "*"


            }

            binding.buDiv.id -> {

                op = "/"
            }

            binding.buSub.id -> {


                op = "-"
            }

            binding.buSum.id -> {

                op = "+"
            }
        }
    }
    fun buEqualEvent(view:View){
        val newNumber=binding.etShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op){

            "*"->{
                finalNumber=  oldNumber.toDouble() *newNumber.toDouble()
            }
            "/"->{
                finalNumber=  oldNumber.toDouble() /newNumber.toDouble()
            }
            "+"->{
                finalNumber=  oldNumber.toDouble()+newNumber.toDouble()
            }
            "-"->{
                finalNumber=  oldNumber.toDouble() *newNumber.toDouble()
            }
        }
        binding.etShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }
    fun buClean(view:View){
        binding.etShowNumber.setText("0")
        isNewOp=true
    }
}