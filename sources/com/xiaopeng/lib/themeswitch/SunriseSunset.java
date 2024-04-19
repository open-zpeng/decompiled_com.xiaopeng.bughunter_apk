package com.xiaopeng.lib.themeswitch;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import okhttp3.internal.http.StatusLine;
/* loaded from: classes.dex */
final class SunriseSunset {
    private static final double CONST_0009 = 9.0E-4d;
    private static final double CONST_360 = 360.0d;
    private static final int JULIAN_DATE_2000_01_01 = 2451545;
    private static final long MILLISECONDS_IN_DAY = 86400000;
    public static final double SUN_ALTITUDE_ASTRONOMICAL_TWILIGHT = -18.0d;
    public static final double SUN_ALTITUDE_CIVIL_TWILIGHT = -6.0d;
    public static final double SUN_ALTITUDE_NAUTICAL_TWILIGHT = -12.0d;
    public static final double SUN_ALTITUDE_SUNRISE_SUNSET = -0.833d;

    /* loaded from: classes.dex */
    public enum DayPeriod {
        DAY,
        CIVIL_TWILIGHT,
        NAUTICAL_TWILIGHT,
        ASTRONOMICAL_TWILIGHT,
        NIGHT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SolarEquationVariables {
        final double delta;
        final double jtransit;
        final double lambda;
        final double m;
        final double n;

        private SolarEquationVariables(double d, double d2, double d3, double d4, double d5) {
            this.n = d;
            this.m = d2;
            this.lambda = d3;
            this.jtransit = d4;
            this.delta = d5;
        }
    }

    private SunriseSunset() {
    }

    public static Calendar[] getAstronomicalTwilight(Calendar calendar, double d, double d2) {
        return getSunriseSunset(calendar, d, d2, -18.0d);
    }

    public static Calendar[] getCivilTwilight(Calendar calendar, double d, double d2) {
        return getSunriseSunset(calendar, d, d2, -6.0d);
    }

    public static long getDayLength(Calendar calendar, double d, double d2) {
        Calendar[] sunriseSunset = getSunriseSunset(calendar, d, d2);
        if (sunriseSunset == null) {
            int i = calendar.get(2);
            if (d > 0.0d) {
                if (i < 3 || i > 10) {
                    return 0L;
                }
                return MILLISECONDS_IN_DAY;
            } else if (i < 3 || i > 10) {
                return MILLISECONDS_IN_DAY;
            } else {
                return 0L;
            }
        }
        return sunriseSunset[1].getTimeInMillis() - sunriseSunset[0].getTimeInMillis();
    }

    public static DayPeriod getDayPeriod(Calendar calendar, double d, double d2) {
        if (isDay(calendar, d, d2)) {
            return DayPeriod.DAY;
        }
        if (isCivilTwilight(calendar, d, d2)) {
            return DayPeriod.CIVIL_TWILIGHT;
        }
        if (isNauticalTwilight(calendar, d, d2)) {
            return DayPeriod.NAUTICAL_TWILIGHT;
        }
        if (isAstronomicalTwilight(calendar, d, d2)) {
            return DayPeriod.ASTRONOMICAL_TWILIGHT;
        }
        if (isNight(calendar, d, d2)) {
            return DayPeriod.NIGHT;
        }
        return DayPeriod.NIGHT;
    }

    public static Calendar getGregorianDate(double d) {
        double d2 = d + 0.5d;
        int i = (int) d2;
        int i2 = i + 32044;
        int i3 = i2 / 146097;
        int i4 = i2 % 146097;
        int i5 = (((i4 / 36524) + 1) * 3) / 4;
        int i6 = i4 - (36524 * i5);
        int i7 = i6 / 1461;
        int i8 = i6 % 1461;
        int i9 = (((i8 / 365) + 1) * 3) / 4;
        int i10 = i8 - (i9 * 365);
        int i11 = (i3 * 400) + (i5 * 100) + (i7 * 4) + i9;
        int i12 = (((i10 * 5) + StatusLine.HTTP_PERM_REDIRECT) / 153) - 2;
        int i13 = i12 + 2;
        double d3 = (d2 - i) * 24.0d;
        int i14 = (int) d3;
        int i15 = (int) ((d3 - i14) * 60.0d);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(1, (i11 - 4800) + (i13 / 12));
        calendar.set(2, i13 % 12);
        calendar.set(5, (i10 - (((i12 + 4) * 153) / 5)) + 122 + 1);
        calendar.set(11, i14);
        calendar.set(12, i15);
        calendar.set(13, (int) (((d3 * 3600.0d) - ((i14 * 3600) + (i15 * 60))) + 0.5d));
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        return calendar2;
    }

