package gfriend_yerin.lol_friends.view.main

import android.os.Bundle
import android.view.KeyEvent
import gfriend_yerin.lol_friends.BaseActivity
import gfriend_yerin.lol_friends.R
import gfriend_yerin.lol_friends.data.value_object.PlayInfoVO
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View{

    private lateinit var presenter : MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter()

        main_player_edit.setOnKeyListener { view, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                search(main_player_edit.text.toString())
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }

    override fun updateEntries(entries: ArrayList<PlayInfoVO>) {

    }

    private fun search(name : String){

    }
}
