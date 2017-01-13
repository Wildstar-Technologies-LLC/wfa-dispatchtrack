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

public interface ServiceOrder {
   public enum Status {NEW, SCHEDULED, STARTED, UNABLE_TO_START, FINISHED, 
      UNABLE_TO_FINISH};
   public final int SERVICE_TYPE_DELIVERY=0;
   public final int SERVICE_TYPE_PICKUP=1;
   public final int SERVICE_TYPE_SERVICE=2;
   
   //***** accountId
   public String getAccountId();
   public void setAccountId(String accountId);
   
   //***** amount
   public float getAmount();
   public void setAmount(float amount);
   
   //***** codAmount
   public float getCODAmount();
   public void setCODAmount(float amount);
      
   //***** customer
   public Customer getCustomer();
   public void setCustomer(Customer customer);

   //***** deliveryCharge 
   public float getDeliveryCharge();
   public void setDeliveryCharge(float charge);
   
   //***** deliveryDate
   public Date getDeliveryDate();
   public void setDeliveryDate(Date deliveryDate);
   
   //***** deliveryTimeWIndowStart
   public Date getDeliveryTimeWindowStart();
   public void setDeliveryTimeWindowStart(Date windowStart);
   
   //***** deliveryTimeWIndowStop
   public Date getDeliveryTimeWindowStop();
   public void setDeliveryTimeWindowStop(Date windowStop);
   
   //***** description
   public String getDescription();
   public void setDescription(String description);
   
   //***** displayOrderNumber
   public String getDisplayOrderNumber();
   public void setDisplayOrderNumber(String orderNumber);
   
   //***** drivers   
   public boolean addDriver(Driver driver);
   public List<Driver> getDrivers();
   public void setDrivers(List<Driver> drivers);
   
   //***** driverId
   public String getDriverId();
   public void setDriverId(String driverId);
   
   //***** items
   public List<Item> getItems();
   public void setItems(Item... items);
   public boolean addItem(Item item);
   public boolean removeItem(Item item);
   
   //***** notes
   public List<Note> getNotes();
   public void setNotes(Note...notes);
   /**
    * Adds the specified {@code Note} to the list of notes associated
    * with the {@code ServiceOrder}
    * @param note The note to be added to the collection of notes associated 
    * with the {@code ServiceOrder}
    * @return {@code true} if the {@code Note} was added to the list 
    * associated with the {@code ServiceOrder}
    */
   public boolean addNote(Note note);
   /**
    * Remote the first occurrence of the specified {@code note} from service 
    * order.
    * @param {@code note} The {@code note} to be removed from the service 
    * order.
    * @return {@code true} if the specified {@code note} was associated with
    * the service order and has now been removed.
    */
   public boolean removeNote(Note note);
   
   //***** noteCount
   /**
    * Returns the total number of {@code note} objects associated with the 
    * service order
    * @return
    */
   public int getNoteCount();
   
   //***** number
   public String getNumber();
   public void setNumber(String number);
   
   //***** origin
   public String getOrigin();
   public void setOrigin(String origin);
   
   //***** preReqs
   public boolean addPreReq(String prerequisiteOrderId);
   public List<String> getPreReqs();
   public void setPreReqs(List<String> prerequisiteOrderId);
   
   //***** requestDeliveryDate
   public Date getRequestDeliveryDate();
   public void setRequestDeliveryDate(Date saleDate);
   
   //***** requestTimeWindowStart
   public Date getRequestTimeWindowStart();
   public void setRequestTimeWindowStart(Date windowStart);
   
   //***** requestTimeWindowStop
   public Date getRequestTimeWindowStop();
   public void setRequestTimeWindowStop(Date windowStop);
   
   //***** serviceType
   public String getServiceType();
   public void setServiceType(String serviceType);
   
   //***** serviceTime
   public int getServiceTime();
   public void setServiceTime(int serviceTime);
   
   //***** serviceUnit
   /**
    * Returns the name of the resource or route.
    * @return
    */
   public String getServiceUnit();
   public void setServiceUnit(String serviceUnit);

   //***** status
   public Status getStatus();
   public String getStatusLabel();
   public void setStatus(Status status);
   public void setStatus(String statusLabel);
   
   //***** stopNumber
   public int getStopNumber();
   public void setStopNumber(int stopNumber);
   
   //***** stopTime
   public String getStopTime();
   public void setStopTime(String stopTime);
   
   //***** storeCode
   public String getStoreCode();
   public void setStoreCode(String storeCode);
   
   //***** taxes 
   public float getTaxes();
   public void setTaxes(float taxes);
   
   //***** truckId
   public String getTruckId();
   public void setTruckId(String truckId);
}