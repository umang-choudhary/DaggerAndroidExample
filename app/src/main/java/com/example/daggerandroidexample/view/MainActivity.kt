package com.example.daggerandroidexample.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerandroidexample.adapter.UserListAdapter
import com.example.daggerandroidexample.app.UserApplication
import com.example.daggerandroidexample.databinding.ActivityMainBinding
import com.example.daggerandroidexample.model.Result
import com.example.daggerandroidexample.model.UserResponse
import com.example.daggerandroidexample.network.RetrofitUserAPI
import com.example.daggerandroidexample.utils.TAG
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofitUserAPI: RetrofitUserAPI

    @Inject
    lateinit var retrofitUserAPI2: RetrofitUserAPI

    @Inject
    lateinit var picasso: Picasso

    @Inject
    lateinit var picasso2: Picasso

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initData()
    }

    private fun initData() {
        val userComponent = (application as UserApplication).getUserComponent()

        val activityComponent = userComponent.getActivityComponentFactory().create(this)
        activityComponent.injectMainActivity(this)

        // picasso = RetrofitAPIClient.getPicasso(this, RetrofitAPIClient.getHttpClient(this))

        Log.d(TAG, "Retrofit1 =  $retrofitUserAPI is using $picasso")
        Log.d(TAG, "Retrofit2 =  $retrofitUserAPI2 is using $picasso2")

        populateUsers()
    }

    private fun populateUsers() {
        val usersCall: Call<UserResponse> = retrofitUserAPI.getRandomUsers(18)
        usersCall.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val results = response.body()?.results
                    if (results != null) {
                        mAdapter = UserListAdapter(
                            this@MainActivity,
                            results as ArrayList<Result>,
                            picasso
                        )

                        binding.recyclerViewAllUser.layoutManager =
                            LinearLayoutManager(this@MainActivity)
                        binding.recyclerViewAllUser.adapter = mAdapter
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Timber.i(t.message)
            }
        })
    }

    /*private fun getUserService(): RetrofitUserAPI {
        return RetrofitAPIClient.getClient(BASE_URL, this).create(RetrofitUserAPI::class.java)
    }*/
}