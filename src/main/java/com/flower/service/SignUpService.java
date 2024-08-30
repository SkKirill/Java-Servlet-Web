package com.flower.service;

import com.flower.entity.Profile;
import com.flower.exception.EmptyInputDataException;
import com.flower.exception.ProfileIsAlreadyExistsException;
import com.flower.repository.ProfileRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpService {
    private static final Logger logger = Logger.getLogger(SignUpService.class.getName());
    private final ProfileRepository profileRepository;

    public SignUpService() {
        this.profileRepository = new ProfileRepository();
    }

    private void validateProfileData(String login, String password) throws EmptyInputDataException {
        if (login == null || login.trim().isEmpty()) {
            throw new EmptyInputDataException("login is empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new EmptyInputDataException("password is empty");
        }
    }

    public Profile registerProfile(String login, String password) {
        try{
            validateProfileData(login, password);
            if (profileRepository.existProfileByLogin(login)) {
                throw new ProfileIsAlreadyExistsException("A profile with that login already exists");
            }
            profileRepository.addProfile(login, password, "");

            logger.log(Level.INFO, "The user has been successfully registered: {0}", login);
            return new Profile("", login, password);
        }
        catch (EmptyInputDataException e){
            logger.log(Level.SEVERE,"Profile data validation error: {0}", e.getMessage());
        }
        catch (ProfileIsAlreadyExistsException e){
            logger.log(Level.SEVERE,"Registration error: a profile with the same login already exists: {0}", login);
        }
        return null;
    }
}
