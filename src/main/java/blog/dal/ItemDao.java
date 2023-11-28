package blog.dal;

import blog.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDao {
    protected ConnectionManager connectionManager;

	private static ItemDao instance = null;
	protected ItemDao() {
		connectionManager = new ConnectionManager();
	}
	public static ItemDao getInstance() {
		if(instance == null) {
			instance = new ItemDao();
		}
		return instance;
	}

    public Item create(Item item) throws SQLException {
        String query = "INSERT INTO Items (itemName, stackSize, vendorPrice, isSellable) " +
                "VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, item.getItemName());
            statement.setInt(2, item.getStackSize());
            statement.setInt(3, item.getVendorPrice());
            statement.setBoolean(4, item.getIsSellable());
            statement.executeUpdate();
            return item;
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

    public Item getItemByName(String name) throws SQLException{
        String query = "SELECT * FROM Items WHERE itemName = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            results = statement.executeQuery();
            if(results.next()) {
                String itemName = results.getString("itemName");
                int stackSize = results.getInt("stackSize");
                int vendorPrice = results.getInt("vendorPrice");
                boolean isSellable = results.getBoolean("isSellable");
                Item item = new Item(itemName, stackSize, vendorPrice, isSellable);
                return item;
            }
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
            if(results != null) {
                results.close();
            }
        }
        return null;
    }

    public Item deleteItem(Item item) throws SQLException {
        String query = "DELETE FROM Items WHERE itemName=?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, item.getItemName());
            statement.executeUpdate();
            return null;
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
