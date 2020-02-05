package com.examples.coding.containerviewsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //by lazy initializes the value whenever the value is first called upon
    val personList by lazy { poplateList() }
    val adapter by lazy  {PersonAdapter(personList)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        //val gridLayoutManager = GridLayoutManager(this, 3,LinearLayoutManager.HORIZONTAL, false)
        rvPersonList.layoutManager = layoutManager
        rvPersonList.addItemDecoration(itemDecoration)
        rvPersonList.adapter = adapter
    }

    private fun poplateList() : ArrayList<Person> {
        val returnList = ArrayList<Person>()
        returnList.add(Person("Aaron", "Hoskins", "123 SomeStreet Rd"))
        returnList.add(Person("James", "Kirk", "123 Enterprise Way"))
        returnList.add(Person("Darth", "Vader", "123 Dark Side Rd"))
        returnList.add(Person("Bill", "Gates", "123 Money Rd"))
        returnList.add(Person("Steve", "Jobs", "123 RipOff Rd"))
        returnList.add(Person("Elon", "Musk", "123 Tesla Rd"))
        returnList.add(Person("Florida", "Man", "123 Crazy Rd"))
        returnList.add(Person("William", "Hoskins", "123 SomeStreet Rd"))
        returnList.add(Person("Donald", "Trump", "123 TwitterTroll Rd"))
        returnList.add(Person("Homer", "Simpson", "123 Springfield Rd"))

        return returnList
    }

    fun onClick(view: View) {
        val first = etFirstName.text.toString()
        val last = etLastName.text.toString()
        val address = etAddress.text.toString()
        val personToAdd = Person(first, last, address)
        adapter.addPersonToList(personToAdd)
    }
}
