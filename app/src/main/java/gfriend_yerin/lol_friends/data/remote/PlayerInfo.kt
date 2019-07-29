package gfriend_yerin.lol_friends.data.remote

import android.util.Log
import gfriend_yerin.lol_friends.data.value_object.PlayerVO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PlayerInfo {

    private const val TAG : String = "PlayerInfo"

    fun getPlayerVo(name : String, playerListener: RiotPlayerListener){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://kr.api.riotgames.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RiotService::class.java)

        val repos = retrofit.playerRepoAsync(name, "RGAPI-21e2db1e-1dda-4f3c-b74c-63c30044d5b4")

        Log.e("Tag", repos.request().url().toString())

        repos.enqueue( object : Callback<PlayerVO> {

            override fun onFailure(call: Call<PlayerVO>, t: Throwable) {
                Log.e("Main", t.localizedMessage)
                Log.e("Main", "Fail Connection")
            }

            override fun onResponse(call: Call<PlayerVO>, response: Response<PlayerVO>) {
                if(response.isSuccessful){
                    val res : PlayerVO? = response.body()

                    playerListener.onResult(true, res)

                    Log.e("", res!!.name)
                }
                else
                    playerListener.onResult(false, null)
            }

        } )
    }
}