    public static double getJulianDate(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        int i = calendar2.get(1);
        int i2 = calendar2.get(2) + 1;
        int i3 = (14 - i2) / 12;
        int i4 = (i + 4800) - i3;
        return ((((((calendar2.get(5) + (((((i2 + (i3 * 12)) - 3) * 153) + 2) / 5)) + (i4 * 365)) + (i4 / 4)) - (i4 / 100)) + (i4 / 400)) - 32045) + ((calendar2.get(11) - 12.0d) / 24.0d) + (calendar2.get(12) / 1440.0d) + (calendar2.get(13) / 86400.0d);
    }

    public static Calendar[] getNauticalTwilight(Calendar calendar, double d, double d2) {
        return getSunriseSunset(calendar, d, d2, -12.0d);
    }

    private static SolarEquationVariables getSolarEquationVariables(Calendar calendar, double d) {
        double julianDate = (getJulianDate(calendar) - 2451545.0d) - CONST_0009;
        double d2 = (-d) / CONST_360;
        double round = Math.round(julianDate - d2);
        double d3 = d2 + 2451545.0009d + round;
        double radians = Math.toRadians((((d3 - 2451545.0d) * 0.98560028d) + 357.5291d) % CONST_360);
        double radians2 = Math.toRadians((((Math.toDegrees(radians) + 102.9372d) + (((Math.sin(radians) * 1.9148d) + (Math.sin(radians * 2.0d) * 0.02d)) + (Math.sin(3.0d * radians) * 3.0E-4d))) + 180.0d) % CONST_360);
        return new SolarEquationVariables(round, radians, radians2, (d3 + (Math.sin(radians) * 0.0053d)) - (Math.sin(2.0d * radians2) * 0.0069d), Math.asin(Math.sin(radians2) * Math.sin(Math.toRadians(23.439d))));
    }

    public static Calendar getSolarNoon(Calendar calendar, double d, double d2) {
        SolarEquationVariables solarEquationVariables = getSolarEquationVariables(calendar, d2);
        double radians = Math.toRadians(d);
        if (Double.isNaN(Math.acos((Math.sin(Math.toRadians(-0.833d)) - (Math.sin(radians) * Math.sin(solarEquationVariables.delta))) / (Math.cos(radians) * Math.cos(solarEquationVariables.delta))))) {
            return null;
        }
        Calendar gregorianDate = getGregorianDate(solarEquationVariables.jtransit);
        Calendar calendar2 = Calendar.getInstance(calendar.getTimeZone());
        calendar2.setTimeInMillis(gregorianDate.getTimeInMillis());
        return calendar2;
    }

    public static Calendar[] getSunriseSunset(Calendar calendar, double d, double d2) {
        return getSunriseSunset(calendar, d, d2, -0.833d);
    }

    public static boolean isAstronomicalTwilight(double d, double d2) {
        return isAstronomicalTwilight(Calendar.getInstance(), d, d2);
    }

    public static boolean isCivilTwilight(double d, double d2) {
        return isCivilTwilight(Calendar.getInstance(), d, d2);
    }

    public static boolean isDay(double d, double d2) {
        return isDay(Calendar.getInstance(), d, d2);
    }

    public static boolean isNauticalTwilight(double d, double d2) {
        return isNauticalTwilight(Calendar.getInstance(), d, d2);
    }

    public static boolean isNight(double d, double d2) {
        return isNight(Calendar.getInstance(), d, d2);
    }

    public static boolean isTwilight(double d, double d2) {
        return isTwilight(Calendar.getInstance(), d, d2);
    }

