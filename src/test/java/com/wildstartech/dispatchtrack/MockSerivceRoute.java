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
import java.util.logging.Logger;

public class MockSerivceRoute implements ServiceRoute {
   private static final String _CLASS=MockSerivceRoute.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   private Date actualEndTime=null;
   private Date actualStartTime=null;
   private Date estimatedEndTime=null;
   private Date estimatedStartTime=null;
   private int actualTime=0;
   private float amount=0f;
   private float amountDelivered=0f;
   private float volume=0f;
   private int driverNumber=0;
   private int miles=0;
   private int pieces=0;
   private int stop=0;
   private int totalTime=0;
   private String driverName="";
   private String login="";
   private String serviceUnit="";
   
   /**
    * Default, no-argument constructor.
    */
   public MockSerivceRoute() {
      logger.entering(_CLASS, "MockServiceRoute()");
      logger.exiting(_CLASS, "MockServiceRoute()");
   }
   
   // ***** actualEndTime
   @Override
   public Date getActualEndTime() {
      logger.entering(_CLASS, "getActualEndTime()");
      logger.exiting(_CLASS, "getActualEndTime()",this.actualEndTime);
      return this.actualEndTime;
   }
   @Override
   public void setActualEndTime(Date endTime) {
      logger.entering(_CLASS, "getActualEndTime(Date)",endTime);
      this.actualEndTime=endTime;
      logger.exiting(_CLASS, "getActualEndTime(Date)");
   }

   // ***** actualStartTime
   @Override
   public Date getActualStartTime() {
      logger.entering(_CLASS, "getActualStartTime()");
      logger.exiting(_CLASS, "getActualStartTime()",this.actualStartTime);
      return this.actualStartTime;
   }

   @Override
   public void setActualStartTime(Date startTime) {
      logger.entering(_CLASS, "setActualStartTime(Date)",startTime);
      this.actualStartTime=startTime;
      logger.exiting(_CLASS, "setActualStartTime(Date)");
   }

   // ***** actualTime
   @Override
   public int getActualTime() {
      logger.entering(_CLASS, "getActualTime()");
      logger.exiting(_CLASS, "getActualTime()",this.actualTime);
      return this.actualTime;
   }

   @Override
   public void setActualTime(int actualTime) {
      logger.entering(_CLASS, "setActualTime(int)",actualTime);
      this.actualTime=actualTime;
      logger.exiting(_CLASS, "setActualTime(int)");
   }

   // ***** amount
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

   // ***** amountDelivered
   @Override
   public float getAmountDelivered() {
      logger.entering(_CLASS, "getAmountDelivered()");
      logger.exiting(_CLASS, "getAmountDelivered()",this.amountDelivered);
      return this.amountDelivered;
   }

   @Override
   public void setAmountDelivered(float amountDelivered) {
      logger.entering(_CLASS, "setAmountDelivered(float)",amountDelivered);
      this.amountDelivered=amountDelivered;
      logger.exiting(_CLASS, "setAmountDelivered(float)");
   }

   // ***** driverName
   @Override
   public String getDriverName() {
      logger.entering(_CLASS, "getDriverName()");
      logger.exiting(_CLASS, "getDriverName()",this.driverName);
      return this.driverName;
   }

   @Override
   public void setDriverName(String driverName) {
      logger.entering(_CLASS, "setDriverName(float)",driverName);
      this.driverName=driverName;
      logger.exiting(_CLASS, "setDriverName(float)");
   }

   // ***** driverNumber
   @Override
   public int getDriverNumber() {
      logger.entering(_CLASS, "getDriverNumber()");
      logger.exiting(_CLASS, "getDriverNumber()",this.driverNumber);
      return this.driverNumber;
   }
   @Override
   public void setDriverNumber(int driverNumber) {
      logger.entering(_CLASS, "setDriverNumber(int)",driverNumber);
      this.driverNumber=driverNumber;
      logger.exiting(_CLASS, "setDriverNumber(int)");
   }

