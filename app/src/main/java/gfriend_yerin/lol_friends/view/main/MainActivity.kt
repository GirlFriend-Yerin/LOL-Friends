package gfriend_yerin.lol_friends.view.main

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import gfriend_yerin.lol_friends.view.BaseActivity
import gfriend_yerin.lol_friends.R
import gfriend_yerin.lol_friends.data.value_object.LeagueVO
import gfriend_yerin.lol_friends.data.value_object.PlayInfoVO
import gfriend_yerin.lol_friends.data.value_object.PlayerVO
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.summoner_rank.*

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

    override fun updateEntries(entries: List<PlayInfoVO>) {
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

    override fun updateUserRank(ranks: List<LeagueVO>) {
        for (league in ranks){
            val tierDrawable = tierIcon(league.tier)
            Glide.with(this).load((tierDrawable)).into(tierImageView(league.queueType))
            tierTextView(league.queueType).text = league.tier + ' ' + league.rank + ' ' + league.leaguePoint
        }
    }

    private fun search(name : String){
        presenter.updateUser(name)
    }

    private fun tierImageView(queueType : String) : ImageView {
        when(queueType){
            "RANKED_SOLO_5x5" -> return main_solo_tier_image
            "RANKED_TEAM_5x5" -> return main_team_tier_image
            "RANKED_TFT" -> return main_tft_tier_image
        }
        return main_tbt_tier_image
    }

    private fun tierTextView(queueType : String) : TextView {
        when(queueType){
            "RANKED_SOLO_5x5" -> return main_solo_tier_text
            "RANKED_TEAM_5x5" -> return main_team_tier_text
            "RANKED_TFT" -> return main_tft_tier_text
        }

        return main_tbt_tier_text
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
