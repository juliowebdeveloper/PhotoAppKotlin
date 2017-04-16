package julio.com.br.photoapp.api

import julio.com.br.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Shido on 16/04/2017.
 */
interface PhotoApi {

    @GET("?key=5125088-68ee29a5523b2eeb34f0b1072&q=nature&image_type=photo")
    fun getPhotos(): Call<PhotoList>


}