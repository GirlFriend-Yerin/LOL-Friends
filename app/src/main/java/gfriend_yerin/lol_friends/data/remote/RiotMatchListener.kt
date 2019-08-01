package gfriend_yerin.lol_friends.data.remote

import gfriend_yerin.lol_friends.data.value_object.PlayInfoVO

interface RiotMatchListener {

    fun onResult (isSuccess : Boolean , result:  List<PlayInfoVO>?)
}