package com.example.deliveryapplication.presenter;

import com.example.deliveryapplication.model.Address;
import com.example.deliveryapplication.model.Delivery;
import com.example.deliveryapplication.repository.DataRepository;

import java.util.List;

public class DataPresenter {

    private DataRepository dataRepository;

    public DataPresenter() {
        this.dataRepository = new DataRepository();
    }

    public List<Delivery> getMockDeliveryData() {
        return dataRepository.getMockDeliveryData();
    }

    public List<Address> getMockAddressMockData() {
        return dataRepository.getMockAddressMockData();
    }

    public int getMockDataSize() {
        return getMockDeliveryData().size();
    }
}
