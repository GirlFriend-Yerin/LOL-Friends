package gfriend_yerin.lol_friends.data

import gfriend_yerin.lol_friends.data.value_object.LeagueVO
import gfriend_yerin.lol_friends.data.value_object.MatchVO
import gfriend_yerin.lol_friends.data.value_object.PlayerVO

interface RiotSource {

    fun initStaticData()
    fun getPlayerInfo(name : String, playerListener : PlayerListener)
    fun getMatchInfo(accId : String, matchListener : RiotSource.MatchListener)
    fun getRankInfo(encId : String, rankListener : RankListener)

    interface MatchListener {
        fun onResult(isSuccess: Boolean, result: MatchVO?)
    }

    interface PlayerListener {
        fun onResult(isSuccess: Boolean, playerVO: PlayerVO?)
    }

    interface RankListener {
        fun onResult(isSuccess: Boolean, result: List<LeagueVO>?)
    }

}