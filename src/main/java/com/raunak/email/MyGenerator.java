package com.raunak.email;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGenerator implements IdentifierGenerator {

	private static final long serialVersionUID = 1L;

	@Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "grp-for-";
        String query = "SELECT MAX(people_id) FROM groups";
        Connection connection = null;
		try {
			connection = session.getJdbcConnectionAccess().obtainConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String lastId = rs.getString(1);
                if (lastId != null) {
                    int number = Integer.parseInt(lastId.substring(prefix.length())) + 1;
                    return prefix + "-" + number;
                }
            }
        } catch (SQLException e) {
            throw new HibernateException("Unable to generate ID", e);
        }

        return prefix + "-" + 1;
    }
}