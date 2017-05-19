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
import java.util.Map;

public class MockServiceOrder implements ServiceOrder {
   private float amount=0f;
   private float cod=0f;
   private float codAmount=0f;
   private float deliveryCharge=0f;
   private float paymentCollected=0f;
   private float taxes=0f;
   
   private int pieces=0;
   private int serviceTime=0;
   private int stopNumber=0;
   
   private Customer customer=new MockCustomer();
   
   private Date deliveryDate=null;
   private Date finishedAt=null;
   private Date requestDeliveryDate=null;
   private Date requestWindowStartTime=null;
   private Date requestWindowEndTime=null;
   private Date scheduledAt=null;
   private Date startedAt=null;
   private Date timeWindowEnd=null;
   private Date timeWindowStart=null;
   
   private List<Driver> drivers=null;
   private List<HistoryEvent> historyEvents=null;
   private List<Image> images=null;
   private List<Item> items=null;
   private List<Note> notes=null;
   private List<ShipmentEvent> events=null;
   private List<String> prerequisiteOrderIds=null;
   
   private Map<String,String> additionalFields=null;
   private Map<String,String> extra=null;
   
   private PreCall preCall=null;
   
   private ServiceUnit serviceUnit=null;
   
   private Signature signature=null;
   
   private Status status=Status.NEW;
   private String account="";
   private String description="";
   private String displayOrderNumber="";
   private String id="";
   private String number="";
   private String origin="";
   private String paymentNotes="";
   private String serviceType="";
   private String stopTime="";
   private String storeCode="";
   
   private Survey survey=null;
   
   private Truck truck=null;
   
