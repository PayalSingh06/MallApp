package com.example.shoppingmallapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var s :String = ""
    var bill :Int = 0
    var temp :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkBoxApple = findViewById<CheckBox>(R.id.checkBoxApple)
        val checkBoxT = findViewById<CheckBox>(R.id.checkBoxT)
        val checkBoxRing = findViewById<CheckBox>(R.id.checkBoxRing)
        val checkBoxBag = findViewById<CheckBox>(R.id.checkBoxBag)
        val checkBoxBowl = findViewById<CheckBox>(R.id.checkBoxBowl)
        val checkBoxLaptop = findViewById<CheckBox>(R.id.checkBoxLaptop)
        val checkBoxGst1 = findViewById<CheckBox>(R.id.chechBoxGst1)
        val checkBoxGst2 = findViewById<CheckBox>(R.id.chechBoxGst2)
        val btnBill = findViewById<Button>(R.id.buttonBill)
        val btnReset = findViewById<Button>(R.id.buttonReset)



        checkBoxApple.setOnClickListener(this)
        checkBoxT.setOnClickListener(this)
        checkBoxRing.setOnClickListener(this)
        checkBoxBag.setOnClickListener(this)
        checkBoxBowl.setOnClickListener(this)
        checkBoxLaptop.setOnClickListener(this)


        btnBill.setOnClickListener {
            var gst:String = ""
            var b = bill.toString().toInt()
            if (checkBoxGst1.isChecked) {
                temp = (bill * 6 ) / 100
                b -= temp
            }
            else if(checkBoxGst2.isChecked)
            {
                temp = (bill * 12) / 100
                b -= temp

            }

            val intent = Intent(this, SecondActivity::class.java)
            val detailOfList = s.toString()
            intent.putExtra("123", b)
            intent.putExtra("abc", detailOfList)
            startActivity(intent)
        }
        btnReset.setOnClickListener{
            checkBoxApple.isChecked = false
            checkBoxBag.isChecked = false
            checkBoxBowl.isChecked = false
            checkBoxLaptop.isChecked = false
            checkBoxRing.isChecked = false
            checkBoxT.isChecked = false
            checkBoxGst1.isChecked = false
            checkBoxGst2.isChecked = false
        }

    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        when(id) {
            R.id.checkBoxApple -> {
                s += checkBoxApple.text.toString()
                bill += 100
            }
            R.id.checkBoxT -> {
                s += checkBoxT.text.toString()
                bill += 400
            }
            R.id.checkBoxLaptop -> {
                s += checkBoxLaptop.text.toString()
                bill += 30000
            }
            R.id.checkBoxRing -> {
                s += checkBoxRing.text.toString()
                bill += 100
            }
            R.id.checkBoxBowl -> {
                s += checkBoxBowl.text.toString()
                bill += 200
            }
            R.id.checkBoxBag -> {
                s += checkBoxBag.text.toString()
                bill += 500
            }
        }

        }

    }
