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
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.spi.xml.ServiceManagerImpl;
/**
 * Primary interface gateway between DispatchTrack and API clients.
 * 
 * @author Derek Berube, Wildstar Technologies, LLC.
 * @version 0.1, 2017.01.17
 */
public abstract class ServiceManager {
   private static final String _CLASS=ServiceManager.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   /* Keys used to store the service end-point URLs in the 
    * urlTemplates Map. */
   public static final String _API_ADD="SET";
   public static final String _API_ADD_KEY="url.add";
   public static final String _API_BULK_IMPORT="BULK_IMPORT";
   public static final String _API_BULK_IMPORT_KEY="url.import";
   public static final String _API_DELETE="DELETE";
   public static final String _API_DELETE_KEY="url.delete";
   public static final String _API_DELIVERY_RECEIPT="DELIVERY_RECEIPT";
   public static final String _API_DELIVERY_RECEIPT_KEY=
      "url.delivery-receipt";
   public static final String _API_EXPORT="EXPORT";
   public static final String _API_EXPORT_KEY="url.export";
   public static final String _API_MANIFEST="MANIFEST";
   public static final String _API_MANIFEST_KEY="url.manifest";
   public static final String _API_ROUTE_STATISTICS="ROUTE_STATISTICS";
   public static final String _API_ROUTE_STATISTICS_KEY="url.service-unit-stats";
      
   public static final String _API_PROPERTIES="api.properties";
   public static final String _CONFIG_KEY_APIKEY="api_key";
   public static final String _CONFIG_KEY_CODE="code";
   public static final String _CONFIG_KEY_SERVER="server";
   public static final String _MANAGER_PROPERTIES="ServiceManager.properties";   
   
   public static enum OperationType {
      BULK_IMPORT,
      DELETE,
      DELIVERY_RECEIPT,
      EXPORT,
      MANIFEST_ACTIVITY,
      ROUTE_STATISTICS,
      SET
   };
   
   /* BEGIN: Internal fields */
   private boolean initialized=true;
   private Map<String,String> urlTemplates=new TreeMap<String,String>();
   private String apiKey="";
   private String code="";
   private String server="";
   
   /* END: Internal fields */
   // ********** Utility Methods **********
   /**
    * Performs necessary initialization operations for the 
    * {@code ServiceManager} such as processing the {@code api.properties}
    * configuration file.
    * 
    * <p>The {@code init()} method <strong>MUST</strong> be invoked 
    * <strong>every</strong> an instance of the {@code ServiceManager} is
    * invoked. The following is a summary of operations performed by this
    * method.</p>
    * <ul>
    * <li>Parse {@code api.properties} to get web address templates for the
    * service endpoints.</li>
    * </ul>
    */
   public void init() {
      logger.entering(_CLASS, "init()");
      String msg="";
      
      // Load and process the ServiceManager.properties configuration file.
      loadProperties();
      // Load and process the api.properties configuration file.
      loadAPIProperties();
      // Let's look to see if we're initialized.
      checkProperties();
      if (!isInitialized()) {
         msg=Localization.getString(
            ServiceManagerMessages._BUNDLE_NAME, 
            ServiceManagerMessages.ERR_INIT_FAILED, 
            null, 
            null, 
            new Object[]{});
         logger.severe(msg);
      } // END if (!isInitialized())
      logger.exiting(_CLASS, "init()");
   }
   
