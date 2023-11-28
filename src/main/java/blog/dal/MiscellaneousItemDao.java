package blog.dal;

import blog.model.MiscellaneousItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MiscellaneousItemDao {
    protected ConnectionManager connectionManager;

	private static MiscellaneousItemDao instance = null;
	protected MiscellaneousItemDao() {
		connectionManager = new ConnectionManager();
	}
	public static MiscellaneousItemDao getInstance() {
		if(instance == null) {
			instance = new MiscellaneousItemDao();
		}
		return instance;
	}

    public MiscellaneousItem create(MiscellaneousItem miscellaneousItem) throws SQLException{
        String query = "INSERT INTO MiscellaneousItem (itemName, description) " +
                "VALUES (?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, miscellaneousItem.getItemName());
            statement.setString(2, miscellaneousItem.getDescription());
            statement.executeUpdate();
            return miscellaneousItem;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
        }
    }

    public MiscellaneousItem updateDescription(MiscellaneousItem miscellaneousItem, String newDescription) throws SQLException{
        String query = "UPDATE MiscellaneousItem SET description = ? WHERE itemName = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, newDescription);
            statement.setString(2, miscellaneousItem.getItemName());
            statement.executeUpdate();
            miscellaneousItem.setDescription(newDescription);
            return miscellaneousItem;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
        }
    }

    public MiscellaneousItem getMiscellaneousItemByName(String itemName) throws SQLException{
        String query = "SELECT * FROM MiscellaneousItem WHERE itemName = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, itemName);
            results = statement.executeQuery();
            if(results.next()) {
                String resultItemName = results.getString("itemName");
                String description = results.getString("description");
                MiscellaneousItem miscellaneousItem = new MiscellaneousItem(resultItemName, description);
                return miscellaneousItem;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MiscellaneousItem delete(MiscellaneousItem miscellaneousItem) throws SQLException {
        String query = "DELETE FROM MiscellaneousItem WHERE itemName=?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, miscellaneousItem.getItemName());
            statement.executeUpdate();
            return miscellaneousItem;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
        }
    }
}
