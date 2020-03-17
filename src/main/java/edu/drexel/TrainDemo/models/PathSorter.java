package edu.drexel.TrainDemo.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSorter{
    List<Path> paths = new ArrayList<Path>();

    public PathSorter(List<Path> paths){
        this.paths = paths;
    }

    public List<Path> sortPaths(){
        Collections.sort(paths);
        return paths;
    }
}