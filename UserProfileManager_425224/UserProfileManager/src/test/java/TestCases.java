import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import dao.ProfileDAO;
import dao.UserDAO;
import entities.Profile;
import entities.User;
import exceptions.ProfileException;
import exceptions.UserException;
import jakarta.persistence.EntityManager;
import utilities.EMUtil;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class TestCases {
	
	public static double marks = 1;
	
	private EntityManager em;
	private UserDAO userDAO;
	private ProfileDAO profileDAO;
	
	@BeforeAll
	void setUp() throws Exception {
		em = (EntityManager) Class.forName("utilities.EMUtil").getDeclaredMethod("provideEntityManager").invoke(EMUtil.class);
		userDAO = (UserDAO) Class.forName("dao.UserDAOImpl").getDeclaredConstructor(EntityManager.class).newInstance(em);
		profileDAO = (ProfileDAO) Class.forName("dao.ProfileDAOImpl").getDeclaredConstructor(EntityManager.class).newInstance(em);
		marks++;
	}
	
	@AfterAll
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	@Order(1)
	@DisplayName("Entity class attributes check")
	void testEntityClassAttributesCheck() throws Exception {
		// Arrange and Act and Assert
		assertEquals(4, User.class.getDeclaredFields().length,
				"Failure message: Incorrect number of attributes in user class");
		
		assertEquals(4, Profile.class.getDeclaredFields().length,
				"Failure message: Incorrect number of attributes in profile class");
		
		assertEquals(int.class, User.class.getDeclaredField("id").getType(),
				"Failure message: Incorrect data type for field id");
		
		assertEquals(int.class, Profile.class.getDeclaredField("id").getType(),
				"Failure message: Incorrect data type for field id");
		
		assertEquals(String.class, User.class.getDeclaredField("username").getType(),
				"Failure message: Incorrect data type for field username");
		
		assertEquals(String.class, Profile.class.getDeclaredField("lastName").getType(),
				"Failure message: Incorrect data type for field lastName");
		marks++;
	}
	
	@Test
	@Order(2)
	@DisplayName("addUser: When adding a new user, then it should be saved successfully in the database")
	public void testAddUser_WhenAddingNewUser_ThenUserSavedInDatabase() throws Exception {
        // Arrange
		Profile profile = Profile.class
                .getDeclaredConstructor(String.class, String.class, User.class)
                .newInstance("Sarah", "Davis", null);
		
		User user = User.class
				.getDeclaredConstructor(String.class, String.class, Profile.class)
				.newInstance("john123", "password1", profile);
		
		// Act
		userDAO.addUser(user);
		
		// Assert
		User savedUser = em.find(User.class, User.class.getDeclaredMethod("getId").invoke(user));
		
		assertNotNull(savedUser, 
				() -> "Failure message: User not save to database");
		assertEquals("password1", User.class.getDeclaredMethod("getPassword").invoke(savedUser),
				() -> "Failure message: Saved object does not matches with actual object");
		marks++;
    }
	
	@Test
	@Order(3)
	@DisplayName("addUser: When adding a null user, then UserException should be thrown")
	public void testAddUser_WhenUserIsNull_ThenUserExceptionThrown() throws Exception {
		// Arrange and Act and Assert
		assertThrows(UserException.class,() -> userDAO.addUser(null),
				() -> "Failure message: Expected UserException to be thrown");
		marks++;
	}
	
	@Test
	@Order(4)
	@DisplayName("getUserById: When retrieving a user by ID, then the corresponding user should be returned from the database")
	public void testGetUserById_WhenRetrievingUserById_ThenCorrespondingUserReturnedFromDatabase() throws Exception {
		// Arrange
		User user = User.class
				.getDeclaredConstructor(String.class, String.class, Profile.class)
				.newInstance("alex789", "password3", null);
		userDAO.addUser(user);
		int userId = (int) User.class.getDeclaredMethod("getId").invoke(user);
		
		// Act
		User foundUser = userDAO.getUserById(userId);
		
		// Assert
		assertNotNull(foundUser, 
				() -> "Failure message: User not save to database");
		assertEquals("password3", User.class.getDeclaredMethod("getPassword").invoke(foundUser),
				() -> "Failure message: Saved object does not matches with actual object");
		marks++;
	}

	@Test
	@Order(5)
	@DisplayName("getUserById: When retrieving a user by ID and the user is not found, then UserException should be thrown")
	public void testGetUserById_WhenUserNotFound_ThenUserExceptionThrown() throws Exception {
		// Arrange
		int userId = - new Random().nextInt(100, 110);
		
		// Act and Assert
		assertThrows(UserException.class, () -> userDAO.getUserById(userId),
				() -> "Failure message: UserException to be thrown if user not found");
		marks++;
	}
	
	@Test
	@Order(6)
	@DisplayName("updateUser: When updating an existing user, then the user details should be updated in the database")
	public void testUpdateUser_WhenUpdatingExistingUser_ThenUserDetailsUpdatedInDatabase() throws Exception {
		// Arrange
		User user = User.class
				.getDeclaredConstructor(String.class, String.class, Profile.class)
				.newInstance("mike654", "password5", null);
		userDAO.addUser(user);
		int userId = (int) User.class.getDeclaredMethod("getId").invoke(user);
		
		// Act
		userDAO.updateUser(user);
		
		// Assert
		User updatedUser = em.find(User.class, userId);
		assertNotNull(updatedUser, 
				() -> "Failure message: User not save to database");
		assertEquals("password5", User.class.getDeclaredMethod("getPassword").invoke(updatedUser),
				() -> "Failure message: Saved object does not matches with actual object");
		marks++;
	}
	
	@Test
	@Order(7)
	@DisplayName("updateUser: When updating a non-existent user, then UserException should be thrown")
	public void testUpdateUser_WhenUserNotFound_ThenUserExceptionThrown() throws Exception {
		// Arrange 
		User user = User.class
				.getDeclaredConstructor(String.class, String.class, Profile.class)
				.newInstance("sarah321", "password4", null);
		
		// Act and Assert
		assertThrows(UserException.class, () -> userDAO.updateUser(user),
				() -> "Failure message: UserException to be thrown if trying to upadate non existing user");
		
		marks++;
	}

	@Test
	@Order(8)
	@DisplayName("deleteUser: When deleting a user, then the user should be removed from the database")
	public void testDeleteUser_WhenDeletingUser_ThenUserRemovedFromDatabase() throws Exception {
		// Arrange
		User user = User.class
				.getDeclaredConstructor(String.class, String.class, Profile.class)
				.newInstance("phil654", "password5", null);
		userDAO.addUser(user);
		int userId = (int) User.class.getDeclaredMethod("getId").invoke(user);
		
		// Act
		userDAO.deleteUser(user);
		
		// Assert
		User deletedUser = em.find(User.class, userId);
		
		assertNull(deletedUser,
				() -> "Failure message: object is not deleted from database");
		
		marks++;
	}
	
	@Test
	@Order(9)
	@DisplayName("deleteUser: When deleting a non-existent user, then UserException should be thrown")
	public void testDeleteUser_WhenUserNotFound_ThenUserExceptionThrown() throws Exception {
		// Arrange 
		User user = User.class
				.getDeclaredConstructor(String.class, String.class, Profile.class)
				.newInstance("Phil654", "password7", null);
		
		// Act and Assert
		assertThrows(UserException.class, () -> userDAO.deleteUser(user),
				() -> "Failure message: UserException to be thrown if trying to delete non existing user");
		marks++;
	}
	
	@Test
	@Order(10)
	@DisplayName("addProfile: When adding a new profile, then it should be saved successfully in the database")
	public void testAddProfile_WhenAddingNewProfile_ThenProfileSavedInDatabase() throws Exception {
		// Arrange
        Profile profile = Profile.class
                .getDeclaredConstructor(String.class, String.class, User.class)
                .newInstance("John", "Doe", null);
        
        // Act
        profileDAO.addProfile(profile);

        // Retrieve
        Profile retrievedProfile = em.find(Profile.class, Profile.class.getDeclaredMethod("getId").invoke(profile));

        // Assert
        assertNotNull(retrievedProfile,
        		() -> "Failure message: profile object not save to database properly");
        assertEquals(
        		Profile.class.getDeclaredMethod("getFirstName").invoke(profile),
        		Profile.class.getDeclaredMethod("getFirstName").invoke(retrievedProfile),
        		() -> "Failure message: Original object attributes values not matches with saved object");
        assertEquals(
        		Profile.class.getDeclaredMethod("getLastName").invoke(profile),
        		Profile.class.getDeclaredMethod("getLastName").invoke(retrievedProfile),
        		() -> "Failure message: Original object attributes values not matches with saved object");
        marks++;
	}
	
	@Test
	@Order(11)
	@DisplayName("addProfile: When adding a null profile, then ProfileException should be thrown")
	public void testAddProfile_WhenProfileIsNull_ThenProfileExceptionThrown() throws Exception {
		// Arrange, Act, Assert
		assertThrows(ProfileException.class,
				() -> profileDAO.addProfile(null),
				() -> "Failure message: Expected ProfileException to be thrown");
		marks++;
	}

	@Test
	@Order(12)
	@DisplayName("getProfileById: When retrieving a profile by ID, then the corresponding profile should be returned from the database")
	public void testGetProfileById_WhenRetrievingProfileById_ThenCorrespondingProfileReturnedFromDatabase() throws Exception {
		// Arrange
		Profile profile = Profile.class
                .getDeclaredConstructor(String.class, String.class, User.class)
                .newInstance("Alex", "Johnson", null);
		profileDAO.addProfile(profile);
		
		int profileId = (int) Profile.class.getDeclaredMethod("getId").invoke(profile);
		
		// Act
		Profile foundProfile = profileDAO.getProfileById(profileId);
		
		// Assert
		assertNotNull(foundProfile,
				() -> "Failure message: return null profile object even if the proile present eith given id");
		assertEquals(
        		Profile.class.getDeclaredMethod("getFirstName").invoke(profile),
        		Profile.class.getDeclaredMethod("getFirstName").invoke(foundProfile),
        		() -> "Failure message: Original object attributes values not matches with saved object");
        assertEquals(
        		Profile.class.getDeclaredMethod("getLastName").invoke(profile),
        		Profile.class.getDeclaredMethod("getLastName").invoke(foundProfile),
        		() -> "Failure message: Original object attributes values not matches with saved object");
		marks++;
	}
	
	@Test
	@Order(13)
	@DisplayName("getProfileById: When retrieving a profile by ID and the profile is not found, then ProfileException should be thrown")
	public void testGetProfileById_WhenProfileNotFound_ThenProfileExceptionThrown() throws Exception {
		// Arrange 
		int profileId = - new Random().nextInt(100, 110);
		
		// Act and Assert
		assertThrows(ProfileException.class, () -> profileDAO.getProfileById(profileId),
				() -> "Failure message: Method is not throwing the exception even if profile is not present with given profile ID");
		marks++;
	}

	@Test
	@Order(14)
	@DisplayName("updateProfile: When updating an existing profile, then the profile details should be updated in the database")
	public void testUpdateProfile_WhenUpdatingExistingProfile_ThenProfileDetailsUpdatedInDatabase() throws Exception {
		// Arrange
		Profile profile = Profile.class
                .getDeclaredConstructor(String.class, String.class, User.class)
                .newInstance("Sarah", "Davis", null);
		profileDAO.addProfile(profile);
		Profile.class.getDeclaredMethod("setFirstName", String.class).invoke(profile, "Mike");
		int profileId = (int) Profile.class.getDeclaredMethod("getId").invoke(profile);
		
		// Act
		profileDAO.updateProfile(profile);
		
		// Assert
		Profile updatedProfile = em.find(Profile.class, profileId);
		
		assertEquals(Profile.class.getDeclaredMethod("getFirstName").invoke(profile),
        		Profile.class.getDeclaredMethod("getFirstName").invoke(updatedProfile),
        		() -> "Failure message: Original object attributes values not matches with saved object");
		marks++;
	}
	
	@Test
	@Order(15)
	@DisplayName("updateProfile: When updating a non-existent profile, then ProfileException should be thrown")
	public void testUpdateProfile_WhenProfileNotFound_ThenProfileExceptionThrown() throws Exception {
		// Arrange
		Profile profile = Profile.class
                .getDeclaredConstructor(String.class, String.class, User.class)
                .newInstance("Sarah", "Davis", null);

		// Act and Assert
		assertThrows(ProfileException.class, () -> profileDAO.updateProfile(profile),
				() -> "Failure message: ProfileException to be thrown if trying to update non existing profile");
		marks++;
	}

	@Test
	@Order(16)
	@DisplayName("deleteProfile: When deleting a profile, then the profile should be removed from the database")
	public void testDeleteProfile_WhenDeletingProfile_ThenProfileRemovedFromDatabase() throws Exception {
		// Arrange
		Profile profile = Profile.class
                .getDeclaredConstructor(String.class, String.class, User.class)
                .newInstance("John", "Doe", null);
		
		profileDAO.addProfile(profile);
		
		// Act
		profileDAO.deleteProfile(profile);
		
		// Assert
		assertNull(em.find(Profile.class, Profile.class.getDeclaredMethod("getId").invoke(profile)),
				() -> "Failure message: object is not deleted from database");
		
		marks++;
	}
	
	@Test
	@Order(17)
	@DisplayName("deleteProfile: When deleting a non-existent profile, then ProfileException should be thrown")
	public void testDeleteProfile_WhenProfileNotFound_ThenProfileExceptionThrown() throws Exception {
		// Arrange 
		Profile profile = Profile.class
                .getDeclaredConstructor(String.class, String.class, User.class)
                .newInstance("Emma", "Smith", null);
		
		// Act and Assert
		assertThrows(ProfileException.class,
				() -> profileDAO.deleteProfile(profile),
				() -> "Failure message: Expected ProfileException to be thrown");
		marks++;
	}
	
    @Test
    @Order(18)
    void buildScore(){
        System.out.println("[MARKS] marks is " + marks);
    }
}
