package com.amirahmad.projects.archnoteapp2019.database;

import androidx.room.TypeConverter;

import java.util.Date;


/**
 * Created by Amirahmad Adibi.
 * ArchNoteApp2019 | Copyrights 2019-07-19.
 */
public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp == null ? null : new Date(timestamp);
    }


    @TypeConverter
    public static Long toTimestamp(Date date){
        return date == null ? null : date.getTime();
    }
}



