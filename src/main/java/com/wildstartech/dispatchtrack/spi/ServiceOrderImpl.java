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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.Customer;
import com.wildstartech.dispatchtrack.Driver;
import com.wildstartech.dispatchtrack.HistoryEvent;
import com.wildstartech.dispatchtrack.Image;
import com.wildstartech.dispatchtrack.Item;
import com.wildstartech.dispatchtrack.Localization;
import com.wildstartech.dispatchtrack.Note;
import com.wildstartech.dispatchtrack.PreCall;
import com.wildstartech.dispatchtrack.ServiceOrder;
import com.wildstartech.dispatchtrack.ServiceOrderMessages;
import com.wildstartech.dispatchtrack.ServiceUnit;
import com.wildstartech.dispatchtrack.ShipmentEvent;
import com.wildstartech.dispatchtrack.Signature;
import com.wildstartech.dispatchtrack.Survey;
import com.wildstartech.dispatchtrack.Truck;

/**
 * Class representation of a DispatchTrack Service Order.
 * @author Derek Berube, Wildstar Technologies, LLC.
 * @version 0.1, 2017.05.02
 *
 */
public class ServiceOrderImpl implements ServiceOrder {
   private static final String _CLASS=ServiceOrderImpl.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   private float amount=0f;
   private float cod=0f;
   private float codAmount=0f;
   private float deliveryCharge=0f;
   private float paymentCollected=0f;
   private float taxes=0f;
   
   private int pieces=0;
   private int serviceTime=0;
   private int stopNumber=0;
   
   private Customer customer=null;
   
   private Date deliveryDate=null;
   private Date finishedAt=null;
   private Date requestDeliveryDate=null;
   private Date requestWindowEndTime=null;
   private Date requestWindowStartTime=null;
   private Date scheduledAt=null;
   private Date startedAt=null;
   private Date timeWindowEnd=null;
   private Date timeWindowStart=null;
   
   private List<Driver> drivers=null;
   private List<HistoryEvent> historyEvents=null;
   private List<Image> images=null;
   private List<Item> items=null;
   private List<Note> notes=null;
   private List<ShipmentEvent> orderShipmentEvents=null;
   private List<String> prerequisiteOrderIds=null;
   
   private Map<String,String> additionalFields=null;
   private Map<String,String> extra=null;
   
   private PreCall preCall=null;
   
   private Signature signature=null;
   
   private ServiceUnit serviceUnit=null;
   
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
   public ServiceOrderImpl() {
      logger.entering(_CLASS, "serviceOrderImpl()");
      this.additionalFields=new TreeMap<String,String>();
      this.customer=new CustomerImpl();
      this.drivers=new ArrayList<Driver>();
      this.orderShipmentEvents=new ArrayList<ShipmentEvent>();
      this.extra=new TreeMap<String,String>();
      this.images=new ArrayList<Image>();
      this.items=new ArrayList<Item>();
      this.notes=new ArrayList<Note>();
      this.preCall=new PreCallImpl();
      this.prerequisiteOrderIds=new ArrayList<String>();
      this.signature=new SignatureImpl();
      this.survey=new SurveyImpl();
      logger.exiting(_CLASS, "serviceOrderImpl()");
   }
   /* ********** Utility Methods **********/
   /**
    * Utility to return the localized label for the Status
    * @param status
    * @return
    */
   private String getStatusLabel(Status status) {
      logger.entering(_CLASS, "getStatusLabel(Status)",status);
      String label="";
      String resourceId="";
      
      switch (status) {
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
            ServiceOrder._RESOURCE_BUNDLE, 
            resourceId, 
            null, 
            null, 
            null);
      logger.exiting(_CLASS, "getStatusLabel(Status)",label);
      return label;
   }
   /* ********** Accessor Methods **********/
   //***** accountId
   @Override
   public String getAccount() {
      logger.entering(_CLASS, "getAccountId()");
      logger.exiting(_CLASS, "getAccountId()",this.account);
      return this.account;
   }
   @Override
   public void setAccount(String accountId) {
      logger.entering(_CLASS, "setAccountId(String)",accountId);
      this.account=accountId;
      logger.exiting(_CLASS, "setAccountId(String)");
   }
   
   //***** additionalFields
   public Map<String,String> getAdditionalFields() {
      logger.entering(_CLASS, "getAdditionalFields()");
      logger.exiting(_CLASS, "getAdditionalFields()",this.additionalFields);
      return this.additionalFields;
   }
   public void setAdditionalFields(Map<String,String> additionalFields) {
      logger.entering(_CLASS, "setAdditionalFields(Map<String,String>)",
         additionalFields);
      if (additionalFields != null) {
         this.additionalFields=additionalFields;
      } else {
         this.additionalFields.clear();
      } // END if (additionalFields != null)
      logger.exiting(_CLASS, "setAdditionalFields(Map<String,String>)");
   }

