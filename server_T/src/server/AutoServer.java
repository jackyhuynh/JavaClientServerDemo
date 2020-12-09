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
public interface AutoServer 
{
        public void BuildAutoFromProObjAndAddtoLink(Properties props);
        public ArrayList<String> listOfAvailableModel();
        public void sendSelectedmodelTOUser(String select,ObjectOutputStream writer);
}
