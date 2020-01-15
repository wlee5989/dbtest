package com.rackroom.cpi.dbtest;
import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSource {
 
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
 
    
    
    static {
    	
    	String jdbcUrl="jdbc:mysql:///hybrisdb?cloudSqlInstance=rrs-hybris-dev:us-east4:sql&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=hybris&password=Nd4734MvKjyu4NAT";
    	String	dataSourceUser="hybris";
    	String	dataSourcePassword="Nd4734MvKjyu4NAT";
    	
    	
        config.setJdbcUrl( jdbcUrl );
        config.setUsername( dataSourceUser );
        config.setPassword( dataSourcePassword );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }
 
    private DataSource() {}
 
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}