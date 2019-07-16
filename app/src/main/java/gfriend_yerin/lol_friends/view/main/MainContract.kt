package gfriend_yerin.lol_friends.view.main

interface MainContract {

    interface View{

    }

    interface Presenter{
        fun setView(view : View)
    }
}