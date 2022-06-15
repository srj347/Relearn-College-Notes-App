package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity.LEFT
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.model.SubjectName
import com.google.android.material.navigation.NavigationView


class recyler1 : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var charItem: ArrayList<SubjectName>? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var alphaAdapters: RecyclerAdapter? = null

    // Navigation Drawer
    lateinit var toggle : ActionBarDrawerToggle


    var status: ArrayList<SubjectName> = java.util.ArrayList<SubjectName>()

    var branch:String ?=null
    var name:String ?=null
    lateinit var greet_name:TextView
    lateinit var dash_name:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyler1)


        branch = intent.getStringExtra("EXTRA_branch")
        name = intent.getStringExtra("EXTRA_name")

        //findViewById<TextView?>(R.id.greet_name).setText(name)
        //findViewById<TextView?>(R.id.dash_name).setText(name)
        //greet_name.setText(name.toString())
        //dash_name.setText(name.toString())

        Log.d("abc",name.toString())

        first()

        if(branch==null)
            branch = "CSE"
        open()


        // Toggle
        val drawerLayout : DrawerLayout = findViewById(R.id.drawer_layout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Log.d("recycler1",name.toString())
        //findViewById<TextView?>(R.id.greet_name).setText(name)
        //findViewById<TextView?>(R.id.dash_name).setText(name)
        //greet_name.setText(name.toString())
        //dash_name.setText(name.toString())

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.sub1 -> {
                    branch = "CSE"
                    open()
                    drawerLayout.closeDrawer(LEFT)
                }
                R.id.sub2 -> {
                    branch = "IT"
                    open()
                    drawerLayout.closeDrawer(LEFT)
                }
                R.id.sub3 -> {
                    branch = "ECE"
                    open()
                    drawerLayout.closeDrawer(LEFT)
                }
                R.id.abt_us -> {
                    Toast.makeText(applicationContext,"Clicked About Us",Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

    }

    fun first(){
        val isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
            .getBoolean("isFirstRun", true)

        if (isFirstRun) {
            //show start activity
            startActivity(Intent(this, Login::class.java))
            Toast.makeText(this, "First Run", Toast.LENGTH_LONG)
                .show()
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
            .putBoolean("isFirstRun", false).apply()
    }

    fun open(){
        recyclerView = findViewById(R.id.recycler_view_item)
        gridLayoutManager =
            GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)


        charItem = setSubject()
        alphaAdapters = RecyclerAdapter(applicationContext, charItem!!)
        recyclerView?.adapter = alphaAdapters
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item))
            return true

        return super.onOptionsItemSelected(item)
    }


    private fun setSubject(): ArrayList<SubjectName> {

        val CSE: ArrayList<SubjectName> = ArrayList()
        CSE.add(SubjectName(R.drawable.android, "CST251"))
        CSE.add(SubjectName(R.drawable.android, "CST252"))
        CSE.add(SubjectName(R.drawable.android, "CST253"))
        CSE.add(SubjectName(R.drawable.android, "CST254"))


        val IT: ArrayList<SubjectName> = ArrayList()
        IT.add(SubjectName(R.drawable.android, "IT251"))
        IT.add(SubjectName(R.drawable.android, "IT252"))
        IT.add(SubjectName(R.drawable.android, "IT253"))
        IT.add(SubjectName(R.drawable.android, "IT254"))


        val ECE: ArrayList<SubjectName> = ArrayList()

        ECE.add(SubjectName(R.drawable.android, "ECE251"))
        ECE.add(SubjectName(R.drawable.android, "ECE252"))
        ECE.add(SubjectName(R.drawable.android, "ECE253"))
        ECE.add(SubjectName(R.drawable.android, "ECE254"))
        ECE.add(SubjectName(R.drawable.android, "ECE254"))
        ECE.add(SubjectName(R.drawable.android, "ECE254"))
        ECE.add(SubjectName(R.drawable.android, "ECE254"))
        ECE.add(SubjectName(R.drawable.android, "ECE254"))
        ECE.add(SubjectName(R.drawable.android, "ECE254"))
        ECE.add(SubjectName(R.drawable.android, "ECE254"))
        ECE.add(SubjectName(R.drawable.android, "ECE254"))

        if(branch.equals("CSE"))
            status = CSE
        else if(branch.equals("IT"))
            status = IT
        else if(branch.equals("ECE"))
            status = ECE

        return status


    }
}