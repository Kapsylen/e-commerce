package com.homebrew.ecommerce.domain;

import lombok.Builder;

@Builder
public record CustomerApi(
        String firstName,
        String lastName,
        String ssn
) {}