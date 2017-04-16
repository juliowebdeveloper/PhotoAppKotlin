package julio.com.br.photoapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import julio.com.br.photoapp.R
import julio.com.br.photoapp.models.Photo

/**
 * Created by Shido on 16/04/2017.
 */
class MainAdapter (var photos: List<Photo>, var clickListener: View.OnClickListener ) : RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val photo = photos[position]
        holder?.tags?.text = photo.tags
        holder?.favorites?.text = photo.favourites.toString()
        holder?.likes?.text = photo.likes.toString()
        if(photo.previewUrl.isNotEmpty()){
            Glide.with(holder?.tags?.context).load(photo.previewUrl).into(holder?.photoItem);
        }
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun getPhoto(position: Int): Photo{
        return photos[position]
    }



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
            return PhotoViewHolder(LayoutInflater.from(parent?.context)
                    .inflate(R.layout.photo_item, parent, false));


    }


    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var tags: TextView
            var likes: TextView
            var favorites: TextView
            var photoItem: ImageView
        init {
            if(clickListener != null){
                itemView.setOnClickListener (clickListener)
            }
            itemView.tag = this //Setando o proprio objecto na tag ja que ela aceita qualquer tipo de objeto para ser passado depois
            tags = itemView.findViewById(R.id.tags) as TextView
            likes = itemView.findViewById(R.id.likes) as TextView
            favorites = itemView.findViewById(R.id.favorites) as TextView
            photoItem = itemView.findViewById(R.id.photo_item) as ImageView
        }

    }


}