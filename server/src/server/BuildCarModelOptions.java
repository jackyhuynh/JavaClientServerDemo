/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

/**
 *
 * @author TrucHuynh
 */

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Properties;
import Adapter.BuildAutomobile;


public class BuildCarModelOptions implements AutoServer
{
	
    private BuildAutomobile build_car;
    
    //	Default Costructor:
    public BuildCarModelOptions()
    {
        build_car = new BuildAutomobile();
    }

    /**
     * create  and automobile form property object and add to linked hash map
     * @param pros_Object
     */
        @Override
    public void BuildAutoFromProObjAndAddtoLink(Properties pros_Object) 
    {
        	build_car.BuildAutoFromProObjAndAddtoLink(pros_Object);
    }
    

    /**
     * get list of available model
     * Call BuildAutomobile to print out the available Model in the list
     * @return
     */
        @Override
    public ArrayList<String> listOfAvailableModel()
    {	
        	return build_car.listOfAvailableModel();
    }
    
    
    /**
     *  send an instance of selected model to user
     * @param selected
     * @param writer
     */
    @Override
    public void sendSelectedmodelTOUser(String selectModel,ObjectOutputStream writer)
    {
    	build_car.sendSelectedmodelTOUser(selectModel, writer);
    }
}
