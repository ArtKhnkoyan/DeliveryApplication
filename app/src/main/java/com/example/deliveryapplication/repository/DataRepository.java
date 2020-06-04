package com.example.deliveryapplication.repository;


import com.example.deliveryapplication.model.Address;
import com.example.deliveryapplication.model.Delivery;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataRepository {

    public List<Delivery> getMockDeliveryData() {
        return Arrays.asList(

                Delivery.builder().address(Address.builder().address("14 Abovyan St, Yerevan 0001").longitude(40.1813219).latitude(44.5163057).placeCategory("hotel").build()).orderNumber(101).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("1 Amiryan St, Yerevan 0010").longitude(40.1777383).latitude(44.5115989).placeCategory("hotel").build()).orderNumber(102).deliveryTimes("10:00-12:30").estimateTime("11:15").build(),
                Delivery.builder().address(Address.builder().address("Myasnikyan side Street, Yerevan 0100").longitude(40.20103).latitude(44.55384).placeCategory("hotel").build()).orderNumber(103).deliveryTimes("09:00-09:30").estimateTime("09:45").build(),
                Delivery.builder().address(Address.builder().address("18/5 Myasnikyan Ave, Yerevan").longitude(40.19365).latitude(44.53324).placeCategory("hotel").build()).orderNumber(103).deliveryTimes("11:00-12:15").estimateTime("11:15").build(),
                Delivery.builder().address(Address.builder().address("5 Mesrop Mashtots Ave, Yerevan 0015").longitude(40.1784326).latitude(44.5042227).placeCategory("hotel").build()).orderNumber(103).deliveryTimes("12:05-15:30").estimateTime("13:50").build(),
                Delivery.builder().address(Address.builder().address("Floor 6, 19 Kievyan St, Yerevan 0033").longitude(40.19761).latitude(44.49208).placeCategory("office").build()).orderNumber(103).deliveryTimes("14:00-17:30").estimateTime("17:15").build(),
                Delivery.builder().address(Address.builder().address("3/8 Vazgen Sargsyan St, Yerevan 0010").longitude(40.1767792).latitude(40.1767792).placeCategory("office").build()).orderNumber(103).deliveryTimes("15:15-15:45").estimateTime("15:50").build(),
                Delivery.builder().address(Address.builder().address("1 Argishti St, Yerevan 0015").longitude(40.174333).latitude(44.5034287).placeCategory("office").build()).orderNumber(103).deliveryTimes("15:55-17:05").estimateTime("16:15").build(),
                Delivery.builder().address(Address.builder().address("14 Petros Adamyan St, Yerevan 0010").longitude(40.1757283).latitude(44.511825).placeCategory("office").build()).orderNumber(103).deliveryTimes("17:45-18:30").estimateTime("18:15").build(),
                Delivery.builder().address(Address.builder().address("Mher Mkrtchyan St, Yerevan").longitude(40.15561).latitude(44.48891).placeCategory("office").build()).orderNumber(103).deliveryTimes("18:45-19:45").estimateTime("19:15").build(),
                Delivery.builder().address(Address.builder().address("21 Paronyan St, Yerevan 0015").longitude(40.1838403).latitude(44.49895549211955).placeCategory("medical services").build()).orderNumber(103).deliveryTimes("19:30-20:30").estimateTime("19:50").build(),
                Delivery.builder().address(Address.builder().address("15a Mesrop Mashtots Ave, Yerevan 0002").longitude(40.1823412).latitude(44.5080399).placeCategory("medical services").build()).orderNumber(103).deliveryTimes("20:40-21:10").estimateTime("21:15").build(),
                Delivery.builder().address(Address.builder().address("17 Tigran Mets Ave, Yerevan 0010").longitude(40.16841).latitude(44.51283).placeCategory("medical services").build()).orderNumber(103).deliveryTimes("21:30-22:10").estimateTime("21:45").build(),
                Delivery.builder().address(Address.builder().address("6 Margaryan St, Yerevan 0078").longitude(40.2046865).latitude(44.471392).placeCategory("medical services").build()).orderNumber(103).deliveryTimes("22:15-22:45").estimateTime("22:46").build(),
                Delivery.builder().address(Address.builder().address("11, 2 Sayat-Nova Ave, Yerevan").longitude(40.18499).latitude(44.51769).placeCategory("medical services").build()).orderNumber(103).deliveryTimes("22:55-23:35").estimateTime("22:25").build(),
                Delivery.builder().address(Address.builder().address("37 Mesrop Mashtots Ave, Yerevan 0002").longitude(40.1860177).latitude(44.5133313).placeCategory("apartment").build()).orderNumber(103).deliveryTimes("23:40-00:30").estimateTime("00:00").build(),
                Delivery.builder().address(Address.builder().address("19 Aghayan St, Yerevan 0002").longitude(40.1861134).latitude(44.5191352).placeCategory("apartment").build()).orderNumber(103).deliveryTimes("01:05-02:15").estimateTime("01:47").build(),
                Delivery.builder().address(Address.builder().address("0002 Mesrop Mashtots Ave, Yerevan").longitude(40.1861397).latitude(44.514024).placeCategory("apartment").build()).orderNumber(103).deliveryTimes("02:35-03:30").estimateTime("02:55").build(),
                Delivery.builder().address(Address.builder().address("13a Mesrop Mashtots Ave, Yerevan 0002").longitude(40.1850613).latitude(44.5125555).placeCategory("apartment").build()).orderNumber(103).deliveryTimes("03:35-04:30").estimateTime("03:15").build(),
                Delivery.builder().address(Address.builder().address("28 Charents Street, Yerevan 0025").longitude(40.1794354).latitude(44.5273632).placeCategory("apartment").build()).orderNumber(103).deliveryTimes("05:05-05:50").estimateTime("05:35").build()
        );
    }

    public List<Address> getMockAddressMockData() {
        return getMockDeliveryData().stream().map(delivery -> Address.builder().address(delivery.getAddress().getAddress()).longitude(delivery.getAddress().getLongitude()).latitude(delivery.getAddress().getLatitude()).placeCategory(delivery.getAddress().getPlaceCategory()).build()).collect(Collectors.toList());
    }
}
