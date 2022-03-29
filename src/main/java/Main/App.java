package Main;

import GUI.Controller;
import GUI.View;
import Model.Model;

public class App 
{
    public static void main( String[] args ){
       Controller controller = new Controller(new View(), new Model());
    }
}
