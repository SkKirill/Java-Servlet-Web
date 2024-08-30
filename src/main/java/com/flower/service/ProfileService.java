package com.flower.service;

import com.flower.repository.ProfileRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileService {
    private final ProfileRepository profileRepository;
    private static final Logger logger = Logger.getLogger(ProfileService.class.getName());

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public boolean isProfileExists(Long id) {
        if (!profileRepository.existProfileByID(id)){
            logger.log(Level.SEVERE, "isProfileExists error: {0}", id);
            return false;
        }
        else {
            logger.log(Level.INFO, "isProfileExists");
            return true;
        }
    }
}
