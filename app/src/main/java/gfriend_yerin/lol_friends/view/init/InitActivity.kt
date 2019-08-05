package gfriend_yerin.lol_friends.view.init

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import gfriend_yerin.lol_friends.data.RiotDataRepository
import gfriend_yerin.lol_friends.view.main.MainActivity

class InitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        RiotDataRepository.initStaticData()

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },1500)
    }
}