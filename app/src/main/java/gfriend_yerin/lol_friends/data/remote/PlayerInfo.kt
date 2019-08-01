package gfriend_yerin.lol_friends.data.remote

import android.util.Log
import gfriend_yerin.lol_friends.BuildConfig
import gfriend_yerin.lol_friends.data.value_object.LeagueVO
import gfriend_yerin.lol_friends.data.value_object.MatchVO
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

        repos.enqueue(object : Callback<PlayerVO> {

            override fun onFailure(call: Call<PlayerVO>, t: Throwable) {
                Log.e(TAG, t.localizedMessage)
                Log.e(TAG, "Fail Connection")
            }

            override fun onResponse(call: Call<PlayerVO>, response: Response<PlayerVO>) {
                if (response.isSuccessful) {
                    val res: PlayerVO? = response.body()
                    Log.e(TAG, res!!.accountId)
                    playerListener.onResult(true, res)
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

        Log.e(TAG, repos.request().url().toString())

        repos.enqueue(object : Callback<MatchVO> {

            override fun onFailure(call: Call<MatchVO>, t: Throwable) {
                Log.e(TAG, t.localizedMessage)
            }

            override fun onResponse(call: Call<MatchVO>, response: Response<MatchVO>) {
                if (response.isSuccessful){
                    val res : MatchVO? = response.body()

                    for ( play in res!!.matches)
                        Log.e("Match", play.lane + " / " + play.timestamp)

                    matchListener.onResult(true, res)
                }
                else
                    matchListener.onResult(false, null)
            }
        })
    }

    fun getPlayerLeague(id : String, rankListener : RiotRankListener) {

        val retrofit = Retrofit.Builder().baseUrl(RiotService.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RiotService::class.java)

        val repos = retrofit.playerLeagueAsync(id, BuildConfig.api_key)

        repos.enqueue(object : Callback<List<LeagueVO>> {

            override fun onFailure(call: Call<List<LeagueVO>>, t: Throwable) {
                Log.e(TAG, t.localizedMessage)
            }

            override fun onResponse(call: Call<List<LeagueVO>>, response: Response<List<LeagueVO>>) {
                if (response.isSuccessful){
                    val res : List<LeagueVO>? = response.body()
                    rankListener.onResult(true, res)
                }
                else
                    rankListener.onResult(false, null)
            }
        })
    }
}