package gfriend_yerin.lol_friends.view.main

import gfriend_yerin.lol_friends.data.value_object.PlayInfoVO
import gfriend_yerin.lol_friends.data.value_object.PlayerVO

interface MainContract {

    interface View{
        fun updateEntries(entries : ArrayList<PlayInfoVO>)
        fun updateUserProfile(player : PlayerVO?)
    }

    interface Presenter{
        fun setView(view : View)
        fun findUser(name : String)
    }
}