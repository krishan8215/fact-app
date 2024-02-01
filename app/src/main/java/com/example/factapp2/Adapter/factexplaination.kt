package com.example.factapp2.Adapter

import android.animation.ObjectAnimator
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.factapp2.databinding.FactbriefBinding
import com.example.factapp2.model.factexplain
import com.example.factapp2.newstartactivity
import java.time.Duration

class factexplaination( val newstartactivity: newstartactivity, val explainlist: ArrayList<factexplain>)

    :RecyclerView.Adapter<factexplaination.Viewholder>() {

//    val listcolor = arrayListOf<String>(" #ffda79 ","#f7f1e3 "," #F8EFB", " #9AECDB ","#7efff5")

    class Viewholder(  val binding: FactbriefBinding ):RecyclerView.ViewHolder(binding.root) {

    }

         override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

//             val listcolor = arrayListOf<String>(" #ffda79 ","#f7f1e3 "," #F8EFB", " #9AECDB ","#7efff5")
          return Viewholder(FactbriefBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

         override fun getItemCount() = explainlist.size


         override fun onBindViewHolder(holder: Viewholder, position: Int) {

             if (position%6 == 0){
                 holder.binding.factexpain.setBackgroundColor(Color.CYAN)
             }else if (position%6 ==1){
                 holder.binding.factexpain.setBackgroundColor(Color.GREEN)
             }else if (position%6 ==2){
                 holder.binding.factexpain.setBackgroundColor(Color.YELLOW)

             }else if (position%6 ==3){
                 holder.binding.factexpain.setBackgroundColor(Color.CYAN)
             }
             else
                  if (position%6 ==4){
                      holder.binding.factexpain.setBackgroundColor(Color.GREEN)
                  }else if (position%6 ==5){
                      holder.binding.factexpain.setBackgroundColor(Color.WHITE)
                  }

         holder.binding.factexpain.text = explainlist[position].data.toString()
         ObjectAnimator.ofFloat(holder.binding.factexpain,View.TRANSLATION_Y ,-3000f,0f).apply {
            duration = 200
            start()
         }


    }
}