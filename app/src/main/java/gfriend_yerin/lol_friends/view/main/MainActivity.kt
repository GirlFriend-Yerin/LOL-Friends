package gfriend_yerin.lol_friends.view.main

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import gfriend_yerin.lol_friends.view.BaseActivity
import gfriend_yerin.lol_friends.R
import gfriend_yerin.lol_friends.data.value_object.LeagueVO
import gfriend_yerin.lol_friends.data.value_object.PlayInfoVO
import gfriend_yerin.lol_friends.data.value_object.PlayerVO
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View{

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var presenter : MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter()
        presenter.setView(this)

        main_player_edit.setOnKeyListener { _, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                search(main_player_edit.text.toString())
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }

    override fun updateEntries(entries: ArrayList<PlayInfoVO>) {
        for (info in entries){
            Log.e(TAG, info.timestamp.toString())
        }
    }

    override fun updateUserProfile(player: PlayerVO?) {
        if (player == null) Toast.makeText(this, "찾고자 하는 소환사가 없습니다 ㅠㅠ",Toast.LENGTH_SHORT).show()
        else{
            main_summoner_name.text = player.name
            main_summoner_level.text = player.summonerLevel.toString()
        }
    }

    override fun updateUserRank(ranks: ArrayList<LeagueVO>) {
        for (league in ranks){
            val tierDrawable = tierIcon(league.tier)
            val score = league.leaguePoint
        }
    }

    private fun search(name : String){
        presenter.updateUser(name)
    }

    private fun tierIcon(flag : String) : Int{
        when(flag){
            "IRON" -> return R.drawable.emblem_iron
            "BRONZE" -> return R.drawable.emblem_bronze
            "SLIVER" -> return R.drawable.emblem_silver
            "GOLD" -> return R.drawable.emblem_gold
            "PLATINUM" -> return R.drawable.emblem_platinum
            "DIAMOND" -> return R.drawable.emblem_diamond
            "MASTER" -> return R.drawable.emblem_master
            "GRANDMASTER" -> return R.drawable.emblem_grandmaster
            "CHALLENGER" -> return R.drawable.emblem_challenger
        }
        return 0
    }
}
