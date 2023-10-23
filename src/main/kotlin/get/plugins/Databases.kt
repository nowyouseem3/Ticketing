package get.plugins

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.network.sockets.*
import io.ktor.server.config.*
import java.sql.*
import java.sql.Connection

class DBConfig {
    private val config = HikariConfig()
    private var ds: HikariDataSource? = null

    @Throws(SQLException::class)
    fun connection(): Connection
    {
        val appConf = HoconApplicationConfig(ConfigFactory.load())
        val port = appConf.property("db.port").getString()
        config.jdbcUrl = "jdbc:postgresql://192.168.4.134:$port/postgres"
        config.username = appConf.property("db.userName").getString()
        config.password = appConf.property("db.userPassword").getString()
        config.addDataSourceProperty("cachePrepStmts", "true")
        config.addDataSourceProperty("prepStmtCacheSize", "255")
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048")
        ds = HikariDataSource(config)

        return  ds!!.connection
    }
}

