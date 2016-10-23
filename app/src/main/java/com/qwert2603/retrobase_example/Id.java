package com.qwert2603.retrobase_example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Id {
    private int mId;

    public Id(ResultSet resultSet) throws SQLException {
        mId = resultSet.getInt(1);
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}