   /**
    * Default, no-argument constructor
    */
   public MockServiceOrder() {
      this.customer=new MockCustomer();
      this.drivers=new ArrayList<Driver>();
      this.events=new ArrayList<ShipmentEvent>();
      this.historyEvents=new ArrayList<HistoryEvent>();
      this.images=new ArrayList<Image>();
      this.items=new ArrayList<Item>();
      this.notes=new ArrayList<Note>();
      this.preCall=new MockPreCall();
      this.prerequisiteOrderIds=new ArrayList<String>(); 
      this.serviceUnit=new MockServiceUnit();
      this.signature=new MockSignature();
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
   public String getAccount() {
      return this.account;
   }
   @Override
   public void setAccount(String accountId) {
      this.account=accountId;
   }

   //***** additionalFields
   @Override
   public Map<String,String> getAdditionalFields() {
      return this.additionalFields;
   }
   @Override
   public void setAdditionalFields(Map<String,String> additionalFields) {
      this.additionalFields=additionalFields;
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
   
 //***** cod
   @Override
   public float getCOD() {
      return this.cod;
   }
   @Override
   public void setCOD(float cod) {
      this.cod=cod;
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

   //***** deliveredItemQuantity
   @Override
   public int getDeliveredItemQuantity() {
      int count=0;
      for (Item item: this.items) {
         count+=item.getDeliveredQuantity();
      } // END for (Item item: this.items)
      return count;
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
      return this.drivers.add(driver);
   }
   @Override
   public Driver getDriver(int index) {
      return this.drivers.get(index);
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
   public Driver removeDriver(int index) {
      return this.drivers.remove(index);
   }
   @Override
   public Driver setDriver(int index, Driver driver) {
      return this.drivers.remove(index);
   }
   @Override
   public void setDrivers(Driver...drivers) {
      if (drivers != null) {
         for (Driver driver: drivers) {
            this.drivers.add(driver);
         } // END for (Driver driver: drivers) 
      } // END if (drivers != null)
   }
   @Override
   public void setDrivers(List<Driver> drivers) {
      this.drivers.clear();
      if ((drivers != null) && (drivers.size() > 0)) {
         this.drivers.addAll(drivers);
      } // END if ((drivers != null) && (drivers.size() > 0))
   }
   
   //***** extra
   @Override
   public Map<String,String> getExtra() {
      return this.extra;
   }
   @Override
   public void setExtra(Map<String,String> extra) {
      this.extra=extra;
   }
   
   //***** finishedAt
   public Date getFinishedAt() {
      return this.finishedAt;
   }
   public void setFinishedAt(Date finishedAt) {
      this.finishedAt=finishedAt;
   }
   
   //***** id
   public String getId() {
      return this.id;      
   }
   public void setId(String id) {
      this.id=id;
   }
   
   //***** itemCount
   @Override
   public int getItemCount() {
      return this.items.size();
   }
   
   //***** images
   @Override
   public boolean addImage(Image image) {
      boolean result=false;
      if (image != null) {
         result=this.images.add(image);
      } // END if (image != null)
      return result;
   }
   @Override
   public Image getImage(int index) {
      Image image=null;
      image=this.images.get(index);
      return image;
   }
   
   @Override
   public List<Image> getImages() {
      List<Image> newList=null;
      newList=Collections.unmodifiableList(this.images);
      return newList;
   }
   @Override
   public Image removeImage(int index) {
      Image image=null;
      image=this.images.remove(index);
      return image;
   }
   @Override
   public boolean removeImage(Image image) {
      boolean result=false;
      if (image != null) {
         result=this.images.remove(image);
      } // END if (image != null)
      return result;
   }
   @Override 
   public Image setImage(int index, Image image) {
      Image result=null;
      result=this.images.set(index, image);
      return result;
   }
   @Override
   public void setImages(Image... images) {
      this.images.clear();
      if (images != null) {
         for (Image image: images) {
            this.images.add(image);
         } // END for (Image image: images)
      } // END if (images != null)
   }
   @Override
   public void setImages(List<Image> images) {
      this.images.clear();
      this.images.addAll(images);
   }
   
   //***** items
   public boolean addItem(Item item) {
      boolean result=false;
      if (item != null) {
         result=this.items.add(item);
      } // END if (item != null)
      return result;
   }
   @Override
   public Item getItem(int index) {
      return this.items.get(index);
   }
   public List<Item> getItems() {
      return this.items;
   }
   @Override
   public Item removeItem(int index) {
      
      return this.items.remove(index);
   }
   @Override
   public boolean removeItem(Item item) {
      return this.items.remove(item);
   }
   @Override 
   public Item setItem(int index, Item item) {
      return this.items.set(index, item);
   }
   public void setItems(Item... items) {
      this.items.clear();
      if (items != null) {
         for (Item item: items) {
            this.items.add(item);
         } // END for (Item item: items)
      } // END if (items != null)
   }
   @Override
   public void setItems(List<Item> items) {
      this.items.clear();
      this.items.addAll(items);      
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
   
 //***** orderHistory 
   @Override
   public boolean addHistoryEvent(HistoryEvent event) {
      return this.historyEvents.add(event);
   }
   
   @Override
   public void clearHistoryEvents() {
      this.historyEvents.clear();
   }
  
   @Override
   public HistoryEvent getHistoryEvent(int index) {
      return this.historyEvents.get(index);
   }
   @Override
   public List<HistoryEvent> getHistoryEvents() {
      return Collections.unmodifiableList(this.historyEvents);
   }
   @Override
   public HistoryEvent removeHistoryEvent(int index) {
      return this.historyEvents.remove(index);
   }
   @Override
   public boolean removeHistoryEvent(HistoryEvent event) {
      return this.historyEvents.remove(event);
   }
   @Override
   public HistoryEvent setHistoryEvent(int index,HistoryEvent event) {
      return this.historyEvents.set(index,event);
   }
   @Override
   public void setHistoryEvents(HistoryEvent... events) {
      if (events != null) {
         clearHistoryEvents();
         for (HistoryEvent event: events) {
            this.historyEvents.add(event);
         } // END for (HistoryEvent event: events)
      } // END if (events != null)
   }
   @Override
   public void setHistoryEvents(List<HistoryEvent> events) {
      clearHistoryEvents();
      this.historyEvents.addAll(events);
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
   
   //***** paymentCollected
   public float getPaymentCollected() {
      return this.paymentCollected;
   }
   public void setPaymentCollected(float amount) {
      this.paymentCollected=amount;
   }
   
   //***** paymentNotes
   public String getPaymentNotes() {
      return this.paymentNotes;
   }
   public void setPaymentNotes(String paymentNotes) {
      this.paymentNotes=paymentNotes;
   }
   
   //***** pieces
   @Override
   public int getPieces() {
      return this.pieces;
   }
   @Override
   public void setPieces(int count) {
      this.pieces=count;      
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

   //***** requestWindowStartTime
   @Override
   public Date getRequestWindowStartTime() {
      return this.requestWindowStartTime;
   }
   @Override
   public void setRequestWindowStartTime(Date windowStart) {
      this.requestWindowStartTime=windowStart;
   }

   //***** requestWindowStopTime
   @Override
   public Date getRequestWindowEndTime() {
      return this.requestWindowEndTime;
   }
   @Override
   public void setRequestWindowEndTime(Date windowStop) {      
      this.requestWindowEndTime=windowStop;
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
   
   //***** scheduledAt
   @Override
   public Date getScheduledAt() {
      return this.scheduledAt;
   }
   @Override
   public void setScheduledAt(Date date) {
      this.scheduledAt=date;
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
   public ServiceUnit getServiceUnit() {
      return this.serviceUnit;
   }
   @Override
   public void setServiceUnit(ServiceUnit serviceUnit) {
      this.serviceUnit=serviceUnit;
   }

 //***** shipmentEvents
   @Override
   public boolean addShipmentEvent(ShipmentEvent event) {
      return this.events.add(event);
   }
   @Override
   public void clearShipmentEvents() {
      this.events.clear();      
   }
   @Override
   public ShipmentEvent getShipmentEvent(int i) {
      int numberOfEvents=0;
      ShipmentEvent event=null;
      
      numberOfEvents=this.events.size();
      if (i >= numberOfEvents) {
         i=numberOfEvents - 1;
      }  // END if (i >= numberOfEvents)
      if (i < 0) {
         i=0;
      } // END if (i < 0) 
      if (numberOfEvents > 0) {
         event=this.events.get(i);
      } // END if (numberOfEvents > 0)    
      return event;
   }
   @Override
   public List<ShipmentEvent> getShipmentEvents() {
      List<ShipmentEvent> events=null;
      events=Collections.unmodifiableList(this.events);
      return events;
   }
   @Override 
   public ShipmentEvent removeShipmentEvent(int i) {
      int numberOfEvents=0;
      ShipmentEvent event=null;
      
      numberOfEvents=this.events.size();
      if ((i > numberOfEvents -1) || (i < 0)) {
         throw new IndexOutOfBoundsException();
      } // END if ((i > numberOfEvents -1) || (i < 0))
      event=this.events.remove(i);
      return event;
   }
   @Override
   public boolean removeShipmentEvent(ShipmentEvent event) {
      boolean result=false;
      result=this.events.remove(event);
      return result;
   }
   @Override
   public ShipmentEvent setShipmentEvent(int index, ShipmentEvent event) {
      return this.events.set(index, event);
   }
   @Override
   public void setShipmentEvents(ShipmentEvent...events) {
      if (events != null) {
         for(ShipmentEvent event: events) {
            addShipmentEvent(event);
         } // END for(ShipmentEvent event: events)
      } else {
         this.events.clear();
      } // END if (events != null)
   }
   @Override
   public void setShipmentEvents(List<ShipmentEvent> events) {
      if (events != null) {
         for(ShipmentEvent event: events) {
            addShipmentEvent(event);
         } // END for(ShipmentEvent event: events)
      } else {
         this.events.clear();
      } // END if (events != null)
   }
   
   //***** signature
   @Override
   public Signature getSignature() {
      return this.signature;
   }
   @Override
   public void setSignature(Signature signature) {
      this.signature=signature;      
   }
   
   //***** startedAt
   public Date getStartedAt() {
      return this.startedAt;
   }
   public void setStartedAt(Date startedAt) {
      this.startedAt=startedAt;
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

   //***** survey
   @Override
   public Survey getSurvey() {
      return this.survey;
   }
   @Override
   public void setSurvey(Survey survey) {
      this.survey=survey;      
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

   //***** timeWindowStart
   public Date getTimeWindowStart() {
      return this.timeWindowStart;
   }
   public void setTimeWindowStart(Date timeWindowStart) {
      this.timeWindowStart=timeWindowStart;
   }
   
   //***** timeWindowStop
   public Date getTimeWindowEnd() {
      return this.timeWindowEnd;
   }
   public void setTimeWindowEnd(Date timeWindowEnd) {
      this.timeWindowEnd=timeWindowEnd;      
   }
   
   //***** totalItemQuantity
   @Override
   public int getTotalItemQuantity() {
      int count=0;
      for (Item item: this.items) {
         count+=item.getQuantity();
      } // END for (Item item: this.items)
      return count;
   }
   //***** truck
   @Override
   public Truck getTruck() {
      return this.truck;
   }
   @Override
   public void setTruck(Truck truck) {
      this.truck=truck;
   }
}