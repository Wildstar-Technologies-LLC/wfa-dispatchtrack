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
package com.wildstartech.dispatchtrack.spi;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.Localization;
import com.wildstartech.dispatchtrack.ServiceManager;
import com.wildstartech.dispatchtrack.ServiceManagerMessages;
import com.wildstartech.dispatchtrack.ServiceOrder;

public class ServiceManagerImpl extends ServiceManager {
   private static final String _CLASS=ServiceManagerImpl.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   private static final String _CONFIG_FILENAME="ServiceManager.properties";
  
   
   /** 
    * Default, no-argument constructor.
    */
   public ServiceManagerImpl() {
      logger.entering(_CLASS, "ServiceManagerImpl()");
      init();
      logger.exiting(_CLASS, "ServiceManagerImpl()");
   }
   
   /**
    * Read the necessary configuration properties from the 
    * {@code ServiceManager.properties} configuration file.
    */
   private void init() {
      logger.entering(_CLASS, "init()");
      ClassLoader cl=null;
      InputStream in=null;
      Properties props=null;
      String msg=null;
      
      cl=ServiceManagerImpl.class.getClassLoader();
      in=cl.getResourceAsStream(_CONFIG_FILENAME);
      if (in != null) {
         props=new Properties();
         try {
            props.load(in);
            setApiKey(loadProperty(props,ServiceManager._CONFIG_KEY_APIKEY));
            setCode(loadProperty(props,ServiceManager._CONFIG_KEY_CODE));
            setServer(loadProperty(props,ServiceManager._CONFIG_KEY_SERVER));
            checkProperties();
            if (!isInitialized()) {
               msg=Localization.getString(
                  "ServiceManagerMessages", 
                  ServiceManagerMessages.ERR_INIT_FAILED, 
                  null, 
                  null, 
                  new Object[]{});
            }
         } catch (IOException ex) {
            msg=Localization.getString(
                  "ServiceManagerMessages", 
                  ServiceManagerMessages.ERR_READING_CONFIG_FILE, 
                  null, 
                  cl, 
                  new Object[] {_CONFIG_FILENAME});
         } // END try/catch
      } else {
         msg=Localization.getString(
               "ServiceManagerMessages", 
               ServiceManagerMessages.ERR_CONFIG_FILE_NOT_FOUND, 
               null, 
               cl, 
               new Object[] {_CONFIG_FILENAME});
          logger.severe(msg);
      } // END if (in != null)
      
      logger.exiting(_CLASS, "init()");
   }
   
   private String loadProperty(Properties props,String propertyName) {
      logger.entering(_CLASS, "loadProperty(Properties,String)",
            new Object[] {props,propertyName});
      ClassLoader cl=null;
      String msg="";
      String propValue="";
      
      propValue=props.getProperty(propertyName);
      if (propValue == null) {
         msg=Localization.getString(
            "ServiceManagerMessages", 
            ServiceManagerMessages.ERR_CONFIG_PROPERTY_MISSING, 
            null, 
            cl, 
            new Object[] {propertyName});
         logger.severe(msg);
      } // END if (property == null)
      logger.exiting(_CLASS, "loadProperty(Properties,String)",propValue);
      return propValue;      
   }
   @Override
   public List<ServiceOrder> importOrders(List<ServiceOrder> orders) {
      logger.entering(_CLASS, "importOrders(List<ServiceOrder>)",orders);
      List<ServiceOrder> importedOrders=null;
      
      importedOrders=new ArrayList<ServiceOrder>();
      logger.exiting(_CLASS, "importOrders(List<ServiceOrder>)",importedOrders);
      return importedOrders;
   }

   @Override
   public ServiceOrder setServiceOrder(ServiceOrder order) {
      logger.entering(_CLASS, "setServiceOrder(ServiceOrder)",order);
      ServiceOrder resultOrder=null;
      
      logger.exiting(_CLASS, "setServiceOrder(List<ServiceOrder>)",
            resultOrder);
      return resultOrder;
   }

   @Override
   public List<ServiceOrder> getServiceOrderForDate(Date date) {
      logger.entering(_CLASS, "getServiceOrderForDate(Date)",date);
      List<ServiceOrder> serviceOrders=null;
      
      serviceOrders=new ArrayList<ServiceOrder>();
      logger.exiting(_CLASS, "getServiceOrderForDate(Date)",serviceOrders);
      return serviceOrders;
   }

}
