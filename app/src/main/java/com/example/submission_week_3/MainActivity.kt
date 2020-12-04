package com.example.submission_week_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submission_week_3.coronaPackage.CoronaAppActivity
import com.example.submission_week_3.daerahPackage.DaerahAppActivity
import com.example.submission_week_3.museumPackage.MuseumAppActivity
import com.example.submission_week_3.newsPackage.NewsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batikApp.setOnClickListener {
            val news = Intent(this, NewsActivity::class.java)
            startActivity(news)
        }

        museumApp.setOnClickListener {
            val museum= Intent(this, MuseumAppActivity::class.java)
            startActivity(museum)
        }

        daerahApp.setOnClickListener {
            val daerah= Intent(this, DaerahAppActivity::class.java)
            startActivity(daerah)
        }

        coronaApp.setOnClickListener {
            val corona= Intent(this, CoronaAppActivity::class.java)
            startActivity(corona)
        }


    }

}