    public static Calendar[] getSunriseSunset(Calendar calendar, double d, double d2, double d3) {
        SolarEquationVariables solarEquationVariables = getSolarEquationVariables(calendar, d2);
        double d4 = -d2;
        double radians = Math.toRadians(d);
        double acos = Math.acos((Math.sin(Math.toRadians(d3)) - (Math.sin(radians) * Math.sin(solarEquationVariables.delta))) / (Math.cos(radians) * Math.cos(solarEquationVariables.delta)));
        if (Double.isNaN(acos)) {
            return null;
        }
        double degrees = (((((Math.toDegrees(acos) + d4) / CONST_360) + solarEquationVariables.n) + (Math.sin(solarEquationVariables.m) * 0.0053d)) - (Math.sin(solarEquationVariables.lambda * 2.0d) * 0.0069d)) + 2451545.0009d;
        double d5 = solarEquationVariables.jtransit;
        Calendar gregorianDate = getGregorianDate(d5 - (degrees - d5));
        Calendar gregorianDate2 = getGregorianDate(degrees);
        Calendar calendar2 = Calendar.getInstance(calendar.getTimeZone());
        calendar2.setTimeInMillis(gregorianDate.getTimeInMillis());
        Calendar calendar3 = Calendar.getInstance(calendar.getTimeZone());
        calendar3.setTimeInMillis(gregorianDate2.getTimeInMillis());
        return new Calendar[]{calendar2, calendar3};
    }

    public static boolean isAstronomicalTwilight(Calendar calendar, double d, double d2) {
        Calendar[] astronomicalTwilight;
        Calendar[] nauticalTwilight = getNauticalTwilight(calendar, d, d2);
        if (nauticalTwilight == null || (astronomicalTwilight = getAstronomicalTwilight(calendar, d, d2)) == null) {
            return false;
        }
        return (calendar.after(nauticalTwilight[1]) && calendar.before(astronomicalTwilight[1])) || (calendar.after(astronomicalTwilight[0]) && calendar.before(nauticalTwilight[0]));
    }

    public static boolean isCivilTwilight(Calendar calendar, double d, double d2) {
        Calendar[] civilTwilight;
        Calendar[] sunriseSunset = getSunriseSunset(calendar, d, d2);
        if (sunriseSunset == null || (civilTwilight = getCivilTwilight(calendar, d, d2)) == null) {
            return false;
        }
        return (calendar.after(sunriseSunset[1]) && calendar.before(civilTwilight[1])) || (calendar.after(civilTwilight[0]) && calendar.before(sunriseSunset[0]));
    }

    public static boolean isDay(Calendar calendar, double d, double d2) {
        Calendar[] sunriseSunset = getSunriseSunset(calendar, d, d2);
        if (sunriseSunset != null) {
            return calendar.after(sunriseSunset[0]) && calendar.before(sunriseSunset[1]);
        }
        int i = calendar.get(2);
        return d > 0.0d ? i >= 3 && i <= 10 : i < 3 || i > 10;
    }

    public static boolean isNauticalTwilight(Calendar calendar, double d, double d2) {
        Calendar[] nauticalTwilight;
        Calendar[] civilTwilight = getCivilTwilight(calendar, d, d2);
        if (civilTwilight == null || (nauticalTwilight = getNauticalTwilight(calendar, d, d2)) == null) {
            return false;
        }
        return (calendar.after(civilTwilight[1]) && calendar.before(nauticalTwilight[1])) || (calendar.after(nauticalTwilight[0]) && calendar.before(civilTwilight[0]));
    }

    public static boolean isNight(Calendar calendar, double d, double d2) {
        Calendar[] astronomicalTwilight = getAstronomicalTwilight(calendar, d, d2);
        if (astronomicalTwilight == null) {
            int i = calendar.get(2);
            return d > 0.0d ? i < 3 || i > 10 : i >= 3 && i <= 10;
        }
        Calendar calendar2 = astronomicalTwilight[0];
        Calendar calendar3 = astronomicalTwilight[1];
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z").setTimeZone(calendar.getTimeZone());
        return calendar.before(calendar2) || calendar.after(calendar3);
    }

    public static boolean isTwilight(Calendar calendar, double d, double d2) {
        return isCivilTwilight(calendar, d, d2) || isNauticalTwilight(calendar, d, d2) || isAstronomicalTwilight(calendar, d, d2);
    }
}
