package gfriend_yerin.lol_friends.view.main.playInfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import gfriend_yerin.lol_friends.R
import gfriend_yerin.lol_friends.data.playinfo.PlayInfoVO
import kotlinx.android.synthetic.main.palyinfo_item.view.*

class PlayInfoAdapter(private val items : ArrayList<PlayInfoVO>,
                      private val layout : Int) : RecyclerView.Adapter<PlayInfoAdapter.PlayinfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayinfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return PlayinfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayinfoViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() : Int = items.size

    class PlayinfoViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {

        fun bind(item : PlayInfoVO){
            Glide.with(view).load(item).apply(RequestOptions.circleCropTransform()).into(view.playinfo_champ_image)

        }

    }

}