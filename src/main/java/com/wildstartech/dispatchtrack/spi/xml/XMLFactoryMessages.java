package com.wildstartech.dispatchtrack.spi.xml;

import java.util.ListResourceBundle;

public class XMLFactoryMessages extends ListResourceBundle {
   public static final String ERR_XML_STREAM_READER_NULL=
      "ERR_XML_STREAM_READER_NULL";
   
   @Override
   protected Object[][] getContents() {
      return new Object[][] {
         {ERR_XML_STREAM_READER_NULL,"The XMLStreamReader passed as a parameter is NULL."}
      };
   }
}