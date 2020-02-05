package com.examples.coding.containerviewsdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_person_details.*
import kotlinx.android.synthetic.main.person_item.*
import kotlinx.android.synthetic.main.person_item.tvFirstName
import kotlinx.android.synthetic.main.person_item.tvLastName

class PersonDetailsActivity : AppCompatActivity() {
    val list by lazy { initList() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_details)

        val passedPerson = intent?.getParcelableExtra<Person>(KEY_PERSON)
        //Elvis operator (?:) - tenerary operator - checks if value is null, if is null return
                // value to the right
                // passedPerson.getFirstName() != null ? passedPerson.getFirstName() : "no first name"
        tvFirstName.text = passedPerson?.firstName ?: "No First Name"
        tvLastName.text = passedPerson?.lastName ?: "No Last Name"
        tvAddress.text = passedPerson?.address ?: "No Address"
        initListView()
    }

    fun initListView() {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        lvListView.adapter = adapter
        lvListView.setOnItemClickListener { _, _, i, _ ->
            val selectedString = list[i]
            val intent = Intent("MAKE>THE>INTENT")
            intent.putExtra("KEY", selectedString)
            startActivity(intent)



        }
    }

    fun initList() : ArrayList<String>{
        val stringList = ArrayList<String>()

        stringList.add("Value 1")
        stringList.add("Value 2")
        stringList.add("Value 3")
        stringList.add("Value 4")
        stringList.add("Value 5")
        stringList.add("Value 6")

        return stringList
    }
}
