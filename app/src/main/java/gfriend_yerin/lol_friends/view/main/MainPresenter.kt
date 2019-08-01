package gfriend_yerin.lol_friends.view.main

import gfriend_yerin.lol_friends.data.remote.PlayerInfo
import gfriend_yerin.lol_friends.data.remote.RiotMatchListener
import gfriend_yerin.lol_friends.data.remote.RiotPlayerListener
import gfriend_yerin.lol_friends.data.value_object.PlayInfoVO
import gfriend_yerin.lol_friends.data.value_object.PlayerVO

class MainPresenter : MainContract.Presenter {
    override fun findUser(name: String) {
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
    
    private fun searchEntries(player: PlayerVO) {
        PlayerInfo.getPlayerMatches(player.accountId, object : RiotMatchListener{
            override fun onResult(isSuccess: Boolean, result: List<PlayInfoVO>?) {
                if (isSuccess){
                    view.updateEntries(ArrayList(result))

                }
                else
                    view.updateEntries(ArrayList(result))
            }
        })
    }

    private lateinit var view : MainContract.View

    override fun setView(view: MainContract.View) {
        this.view = view
    }

}