   /**
    * Loads and parses the {@code api.properties} configuration file.
    * @param opType
    * @return
    */
   public Properties loadAPIProperties() {
      logger.entering(_CLASS, "loadAPIProperties()");
      ClassLoader cl=null;
      Properties props=null;
      InputStream in=null;
      String msg=null;
      String property=null;
      
      cl=ServiceManager.class.getClassLoader();
      if (cl != null) {
         in=cl.getResourceAsStream(_API_PROPERTIES);
         if (in != null) {
            props=new Properties();
            try {
               props.load(in);
               if (this.urlTemplates == null) {
                  this.urlTemplates=new TreeMap<String,String>();                 
               } // END if (this.urlTemplates == null)
               // _API_ADD
               property=loadProperty(
                     props, 
                     ServiceManager._API_ADD_KEY, 
                     _API_PROPERTIES);
               this.urlTemplates.put(_API_ADD, property);
               // _API_BULK_IMPORT
               property=loadProperty(
                  props,
                  ServiceManager._API_BULK_IMPORT_KEY,
                  _API_PROPERTIES);
               this.urlTemplates.put(_API_BULK_IMPORT, property);
               // _API_DELETE
               property=loadProperty(
                  props,
                  ServiceManager._API_DELETE_KEY,
                  _API_PROPERTIES);
               this.urlTemplates.put(ServiceManager._API_DELETE, property);
               // _API_DELETE
               property=loadProperty(
                  props,
                  ServiceManager._API_DELIVERY_RECEIPT_KEY,
                  _API_PROPERTIES);
               this.urlTemplates.put(
                  ServiceManager._API_DELIVERY_RECEIPT, property);
               // _API_EXPORT
               property=loadProperty(
                  props,
                  ServiceManager._API_EXPORT_KEY,
                  _API_PROPERTIES);
               this.urlTemplates.put(
                  ServiceManager._API_EXPORT, property);
               // _API_MANIFEST
               property=loadProperty(
                  props,
                  ServiceManager._API_MANIFEST_KEY,
                  _API_PROPERTIES);
               this.urlTemplates.put(
                  ServiceManager._API_MANIFEST, property);
               // _API_ROUTE_STATISTICS
               property=loadProperty(
                  props,
                  ServiceManager._API_ROUTE_STATISTICS_KEY,
                  _API_PROPERTIES);
               this.urlTemplates.put(
                  ServiceManager._API_ROUTE_STATISTICS, property);               
            } catch (IOException ex) {
               msg=Localization.getString(
                  "ServiceManagerMessages", 
                  ServiceManagerMessages.ERR_FILE_IOEXCEPTION, 
                  null, 
                  cl, 
                  new Object[] {_API_PROPERTIES});
               logger.severe(msg);
            } // END try/catch
         } else {
            msg=Localization.getString(
                  ServiceManagerMessages._BUNDLE_NAME, 
                  ServiceManagerMessages.ERR_FILE_IOEXCEPTION, 
               null, 
               cl, 
               new Object[] {_API_PROPERTIES});
            logger.severe(msg);
         } // END if (in != null)
      } else {
         msg=Localization.getString(
            ServiceManagerMessages._BUNDLE_NAME, 
            ServiceManagerMessages.ERR_CONFIG_FILE_NOT_FOUND, 
            null, 
            cl, 
            new Object[] {_API_PROPERTIES});
         logger.severe(msg);         
      } // if (cl != null)
      
      logger.exiting(_CLASS, "loadAPIProperties()",props);
      return props;
   }
   /**
    * Loads the property with the specified {@code propertyName} from
    * the {@code Properties} object passed as a parameter.
    * 
    * @param props The {@code Properties} container from whence the specified
    * {@code propertyName} should be read.
    * @param propertyName The name of the property that should be read from the
    * specified {@code Properties} object.
    * @return the value of the requested property in the form of a 
    * {@code String}
    */
   public  String loadProperty(Properties props,String propertyName, String fielName) {
      logger.entering(_CLASS, "loadProperty(Properties,String)",
            new Object[] {props,propertyName});
      ClassLoader cl=null;
      String msg="";
      String propValue="";
      
      propValue=props.getProperty(propertyName);
      if (propValue == null) {
         msg=Localization.getString(
            ServiceManagerMessages._BUNDLE_NAME, 
            ServiceManagerMessages.ERR_CONFIG_PROPERTY_MISSING, 
            null, 
            cl, 
            new Object[] {fielName,propertyName});
         logger.severe(msg);
      } // END if (property == null)
      logger.exiting(_CLASS, "loadProperty(Properties,String)",propValue);
      return propValue;      
   }
   
