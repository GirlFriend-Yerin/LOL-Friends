package gfriend_yerin.lol_friends.data.playinfo

import gfriend_yerin.lol_friends.data.playinfo.player.PlayerVO

data class PlayInfoVO(private val builder: Builder) {

    class Builder {
        private var code = 0
        private lateinit var name: String
        private var kill = 0
        private var death = 0
        private var assist = 0
        private var playTime = 0L
        private var timestamp = 0L
        private var victory = true
        private lateinit var teamPlayer : ArrayList<PlayerVO>
        private lateinit var enemyPlayer : ArrayList<PlayerVO>

        fun code(code: Int) = apply { this.code = code }
        fun name(name: String) = apply { this.name = name }
        fun kill(kill: Int) = apply { this.kill = kill }
        fun death(death: Int) = apply { this.death = death }
        fun assist(assist: Int) = apply { this.assist = assist }
        fun playTime(playTime: Long) = apply { this.playTime = playTime }
        fun victory(victory: Boolean) = apply { this.victory = victory }
        fun timeStamp(timestamp: Long) = apply { this.timestamp = timestamp }
        fun myTeam(teamPlayer : ArrayList<PlayerVO>) = apply { this.teamPlayer = teamPlayer}
        fun enemy(enemyPlayer : ArrayList<PlayerVO>) = apply { this.enemyPlayer = enemyPlayer}
        fun build() = PlayInfoVO(this)
    }
}