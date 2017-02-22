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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MockServiceOrder implements ServiceOrder {
   private float amount=0f;
   private float codAmount=0f;
   private float deliveryCharge=0f;
   private float taxes=0f;
   
   private int serviceTime=0;
   private int stopNumber=0;
   
   private Customer customer=new MockCustomer();
   
   private Date deliveryDate=null;
   private Date deliveryTimeWindowStart=null;
   private Date deliveryTimeWindowStop=null;
   private Date requestDeliveryDate=null;
   private Date requestTimeWindowStart=null;
   private Date requestTimeWindowStop=null;
   
   private List<Driver> drivers=null;
   private List<Item> items=null;
   private List<Note> notes=null;
   private List<String> prerequisiteOrderIds=null;
   
   private PreCall preCall=null;
   private Status status=Status.NEW;
   private String accountId="";
   private String description="";
   private String displayOrderNumber="";
   private String driverId="";
   private String id="";
   private String number="";
   private String origin="";
   private String serviceType="";
   private String serviceUnit="";
   private String stopTime="";
   private String storeCode="";
   private String truckId="";
   
   /**
    * Default, no-argument constructor
    */
   public MockServiceOrder() {
      this.preCall=new MockPreCall();
      this.drivers=new ArrayList<Driver>();
      this.items=new ArrayList<Item>();
      this.notes=new ArrayList<Note>();
      this.prerequisiteOrderIds=new ArrayList<String>();
   }
   /* ********** Utility Methods **********/
   /**
    * Utility to return the localized label for the Status
    * @param status
    * @return
    */
   private String getStatusLabel(Status status) {
      String label="";
      String resourceId="";
      
      switch (this.status) {
         case NEW:
            resourceId=ServiceOrderMessages.STATUS_LABEL_NEW;
            break;
         case SCHEDULED:
            resourceId=ServiceOrderMessages.STATUS_LABEL_SCHEDULED;
            break;
         case STARTED:
            resourceId=ServiceOrderMessages.STATUS_LABEL_STARTED;
            break;
         case UNABLE_TO_FINISH:
            resourceId=ServiceOrderMessages.STATUS_LABEL_UNABLE_TO_FINISH;
            break;
         case UNABLE_TO_START:
            resourceId=ServiceOrderMessages.STATUS_LABEL_UNABLE_TO_START;
            break;
         default:
            resourceId=ServiceOrderMessages.STATUS_LABEL_FINISHED;
      }  // END switch
      label=Localization.getString(
            "ServiceOrderMessages", resourceId, null, null, null);
      return label;
   }
   /* ********** Accessor Methods **********/
   //***** accountId
   @Override
   public String getAccountId() {
      return this.accountId;
   }
   @Override
   public void setAccountId(String accountId) {
      this.accountId=accountId;
   }

   //***** amount
   @Override
   public float getAmount() {
      return this.amount;
   }
   @Override
   public void setAmount(float amount) {
      this.amount=amount;
   }
   
   //***** codAmount
   @Override
   public float getCODAmount() {
      return this.codAmount;
   }
   @Override
   public void setCODAmount(float amount) {
      this.codAmount=amount;
   }

   //***** customer
   @Override
   public Customer getCustomer() {
      return this.customer;
   }

   @Override
   public void setCustomer(Customer customer) {
      this.customer=customer;
   }

   //***** deliveryCharge
   @Override
   public float getDeliveryCharge() {
      return this.deliveryCharge;
   }

   @Override
   public void setDeliveryCharge(float charge) {
      this.deliveryCharge=charge;
   }

   //***** deliveryDate
   @Override
   public Date getDeliveryDate() {
      return this.deliveryDate;
   }
   @Override
   public void setDeliveryDate(Date deliveryDate) {
      this.deliveryDate=deliveryDate;
   }

   //***** deliveryTimeWindowStart
   @Override
   public Date getDeliveryTimeWindowStart() {
      return this.deliveryTimeWindowStart;
   }
   @Override
   public void setDeliveryTimeWindowStart(Date windowStart) {
      this.deliveryTimeWindowStart=windowStart;
   }

   //***** deliveryTimeWindowStop
   @Override
   public Date getDeliveryTimeWindowStop() {
      return this.deliveryTimeWindowStop;
   }
   @Override
   public void setDeliveryTimeWindowStop(Date windowStop) {
      this.deliveryTimeWindowStop=windowStop;
   }

   //***** description
   @Override
   public String getDescription() {
      return this.description;
   }
   @Override
   public void setDescription(String description) {
      this.description=description;
   }

   //***** dispayOrderNumber
   @Override 
   public String getDisplayOrderNumber() {
      return this.displayOrderNumber;
   }
   public void setDisplayOrderNumber(String orderNumber) {
      this.displayOrderNumber=orderNumber;
   }
   //***** driver
   @Override
   public boolean addDriver(Driver driver) {
      boolean result=false;
      if (driver != null) {
         result=this.drivers.add(driver);
      } // END if (driver != null)
      return result;
   }
   @Override
   public List<Driver> getDrivers() {
      return Collections.unmodifiableList(this.drivers);
   }
   @Override
   public boolean removeDriver(Driver driver) {
      boolean result=false;
      if (driver != null) {
         result=this.drivers.remove(driver);
      }
      return result;
   }
   @Override
   public void setDrivers(List<Driver> drivers) {
      this.drivers.clear();
      if ((drivers != null) && (drivers.size() > 0)) {
         this.drivers.addAll(drivers);
      } // END if ((drivers != null) && (drivers.size() > 0))
   }
   
   //***** id
   public String getId() {
      return this.id;      
   }
   public void setId(String id) {
      this.id=id;
   }
   
   //***** items
   public List<Item> getItems() {
      return Collections.unmodifiableList(this.items);
   }
   public void setItems(Item... items) {
      this.items.clear();
      if (items != null) {
         for (Item item: items) {
            this.items.add(item);
         } // END for (Item item: items)
      } // END if (items != null)
   }
   public boolean addItem(Item item) {
      boolean result=false;
      if (item != null) {
         result=this.items.add(item);
      } // END if (item != null)
      return result;
   }
   public boolean removeItem(Item item) {
      boolean result=false;
      if (item != null) {
         result=this.items.remove(item);
      } // END if (item != null)
      return result;
   }
   
   //***** notes
   @Override
   public List<Note> getNotes() {
      return Collections.unmodifiableList(this.notes);
   }
   @Override
   public void setNotes(Note... notes) {
      this.notes.clear();
      if (notes != null) {
         for (Note note: notes) {
            this.notes.add(note);
         } // END for (Note note: notes)
      } // END if (notes != null)
   }
   @Override
   public boolean addNote(Note note) {
      boolean result=false;
      if (note != null) {
         result=this.notes.add(note);
      } // END if (note != null)
      return result;
   }
   @Override
   public boolean removeNote(Note note) {
      boolean result=false;
      if (note != null) {
         result=this.notes.remove(note);
      } // END if (note != null)
      return result;
   }
   @Override
   public int getNoteCount() {
      return this.notes.size();
   }

   //***** number
   @Override
   public String getNumber() {
      return this.number;
   }
   @Override
   public void setNumber(String number) {
      this.number=number;
   }

   //***** origin
   @Override
   public String getOrigin() {
      return this.origin;
   }
   @Override
   public void setOrigin(String origin) {
      this.origin=origin;
   }
   //***** preCall
   @Override
   public PreCall getPreCall() {
      return this.preCall;
   }
   @Override
   public void setPreCall(PreCall preCall) {
      this.preCall=preCall;
   }
   //***** preReqs
   @Override
   public boolean addPreReq(String prerequisiteOrderId) {
      return this.prerequisiteOrderIds.add(prerequisiteOrderId);
   }
   @Override
   public List<String> getPreReqs() {
      return this.prerequisiteOrderIds;
   }
   @Override
   public void setPreReqs(List<String> prerequisiteOrderIds) {
      this.prerequisiteOrderIds=prerequisiteOrderIds;
   }

   //***** requestDeliveryDate
   @Override
   public Date getRequestDeliveryDate() {
      return this.requestDeliveryDate;
   }
   @Override
   public void setRequestDeliveryDate(Date saleDate) {
      this.requestDeliveryDate=saleDate;
   }

   //***** requestTimeWindowStart
   @Override
   public Date getRequestTimeWindowStart() {
      return this.requestTimeWindowStart;
   }
   @Override
   public void setRequestTimeWindowStart(Date windowStart) {
      this.requestTimeWindowStart=windowStart;
   }

   //***** requestTimeWindowStop
   @Override
   public Date getRequestTimeWindowStop() {
      return this.requestTimeWindowStop;
   }
   @Override
   public void setRequestTimeWindowStop(Date windowStop) {      
      this.requestTimeWindowStop=windowStop;
   }
   
   //***** serviceType
   @Override
   public String getServiceType() {
      return this.serviceType;
   }

   @Override
   public void setServiceType(String serviceType) {
      this.serviceType=serviceType;
   }
   
   @Override
   public String getServiceTypeLabel() {     
      return this.serviceType;
   }
   
   //***** serviceTime
   @Override
   public int getServiceTime() {
      return this.serviceTime;
   }
   @Override
   public void setServiceTime(int serviceTime) {
      this.serviceTime=serviceTime;
   }
   
   //***** serviceUnit
   @Override
   public String getServiceUnit() {
      return this.serviceUnit;
   }
   @Override
   public void setServiceUnit(String serviceUnit) {
      this.serviceUnit=serviceUnit;
   }

   //***** status
   @Override
   public Status getStatus() {
      return this.status;      
   }
   @Override
   public String getStatusLabel() {
      return getStatusLabel(this.status);
   }
   
   @Override
   public void setStatus(Status status) {
      this.status=status;      
   }
   @Override
   public void setStatus(String statusLabel) {
      if (statusLabel != null) {
         if (statusLabel.equals(getStatusLabel(Status.SCHEDULED))) {
            this.status=Status.SCHEDULED;
         } else if (statusLabel.equals(getStatusLabel(Status.STARTED))) {
            this.status=Status.STARTED;
         } else if (statusLabel.equals(getStatusLabel(Status.FINISHED))) {
            this.status=Status.FINISHED;
         } else if (statusLabel.equals(
               getStatusLabel(Status.UNABLE_TO_FINISH))) {
            this.status=Status.UNABLE_TO_FINISH;
         } else if (statusLabel.equals(
               getStatusLabel(Status.UNABLE_TO_START))) {
            this.status=Status.UNABLE_TO_START;
         } else {
            this.status=Status.NEW;
         } // END if (statusLabel.equals(getStatusLabel(Status.SCHEDULED))) ...         
      } // END if (statusLabel != null)
   }
   //***** stopNumber
   @Override
   public int getStopNumber() {
      return this.stopNumber;
   }
   @Override
   public void setStopNumber(int stopNumber) {
      this.stopNumber=stopNumber;
   }

   //***** stopTime
   @Override
   public String getStopTime() {
      return this.stopTime;
   }
   @Override
   public void setStopTime(String stopTime) {
      this.stopTime=stopTime;
   }

   //***** storeCode
   @Override
   public String getStoreCode() {
      return this.storeCode;
   }
   @Override
   public void setStoreCode(String storeCode) {
      this.storeCode=storeCode;
   }

   //***** taxes
   @Override
   public float getTaxes() {
      return this.taxes;
   }
   @Override
   public void setTaxes(float taxes) {
      this.taxes=taxes;
   }

   //***** truckId
   @Override
   public String getTruckId() {
      return this.truckId;
   }
   @Override
   public void setTruckId(String truckId) {
      this.truckId=truckId;
   }
}