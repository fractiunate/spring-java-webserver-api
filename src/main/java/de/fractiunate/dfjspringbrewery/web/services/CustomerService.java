package de.fractiunate.dfjspringbrewery.web.services;

import de.fractiunate.dfjspringbrewery.web.model.CustomerDto;
import java.util.List;
import java.util.UUID;

public interface CustomerService {

  CustomerDto getCustomerById(UUID customerId) throws CustomerService.ResourceNotFoundException;

  CustomerDto registerNewCustomer(CustomerDto customer);

  void updateCustomerData(UUID customerId, CustomerDto customerDto) throws ResourceNotFoundException;

  boolean deleteCustomerById(UUID customerId);

  List<CustomerDto> getAllCustomers();

  public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String errorMessage) {
      super(errorMessage);
    }
  }
}
