package com.online.multishop;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.SQLException;

public class DatabaseConnection {

    private final DataSource dataSource;

    public DatabaseConnection(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PreDestroy
    public void closeConnections() throws SQLException {
        dataSource.getConnection().close();
    }
}
