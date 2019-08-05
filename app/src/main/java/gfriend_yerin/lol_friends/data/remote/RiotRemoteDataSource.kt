package gfriend_yerin.lol_friends.data.remote

import android.util.Log
import gfriend_yerin.lol_friends.BuildConfig
import gfriend_yerin.lol_friends.data.RiotSource
import gfriend_yerin.lol_friends.data.value_object.LeagueVO
import gfriend_yerin.lol_friends.data.value_object.MatchVO
import gfriend_yerin.lol_friends.data.value_object.PlayerVO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RiotRemoteDataSource : RiotSource{

    private const val TAG = "RiotRemoteDataSource"

    private val riotService = RetrofitFactory.create(RiotService.baseUrl)
    private val riotStaticService = RetrofitFactory.create(RiotService.dragonBaseUrl)

    private lateinit var curVersion : String

    override fun initStaticData() {
        val repos = riotStaticService.loadRiotAPIVersion()

        repos.enqueue( object : Callback<List<String>> {
            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.e(TAG, "Version Load Fail")
            }

            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                curVersion = response.body()!![0]

                Log.e(TAG, curVersion)
            }
        })
    }

    override fun getPlayerInfo(name : String, playerListener : RiotSource.PlayerListener) {
        val repos = riotService.playerRepoAsync(name, BuildConfig.api_key)

        repos.enqueue(object : Callback<PlayerVO> {

            override fun onFailure(call: Call<PlayerVO>, t: Throwable) {
                Log.e(TAG, t.localizedMessage)
                Log.e(TAG, "Fail Connection")
            }

            override fun onResponse(call: Call<PlayerVO>, response: Response<PlayerVO>) {
                if (response.isSuccessful) {
                    val res: PlayerVO? = response.body()
                    playerListener.onResult(true, res)
                } else
                    playerListener.onResult(false, null)
            }

        })
    }

    override fun getRankInfo(encId : String, rankListener : RiotSource.RankListener) {
        val repos = riotService.playerLeagueAsync(encId, BuildConfig.api_key)

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

    override fun getMatchInfo(accId : String, matchListener : RiotSource.MatchListener) {
        val repos = riotService.playerMatchesAsync(accId, BuildConfig.api_key)

        repos.enqueue(object : Callback<MatchVO> {

            override fun onFailure(call: Call<MatchVO>, t: Throwable) {
                Log.e(TAG, t.localizedMessage)
            }

            override fun onResponse(call: Call<MatchVO>, response: Response<MatchVO>) {
                if (response.isSuccessful){
                    val res : MatchVO? = response.body()

                    matchListener.onResult(true, res)
                }
                else
                    matchListener.onResult(false, null)
            }
        })
    }



}