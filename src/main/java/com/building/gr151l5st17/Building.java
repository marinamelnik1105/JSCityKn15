package com.buildings.gr151l5st17;

import com.sun.org.apache.xml.internal.utils.UnImplNode;
import eu.printingin3d.javascad.coords.Angles3d;
import java.util.ArrayList;
import java.util.List;

import eu.printingin3d.javascad.models.Abstract3dModel;
import eu.printingin3d.javascad.models.Sphere;
import eu.printingin3d.javascad.coords.Coords3d;
import eu.printingin3d.javascad.coords.Dims3d;
import eu.printingin3d.javascad.coords.Triangle3d;
import eu.printingin3d.javascad.models.*;
import eu.printingin3d.javascad.tranzitions.Difference;
import eu.printingin3d.javascad.tranzitions.Scale;
import eu.printingin3d.javascad.tranzitions.Union;
import sun.rmi.server.UnicastRef;
class Building extends Union {
    Building() {
        super(getModels());
    }
    static Abstract3dModel Window () {
        return new Union(
            new Cube(new Dims3d(3, 0.5, 4)),
            new Cube(new Dims3d(1.3, 0.8, 1.7)).move(new Coords3d( 0.7, 0, 0.9)),
            new Cube(new Dims3d(1.3, 0.8, 1.7)).move(new Coords3d(-0.7, 0, 0.9)),
            new Cube(new Dims3d(1.3, 0.8, 1.7)).move(new Coords3d( 0.7, 0,-0.9)),
            new Cube(new Dims3d(1.3, 0.8, 1.7)).move(new Coords3d(-0.7, 0,-0.9))
        );
    }
    static Abstract3dModel WindowRot () {
        return Window().rotate(Angles3d.zOnly(90));
    }
    static Abstract3dModel Floor (int a) {
        double step = 3.25;
        Abstract3dModel main = new Cube(new Dims3d(59 - step * a, 14, 5))
            .move(Coords3d.xOnly(-step / 2 * a));
        for(int i = 0; i < 18 - a; i++) {
            main = new Difference(main,
                Window().move(new Coords3d(-27.5 + i * 3.25, 7, 0)),
                Window().move(new Coords3d(-27.5 + i * 3.25,-7, 0))
            );
        }
        for(int i = 0; i < 4; i++) {
            main = new Difference(main,
                WindowRot().move(new Coords3d(-29.5, -5 + i * 3.25, 0)),
                WindowRot().move(new Coords3d( 29.5 - step * a, -5 + i * 3.25, 0))
            );
        }
        return main;
    }
    static Abstract3dModel Build () {
        return new Union(
            Floor(0).move(Coords3d.zOnly(-2.5)),
            Floor(0).move(Coords3d.zOnly( 2.5)),
            Floor(0).move(Coords3d.zOnly( 7.5)),
            Floor(1).move(Coords3d.zOnly(12.5)),
            Floor(2).move(Coords3d.zOnly(17.5)),
            Floor(3).move(Coords3d.zOnly(22.5)),
            Floor(4).move(Coords3d.zOnly(27.5))
        );
    }
    private static List<Abstract3dModel> getModels() {
        List<Abstract3dModel> models = new ArrayList<Abstract3dModel>();
        models.add(Build());
        return models;
    }
}