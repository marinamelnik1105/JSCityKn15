package com.building.gr151l5st19;

import java.io.File;
import java.io.IOException;

import eu.printingin3d.javascad.exceptions.IllegalValueException;
import eu.printingin3d.javascad.utils.SaveScadFiles;

public class Main {
    /**
     * @param args
     * @throws IOException
     * @throws IllegalValueException
     */
    public static void main(String[] args) throws IllegalValueException, IOException {
        new SaveScadFiles(new File("/home/hylotly/Documents/Project/model")).
                addModel("castle_gr151l5st19.scad", new Building()).
                saveScadFiles();
    }
}
