package com.windrift.common.util;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by gary on 4/06/14.
 */
public class DateUtil {

    public static String getDurationInYearToNow(Date from) {
        return DurationFormatUtils.formatPeriod(from.getTime(), System.currentTimeMillis(), "y");
    }
}
