package com.wildstartech.dispatchtrack;

import java.util.Date;

public class MockServiceRoute implements ServiceRoute {
   private float amount=0f;
   private float amountDelivered=0f;
   private float volume=0f;
   private int actualTime=0;
   private int driverNumber=0;
   private int miles=0;
   private int pieces=0;
   private int stop=0;
   private int totalTime=0;
   private Date actualEndTime=null;
   private Date actualStartTime=null;
   private Date estimatedEndTime=null;
   private Date estimatedStartTime=null;
   private String driverName=null;
   private String login=null;
   private String serviceUnit=null;

   public MockServiceRoute() {
   }
   
   //***** actualEndTime
   @Override
   public Date getActualEndTime() {
      return this.actualEndTime;
   }
   @Override
   public void setActualEndTime(Date endTime) {
      this.actualEndTime=endTime;
   }
   
   //***** actualStartTime
   @Override
   public Date getActualStartTime() {
      return this.actualStartTime;
   }
   @Override
   public void setActualStartTime(Date startTime) {
      this.actualStartTime=startTime;
   }

   //***** actualTime
   @Override
   public int getActualTime() {
      return this.actualTime;
   }
   @Override
   public void setActualTime(int actualTime) {
      this.actualTime=actualTime;
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

   //***** amountDelivered
   @Override
   public float getAmountDelivered() {
      return this.amountDelivered;
   }
   @Override
   public void setAmountDelivered(float amountDelivered) {
      this.amountDelivered=amountDelivered;
   }

   //***** driverName
   @Override
   public String getDriverName() {
      return this.driverName;
   }
   @Override
   public void setDriverName(String driverName) {
      this.driverName=driverName;
   }

   //***** driverNumber
   @Override
   public int getDriverNumber() {
      return this.driverNumber;
   }
   @Override
   public void setDriverNumber(int driverNumber) {
      this.driverNumber=driverNumber;
   }

   //***** estimatedEndTime
   @Override
   public Date getEstimatedEndTime() {
      return this.estimatedEndTime;
   }

   @Override
   public void setEstimatedEndTime(Date endTime) {
      this.estimatedEndTime=endTime;
   }

   //***** estimatedStartTime
   @Override
   public Date getEstimatedStartTime() {
      return this.estimatedStartTime;
   }
   @Override
   public void setEstimatedStartTime(Date startTime) {
      this.estimatedStartTime=startTime;
   }

   //***** login
   @Override
   public String getLogin() {
      return this.login;
   }
   @Override
   public void setLogin(String login) {
      this.login=login;
   }

   //***** miles
   @Override
   public int getMiles() {
      return this.miles;
   }
   @Override
   public void setMiles(int miles) {
      this.miles=miles;
   }

   //***** pieces
   @Override
   public int getPieces() {
      return this.pieces;
   }
   @Override
   public void setPieces(int pieces) {
      this.pieces=pieces;
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

   //***** stop
   @Override
   public int getStop() {
      return this.stop;
   }
   @Override
   public void setStop(int stop) {
      this.stop=stop;
   }

   //***** totalTime
   @Override
   public int getTotalTime() {
      return this.totalTime;
   }
   @Override
   public void setTotalTime(int totalTime) {
      this.totalTime=totalTime;
   }

   //***** volume
   @Override
   public float getVolume() {
      return this.volume;
   }

   @Override
   public void setVolume(float volume) {
      this.volume=volume;
   }
}