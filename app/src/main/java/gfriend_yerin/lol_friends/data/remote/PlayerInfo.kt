package gfriend_yerin.lol_friends.data.remote

import android.util.Log
import gfriend_yerin.lol_friends.BuildConfig
import gfriend_yerin.lol_friends.data.value_object.PlayInfoVO
import gfriend_yerin.lol_friends.data.value_object.PlayerVO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PlayerInfo {

    private const val TAG: String = "PlayerInfo"

    fun getPlayerVo(name: String, playerListener: RiotPlayerListener) {
        val retrofit = Retrofit.Builder()
            .baseUrl(RiotService.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RiotService::class.java)

        val repos = retrofit.playerRepoAsync(name, BuildConfig.api_key)

        Log.e(TAG, repos.request().url().toString())

        repos.enqueue(object : Callback<PlayerVO> {

            override fun onFailure(call: Call<PlayerVO>, t: Throwable) {
                Log.e(TAG, t.localizedMessage)
                Log.e(TAG, "Fail Connection")
            }

            override fun onResponse(call: Call<PlayerVO>, response: Response<PlayerVO>) {
                if (response.isSuccessful) {
                    val res: PlayerVO? = response.body()
                    playerListener.onResult(true, res)
                    Log.e("", res!!.name)
                } else
                    playerListener.onResult(false, null)
            }

        })
    }

    fun getPlayerMatches(accId : String, matchListener: RiotMatchListener) {
        val retrofit = Retrofit.Builder().baseUrl(RiotService.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RiotService::class.java)

        val repos = retrofit.playerMatchesAsync(accId, BuildConfig.api_key)

        repos.enqueue(object : Callback<List<PlayInfoVO>> {

            override fun onFailure(call: Call<List<PlayInfoVO>>, t: Throwable) {
                Log.e(TAG, t.localizedMessage)
            }

            override fun onResponse(call: Call<List<PlayInfoVO>>, response: Response<List<PlayInfoVO>>) {
                if (response.isSuccessful){
                    val res : List<PlayInfoVO>? = response.body()
                    matchListener.onResult(true, res)
                }
                else
                    matchListener.onResult(false, null)
            }
        })
    }
}