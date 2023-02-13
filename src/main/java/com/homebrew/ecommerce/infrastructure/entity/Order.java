package com.homebrew.ecommerce.infrastructure.entity;

import com.homebrew.ecommerce.domain.ShoppingCart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity(name = "orders")
public class Order {
    @Id
    private String id;
    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @UpdateTimestamp
    private LocalDateTime updatedDateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_id", referencedColumnName = "id")
    private UserAccount userAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
    private ShoppingCart shoppingCart;

    public Order(String id, LocalDateTime createdDateTime, LocalDateTime updatedDateTime, UserAccount userAccount, ShoppingCart shoppingCart) {
        this.id = id;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
        this.userAccount = userAccount;
        this.shoppingCart = shoppingCart;
    }
}
