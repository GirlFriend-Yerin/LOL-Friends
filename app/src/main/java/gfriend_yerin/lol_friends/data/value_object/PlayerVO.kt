package gfriend_yerin.lol_friends.data.value_object

import java.io.Serializable

data class PlayerVO(
    val id: String,
    val accountId: String,
    val puuid: String,
    val name: String,
    val revisionDate: Long,
    val summonerLevel: Int
) : Serializable {
}