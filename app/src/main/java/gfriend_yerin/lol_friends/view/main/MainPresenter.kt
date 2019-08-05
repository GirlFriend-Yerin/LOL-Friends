package gfriend_yerin.lol_friends.view.main

import gfriend_yerin.lol_friends.data.RiotDataRepository
import gfriend_yerin.lol_friends.data.RiotSource
import gfriend_yerin.lol_friends.data.value_object.LeagueVO
import gfriend_yerin.lol_friends.data.value_object.MatchVO
import gfriend_yerin.lol_friends.data.value_object.PlayerVO

class MainPresenter : MainContract.Presenter {

    private lateinit var view : MainContract.View

    override fun setView(view: MainContract.View) {
        this.view = view
    }

    override fun updateUser(name: String) {
        RiotDataRepository.getPlayerInfo(name, object : RiotSource.PlayerListener {
            override fun onResult(isSuccess: Boolean, playerVO: PlayerVO?) {
                if (isSuccess) {
                    view.updateUserProfile(playerVO)
                    searchLeague(playerVO!!)
                    searchEntries(playerVO)
                }
                else
                    view.updateUserProfile(null)
            }
        })
    }

    private fun searchLeague(player: PlayerVO){
        RiotDataRepository.getRankInfo(player.id, object : RiotSource.RankListener {
            override fun onResult(isSuccess: Boolean, result: List<LeagueVO>?) {
                if (isSuccess){
                    view.updateUserRank(result!!)
                }
            }
        })
    }

    private fun searchEntries(player: PlayerVO) {
        RiotDataRepository.getMatchInfo(player.accountId, object : RiotSource.MatchListener{
            override fun onResult(isSuccess: Boolean, result: MatchVO?) {
                if (isSuccess){
                    //view.updateEntries(result)
                }
                else;
                    //view.updateEntries(ArrayList(result))
            }
        })
    }

}