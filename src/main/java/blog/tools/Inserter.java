package blog.tools;

import blog.dal.*;
import blog.model.*;
import blog.model.Character;

import java.sql.SQLException;
import java.util.List;


/**
 * main() runner, used for the app demo.
 * 
 * Instructions:
 * 1. Create a new MySQL schema and then run the CREATE TABLE statements from lecture:
 * http://goo.gl/86a11H.
 * 2. Update ConnectionManager with the correct user, password, and schema.
 */
public class Inserter {

	public static void main(String[] args) throws SQLException {
		// DAO instances.
		AccountDao accountDao = AccountDao.getInstance();
		CharacterDao characterDao = CharacterDao.getInstance();
		CurrencyDao currencyDao = CurrencyDao.getInstance();
		CharacterCurrencyDao characterCurrencyDao = CharacterCurrencyDao.getInstance();
		JobsDao jobsDao = JobsDao.getInstance();
		CharacterJobsDao characterJobsDao = CharacterJobsDao.getInstance();
		ItemDao itemDao = ItemDao.getInstance();
		InventoryItemDao inventoryItemDao = InventoryItemDao.getInstance();
		AttributeBonusConsumableDao attributeBonusConsumableDao = AttributeBonusConsumableDao.getInstance();
		AttributeBonusWeaponDao attributeBonusWeaponDao = AttributeBonusWeaponDao.getInstance();
		AttributeBonusGearDao attributeBonusGearDao = AttributeBonusGearDao.getInstance();
		ConsumableItemDao consumableItemDao = ConsumableItemDao.getInstance();
		WeaponItemDao weaponItemDao = WeaponItemDao.getInstance();
		GearItemDao gearItemDao = GearItemDao.getInstance();
		CustomizableWeaponDao customizableWeaponDao = CustomizableWeaponDao.getInstance();
		CustomizableGearDao customizableGearDao = CustomizableGearDao.getInstance();
		EquippedItemDao equippedItemDao = EquippedItemDao.getInstance();
		MiscellaneousItemDao miscellaneousItemDao = MiscellaneousItemDao.getInstance();


		Account acc1 = new Account("lily", "lily@gmail.com");
		acc1 = accountDao.create(acc1);
		System.out.println("Get account by id:" + acc1.getAccountId());
		Account acc = accountDao.getAccountById(1);
		System.out.println("Get account by id 1:" + acc);
		accountDao.updateEmailAddress(acc1, "lily222@hotfox.com");
		accountDao.updateName(acc1, "lily222");

		Character char1 = new Character(acc1.getAccountId(), "Lily", "Wang", 10, 10, 10, 10);
		char1 = characterDao.create(acc1, char1);
		System.out.println("Successfully created char1: " + char1);
		char1 = characterDao.updateStrength(char1, 20);
		System.out.println("Successfully updated char1: " + char1);
		char1 = characterDao.updateDexterity(char1, 20);
		System.out.println("Successfully updated char1: " + char1);
		char1 = characterDao.updateVitality(char1, 20);
		System.out.println("Successfully updated char1: " + char1);
		char1 = characterDao.updateIntelligence(char1, 20);
		System.out.println("Successfully updated char1: " + char1);
		char1 = characterDao.delete(char1);
		System.out.println("Successfully deleted char1");

		Character char2 = new Character(acc1.getAccountId(), "Lily", "Wang", 10, 10, 10, 10);
		char2 = characterDao.create(acc1, char2);
		System.out.println("Successfully created char2: " + char2);

		Currency currency1 = new Currency("Gold", 100, 1000);
		currency1 = currencyDao.create(currency1);
		System.out.println("Successfully created currency1: " + currency1);
		currency1 = currencyDao.updateWeeklyCaps(currency1, 200);
		System.out.println("Successfully updated currency1: " + currency1);
		currency1 = currencyDao.updateTotalCaps(currency1, 2000);
		System.out.println("Successfully updated currency1: " + currency1);
		Currency currency2 = currencyDao.getCurrencyByName("Gold");
		System.out.println("Successfully retrieved currency2: " + currency2);
		Currency currency3 = new Currency("silver", 700, 1900);
		currency3 = currencyDao.create(currency3);

		characterCurrencyDao.create(currency1, char2, 100, 1000);
		characterCurrencyDao.create(currency3, char2, 200, 2000);
		characterCurrencyDao.updateWeek(char2, currency1, 200);
		characterCurrencyDao.updateTotal(char2, currency1, 2000);
		List<CharacterCurrency> characterCurrencies = characterCurrencyDao.getCurrencyByCharacter(char2);
		for (CharacterCurrency characterCurrency : characterCurrencies) {
			System.out.println(characterCurrency);
		}

		Jobs job1 = new Jobs("job1", "category1");
		job1 = jobsDao.create(job1);
		System.out.println("Successfully created job1: " + job1);
		Jobs job2 = new Jobs("job2", "category2");
		job2 = jobsDao.create(job2);
		System.out.println("Successfully created job2: " + job2);

		characterJobsDao.create(job1, char2);
		System.out.println("Successfully created cj1: " + job1);
		characterJobsDao.create(job2, char2);
		System.out.println("Successfully created cj2: " + job2);
		CharacterJobs cj1 = characterJobsDao.updateExpAndJobLevel(char2, job1, 200);
		System.out.println("Successfully updated cj1: " + cj1);
		characterJobsDao.updateExpAndJobLevel(char2, job2, 200);
		System.out.println("Successfully updated cj2: " + cj1);

		Item item1 = new Item("item1", 100, 1000, true);
		item1 = itemDao.create(item1);
		System.out.println("Successfully created item1: " + item1);
		Item item2 = new Item("item2", 200, 2000, true);
		item2 = itemDao.create(item2);
		System.out.println("Successfully created item2: " + item2);
		item1 = itemDao.getItemByName("item1");
		System.out.println("Successfully retrieved item1: " + item1);
		item2 = itemDao.getItemByName("item2");
		System.out.println("Successfully retrieved item2: " + item2);
		Item item3 = new Item("item3", 300, 3000, true);
		item3 = itemDao.create(item3);
		System.out.println("Successfully created item3: " + item3);
		itemDao.deleteItem(item3);
		item3 = itemDao.getItemByName("item3");
		if(item3 == null)  System.out.println("Successfully deleted item3");
		Item item4 = new Item("item4", 400, 4000, true);
		item4 = itemDao.create(item4);
		System.out.println("Successfully created item4: " + item4);
		item3 = new Item("item3", 500, 5000, true);
		item3 = itemDao.create(item3);
		Item item5 = new Item("item5", 600, 6000, true);
		item5 = itemDao.create(item5);
		Item item6 = new Item("item6", 700, 7000, true);
		item6 = itemDao.create(item6);

		InventoryItem inventoryItem1 = new InventoryItem(char2.getFirstName(), char2.getLastName(), item1.getItemName(), 100);
		inventoryItem1 = inventoryItemDao.create(inventoryItem1);
		System.out.println("Successfully created inventoryItem1: " + inventoryItem1);
		InventoryItem inventoryItem2 = new InventoryItem(char2.getFirstName(), char2.getLastName(), item2.getItemName(), 200);
		inventoryItem2 = inventoryItemDao.create(inventoryItem2);
		System.out.println("Successfully created inventoryItem2: " + inventoryItem2);
		inventoryItem1 = inventoryItemDao.updateNumber(inventoryItem1, 200);
		System.out.println("Successfully updated inventoryItem1: " + inventoryItem1);
		List<InventoryItem> inventoryItems = inventoryItemDao.getItemByName(char2);
		for (InventoryItem inventoryItem : inventoryItems) {
			System.out.println(inventoryItem);
		}
		InventoryItem inventoryItem3 = new InventoryItem(char2.getFirstName(), char2.getLastName(), item3.getItemName(), 300);
		inventoryItem3 = inventoryItemDao.create(inventoryItem3);
		InventoryItem inventoryItem4 = new InventoryItem(char2.getFirstName(), char2.getLastName(), item4.getItemName(), 400);
		inventoryItem4 = inventoryItemDao.create(inventoryItem4);
		
		WeaponItem weaponItem1 = new WeaponItem("Item1", 100, 50, job1.getJobName(), true, 1, 1200);
		weaponItem1 = weaponItemDao.create(weaponItem1);
		System.out.println("Successfully created weaponItem1: " + weaponItem1);
		WeaponItem weaponItem2 = new WeaponItem("Item2", 200, 100, job2.getJobName(), true, 2, 2200);
		weaponItem2 = weaponItemDao.create(weaponItem2);
		System.out.println("Successfully created weaponItem2: " + weaponItem2);
		weaponItem1 = weaponItemDao.getWeaponItemByName("Item1");
		System.out.println("Successfully retrieved weaponItem1: " + weaponItem1);
		weaponItem1 = weaponItemDao.updateitemLevel(weaponItem1, 60);
		System.out.println("Successfully updated weaponItem1: " + weaponItem1);
		weaponItem2 = weaponItemDao.updateDamageDone(weaponItem2, 3400);
		System.out.println("Successfully updated weaponItem2: " + weaponItem2);

		GearItem gearItem1 = new GearItem("Item3", 100, "Head", 50, job1.getJobName(), 1, 1200);
		gearItem1 = gearItemDao.create(gearItem1);
		System.out.println("Successfully created gearItem1: " + gearItem1);
		GearItem gearItem2 = new GearItem("Item4", 200, "Body", 100, job2.getJobName(), 2, 2200);
		gearItem2 = gearItemDao.create(gearItem2);
		System.out.println("Successfully created gearItem2: " + gearItem2);
		gearItem1 = gearItemDao.getGearItemByName("Item3");
		System.out.println("Successfully retrieved gearItem1: " + gearItem1);
		List<GearItem> gearList = gearItemDao.getGearItemByPartialName("Item");
		for (GearItem gearItem : gearList) {
			System.out.println(gearItem);
		}
		gearItem1 = gearItemDao.updateDefenseRating(gearItem1, 6);
		System.out.println("Successfully updated gearItem1: " + gearItem1);
		gearItem2 = gearItemDao.updateMagicDefenseRating(gearItem2, 1500);
		System.out.println("Successfully updated gearItem2: " + gearItem2);


		EquippedItem equippedItem1 = new EquippedItem(char2.getFirstName(), char2.getLastName(), "Main Hand", weaponItem1.getItemName());
		equippedItem1 = equippedItemDao.create(equippedItem1);
		if(equippedItem1 != null) System.out.println("Successfully created equippedItem1: " + equippedItem1);
		EquippedItem equippedItem2 = new EquippedItem(char2.getFirstName(), char2.getLastName(), "Head", gearItem1.getItemName());
		equippedItem2 = equippedItemDao.create(equippedItem2);
		if(equippedItem2 != null) System.out.println("Successfully created equippedItem2: " + equippedItem2);

		MiscellaneousItem miscellaneousItem1 = new MiscellaneousItem("item5", "Miscellaneous");
		miscellaneousItem1 = miscellaneousItemDao.create(miscellaneousItem1);
		System.out.println("Successfully created miscellaneousItem1: " + miscellaneousItem1);
		miscellaneousItem1 = miscellaneousItemDao.getMiscellaneousItemByName(item5.getItemName());
		System.out.println("Successfully retrieved miscellaneousItem1: " + miscellaneousItem1);
		miscellaneousItem1 = miscellaneousItemDao.updateDescription(miscellaneousItem1, "MiscellaneousItem");
		System.out.println("Successfully updated miscellaneousItem1: " + miscellaneousItem1);

		ConsumableItem consumableItem1 = new ConsumableItem("item6", 10, "Consumable", 1000, 1000, 1000, 1000, 1000);
		consumableItem1 = consumableItemDao.create(consumableItem1);
		System.out.println("Successfully created consumableItem1: " + consumableItem1);
		consumableItem1 = consumableItemDao.getConsumableItemByName(consumableItem1.getItemName());
		System.out.println("Successfully retrieved consumableItem1: " + consumableItem1);

		AttributeBonusConsumable attributeBonusConsumable1 = new AttributeBonusConsumable(consumableItem1.getItemName(), 400, 400, 400, 400, 400);
		attributeBonusConsumable1 = attributeBonusConsumableDao.create(attributeBonusConsumable1);
		System.out.println("Successfully created attributeBonusConsumable1: " + attributeBonusConsumable1);
		attributeBonusConsumable1 = attributeBonusConsumableDao.getAttributeBonusConsumableByItemName(attributeBonusConsumable1.getItemName());
		System.out.println("Successfully retrieved attributeBonusConsumable1: " + attributeBonusConsumable1);

		AttributeBonusWeapon attributeBonusWeapon1 = new AttributeBonusWeapon(weaponItem1.getItemName(), 400, 400, 400, 400, 400);
		attributeBonusWeapon1 = attributeBonusWeaponDao.create(attributeBonusWeapon1);
		System.out.println("Successfully created attributeBonusWeapon1: " + attributeBonusWeapon1);
		attributeBonusWeapon1 = attributeBonusWeaponDao.getAttributeBonusWeaponByItemName(attributeBonusWeapon1.getItemName());
		System.out.println("Successfully retrieved attributeBonusWeapon1: " + attributeBonusWeapon1);

		AttributeBonusGear attributeBonusGear1 = new AttributeBonusGear(gearItem1.getItemName(), 400, 400, 400, 400, 400);
		attributeBonusGear1 = attributeBonusGearDao.create(attributeBonusGear1);
		System.out.println("Successfully created attributeBonusGear1: " + attributeBonusGear1);
		attributeBonusGear1 = attributeBonusGearDao.getAttributeBonusGearByItemName(attributeBonusGear1.getItemName());
		System.out.println("Successfully retrieved attributeBonusGear1: " + attributeBonusGear1);

		CustomizableWeapon customizableWeapon1 = new CustomizableWeapon(weaponItem1.getItemName(), "Red", "Good", "New", char2.getFirstName() + " " + char2.getLastName());
		customizableWeapon1 = customizableWeaponDao.create(customizableWeapon1);
		System.out.println("Successfully created customizableWeapon1: " + customizableWeapon1);
		customizableWeapon1 = customizableWeaponDao.getCustomizableWeaponById(1);
		System.out.println("Successfully retrieved customizableWeapon1: " + customizableWeapon1);
		List<CustomizableWeapon> customizableWeapons = customizableWeaponDao.getCustomizableWeaponByName(weaponItem1.getItemName());
		for (CustomizableWeapon customizableWeapon : customizableWeapons) {
			System.out.println(customizableWeapon);
		}
		List<CustomizableWeapon> customizableWeapons2 = customizableWeaponDao.getCustomizableWeaponByCharacter(char2.getFirstName() + " " + char2.getLastName());
		for (CustomizableWeapon customizableWeapon : customizableWeapons2) {
			System.out.println(customizableWeapon);
		}

		CustomizableGear customizableGear1 = new CustomizableGear(gearItem1.getItemName(), "Red", "Good", "New", char2.getFirstName() + " " + char2.getLastName());
		customizableGear1 = customizableGearDao.create(customizableGear1);
		System.out.println("Successfully created customizableGear1: " + customizableGear1);
		customizableGear1 = customizableGearDao.getCustomizableGearById(1);
		System.out.println("Successfully retrieved customizableGear1: " + customizableGear1);
		List<CustomizableGear> customizableGears = customizableGearDao.getCustomizableGearsByName(gearItem1.getItemName());
		for (CustomizableGear customizableGear : customizableGears) {
			System.out.println(customizableGear);
		}
		List<CustomizableGear> customizableGears2 = customizableGearDao.getCustomizableGearByCharacter(char2.getFirstName() + " " + char2.getLastName());
		for (CustomizableGear customizableGear : customizableGears2) {
			System.out.println(customizableGear);
		}
	}
}