   // ***** estimatedEndTime
   @Override
   public Date getEstimatedEndTime() {
      logger.entering(_CLASS, "getEstimatedEndTime()");
      logger.exiting(_CLASS, "getEstimatedEndTime()",this.estimatedEndTime);
      return this.estimatedEndTime;
   }

   @Override
   public void setEstimatedEndTime(Date endTime) {
      logger.entering(_CLASS, "setEstimatedEndTime(Date)",endTime);
      this.estimatedEndTime=endTime;
      logger.exiting(_CLASS, "setEstimatedEndTime(Date)");
   }

   // ***** estimatedStartTime
   @Override
   public Date getEstimatedStartTime() {
      logger.entering(_CLASS, "getEstimatedStartTime()");
      logger.exiting(_CLASS, "getEstimatedStartTime()",
            this.estimatedStartTime);
      return this.estimatedStartTime;
   }

   @Override
   public void setEstimatedStartTime(Date startTime) {
      logger.entering(_CLASS, "setEstimatedStartTime(Date)",startTime);
      this.estimatedStartTime=startTime;
      logger.exiting(_CLASS, "setEstimatedStartTime(Date)");
   }

   // ***** login
   @Override
   public String getLogin() {
      logger.entering(_CLASS, "getLogin()");
      logger.exiting(_CLASS, "getLogin()",this.login);
      return this.login;
   }

   @Override
   public void setLogin(String login) {
      logger.entering(_CLASS, "setLogin(String)",login);
      this.login=login;
      logger.exiting(_CLASS, "setLogin(String)");
   }

   // ***** miles
   @Override
   public int getMiles() {
      logger.entering(_CLASS, "getMiles()");
      logger.exiting(_CLASS, "getMiles()",this.miles);
      return this.miles;
   }

   @Override
   public void setMiles(int miles) {
      logger.entering(_CLASS, "setMiles(int)",miles);
      this.miles=miles;
      logger.exiting(_CLASS, "setMiles(int)");
   }

   // ***** pieces
   @Override
   public int getPieces() {
      logger.entering(_CLASS, "getPieces()");
      logger.exiting(_CLASS, "getPieces()",this.pieces);
      return this.pieces;
   }

   @Override
   public void setPieces(int pieces) {
      logger.entering(_CLASS, "setPieces(int)",pieces);
      this.pieces=pieces;
      logger.exiting(_CLASS, "setPieces(int)");
   }
   
   // ***** serviceUnit
   @Override
   public String getServiceUnit() {
      logger.entering(_CLASS, "getServiceUnit()");
      logger.exiting(_CLASS, "getServiceUnit()",this.serviceUnit);
      return this.serviceUnit;
   }

   @Override
   public void setServiceUnit(String name) {
      logger.entering(_CLASS, "setServiceUnit(String)",name);
      this.serviceUnit=name;
      logger.exiting(_CLASS, "setServiceUnit(String)");
   }

   // ***** stop
   @Override
   public int getStop() {
      logger.entering(_CLASS, "getStop()");
      logger.exiting(_CLASS, "getStop()",this.stop);
      return this.stop;
   }

   @Override
   public void setStop(int lastStop) {
      logger.entering(_CLASS, "setStop(int)",lastStop);
      this.stop=lastStop;
      logger.exiting(_CLASS, "setStop(int)");
   }

   // ***** totalTime
   @Override
   public int getTotalTime() {
      logger.entering(_CLASS, "getTotalTime()");
      logger.exiting(_CLASS, "getTotalTime()",this.totalTime);
      return this.totalTime;
   }

   @Override
   public void setTotalTime(int totalTime) {
      logger.entering(_CLASS, "setTotalTime(int)",totalTime);
      this.totalTime=totalTime;
      logger.exiting(_CLASS, "setTotalTime(int)");
   }

   @Override
   public float getVolume() {
      logger.entering(_CLASS, "getVolume()");
      logger.exiting(_CLASS, "getVolume()",this.volume);
      return this.volume;
   }

   @Override
   public void setVolume(float volume) {
      logger.entering(_CLASS, "setVolume(float)",volume);
      this.volume=volume;
      logger.exiting(_CLASS, "setVolume(float)");
   }
}