   /**
    * Loads and processes the {@code ServerManager.properties} configuration
    * file.
    */
   public Properties loadProperties() {
      logger.entering(_CLASS,"loadProperties()");
      logger.entering(_CLASS, "init()");
      ClassLoader cl=null;
      InputStream in=null;
      Properties props=null;
      String msg=null;
      
      cl=ServiceManagerImpl.class.getClassLoader();
      in=cl.getResourceAsStream(_MANAGER_PROPERTIES);
      if (in != null) {
         props=new Properties();
         try {
            props.load(in);
            setApiKey(loadProperty(
               props,
               ServiceManager._CONFIG_KEY_APIKEY,
               _MANAGER_PROPERTIES));
            setCode(loadProperty(
               props,
               ServiceManager._CONFIG_KEY_CODE,
               _MANAGER_PROPERTIES));
            setServer(loadProperty(
               props,
               ServiceManager._CONFIG_KEY_SERVER,
               _MANAGER_PROPERTIES));
         } catch (IOException ex) {
            msg=Localization.getString(
                  ServiceManagerMessages._BUNDLE_NAME, 
                  ServiceManagerMessages.ERR_READING_CONFIG_FILE, 
                  null, 
                  cl, 
                  new Object[] {_MANAGER_PROPERTIES});
         } // END try/catch
      } else {
         msg=Localization.getString(
               ServiceManagerMessages._BUNDLE_NAME, 
               ServiceManagerMessages.ERR_CONFIG_FILE_NOT_FOUND, 
               null, 
               cl, 
               new Object[] {_MANAGER_PROPERTIES});
          logger.severe(msg);
      } // END if (in != null)
      logger.exiting(_CLASS,"loadProperties()",props);
      return props;
   }
   
   // ********** Accessor Methods ********** 
  
   //***** apiKey
   public final String getApiKey() {
      logger.entering(_CLASS,"getApiKey()");
      logger.exiting(_CLASS, "getApiKey()",this.apiKey);
      return this.apiKey;
   }
   public final void setApiKey(String apiKey) {
      logger.entering(_CLASS,"setApiKey(String)",apiKey);
      if (apiKey != null) {
         this.apiKey=apiKey;
      } else {
         this.apiKey="";
      } // END if (apiKey != null)
      logger.exiting(_CLASS, "setApiKey(String)");
   }
   
   //***** code
   public final String getCode() {
      logger.entering(_CLASS,"getCode()");
      logger.exiting(_CLASS, "getCode()",this.code);
      return this.code;
   }
   public final void setCode(String code) {
      logger.entering(_CLASS,"setCode(String)",code);
      if (code != null) {
         this.code=code;
      } else {
         this.code="";
      } // END if (code != null)
      logger.exiting(_CLASS, "setCode(String)");
   }
   
   //***** initialized
   public final boolean isInitialized() {
      logger.entering(_CLASS, "isInitialized()");
      logger.exiting(_CLASS, "isInitialized()",this.initialized);
      return this.initialized;
   }
   public final void setInitialized(boolean initialized) {
      logger.entering(_CLASS, "setInitialized(boolean)",initialized);
      this.initialized=initialized;
      logger.exiting(_CLASS, "setInitialized(boolean)");
   }
   
   //***** server
   public final String getServer() {
      logger.entering(_CLASS,"getServer()");
      logger.exiting(_CLASS, "getServer()",this.server);
      return this.server;
   }
   public final void setServer(String server) {
      logger.entering(_CLASS,"setServer(String)",server);
      if (server != null) {
         this.server=server;
      } else {
         this.server="";
      } // END if (server != null)
      logger.exiting(_CLASS, "setServer(String)");
   }
   
