package gfriend_yerin.lol_friends.data.value_object

import java.io.Serializable

data class LeagueVO(
    val queueType : String,
    val tier : String,
    val leaguePoint : Int,
    val win : Int,
    val lose : Int
) : Serializable {
}