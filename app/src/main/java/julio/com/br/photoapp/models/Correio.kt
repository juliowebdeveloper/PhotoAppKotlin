package julio.com.br.photoapp.models

import com.bluelinelabs.logansquare.annotation.JsonField
import com.bluelinelabs.logansquare.annotation.JsonObject

/**
 * Created by mira on 17/04/2017.
 */
@JsonObject
data class Correio(@JsonField val bairro: String? = null ,
                   @JsonField val cep: String?= null,
                   @JsonField val cidade: String?= null,
                   @JsonField val estado: String?= null,
                   @JsonField val logradouro: String? = null,
                   @JsonField val tipodelogradouro: String?= null) {



}
