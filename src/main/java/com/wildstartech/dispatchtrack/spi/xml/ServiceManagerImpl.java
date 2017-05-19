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
package com.wildstartech.dispatchtrack.spi.xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.ManifestEntry;
import com.wildstartech.dispatchtrack.ServiceManager;
import com.wildstartech.dispatchtrack.ServiceOrder;
import com.wildstartech.dispatchtrack.ServiceOrder.ServiceType;
import com.wildstartech.dispatchtrack.ServiceOrder.Status;
import com.wildstartech.dispatchtrack.ServiceRoute;

/**
 * Concrete implementation of the {@code ServiceManager} interface
 * @author Derek Berube, Wildstar Technologies, LLC.
 * @version 0.1
 *
 */
public class ServiceManagerImpl extends ServiceManager {
   private static final String _CLASS=ServiceManagerImpl.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
  
   
   /** 
    * Default, no-argument constructor.
    */
   public ServiceManagerImpl() {
      logger.entering(_CLASS, "ServiceManagerImpl()");
      init();
      logger.exiting(_CLASS, "ServiceManagerImpl()");
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
   public ServiceOrder setServiceOrder(ServiceOrder order, Date activityDate) {
      logger.entering(_CLASS, "setServiceOrder(ServiceOrder)",order);
      ServiceOrder resultOrder=null;
      
      logger.exiting(_CLASS, "setServiceOrder(List<ServiceOrder>)",
            resultOrder);
      return resultOrder;
   }

   @Override
   public List<ServiceOrder> getServiceOrdersForDate(Date date) {
      logger.entering(_CLASS, "getServiceOrderForDate(Date)",date);
      List<ServiceOrder> serviceOrders=null;
      
      serviceOrders=new ArrayList<ServiceOrder>();
      logger.exiting(_CLASS, "getServiceOrderForDate(Date)",serviceOrders);
      return serviceOrders;
   }


   @Override
   public ServiceOrder removeServiceOrder(String orderNumber) {
      // TODO Auto-generated method stub
      return null;
   }


   @Override
   public List<ServiceOrder> removeServiceOrdersByDate(Date date) {
      // TODO Auto-generated method stub
      return null;
   }


   @Override
   public List<ServiceOrder> getServiceOrders(Date activityDate, String serviceUnit, ServiceType serviceType,
         String account, Status status) {
      // TODO Auto-generated method stub
      return null;
   }


   @Override
   public void getDeliveryReceipt(String orderNumber) {
      // TODO Auto-generated method stub
      
   }


   @Override
   public void getStatus(Date startDate, Date stopDate, String serviceUnit, String orderNumber) {
      
   }


   @Override
   public List<ServiceRoute> getRouteStatistics(Date activityDate, String serviceUnit) {
      // TODO Auto-generated method stub
      return null;
   }


   @Override
   public List<ManifestEntry> getManifestActivity(Date activityDate, String accountName) {
      // TODO Auto-generated method stub
      return null;
   }   
}