   //***** amount
   @Override
   public float getAmount() {
      logger.entering(_CLASS, "getAmount()");
      logger.exiting(_CLASS, "getAmount()",this.amount);
      return this.amount;
   }
   @Override
   public void setAmount(float amount) {
      logger.entering(_CLASS, "setAmount(float)",amount);
      this.amount=amount;
      logger.exiting(_CLASS, "setAmount(float)");            
   }
   
   //***** cod
   @Override
   public float getCOD() {
      logger.entering(_CLASS, "getCOD()");
      logger.exiting(_CLASS, "getCOD()",this.cod);
      return this.cod;
   }
   @Override
   public void setCOD(float cod) {
      logger.entering(_CLASS, "setCOD(float)",cod);
      this.cod=cod;
      logger.exiting(_CLASS, "setCOD(float)");
   }
   
   //***** codAmount
   @Override
   public float getCODAmount() {
      logger.entering(_CLASS, "getCODAmount()");
      logger.exiting(_CLASS, "getCODAmount()",this.codAmount);
      return this.codAmount;
   }
   @Override
   public void setCODAmount(float amount) {
      logger.entering(_CLASS, "setCODAmount(float)",amount);
      this.codAmount=amount;
      logger.exiting(_CLASS, "setCODAmount(float)");
   }

   //***** count
   @Override
   public int getCount() {
      logger.entering(_CLASS, "getCount()");
      int count=0;
      count=this.items.size();
      logger.exiting(_CLASS, "getCount()",count);
      return count;
   }
   
   //***** customer
   @Override
   public Customer getCustomer() {
      logger.entering(_CLASS, "getCustomer()");
      logger.exiting(_CLASS, "getCustomer()",this.customer);
      return this.customer;
   }

   @Override
   public void setCustomer(Customer customer) {
      logger.entering(_CLASS, "setCustomer(Customer)",customer);
      this.customer=customer;
      logger.exiting(_CLASS, "setCustomer(Customer)");
   }

   //***** deliveredItemQuantity
   @Override
   public int getDeliveredQuantity() {
      logger.entering(_CLASS, "getDeliveredQuantity()");
      int count=0;
      for (Item item: this.items) {
         count+=item.getDeliveredQuantity();
      } // END for (Item item: this.items)
      logger.exiting(_CLASS, "getDeliveredQuantity()",count);
      return count;
   }
   
   //***** deliveryCharge
   @Override
   public float getDeliveryCharge() {
      logger.entering(_CLASS, "getDeliveryCharge()");
      logger.exiting(_CLASS, "getDeliveryCharge()",this.deliveryCharge);
      return this.deliveryCharge;
   }

   @Override
   public void setDeliveryCharge(float charge) {
      logger.entering(_CLASS, "setDeliveryCharge(float)",charge);
      this.deliveryCharge=charge;
      logger.exiting(_CLASS, "setDeliveryCharge(float)");
   }

   //***** deliveryDate
   @Override
   public Date getDeliveryDate() {
      logger.entering(_CLASS, "getDeliveryDate()");
      logger.exiting(_CLASS, "getDeliveryDate()",this.deliveryDate);
      return this.deliveryDate;
   }
   @Override
   public void setDeliveryDate(Date deliveryDate) {
      logger.entering(_CLASS, "setDeliveryDate(Date)",deliveryDate);
      this.deliveryDate=deliveryDate;
      logger.exiting(_CLASS, "setDeliveryDate(Date)");
   }   

   //***** description
   @Override
   public String getDescription() {
      logger.entering(_CLASS, "getDescription()");
      logger.exiting(_CLASS, "getDescription()",this.description);
      return this.description;
   }
   @Override
   public void setDescription(String description) {
      logger.entering(_CLASS, "setDescription(String)",description);
      this.description=description;
      logger.exiting(_CLASS, "setDescription(String)");
   }

