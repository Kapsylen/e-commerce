package com.homebrew.ecommerce.domain;

import lombok.Builder;

@Builder
public record UserAccountApi(
        CustomerApi customerApi,
        String email,
        String password
) {
}
