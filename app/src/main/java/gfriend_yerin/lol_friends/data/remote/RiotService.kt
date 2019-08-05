package gfriend_yerin.lol_friends.data.remote

import gfriend_yerin.lol_friends.data.value_object.LeagueVO
import gfriend_yerin.lol_friends.data.value_object.MatchVO
import gfriend_yerin.lol_friends.data.value_object.PlayInfoVO
import gfriend_yerin.lol_friends.data.value_object.PlayerVO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RiotService {

    companion object {
        const val baseUrl : String = "https://kr.api.riotgames.com"
        const val dragonBaseUrl : String = "https://ddragon.leagueoflegends.com"
    }

    @GET ("/lol/summoner/v4/summoners/by-name/{name}")
    fun playerRepoAsync(@Path("name") name : String, @Query("api_key") apiKey : String) : Call<PlayerVO>

    @GET ("/lol/league/v4/entries/by-summoner/{encId}")
    fun playerLeagueAsync(@Path("encId") encId : String, @Query("api_key") apiKey : String) : Call<List<LeagueVO>>

    @GET ("/lol/match/v4/matchlists/by-account/{accId}")
    fun playerMatchesAsync(@Path("accId") accId :String, @Query("api_key") apiKey : String) : Call<MatchVO>

    @GET ("/api/versions.json")
    fun loadRiotAPIVersion() : Call<List<String>>
}