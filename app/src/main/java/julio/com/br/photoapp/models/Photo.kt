package julio.com.br.photoapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Shido on 16/04/2017.
 */
data class Photo (val id: String,
                  val likes: Int,
                  val favourites: Int,
                  val tags: String,
                  @SerializedName("previewURL")val previewUrl: String,
                  @SerializedName("webformatURL") val webFormatUrl: String) : Serializable {

}