package gfriend_yerin.lol_friends.data.value_object

import java.io.Serializable

data class PlayInfoVO(
    val code: Int,
    val kill: Int,
    val name: String,
    val death: Int,
    val assist: Int,
    val timestamp: Long,
    val victory: Boolean,
    val teamPlayer: ArrayList<PlayerVO>,
    val enemyPlayer: ArrayList<PlayerVO>) : Serializable
