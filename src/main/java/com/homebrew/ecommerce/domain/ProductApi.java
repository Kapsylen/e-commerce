package com.homebrew.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductApi(
        String id,
        String name,
        String brand,
        Integer quantity
) {
}
