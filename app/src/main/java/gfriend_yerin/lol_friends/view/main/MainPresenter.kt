package gfriend_yerin.lol_friends.view.main

class MainPresenter : MainContract.Presenter {

    private lateinit var view : MainContract.View

    override fun setView(view: MainContract.View) {
        this.view = view
    }


}