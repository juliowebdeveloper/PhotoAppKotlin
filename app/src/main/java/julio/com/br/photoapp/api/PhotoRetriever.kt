package julio.com.br.photoapp.api

import julio.com.br.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Shido on 16/04/2017.
 */
class PhotoRetriever {


private val service: PhotoApi

    init{
        val retrofit = Retrofit.Builder().baseUrl("http://www.pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(PhotoApi::class.java)

    }


    fun getPhotos(callback: Callback<PhotoList>){
        val call = service.getPhotos()
        call.enqueue(callback)
    }
}