package com.flower.service;

import com.flower.entity.Profile;
import com.flower.exception.EmptyInputDataException;
import com.flower.exception.InvalidLoginDataException;
import com.flower.repository.ProfileRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogInService {
    private static final Logger logger = Logger.getLogger(LogInService.class.getName());
    private final ProfileRepository _profileRepository;

    public LogInService(ProfileRepository profileRepository) {
        _profileRepository = profileRepository;
    }

    public Profile LoginUser(String login, String password) throws EmptyInputDataException, InvalidLoginDataException {
        try{
            validateLoginAndPassword(login, password);
            Profile profile = _profileRepository.findByLoginAndPassword(login, password);
            if (profile == null) {
                throw new InvalidLoginDataException("Invalid username or password");
            }
            logger.log(Level.INFO, "Logged in profile: {0}", profile);
            return profile;
        } catch (EmptyInputDataException e) {
            logger.log(Level.SEVERE, "Profile data validation error: {0}", e.getMessage());
            throw e;
        } catch (InvalidLoginDataException e) {
            logger.log(Level.WARNING, "Login attempt with invalid data: {0}", login);
            throw e;
        }
    }
    private void validateLoginAndPassword(String login, String password) throws EmptyInputDataException{
        if (login == null || login.trim().isEmpty()) {
            throw new EmptyInputDataException("profile login is empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new EmptyInputDataException("profile password is empty");
        }
    }
}
