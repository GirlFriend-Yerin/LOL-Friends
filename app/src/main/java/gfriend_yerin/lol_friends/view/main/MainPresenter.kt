package gfriend_yerin.lol_friends.view.main

import gfriend_yerin.lol_friends.data.player.PlayerVO

class MainPresenter : MainContract.Presenter {
    override fun searchEntries(player: PlayerVO) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var view : MainContract.View

    override fun setView(view: MainContract.View) {
        this.view = view
    }


}