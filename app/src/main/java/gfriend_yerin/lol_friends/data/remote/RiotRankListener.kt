package gfriend_yerin.lol_friends.data.remote

import gfriend_yerin.lol_friends.data.value_object.LeagueVO

@FunctionalInterface
interface RiotRankListener {

    fun onResult (isSuccess : Boolean, result : List<LeagueVO>?)

}