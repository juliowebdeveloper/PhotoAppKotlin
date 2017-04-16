package julio.com.br.photoapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import julio.com.br.photoapp.adapters.MainAdapter
import julio.com.br.photoapp.api.PhotoRetriever
import julio.com.br.photoapp.models.Photo
import julio.com.br.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() , View.OnClickListener {


    var photos: List<Photo>? = null
    var mainAdapter: MainAdapter? = null
    lateinit var recyclerView: RecyclerView //late init possibilita que seja nulo aqui e inicializado no onCreate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        var retriever = PhotoRetriever()
        val callback = object : Callback<PhotoList>{//object keyword é usado em kotlin para se criar classes anonimas
            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
                    //let keyword será só chamada se a variavel nao for nula
                    response?.isSuccessful.let {
                            this@MainActivity.photos = response?.body()?.hits
                        mainAdapter = MainAdapter(this@MainActivity.photos!!, this@MainActivity) //MainActivity que irá implementar o onClickListener, passando ela como construtor
                        recyclerView.adapter = mainAdapter

                    }
            }

            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
                Log.e(MainActivity::class.java.simpleName, "Error retrieving the photos")
                Toast.makeText(this@MainActivity, "Error retrieving the photos", Toast.LENGTH_LONG).show()
            }

        }

        retriever.getPhotos(callback)

      /*  var retriever2 = PhotoRetriever()
        retriever.getPhotos(object: Callback<PhotoList>{
            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })*/




    }

    override fun onClick(view: View?) {
        val intent  = Intent(this, DetailActivity::class.java)
        val holder = view?.tag as MainAdapter.PhotoViewHolder //Pegando o objeto da Tag que foi setado la no init do PhotoViewHolder
        intent.putExtra(DetailActivity.PHOTO, mainAdapter?.getPhoto(holder.adapterPosition)) //Pega a foto naquela posição a partir do getAdapterPosition
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

























/*

    var name2 :String? = null //só var pode ser null
    var name3 = null
    val length = name2?.length ?: -1 //Será length ou -1 se for nulo
    val lenght2 = name2!!.length //Null pointer se name2 for null

*/


    /*    fun strLength(name: String?):  Int{
        return name?.length ?: -1 //Como o retorno é  um Int e não um Int? não pode retornar null
    }
    fun strLength2(name: String?):  Int?{
        return name?.length //Como o retorno é  um Int? ele pode retornar null
    }*/
}
