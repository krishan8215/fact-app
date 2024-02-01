package com.example.factapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.factapp2.Adapter.factexplaination
import com.example.factapp2.databinding.ActivityNewstartactivityBinding
import com.example.factapp2.model.factexplain
import com.google.firebase.firestore.FirebaseFirestore

class newstartactivity : AppCompatActivity() {

    lateinit var db:FirebaseFirestore
    lateinit var binding: ActivityNewstartactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewstartactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= FirebaseFirestore.getInstance()

        val name = intent.getStringExtra("name")
        val id  = intent.getStringExtra("id")

        db= FirebaseFirestore.getInstance()


//      binding.btnback.setOnClickListener {
//       onBackPressed()
//        }
//

        binding.factname.text = name.toString()



        db.collection("fact").document(id!!).collection("all").addSnapshotListener { value, error ->
        val explainlist = arrayListOf<factexplain>()
       val data = value?.toObjects(factexplain::class.java)
       explainlist.addAll(data!!)



    binding.factrecycler.layoutManager =LinearLayoutManager(this)
    binding.factrecycler.adapter = factexplaination(this,explainlist)

}


     binding.btnback.setOnClickListener {
    onBackPressed()
}
    }}
