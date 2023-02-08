package com.homebrew.ecommerce.domain;

import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record OrderApi(
        LocalDateTime created,
        LocalDateTime updated
) {}
