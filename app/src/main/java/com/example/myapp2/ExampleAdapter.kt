package com.example.myapp2

import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.setting_item.view.*

class ExampleAdapter(
    private val exampleList: List<SettingData>,
    private val listner: OnItemClickListner)
    //adapter will adapt our data so that it can be displayed in list// recycleView Step - 1 class ExampleAdapter:RecyclerView.Adapter, settingPage: com.example.myapp2.SettingPage){}, settingPage: com.example.myapp2.SettingPage){}
                     : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {// recycleView Step 4- RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>()
    // step 9 create constructor  - private val exampleList: List<SettingData>



    //Step 5 - Add  method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.setting_item, parent, false)  // step 8
        return ExampleViewHolder(itemView)  // step 7
    }   // for any type of recycle view example u can use this code as it is .. no need to change anything.



    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]   // step 10

        holder.imageView.setImageResource(currentItem.imageResource)   // step - 11
        holder.textView1.text = currentItem.name
        holder.itemView.setOnClickListener{
            listner.onItemClick(position)


        }
    }
    override fun getItemCount() =exampleList.size  //step 12


      class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         // it holds the view of recycler view // recycleView Step -2 Add constructor(itemView)
         val imageView: ImageView = itemView.image_view //// recycleView Step - 3
         val textView1 = itemView.text_view1



//        init {         // init block is used to add click event on recycle view = just add this code ..no need to add extra code in other package.
//            itemView.setOnClickListener{ v: View ->    // step 13
//                val position: Int = adapterPosition
//               Toast.makeText(itemView.context, "You Clicked On Item # ${position + 1}",Toast.LENGTH_SHORT).show()
//            }
//        }

     }
    interface OnItemClickListner{ // for clicke event on reccycle view  make first interface
        fun onItemClick(position: Int)
    }
    }

