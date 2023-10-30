package com.example.bookshopapi.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@NoArgsConstructor
public class ConvetDateTimeUTC {
    public String convertDateTimeUTC(Date dateTimeString){
        SimpleDateFormat sdfGMT7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        sdfGMT7.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        return sdfGMT7.format(dateTimeString);
    }
}

//        DateTimeFormatter formatter=DateTimeFormatter.ISO_OFFSET_DATE_TIME;
//        OffsetDateTime dateTime=OffsetDateTime.parse(dateTimeString, formatter);
//        ZoneId zoneIdPlus7 = ZoneId.of("GMT+7");
//        return dateTime.atZoneSameInstant(zoneIdPlus7).toOffsetDateTime().toString();
