package pard.assignment4.entity.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pard.assignment4.entity.item.Item;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;
    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Item> registedItems = new ArrayList<>();

    @Builder
    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void update(String name, String address) {
        if (name != null) {
            this.name = name;
        }

        if (address != null) {
            this.address = address;
        }
    }
}
