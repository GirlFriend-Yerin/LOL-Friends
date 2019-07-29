package gfriend_yerin.lol_friends.view.main

import gfriend_yerin.lol_friends.data.value_object.PlayerVO

class MainPresenter : MainContract.Presenter {
    override fun findUser(name: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchEntries(player: PlayerVO) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var view : MainContract.View

    override fun setView(view: MainContract.View) {
        this.view = view
    }


}