   //***** dispayOrderNumber
   @Override 
   public String getDisplayOrderNumber() {
      logger.entering(_CLASS, "getDisplayOrderNumber()");
      logger.exiting(_CLASS, "getDisplayOrderNumber()",
            this.displayOrderNumber);
      return this.displayOrderNumber;
   }
   public void setDisplayOrderNumber(String orderNumber) {
      logger.entering(_CLASS, "setDisplayOrderNumber(String)",orderNumber);
      this.displayOrderNumber=orderNumber;
      logger.exiting(_CLASS, "setDisplayOrderNumber(String)");
   }
   //***** driver
   @Override
   public boolean addDriver(Driver driver) {
      logger.entering(_CLASS, "addDriver(Driver)",driver);
      boolean result=false;
      if (driver != null) {
         result=this.drivers.add(driver);
      } // END if (driver != null)
      logger.exiting(_CLASS, "addDriver(Driver)",result);
      return result;
   }
   @Override
   public Driver getDriver(int index) {
      logger.entering(_CLASS, "getDriver(int)",index);
      Driver driver=null;
      driver=this.drivers.get(index);
      logger.exiting(_CLASS, "getDriver(int)",driver);
      return driver;
   }
   @Override
   public List<Driver> getDrivers() {
      logger.entering(_CLASS, "getDrivers()");
      List<Driver> newList=null;
      newList=Collections.unmodifiableList(this.drivers);
      logger.exiting(_CLASS, "getDrivers()",newList);
      return newList;
   }
   @Override
   public boolean removeDriver(Driver driver) {
      logger.entering(_CLASS, "removeDriver(Driver)",driver);
      boolean result=false;
      if (driver != null) {
         result=this.drivers.remove(driver);
      } // END if (driver != null)
      logger.exiting(_CLASS, "removeDriver(Driver)",result);
      return result;
   }
   @Override
   public Driver removeDriver(int index) {
      logger.entering(_CLASS, "removeDriver(int)",index);
      Driver driver=null;
      driver=this.drivers.remove(index);
      logger.exiting(_CLASS, "removeDriver(int)",driver);
      return driver;
   }
   @Override
   public Driver setDriver(int index, Driver driver) {
      logger.entering(_CLASS,"setDriver(int,Driver)",
         new Object[] {index,driver});
      Driver returnDriver=null;
      returnDriver=this.drivers.remove(index);
      logger.exiting(_CLASS, "setDriver(int,Driver)",returnDriver);
      return returnDriver;
   }
   @Override
   public void setDrivers(Driver...drivers) {
      logger.entering(_CLASS, "setDrivers(Driver...)",drivers);
      if (drivers != null) {
         for (Driver driver: drivers) {
            this.drivers.add(driver);
         } // END for (Driver driver: drivers) 
      } // END if (drivers != null)
      logger.exiting(_CLASS, "setDrivers(Driver...)");
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
      logger.entering(_CLASS, "getExtra()");
      logger.exiting(_CLASS, "getExtra()",this.extra);
      return this.extra;
   }
   public void setExtra(Map<String,String> extra) {
      logger.entering(_CLASS, "setExtra(Map<String,String>)",extra);
      if (extra != null) {
         this.extra=extra;
      } else {
         this.extra.clear();
      } // END if (additionalFields != null)
      logger.exiting(_CLASS, "setExtra(Map<String,String>)");
   }
   
   //***** finishedAt
   @Override
   public Date getFinishedAt() {
      logger.entering(_CLASS, "getFinishedAt()");
      logger.exiting(_CLASS, "getFinishedAt()",this.finishedAt);
      return this.finishedAt;
   }
   @Override
   public void setFinishedAt(Date finishedAt) {
      logger.entering(_CLASS, "setFinishedAt(Date)",finishedAt);
      this.finishedAt=finishedAt;
      logger.exiting(_CLASS, "setFinishedAt(Date)");
   }
   
   //***** id
   @Override
   public String getId() {
      logger.entering(_CLASS, "getId()");
      logger.exiting(_CLASS, "getId()",this.id);
      return this.id;      
   }
   @Override
   public void setId(String id) {
      logger.entering(_CLASS, "setId(String)",id);
      this.id=id;
      logger.entering(_CLASS, "setId(String)");
   }
   
   //***** images
   @Override
   public boolean addImage(Image image) {
      logger.entering(_CLASS, "addImage(Image)",image);
      boolean result=false;
      if (image != null) {
         result=this.images.add(image);
      } // END if (image != null)
      logger.exiting(_CLASS, "addImage(Image)",result);
      return result;
   }
   @Override
   public Image getImage(int index) {
      logger.entering(_CLASS, "getImage(int)",index);
      Image image=null;
      image=this.images.get(index);
      logger.exiting(_CLASS, "getImage(int)",image);
      return image;
   }
   
   @Override
   public List<Image> getImages() {
      logger.entering(_CLASS, "getImages()");
      List<Image> newList=null;
      newList=Collections.unmodifiableList(this.images);
      logger.exiting(_CLASS, "getImages()",newList);
      return newList;
   }
   @Override
   public Image removeImage(int index) {
      logger.entering(_CLASS, "removeImage(int)",index);
      Image image=null;
      image=this.images.remove(index);
      logger.exiting(_CLASS, "removeImage(int)",image);
      return image;
   }
   @Override
   public boolean removeImage(Image image) {
      logger.entering(_CLASS, "removeImage(Image)",image);
      boolean result=false;
      if (image != null) {
         result=this.images.remove(image);
      } // END if (image != null)
      logger.exiting(_CLASS, "removeImage(Image)",result);
      return result;
   }
   @Override 
   public Image setImage(int index, Image image) {
      logger.entering(_CLASS, "setImage(int,Image)",new Object[] {index,image});
      Image result=null;
      result=this.images.set(index, image);
      logger.exiting(_CLASS, "setImage(int,Image)",result);
      return result;
   }
   @Override
   public void setImages(Image... images) {
      logger.entering(_CLASS, "setImages(Image)",images);
      this.images.clear();
      if (images != null) {
         for (Image image: images) {
            this.images.add(image);
         } // END for (Image image: images)
      } // END if (images != null)
      logger.exiting(_CLASS, "setImages(Image)");
   }
   @Override
   public void setImages(List<Image> images) {
      logger.entering(_CLASS, "setImages(Image)",images);
      this.images.clear();
      this.images.addAll(images);
      logger.exiting(_CLASS, "setImages(Image)");
   }
   
