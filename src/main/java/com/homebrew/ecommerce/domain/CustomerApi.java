package com.homebrew.ecommerce.domain;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record CustomerApi(
        @NonNull
        String firstName,
        @NonNull
        String lastName,
        @NonNull
        String ssn,
        @NonNull
        AddressApi addressApi
) {
}
