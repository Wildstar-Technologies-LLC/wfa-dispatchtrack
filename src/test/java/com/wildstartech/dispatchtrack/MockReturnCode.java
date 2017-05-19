package com.wildstartech.dispatchtrack;

public class MockReturnCode implements ReturnCode {
   private String code="";
   private String source="";
   
   /** 
    * Default, no-argument constructor.
    */
   public MockReturnCode() {
      
   }
   
   //***** code
   @Override
   public String getCode() {
      return this.code;
   }
   @Override
   public void setCode(String code) {
      this.code=code;
   }

   //***** source
   @Override
   public String getSource() {
      return this.source;
   }
   @Override
   public void setSource(String source) {
      this.source=source;      
   }
}