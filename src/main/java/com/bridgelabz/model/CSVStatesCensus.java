package com.bridgelabz.model;

import com.opencsv.bean.CsvBindByName;

public class CSVStatesCensus {

    //BINDING THE COLUMN NAME IN CsvBindByName CLASS
    @CsvBindByName(column = "State", required = true)
    public static String state;

    @CsvBindByName(column = "Population", required = true)
    public long Population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public long AreaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public int DensityPerSqkm;

    public CSVStatesCensus(long population, long areaInSqKm, int densityPerSqkm) {
        Population = population;
        AreaInSqKm = areaInSqKm;
        DensityPerSqkm = densityPerSqkm;
    }

    @Override
    public String toString() {
        return "CSVStatesCensus{" +
                "Population=" + Population +
                ", AreaInSqKm=" + AreaInSqKm +
                ", DensityPerSqkm=" + DensityPerSqkm +
                '}';
    }
}
