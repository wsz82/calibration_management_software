package spio2023.cms.api.rest;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String type, Long id) {
        super("Could not find " + type + " " + id);
    }

}
