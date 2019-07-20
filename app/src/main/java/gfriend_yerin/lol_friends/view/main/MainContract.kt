package gfriend_yerin.lol_friends.view.main

import gfriend_yerin.lol_friends.data.playinfo.PlayInfoVO
import gfriend_yerin.lol_friends.data.playinfo.player.PlayerVO

interface MainContract {

    interface View{
        fun updateEntries(entries : ArrayList<PlayInfoVO>)
    }

    interface Presenter{
        fun setView(view : View)
        fun searchEntries(player : PlayerVO)
    }
}