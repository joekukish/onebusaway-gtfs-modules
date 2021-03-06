/**
 * Copyright (C) 2011 Brian Ferris <bdferris@onebusaway.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.gtfs.model;

import org.onebusaway.csv_entities.schema.annotations.CsvField;
import org.onebusaway.csv_entities.schema.annotations.CsvFields;
import org.onebusaway.gtfs.serialization.mappings.EntityFieldMappingFactory;
import org.onebusaway.gtfs.serialization.mappings.StopTimeFieldMappingFactory;

@CsvFields(filename = "stop_times.txt")
public final class StopTime extends IdentityBean<Integer> implements
    Comparable<StopTime> {

  private static final long serialVersionUID = 1L;

  private static final int MISSING_VALUE = -999;

  @CsvField(ignore = true)
  private int id;

  @CsvField(name = "trip_id", mapping = EntityFieldMappingFactory.class)
  private Trip trip;

  @CsvField(name = "stop_id", mapping = EntityFieldMappingFactory.class)
  private Stop stop;

  @CsvField(optional = true, mapping = StopTimeFieldMappingFactory.class)
  private int arrivalTime = MISSING_VALUE;

  @CsvField(optional = true, mapping = StopTimeFieldMappingFactory.class)
  private int departureTime = MISSING_VALUE;

  private int stopSequence;

  @CsvField(optional = true)
  private String stopHeadsign;

  @CsvField(optional = true)
  private String routeShortName;

  @CsvField(optional = true, defaultValue = "0")
  private int pickupType;

  @CsvField(optional = true, defaultValue = "0")
  private int dropOffType;

  @CsvField(optional = true)
  private double shapeDistTraveled = MISSING_VALUE;

  public StopTime() {

  }

  public StopTime(StopTime st) {
    this.arrivalTime = st.arrivalTime;
    this.departureTime = st.departureTime;
    this.dropOffType = st.dropOffType;
    this.id = st.id;
    this.pickupType = st.pickupType;
    this.routeShortName = st.routeShortName;
    this.shapeDistTraveled = st.shapeDistTraveled;
    this.stop = st.stop;
    this.stopHeadsign = st.stopHeadsign;
    this.stopSequence = st.stopSequence;
    this.trip = st.trip;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
  }

  public int getStopSequence() {
    return stopSequence;
  }

  public void setStopSequence(int stopSequence) {
    this.stopSequence = stopSequence;
  }

  public Stop getStop() {
    return stop;
  }

  public void setStop(Stop stop) {
    this.stop = stop;
  }

  public boolean isArrivalTimeSet() {
    return arrivalTime != MISSING_VALUE;
  }

  /**
   * @return arrival time, in seconds since midnight
   */
  public int getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public void clearArrivalTime() {
    this.arrivalTime = MISSING_VALUE;
  }

  public boolean isDepartureTimeSet() {
    return departureTime != MISSING_VALUE;
  }

  /**
   * @return departure time, in seconds since midnight
   */
  public int getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(int departureTime) {
    this.departureTime = departureTime;
  }

  public void clearDepartureTime() {
    this.departureTime = MISSING_VALUE;
  }

  public String getStopHeadsign() {
    return stopHeadsign;
  }

  public void setStopHeadsign(String headSign) {
    this.stopHeadsign = headSign;
  }

  public String getRouteShortName() {
    return routeShortName;
  }

  public void setRouteShortName(String routeShortName) {
    this.routeShortName = routeShortName;
  }

  public int getPickupType() {
    return pickupType;
  }

  public void setPickupType(int pickupType) {
    this.pickupType = pickupType;
  }

  public int getDropOffType() {
    return dropOffType;
  }

  public void setDropOffType(int dropOffType) {
    this.dropOffType = dropOffType;
  }

  public boolean isShapeDistTraveledSet() {
    return shapeDistTraveled != MISSING_VALUE;
  }

  public double getShapeDistTraveled() {
    return shapeDistTraveled;
  }

  public void setShapeDistTraveled(double shapeDistTraveled) {
    this.shapeDistTraveled = shapeDistTraveled;
  }

  public void clearShapeDistTraveled() {
    this.shapeDistTraveled = MISSING_VALUE;
  }

  public int compareTo(StopTime o) {
    return this.stopSequence - o.stopSequence;
  }

  @Override
  public String toString() {
    return "StopTime(seq=" + stopSequence + " stop=" + stop.getId() + " trip="
        + trip.getId() + " times="
        + StopTimeFieldMappingFactory.getSecondsAsString(arrivalTime) + "-"
        + StopTimeFieldMappingFactory.getSecondsAsString(departureTime) + ")";
  }
}
