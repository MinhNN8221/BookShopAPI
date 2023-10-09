package com.example.bookshopapi.service;

import com.example.bookshopapi.entity.Receiver;
import com.example.bookshopapi.repository.ReceiverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiverService {
    @Autowired
    private ReceiverRepo receiverRepo;

    public List<Receiver> getAllReceivers(int customerId) {
        return receiverRepo.findByCustomerId(customerId);
    }

    public Receiver findById(int receiverId) {
        return receiverRepo.findById(receiverId);
    }

    public Receiver getReceiverDefault(int customerId) {
        return receiverRepo.getReceiverDefault(customerId);
    }

    public Receiver save(Receiver receiver) {
        return receiverRepo.save(receiver);
    }

    public void update(Receiver receiver) {
        Receiver receiverIsDefalut = getReceiverDefault(receiver.getCustomer().getId());
        if (receiverIsDefalut != null && !receiverIsDefalut.equals(receiver)) {
            receiverIsDefalut.setIsDefault(0);
            receiverRepo.save(receiverIsDefalut);
        }
        receiverRepo.save(receiver);
    }

    public void deleteReceiverByIdAndCustomerId(int receiverId, int customerId) {
        receiverRepo.deleteByIdAndCustomerId(receiverId, customerId);
    }
}
