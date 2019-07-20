package gfriend_yerin.lol_friends.utils

import gfriend_yerin.lol_friends.data.playinfo.PlayInfoVO
import org.json.JSONObject

object LolJsonParser {

    fun parseJsonPlayInfo(json : JSONObject) : PlayInfoVO{
        // TODO : Parse JSON File

        return PlayInfoVO.Builder().build()
    }

    fun parseJsonPlayInfo(json : String) : PlayInfoVO = parseJsonPlayInfo(JSONObject(json))


    fun parseJsonRotationChamp(json : JSONObject) : ArrayList<Int> {
        return ArrayList<Int>()
    }

    fun parseJsonRotationChamp(json : String) : ArrayList<Int> = parseJsonRotationChamp(JSONObject(json))
}