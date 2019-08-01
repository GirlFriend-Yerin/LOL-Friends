package gfriend_yerin.lol_friends.data.value_object

import java.io.Serializable

data class PlayInfoVO(
    val lane: String,
    val gameId: Long,
    val champion: Int,
    val platformId: String,
    val season: Int,
    val queue: Int,
    val role: String,
    val timestamp: Long) : Serializable
