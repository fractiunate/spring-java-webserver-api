package de.fractiunate.dfjspringbrewery.web.services;

import de.fractiunate.dfjspringbrewery.web.model.CustomerDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

  private final List<CustomerDto> customers = new ArrayList<CustomerDto>(Arrays.asList(
      new CustomerDto(UUID.fromString("f8e03ae2-9b72-47e2-98d2-4a6a2470da45"), "Unit Test"),
      new CustomerDto(UUID.randomUUID(), "David"),
      new CustomerDto(UUID.randomUUID(), "Simon Schmidde"),
      new CustomerDto(UUID.randomUUID(), "Mama Simone"),
      new CustomerDto(UUID.randomUUID(), "Jonas Bro")
  ));

  @Override
  public CustomerDto getCustomerById(UUID customerId) throws ResourceNotFoundException {
//        return CustomerDto.builder().customerUuid(UUID.randomUUID()).customerName("David Dedicated").build();
    return Optional.of(customers.stream()
                                .filter(customer -> customer.getCustomerUuid().compareTo(customerId) == 0)
                                .findAny()).get().orElseThrow(() -> new ResourceNotFoundException(""));

  }

  @Override
  public CustomerDto registerNewCustomer(CustomerDto customer) {
    CustomerDto savedCustomer = new CustomerDto()
        .builder()
        .customerName(customer.getCustomerName())
        .customerUuid(UUID.randomUUID())
        .build();

    customers.add(savedCustomer);
    return savedCustomer;

  }

  @Override
  public void updateCustomerData(UUID customerId, CustomerDto customerDto) throws ResourceNotFoundException {
    Optional<CustomerDto> savedCustomer = customers.stream().filter(customer -> customer.getCustomerUuid().compareTo(customerId) == 0).findAny();
    if (savedCustomer.isPresent()) {
      customerDto.setCustomerUuid(customerId);
      customers.set(customers.indexOf(savedCustomer.get()), customerDto);
    }
//    update props
//    save new DTO with UUID of customer
  }

  @Override
  public boolean deleteCustomerById(UUID customerId) {
    return customers.removeIf(obj -> obj.getCustomerUuid() == customerId);
  }

  @Override
  public List<CustomerDto> getAllCustomers() {
    return (customers == null || customers.isEmpty()) ? Collections.emptyList() : customers;
  }

  private void doNothing() {
    System.out.println("nope, nothing to see");
  }

}
