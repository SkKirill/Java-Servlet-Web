package com.flower.service;

import com.flower.entity.Flower;
import com.flower.exception.DeleteFlowerException;
import com.flower.exception.EmptyInputDataException;
import com.flower.repository.FlowerRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlowerService {

    private static final Logger logger = Logger.getLogger(FlowerService.class.getName());
    public final FlowerRepository flowerRepository;

    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getAllFlower(Long id) {
        return flowerRepository.findAllFlowers(id);
    }

    public boolean isFlowerExists(Long id){
        try {
            return flowerRepository.existsFlowerById(id);
        }catch (NullPointerException e){
            logger.log(Level.SEVERE,"isFlowerExists error: {0}", e.getMessage());
            throw e;
        }
    }

    public Flower getFlowerData(Long id) {
        return flowerRepository.findFlowerById(id);
    }

    public void changeFlowerData(Long profileId, String name, String description){
        flowerRepository.updateFlower(profileId, description, name);
        logger.log(Level.INFO,"changeAnimal success");
    }

    public void deleteFlowerData(Long id){
        flowerRepository.deleteFlower(id);
        logger.log(Level.INFO,"deleteFlower success");
    }

    private void validateAddFlowerData(String id, String name) throws EmptyInputDataException {
        if (id == null || id.trim().isEmpty()) {
            throw new EmptyInputDataException("flower id is empty");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new EmptyInputDataException("flower name is empty");
        }
    }

    public void addNewFlower(Long profileId, String name, String description) throws EmptyInputDataException {
        try {
            validateAddFlowerData(String.valueOf(profileId), name);
            flowerRepository.addFlower(profileId, description, name);
            logger.log(Level.INFO,"flower with " + profileId + name + "added success");
        } catch (EmptyInputDataException e) {
            logger.log(Level.SEVERE,"addNewFlower error: {0}", e.getMessage());
            throw e;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Unexpected error adding new flower", ex);
            throw ex;
        }
    }
}
