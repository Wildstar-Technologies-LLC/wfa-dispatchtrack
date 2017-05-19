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
import java.util.Map;

public interface ServiceOrder {
   public String _RESOURCE_BUNDLE=
      "com.wildstartech.dispatchtrack.ServiceOrderMessages";
   
   public enum Status {NEW, SCHEDULED, STARTED, UNABLE_TO_START, FINISHED, 
      UNABLE_TO_FINISH};
   public enum ServiceType {DELIVERY,PICKUP,SERVICE};
   
   //***** account
   public String getAccount();
   public void setAccount(String account);
   
   //***** additionalFields
   public Map<String,String> getAdditionalFields();
   public void setAdditionalFields(Map<String,String> additionalFields);
   
   //***** amount
   public float getAmount();
   public void setAmount(float amount);
   
   //***** cod
   public float getCOD();
   public void setCOD(float cod);
   
   //***** codAmount
   public float getCODAmount();
   public void setCODAmount(float amount);
      
   //***** customer
   public Customer getCustomer();
   public void setCustomer(Customer customer);

   //***** deliveredItemQuantity
   public int getDeliveredItemQuantity();
   
   //***** deliveryCharge 
   public float getDeliveryCharge();
   public void setDeliveryCharge(float charge);
   
   //***** deliveryDate
   public Date getDeliveryDate();
   public void setDeliveryDate(Date deliveryDate);
   
   //***** description
   public String getDescription();
   public void setDescription(String description);
   
   //***** displayOrderNumber
   public String getDisplayOrderNumber();
   public void setDisplayOrderNumber(String orderNumber);
   
   //***** drivers   
   public boolean addDriver(Driver driver);
   public Driver getDriver(int index);
   public List<Driver> getDrivers();
   public boolean removeDriver(Driver drive);
   public Driver removeDriver(int index);
   public Driver setDriver(int index, Driver driver);
   public void setDrivers(Driver... drivers);
   public void setDrivers(List<Driver> drivers);
   
   //***** extra
   public Map<String,String> getExtra();
   public void setExtra(Map<String,String> extra);
   
   //***** finishedAt
   public Date getFinishedAt();
   public void setFinishedAt(Date finishedAt);
   
   //***** id
   public String getId();
   public void setId(String id);
   
   //***** images
   public boolean addImage(Image image);
   public Image getImage(int index);
   public List<Image> getImages();
   public Image removeImage(int index);
   public boolean removeImage(Image image);
   public Image setImage(int index,Image image);
   public void setImages(Image... images);
   public void setImages(List<Image> images);
   
   //***** items
   public boolean addItem(Item item);
   public Item getItem(int index);
   public List<Item> getItems();
   public Item removeItem(int index);
   public boolean removeItem(Item item);
   public Item setItem(int index,Item item);
   public void setItems(Item... items);
   public void setItems(List<Item> items);   
   
   //***** itemCount
   public int getItemCount();
   
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
   
   //***** orderHistory 
   public boolean addHistoryEvent(HistoryEvent event);
   public void clearHistoryEvents();
   public HistoryEvent getHistoryEvent(int index);
   public List<HistoryEvent> getHistoryEvents();
   public HistoryEvent removeHistoryEvent(int index);
   public boolean removeHistoryEvent(HistoryEvent event);
   public HistoryEvent setHistoryEvent(int index,HistoryEvent event);
   public void setHistoryEvents(HistoryEvent... events);
   public void setHistoryEvents(List<HistoryEvent> events);
   
   //***** origin
   public String getOrigin();
   public void setOrigin(String origin);
   
   //***** paymentCollected
   public float getPaymentCollected();
   public void setPaymentCollected(float amount);
   
   //***** paymentNotes
   public String getPaymentNotes();
   public void setPaymentNotes(String paymentNotes);
   
   //***** pieces
   public int getPieces();
   public void setPieces(int pieces);
   
   //***** preCall
   public PreCall getPreCall();
   public void setPreCall(PreCall preCall);
   
   //***** preReqs
   public boolean addPreReq(String prerequisiteOrderId);
   public List<String> getPreReqs();
   public void setPreReqs(List<String> prerequisiteOrderId);
   
   //***** requestDeliveryDate
   public Date getRequestDeliveryDate();
   public void setRequestDeliveryDate(Date saleDate);
   
   //***** requestWindowStartTime
   public Date getRequestWindowStartTime();
   public void setRequestWindowStartTime(Date windowStart);
   
   //***** requestTWindowStopTime
   public Date getRequestWindowEndTime();
   public void setRequestWindowEndTime(Date windowStop);
   
   //***** scheduledAt
   public Date getScheduledAt();
   public void setScheduledAt(Date scheduledAt);
   
   //***** serviceType
   public String getServiceType();
   public String getServiceTypeLabel();
   public void setServiceType(String serviceType);
   
   //***** serviceTime
   public int getServiceTime();
   public void setServiceTime(int serviceTime);
   
   //***** serviceUnit
   /**
    * Returns the name of the resource or route.
    * @return
    */
   public ServiceUnit getServiceUnit();
   public void setServiceUnit(ServiceUnit serviceUnit);

   //***** shipmentEvents
   public boolean addShipmentEvent(ShipmentEvent event);
   public void clearShipmentEvents();
   public ShipmentEvent getShipmentEvent(int i);
   public List<ShipmentEvent> getShipmentEvents();
   public ShipmentEvent removeShipmentEvent(int i);
   public boolean removeShipmentEvent(ShipmentEvent event);
   public ShipmentEvent setShipmentEvent(int index, ShipmentEvent event);
   public void setShipmentEvents(List<ShipmentEvent> events);
   public void setShipmentEvents(ShipmentEvent... events);
   
   //***** signature
   public Signature getSignature();
   public void setSignature(Signature signature);
   
   //***** startedAt
   public Date getStartedAt();
   public void setStartedAt(Date startedAt);
   
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
   
   //***** survey
   public Survey getSurvey();
   public void setSurvey(Survey survey);
   
   //***** taxes 
   public float getTaxes();
   public void setTaxes(float taxes);
   
   //***** timeWindowEnd
   public Date getTimeWindowEnd();
   public void setTimeWindowEnd(Date timeWindowEnd);
   
   //***** timeWindowStart
   public Date getTimeWindowStart();
   public void setTimeWindowStart(Date timeWindowStart);
   
   //***** totalItemQuantity
   public int getTotalItemQuantity();
   
   //***** truckId
   public Truck getTruck();
   public void setTruck(Truck truck);
}