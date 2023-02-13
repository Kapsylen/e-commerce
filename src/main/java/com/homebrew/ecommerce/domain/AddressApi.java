package com.homebrew.ecommerce.domain;

import lombok.Builder;

@Builder
public record AddressApi(
        String street,
        Integer number,
        String city,
        Integer zipCode
) {
}
