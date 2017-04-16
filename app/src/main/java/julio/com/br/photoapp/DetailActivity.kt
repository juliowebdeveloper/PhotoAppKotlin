package julio.com.br.photoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import julio.com.br.photoapp.models.Photo

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView = findViewById(R.id.photoView) as ImageView
        val photo  = intent.getSerializableExtra(PHOTO) as Photo?

        photo?.webFormatUrl.let{ //Se o webFormatUrl nao for nulo ele fará o seguinte
            Log.e("DA", photo?.webFormatUrl)
            Glide.with(this).load(photo?.webFormatUrl).into(imageView)
        }

        imageView.setOnClickListener { finish() }

    }

    companion object{
        val PHOTO = "PHOTO"
    }
}
