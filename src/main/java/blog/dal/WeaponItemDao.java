package blog.dal;
import blog.model.WeaponItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class WeaponItemDao {
    protected ConnectionManager connectionManager;

	private static WeaponItemDao instance = null;
	protected WeaponItemDao() {
		connectionManager = new ConnectionManager();
	}
	public static WeaponItemDao getInstance() {
		if(instance == null) {
			instance = new WeaponItemDao();
		}
		return instance;
	}

    public WeaponItem create(WeaponItem weaponItem) throws SQLException {
        String query = "INSERT INTO WeaponItem (itemName, itemLevel, requiredLevel, requiredJob, autoAttack, attackDelay, damageDone) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, weaponItem.getItemName());
            statement.setInt(2, weaponItem.getItemLevel());
            statement.setInt(3, weaponItem.getRequiredLevel());
            statement.setString(4, weaponItem.getRequiredJob());
            statement.setBoolean(5, weaponItem.getAutoAttack());
            statement.setInt(6, weaponItem.getAttackDelay());
            statement.setInt(7, weaponItem.getDamageDone());
            statement.executeUpdate();
            return weaponItem;
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

    public WeaponItem getWeaponItemByName(String itemName) throws SQLException{
        String query = "SELECT * FROM WeaponItem WHERE itemName = ?;";
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
                int itemLevel = results.getInt("itemLevel");
                int requiredLevel = results.getInt("requiredLevel");
                String requiredJob = results.getString("requiredJob");
                boolean autoAttack = results.getBoolean("autoAttack");
                int attackDelay = results.getInt("attackDelay");
                int damageDone = results.getInt("damageDone");
                WeaponItem weaponItem = new WeaponItem(resultItemName, itemLevel, requiredLevel, requiredJob, autoAttack, attackDelay, damageDone);
                return weaponItem;
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

    public WeaponItem updateitemLevel(WeaponItem weaponItem, int newItemLevel) throws SQLException {
        String query = "UPDATE WeaponItem SET itemLevel=? WHERE itemName=?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, newItemLevel);
            statement.setString(2, weaponItem.getItemName());
            statement.executeUpdate();
            weaponItem.setItemLevel(newItemLevel);
            return weaponItem;
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

    public WeaponItem updateDamageDone(WeaponItem weaponItem, int newDamageDone) throws SQLException {
        String query = "UPDATE WeaponItem SET damageDone=? WHERE itemName=?;";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, newDamageDone);
            statement.setString(2, weaponItem.getItemName());
            statement.executeUpdate();
            weaponItem.setDamageDone(newDamageDone);
            return weaponItem;
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
