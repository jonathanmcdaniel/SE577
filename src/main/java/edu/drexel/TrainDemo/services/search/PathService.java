package edu.drexel.TrainDemo.services.search;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.models.search.Path;

@Service
public interface PathService {
    List<Path> getPaths(String from, String to);
}