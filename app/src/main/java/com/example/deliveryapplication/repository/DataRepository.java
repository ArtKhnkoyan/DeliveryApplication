package com.example.deliveryapplication.repository;


import com.example.deliveryapplication.model.Address;
import com.example.deliveryapplication.model.Delivery;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataRepository {

    public List<Delivery> getMockDeliveryData() {
        return Arrays.asList(

                Delivery.builder().address(Address.builder().address("16 A Arshakunyats Ave, Yerevan, Armenia").longitude(40.168636).latitude(44.506729).build()).orderNumber(100).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("9 Argishti St, Yerevan 0015, Armenia").longitude(6644).latitude(56565).build()).orderNumber(101).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(102).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(104).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(103).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(105).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(106).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(107).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(108).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(109).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(110).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(111).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(112).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(113).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(114).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(115).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(116).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(117).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("aaaa").longitude(6644).latitude(56565).build()).orderNumber(118).deliveryTimes("08:00-09:30").estimateTime("09:15").build(),
                Delivery.builder().address(Address.builder().address("4/2 Grigor Lusavorich Street, Yerevan 0015, Armenia").longitude(40.171947).latitude(44.508363).build()).orderNumber(119).deliveryTimes("08:00-09:30").estimateTime("09:15").build()
                );
    }

    public List<Address> getMockAddressMockData() {
        return getMockDeliveryData().stream().map(delivery -> Address.builder().address(delivery.getAddress().getAddress()).longitude(delivery.getAddress().getLongitude()).latitude(delivery.getAddress().getLatitude()).build()).collect(Collectors.toList());
    }
}
