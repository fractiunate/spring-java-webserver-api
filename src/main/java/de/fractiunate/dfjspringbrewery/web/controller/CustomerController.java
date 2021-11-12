package de.fractiunate.dfjspringbrewery.web.controller;

import de.fractiunate.dfjspringbrewery.web.services.CustomerService;
import de.fractiunate.dfjspringbrewery.web.services.CustomerService.ResourceNotFoundException;
import de.fractiunate.dfjspringbrewery.web.model.CustomerDto;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }


  @GetMapping({"/all"})
  public ResponseEntity<List<CustomerDto>> listCustomers() {
    return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
  }

  @GetMapping({"/{customerId}"})
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
    try {
      return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    } catch (CustomerService.ResourceNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }


  @PostMapping
  public ResponseEntity registerNewCustomer(@RequestBody CustomerDto customer) {
    CustomerDto savedCustomer = customerService.registerNewCustomer(customer);
    HttpHeaders header = new HttpHeaders();
    header.add("Location", "/api/v1/customer/" + savedCustomer.getCustomerUuid());
    System.out.println(savedCustomer);
    return new ResponseEntity(header, HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{customerId}")
  public void updateCustomerData(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto){
    try {
      customerService.updateCustomerData(customerId, customerDto);
    } catch (ResourceNotFoundException e) {
      e.printStackTrace();
    }
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{customerId}")
  public void deleteCustomer(@PathVariable UUID customerId){
    boolean deleted = customerService.deleteCustomerById(customerId);
  }


}
