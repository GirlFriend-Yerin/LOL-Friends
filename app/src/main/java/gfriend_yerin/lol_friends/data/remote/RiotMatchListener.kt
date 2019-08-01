package gfriend_yerin.lol_friends.data.remote

import gfriend_yerin.lol_friends.data.value_object.MatchVO

@FunctionalInterface
interface RiotMatchListener {

    fun onResult (isSuccess : Boolean , result:  MatchVO?)
}