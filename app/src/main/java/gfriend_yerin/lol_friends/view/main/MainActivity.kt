package gfriend_yerin.lol_friends.view.main

import android.os.Bundle
import gfriend_yerin.lol_friends.BaseActivity
import gfriend_yerin.lol_friends.R

class MainActivity : BaseActivity(), MainContract.View{

    private lateinit var presenter : MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter()
    }
}
