package com.example.factapp2.Adapter

import android.animation.ObjectAnimator
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.factapp2.MainActivity
import com.example.factapp2.databinding.FactpreviewBinding
import com.example.factapp2.model.factcat
import com.example.factapp2.newstartactivity

class factcategory( val mainActivity: MainActivity, val factlist: ArrayList<factcat>) :RecyclerView.Adapter<factcategory.Viewholder>(){
    val ColorList = arrayListOf("#3498db","#8e44ad","#e67e22","#27ae60","#e74c3c")
    class Viewholder( val binding: FactpreviewBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(FactpreviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = factlist.size



    override fun onBindViewHolder(holder: Viewholder, position: Int) {



        if (position%5 ==0){

            holder.binding.daily.setBackgroundColor(android.graphics.Color.parseColor(ColorList[0]))
        }else if (position%5 == 1){

            holder.binding.daily.setBackgroundColor(android.graphics.Color.parseColor(ColorList[1]))
        }


        if (position%5 ==2){
            holder.binding.daily.setBackgroundColor(android.graphics.Color.parseColor(ColorList[2]))
        }else

            if (position%5 ==3){

                holder.binding.daily.setBackgroundColor(android.graphics.Color.parseColor(ColorList[3]))
            }else if(position%5 ==4) {

                holder.binding.daily.setBackgroundColor(android.graphics.Color.parseColor(ColorList[4]))
            }

        holder.binding.daily.text =factlist[position].name.toString()
holder.binding.root.setOnClickListener {

    val intent = Intent(mainActivity,newstartactivity::class.java)
    intent.putExtra("id",factlist[position].id)
    intent.putExtra("name",factlist[position].name)
mainActivity.startActivity(intent)
}

ObjectAnimator.ofFloat(holder.binding.daily,View.TRANSLATION_X,-3000f,0f).apply {
    duration = 300
start()
}

    }

}