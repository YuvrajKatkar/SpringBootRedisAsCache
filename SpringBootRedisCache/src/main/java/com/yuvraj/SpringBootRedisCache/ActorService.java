package com.yuvraj.SpringBootRedisCache;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Optional<Actor> getActorById(Long id) {
        return actorRepository.findById(id);
    }

    public Actor addActor(Actor actor) {
        actor.setLastUpdate(LocalDateTime.now());
        return actorRepository.save(actor);
    }

    public Actor updateActor(Long id, Actor actorDetails) {
        Actor actor = actorRepository.findById(id).orElseThrow();
        actor.setFirstName(actorDetails.getFirstName());
        actor.setLastName(actorDetails.getLastName());
        actor.setLastUpdate(LocalDateTime.now());
        return actorRepository.save(actor);
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}