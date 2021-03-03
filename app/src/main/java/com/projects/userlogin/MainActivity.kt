package com.projects.userlogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: MainRecyclerAdapter
    private var firebaseAuth: FirebaseAuth? = null
    lateinit var dataList:ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar=findViewById(R.id.toolbar)
        setUpToolbar()
        setDataList()
        recyclerView = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this@MainActivity as Context)
        recyclerAdapter=MainRecyclerAdapter(this@MainActivity as Context,dataList)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerAdapter

    }

    private fun setDataList() {
        dataList=ArrayList<Movie>()
        dataList.add(Movie("Boss","Comedy,","16 October 2013","6/10"))
        dataList.add(Movie("Satyameva Jayate 2","Action","14 May 2021","6/10"))
        dataList.add(Movie("Kaadan","Drama","26 March 2021","8/10"))
        dataList.add(Movie("Padmaavat","Epic Drama","25 January 2018","6/10"))
        dataList.add(Movie("Krrish 3","Action","18 September 2013","8/10"))
        dataList.add(Movie("Dhoom 3","Thriller","20 December 2013","8/10"))
        dataList.add(Movie("Durgamati","Horror","11 December 2020","4/10"))
        dataList.add(Movie("Ludo","Comedy","12 November 2020","8/10"))
        dataList.add(Movie("Chhalaang","Comedy","13 November 2020","6/10"))
        dataList.add(Movie("Laxmii","Horror Comedy","9 November 2020","4/10"))
        dataList.add(Movie("Aadhaar","Drama","5 February 2021","4/10"))
        dataList.add(Movie("Shakeela","Biography","25 December 2020","2/10"))
        dataList.add(Movie("Insidious","Horror, Mystery, Thr)iller ","1 April 2011","6.8/10"))
        dataList.add(Movie("Joker","Crime, Drama, Thriller ","4 October 2019"," 8.4/10"))
        dataList.add(Movie("Inception"," Action, Adventure, Sci-Fi ","16 July 2010","8.8/10"))
        dataList.add(Movie("Interstellar","Adventure, Drama, Sci-Fi "," 7 November 2014","8.6/10"))
        dataList.add(Movie("Tom and Jerry","Animation, Adventure, Comedy "," 26 February 2021 ","5.3/10"))
        dataList.add(Movie("Tenet","Action, Sci-Fi, Thriller ","3 September 2020 ","7.5/10"))
        dataList.add(Movie("Wonder Woman 1984","Action, Adventure, Fantasy ","25 December 2020 ","5.4/10"))
        dataList.add(Movie("Avengers: Endgame","Action, Adventure, Drama ","26 April 2019 ","8.4/10"))
        dataList.add(Movie("1917 ","Horror, Mystery, Thriller,","10 January 2020 ","8.3/10"))
        dataList.add(Movie("Gladiator","Action, Adventure, Drama","5 May 2000 ","8.5/10"))
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Movies" }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.logout_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         var id = item.getItemId();
        when(id){
             R.id.logout -> {
                 firebaseAuth=FirebaseAuth.getInstance()
                 firebaseAuth!!.signOut()
                 startActivity(Intent(this@MainActivity,LoginActivity::class.java))
                 finish()
             }
        }
        return super.onOptionsItemSelected(item)
    }
}