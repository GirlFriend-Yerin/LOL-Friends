package gfriend_yerin.lol_friends.data

import gfriend_yerin.lol_friends.data.remote.RiotRemoteDataSource

object RiotDataRepository : RiotSource{

    private val RiotRemoteSource : RiotRemoteDataSource = RiotRemoteDataSource

    override fun initStaticData() {
        RiotRemoteSource.initStaticData()
    }

    override fun getPlayerInfo(name: String, playerListener: RiotSource.PlayerListener) {
        RiotRemoteSource.getPlayerInfo(name, playerListener)
    }

    override fun getRankInfo(encId: String, rankListener: RiotSource.RankListener) {
        RiotRemoteSource.getRankInfo(encId, rankListener)
    }

    override fun getMatchInfo(accId: String, matchListener: RiotSource.MatchListener) {
        RiotRemoteSource.getMatchInfo(accId, matchListener)
    }

}