   //***** itemCount
   @Override
   public int getItemCount() {
      logger.entering(_CLASS, "getItemCount()");
      logger.exiting(_CLASS, "getItemCount()",this.items.size());
      return this.items.size();
   }
   
   //***** items
   @Override
   public boolean addItem(Item item) {
      logger.entering(_CLASS, "addItem(Item)",item);
      boolean result=false;
      if (item != null) {
         result=this.items.add(item);
      } // END if (item != null)
      logger.exiting(_CLASS, "addItem(Item)",result);
      return result;
   }
   @Override
   public Item getItem(int index) {
      logger.entering(_CLASS, "getItem(int)",index);
      Item item=null;
      item=this.items.get(index);
      logger.exiting(_CLASS, "getItem(int)",item);
      return item;
   }
   
   @Override
   public List<Item> getItems() {
      logger.entering(_CLASS, "getItems()");
      List<Item> newList=null;
      newList=Collections.unmodifiableList(this.items);
      logger.exiting(_CLASS, "getItems()",newList);
      return newList;
   }
   @Override
   public Item removeItem(int index) {
      logger.entering(_CLASS, "removeItem(int)",index);
      Item item=null;
      item=this.items.remove(index);
      logger.exiting(_CLASS, "removeItem(int)",item);
      return item;
   }
   @Override
   public boolean removeItem(Item item) {
      logger.entering(_CLASS, "removeItem(Item)",item);
      boolean result=false;
      if (item != null) {
         result=this.items.remove(item);
      } // END if (item != null)
      logger.exiting(_CLASS, "removeItem(Item)",result);
      return result;
   }
   @Override 
   public Item setItem(int index, Item item) {
      logger.entering(_CLASS, "setItem(int,Item)",new Object[] {index,item});
      Item result=null;
      result=this.items.set(index, item);
      logger.exiting(_CLASS, "setItem(int,Item)",result);
      return result;
   }
   @Override
   public void setItems(Item... items) {
      logger.entering(_CLASS, "setItems(Item)",items);
      this.items.clear();
      if (items != null) {
         for (Item item: items) {
            this.items.add(item);
         } // END for (Item item: items)
      } // END if (items != null)
      logger.exiting(_CLASS, "setItems(Item)");
   }
   @Override
   public void setItems(List<Item> items) {
      logger.entering(_CLASS, "setItems(Item)",items);
      this.items.clear();
      this.items.addAll(items);
      logger.exiting(_CLASS, "setItems(Item)");
   }
   
   //***** notes
   @Override
   public List<Note> getNotes() {
      logger.entering(_CLASS, "getNotes()");
      List<Note> newList=null;
      newList=Collections.unmodifiableList(this.notes);
      logger.exiting(_CLASS, "getNotes()",newList);
      return newList;      
   }
   @Override
   public void setNotes(Note... notes) {
      logger.entering(_CLASS, "setNotes(Note...)",notes);
      this.notes.clear();
      if (notes != null) {
         for (Note note: notes) {
            this.notes.add(note);
         } // END for (Note note: notes)
      } // END if (notes != null)
      logger.entering(_CLASS, "setNotes(Note...)");
   }
   @Override
   public boolean addNote(Note note) {
      logger.entering(_CLASS, "addNote(Note)",note);
      boolean result=false;
      if (note != null) {
         result=this.notes.add(note);
      } // END if (note != null)
      logger.exiting(_CLASS, "addNote(Note)",result);
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
      logger.entering(_CLASS, "getNoteCount()");
      int noteCount=0;
      noteCount=this.notes.size();
      logger.exiting(_CLASS, "getNoteCount()",noteCount);
      return noteCount;
   }

   //***** number
   @Override
   public String getNumber() {
      logger.entering(_CLASS, "getNumber()");
      logger.exiting(_CLASS, "getNumber()",this.number);
      return this.number;
   }
   @Override
   public void setNumber(String number) {
      logger.entering(_CLASS, "setNumber(String)",number);
      this.number=number;
      logger.exiting(_CLASS, "setNumber(String)");
   }

   //***** orderHistory 
   @Override
   public boolean addHistoryEvent(HistoryEvent event) {
      logger.entering(_CLASS, "addHistoryEvent(HistoryEvent)",event);
      boolean result=false;
      result=this.historyEvents.add(event);
      logger.entering(_CLASS, "addHistoryEvent(HistoryEvent)",result);
      return result;
   }
   
   @Override
   public void clearHistoryEvents() {
      logger.entering(_CLASS, "clearHistoryEvents()");
      this.historyEvents.clear();
      logger.exiting(_CLASS, "clearHistoryEvents()");
   }
  
