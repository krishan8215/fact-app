package com.example.factapp2

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.factapp2.Adapter.factcategory
import com.example.factapp2.databinding.ActivityMainBinding
import com.example.factapp2.model.factcat
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
lateinit var db:FirebaseFirestore
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


db = FirebaseFirestore.getInstance()

val factlist = arrayListOf<factcat>()

        db.collection("fact").addSnapshotListener { value, error ->
val factlist = arrayListOf<factcat>()
val data =value?.toObjects(factcat::class.java)
factlist.addAll(data!!)

binding.mainrecycler.layoutManager = LinearLayoutManager(this)
binding.mainrecycler.adapter =factcategory(this,factlist)

        }









     binding.imgmenu.setOnClickListener {

    if (binding.drawerlay.isDrawerOpen(Gravity.LEFT)) {
        binding.drawerlay.closeDrawer(Gravity.LEFT)

    }else{
        binding.drawerlay.openDrawer(Gravity.LEFT)
    }


}

binding.navimain.setNavigationItemSelectedListener {
when(it.itemId){

    R.id.menushare->{


true
    }
    R.id.menumore->{
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
        }
true
    }
    R.id.menurate->{
        val uri = Uri.parse("market://details?id=$packageName")
        val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(myAppLinkToMarket)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show()
        }

        true

    }else-> false
}



}

 fun onBackPressed() {
     if (binding.drawerlay.isDrawerOpen(Gravity.LEFT)){
         binding.drawerlay.closeDrawer(Gravity.LEFT)
     }else{
         super.onBackPressed()
     }

     }

     }
     }







