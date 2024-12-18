package com.example.sycrypto

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.sycrypto.databinding.ActivityMainBinding
import java.util.Locale


// API key : "2c6165f1-b7c8-4ff4-88f6-0c9d8405fd85"
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var rvAdapter: RvAdapter
    private lateinit var data: ArrayList<Modal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        data = ArrayList()
        apiData
        rvAdapter = RvAdapter(this, data)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = rvAdapter

        binding.search.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                val filterdata = ArrayList<Modal>()
                for(item in data){
                    if(item.name.lowercase(Locale.getDefault()).contains(p0.toString().lowercase(Locale.getDefault()))){
                        filterdata.add(item)
                    }
                }

                if(filterdata.isEmpty()){
//                    Toast.makeText(this@MainActivity, "No Data Available", Toast.LENGTH_SHORT).show()
                } else {
                    rvAdapter.changeData(filterdata)
                }
            }

        })
    }

    val apiData:Unit
        get(){
            val url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest"

            val queue= Volley.newRequestQueue(this)

            val jsonObjectRequest: JsonObjectRequest =
                object : JsonObjectRequest(Method.GET, url,null,Response.Listener {
                    response ->
                    binding.progressBar.isVisible = false
                    try {
                        val dataArray = response.getJSONArray("data")
                        for(i in 0 until dataArray.length()){
                            val dataObject = dataArray.getJSONObject(i)

                            val symbol =dataObject.getString("symbol")
                            val name =dataObject.getString("name")
                            val quote =dataObject.getJSONObject("quote")
                            val usd = quote.getJSONObject("USD")
                            val price = String.format("$" + "%.2f", usd.getDouble("price"))

                            data.add(Modal(name,symbol,price))
                        }
                        rvAdapter.notifyDataSetChanged()
                    } catch (e: Exception){
                        Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
                    }

                }, Response.ErrorListener {
                    Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
                })

                {
                    override fun getHeaders(): Map<String, String> {
                        val headers = HashMap<String, String>()
                        headers["X-CMC_PRO_API_KEY"] = "2c6165f1-b7c8-4ff4-88f6-0c9d8405fd85"
                        return headers
                    }
                }

            queue.add(jsonObjectRequest)
        }
}