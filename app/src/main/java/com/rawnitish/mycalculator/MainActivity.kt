package com.rawnitish.mycalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {
    //@SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var A: Float = 0F
        var B: Float = 0F
        var C: Float = 0F
        var op: Char? = null
        var temp: Int? = null
        var flag:Boolean = false
        var lastLen: Int = 0

        txtView1.text = " "
        //
        btn1.setOnClickListener {
            if( flag && op == null ){
                txtView1.text = ""
                flag = false
            }
            txtView1.text = txtView1.text.toString() + "1"
            temp = ( (temp?:0) * 10 ) + 1
        }
        btn2.setOnClickListener {
            if( flag && op == null ){
                txtView1.text = ""
                flag = false
            }
            txtView1.text = txtView1.text.toString() + "2"
            temp = ( (temp?:0) * 10 ) + 2
        }
        btn3.setOnClickListener {
            if( flag && op == null ){
                txtView1.text = ""
                flag = false
            }
            txtView1.text = txtView1.text.toString() + "3"
            temp = ( ( temp?:0 ) * 10 ) + 3
        }
        btn4.setOnClickListener {
            if( flag && op == null ){
                txtView1.text = ""
                flag = false
            }
            txtView1.text = txtView1.text.toString() + "4"
            temp = ( (temp?:0) * 10 ) + 4
        }
        btn5.setOnClickListener {
            if( flag && op == null ){
                txtView1.text = ""
                flag = false
            }
            txtView1.text = txtView1.text.toString() + "5"
            temp = ( (temp?:0) * 10 ) + 5
        }
        btn6.setOnClickListener {
            if( flag && op == null ){
                txtView1.text = ""
                flag = false
            }
            txtView1.text = txtView1.text.toString() + "6"
            temp = ( (temp?:0) * 10 ) + 6
        }
        btn7.setOnClickListener {
            if( flag && op == null ){
                txtView1.text = ""
                flag = false
            }
            txtView1.text = txtView1.text.toString() + "7"
            temp = ( (temp?:0) * 10 ) + 7
        }
        btn8.setOnClickListener {
            if( flag ){
                txtView1.text = ""
                flag = false
                if( op != null ){
                    txtView1.text = "$A + 8 "
                }
            }
            txtView1.text = txtView1.text.toString() + "8"
            temp = ( (temp?:0) * 10 ) + 8
        }
        btn9.setOnClickListener {
            if( flag ){
                txtView1.text = ""
                flag = false
                if( op != null ){
                    txtView1.text = "$A + 9 "
                }
            }
            txtView1.text = txtView1.text.toString() + "9"
            temp = ( (temp?:0) * 10 ) + 9
        }
        btn0.setOnClickListener {
            if( flag ){
                txtView1.text = ""
                flag = false
                if( op != null ){
                    txtView1.text = "$A + 9 "
                    temp = temp?:0 + 9
                }
            }
            txtView1.text = txtView1.text.toString() + "0"
            temp = ( (temp?:0) * 10 )
        }
        btn10.setOnClickListener {
            txtView1.text = txtView1.text.toString() + "/"
            //A = temp?:C
            if( temp == null ){
                var len = txtView1.text.toString().length
                txtView1.text = txtView1.text.toString()!!.substring( lastLen + 2, len )
                A = C
            }
            else    A = temp!!.toFloat()
            temp = null
            op = '/'
        }
        btn11.setOnClickListener{
            txtView1.text = txtView1.text.toString() + "+"
            if( temp == null ){
                var len = txtView1.text.toString().length
                txtView1.text = txtView1.text.toString()!!.substring( lastLen + 2, len )
                A = C
            }
            else    A = temp!!.toFloat()
            temp = null
            op = '+'
        }
        btn12.setOnClickListener {
            txtView1.text = txtView1.text.toString() + "-"
            //A = temp?:C
            if( temp == null ){
                var len = txtView1.text.toString().length
                txtView1.text = txtView1.text.toString()!!.substring( lastLen + 2, len )
                A = C
            }
            else    A = temp!!.toFloat()
            temp = null
            op = '-'
        }
        btn13.setOnClickListener {
            txtView1.text = txtView1.text.toString() + "*"
            //A = temp?:C
            if( temp == null ){
                var len = txtView1.text.toString().length
                txtView1.text = txtView1.text.toString()!!.substring( lastLen + 2, len )
                A = C
            }
            else    A = temp!!.toFloat()
            temp = null
            op = '*'
        }
        btn14.setOnClickListener {
            if( temp == null || op == null ){
                Toast.makeText( this, "Invalid Input", Toast.LENGTH_SHORT ).show()
                //txtView1.text = ""
            }
            else{
                B = temp!!.toFloat()
                temp = null
                C = processC( A, B, op!! )
                if( C == 0F )   Toast.makeText( this, "Zero can't be divided!", Toast.LENGTH_LONG ).show()
                else{
                    op = null
                    lastLen = txtView1.text.toString().length
                    txtView1.text = txtView1.text.toString() + "\n=$C"
                    flag = true
                }
            }
        }
        btn15.setOnClickListener {
            op = null
            temp = null
            txtView1.text = ""
        }
        btn16.setOnClickListener {
            var len = txtView1.text.toString().length
            if( temp != null ) temp = temp!! / 10
            else if( C > 0 ) C /= 10
            txtView1.text = txtView1.text.toString().substring( 0, len - 1 )
        }

    }
}

fun processC( A: Float, B: Float, op: Char ): Float{
    when( op ){
        '+' -> return( A + B )
        '-' -> return( A - B )
        '/' -> return( A / B )
        '*' -> return( A * B )
    }
    return -1F
}/*
fun buttonClick( a: Int ){
    if( flag && op == null ){
        txtView1.text = ""
        flag = false
    }
    txtView1.text = txtView1.text.toString() + "$a"
    temp = ( ( temp?:0 ) * 10 ) + a
}*/