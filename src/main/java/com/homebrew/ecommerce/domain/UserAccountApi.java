package com.homebrew.ecommerce.domain;

import lombok.Builder;

@Builder
public record UserAccountApi(
        String userId,
        CustomerApi customerApi,
        String email,
        String password
) {
}
