package gfriend_yerin.lol_friends.data.remote

import gfriend_yerin.lol_friends.data.value_object.PlayerVO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RiotService {
    @GET ("/lol/summoner/v4/summoners/by-name/{name}")
    fun playerRepoAsync(@Path("name") name : String, @Query("api_key") apiKey : String) : Call<PlayerVO>

    @GET ("/lol/summoner/v4/summoners/by-name/{name}")
    fun playerRepoSync(@Path("name") name : String, @Query("api_key") apiKey : String) : PlayerVO
}