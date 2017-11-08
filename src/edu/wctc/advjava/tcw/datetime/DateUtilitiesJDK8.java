package edu.wctc.advjava.tcw.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


/**
 * A utility class that represents commonly used Date/Time methods for the
 * JDK 8 API.
 * <br>
 * @author cainebourne
 * @version 1.00
 * @since 1.8
 * 
 */
public class DateUtilitiesJDK8 {

 /**
     * Format a LocalDateTime object to a month/day/year hour:minute 
     * format (mm/dd/yyyy HH:mm)<br>
     *
     * @param date a LocalDateTimeobject
     * @return a date formatted to month/day/year hour:minute (mm/dd/yyyy HH:mm)
     * @throws IllegalArgumentException if date is null
     */
    public final String localDateTimeToString(LocalDateTime date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        return date.format(formatter);
    }

    /**
     * Format a LocalDateTime object according to a specified format.
     * For example, you can put a LocalDateTime object in the format
     * of 'yyyy/MM/dd' or 'HH:mm' or 'MM-dd HH:mm', etc...<br>
     *
     * @param date a LocalDateTime object
     * @param specifiedDateTime a String with the specified date and time pattern
     * @return a date and/or time format according to the specified pattern
     * @throws IllegalArgumentException if pattern is not recognized and/or date
     * is null
     */
    public final String localDateTimeToString(LocalDateTime date, String specifiedDateTime) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(specifiedDateTime);
        return date.format(formatter);
    }

    /**
     * Attempts to convert a String representation of a date and time to a
     * LocalDateTime object. Conversion rules are based on parse
     * definitions in the java.​time.​format.​DateTimeFormatter class.<br>
     * <br>
     * There are 2 acceptable formats:<br>
     * <ul>
     * <li>yyyy-MM-ddTHH:mm</li>
     * <li>yyyy-MM-ddTHH:mm:ss</li>
     * </ul>
     *
     * @param stringDate a string representation of a date
     * @return a LocalDateTime object
     * @throws IllegalArgumentException if the date string cannot be parsed
     * and/or if the string object is null or empty.
     */
    public final LocalDateTime stringToLocalDateTime(String stringDate) throws IllegalArgumentException {
        if (stringDate == null || stringDate.isEmpty()) {
            throw new IllegalArgumentException("Cannot be null or empty");
        }

        LocalDateTime date = LocalDateTime.parse(stringDate);
        return date;
    }
    

     /**
     * Attempts to convert a String representation of a date and time to a
     * LocalDateTime object by any pattern specified. 
     * Conversion rules are based on parse definitions in the 
     * java.​time.​format.​DateTimeFormatter class.
     *
     * @param stringDate a string representation of a date and time
     * @param specifiedDateTime a String with the specified date and time pattern
     * @return a LocalDateTime object
     * @throws IllegalArgumentException if the date string cannot be parsed
     * and/or if the string object is null or empty.
     */
    public final LocalDateTime stringToLocalDateTime(String stringDate, String specifiedDateTime) throws IllegalArgumentException {
        if (stringDate == null || stringDate.isEmpty()) {
            throw new IllegalArgumentException("Cannot be null or empty");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(specifiedDateTime);
        LocalDateTime date = LocalDateTime.parse(stringDate, formatter);

        return date;
    }

     /**
     * Attempts to perform a calculation between two LocalDateTime objects by
     * using a specified ChronoUnit and returns a long object.<br>
     * <br>
     * all other values will throw an exception. calculation will take endDate and
     * subtract startDate to return long value.<br>
     * @param beginDate the starting LocalDateTime object for calculation
     * @param endDate the ending LocalDateTime object for calculation
     * @param unit must be a supported ChronoUnit from list above
     * @return a long object
     * @throws IllegalArgumentException if any objects are null.
     */
    public final long getLocalDateTimeDiff(LocalDateTime beginDate, LocalDateTime endDate, ChronoUnit unit)
    throws IllegalArgumentException{
        if (beginDate == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        else if (endDate == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        else if (unit == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        
        long tempDateDiff = unit.between(beginDate, endDate);
        return tempDateDiff;
    }
    
}
