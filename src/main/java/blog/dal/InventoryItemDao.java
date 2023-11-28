package blog.dal;
import blog.model.InventoryItem;
import blog.model.Character;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryItemDao{
    protected ConnectionManager connectionManager;

	private static InventoryItemDao instance = null;
	protected InventoryItemDao() {
		connectionManager = new ConnectionManager();
	}
	public static InventoryItemDao getInstance() {
		if(instance == null) {
			instance = new InventoryItemDao();
		}
		return instance;
	}

    public InventoryItem create (InventoryItem inventoryItem) throws SQLException {
        String query = "INSERT INTO InventoryItem (firstName, lastName, itemName, number) " +
                "VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, inventoryItem.getFirstName());
            statement.setString(2, inventoryItem.getLastName());
            statement.setString(3, inventoryItem.getItemName());
            statement.setInt(4, inventoryItem.getNumber());
            statement.executeUpdate();
            return inventoryItem;
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
    public List<InventoryItem> getItemByName(Character character) throws SQLException{
        String query = "SELECT * FROM InventoryItem WHERE firstName = ? AND lastName = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        List<InventoryItem> inventoryItems = new ArrayList<InventoryItem>();
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, character.getFirstName());
            statement.setString(2, character.getLastName());
            results = statement.executeQuery();
            while(results.next()) {
                String firstName = results.getString("firstName");
                String lastName = results.getString("lastName");
                String itemName = results.getString("itemName");
                int number = results.getInt("number");
                InventoryItem inventoryItem = new InventoryItem(firstName, lastName, itemName, number);
                inventoryItems.add(inventoryItem);
            }
            return inventoryItems;
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
    public InventoryItem updateNumber(InventoryItem inventoryItem, int newNumber) throws SQLException {
        String query = "UPDATE InventoryItem SET number=? WHERE firstName=? AND lastName=? AND itemName=?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, newNumber);
            statement.setString(2, inventoryItem.getFirstName());
            statement.setString(3, inventoryItem.getLastName());
            statement.setString(4, inventoryItem.getItemName());
            statement.executeUpdate();
            inventoryItem.setNumber(newNumber);
            return inventoryItem;
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
