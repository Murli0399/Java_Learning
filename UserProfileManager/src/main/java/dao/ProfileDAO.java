package dao;

import entities.Profile;
import exceptions.ProfileException;

public interface ProfileDAO {

	void addProfile(Profile profile) throws ProfileException;
    
	Profile getProfileById(int id) throws ProfileException;
    
	void updateProfile(Profile profile) throws ProfileException;
    
	void deleteProfile(Profile profile) throws ProfileException;
}
