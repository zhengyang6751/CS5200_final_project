package blog.dal;
import blog.model.EquippedItem;
import blog.model.GearItem;
import blog.model.WeaponItem;
import blog.model.Character;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquippedItemDao {
    protected ConnectionManager connectionManager;

	private static EquippedItemDao instance = null;
	protected EquippedItemDao() {
		connectionManager = new ConnectionManager();
	}
	public static EquippedItemDao getInstance() {
		if(instance == null) {
			instance = new EquippedItemDao();
		}
		return instance;
	}

    public EquippedItem create(EquippedItem equippedItem) throws SQLException {
        String query = "INSERT INTO EquippedItem (firstName, lastName, slotName, itemName) " +
                "VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        WeaponItemDao weaponItemDao = WeaponItemDao.getInstance();
        GearItemDao gearItemDao = GearItemDao.getInstance();
        WeaponItem weaponItem = null;
        GearItem gearItem = null;
        weaponItem = weaponItemDao.getWeaponItemByName(equippedItem.getItemName());
        gearItem = gearItemDao.getGearItemByName(equippedItem.getItemName());
        if(weaponItem == null && gearItem == null) {
            return null;
        }
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, equippedItem.getFirstName());
            statement.setString(2, equippedItem.getLastName());
            statement.setString(3, equippedItem.getSlotName());
            statement.setString(4, equippedItem.getItemName());
            statement.executeUpdate();
            return equippedItem;
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
    

    public EquippedItem getEquippedItemByName(Character character, String slotName) throws SQLException{
        String query = "SELECT * FROM EquippedItem WHERE firstName = ? AND lastName = ? AND slotName = ?;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, character.getFirstName());
            statement.setString(2, character.getLastName());
            statement.setString(3, slotName);
            results = statement.executeQuery();
            if(results.next()) {
                String resultFirstName = results.getString("firstName");
                String resultLastName = results.getString("lastName");
                String resultSlotName = results.getString("slotName");
                String resultItemName = results.getString("itemName");
                EquippedItem equippedItem = new EquippedItem(resultFirstName, resultLastName, resultSlotName, resultItemName);
                return equippedItem;
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
        }
        return null;
    }

    public EquippedItem updateGear(GearItem gearItem, String firstName, String lastName) throws SQLException {
        String query = "UPDATE EquippedItem SET itemName=? WHERE firstName=? AND lastName=? AND slotName=?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, gearItem.getItemName());
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, gearItem.getSlotName());
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
    public EquippedItem updateWeapon(WeaponItem weaponItem, String firstName, String lastName) throws SQLException {
        String query = "UPDATE EquippedItem SET itemName=? WHERE firstName=? AND lastName=? AND slotName=?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, weaponItem.getItemName());
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, "Main Hand");
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
    public EquippedItem deleteEquippedItem(EquippedItem equippedItem) throws SQLException {
        String query = "DELETE FROM EquippedItem WHERE firstName=? AND lastName=? AND slotName=?";
        Connection connection = null;
        PreparedStatement statement = null;
        if(equippedItem.getSlotName() == "Main Hand") {
            return null;
        }
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, equippedItem.getFirstName());
            statement.setString(2, equippedItem.getLastName());
            statement.setString(3, equippedItem.getSlotName());
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
