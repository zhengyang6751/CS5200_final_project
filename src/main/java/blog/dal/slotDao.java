package blog.dal;

import blog.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class slotDao {
	protected ConnectionManager connectionManager;

	private static slotDao instance = null;
	protected slotDao() {
		connectionManager = new ConnectionManager();
	}
	public static slotDao getInstance() {
		if(instance == null) {
			instance = new slotDao();
		}
		return instance;
	}
	public slot create(slot st) throws SQLException {
		String query = "INSERT INTO slot(slotName) VALUES(?);";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = connectionManager.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, st.getSlotName());
            ps.executeUpdate();
            return st;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
		}
	

	
	}
    