   //***** Utility Methods
   /**
    * Confirms the {@code api.properties} and the 
    * {@code ServiceManager.properties} configuration files were properly
    * processed.
    */
   public final void checkProperties() {
      String msg="";
      /* ***** Confirm ServiceManager.properties */
      if (
            (this.apiKey == null) || 
            (this.apiKey.isEmpty()) ||
            (this.code == null) || 
            (this.code.isEmpty()) ||
            (this.server == null) ||
            (this.server.isEmpty())
         ) {
         this.initialized = false;
         msg=Localization.getString(
            ServiceManagerMessages._BUNDLE_NAME, 
            ServiceManagerMessages.ERR_NOT_INITIALIZED, 
            null, 
            null, 
            new Object[]{});
         logger.severe(msg);         
      } // END if ((this.apiKey == null ...
      /* ***** Confirm api.properties */
      if (this.urlTemplates == null) {
         this.initialized = false;         
      } else {
         if (!checkString(urlTemplates.get(_API_ADD))) {
            this.initialized = false;
         } else if (!checkString(urlTemplates.get(_API_BULK_IMPORT))) {
            this.initialized = false;
         } else if (!checkString(urlTemplates.get(_API_DELETE))) {
            this.initialized = false;
         } else if (!checkString(urlTemplates.get(_API_DELIVERY_RECEIPT))) {
            this.initialized = false;
         } else if (!checkString(urlTemplates.get(_API_EXPORT))) {
            this.initialized = false;
         } else if (!checkString(urlTemplates.get(_API_MANIFEST))) {
            this.initialized = false;
         } else if (!checkString(urlTemplates.get(_API_ROUTE_STATISTICS))) {
            this.initialized = false;
         } // END if (!checkString(urlTemplates.get(_API_ADD_KEY)))         
      } // END if (this.urlTemplates == null)
   }
   /**
    * Returns {@code false} if the specified {@code String} is either null
    * or empty. 
    * @param value the {@code String} value to test.
    * @return {@code false} if the string is either {@code null} or empty. 
    */
   public boolean checkString(String value) {
      logger.entering(_CLASS, "checkString(String)",value);
      boolean result=false;
      if ((value != null) && (!value.isEmpty())) {
         result=true;
      } // END if ((value != null) && (!value.isEmpty())) 
      logger.exiting(_CLASS, "checkString(String)",result);
      return result;
   }
   
   /**
    * Return the web address for the requested operation. 
    * @param type the {@code OperationType} for which the caller is requesting
    * a web address against which calls can be made
    * @return the web address to which calls to invoke the specified operation
    * should be directed
    */
   public String getServiceEndpoint(OperationType type) {
      logger.entering(_CLASS,"getServiceEndpoint(OperationType)",type);
      String msg=null;
      String server=null;
      String serviceEndpoint="";
      String template="";
      
      switch(type) {
         case BULK_IMPORT:
            template=this.urlTemplates.get(
               ServiceManager._API_BULK_IMPORT);
            break;
         case DELETE:
            template=this.urlTemplates.get(
               ServiceManager._API_DELETE);
            break;
         case DELIVERY_RECEIPT:
            template=this.urlTemplates.get(
               ServiceManager._API_DELIVERY_RECEIPT);
            break;
         case EXPORT:
            template=this.urlTemplates.get(
               ServiceManager._API_EXPORT);
            break;
         case MANIFEST_ACTIVITY:
            template=this.urlTemplates.get(
               ServiceManager._API_MANIFEST);
            break;
         case ROUTE_STATISTICS:
            template=this.urlTemplates.get(
               ServiceManager._API_ROUTE_STATISTICS);
            break;
         case SET:
            template=this.urlTemplates.get(
               ServiceManager._API_ADD);               
            break;
      } // END switch(type)
      server=getServer();
      if ((server != null) && (!server.isEmpty())) {
         serviceEndpoint=MessageFormat.format(template, server);
      } else {
         msg=Localization.getString(
            ServiceManagerMessages._BUNDLE_NAME, 
            ServiceManagerMessages.ERR_PROPERTY_NOT_FOUND, 
            null, 
            null, 
            new Object[] {_CONFIG_KEY_SERVER,_MANAGER_PROPERTIES});
         logger.severe(msg);
      } // END if ((server != null) && (!server.isEmpty()))
      
      logger.exiting(_CLASS,"getServiceEndpoint(OperationType)",serviceEndpoint);
      return serviceEndpoint;
   }
   
