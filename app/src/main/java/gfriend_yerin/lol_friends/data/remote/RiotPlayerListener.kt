package gfriend_yerin.lol_friends.data.remote;

import gfriend_yerin.lol_friends.data.value_object.PlayerVO

@FunctionalInterface
interface RiotPlayerListener {

    fun onResult(isSuccess : Boolean, playerVO : PlayerVO?)

}