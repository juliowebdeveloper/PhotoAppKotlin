package julio.com.br.photoapp.api

import julio.com.br.photoapp.models.Correio
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by mira on 17/04/2017.
 */
interface CorreioApi {

    @GET("cep/76873274")
    fun getDados(): Call<Correio>;

}