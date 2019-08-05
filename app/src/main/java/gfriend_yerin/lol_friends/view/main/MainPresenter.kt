package gfriend_yerin.lol_friends.view.main

import android.util.Log
import gfriend_yerin.lol_friends.data.remote.PlayerInfo
import gfriend_yerin.lol_friends.data.remote.RiotMatchListener
import gfriend_yerin.lol_friends.data.remote.RiotPlayerListener
import gfriend_yerin.lol_friends.data.remote.RiotRankListener
import gfriend_yerin.lol_friends.data.value_object.LeagueVO
import gfriend_yerin.lol_friends.data.value_object.MatchVO
import gfriend_yerin.lol_friends.data.value_object.PlayInfoVO
import gfriend_yerin.lol_friends.data.value_object.PlayerVO

class MainPresenter : MainContract.Presenter {
    override fun updateUser(name: String) {
        PlayerInfo.getPlayerVo(name, object : RiotPlayerListener {
            override fun onResult(isSuccess: Boolean, playerVO: PlayerVO?) {
                if (isSuccess) {
                    view.updateUserProfile(playerVO)
                    searchEntries(playerVO!!)
                }
                else
                    view.updateUserProfile(null)
            }
        })
    }

    private fun searchLeague(player: PlayerVO){

    }

    private fun searchEntries(player: PlayerVO) {
        PlayerInfo.getPlayerLeague(player.id, object : RiotRankListener {
            override fun onResult(isSuccess: Boolean, result: List<LeagueVO>?) {
                if (isSuccess){
                    for (item in result!!)
                        Log.e("TAG", item.queueType + " / " + item.tier + " / " + item.leaguePoint)
                }
            }
        })

        PlayerInfo.getPlayerMatches(player.accountId, object : RiotMatchListener{
            override fun onResult(isSuccess: Boolean, result: MatchVO?) {
                if (isSuccess){
                    //view.updateEntries(result)
                }
                else;
                    //view.updateEntries(ArrayList(result))
            }
        })
    }

    private lateinit var view : MainContract.View

    override fun setView(view: MainContract.View) {
        this.view = view
    }

}