   /**
    * Pushes the specified collection of service orders to Dispatch Track servers.
    * <table>
    * <tr>
    * <td><strong>NOTE:</strong></td>
    * <td>The list of orders imported by DispatchTrack will overwrite 
    * @param orders The collection of {@code ServiceOrder} objects that are to be
    * pushed
    * @return
    */
   public abstract List<ServiceOrder> importOrders(List<ServiceOrder> orders);
   
   public abstract ServiceOrder removeServiceOrder(String orderNumber);
   /**
    * Removes a list of {@code ServiceOrder} objects where the value for the
    * {@code scheduledDate} matches the value passed as a parameter.
    * @param date
    * @return The {@code List} of {@code ServiceOrder} objects removed from
    * dispatch track.
    */
   public abstract List<ServiceOrder> removeServiceOrdersByDate(Date date);
   
   /**
    * Imports a single order into the DispatchTrack platform.
    * 
    * @param order The {@code ServiceOrder} that is to be pushed over to the
    * DispatchTrack platform.
    * 
    * @param activityDate
    * 
    * @return A version of the {@code ServiceOrder} after it has been written
    * out to the DispatchTrack platform.
    * 
    * @return
    */
   public abstract ServiceOrder setServiceOrder(ServiceOrder order, Date activityDate);
   /**
    * Retrieves a list of service orders for the specified {@code activityDate}.
    * 
    * @param {@code activityDate} The date on which orders are supposed to be 
    * either delivered or picked up.  This is a required parameter.
    * @param {@code serviceUnit} Filter the list of service orders based upon
    * the resource that will be performing the service.  This is an optional 
    * parameter.
    * @param {@code serviceType} Filter the list of service orders returned 
    * based upon the type of service ({@code Delivery}, {@code Service}
    * or {@code Pickup}) being 
    * performed. This is an optional parameter.
    * @param {@code account} Filter the list of service orders returned based
    * upon the account number associated with the ticket.  This is an optional 
    * parameter.
    * @param {@code status} Filter the list of service orders returned based 
    * upon the current status of the order in the system.  This is an optional
    * parameter.
    * 
    * @return The list of {@code ServiceOrder} objects that match the specified
    * criteria.
    */
   public abstract List<ServiceOrder> getServiceOrders(
         Date activityDate, 
         String serviceUnit, 
         ServiceOrder.ServiceType serviceType,
         String account,
         ServiceOrder.Status status);
   
   public abstract List<ServiceOrder> getServiceOrdersForDate(Date activityDate);
   public abstract void getDeliveryReceipt(String orderNumber);
   /**
    * Returns the a list of status objects for {@code ServiceOrders} in the 
    * system based upon the criteria passed as parameters.
    * 
    *  
    * @param startDate The minimum activity date for {@code ServiceOrders}
    * that should be returned by this API call.
    * @param stopDate If specified, the query should perform a search for 
    * orders with an activity date that falls within the dates specified by
    * the {@code startDate} and {@code stopDate} parameters.
    * @param serviceUnit Filter the list of service orders based upon the 
    * resource that will be performing the service.  This is an optional 
    * parameter.
    * @param orderNumber Identify a specific service order
    */
   public abstract void getStatus(
         Date startDate, 
         Date stopDate, 
         String serviceUnit, 
         String orderNumber);
   
   /**
    * 
    * @param activityDate The date of a delivery, service or pickup activity
    * represented by {@code ServiceOrders} in the platform.
    * @param serviceUnit Filter the list of service orders based upon the 
    * resource that will be performing the service.  This is an optional 
    * parameter.
    */
   public abstract List<ServiceRoute> getRouteStatistics(Date activityDate, String serviceUnit);
   /**
    * 
    * @param activityDate The date of a delivery, service or pickup activity
    * represented by {@code ServiceOrders} in the platform.
    * @param accountName Filter the list of {@code Manifest} objects returned
    * by the value in the {@code accountName} property of the 
    * {@code ServiceOrder}.
    *
    */
   public abstract List<ManifestEntry> getManifestActivity(
         Date activityDate, 
         String accountName);
}