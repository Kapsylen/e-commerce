package com.homebrew.ecommerce.domain;

import lombok.Builder;

@Builder
public record AddressApi(
   String street,
   int number,
   String city,
   int zipCode
) {}
