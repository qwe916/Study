package com.example.spring.transactional.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    int id;
    int money;

    public Account() {
    }

    public Account(int id, int money) {
        this.id = id;
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;

        if (id != account.id) return false;
        return money == account.money;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + money;
        return result;
    }
}