   @Override
   public HistoryEvent getHistoryEvent(int index) {
      logger.entering(_CLASS, "getHistoryEvent(int)",index);
      HistoryEvent event=null;
      event=this.historyEvents.get(index);
      logger.entering(_CLASS, "getHistoryEvent(HistoryEvent)",event);
      return event;
   }
   @Override
   public List<HistoryEvent> getHistoryEvents() {
      logger.entering(_CLASS, "getHistoryEvents()");
      List<HistoryEvent> events=null;
      events=Collections.unmodifiableList(this.historyEvents);
      logger.exiting(_CLASS, "getHistoryEvents()",events);
      return events;
   }
   @Override
   public HistoryEvent removeHistoryEvent(int index) {
      logger.entering(_CLASS, "removeHistoryEvent(int)",index);
      HistoryEvent event=null;
      event=this.historyEvents.remove(index);
      logger.entering(_CLASS, "removeHistoryEvent(int)",event);
      return event;
   }
   @Override
   public boolean removeHistoryEvent(HistoryEvent event) {
      logger.entering(_CLASS, "removeHistoryEvent(HistoryEvent)",event);
      boolean result=false;
      result=this.historyEvents.remove(event);
      logger.entering(_CLASS, "removeHistoryEvent(HistoryEvent)",result);
      return result;
   }
   @Override
   public HistoryEvent setHistoryEvent(int index,HistoryEvent event) {
      logger.entering(_CLASS, "setHistoryEvent(int,HistoryEvent)",
            new Object[] {index,event});
      HistoryEvent returnEvent=null;
      returnEvent=this.historyEvents.set(index,event);
      logger.entering(_CLASS, "getHistoryEvent(HistoryEvent)",returnEvent);
      return returnEvent;
   }
   @Override
   public void setHistoryEvents(HistoryEvent... events) {
      logger.entering(_CLASS, "setHistoryEvents(HistoryEvent...)",events);
      if (events != null) {
         clearHistoryEvents();
         for (HistoryEvent event: events) {
            this.historyEvents.add(event);
         } // END for (HistoryEvent event: events)
      } // END if (events != null)
      logger.exiting(_CLASS, "setHistoryEvents(HistoryEvent...)");
   }
   @Override
   public void setHistoryEvents(List<HistoryEvent> events) {
      logger.entering(_CLASS, "setHistoryEvents()",events);
      clearHistoryEvents();
      this.historyEvents.addAll(events);
      logger.exiting(_CLASS, "setHistoryEvents()");
   }
   //***** origin
   @Override
   public String getOrigin() {
      logger.entering(_CLASS, "getOrigin()");
      logger.exiting(_CLASS, "getOrigin()",this.origin);
      return this.origin;
   }
   @Override
   public void setOrigin(String origin) {
      logger.entering(_CLASS, "setOrigin(String)",origin);
      this.origin=origin;
      logger.exiting(_CLASS, "setOrigin(String)");
   }
   
   //***** paymentCollected
   @Override
   public float getPaymentCollected() {
      logger.entering(_CLASS, "getPaymentCollected()");
      logger.exiting(_CLASS, "getPaymentCollected()",this.paymentCollected);
      return this.paymentCollected;
   }
   @Override
   public void setPaymentCollected(float amount) {
      logger.entering(_CLASS, "setPaymentCollected(String)",amount);
      this.paymentCollected=amount;
      logger.entering(_CLASS, "setPaymentCollected(String)");      
   }
   
   //***** paymentNotes
   @Override
   public String getPaymentNotes() {
      logger.entering(_CLASS, "getPaymentNotes()");
      logger.exiting(_CLASS, "getPaymentNotes()",this.paymentNotes);
      return this.paymentNotes;
   }
   @Override
   public void setPaymentNotes(String paymentNotes) {
      logger.entering(_CLASS, "setPaymentNotes(String)",paymentNotes);
      if (paymentNotes == null) {
         this.paymentNotes="";
      } else {
         this.paymentNotes=paymentNotes;
      } // END if (paymentNotes == null)
      logger.exiting(_CLASS, "setPaymentNotes(String)");
   }
   
   //***** pieces
   @Override
   public int getPieces() {
      logger.entering(_CLASS, "getPieces()");
      logger.exiting(_CLASS, "getPieces()",this.pieces);
      return this.pieces;
   }
   @Override
   public void setPieces(int count) {
      logger.entering(_CLASS, "setPieces(int)",count);
      if (count > 0) {
         this.pieces=count;
      } else {
         this.pieces=0;
      } // END if (count > 0)
      logger.exiting(_CLASS, "setPieces(int)");
   }
   //***** preCall
   @Override
   public PreCall getPreCall() {
      logger.entering(_CLASS, "getPreCall()");
      logger.exiting(_CLASS, "getPreCall()",this.preCall);
      return this.preCall;
   }
   @Override
   public void setPreCall(PreCall preCall) {
      logger.entering(_CLASS, "setPreCall(String)",preCall);
      this.preCall=preCall;
      logger.exiting(_CLASS, "setPreCall(String)");
   }
   //***** preReqs
   @Override
   public boolean addPreReq(String prerequisiteOrderId) {
      logger.entering(_CLASS, "addPreReq(String)",prerequisiteOrderId);
      boolean result=false;
      result=this.prerequisiteOrderIds.add(prerequisiteOrderId);
      logger.exiting(_CLASS, "addPreReq(String)",result);
      return result;
   }
   @Override
   public List<String> getPreReqs() {
      logger.entering(_CLASS, "getPreCall()");
      List<String> newList=null;
      newList=Collections.unmodifiableList(this.prerequisiteOrderIds);
      logger.exiting(_CLASS, "getPreCall()",newList);
      return newList;
   }
   @Override
   public void setPreReqs(List<String> prerequisiteOrderIds) {
      logger.entering(_CLASS, "setPreReqs(List<String>)",prerequisiteOrderIds);
      this.prerequisiteOrderIds=prerequisiteOrderIds;
      logger.exiting(_CLASS, "setPreReqs(List<String>)");
   }

