package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class Details : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        val branch =  findViewById<Spinner>(R.id.branch)
        val sem = findViewById<Spinner>(R.id.sem)
        val name = findViewById<EditText>(R.id.name)

        val button = findViewById<Button>(R.id.nxtBtn)
        button.setOnClickListener{
            val b = branch.selectedItem
            val n = name.text

            intent = Intent(this,recyler1::class.java).also {
                it.putExtra("EXTRA_branch",b.toString())
                it.putExtra("EXTRA_name",n.toString())
            }
            startActivity(intent)
        }

        branch.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@Details,
                    "You selected ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_LONG).show()
            }

        }

        sem.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {

                Toast.makeText(this@Details,
                    "You selected ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_LONG).show()

            }

        }
    }
}