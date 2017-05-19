package com.wildstartech.dispatchtrack;

import java.util.Date;

public class MockManifestEntry implements ManifestEntry {

   private int stopNumber=0;
   private Date scheduledDateTime=null;
   private Date windowEndTime=null;
   private Date windowStartTime=null;
   private String number=null;
   private String serviceOrderId=null;
   private String serviceUnit=null;
   private String status=null;
   
   /**
    * Default, no-argument constructor;
    */
   public MockManifestEntry() {
      
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

   @Override
   public Date getScheduledDate() {
      return this.scheduledDateTime;
   }

   @Override
   public void setScheduledDate(Date date) {
      this.scheduledDateTime=date;
   }

   @Override
   public void setScheduledDate(String date) {
      // TODO - Need to parse XML Date 
   }

   @Override
   public Date getScheduledTime() {
      return this.scheduledDateTime;
   }

   @Override
   public void setScheduledTime(Date scheduledTime) {
      this.scheduledDateTime=scheduledTime;
   }

   @Override
   public String getServiceOrderId() {
      return this.serviceOrderId;
   }

   @Override
   public void setServiceOrderId(String serviceOrderId) {
      this.serviceOrderId=serviceOrderId;
   }

   @Override
   public String getServiceUnit() {
      return this.serviceUnit;
   }

   @Override
   public void setServiceUnit(String serviceUnit) {
      this.serviceUnit=serviceUnit;
   }

   @Override
   public String getStatus() {
      return this.status;
   }

   @Override
   public void setStatus(String status) {
      this.status=status;

   }

   @Override
   public int getStopNumber() {
      return this.stopNumber;
   }

   @Override
   public void setStopNumber(int stopNumber) {
      this.stopNumber=stopNumber;
   }

   @Override
   public Date getWindowEndTime() {
      return this.windowEndTime;
   }

   @Override
   public void setWindowEndTime(Date endTime) {
      this.windowEndTime=endTime;
   }

   @Override
   public void setWindowEndTime(String endTime) {
      // TODO Auto-generated method stub

   }

   @Override
   public Date getWindowStartTime() {
      return this.windowStartTime;
   }

   @Override
   public void setWindowStartTime(Date startTime) {
      this.windowStartTime=startTime;

   }

   @Override
   public void setWindowStartTime(String startTime) {
      // TODO Auto-generated method stub
   }
}