package gfriend_yerin.lol_friends.data.playinfo

import gfriend_yerin.lol_friends.data.player.PlayerVO

class PlayInfoVO(builder: Builder) {
    private var code = 0
        get() = field
    private var kill = 0
        get() = field
    private var name: String
        get() = field
    private var death = 0
        get() = field
    private var assist = 0
        get() = field
    private var timestamp = 0L
        get() = field
    private var victory = true
        get() = field
    private var teamPlayer: ArrayList<PlayerVO>
        get() = field
    private var enemyPlayer: ArrayList<PlayerVO>
        get() = field

    init {
        this.code = builder.code
        this.kill = builder.kill
        this.name = builder.name!!
        this.death = builder.death
        this.assist = builder.assist
        this.timestamp = builder.timestamp
        this.victory = builder.victory
        this.teamPlayer = builder.teamPlayer!!
        this.enemyPlayer = builder.enemyPlayer!!
    }

    class Builder{
        var code: Int = 0
        var name: String? = null
        var kill: Int = 0
        var death : Int = 0
        var assist : Int =0
        var playTime : Long = 0
        var timestamp : Long = 0
        var victory : Boolean = true
        var teamPlayer: ArrayList<PlayerVO>? = null
        var enemyPlayer: ArrayList<PlayerVO>? = null

        fun code(code: Int) = apply { this.code = code }
        fun name(name: String) = apply { this.name = name }
        fun kill(kill: Int) = apply { this.kill = kill }
        fun death(death: Int) = apply { this.death = death }
        fun assist(assist: Int) = apply { this.assist = assist }
        fun playTime(playTime: Long) = apply { this.playTime = playTime }
        fun victory(victory: Boolean) = apply { this.victory = victory }
        fun timeStamp(timestamp: Long) = apply { this.timestamp = timestamp }
        fun myTeam(teamPlayer: ArrayList<PlayerVO>) = apply { this.teamPlayer = teamPlayer }
        fun enemy(enemyPlayer: ArrayList<PlayerVO>) = apply { this.enemyPlayer = enemyPlayer }
        fun build() = PlayInfoVO(this)
    }
}