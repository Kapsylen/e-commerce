package com.homebrew.ecommerce.service;


import com.homebrew.ecommerce.domain.AddressApi;
import com.homebrew.ecommerce.infrastructure.AddressRepository;
import com.homebrew.ecommerce.util.AddressTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Override
    public AddressApi getAddress(String id) {
       return AddressTransformer.toAddressApi(addressRepository.findById(id).get());
    }

    @Override
    public void saveAddress(AddressApi addressApi) {
        addressRepository.save(AddressTransformer.toAddress(addressApi));
    }

    @Override
    public void deleteAddress(String id) {
        addressRepository.deleteById(id);
    }
}
