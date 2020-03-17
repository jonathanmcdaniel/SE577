package edu.drexel.TrainDemo.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.drexel.TrainDemo.models.Path;

@Service
public interface PathService {
    List<Path> getPaths(String from, String to);
}