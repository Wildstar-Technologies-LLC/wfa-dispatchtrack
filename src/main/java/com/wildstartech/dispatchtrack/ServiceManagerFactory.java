/* 
 *  Wildstar Foundation Architecture DispatchTrack API for Java
 *
 *  Copyright (C) 2017 Wildstar Technologies, LLC.
 *
 *  This program is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the Free
 *  Software Foundation; either version 2 of the License, or (at your option)
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *  FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 *  more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc., 59
 *  Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *  
 *  Linking this library statically or dynamically with other modules is making
 *  a combined work based on this library.  Thus, the terms and conditions of
 *  the GNU General Public License cover the whole combination.
 *
 *  As a special exception, the copyright holders of this library give you
 *  permission to link this library with independent modules to produce an
 *  executable, regardless of the license terms of these independent modules,
 *  and to copy and distribute the resulting executable under terms of your
 *  choice, provided that you also meet, for each linked independent module,
 *  the terms and conditions of the license of that module.  An independent
 *  module is a module which is not derived from or based on this library.  If
 *  you modify this library, you may extend this exception to your version of
 *  the library, but you are not obligated to do so.  If you do not wish to do
 *  so, delete this exception statement from your version.
 *  If you need additional information or have any questions, please contact:
 *
 *      Wildstar Technologies, LLC.
 *      63 The Greenway Loop
 *      Inlet Beach, FL 32461
 *      USA
 *
 *      derek.berube@wildstartech.com
 *      www.wildstartech.com
 */
package com.wildstartech.dispatchtrack;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Factory class used to return an implementation of the {@code ServiceManager} 
 * abstract class.
 * 
 * @author Derek Berube, Wildstar Technologies, LLC.
 * @version 0.1, 2017-01-27
 *
 */
public class ServiceManagerFactory {
   private static final String _CLASS=ServiceManagerFactory.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);

   private static final String _CONFIGURATION_FILE_NAME=
      "ServiceManagerFactory.properties";
   private static final String _MANAGER_CLASS_PROPERTY=
      "com.wildstartech.dispatchtrack.ServiceManager";
   /**
    * Default, no-argument constructor.
    */
   public ServiceManagerFactory() {
      logger.entering(_CLASS, "ServiceManagerFactory()");
      logger.entering(_CLASS, "ServiceManagerFactory()");
   }
   
   public ServiceManager getServiceManager() {
      logger.entering(_CLASS, "getServiceManager()");
      Class<?> managerClass=null;
      ClassLoader cl=null;
      InputStream in=null;
      Properties props=null;
      ServiceManager serviceManager=null;
      String managerClassName="";
      String msg="";
      
      cl=ServiceManagerFactory.class.getClassLoader();
      in=cl.getResourceAsStream(_CONFIGURATION_FILE_NAME);
      if (in != null) {
         props=new Properties();
         try {
            props.load(in);
            managerClassName=props.getProperty(_MANAGER_CLASS_PROPERTY);
            if (
                  (managerClassName != null) &&
                  (!managerClassName.isEmpty())
               ) {
               try {
                  managerClass=cl.loadClass(managerClassName);
                  serviceManager=(ServiceManager) managerClass.newInstance();
               } catch (ClassNotFoundException ex) {
                  msg=Localization.getString(
                     "ServiceManagerMessages", 
                     ServiceManagerMessages.ERR_MANAGER_LOAD, 
                     null, 
                     cl, 
                     new Object[] {"ClassNotFound",
                        managerClassName});
                  logger.severe(msg);
               } catch (InstantiationException ex) {
                  msg=Localization.getString(
                     "ServiceManagerMessages", 
                     ServiceManagerMessages.ERR_MANAGER_LOAD, 
                     null, 
                     cl, 
                     new Object[] {"InstantiationException",
                        managerClassName});
                  logger.severe(msg);
               } catch (IllegalAccessException ex) {
                  msg=Localization.getString(
                     "ServiceManagerMessages", 
                     ServiceManagerMessages.ERR_MANAGER_LOAD, 
                     null, 
                     cl, 
                     new Object[] {"IllegalAccessException",
                        managerClassName});
                  logger.severe(msg);
               } // END try/catch               
            } else {
               msg=Localization.getString(
                  "ServiceManagerMessages", 
                  ServiceManagerMessages.ERR_PROPERTY_NOT_FOUND, 
                  null, 
                  cl, 
                  new Object[] {_MANAGER_CLASS_PROPERTY,
                     _CONFIGURATION_FILE_NAME});
               logger.severe(msg);
            } // END if ((managerClassName != null) && ...
            
         } catch (IOException ex) {
            msg=Localization.getString(
               "ServiceManagerMessages", 
               ServiceManagerMessages.ERR_READING_CONFIG_FILE, 
               null, 
               cl, 
               new Object[] {_CONFIGURATION_FILE_NAME});
            logger.severe(msg);
         } // END Try/catch
      } else {
         msg=Localization.getString(
            "ServiceManagerMessages", 
            ServiceManagerMessages.ERR_CONFIG_FILE_NOT_FOUND, 
            null, 
            cl, 
            new Object[] {_CONFIGURATION_FILE_NAME});
         logger.severe(msg);         
      } // END if (in != null)            
      
      logger.exiting(_CLASS, "getServiceManager()",serviceManager);
      return serviceManager;
   }
}