   //***** requestDeliveryDate
   @Override
   public Date getRequestDeliveryDate() {
      logger.entering(_CLASS, "getRequestDeliveryDate()");
      logger.exiting(_CLASS, "getRequestDeliveryDate()",
         this.requestDeliveryDate);
      return this.requestDeliveryDate;
   }
   @Override
   public void setRequestDeliveryDate(Date deliveryDate) {
      logger.entering(_CLASS, "setRequestDeliveryDate(Date)",deliveryDate);
      this.requestDeliveryDate=deliveryDate;
      logger.exiting(_CLASS, "setRequestDeliveryDate(Date)");
   }

   //***** requestWindowStartTime
   @Override
   public Date getRequestWindowStartTime() {
      logger.entering(_CLASS, "getRequestWindowStartTime()");
      logger.exiting(_CLASS, "getRequestWindowStartTime()",
         this.requestWindowStartTime);
      return this.requestWindowStartTime;
   }
   @Override
   public void setRequestWindowStartTime(Date windowStart) {
      logger.entering(_CLASS, "setRequestWindowStartTime(Date)",windowStart);
      this.requestWindowStartTime=windowStart;
      logger.exiting(_CLASS, "setRequestWindowStartTime(Date)");
   }

   //***** requestWindowEndTime
   @Override
   public Date getRequestWindowEndTime() {
      logger.entering(_CLASS, "getRequestWindowEndTime()");
      logger.exiting(_CLASS, "getRequestWindowEndTime()",
         this.requestWindowEndTime);
      return this.requestWindowEndTime;
   }
   @Override
   public void setRequestWindowEndTime(Date windowEnd) {   
      logger.entering(_CLASS, "setRequestTimeWindowStop(Date)",windowEnd);
      this.requestWindowEndTime=windowEnd;
      logger.exiting(_CLASS, "setRequestTimeWindowStop(Date)");
   }
   
   //***** serviceType
   @Override
   public String getServiceType() {
      logger.entering(_CLASS, "getServiceType()");
      logger.exiting(_CLASS, "getServiceType()",this.serviceType);
      return this.serviceType;
   }

   @Override
   public void setServiceType(String serviceType) {
      logger.entering(_CLASS, "setServiceType(String)",serviceType);
      this.serviceType=serviceType;
      logger.exiting(_CLASS, "setServiceType(String)");
   }
   
   @Override
   public String getServiceTypeLabel() {
      logger.entering(_CLASS, "getServiceTypeLabel()");
      logger.exiting(_CLASS, "getServiceTypeLabel()",this.serviceType);
      return this.serviceType;
   }
   
   //***** scheduledAt
   @Override
   public Date getScheduledAt() {
      logger.entering(_CLASS,"getScheduledAt()");
      logger.exiting(_CLASS,"getScheduledAt()",this.scheduledAt);
      return this.scheduledAt;
   }
   @Override
   public void setScheduledAt(Date date) {
      logger.entering(_CLASS, "setScheduledAt(Date)",date);
      this.scheduledAt=date;
      logger.exiting(_CLASS, "setScheduledAt(Date)");
   }
   
   //***** serviceTime
   @Override
   public int getServiceTime() {
      logger.entering(_CLASS, "getServiceTime()");
      logger.exiting(_CLASS, "getServiceTime()",this.serviceTime);
      return this.serviceTime;
   }
   @Override
   public void setServiceTime(int serviceTime) {
      logger.entering(_CLASS, "setServiceTime(int)",serviceTime);
      this.serviceTime=serviceTime;
      logger.exiting(_CLASS, "setServiceTime(int)");
   }
   
   //***** serviceUnit
   @Override
   public ServiceUnit getServiceUnit() {
      logger.entering(_CLASS, "getServiceUnit()");
      logger.exiting(_CLASS, "getServiceUnit()",this.serviceUnit);
      return this.serviceUnit;
   }
   @Override
   public void setServiceUnit(ServiceUnit serviceUnit) {
      logger.entering(_CLASS, "setServiceUnit(ServiceUnit)",serviceUnit);
      this.serviceUnit=serviceUnit;
      logger.exiting(_CLASS, "setServiceUnit(ServiceUnit)");
   }

