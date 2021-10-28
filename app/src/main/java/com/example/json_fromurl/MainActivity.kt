 package com.example.json_fromurl

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.json_fromurl.`interface`.RetrofitService
import com.example.json_fromurl.adapter.MyAdapter
import com.example.json_fromurl.common.Common
import com.example.json_fromurl.model.Movie_book
import dmax.dialog.SpotsDialog

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

 class MainActivity : AppCompatActivity() {

    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : MyAdapter
    lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mService=Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager=LinearLayoutManager(this)
        recyclerMovieList.layoutManager=layoutManager
       dialog=SpotsDialog.Builder().setCancelable(false).setContext(this).build()

    getAllMovieList()

    }
     private fun getAllMovieList(){
         dialog.show()
         mService.getMovieist().enqueue(object :Callback<MutableList<Movie_book>>  {
             override fun onFailure(call: Call<MutableList<Movie_book>>, t: Throwable) {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
             }
             override fun onResponse(call: Call<MutableList<Movie_book>>, response: Response<MutableList<Movie_book>>) {
                 adapter = MyAdapter(baseContext, response.body() as MutableList<Movie_book>)
                 adapter.notifyDataSetChanged()
                 recyclerMovieList.adapter = adapter

                 dialog.dismiss()
             }

         })
     }
}