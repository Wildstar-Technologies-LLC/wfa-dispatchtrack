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

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.spi.ServiceManagerImpl;

public abstract class ServiceManager {
   private static final String _CLASS=ServiceManager.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   private boolean initialized=false;
   
   private String apiKey="";
   private String code="";
   private String server="";
   
   public static final String _CONFIG_KEY_APIKEY="api_key";
   public static final String _CONFIG_KEY_CODE="code";
   public static final String _CONFIG_KEY_SERVER="server";
   
   /* ********** Accessor Methods **********/ 
   
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
   public final void checkProperties() {
      String msg="";
      if (
            (this.apiKey != null) && 
            (!this.apiKey.isEmpty()) &&
            (this.code != null) && 
            (!this.code.isEmpty()) &&
            (this.server != null) && 
            (!this.server.isEmpty())
         ) {
         this.initialized=true;
      } else {
         msg=Localization.getString(
            "ServiceManagerMessages", 
            ServiceManagerMessages.ERR_NOT_INITIALIZED, 
            null, 
            null, 
            new Object[]{});
         logger.severe(msg);
      } // END if ((this.apiKey != null ...
   }
   
   /**
    * Returns a reference to a concrete implementation of the 
    * {@code ServiceManager} class.
    * @return a concrete implementation of the {@code ServiceManager}
    * class.
    */
   public static ServiceManager getInstance() {
      logger.entering(_CLASS, "getInstance()");
      ServiceManager manager=null;
      
      manager=new ServiceManagerImpl();
      logger.exiting(_CLASS, "getInstance()",manager);
      return manager;
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
   public abstract ServiceOrder setServiceOrder(ServiceOrder order);
   public abstract List<ServiceOrder> getServiceOrderForDate(Date date);
}