   //***** shipmentEvents
   @Override
   public boolean addOrderShipmentEvent(ShipmentEvent event) {
      logger.entering(_CLASS, "addOrderShipmentEvent(ShipmentEvent)",event);
      boolean result=false;
      result=this.orderShipmentEvents.add(event);
      logger.exiting(_CLASS, "addOrderShipmentEvent(ShipmentEvent)",result);
      return result;
   }
   @Override
   public void clearOrderShipmentEvents() {
      logger.entering(_CLASS, "clearOrderShipmentEvents()");
      this.orderShipmentEvents.clear();
      logger.exiting(_CLASS, "clearOrderShipmentEvents()");
   }
   @Override
   public ShipmentEvent getOrderShipmentEvent(int i) {
      logger.entering(_CLASS, "getOrderShipmentEvent(int)",i);
      int numberOfEvents=0;
      ShipmentEvent event=null;
      
      numberOfEvents=this.orderShipmentEvents.size();
      if (i >= numberOfEvents) {
         i=numberOfEvents - 1;
      }  // END if (i >= numberOfEvents)
      if (i < 0) {
         i=0;
      } // END if (i < 0) 
      if (numberOfEvents > 0) {
         event=this.orderShipmentEvents.get(i);
      } // END if (numberOfEvents > 0)    
      logger.entering(_CLASS, "getOrderShipmentEvent(int)",event);
      return event;
   }
   @Override
   public List<ShipmentEvent> getOrderShipmentEvents() {
      logger.entering(_CLASS, "getOrderShipmentEvents()");
      List<ShipmentEvent> events=null;
      events=Collections.unmodifiableList(this.orderShipmentEvents);
      logger.exiting(_CLASS, "getOrderShipmentEvents()",events);
      return events;
   }
   @Override 
   public ShipmentEvent removeOrderShipmentEvent(int i) {
      logger.entering(_CLASS, "removeShipmentEvent(int)",i);
      int numberOfEvents=0;
      ShipmentEvent event=null;
      
      numberOfEvents=this.orderShipmentEvents.size();
      if ((i > numberOfEvents -1) || (i < 0)) {
         throw new IndexOutOfBoundsException();
      } // END if ((i > numberOfEvents -1) || (i < 0))
      event=this.orderShipmentEvents.remove(i);
      logger.entering(_CLASS, "removeShipmentEvent(int)",event);
      return event;
   }
   @Override
   public boolean removeOrderShipmentEvent(ShipmentEvent event) {
      logger.entering(_CLASS, "removeOrderShipmentEvent(ShipmentEvent)",event);
      boolean result=false;
      result=this.orderShipmentEvents.remove(event);
      logger.exiting(_CLASS, "removeOrderShipmentEvent(ShipmentEvent)",result);
      return result;
   }
   @Override
   public ShipmentEvent setOrderShipmentEvent(int index, 
         ShipmentEvent event) {
      logger.entering(_CLASS, "setOrderShipmentEvent(int,ShipmentEvent)",
         new Object[] {index, event});
      ShipmentEvent result=null;
      result=this.orderShipmentEvents.set(index, event);
      logger.entering(_CLASS, "setOrderShipmentEvent(int,ShipmentEvent)",
         result);
      return result;
   }
   @Override
   public void setOrderShipmentEvents(ShipmentEvent...events) {
      logger.entering(_CLASS, "setOrderShipmentEvents(ShipmentEvent...)",
         events);
      if (events != null) {
         for(ShipmentEvent event: events) {
            addOrderShipmentEvent(event);
         } // END for(ShipmentEvent event: events)
      } else {
         this.orderShipmentEvents.clear();
      } // END if (events != null)
      logger.exiting(_CLASS, "setOrderShipmentEvents(ShipmentEvent...)");
   }
   @Override
   public void setOrderShipmentEvents(List<ShipmentEvent> events) {
      logger.entering(_CLASS, "setOrderShipmentEvents(List<ShipmentEvent>)",
         events);
      if (events != null) {
         for(ShipmentEvent event: events) {
            addOrderShipmentEvent(event);
         } // END for(ShipmentEvent event: events)
      } else {
         this.orderShipmentEvents.clear();
      } // END if (events != null)
      logger.exiting(_CLASS, "setOrderShipmentEvents(ShipmentEvent...)");
   }
   
   //***** signature
   @Override
   public Signature getSignature() {
      logger.entering(_CLASS, "getSignature()");
      logger.exiting(_CLASS, "getSignature()",this.signature);
      return this.signature;
   }
   @Override
   public void setSignature(Signature signature) {
      logger.entering(_CLASS, "setSignature(Signature)",signature);
      this.signature=signature;
      logger.exiting(_CLASS, "setSignature(Signature)");
   }
   //***** startedAt
   @Override
   public Date getStartedAt() {
      logger.entering(_CLASS, "getStartedAt()");
      logger.exiting(_CLASS, "getStartedAt()",this.startedAt);
      return this.startedAt;
   }
   @Override
   public void setStartedAt(Date startedAt) {
      logger.entering(_CLASS, "setStartedAt(Date)",startedAt);
      this.startedAt=startedAt;
      logger.exiting(_CLASS, "setStartedAt(Date)");
   }
   
