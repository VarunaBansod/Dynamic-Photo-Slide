package com.example.dynamicphotoslide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var img :ImageView
    var currentImg = 0
    var nameToShow = arrayOf("Shri Ganesh","Shri Radha Krishna", "Adi-Shakti", "Lord Buddha")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prev = findViewById<ImageButton>(R.id.prevBtn)
        val next = findViewById<ImageButton>(R.id.nextBtn) // har ek id se linked ek int type address hota hai
        val text = findViewById<TextView>(R.id.textView2)

        //when previous button clicked
        prev.setOnClickListener{
            //PREVIOUS IMG
           val idCurrentImgString ="pic$currentImg"
            //AS generate am integer address associated with string so we will convert string into integer address associated with it
            //we are trying to get id address which is of int type using this method
            val idCurrentImgInt =this.resources.getIdentifier(idCurrentImgString,"id", packageName)// we want to know address of idCurrentImageString, we are playing with "id's" and we used getpackage to get packageName method
            img= findViewById(idCurrentImgInt)
            img.alpha=0f
            currentImg = (4+currentImg-1)%4

            //CURRENT IMG
            val idCurrentImgToShow ="pic$currentImg"
            val idCurrentImgToShowInt =this.resources.getIdentifier(idCurrentImgToShow,"id", packageName)// we want to know address of idCurrentImageString, we are playing with "id's" and we used getpackage to get packageName method
            img= findViewById(idCurrentImgToShowInt)
            img.alpha=1f
            text.text = nameToShow[currentImg]
        }

        //when next button clicked
        next.setOnClickListener{
            //PREVIOUS IMG
            val idCurrentImgString ="pic$currentImg"
            //AS generate am integer address associated with string so we will convert string into integer address associated with it
            //we are trying to get id address which is of int type using this method
            val idCurrentImgInt =this.resources.getIdentifier(idCurrentImgString,"id", packageName)// we want to know address of idCurrentImageString, we are playing with "id's" and we used getpackage to get packageName method
            img= findViewById(idCurrentImgInt)
            img.alpha=0f
            currentImg = (4+currentImg+1)%4

            //CURRENT IMG
            val idCurrentImgToShow ="pic$currentImg"
            val idCurrentImgToShowInt =this.resources.getIdentifier(idCurrentImgToShow,"id", packageName)// we want to know address of idCurrentImageString, we are playing with "id's" and we used getpackage to get packageName method
            img= findViewById(idCurrentImgToShowInt)
            img.alpha=1f
            text.text = nameToShow[currentImg]
        }
    }
}