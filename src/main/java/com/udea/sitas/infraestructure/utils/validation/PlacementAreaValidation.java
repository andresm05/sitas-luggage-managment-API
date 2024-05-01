package com.udea.sitas.infraestructure.utils.validation;

public class PlacementAreaValidation {

    /* Measurements are shown in centimeters */
    private static final double MAX_HEIGHT_AREA1 = 45;
    private static final double MAX_LENGTH_AREA1 = 35;
    private static final double MAX_WIDTH_AREA1 = 20;
    private static final double MAX_HEIGHT_AREA2 = 90;
    private static final double MAX_LENGTH_AREA2 = 70;
    private static final double MAX_WIDTH_AREA2 = 140;
    private static final double MAX_HEIGHT_AREA3 = 55;
    private static final double MAX_LENGTH_AREA3 = 35;
    private static final double MAX_WIDTH_AREA3 = 25;

    public static boolean validateMeasurements(double height, double length, double width, Long placement_area_id) {
        if (placement_area_id == 1) {
            return height <= MAX_HEIGHT_AREA1 && length <= MAX_LENGTH_AREA1 && width <= MAX_WIDTH_AREA1;
        } else if (placement_area_id == 2) {
            return height <= MAX_HEIGHT_AREA2 && length <= MAX_LENGTH_AREA2 && width <= MAX_WIDTH_AREA2;
        }

        return height <= MAX_HEIGHT_AREA3 && length <= MAX_LENGTH_AREA3 && width <= MAX_WIDTH_AREA3;

    }

    public static String getMeasurements(Long placement_area_id) {
        if (placement_area_id == 1) {
            return "Alto: " + MAX_HEIGHT_AREA1 + " cm, Largo: " + MAX_LENGTH_AREA1 + " cm, Ancho: " + MAX_WIDTH_AREA1
                    + " cm";
        } else if (placement_area_id == 2) {
            return "Alto: " + MAX_HEIGHT_AREA2 + " cm, Largo: " + MAX_LENGTH_AREA2 + " cm, Ancho: " + MAX_WIDTH_AREA2
                    + " cm";
        }

        return "Alto: " + MAX_HEIGHT_AREA3 + " cm, Largo: " + MAX_LENGTH_AREA3 + " cm, Ancho: " + MAX_WIDTH_AREA3
                + " cm";
    }

}