   //***** status
   @Override
   public Status getStatus() {
      logger.entering(_CLASS, "getStatus()");
      logger.exiting(_CLASS, "getStatus()",this.status);
      return this.status;      
   }
   @Override
   public String getStatusLabel() {
      logger.entering(_CLASS, "getStatusLabel()");
      logger.exiting(_CLASS, "getStatusLabel()",this.status);
      return getStatusLabel(this.status);
   }
   
   @Override
   public void setStatus(Status status) {
      logger.entering(_CLASS, "setStatus(Status)",status);
      this.status=status;
      logger.exiting(_CLASS, "setStatus(Status)");
   }
   @Override
   public void setStatus(String statusLabel) {
      logger.entering(_CLASS, "setStatus(String)",statusLabel);
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
      logger.exiting(_CLASS, "setStatus(String)");
   }
   //***** stopNumber
   @Override
   public int getStopNumber() {
      logger.entering(_CLASS,"getStopNumber()");
      logger.exiting(_CLASS,"getStopNumber()",this.stopNumber);
      return this.stopNumber;
   }
   @Override
   public void setStopNumber(int stopNumber) {
      logger.entering(_CLASS,"setStopNumber(int)",stopNumber);
      this.stopNumber=stopNumber;
      logger.exiting(_CLASS,"setStopNumber(int)");
   }

   //***** stopTime
   @Override
   public String getStopTime() {
      logger.entering(_CLASS, "getStopTime()");
      logger.exiting(_CLASS, "getStopTime()",this.stopTime);
      return this.stopTime;
   }
   @Override
   public void setStopTime(String stopTime) {
      logger.entering(_CLASS, "setStopTime(String)",stopTime);
      this.stopTime=stopTime;
      logger.exiting(_CLASS, "setStopTime(String)");
   }

   //***** storeCode
   @Override
   public String getStoreCode() {
      logger.entering(_CLASS, "getStoreCode()");
      logger.exiting(_CLASS, "getStoreCode()",this.storeCode);
      return this.storeCode;
   }
   @Override
   public void setStoreCode(String storeCode) {
      logger.entering(_CLASS, "setStoreCode(String)",storeCode);
      this.storeCode=storeCode;
      logger.exiting(_CLASS, "setStoreCode(String)");
   }
   
   //***** survey
   @Override
   public Survey getSurvey() {
      logger.entering(_CLASS, "getSurvey()");
      logger.exiting(_CLASS, "getSurvey()",this.survey);
      return this.survey;
   }
   @Override
   public void setSurvey(Survey survey) {
      logger.entering(_CLASS, "setSurvey(Survey)",survey);
      if (survey != null) {
         this.survey=survey;
      } else {
         this.survey=new SurveyImpl();
      } // END if (survey != null)
      logger.exiting(_CLASS, "setSurvey(Survey)");
   }
   
   //***** timeWindowStart
   @Override
   public Date getTimeWindowStart() {
      logger.entering(_CLASS,"getTimeWindowStart()");
      logger.exiting(_CLASS,"getTimeWindowStart()",this.timeWindowStart);
      return this.timeWindowStart;
   }
   @Override
   public void setTimeWindowStart(Date timeWindowStart) {
      logger.entering(_CLASS, "setTimeWindowStart(Date)",timeWindowStart);
      this.timeWindowStart=timeWindowStart;
      logger.exiting(_CLASS, "setTimeWindowStart(Date)");
   }
   
   //***** timeWindowStop
   @Override
   public Date getTimeWindowEnd() {
      logger.entering(_CLASS,"getTimeWindowEnd()");
      logger.exiting(_CLASS,"getTimeWindowEnd()",this.timeWindowEnd);
      return this.timeWindowEnd;
   }
   @Override
   public void setTimeWindowEnd(Date timeWindowEnd) {
      logger.entering(_CLASS, "setTimeWindowEnd(Date)",timeWindowEnd);
      this.timeWindowEnd=timeWindowEnd;
      logger.exiting(_CLASS, "setTimeWindowEnd(Date)");
   }

   //***** totalItemQuantity
   @Override
   public int getTotalQuantity() {
      logger.entering(_CLASS, "getTotalQuantity()");
      int count=0;
      for (Item item: this.items) {
         count+=item.getQuantity();
      } // END for (Item item: this.items)
      logger.exiting(_CLASS, "getTotalQuantity()",count);
      return count;
   }
   
   //***** taxes
   @Override
   public float getTaxes() {
      logger.entering(_CLASS, "getTaxes()");
      logger.exiting(_CLASS, "getTaxes()",this.taxes);
      return this.taxes;
   }
   @Override
   public void setTaxes(float taxes) {
      logger.entering(_CLASS, "setTaxes(float)",taxes);
      this.taxes=taxes;
      logger.exiting(_CLASS, "setTaxes(float)");
   } 
   
   //***** truckId
   @Override
   public Truck getTruck() {
      logger.entering(_CLASS, "getTruck()");
      logger.exiting(_CLASS, "getTruck()",this.truck);
      return this.truck;
   }
   @Override
   public void setTruck(Truck truck) {
      logger.entering(_CLASS, "setTruck(Truck)",truck);
      this.truck=truck;
      logger.exiting(_CLASS, "setTruck(Truck)");
   }
}