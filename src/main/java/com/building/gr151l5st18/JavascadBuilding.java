package javascadbuilding;

import java.io.File;
import java.io.IOException;

import eu.printingin3d.javascad.exceptions.IllegalValueException;
import eu.printingin3d.javascad.models.IModel;
import eu.printingin3d.javascad.utils.SaveScadFiles;

/**
 *
 * @author Ilia Misjura
 * KN01-15-1
 * NMetAU
 */
//Main Class
public class JavascadBuilding
{
    public static void main(String[] args) throws IllegalValueException, IOException
    {
        new SaveScadFiles(new File("C:/temp")).addModel("building.scad", new Building()).saveScadFiles();
    }   
}
